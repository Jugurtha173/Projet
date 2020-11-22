package projet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JUGURTHA
 */
public class Room {
	
	private String name;
	private List<Door> doors = new ArrayList<>();
	private List<Object> objects = new ArrayList<>();
	private List<Character> characters = new ArrayList<>();
	
	public Room(String name) {
		this.name = name;
	}
	
	public void addCharacter(Character character) {
		this.characters.add(character);
		character.setCurrentRoom(this);
	}
	
	public void addDoor(Door door) {
		this.doors.add(door);
	}
	
	public void addObject(Object object) {
		objects.add(object);
	}
	
	public String getName() {
		return name;
	}
	
	public List<Door> getDoors() {
		return doors;
	}
	
	public List<Object> getObjects() {
		return this.objects;
	}
	
	@Override
	public String toString() {
		
		return "Your are in the " + this.name + "\n\n";
	}
    
	public String descriptif() {
		
		String detail = this.toString();
		// lister les objets
		detail+= "\n";
		for (Object object : objects) {
			detail += "there's a " + object.toString() + " here\n" ;
		}
		
		// lister les personnages
		detail+= "\n";
		for (Character perso : characters) {
			if(!(perso instanceof Hero))
				detail += "OH ! " + perso.toString() + " is here\n" ;
		}
		
		// lister les portes
		detail+= "\n";
		for (Door door : doors) {
			detail += "there's a door to "
					+ ( door.room1 != this ? door.room1.name : door.room2.name  ) + "\n" ;
		}
		detail+= "\n";
		
		return detail;
	}
	
}
