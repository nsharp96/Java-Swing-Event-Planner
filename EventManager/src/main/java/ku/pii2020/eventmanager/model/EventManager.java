/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.eventmanager.model;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import ku.pii2020.eventmanager.controller.Controller;
import ku.pii2020.eventmanager.view.EventCard;
import ku.pii2020.eventmanager.view.EventItemCard;
import ku.pii2020.eventmanager.view.EventViewer;

/**
 *
 * @author Natalie Sharp - K2041275
 */
public class EventManager 
{
    //Attributes
    private static List<Organiser> organisers;
    private static List<Event> events;
    private static List<EventItems> items;
    private static EventManager instance; //Instance of EventManger - Singleton
    
    //Constructor

    /**
     *
     */
    public EventManager()
    {
        EventManager.organisers = new ArrayList<>();
        EventManager.events = new ArrayList<>();
        EventManager.items = new ArrayList<>();
        
        
    }
    
    /**
     *
     * @return Instance of the EventManager. Insures only one EventManager exists.
     */
    public static EventManager getInstance()
    {
        //If there isn't a EventManager yet create one
        if (instance == null)
        {
            instance = new EventManager();
        }
        //Otherwise return the only instance that will be made
        return instance;
    }
    
    //Getter And Setter for User Attribute

    /**
     *
     * @return List of organisers in the Event Manager
     */
    public List<Organiser> getOrganisers()
    {
        return EventManager.organisers;
    }

    /**
     *
     * @param users
     * Set the List of organisers to the Event Manager
     */
    public void setOrganisers(List<Organiser> users)
    {
        EventManager.organisers = users;
    }

    /**
     *
     * @param o
     * @return The object organiser the user is trying to find.
     */
    public Organiser getOrganiser(Organiser o)
    {
        Organiser returnOrg = null;
        for (int i = 0; i<this.getOrganisers().size() ;i++)
        {
            if (this.organisers.get(i).equals(o))
            {
                returnOrg = this.organisers.get(i);
            }
        }
        return returnOrg;
    }
    
    //Method to add user

    /**
     *
     * @param user
     * @return String specifying if the user was added or not and the reason.
     */
    public String addOrganiser(Organiser user)
    {
        String result;
        //Check organiser does not already exist within the eventmanager
        if(!(this.getOrganisers().contains(user)))
                {
                    organisers.add(user);
                    EventManager.getInstance().displayLeftEventItemsAndOrganisers();
                    result = "Organiser added!";
                }
        else
        {
            result = "Organiser was not added as they already exist in the Event Manager";
        }
        return result;    
    }
    
    //Method to add event

    /**
     *
     * @param event
     * @return String specifying if the event was added or not and the reason.
     */
    public boolean addEvent(Event event)
    {
        boolean result = false;
        //Check event does not already exist within events in EM
        boolean contains = false;
        if (EventManager.getInstance().getEvents()!=null || EventManager.getInstance().getEvents().size()>0)
        {
            for (Event e: EventManager.getInstance().getEvents())
            {
                
                if (e==event)
                {
                    contains = true;
                }
            }
        }
        if (contains == true)
        {
             result=false;
        }
        else if (contains == false)
        {
            events.add(event);
            result=true;
            
        }
       
        return result;
    }
    
    //Method to delete event

