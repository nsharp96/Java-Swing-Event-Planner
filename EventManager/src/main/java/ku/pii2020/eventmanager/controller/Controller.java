/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.eventmanager.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import ku.pii2020.eventmanager.model.Event;
import ku.pii2020.eventmanager.model.EventItems;
import ku.pii2020.eventmanager.model.EventManager;
import ku.pii2020.eventmanager.model.Organiser;
import ku.pii2020.eventmanager.view.EventCard;
import ku.pii2020.eventmanager.view.EventItemCard;
import ku.pii2020.eventmanager.view.EventViewer;
import ku.pii2020.eventmanager.view.NewEditForm;
import ku.pii2020.eventmanager.view.NewEditItemForm;
import ku.pii2020.eventmanager.view.NewEventForm;
import ku.pii2020.eventmanager.view.NewEventItemForm;

/**
 *
 * @author Natalie Sharp - K2041275
 */
public class Controller implements ActionListener
{
    private EventViewer h = EventViewer.getInstance();
    private EventManager m = EventManager.getInstance();
    private NewEventForm form;
    private NewEditForm editform;
    private NewEventItemForm Itemform;
    private NewEditItemForm edititem;
    
    /**
     *Controller Constructor. Sets up ActionListenrs and Action Commands
     */
    public Controller()
    {
        //Add actionlistener to add event button
        h.getLoad().addActionListener(this);
        h.getLoad().setActionCommand("Load File");
        
        h.getSave().addActionListener(this);
        h.getSave().setActionCommand("Save File");
        
        h.getClearOrg().addActionListener(this);
        h.getClearOrg().setActionCommand("Clear");
        
        h.getQuit().addActionListener(this);
        h.getQuit().setActionCommand("Quit");
        
        h.rightSide.getRighttop().getAddEvent().addActionListener(this);
        h.rightSide.getRighttop().getAddEvent().setActionCommand("Add Event");
        
        h.rightSide.getRighttop().getEditEvent().addActionListener(this);
        h.rightSide.getRighttop().getEditEvent().setActionCommand("Edit Event");
        
        h.rightSide.getRighttop().getDeleteEvent().addActionListener(this);
        h.rightSide.getRighttop().getDeleteEvent().setActionCommand("Delete Event");
        
        h.rightSide.getRighttop().getSubmit().addActionListener(this);
        h.rightSide.getRighttop().getSubmit().setActionCommand("Search For Event");
        
        h.rightSide.getRighttop().getResetSearch().addActionListener(this);
        h.rightSide.getRighttop().getResetSearch().setActionCommand("Reset Search");
        
        h.rightSide.getRighttop().getSortByTitle().addActionListener(this);
        h.rightSide.getRighttop().getSortByTitle().setActionCommand("Sort By Title");
        
        h.rightSide.getRighttop().getSortByDate().addActionListener(this);
        h.rightSide.getRighttop().getSortByDate().setActionCommand("Sort By Date");
        
        h.rightSide.getRighttop().getSortByOrganiser().addActionListener(this);
        h.rightSide.getRighttop().getSortByOrganiser().setActionCommand("Sort By Organiser");
        
        h.rightSide.getRighttop().getSortByLocation().addActionListener(this);
        h.rightSide.getRighttop().getSortByLocation().setActionCommand("Sort By Location");
        
        h.getRightSide().getRightbottom().getAddEventItem().addActionListener(this);
        h.getRightSide().getRightbottom().getAddEventItem().setActionCommand("Add Event Item");
        
        h.getRightSide().getRightbottom().getEditEventItem().addActionListener(this);
        h.getRightSide().getRightbottom().getEditEventItem().setActionCommand("Edit Event Item");
        
        h.getRightSide().getRightbottom().getDeleteEventItem().addActionListener(this);
        h.getRightSide().getRightbottom().getDeleteEventItem().setActionCommand("Delete Event Item");
        
        h.getRightSide().getRightbottom().getSearchItem().addActionListener(this);
        h.getRightSide().getRightbottom().getSearchItem().setActionCommand("Search Event Items");
        
        h.getRightSide().getRightbottom().getResetSearch().addActionListener(this);
        h.getRightSide().getRightbottom().getResetSearch().setActionCommand("Reset Event Item Search");
        
        h.getRightSide().getRightbottom().getSortByTime().addActionListener(this);
        h.getRightSide().getRightbottom().getSortByTime().setActionCommand("Sort Items By Time");
        
        h.getRightSide().getRightbottom().getSortByTitle().addActionListener(this);
        h.getRightSide().getRightbottom().getSortByTitle().setActionCommand("Sort Items By Title");
    }
    
   
    //ActionListener for when buttons are pressed 
    //ActionPerformed

