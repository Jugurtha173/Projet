package projet;

import java.util.List;

public class Key extends Object {

	public Key() {
		super("Key");
	}
	
	@Override
	public String descriptif() {
		
		return this.toString()+" use it to unlock doors!";
	}

	@Override
	public void use(Character c) {
		System.out.println(this.descriptif());	
		List <Door> doors= c.getCurrentRoom().getDoors();
		for(Door door : doors) {
			if(door instanceof AutoLockDoor) {
				((AutoLockDoor) door).unLock();
			}
			
		}
	}

}
