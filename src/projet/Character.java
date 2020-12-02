package projet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JUGURTHA
 */
public abstract class Character {
	protected final static int MAX_HP = 20;
	protected Boolean isAlive = true;
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
			this.isAlive = false;
		}
	}
	
	public void showHP() {
		int level = this.getHP();
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

	public void beAttacked(int damage) {
		this.HP -= damage;
	}
	
	@Override
	public String toString() {	
		return this.name;
	}
	
	public abstract void specialPower();
	
	public void die() {
		if( this.getHP() <= 0) {
			System.out.println(this.getName() + " is dead !");
			this.isAlive = false;
		}
		
	}
}
