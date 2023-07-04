/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.eventmanager.view;

import java.awt.Insets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import ku.pii2020.eventmanager.model.Event;
import ku.pii2020.eventmanager.model.EventManager;
import ku.pii2020.eventmanager.model.Organiser;

/**
 *
 * @author Student
 */
public class NewEditForm extends JFrame
{
    //Attributes
    private JLabel eventTitleLabel = new JLabel("Enter Title: ");
    private JTextField eventTitle = new JTextField(20);
    private JLabel eventOrganiser = new JLabel("Enter Organiser: ");
    private JComboBox eventOrganiserTitle = new JComboBox();
    private JButton add = new JButton("+");
    private JLabel eventDateLabel = new JLabel("Enter Date: ");
    private DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
    private JFormattedTextField dateTextField = new JFormattedTextField(format);
    private JLabel eventTimeLabel = new JLabel("Enter Time: ");
    private DateFormat timeformat = new SimpleDateFormat("HH:mm");
    private JFormattedTextField timeTextField = new JFormattedTextField(timeformat);
    private JLabel eventLocation = new JLabel("Enter Location: ");
    private JTextField eventLocationField = new JTextField();
    private JButton submitForm = new JButton("Edit Event");
    private Event formevent;
    
    public NewEditForm(Event e)
    {
        this.formevent = e;
        setTitle("Edit Event");
        this.setBounds(100,100,500,400);
        setResizable(true);
        this.setVisible(true);
        
        this.setLayout(null);
        
        //Title part of form
        eventTitleLabel.setSize(200,20);
        eventTitleLabel.setLocation(20,20);
        //Form for title
        eventTitle.setSize(190,20);
        eventTitle.setLocation(160,20);
        eventTitle.setText(e.getTitle());
        
        //EventLabel
        eventOrganiser.setSize(200,20);
        eventOrganiser.setLocation(20,80);
        //Loop through each organiser and add name to combo
        if (EventManager.getInstance().getOrganisers()!=null)
       {
           eventOrganiserTitle.addItem(e.getOrganiser());
           for (Organiser o: EventManager.getInstance().getOrganisers())
           {
               if (!(o.equals(e.getOrganiser())))
               {
                   eventOrganiserTitle.addItem(o);
               }   
           }       
       }
        eventOrganiserTitle.setSize(190,20);
        eventOrganiserTitle.setLocation(160,80);
        //Add add button to add organiser to eventmanager
        add.setSize(20,20);
        add.setLocation(360,80);
        add.setMargin(new Insets(1,1,1,1));
        
        //Date Form
        eventDateLabel.setSize(200,20);
        eventDateLabel.setLocation(20,140);
        //DateTextField
        dateTextField.setSize(190,20);
        dateTextField.setLocation(160,140);
        dateTextField.setText(e.getDate().toString());
        
        //Time Form
        eventTimeLabel.setSize(200,20);
        eventTimeLabel.setLocation(20,200); 
        
        //Form for time
        timeTextField.setSize(190,20);
        timeTextField.setLocation(160,200);
        timeTextField.setText(e.getTime().toString());
        
        //Add Location
        eventLocation.setSize(200,20);
        eventLocation.setLocation(20,260);
        
        //Location form
        eventLocationField.setSize(200,20);
        eventLocationField.setLocation(160,260);
        eventLocationField.setText(e.getLocation());
        
        //Set submit button
        submitForm.setSize(150,20);
        submitForm.setLocation(160,320);
        
        //Add Components
        this.add(eventTitleLabel);
        this.add(eventTitle);
        this.add(eventOrganiser);
        this.add(eventOrganiserTitle);
        this.add(add);
        this.add(eventDateLabel);
        this.add(dateTextField);
        this.add(eventTimeLabel);
        this.add(timeTextField);
        this.add(eventLocation);
        this.add(eventLocationField);
        this.add(submitForm);
        
        
    }
    
    public JButton getSubmitForm() {
        return submitForm;
    }

    public void setSubmitForm(JButton submitForm) {
        this.submitForm = submitForm;
    }
    
    public Event getFormevent() {
        return formevent;
    }

    public void setFormevent(Event formevent) {
        this.formevent = formevent;
    }
    
    public JTextField getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(JTextField eventTitle) {
        this.eventTitle = eventTitle;
    }
    
    public JComboBox getEventOrganiserTitle() {
        return eventOrganiserTitle;
    }

    public void setEventOrganiserTitle(JComboBox eventOrganiserTitle) {
        this.eventOrganiserTitle = eventOrganiserTitle;
    }
    
    public JFormattedTextField getDateTextField() {
        return dateTextField;
    }

    public void setDateTextField(JFormattedTextField dateTextField) {
        this.dateTextField = dateTextField;
    }
    
    public JFormattedTextField getTimeTextField() {
        return timeTextField;
    }

    public void setTimeTextField(JFormattedTextField timeTextField) {
        this.timeTextField = timeTextField;
    }
    
    public JTextField getEventLocationField() {
        return eventLocationField;
    }

    public void setEventLocationField(JTextField eventLocationField) {
        this.eventLocationField = eventLocationField;
    }
    
    public JButton getAdd() {
        return add;
    }

    public void setAdd(JButton add) {
        this.add = add;
    }
    
}
