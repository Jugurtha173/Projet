package projet;

import java.util.Scanner;

/**
 *
 * @author JUGURTHA
 */
public class SecretCodeDoor extends AutoLockDoor{
    
    private final int SECRET_CODE;
    
    public SecretCodeDoor(){
        super(); 
        this.SECRET_CODE = 1703;
    }
    
    public SecretCodeDoor(Room room1, Room room2) {
    	super(room1, room2);
    	this.SECRET_CODE = 1703;
    }
    
    public SecretCodeDoor(Room room1, Room room2, int code) {
    	super(room1, room2);
    	this.SECRET_CODE = code;
    }
   
    @Override
    public void open() {
    	this.unLock();    	
    }
    
    public void unLock(){
    	System.out.print("Tape the code to unlock : ");
        Scanner code = new Scanner(System.in);
        
        if(code.hasNextInt()){
	        if(code.nextInt() == this.SECRET_CODE) {
	        	super.unLock();
	        	super.open();
	        } else {
	        	System.err.println("CODE INCORRECT !!!");        	
	        }
        }
        else {
        	System.err.println("Waiting for a digit code");
        }
    }

}