    /**
     *
     * @param event
     * @return String specifying if the event was deleted or not and the reason.
     */
    public boolean deleteEvent(Event event)
    {
        //ASSUMPTION - Delete Event and the EventItems unless they exist in another event
        boolean result=false;
        //Checks event exists in eventmanager
        if(this.getEvents().contains(event))
        {
            //Retrieves all of the events event items
            List<EventItems> eventsItemsDel = new ArrayList<>();
            eventsItemsDel = event.getEventItems();
            //Remove Event from event manager
            System.out.println(events.remove(event));
            //Delete Organiser unless it already exists in another event.
            boolean orgContains = false;
            Organiser checkOrg = event.getOrganiser();
            if (EventManager.getInstance().getEvents()!=null)
            {
                for (Event e: EventManager.getInstance().getEvents())
                    {
                    if(e.getOrganiser().equals(checkOrg))
                    {
                     orgContains = true;
                    }
                }
            }
            
            if(orgContains == false)
            {
                System.out.println(EventManager.getInstance().getOrganisers().remove(checkOrg));
                
            }
            //Remove Event items from event manager unless they already exist in another event
            for (Event e: EventManager.getInstance().getEvents())
            {
                 for (EventItems i: eventsItemsDel)
                 {
                     if (e.getEventItems().contains(i))
                     {
                         //If contains item in another event remove from list to delete
                         eventsItemsDel.remove(i);
                     }
                 }
            }
            //Delete eventitems from event manager
            for (EventItems i: eventsItemsDel)
            {
                EventManager.getInstance().deleteEventItemsFromEventManager(i);
            }
  
            
        }
        return result;
    }
    
    //Method to add EventItems to EventManager

    /**
     *
     * @param items
     * @return String specifying if the event items was added to the event manager or not and the reason.
     */
    public String addEventItemsToEventManager(EventItems items)
    {
        String result = null;
        //Check EventItem doesn't already exist before adding 
        if(!(this.getEventItems().contains(items)))
        {
            this.getEventItems().add(items);
            result = "Event Item was added to the Event Manager successfully";
            EventManager.getInstance().displayLeftEventItemsAndOrganisers();
        }
        else
        {
            result = "Event Item was not added to the Event Manager as it already exists within it.";
        }
        return result;
    }
    
    //Method to delete EventItems From EventManager

    /**
     *
     * @param items
     */
    public void deleteEventItemsFromEventManager(EventItems items)
    {
        //Remove Event items from event manager unless they already exist in another event
        int countContained = 0;
        for (Event e: EventManager.getInstance().getEvents())
            {
                 for (EventItems i: EventManager.getInstance().getEvent(e).getEventItems())
                 {
                     if (i==items)
                     {
                         //If contains item in another event remove from list to delete
                         countContained += 1;
                     }
                 }
            }
        if (countContained == 0)
        {
            this.getEventItems().remove(items);
            System.out.print("Removed Item");
            
        }
        else
        {
            System.out.println("Didn't remove item");
            System.out.println(countContained);
            for (Event e:EventManager.getInstance().getEvents())
            {
                System.out.println(e.toString());
                for (EventItems ei: e.getEventItems())
                {
                    System.out.println(ei.toString());
                }
            }
        }
       
    }
    
    //Method to add Items to an event in event manager

    /**
     *
     * @param event
     * @param items
     * @return String specifying if the event items were added to the event or not.
     */
    public String addEventItemsToEvent(Event event, EventItems items)
    {
        String result = null;
        //Check event exists
        if(this.getEvents().contains(event))
        {
            //Check that event item does not exists in said event
            if ((this.getEvent(event).getEventItems()==null)||(!(this.getEvent(event).getEventItems().contains(items))))
            {
                this.getEvent(event).getEventItems().add(items);
                this.addEventItemsToEventManager(items);
                result = "The Event Item was successfully added";
            }
            else if (this.getEvent(event).getEventItems().contains(items))
            {
                    result = "The EventItem was not added as the EventItem already exists in the Event";
            }
        }
        else 
        {
            result = "The EventItem was not added to the Event as the Event does not exist.";
        }
        return result;
    }
    
    //Method to delete EventItem from an event

    /**
     *
     * @param event
     * @param items
     * @return String specifying if the event item was removed from the event.
     */
    public String deleteEventItemsFromEvent(Event event, EventItems items)
    {
        String result = null;
        //check event exists
        if(this.getEvents().contains(event))
        {
            if(!(this.getEvent(event).getEventItems().contains(items)))
            {
                result = "The EventItem could not be deleted as the EventItem does not exist";
                System.out.println("222 Was not removed from event");
            }
            else
            {
                result = "The EventItem was removed successfully";
                this.getEvent(event).getEventItems().remove(items);
                System.out.println("EventItem removed from event");
            }
            
        }
        else
        {
            result = "The EventItem could not be deleted as the event did not exist.";
            System.out.println("1111 Was not removed from event");
        }
        return result;
        
    }
    
