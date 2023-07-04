/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.eventmanager.model;

/**
 *
 * @author Natalie Sharp - K204175
 */
public class Organiser 
{
    //Attributes
    private String fullName;
    
    //Constructor

    /**
     *
     */
    public Organiser()
    {
        
    }
    
    //Getter and Setter for first name

    /**
     *
     * @return String of the organisers full name
     */
    public String getFullName()
    {
        return this.fullName;
    }

    /**
     *
     * @param name
     * Sets the organisers full name
     */
    public void setFullName(String name)
    {
        this.fullName = name;
    }
    
    /**
     *
     * @return String of all the organisers details
     */
    @Override
    public String toString()
    {
        String result;
        result = this.getFullName();
        return result;   
    }
}
