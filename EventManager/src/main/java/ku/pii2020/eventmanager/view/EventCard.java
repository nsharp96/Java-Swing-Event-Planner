/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.eventmanager.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import ku.pii2020.eventmanager.model.Event;
import ku.pii2020.eventmanager.model.EventManager;

/**
 *
 * @author Student
 */
public class EventCard extends JPanel
{
    JPanel eventPanel = new JPanel();
    private JCheckBox checker = new JCheckBox();
    private JTextArea eventTitle = new JTextArea();
    static ButtonGroup checkBoxGroup = new ButtonGroup();
    private Event event;
    private JTextArea title = new JTextArea();
    private JTextArea org = new JTextArea();
    private JTextArea date = new JTextArea();
    private JTextArea time = new JTextArea();
    private JTextArea eventlocation = new JTextArea();
    private List<EventItemCard> itemCards = new ArrayList<>();
    //Make a list of eventitems for every item in event
    
    public EventCard(Event e)
    { 
        this.event = e;
        checkBoxGroup.add(checker);
        eventPanel.setBorder(new EmptyBorder(10, 10, 10, 10) );
        this.add(eventPanel);
        eventPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        eventPanel.setLayout(new FlowLayout());
        eventPanel.setPreferredSize(new Dimension(580,50));
        eventPanel.setBackground(Color.white);
        this.add(checker);
        if (e.getTitle()!=null)
        {
           this.title.setText("Event Title: "+e.getTitle()); 
        }
        title.setBackground(Color.white);
        org.setBackground(Color.white);
        date.setBackground(Color.white);
        time.setBackground(Color.white);
        eventlocation.setBackground(Color.white);
        if (e.getOrganiser()!=null)
        {
            this.org.setText("Event Organiser: "+e.getOrganiser().getFullName());
            EventManager.getInstance().associateUserToEvent(event, e.getOrganiser());
        }
        if (e.getDate()!=null)
        {
            this.date.setText("Event Date: "+e.getDate().toString());
        }
        if (e.getTime()!=null)
        {
           this.time.setText("Event Time :"+e.getTime().toString()); 
        }
        
       if (e.getLocation()!=null)
       {
           this.eventlocation.setText("Event Location: "+e.getLocation());
       }
        
        
        
        eventPanel.add(title);
        eventPanel.add(org);
        eventPanel.add(date);
        eventPanel.add(time);
        eventPanel.add(eventlocation);
        
        
        
        
        
    }
    
    
    public JCheckBox getChecker() {
        return checker;
    }

    public void setChecker(JCheckBox checker) {
        this.checker = checker;
    }
    
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
    
    public JTextArea getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }
    
    public JTextArea getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org.setText(org);
    }
    
    public JTextArea getDate() {
        return date;
    }

    public void setDate(JTextArea date) {
        this.date = date;
    }

    public JTextArea getTime() {
        return time;
    }

    public void setTime(JTextArea time) {
        this.time = time;
    }
    
    public JTextArea getEventlocation() {
        return eventlocation;
    }

    public void setEventlocation(JTextArea eventlocation) {
        this.eventlocation = eventlocation;
    }
    
     public List<EventItemCard> getItemCards() {
        return itemCards;
    }

    public void setItemCards(List<EventItemCard> itemCards) {
        this.itemCards = itemCards;
    }
    

    
}
