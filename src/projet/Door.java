package projet;

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
        String color = ANSI_RED;
        if(this.isState())
            color = ANSI_GREEN;
        return "porte " + this.getClass().getSimpleName() + "[etat = " + color + this.isState() + ANSI_RESET + "]";
    }

    
    
}
