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
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

/**
 *
 * @author Natalie Sharp - K2041275
 */
public class rightSide extends JPanel
{
    private static RightSideBottom rightbottom = new RightSideBottom();
    private static RightSideTop righttop = new RightSideTop();
    
    /**
     *
     */
    public rightSide()
    {
        setLayout(new GridLayout(2,1,10,10));
        this.setBackground(Color.LIGHT_GRAY);
        this.add(righttop);
        this.add(rightbottom);
        
    }
    
    public static RightSideTop getRighttop() 
    {
        return righttop;
    }

    public static void setRighttop(RightSideTop righttop) {
        rightSide.righttop = righttop;
    }
    
    public RightSideBottom getRightbottom() {
        return rightbottom;
    }

    //Attributes
    public static void setRightbottom(RightSideBottom rightbottom) {
        rightSide.rightbottom = rightbottom;
    }
    
    
}
