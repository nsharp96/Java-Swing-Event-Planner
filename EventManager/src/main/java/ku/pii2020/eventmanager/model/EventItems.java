/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.eventmanager.model;

import java.time.LocalTime;


/**
 *
 * @author Natalie Sharp - K2041275
 */
public class EventItems 
{
    //Attributes
    private String title;
    private LocalTime startTime;
    
    //Constructor

    /**
     *
     */
    public EventItems()
    {
        
    }

    /**
     *
     * @param title
     * @param startTime
     */
    public EventItems(String title, LocalTime startTime)
    {
        this.title = title;
        this.startTime = startTime;
    }
    
    //Getter and Setter for title

    /**
     *
     * @return Title of the Event item
     */
    public String getTitle()
    {
        return this.title;
    }

    /**
     *
     * @param title
     * Sets the title of the event title
     */
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    //Getter and Setter for starttime 

    /**
     *
     * @return Time of the Event Item
     */
    public LocalTime getTime()
    {
        return this.startTime;
    }

    /**
     *
     * @param time
     * Set the time of the event item
     */
    public void setTime(LocalTime time)
    {
        this.startTime = time;
    }
    
    /**
     *
     * @return String of the event item details
     */
    @Override
    public String toString()
    {
        return this.startTime + ": "+this.title;
    }
    
}
