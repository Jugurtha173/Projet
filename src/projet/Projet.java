package projet;


public class Projet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
    	NuclearCenter nc = new NuclearCenter();
    	nc.start();
        
    }
    
    public static void print(String s) {
    	for(int i = 0; i < s.length(); i++) {
    		System.out.print(s.charAt(i));
    		try { Thread.sleep(5);}
    		catch (InterruptedException e) {}
    	}
    	System.out.println();
    }
    
}
