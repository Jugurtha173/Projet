package projet;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HeroIT {
    
	private Hero h;
	private Room r, r2, r3;
	private Enemy e;
	private Object obj;
      
    @Before
    public void setUp() {
        h = new Hero("Homer");
        r = new Room("Room", false);      
        r.addCharacter(h);
        
        r2 = new Room("Room", true);
        obj = new Duff();

        r3 = new Room("Room");
        
        e = new Enemy("ennemie");


    }
 
    @Test
    public void testIsCurrentLight() {
        assertFalse(h.isCurrentLight());
        h.getCurrentRoom().lightUp();
        assertTrue(h.isCurrentLight());
    }

    /**
     * Test of findObject method, of class Hero.
     */
   @Test
   public void testFindObject() {
        r2.addCharacter(h);
        assertNull(h.findObject(obj.toString()));
        r2.addObject(obj);
        assertNotNull(h.findObject(obj.toString()));
   }

    /**
     * Test of findObjectInventory method, of class Hero.
     */
    @Test
    public void testFindObjectInventory() {
        r3.addObject(obj);
        r3.addCharacter(h);		
        assertNull(h.findObjectInventory(obj.toString()));
        h.take(obj.toString());
        assertNotNull(h.findObjectInventory(obj.toString()));
    }

    @Test
    public void testEnemyInRoom() {
        r3.addCharacter(h);
        assertNull(h.enemyInRoom());
        r3.addCharacter(e);
        assertNotNull(h.enemyInRoom());
    }

    
}