    //Getter And Setter for Event Attribute

    /**
     *
     * @return List of events in Event Manager
     */
    public List<Event> getEvents()
    {
        return EventManager.events;
    }

    /**
     *
     * @param e
     * @return A singular event object the user is trying to find.
     */
    public Event getEvent(Event e)
    {
        Event returnEvent = null;
        if (!(this.events == null))
        {
        for (int i = 0; i<this.getEvents().size() ;i++)
        {
            if (this.events.get(i).equals(e))
            {
                returnEvent = this.events.get(i);
            }
        }
        }
        return returnEvent;
    }
    
    /**
     *
     * @param events
     * Set the List of events in Event Manager.
     */
    
    public void setEvents(List<Event> events)
    {
        EventManager.getInstance().events = events;
    }
    
    //Getter and Setter for EventItems

    /**
     *
     * @return List of EventItems in event mananger
     */
    public List<EventItems> getEventItems()
    {
        return this.items;
    }
    
    /**
     *
     * @param items
     * Set the event items in the event manager.
     */
    public void setEventItems(List<EventItems> items)
    {
        this.items = items;
    }
    
    //Method Associate a person (Organiser) with an Event

    /**
     *
     * @param event
     * @param organiser
     * @return String if the organiser was successfully associated to the event or not.
     */
    public String associateUserToEvent(Event event, Organiser organiser)
    {
        String result = null;
        //Check Event exists
        if (this.getEvents().contains(event))
        {
            //Check organiser exists
            if (this.getOrganisers().contains(organiser))
            {
                if (this.getEvent(event).getOrganiser()== null)
                {
                    this.getEvent(event).setOrganiser(organiser);
                    result = this.getEvent(event).getTitle() + " organiser is now " +this.getOrganiser(organiser).getFullName();
                } 
                else if (this.getEvent(event).getOrganiser() == organiser)
                {
                   result = "The organiser for the event is already the organiser you wish to set it to.";                
                }
                else 
                {
                    this.getEvent(event).setOrganiser(organiser);
                    result = "The previous organiser "+this.getEvent(event).getOrganiser().getFullName() + " is replaced by the new organiser "+this.getOrganiser(organiser).getFullName();
                }
            }
            else
            {
                result = "The association between the event and tghe organiser could not happen as the organiser does not exist.";
            }      
        }
        else
        {
            result = "The association between the event and the organiser could not happen as the event does not exist." ;
        }
        return result;
    }
    
