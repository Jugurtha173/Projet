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
	
	public void removeCharacter(Character character) {
		this.characters.remove(character);
	}
	
	public void addGurad(Enemy guard, Door door) {
		this.addCharacter(guard);
		door.guard = guard;
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
	
	public List<Character> getCharacters(){
		return this.characters;
	}
	
	@Override
	public String toString() {
		
		return "Your are in the " + this.name + "\n";
	}
    
	public String descriptif() {
		
		String detail = this.toString() + "\n";
		// lister les objets
		for (Object object : objects) {
			detail += "there's a " + object.toString() + " here\n" ;
		}
		
		// lister les personnages
		for (Character perso : characters) {
			// sauf le hero (on sait déjà qu'il est là)
			if(!(perso instanceof Hero)) {
				// si il est mort on affiche son cadavre
				if(!(perso.isAlive)) detail += "OH ! The dead body of ";
				
				detail += perso.toString() + " is here, " ;
				
			}
			
		}
		
		// lister les portes
		for (Door door : doors) {
			detail  += "there's a door to "
					+ ( door.room[0] != this ? door.room[0].name : door.room[1].name  ) + "\n" ;
			System.out.println(door.toString());
		}
		
		return detail;
	}
	
}
