package projet;

import java.util.Scanner;

/**
 *
 * @author JUGURTHA
 */
public class SecretCodeDoor extends AutoLockDoor{
    
    private final int SECRET_CODE = 1703;
    
    public SecretCodeDoor(){
        super(); 
    }
   
    @Override
    public void unLock(){
        Scanner code = new Scanner(System.in);
        if(code.nextInt() == this.SECRET_CODE)
            super.unLock();
        else
            System.err.println("CODE INCORRECT !!!");
        code.close();
    }

}
