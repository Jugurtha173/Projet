package projet;

	public abstract class Object {
	
	private String name;
	private int healthEffect = 0;
			
	public Object(String name) {
		this.name = name;
	}
	
	public Object(String name, int healthEffect) {
		this(name);
		this.healthEffect = healthEffect;
	}
	
	public int getHealthEffect() {
		return healthEffect;
	}

	@Override
    public String toString() {
    	return this.name;
    }

    public abstract String descriptif();
	    
    public abstract void use(Character c);

}
