package projet;

/**
 *
 * @author JUGURTHA
 */
public class Door {
    
    
    public Room[] room = new Room[2];
    public Enemy guard = null;
    
    private boolean state;
    
    public Door(){
        this.state = false;
    }
    
    public Door(boolean state){
        this.state = state;
    }
    
    public Door(Room room1, Room room2) {
    	this();
    	this.room[0] = room1;
    	this.room[1] = room2;
    	
    	this.room[0].addDoor(this);
    	this.room[1].addDoor(this);
    }
    
    public void open(){
        this.state = true;
    }
    
    public void close(){
        this.state = false;
    }

    public boolean isState() {
        return state;
    }
 
    @Override
    public String toString() {
        return "porte " + this.getClass().getSimpleName() + "[etat = " + this.isState() + "]";
    }

    
    
}
