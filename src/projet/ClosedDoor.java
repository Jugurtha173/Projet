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
        System.err.println("Porte condamnée impossible d'ouvrir");
    }
    
}