    /**
     *
     * @param e
     * Takes an action event and checks which one is called
     */
    public void actionPerformed (ActionEvent e)
        {
            if(e.getActionCommand().equals("Add Event"))
            {
                form = new NewEventForm();
                
                //Add actionlistener to add user to combobox
                form.getAdd().addActionListener(this);
                form.getAdd().setActionCommand("Add User To ComboBox");
                
                //Add actionListener to submit form
                form.getSubmitForm().addActionListener(this);
                form.getSubmitForm().setActionCommand("Submit Form");
                
            }
            else if(e.getActionCommand()=="Edit Event")
            {
                EventCard checked = null;
                //Loop through eventCards to see if any checkers are selected
                for (EventCard c:EventViewer.getInstance().getRightSide().getRighttop().getCards())
                {
                    if (c.getChecker().isSelected())
                    {
                        checked = c;
                        Event eventincard = c.getEvent();
                        editform = new NewEditForm(eventincard);
                        editform.getAdd().addActionListener(this);
                        editform.getAdd().setActionCommand("Add User To Edit ComboBox");
                        editform.getSubmitForm().addActionListener(this);
                        editform.getSubmitForm().setActionCommand("Edit Form");
                        
                    }
                }
                if (checked==null)
                {
                    JOptionPane.showMessageDialog(h,"Event was not selected.");
                }
            }
            else if(e.getActionCommand()=="Delete Event")
            {
                EventCard checked = null;
                //Loop through eventCards to see if any checkers are selected
                for (EventCard c:EventViewer.getInstance().getRightSide().getRighttop().getCards())
                {
                    //If EventCard is selected then deleted said event card
                    if (c.getChecker().isSelected())
                    {
                        //checked is changed to the eventcard
                        checked = c;
                        Event cevent = checked.getEvent();
                        //Call onto deletedCardFromEventViewer to delete eventcard
                        EventManager.getInstance().deleteCardFromEventViewer(checked);
                        EventManager.getInstance().displayLeftEventItemsAndOrganisers();
                        EventManager.getInstance().displayEventItemCardsToViewer();
                        
                        break;
                        
                    }
                }
                if (checked==null)
                {
                    JOptionPane.showMessageDialog(h,"Event was not selected for deletion.");
                }
            }
            else if(e.getActionCommand()=="Add User To ComboBox")
            {
                String result = (String)JOptionPane.showInputDialog(form,"Enter Organisers Full Name: ");
                if (result!=null)
                {
                    Organiser newOrganiser = new Organiser();
                    newOrganiser.setFullName(result);
                    EventManager.getInstance().addOrganiser(newOrganiser);
                    //Add Organiser to panel on the left hand side
                    form.getEventOrganiserTitle().addItem(newOrganiser);
                }
            }
            else if(e.getActionCommand()=="Add User To Edit ComboBox")
            {
                String result = (String)JOptionPane.showInputDialog(form,"Enter Organisers Full Name: ");
                if (result!=null)
                {
                    Organiser newOrganiser = new Organiser();
                    newOrganiser.setFullName(result);
                    EventManager.getInstance().addOrganiser(newOrganiser);
                    editform.getEventOrganiserTitle().addItem(newOrganiser);
                }
            }
            else if(e.getActionCommand().equals("Submit Form"))
            {
                try
                {
                    Event newEvent = new Event(form.getEventTitle().getText(),(Organiser) form.getEventOrganiserTitle().getSelectedItem(),(LocalDate.parse(form.getDateTextField().getText())),LocalTime.parse(form.getTimeTextField().getText()),form.getEventLocationField().getText());
                    boolean result = m.addEvent(newEvent);
                    
                    //if added
                    if(result==true)
                    {
                       EventCard newCard = EventManager.addEventToViewer(newEvent); 
                       newCard.getChecker().addActionListener(this);
                       newCard.getChecker().setActionCommand("Checked Event");
                    }
                   
                    
                    //dispose of pop up
                    form.dispose();
                    
                }
                catch (Exception excep)
                {
                    JOptionPane.showMessageDialog(form,"The form wasn't filled out correctly. Please try again.");
                }
                
            }
            else if(e.getActionCommand().equals("Edit Form"))
            {
                System.out.println(EventManager.getInstance().editEvent(editform.getFormevent(), editform.getEventTitle().getText(),(Organiser) editform.getEventOrganiserTitle().getSelectedItem(), LocalDate.parse(editform.getDateTextField().getText()), LocalTime.parse(editform.getTimeTextField().getText()), editform.getEventLocationField().getText()));
                EventManager.getInstance().updateCards();
                EventViewer.getInstance().getRightSide().getRighttop().revalidate();

                //dispose of pop up
                editform.dispose();          
            }
            else if(e.getActionCommand().equals("Search For Event"))
            {
                //Get Selected Text In Box
                String getThis = h.getRightSide().getRighttop().getSearch().getText();
                //Check Cards is not empty
                List<EventCard> containedCard = new ArrayList<EventCard>();
                if(h.getRightSide().getRighttop().getCards()!=null)
                {
                    //Loop through EventCards and look at each event and get tostring and check if selected text is contained within
                    for (EventCard ec: h.getRightSide().getRighttop().getCards())
                    {
                        if(ec.getEvent().toString().contains(getThis))
                        {
                            containedCard.add(ec);
                        }
                    }
                }              
                //if yes add to array of contain cards
                //Display selected method
                EventViewer.getInstance().getRightSide().getRighttop().getCenterpanel().removeAll();
                EventViewer.getInstance().getRightSide().getRighttop().repaint();
                for (EventCard ec: containedCard)
                {
                    EventViewer.getInstance().getRightSide().getRighttop().getCenterpanel().add(ec);
                    EventViewer.getInstance().getRightSide().getRighttop().validate();
                }
        
            }
            else if (e.getActionCommand().equals("Reset Search"))
            {
                m.getInstance().displayCardsToViewer();
            }
            else if (e.getActionCommand().equals("Sort By Title"))
            {
                EventManager.getInstance().sort("Title");
                EventManager.displayCardsToViewer();
            }
            else if (e.getActionCommand().equals("Sort By Date"))
            {
                EventManager.getInstance().sort("Date");
                EventManager.displayCardsToViewer();
            }
            else if (e.getActionCommand().equals("Sort By Organiser"))
            {
                EventManager.getInstance().sort("Organiser");
                EventManager.displayCardsToViewer();
            }
            else if (e.getActionCommand().equals("Sort By Location"))
            {
                EventManager.getInstance().sort("Location");
                EventManager.displayCardsToViewer();
            }
            else if(e.getActionCommand().equals("Add Event Item"))
            {
                //Check if event is checked
                EventCard selected = null;
                //If it is asign to selected
                for (EventCard ec: h.getRightSide().getRighttop().getCards())
                {
                    if (ec.getChecker().isSelected())
                    {
                        selected = ec;
                        break;
                    }
                }
                if (selected!=null)
                {
                    Itemform = new NewEventItemForm();
                    
                    //Add actionListener to submit eventform
                    Itemform.setEventCard(selected);
                    Itemform.getSubmitItemForm().addActionListener(this);
                    Itemform.getSubmitItemForm().setActionCommand("Submit Event Item Form");
                }
                else 
                {
                    JOptionPane.showMessageDialog(h, "No Event Selected.");
                }
                //If selected is not null, create eventitem and set to event in event card
                //Create eventitemcard
                    
                //If not pop up screen saying no event chosen
                
                
                //New Event Item form and set title and time
                //Loop through eventcards and get get the one that checked
                //Add event item to said event 
                //Add EventItemCard to EventItem
            }
            else if(e.getActionCommand().equals("Submit Event Item Form"))
            {
                try
                {
                    //Create new eventitem
                    EventItems newEventItem = new EventItems(Itemform.getEventItemTitle().getText(), LocalTime.parse(Itemform.getEventItemTime().getText()));
                    //Add EventItem to event and eventmanager
                    m.addEventItemsToEvent(Itemform.getEventCard().getEvent(),newEventItem);
                    //Make a new EventItemCard
                    EventItemCard newItemCard = new EventItemCard(newEventItem.getTitle(),newEventItem.getTime(),Itemform.getEventCard());
                    newItemCard.setEventItem(newEventItem);
                    //Add to Events ItemCards
                    Itemform.getEventCard().getItemCards().add(newItemCard);
                    //Display selected events item cards
                    EventManager.getInstance().displayEventItemCardsToViewer();
                    Itemform.dispose();
                    
                }
                catch (Exception excep)
                {
                    JOptionPane.showMessageDialog(Itemform, "The form wasn't filled out properly, please try again.");
                }
                 
                
            }
            else if(e.getActionCommand().equals("Edit Event Item"))
            {
                //Check which EventCard is selected
                //Check which EventItem in said event is selected
                
                //Pop up edit screen
                //Add action listenr to submit buttomn
                
                
                EventCard checked = null;
                Event eventincard = null;
                EventItemCard itemchecked = null;
                //Loop through eventCards to see if any checkers are selected
                for (EventCard c:EventViewer.getInstance().getRightSide().getRighttop().getCards())
                {
                    if (c.getChecker().isSelected())
                    {
                        checked = c;
                        eventincard = c.getEvent();    
                    }
                }
                if (checked==null)
                {
                    JOptionPane.showMessageDialog(h,"Event was not selected.");
                }
                else
                {
                    for (EventItemCard eic: checked.getItemCards())
                    {
                        if (eic.getChecker().isSelected())
                        {
                            itemchecked = eic;
                            edititem = new NewEditItemForm(itemchecked.getEventItem());
                            edititem.setEventItemCard(itemchecked);
                            edititem.setItemToEdit(itemchecked.getEventItem());
                            edititem.getSubmitItemForm().addActionListener(this);
                            edititem.getSubmitItemForm().setActionCommand("Submit Edit Item");
                        }
                    }
                }
                if (checked!=null&itemchecked==null)
                {
                    JOptionPane.showMessageDialog(h,"Event Item was not selected.");
                }
                
            }
            else if(e.getActionCommand().equals("Submit Edit Item"))
            {
                edititem.dispose();
                String newTime = edititem.getEventItemTime().getText();
                String newTitle = edititem.getEventItemTitle().getText();
                //Update EventItem
                EventItems itemToEdit = edititem.getItemToEdit();
                System.out.println(itemToEdit);
                itemToEdit.setTime(LocalTime.parse(newTime));
                System.out.println(itemToEdit.getTime());
                itemToEdit.setTitle(newTitle);
                System.out.println(itemToEdit.getTitle());
                //Update EventItemCard
                EventItemCard cardToEdit = edititem.getEventItemCard();
                cardToEdit.getItemtime().setText("Event Time: "+newTime);
                cardToEdit.getItemtitle().setText("Event Title: "+newTitle);
                //Update Cards
                EventManager.getInstance().displayEventItemCardsToViewer();
                EventManager.getInstance().displayLeftEventItemsAndOrganisers();
                
            }
            else if (e.getActionCommand().equals("Delete Event Item"))
            {
                EventCard checked = null;
                for (EventCard ec: EventViewer.getInstance().getRightSide().getRighttop().getCards())
                {
                    //Check what EventCard is checked
                    if(ec.getChecker().isSelected())
                    {
                        checked = ec;
                        break;
                    }
                }
                //Find which EventItem in the Event is checked
                EventItemCard selected = null;
                if (checked!=null)
                {
                    for (EventItemCard eic: checked.getItemCards())
                    {
                        if(eic.getChecker().isSelected())
                        {
                            selected=eic;
                            break;
                        }
                    }
                }
                if (checked==null)
                {
                    JOptionPane.showMessageDialog(h, "Event was not selected");
                }
                if (checked!=null&&selected==null)
                {
                    JOptionPane.showMessageDialog(h, "Event Item was not selected");
                }
                
                if (checked!=null&&selected!=null)
                {
                //Delete EventItem from said event
                EventManager.getInstance().deleteEventItemsFromEvent(checked.getEvent(), selected.getEventItem());
                //Delete EventItemCard from EventCard
                checked.getItemCards().remove(selected);
                //Remove EventItem from EventManager
                EventManager.getInstance().deleteEventItemsFromEventManager(selected.getEventItem());
                //Update Display
                EventManager.getInstance().displayEventItemCardsToViewer();
                EventManager.getInstance().displayLeftEventItemsAndOrganisers();

                }
                
            }
            else if (e.getActionCommand().equals("Search Event Items"))
            {
                //Get Selected Text In Box
                String getThis = h.getRightSide().getRightbottom().getSearchItemField().getText();
                //Create List of ItemCards containing the string to view
                List<EventItemCard> containedItems = new ArrayList<EventItemCard>();
                //Find Selected EventCard
                EventCard checked = null;
                for (EventCard ec: EventViewer.getInstance().getRightSide().getRighttop().getCards())
                {
                    //Check what EventCard is checked
                    if(ec.getChecker().isSelected())
                    {
                        checked = ec;
                        break;
                    }
                }
                if (checked!=null)
                {
                    if(checked.getItemCards()!=null)
                {
                    //Loop through EventCards and look at each event and get tostring and check if selected text is contained within
                    for (EventItemCard eic: checked.getItemCards())
                    {
                        if(eic.getEventItem().toString().contains(getThis))
                        {
                            containedItems.add(eic);
                        }
                    }
                } 
                }
                //Display selected method
                EventViewer.getInstance().getRightSide().getRightbottom().getCenterpanel().removeAll();
                EventViewer.getInstance().getRightSide().getRightbottom().repaint();
                for (EventItemCard eic: containedItems)
                {
                    EventViewer.getInstance().getRightSide().getRightbottom().getCenterpanel().add(eic);
                    EventViewer.getInstance().getRightSide().getRightbottom().validate();
                }
            }
            else if (e.getActionCommand().equals("Reset Event Item Search"))
            {
                m.getInstance().displayEventItemCardsToViewer();
            }
            else if (e.getActionCommand().equals("Sort Items By Time"))
            {
                EventCard checked = null;
                for (EventCard ec: EventViewer.getInstance().getRightSide().getRighttop().getCards())
                {
                    //Check what EventCard is checked
                    if(ec.getChecker().isSelected())
                    {
                        checked = ec;
                        break;
                    }
                }
                EventManager.getInstance().sort("Time", checked);
                EventManager.getInstance().displayEventItemCardsToViewer();
            }
            else if (e.getActionCommand().equals("Sort Items By Title"))
            {
                EventCard checked = null;
                for (EventCard ec: EventViewer.getInstance().getRightSide().getRighttop().getCards())
                {
                    //Check what EventCard is checked
                    if(ec.getChecker().isSelected())
                    {
                        checked = ec;
                        break;
                    }
                }
                EventManager.getInstance().sort("Title", checked);
                EventManager.getInstance().displayEventItemCardsToViewer();
            }
            else if (e.getActionCommand().equals("Checked Event"))
            {
                EventManager.getInstance().displayEventItemCardsToViewer();  
            }
            else if (e.getActionCommand().equals("Load File"))
            {
                JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV File","csv");
                chooser.setDialogTitle("Load File");
                chooser.addChoosableFileFilter(filter);
                int returnValue = chooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION)
                {
                    int output = JOptionPane.showConfirmDialog(h,"By Loading this file, all Events,EvenItems and Ogranisers already opened will be cleared and replaced. Are you sure you want to do this?");
                    if(output == JOptionPane.YES_OPTION)
                    {
                        EventManager.getInstance().clearOrganiser();
                        File file = chooser.getSelectedFile();
                        EventManager.getInstance().readFile(file);
                        for (EventCard ec: h.getRightSide().getRighttop().getCards())
                        {
                            ec.getChecker().addActionListener(this);    
                            ec.getChecker().setActionCommand("Checked Event");
                        }
                        //Display screen
                        EventManager.getInstance().displayLeftEventItemsAndOrganisers();
                        EventManager.getInstance().displayCardsToViewer();
                        EventManager.getInstance().displayEventItemCardsToViewer();
                        
                    }
                }
                   
            }
            else if (e.getActionCommand().equals("Save File"))
            {
                JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV File","csv");
                chooser.setDialogTitle("Save File");
                chooser.addChoosableFileFilter(filter);
                int returnValue = chooser.showSaveDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION)
                {
                    File fileToSave = chooser.getSelectedFile();
                    EventManager.getInstance().saveFile(fileToSave);
                    JOptionPane.showMessageDialog(h, "File was saved successfully!");
                }
            }
            else if (e.getActionCommand().equals("Quit"))
            {
                System.exit(0);
            }
            else if (e.getActionCommand().equals("Clear"))
            {
                int output = JOptionPane.showConfirmDialog(h,"Are you sure you want to clear the EventPlanner?");
                if (output == JOptionPane.YES_OPTION)
                {
                    EventManager.getInstance().clearOrganiser();
                }
            }
        }
                
               
}
