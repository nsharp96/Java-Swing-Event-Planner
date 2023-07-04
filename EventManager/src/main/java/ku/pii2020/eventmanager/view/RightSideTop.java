/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.eventmanager.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import ku.pii2020.eventmanager.controller.Controller;
import ku.pii2020.eventmanager.model.Event;
import ku.pii2020.eventmanager.model.Organiser;

/**
 *
 * @author Natalie Sharp - K2041275
 */
public class RightSideTop extends JPanel
{
    private JPanel centerpanel = new JPanel(new BoxLayout(this,BoxLayout.Y_AXIS));
    private JScrollPane scrollPane = new JScrollPane(centerpanel);
    private JButton addEvent = new JButton("Add Event");
    private JButton editEvent = new JButton("Edit Event");
    private JButton deleteEvent = new JButton("Delete Event");
    private JButton submit = new JButton("Search For Event");
    private JButton resetSearch = new JButton("Reset Search");
    private static List<EventCard> cards = new ArrayList<>();
    private JTextField search = new JTextField(16);
    private JCheckBox sortByDate = new JCheckBox("Sort By Date");
    private JCheckBox sortByTitle = new JCheckBox("Sort By Title");
    private JCheckBox sortByOrganiser = new JCheckBox("Sort By Organiser");
    private JCheckBox sortByLocation = new JCheckBox("Sort By Location");

    /**
     *
     */
    public RightSideTop()
    {
        
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(10, 10, 10, 10) );
        this.add(scrollPane, BorderLayout.CENTER);
        centerpanel.setBackground(Color.LIGHT_GRAY);
        centerpanel.setLayout(new BoxLayout(centerpanel, BoxLayout.Y_AXIS));
        
        Border border = new LineBorder(Color.black, 2, true);
        this.setBorder(new TitledBorder(border,"Events"));
        
        //Top Panel
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        
        topPanel.setBackground(Color.LIGHT_GRAY);
        
        JPanel searcharea = new JPanel();
        searcharea.setBackground(Color.LIGHT_GRAY);
        searcharea.add(search);  
        searcharea.add(submit);
        searcharea.add(resetSearch);
        topPanel.add(searcharea, BorderLayout.EAST);   
        this.add(topPanel,BorderLayout.NORTH);
        
        
        //Make Bottom button panel and sort feature
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        
        JPanel bottomSort = new JPanel();
        bottomSort.add(sortByTitle);
        bottomSort.add(sortByDate);
        bottomSort.add(sortByOrganiser);
        bottomSort.add(sortByLocation);
        
        ButtonGroup checkBoxGroup = new ButtonGroup();
        checkBoxGroup.add(sortByTitle);
        checkBoxGroup.add(sortByDate);
        checkBoxGroup.add(sortByOrganiser);
        checkBoxGroup.add(sortByLocation);
        
        
        JPanel bottomButton = new JPanel();
        bottomPanel.add(bottomSort, BorderLayout.NORTH);
        bottomPanel.add(bottomButton,BorderLayout.SOUTH);
        bottomButton.add(addEvent);
        bottomButton.add(editEvent); 
        bottomButton.add(deleteEvent);
        this.add(bottomPanel, BorderLayout.SOUTH);
        
        
        
        
    }
    
    public JButton getAddEvent() {
        return addEvent;
    }

    public void setAddEvent(JButton addEvent) {
        this.addEvent = addEvent;
    }
    
    public JPanel getCenterpanel() {
        return centerpanel;
    }

    public void setCenterpanel(JPanel centerpanel) {
        this.centerpanel = centerpanel;
    }
    
    public JButton getEditEvent() {
        return editEvent;
    }

    public void setEditEvent(JButton editEvent) {
        this.editEvent = editEvent;
    }
    
    public JButton getDeleteEvent() {
        return deleteEvent;
    }

    public void setDeleteEvent(JButton deleteEvent) {
        this.deleteEvent = deleteEvent;
    }
    
    public static List<EventCard> getCards() {
        return cards;
    }

    public static void setCards(List<EventCard> cards) {
        RightSideTop.cards = cards;
    }
    
    public JButton getSubmit() {
        return submit;
    }

    public void setSubmit(JButton submit) {
        this.submit = submit;
    }
    
    public JTextField getSearch() {
        return search;
    }

    public void setSearch(JTextField search) {
        this.search = search;
    }
    
    public JButton getResetSearch() {
        return resetSearch;
    }

    public void setResetSearch(JButton resetSearch) {
        this.resetSearch = resetSearch;
    }
    
    public JCheckBox getSortByTitle() {
        return sortByTitle;
    }

    public void setSortByTitle(JCheckBox sortByTitle) {
        this.sortByTitle = sortByTitle;
    }
    
    public JCheckBox getSortByDate() {
        return sortByDate;
    }

    public void setSortByDate(JCheckBox sortByDate) {
        this.sortByDate = sortByDate;
    }
    
    public JCheckBox getSortByOrganiser() {
        return sortByOrganiser;
    }

    public void setSortByOrganiser(JCheckBox sortByOrganiser) {
        this.sortByOrganiser = sortByOrganiser;
    }
    
    public JCheckBox getSortByLocation() {
        return sortByLocation;
    }

    public void setSortByLocation(JCheckBox sortByLocation) {
        this.sortByLocation = sortByLocation;
    }
  
    
}
