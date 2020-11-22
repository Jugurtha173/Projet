package projet;

import java.util.List;

/**
 *
 * @author JUGURTHA
 */
public class Door {
    
    // Palette de couleurs    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    /* Pas besoin pour le moment
    //public static final String ANSI_BLACK = "\u001B[30m";
    //public static final String ANSI_YELLOW = "\u001B[33m";
    //public static final String ANSI_BLUE = "\u001B[34m";
    //public static final String ANSI_PURPLE = "\u001B[35m";
    //public static final String ANSI_CYAN = "\u001B[36m";
    //public static final String ANSI_WHITE = "\u001B[37m";
    */
    
    public Room room1 = null;
    public Room room2 = null;
    
    private boolean state;
    
    public Door(){
        this.state = false;
    }
    
    public Door(boolean state){
        this.state = state;
    }
    
    public Door(Room room1, Room room2) {
    	this();
    	this.room1 = room1;
    	this.room2 = room2;
    	
    	this.room1.addDoor(this);
    	this.room2.addDoor(this);
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

/*  public void setRoom(Room room) {
//    	if (this.room1 != null) {
//			this.room1 = room;
//		} else {
//			this.room2 = room;
//		}
//    }
*/    
    
    @Override
    public String toString() {
        String color = ANSI_RED;
        if(this.isState())
            color = ANSI_GREEN;
        return "porte " + this.getClass().getSimpleName() + "[etat = " + color + this.isState() + ANSI_RESET + "]";
    }

    public static void printDoorList(List<Door> doors){
        for(Door door : doors)
            System.out.println(door.toString());
    }
    
    
}
