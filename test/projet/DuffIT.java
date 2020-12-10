package projet;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DuffIT {
    
    private Duff d;
    private Room r;
    private Hero h;
    private Skate s;
    private Key k;
    
    @Before
    public void setUp() {
        d = new Duff();
        r = new Room("Salle");
        h = new Hero("Homer");
        s = new Skate();
        k = new Key();
        r.addCharacter(h);
        r.addObject(d);
        r.addObject(s);
        r.addObject(k);
    }
    
    @Test
    public void testIsEmpty() {  
        assertFalse(d.isEmpty());
        h.take(d.toString());
        h.use(d.toString());
        assertTrue(d.isEmpty());                   
    }

    @Test
    public void testGetNextFullDuff() {
        h.take(d.toString());
        h.take(s.toString());
        h.take(k.toString());
        
        assertNotNull(d.getNextFullDuff(h));
        
        h.use(d.toString());
        
        assertNull(d.getNextFullDuff(h));
    }

   
    @Test
    public void testGetNextEmptyDuff() {
        h.take(d.toString());
        h.take(s.toString());
        h.take(k.toString());
        
        assertNull(d.getNextEmptyDuff(h));
        
        h.use(d.toString());
        
        assertNotNull(d.getNextEmptyDuff(h));
    }

    
}
