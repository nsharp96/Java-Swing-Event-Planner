/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.eventmanager.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import ku.pii2020.eventmanager.model.Event;
import ku.pii2020.eventmanager.model.Organiser;

/**
 *
 * @author Natalie Sharp - K2041275
 */
public class RightSideBottom extends JPanel 
{
    private JPanel centerpanel = new JPanel(new BoxLayout(this,BoxLayout.Y_AXIS));
    private JScrollPane scrollPane = new JScrollPane(centerpanel);
    private JButton addEventItem = new JButton("Add Event Item");
    private JButton editEventItem = new JButton("Edit Event Item");
    private JButton deleteEventItem = new JButton("Delete Event Item");
    private JButton searchItem = new JButton("Search For Event Item");
    private JButton resetSearch = new JButton("Reset Search");
    private JTextField searchItemField = new JTextField(16);
    private JCheckBox sortByTime = new JCheckBox("Sort By Time");
    private JCheckBox sortByTitle = new JCheckBox("Sort By Title");
    
    /**
     *
     */
    public RightSideBottom()
    {
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new BorderLayout());
        this.setBorder(new EmptyBorder(10, 10, 10, 10) );
        this.add(scrollPane, BorderLayout.CENTER);
        centerpanel.setBackground(Color.LIGHT_GRAY);
        centerpanel.setLayout(new BoxLayout(centerpanel, BoxLayout.Y_AXIS));
        
        Border border = new LineBorder(Color.black, 2, true);
        this.setBorder(new TitledBorder(border, "Event Items"));
        
        //Make Top Panel
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setBackground(Color.LIGHT_GRAY);
        
        JPanel searcharea = new JPanel();
        searcharea.setBackground(Color.LIGHT_GRAY);
        searcharea.add(searchItemField);
        searcharea.add(searchItem);
        searcharea.add(resetSearch);
        topPanel.add(searcharea,BorderLayout.EAST);
        this.add(topPanel, BorderLayout.NORTH);
        
        //Make Bottom button panel and sort feature
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        
        JPanel bottomSort = new JPanel();
        bottomSort.add(sortByTime);
        bottomSort.add(sortByTitle);
        ButtonGroup checkBoxGroup = new ButtonGroup();
        checkBoxGroup.add(sortByTime);
        checkBoxGroup.add(sortByTitle);
        
        JPanel bottomButton = new JPanel();
        bottomPanel.add(bottomSort, BorderLayout.NORTH);
        bottomPanel.add(bottomButton,BorderLayout.SOUTH);
        bottomButton.add(addEventItem);
        bottomButton.add(editEventItem);
        bottomButton.add(deleteEventItem);
        this.add(bottomPanel, BorderLayout.SOUTH);
        
        
    }
    
    public JButton getAddEventItem() {
        return addEventItem;
    }

    public void setAddEventItem(JButton addEventItem) {
        this.addEventItem = addEventItem;
    }
    
    public JPanel getCenterpanel() {
        return centerpanel;
    }

    public void setCenterpanel(JPanel centerpanel) {
        this.centerpanel = centerpanel;
    }
    
    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }
    
    public JButton getEditEventItem() {
        return editEventItem;
    }

    public void setEditEventItem(JButton editEventItem) {
        this.editEventItem = editEventItem;
    }
    
    public JButton getDeleteEventItem() {
        return deleteEventItem;
    }

    public void setDeleteEventItem(JButton deleteEventItem) {
        this.deleteEventItem = deleteEventItem;
    }
    
    public JButton getSearchItem() {
        return searchItem;
    }

    public void setSearchItem(JButton searchItem) {
        this.searchItem = searchItem;
    }
    
    public JTextField getSearchItemField() {
        return searchItemField;
    }

    public void setSearchItemField(JTextField searchItemField) {
        this.searchItemField = searchItemField;
    }
    
    public JButton getResetSearch() {
        return resetSearch;
    }

    public void setResetSearch(JButton resetSearch) {
        this.resetSearch = resetSearch;
    }
    
    public JCheckBox getSortByTime() {
        return sortByTime;
    }

    public void setSortByTime(JCheckBox sortByTime) {
        this.sortByTime = sortByTime;
    }

    public JCheckBox getSortByTitle() {
        return sortByTitle;
    }

    public void setSortByTitle(JCheckBox sortByTitle) {
        this.sortByTitle = sortByTitle;
    }
    
}
