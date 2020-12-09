package projet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JUGURTHA
 */
public abstract class Character {
	protected final static int MAX_HP = 20;
	private Boolean alive = true;
	private final String name;
	private int HP;
	private Room currentRoom;
	
	
	List<Object> inventory = new ArrayList<>();
	
	public Character(String name) {
		this.name = name;
		this.HP = MAX_HP;
	}
	
	public int getHP() {
		return this.HP;
	}
	
	public void editHP(int change) {
		this.HP += change;
		if(this.HP > MAX_HP){
			this.HP = MAX_HP;
		} else if (this.HP <= 0) {
			this.alive = false;
		}
	}
	
	public Boolean isAlive() {
		return this.alive;
	}
	
	public void showHP() {
		int level = this.getHP();
		if(level < 0) level = 0;
		
		String hp = this.getName() + " HP : [";
		for (int i = 0; i < MAX_HP; i++) {
			if(i < level) {
				hp += "#";
			} else {
				hp += "-";
			}
		}
		// afficher un pourcentage
		hp += "] " + ((level * 100) / MAX_HP) + "%\n";
		System.out.println(hp);
	}
	
	public String getName() {
		return this.name;
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

	public void dropAllInventory() {
		for(Object obj : this.inventory) {
			this.getCurrentRoom().addObject(obj);
		}
		this.inventory.clear();
		
	}
	
	@Override
	public String toString() {	
		return this.name;
	}
		
	public void die() {
		if( this.getHP() <= 0) {
			System.err.println(this.getName() + " is dead !");
			this.alive = false;
			this.dropAllInventory();
		}
		
	}
}