    /**
     *
     * @param file
     * Takes a file and reads it and creates objects of event, organisers and event items.
     */
    public void readFile(File file)
    {
        //Try unless exception is found
        EventCard ec = null;
        try
        {
            
            String data;
            //Create BufferedReader
            BufferedReader infile = new BufferedReader(new FileReader(file));
            // Read next line of infile
            data = infile.readLine();
            while (data!=null)
            {
                //Split by commas
                String[] serp = data.split(",");
                String event = null;
                String eventItems = null;
                String organiser = null;
                Event e = null;
                
                
                //Assign strings to object type and removes formatting brackets
                event = serp[0].substring(1, serp[0].length() - 1);
                //Checks if the document part is empty
                if (event.equals("null"))
                {
                    event = null;
                }
                eventItems = serp[1].substring(1, serp[1].length() - 1);
                //Checks if the document part is empty
                if (eventItems.equals("null"))
                {
                    eventItems = null;
                }
                organiser = serp[2].substring(1, serp[2].length() - 1);
                //Checks if the document part is empty
                if (organiser.equals("null"))
                {
                    organiser = null;
                }

                //Event
                //Assign attributes
                //Checks if the document part is empty
                if (!(event == null))
                {
                   String[] eventAt = event.split("/");
                   Event newEvent = new Event();
                   newEvent.setTitle(eventAt[0]);
                   newEvent.setDate(LocalDate.parse(eventAt[1]));
                   newEvent.setTime(LocalTime.parse(eventAt[2]));
                   newEvent.setLocation(eventAt[3]);
                   EventCard newEventCard = new EventCard(newEvent);
                   //Adds to EventManager if it doesn't already exist
                   //Check if Event already exists in the EventManager
                   boolean contains = false;
                   Event ifContained = null;
                   for (int i = 0; i<EventManager.getInstance().getEvents().size();i++)
                   {
                       if (EventManager.getInstance().getEvents().get(i).getTitle().equals(newEvent.getTitle()) && EventManager.getInstance().getEvents().get(i).getDate().equals(newEvent.getDate()) && EventManager.getInstance().getEvents().get(i).getTime().equals(newEvent.getTime()) )
                       {
                           contains = true;
                       }
                   }
                   if (contains == false)
                   {
                       EventManager.getInstance().addEvent(newEvent);
                       e = EventManager.getInstance().getEvent(newEvent); 
                       EventViewer.getInstance().getRightSide().getRighttop().getCards().add(newEventCard);
                       ec = newEventCard;
                       
                   }      
                }
                
                //Checks if the document part is empty
                if (!(organiser == null))
                {
                    //Organiser
                    Organiser person = new Organiser();
                    person.setFullName(organiser);
                    //Check Organiser exists
                    boolean checker = false;
                    for (int i = 0; i<EventManager.getInstance().getOrganisers().size();i++)
                    {
                        if (EventManager.getInstance().getOrganisers().get(i).getFullName().equals(person.getFullName()))
                        {
                            checker = true;
                        }
                    }
                    if (checker == false)
                    {
                       EventManager.getInstance().addOrganiser(person); 
                       if (!(e==null))
                       {
                           EventManager.getInstance().associateUserToEvent(e, person);
                           ec.getOrg().setText("Event Organiser: "+person.toString());
                       }
                    }
                     
                }
                
                //Checks if the document part is empty
                if (!(eventItems==null))
                {
                   //EventItems
                   //Assign attributes
                   String[] eventItemsAtt = eventItems.split("/");
                    //Loop through each eventItem
                    for (String items : eventItemsAtt) {
                        String oneEvent = items.substring(1, items.length() - 1);
                        String[] EAttributes = oneEvent.split("-");
                        EventItems newItem = new EventItems();
                        newItem.setTime(LocalTime.parse(EAttributes[0]));
                        newItem.setTitle(EAttributes[1]);
                        //Add EventItem to EventManager
                        //Check EventItem doesn't alredy exists in the eventmanager
                        boolean checker = false;
                        EventItems containedItem = null;
                        for (int i = 0; i<EventManager.getInstance().getEventItems().size();i++)
                        {
                            if (EventManager.getInstance().getEventItems().get(i).getTime().equals(newItem.getTime()) && EventManager.getInstance().getEventItems().get(i).getTitle().equals(newItem.getTitle()))
                                    {
                                        checker = true;
                                        containedItem = EventManager.getInstance().getEventItems().get(i);
                                    }
                        }
                        if (checker == false)
                        {
                           EventManager.getInstance().addEventItemsToEventManager(newItem);
                           //Check if Event exists in file, if it does assign to event
                           if (!(e==null))
                           {
                               EventManager.getInstance().addEventItemsToEvent(e, newItem);
                               EventItemCard newItemCard = new EventItemCard(newItem.getTitle(),newItem.getTime(),ec);
                               newItemCard.setEventItem(newItem);
                               ec.getItemCards().add(newItemCard);
                               System.out.println("Item CARD MADE");
                           } 
                        }
                        if (checker == true)
                        {
                            EventManager.getInstance().addEventItemsToEvent(e,containedItem);
                            EventItemCard newContainedCard = new EventItemCard(containedItem.getTitle(),containedItem.getTime(),ec);
                            ec.getItemCards().add(newContainedCard);
                            newContainedCard.setEventItem(containedItem);
                            
                            
                        }
                        
                    } 
                }
                
                
                 
                
                //Get next line from file
                data = infile.readLine();
            }
            infile.close();
            
            
        }
        catch(FileNotFoundException e)
        {
           System.out.println("Can't find file");	  		    	 	  	       	     	
        }	  		    	 	  	       	     	
        catch (IOException e)	  		    	 	  	       	     	
        {	  		    	 	  	       	     	
            System.out.println("IO Error");
        }
    }
    
