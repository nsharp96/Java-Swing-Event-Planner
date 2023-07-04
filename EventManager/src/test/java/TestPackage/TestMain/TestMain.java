/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPackage.TestMain;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import ku.pii2020.eventmanager.model.Event;
import ku.pii2020.eventmanager.model.EventItems;
import ku.pii2020.eventmanager.model.EventManager;
import ku.pii2020.eventmanager.model.Organiser;

/**
 *
 * @author Natalie Sharp - K2041275
 */
public class TestMain 
{

    /**
     *
     * @param args
     */
    public static void main(String[] args)
    {
        //P2MOD:  Test to check data model.
        System.out.println("P2MOD: Test to ensure data model and set and get attirbutes");
        System.out.println(TestMain.P2MODTest()+System.lineSeparator());
        
        //P2R1:  Test to ensure EventManager is instantiated
        System.out.println("P2MOD: Test to ensure instantiation of EventManager" );
        System.out.println(TestMain.P2MODTest()+System.lineSeparator());
        
        //P2R2: Add Events to the EventManager.
        System.out.println("P2r2: Test to ensure new event is added and other cases" );
        TestMain.P2R2Test();
        
        //P2R3: Delete Events from the EventManager.
        System.out.println("P2r3: Test to ensure events are deleted and other cases" );
        TestMain.P2R3Test();
        
        //P2R4: Add Items to the EventManager
        System.out.println("P2R4: Test to ensure events are added to the EventManager" );
        TestMain.P2R4Test();
        
        //P2R5: Delete Items from the Event Manager
        System.out.println("P2R5: Test to ensure events are deleted from the EventManager" );
        TestMain.P2R5Test();
        
        //P2R6: Associate a Organiser with an event
        System.out.println("P2R6: Test cases for associate Organiser with an event" );
        TestMain.P2R6Test();
        
        //P2R7: Load Events/Items/Organisers from a provided file
        System.out.println("P2R7: Load Events/Items/Organisers from a file" );
        TestMain.P2R7Test(); 
        
        //P2R8: Add agenda items to an event
        System.out.println("P2R8: Add agenda items to an event" );
        TestMain.P2R8Test();
        
        //P2R9: Edit details of an event
        System.out.println("P2R9: Edit details of an event" );
        TestMain.P2R9Test();
        
        //P2R10: Save a file
        System.out.println("P2R10: Save a file" );
        TestMain.P2R10Test();
    }
    
    /**
     * Method Test to ensure EventManager is instantiated
     * @return boolean if it works or not
     */
    public static boolean P2R1Test()
    {
        boolean result = false;
        //Test Instantiation of EventManager
        EventManager myOrganiser = EventManager.getInstance();
        //Add Event to organiser and retrieve to ensure it is instantiated properly
        Event hello = new Event();
        myOrganiser.addEvent(hello);
        if(myOrganiser.getEvents().contains(hello))
        {
            result = true;
        }
        return result;
    }
    
    /**
     * P2MOD:  Test to check data model.
     * @return boolean if works or not
     */
    public static boolean P2MODTest()
    {
        boolean result = false;
        //Create three users and add the the eventManager. Retrieve the information ensure the data model is implemented correctly.
        Organiser natalie = new Organiser();
        natalie.setFullName("Natalie Sharp");     
        if (natalie.getFullName()=="Natalie Sharp")
        {
            result = true;
        }
        return result;   
    }
    
