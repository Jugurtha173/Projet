package projet;

/**
 *
 * @author JUGURTHA
 */
public class AutoLockDoor extends Door {
    
    private boolean lock = true;
    
    public AutoLockDoor(){
       super(false);
    }
    
    public AutoLockDoor(Room room1, Room room2) {
    	super(room1, room2);
    }
    
    @Override
    public void open(){
        if( !(this.lock) ) {
        	super.open();
        }
    }
    
    @Override
    public void close(){
        super.close();
        this.lock = true;
    }
    
    public void unLock(){
        if( !(super.isState()))
            this.lock = false;
    }

    
}
