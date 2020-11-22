package projet;

/**
 *
 * @author JUGURTHA
 */
public class AutoLockDoor extends Door {
    
    private boolean lock;
    
    public AutoLockDoor(){
       super(false);
       this.lock = true;
    }
    
    @Override
    public void open(){
        if( !(this.lock) )
            super.open();
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
