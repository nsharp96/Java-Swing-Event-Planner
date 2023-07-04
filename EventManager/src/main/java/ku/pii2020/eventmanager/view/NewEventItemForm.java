/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.eventmanager.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import ku.pii2020.eventmanager.model.Event;

/**
 *
 * @author Student
 */
public class NewEventItemForm extends JFrame
{
    //Attributes
    private JLabel eventItemTitleLabel = new JLabel("Enter Event Item Title: ");
    private JTextField eventItemTitle = new JTextField(20);
    private JLabel eventItemTimeLabel = new JLabel("Enter Event Item Time: ");
    private DateFormat timeformat = new SimpleDateFormat("HH:mm");
    private JFormattedTextField eventItemTime = new JFormattedTextField(timeformat);
    private JButton submitItemForm = new JButton("Submit Event Item");
    private EventCard eventCard;
    
    public NewEventItemForm()
    {
        setTitle("Create New Event Item");
        this.setBounds(100,100,500,200);
        setResizable(true);
        this.setVisible(true);
        
        this.setLayout(null);
        
        eventItemTitleLabel.setSize(200,20);
        eventItemTitleLabel.setLocation(20,20);
        
        eventItemTitle.setSize(190,20);
        eventItemTitle.setLocation(160,20);
        
        eventItemTimeLabel.setSize(200,20);
        eventItemTimeLabel.setLocation(20,80);
        
        eventItemTime.setSize(190,20);
        eventItemTime.setLocation(160,80);
        
        submitItemForm.setSize(150,20);
        submitItemForm.setLocation(150,120);
        
        this.add(eventItemTitleLabel);
        this.add(eventItemTitle);
        this.add(eventItemTimeLabel);
        this.add(eventItemTime);
        this.add(submitItemForm);
        
    }
    
    public JButton getSubmitItemForm() {
        return submitItemForm;
    }

    public void setSubmitItemForm(JButton submitItemForm) {
        this.submitItemForm = submitItemForm;
    }
    
    public JTextField getEventItemTitle() {
        return eventItemTitle;
    }

    public void setEventItemTitle(JTextField eventItemTitle) {
        this.eventItemTitle = eventItemTitle;
    }
    
    public JFormattedTextField getEventItemTime() {
        return eventItemTime;
    }

    public void setEventItemTime(JFormattedTextField eventItemTime) {
        this.eventItemTime = eventItemTime;
    }
    
    public EventCard getEventCard() {
        return eventCard;
    }

    public void setEventCard(EventCard eventCard) {
        this.eventCard = eventCard;
    }
    

}
