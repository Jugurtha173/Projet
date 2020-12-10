package projet;

import org.junit.Test;
import static org.junit.Assert.*;

public class DoorIT {

    private Room r1, r2;
    private Door d;
    
    @Test
    public void testDoor(){
        boolean state = false;
        d = new Door();
        assertEquals(d.isState(),state);
        assertFalse(d.isState());
    }    
      
    @Test
    public void testIsState(){
       r1 = new Room("Room");   
       r2 = new Room("Room2");   
       d = new Door(false);
       r1.addDoor(d);
       r2.addDoor(d);
       assertFalse(d.isState());
       d.open();
       assertTrue(d.isState());
    }
    
}