    /**
     * P2R2: Add Events to the EventManager.
     * Prints out different strings of the different cases that have worked.
     */
    public static void P2R2Test()
    {
        //Checks Events can be added
        
        //Create Organiser
        Organiser nick = new Organiser();
        nick.setFullName("Nick Smith");
        
        //Create event 
        Event BlackSabbathGig = new Event();
        BlackSabbathGig.setTitle("Black Sabbath Gig");
        BlackSabbathGig.setOrganiser(nick);
        BlackSabbathGig.setLocation("Brixton Academy");
        BlackSabbathGig.setDate(LocalDate.parse("2020-11-14"));
        BlackSabbathGig.setTime(LocalTime.parse("07:00"));
        
        //Test for P2R2 - Checks events are added and not added if the object is added again.
        System.out.println("Check for size of Events in EventManager: Should be 0");
        System.out.println(EventManager.getInstance().getEvents().size());
        System.out.println("Check that event is added properly");
        System.out.println(EventManager.getInstance().addEvent(BlackSabbathGig));
        System.out.println("Add the same event: Check that it doesn't add it again");
        System.out.println(EventManager.getInstance().addEvent(BlackSabbathGig));
        System.out.println("Check for size of Events in EventManager: Should be 1 as 1 has been added");
        System.out.println(EventManager.getInstance().getEvents().size());
        System.out.println(EventManager.getInstance().getEvent(BlackSabbathGig).getDate().getDayOfWeek()+" "+ EventManager.getInstance().getEvent(BlackSabbathGig).getDate().getDayOfMonth() + " "+EventManager.getInstance().getEvent(BlackSabbathGig).getDate().getMonth() + " " + EventManager.getInstance().getEvent(BlackSabbathGig).getDate().getYear());
        System.out.println(EventManager.getInstance().getEvent(BlackSabbathGig).getTime());
        System.out.println(System.lineSeparator());
    }
            
    /**
     * P2R3: Delete Events from the EventManager.
     * Print out strings of the different cases
     */
    public static void P2R3Test()
     {
       //Test of P2R3 - Delete events 
         Event AfterDrinks = new Event();
         Event BeforeDrinks = new Event();
         System.out.println("Check for size of Events in EventManager: Should be 1");
         System.out.println("Amount of Events: "+ EventManager.getInstance().getEvents().size());
         System.out.println("Check new event is added successfully");
         System.out.println(EventManager.getInstance().addEvent(AfterDrinks));
         System.out.println("Amount of Events: " + EventManager.getInstance().getEvents().size());
         System.out.println("Check Event was successfully deleted and check size to see it has");
         System.out.println(EventManager.getInstance().deleteEvent(AfterDrinks));
         System.out.println("Amount of Events after deleting: "+ EventManager.getInstance().getEvents().size());
         System.out.println("Check to see the event was not deleted as it does not exist");
         System.out.println(EventManager.getInstance().deleteEvent(BeforeDrinks)+System.lineSeparator());
     }
    
    /**
     * P2R4: Add Items to the EventManager
     * Print out string of different cases 
     */
    public static void P2R4Test()
     {
         //Test to add Items to the EventManager
         System.out.println("Test to ensure event is added successfully");
         EventItems partyStarts = new EventItems();
         System.out.println(EventManager.getInstance().addEventItemsToEventManager(partyStarts));
         System.out.println("Test to ensure event is not added if it's already there");
         System.out.println(EventManager.getInstance().addEventItemsToEventManager(partyStarts)+System.lineSeparator());
     }
     
    /**
     * P2R5: Delete Items from the Event Manager
     * Print out different strings of the different cases
     */
    public static void P2R5Test()
     {
        EventItems e = EventManager.getInstance().getEventItems().get(0);
        System.out.println("Should print out the event item was deleted");
        EventManager.getInstance().deleteEventItemsFromEventManager(e);
        System.out.println("Should print out the event item doesn't exist");
        EventManager.getInstance().deleteEventItemsFromEventManager(e);
     }
     
    /**
     * P2R6: Associate a Organiser with an event
     * Print out strings of the different cases
     */
    public static void P2R6Test()
     {
         System.out.println("Check two of the same organiser can not be added");
         Organiser brodie = new Organiser();
         System.out.println(EventManager.getInstance().addOrganiser(brodie));
         System.out.println(EventManager.getInstance().addOrganiser(brodie));
         Event starwarsmovie = new Event();
         starwarsmovie.setTitle("Star Wars Movie");
         EventManager.getInstance().addEvent(starwarsmovie);
         Organiser wiseoldman = new Organiser();
         wiseoldman.setFullName("Larry Barry");
         EventManager.getInstance().addOrganiser(wiseoldman);
         System.out.println("Should print out association made between event and new organiser");
         System.out.println(EventManager.getInstance().associateUserToEvent(starwarsmovie, wiseoldman));
         Organiser theo = new Organiser();
         EventManager.getInstance().addOrganiser(theo);
         theo.setFullName("Theodore Bigbrains");
         System.out.println("Should print out the new association and the replacement of the old");
         System.out.println(EventManager.getInstance().associateUserToEvent(starwarsmovie, theo));
         System.out.println("Should print out the association is already the association you want");
         System.out.println(EventManager.getInstance().associateUserToEvent(starwarsmovie, theo));
         Organiser james = new Organiser();
         System.out.println("Should print out the association can't be made as the organiser doesn't exist");
         System.out.println(EventManager.getInstance().associateUserToEvent(starwarsmovie, james));
         Event jamesparty = new Event();
         System.out.println("Should print out the association can't be made as the event doesn't exist");
         System.out.println(EventManager.getInstance().associateUserToEvent(jamesparty, theo)+System.lineSeparator());
         
     }
     