    /**
     * Method that clears the event manager of all events, eventitems and organisers. 
     * 
     */
    public static void clearOrganiser()
    {
        EventManager.organisers.clear();
        EventManager.events.clear();
        EventManager.items.clear();
        //Clear out EventCards
        EventViewer.getInstance().getRightSide().getRighttop().getCards().clear();
        //Refresh all displays
        EventManager.getInstance().displayCardsToViewer();
        EventManager.getInstance().displayEventItemCardsToViewer();
        EventManager.getInstance().displayLeftEventItemsAndOrganisers();
        
    }
    
    /**
     *
     * @param event
     * @param title
     * @param organiser
     * @param date
     * @param time
     * @param location
     * @return String if the events details were edited or not.
     */
    public String editEvent(Event event,String title,Organiser organiser,LocalDate date,LocalTime time,String location)
    {
        String result = "";
        //Check Event exists
        if (!EventManager.getInstance().getEvents().contains(event)) 
        {
            result = "Event does not exist, so nothing has been editd";
        } 
        else 
        {
            //Checks title is not null
            if (!(title==null))
            {
                //title is not null so edit title
                EventManager.getInstance().getEvent(event).setTitle(title);
                result = result + "Title has now been changed to " + title +". ";
            }
            if (!(organiser == null))
            {
                EventManager.getInstance().associateUserToEvent(event, organiser);
                result = result + "Organiser has now been changed to "+organiser+". ";
            }
            if (!(date ==null))
            {
                EventManager.getInstance().getEvent(event).setDate(date);
                result = result + "Date has now been changed to "+date.toString()+". ";
            }
            if (!(time == null))
            {
                EventManager.getInstance().getEvent(event).setTime(time);
                result = result + "Time has now been changed to "+time.toString()+". ";
            }
            if (!(location == null))
            {
                EventManager.getInstance().getEvent(event).setLocation(location);
                result = result + "Location has now been changed to "+location+". ";
            }
        }
        
        return result;
    }
    
    /**
     *
     * @param filename
     * @return a string if the file was saved with all the current events, eventitems and organisers.
     */
    public String saveFile(File filename)
    {
        //Result will return if the file was created successfully
        String result = "";
        //String that will be added to the file contain objects
        String data = "";
        List<Event> savedEvents = new ArrayList<>();
        List<EventItems> savedItems = new ArrayList<>();
        List<Organiser> savedOrganiser = new ArrayList<>();
        try {
          //Make Buffered Writer to create and write file
          BufferedWriter outfile = new BufferedWriter(new FileWriter(filename));
          //For loop to add all events with their items and Organisers
          for (Event e:EventManager.getInstance().getEvents())
          {
              //Add Event to String
              data = "["+e.getTitle()+"/"+e.getDate()+"/"+e.getTime()+"/"+e.getLocation()+"]";
              savedEvents.add(e);
              //Check eventitems in event is not empty
              if (!(e.getEventItems().isEmpty()))
              {
                  data = data + ",[";
                  //if not empty loop through and add to file line
                  for (EventItems i: EventManager.getInstance().getEvent(e).getEventItems())
                  {
                      savedItems.add(i);
                      data = data + "["+i.getTime()+"-"+i.getTitle()+"]";
                      //Check not last item in eventitem array
                      if (!(EventManager.getInstance().getEvent(e).getEventItems().get(EventManager.getInstance().getEvent(e).getEventItems().size()-1)==i))
                      {
                          data = data +"/";
                      }
                      if (EventManager.getInstance().getEvent(e).getEventItems().get(EventManager.getInstance().getEvent(e).getEventItems().size()-1)==i)
                      {
                          data = data +"]";
                      }
                    
                  }
              }
              else 
              {
                  data = data + ",[null]";
              }
              if (!(e.getOrganiser()==null))
              {
                  savedOrganiser.add(e.getOrganiser());
                  data = data + ",["+e.getOrganiser().getFullName()+"]";
              }
              else 
              {
                  data = data + ",[null]";
              }
            
            outfile.write(data);
            outfile.newLine();
            //Add Organiser to String
            //Write new line for next loop
          }
          //Loop through eventitems to ensure they were all added, if not add the others
          for (EventItems i: EventManager.getInstance().getEventItems())
          {
              data = "";
              if (!(savedItems.contains(i)))
              {
                  savedItems.add(i);
                  data = "[null],[["+i.getTime()+"-"+i.getTitle()+"]],[null]";
                  outfile.write(data);
                  outfile.newLine(); 
              }
          }
          //Loop through all ograniser to ensure they were all added, if not add the others
          for (Organiser o: EventManager.getInstance().getOrganisers())
          {
              data = "[null],[null],";
              if (!(savedOrganiser.contains(o)))
              {
                  savedOrganiser.add(o);
                  data = data + "["+o.getFullName()+"]";
                  outfile.write(data);
                  outfile.newLine();
              }
          }
        //Add each item to added
        outfile.close();
        result="File saved successfully.";
        } 
        catch (IOException ex) 
        {
            System.out.println("IO Error.");
        }
        return result;
    }
    
