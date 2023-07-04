/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.eventmanager.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Natalie Sharp - K2041275
 */
public class Event 
{
    //Attributes
    private String title;
    private Organiser organiser;
    private LocalDate date; //Chnage to LocalDate
    private LocalTime time; //Change to LocalTime
    private String location;
    private List<EventItems> eventItems = new ArrayList<>();
    
    
     
        
    //Constructor

    /**
     *Empty constuctor for Event
     */
    public Event()
    {
    
    }
    
    /**
     *Construcot for event that sets all attributes
     * @param title
     * @param org
     * @param date
     * @param time
     * @param location
     */
    public Event(String title, Organiser org, LocalDate date, LocalTime time, String location)
    {
        this.title = title;
        this.organiser = org;
        this.date = date;
        this.time = time;
        this.location = location;
    }
    
    //Getter and Setter for title

    /**
     *
     * @return title of Event object
     */
    public String getTitle()
    {
        return this.title;
    }

    /**
     *
     * @param title
     * Sets Event title
     */
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    //Getter and Setter for organiser

    /**
     *
     * @return Events Organiser
     * gets organiser
     */
    public Organiser getOrganiser()
    {
        return this.organiser;
    }

    /**
     *
     * @param user
     * Sets the Event objects user
     */
    public void setOrganiser(Organiser user)
    {
        this.organiser = user;
    }
    
    //Getter and Setter for date    

    /**
     *
     * @return Date of Event
     */
    public LocalDate getDate()
    {
        return this.date;
    }

    /**
     *
     * @param date
     * Sets the Events date
     */
    public void setDate(LocalDate date)
    {
        this.date = date;
    }
    
    //Getter and Setter for time

    /**
     *
     * @return Time of the event
     */
    public LocalTime getTime()
    {
        return this.time;
    }

    /**
     *
     * @param time
     * Sets the time of the Event
     */
    public void setTime(LocalTime time)
    {
        this.time = time;
    }
    
    //Getter and Setter for location

    /**
     *
     * @return Location of the event
     */
    public String getLocation()
    {
        return this.location;
    }

    /**
     *
     * @param location
     * Sets the location of the event
     */
    public void setLocation(String location)
    {
        this.location = location;
    }
    
    //Getter and Setter for eventitems

    /**
     *
     * @return List of eventItems linked to the event object
     */
    public List<EventItems> getEventItems()
    {
        return this.eventItems;
    }

    /**
     *
     * @param e
     * @return EventItem the user is trying to find
     */
    public EventItems getEventItem(EventItems e)
    {
        EventItems returnEvent = null;
        for (int i = 0; i<this.getEventItems().size() ;i++)
        {
            if (this.eventItems.get(i).equals(e))
            {
                returnEvent = this.eventItems.get(i);
            }
        }
        return returnEvent;
    }

    /**
     *
     * @param items
     * Sets the EventItems of the event
     */
    public void setEventItems(List<EventItems> items)
    {
        this.eventItems = items;
    }
    
    /**
     *
     * @return String of the event details
     */
    @Override
    public String toString()
    {
        String result;
        if (this.organiser==null)
        {
            result = this.title + " "+ this.location + " "+ this.time +" "+ this.getDate().getDayOfWeek()+" "+ this.getDate().getDayOfMonth() + " "+this.getDate().getMonth() + " " + this.getDate().getYear();
        }
        else 
        {
            result = this.title + " " + this.organiser.getFullName() +  " "+ this.location + " "+ this.time +" "+ this.getDate().getDayOfWeek()+" "+ this.getDate().getDayOfMonth() + " "+this.getDate().getMonth() + " " + this.getDate().getYear() ;
        }
        return result;
        
    }
    
}