    /**
     * P2R7: Load Events/Items/Organisers from a provided file
     * Print out strings of the different cases
     */
    public static void P2R7Test()
     {
         //Clear all attributes in EventManager. This will make it easier to see what has been added
         EventManager.clearOrganiser();
         //Test to ensure reads all attributes and adds
         File infile = new File("TestDoc1.csv");
         EventManager.getInstance().readFile(infile);
         //TestDoc1 - include one event with event items and an organiser
         System.out.println("Case for Check file reads and assigns attributes correctly ");
         //Print out Nick Smith
         System.out.println(EventManager.getInstance().getOrganisers().toString());
         //Print out Maddness gig organised by nick at 02 at 7pm on the 12th novemeber
         System.out.println(EventManager.getInstance().getEvents().toString());
         //Print out doors open, first band starts, maddness on and concert closes
         System.out.println(EventManager.getInstance().getEventItems().toString()+System.lineSeparator());
         
         System.out.println("Case for file not existing");
         File wrongfile = new File("doesn't exist");
         //Should print out can't find file
         EventManager.getInstance().readFile(wrongfile);
         System.out.println(System.lineSeparator());
         
         //Read file with only events, no eventitems and no organisers
         EventManager.clearOrganiser();
         System.out.println("Case for file only including events, Should print out 0, 4, 0");
         File eventfile = new File("Test2_onlyevents.csv");
         EventManager.getInstance().readFile(eventfile);
         // Print out 0 for organiser
         System.out.println(EventManager.getInstance().getOrganisers().size());
         //Print out 4 for 4 events
         System.out.println(EventManager.getInstance().getEvents().size());
         System.out.println(EventManager.getInstance().getEvents().toString());
         //Print out 0 for eventitems
         System.out.println(EventManager.getInstance().getEventItems().size()+System.lineSeparator());
         
         //Read file with only eventitems, no events and no organisers
         EventManager.clearOrganiser();
         System.out.println("Case for file only including eventitems, Should print out 0, 0, 12");
         File eventitemfile = new File("Test2_onlyeventitems.csv");
         EventManager.getInstance().readFile(eventitemfile);
         // Print out 0 for organiser
         System.out.println(EventManager.getInstance().getOrganisers().size());
         //Print out 0 for 0 events
         System.out.println(EventManager.getInstance().getEvents().size());
         //Print out 12 for eventitems
         System.out.println(EventManager.getInstance().getEventItems().size());
         System.out.println(EventManager.getInstance().getEventItems().toString()+System.lineSeparator());
         
         //Read file with only organiser, no events and no eventitems
         EventManager.clearOrganiser();
         System.out.println("Case for file only including organiser, Should print out 4, 0, 0");
         File organiserfile = new File("Test2_onlyorganisers.csv");
         EventManager.getInstance().readFile(organiserfile);
         // Print out 4 for organiser
         System.out.println(EventManager.getInstance().getOrganisers().size());
         //Print out 0 for 0 events
         System.out.println(EventManager.getInstance().getEvents().size());
         //Print out 0 for eventitems
         System.out.println(EventManager.getInstance().getEventItems().size());
         System.out.println(EventManager.getInstance().getOrganisers().toString()+System.lineSeparator());
     }
     