    /**
     *adds event to viewer
     * @param e
     * @return
     */
    public static EventCard addEventToViewer(Event e) 
    {
        EventCard newCard = new EventCard(e);
        EventViewer.getInstance().getRightSide().getRighttop().getCards().add(newCard);
        
        EventManager.getInstance().displayCardsToViewer();
        
        //Clear event display
        //Loop through each event and create event card for each and add to the display
        return newCard;
    }
    
    /**
     *displays all cards to viewer
     */
    public static void displayCardsToViewer()
    {
        //Clear Viewer
        EventViewer.getInstance().getRightSide().getRighttop().getCenterpanel().removeAll();
        EventViewer.getInstance().getRightSide().getRighttop().repaint();
        //Check cards is not null
        if (EventViewer.getInstance().getRightSide().getRighttop().getCards()!=null)
        {
            for (EventCard ec: EventViewer.getInstance().getRightSide().getRighttop().getCards())
            {
                EventViewer.getInstance().getRightSide().getRighttop().getCenterpanel().add(ec);
                EventViewer.getInstance().getRightSide().getRighttop().validate();
            }
        }
        //Loop through each card and add to viewer
        //revaldiate screen
    }
    
    /**
     *updates the cards in viewer
     */
    public static void updateCards()
    {
        for (EventCard ec: EventViewer.getInstance().getRightSide().getRighttop().getCards())
        {
            //Reset each attribute from event 
            Event updateevent = ec.getEvent();
            ec.getTitle().setText("Event Title: "+updateevent.getTitle());
            ec.getOrg().setText("Event Organiser: "+updateevent.getOrganiser().toString());
            ec.getDate().setText("Event Date: "+updateevent.getDate().toString());
            ec.getTime().setText("Event Time: "+updateevent.getTime().toString());
            ec.getEventlocation().setText("Event Location: "+updateevent.getLocation());
            //Revalidate view
        }
    }
    
    /**
     *deletes a card from the viewer
     * @param e
     */
    public static void deleteCardFromEventViewer(EventCard e)
    {
        if (EventViewer.getInstance().getRightSide().getRighttop().getCards().contains(e))
        {
//            //Remove eventcard from righttop from centerpanel
            EventViewer.getInstance().getRightSide().getRighttop().getCenterpanel().remove(e);
            //Remove eventcard from cards
            EventViewer.getInstance().getRightSide().getRighttop().getCards().remove(e);
            //Remove event from eventManager with any organiser associated
            EventManager.getInstance().deleteEvent(e.getEvent());
            //Update View
            EventManager.getInstance().displayCardsToViewer();
        }
    }
    
