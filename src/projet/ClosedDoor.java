package projet;

/**
 *
 * @author JUGURTHA
 */
public class ClosedDoor extends Door{
    
    
    public ClosedDoor(){
        super(false);
    }
    
    @Override
    public void open(){
        System.err.println("This door is closed, you can't open !");
    }
    
}