    /**
     * P2R8: Add agenda items to an event
     * Print out strings of the different cases
     */
    public static void P2R8Test()
     {
         //Test to ensure eventitem is added to event
         Event spider = new Event();
         spider.setTitle("Spiderman Movie");
         spider.setTime(LocalTime.parse("07:00"));
         spider.setDate(LocalDate.parse("2022-11-13"));
         spider.setLocation("Kingston Odean");
         EventManager.getInstance().addEvent(spider);
         EventItems getThere = new EventItems();
         getThere.setTime(LocalTime.parse("07:00"));
         getThere.setTitle("Arrive at cinema");
         EventItems nosuchevent = new EventItems();
         nosuchevent.setTime(LocalTime.parse("07:00"));
         nosuchevent.setTitle("nothing");
         EventManager.getInstance().addEventItemsToEventManager(nosuchevent);
         EventItems watchmovie = new EventItems();
         watchmovie.setTime(LocalTime.parse("08:00"));
         watchmovie.setTitle("Movie started");
         System.out.println(EventManager.getInstance().addEventItemsToEvent(spider, getThere));
         System.out.println(EventManager.getInstance().addEventItemsToEvent(spider, watchmovie));
         //Test to ensure eventitem was not added as it already exists
         System.out.println(EventManager.getInstance().addEventItemsToEvent(spider, getThere));
         //Test to ensure eventitem was not added as event does not exist
         Event ghost = new Event();
         System.out.println(EventManager.getInstance().addEventItemsToEvent(ghost,getThere)+System.lineSeparator());
         
     }
     
    /**
     * P2R9: Edit details of an event
     * Print out strings of the different test cases
     */
    public static void P2R9Test()
     {
         //Test to ensure event does not exist
         Event mathClass = new Event();
         Organiser beryl = new Organiser();
         beryl.setFullName("Beryl Smith");
         EventManager.getInstance().addOrganiser(beryl);
         LocalDate eventdate = LocalDate.parse("2021-11-23");
         LocalTime eventtime = LocalTime.parse("07:00");
         System.out.println(EventManager.getInstance().editEvent(mathClass,"hello", beryl, eventdate, eventtime, "University"));
                 
         //Test to ensure event details have been changed
         mathClass.setDate(LocalDate.parse("2022-08-23"));
         mathClass.setLocation("Brighton");
         mathClass.setOrganiser(beryl);
         mathClass.setTime(LocalTime.parse("07:00"));
         mathClass.setTitle("Math Class");
         EventManager.getInstance().addEvent(mathClass);
         Organiser dave = new Organiser();
         dave.setFullName("Dave Mann");
         EventManager.getInstance().addOrganiser(dave);
         LocalDate changedate = LocalDate.parse("2021-09-11");
         LocalTime changetime = LocalTime.parse("04:00");
         
         System.out.println(EventManager.getInstance().editEvent(mathClass, "Geography class",dave , changedate, changetime, "Bluesburry"));
         
	//Test to ensure only the title of the event is changed.
        System.out.println(EventManager.getInstance().editEvent(mathClass,"Boxing class",null,null,null ,null));
	//Test to ensure only the organiser of the event is changed.
        Organiser susan = new Organiser();
        susan.setFullName("Susan Jones");
        System.out.println(EventManager.getInstance().editEvent(mathClass,null,susan ,null,null,null));
	//Test to ensure only the date of the event is changed.
        System.out.println(EventManager.getInstance().editEvent(mathClass,null,null ,eventdate,null,null));
	//Test to ensure only the time of the event is changed.
        System.out.println(EventManager.getInstance().editEvent(mathClass,null,null ,null,eventtime,null));
	//Test to ensure only the location of the event is changed.
        System.out.println(EventManager.getInstance().editEvent(mathClass,null,null ,null,null,"My House")+System.lineSeparator());

     }
 
    /**
     *  P2R10: Save a file
     *  Print out strings of the different test cases
     */
    public static void P2R10Test()
      {
          System.out.println(EventManager.getInstance().getOrganisers());
          System.out.println(EventManager.getInstance().getEvents());
          System.out.println(EventManager.getInstance().getEventItems());
          File newFile = new File("newFile.csv");
          EventManager.getInstance().saveFile(newFile);
          System.out.println("Event Manager Cleared. Load the saved file");
          System.out.println("Should print the same list of organisers, events and eventitems as shown above");
          EventManager.clearOrganiser();
          File readme = new File("newfile.csv");
          EventManager.getInstance().readFile(readme);
          System.out.println(EventManager.getInstance().getOrganisers());
          System.out.println(EventManager.getInstance().getEvents());
          System.out.println(EventManager.getInstance().getEventItems());
          
      }
}
