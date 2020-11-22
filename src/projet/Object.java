package projet;

/**
 *
 * @author JUGURTHA
 */
	public abstract class Object {
	
	private String name;
	
	public Object(String name) {
		this.name = name;
	}

	    @Override
    public String toString() {
    	return this.name;
    }

	public abstract String descriptif();
	    
    public abstract void use();

}
