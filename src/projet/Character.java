package projet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JUGURTHA
 */
public abstract class Character {
	private final String name;
	private int HP;
	private final static int DEFAULT_HP = 100;
	private Room currentRoom;
	
	List<Object> inventory = new ArrayList<>();
	
	public Character(String name) {
		this.name = name;
		this.HP = DEFAULT_HP;
	}
    
	public int getHP() {
		return this.HP;
	}
	
	public void setHP(int HP) {
		this.HP = HP;
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
}