    /**
     *displays the left hand side of the viewer
     */
    public static void displayLeftEventItemsAndOrganisers()
    {
        //GetOrgansieField From left side
        //Create String 
        String OrganiserString = "";
        //Loop throguht each organiser and list their name
        if (EventManager.getInstance().getOrganisers()!=null)
        {
            for (Organiser o: EventManager.getInstance().getOrganisers())
            {
                OrganiserString = OrganiserString + "- "+o.getFullName()+System.lineSeparator();
            }  
        }
        //Set getorganiserfield to text
        System.out.println(OrganiserString);
        EventViewer.getInstance().getLeftSide().getOrganiserField().setText(OrganiserString);
        //GetEventIems Field form left side#
        //Create String 
        String EventItems = "";
        //Loop throguht each eventiem and list their name
        if(EventManager.getInstance().getEventItems()!=null)
        {
            for (EventItems i: EventManager.getInstance().getEventItems())
            {
                EventItems = EventItems +"- "+i.getTitle()+System.lineSeparator();
            
            } 
        }
        //set geteventitems to string
        EventViewer.getInstance().getLeftSide().getEventsField().setText(EventItems);
        //revalidate and repaint section
        EventViewer.getInstance().getLeftSide().revalidate();
        EventViewer.getInstance().getLeftSide().repaint();
        
    }
    
    /**
     *sorts event cards
     * @param whatsHappening
     */
    public void sort(String whatsHappening)
    {
        //Call onto eventcards
        if (whatsHappening.equals("Title"))
        {
            EventViewer.getInstance().getRightSide().getRighttop().getCards().sort((a,b)->{
            return a.getTitle().getText().compareTo(b.getTitle().getText());
                });        
        }
        else if (whatsHappening.equals("Date"))
        {
            EventViewer.getInstance().getRightSide().getRighttop().getCards().sort((a,b)->{
            return a.getEvent().getDate().compareTo(b.getEvent().getDate());
                });        
        }
        else if (whatsHappening.equals("Organiser"))
        {
            EventViewer.getInstance().getRightSide().getRighttop().getCards().sort((a,b)->{
            return a.getOrg().getText().compareTo(b.getOrg().getText());
                });        
        }
        else if (whatsHappening.equals("Location"))
        {
            EventViewer.getInstance().getRightSide().getRighttop().getCards().sort((a,b)->{
            return a.getEventlocation().getText().compareTo(b.getEventlocation().getText());
                });        
        }
        
    }
    
    /**
     *sorts event cards items
     * @param whatToDo
     * @param ec
     */
    public void sort(String whatToDo, EventCard ec)
    {
        if(whatToDo.equals("Time"))
        {
            ec.getItemCards().sort((a,b)->{
                return a.getItemtime().getText().compareTo(b.getItemtime().getText());
            });
        }
        else if (whatToDo.equals("Title"))
        {
            ec.getItemCards().sort((a,b)->{
                return a.getItemtitle().getText().compareTo(b.getItemtitle().getText());
            });
        }
    }
    
    /**
     *displays event items to the viewer
     */
    public void displayEventItemCardsToViewer()
    {
        EventCard selected = null;
        //Remove all componeents from viewer and repaint
        EventViewer.getInstance().getRightSide().getRightbottom().getCenterpanel().removeAll();
        EventViewer.getInstance().getRightSide().getRightbottom().repaint();
        //Loop through events and check which ones are checked
        for (EventCard ec: EventViewer.getInstance().getRightSide().getRighttop().getCards())
        {
            if (ec.getChecker().isSelected())
            {
                selected = ec;
            }
        }
        if(selected!=null)
        {
            //Loop throguth selected eventcard and add evetitem cards to display
            if (selected.getItemCards()!=null)
            {
                for (EventItemCard eic: selected.getItemCards())
                {
                   EventViewer.getInstance().getRightSide().getRightbottom().getCenterpanel().add(eic);
                   EventViewer.getInstance().getRightSide().getRightbottom().getCenterpanel().revalidate();
                   EventViewer.getInstance().getRightSide().getRightbottom().getCenterpanel().repaint();
                }
            }
        }
        
    }
}
