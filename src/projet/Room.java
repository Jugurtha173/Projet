package projet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JUGURTHA
 */
public class Room {
	
	private String name;
	public Boolean isLigth = true;
	private List<Door> doors = new ArrayList<>();
	private List<Object> objects = new ArrayList<>();
	private List<Character> characters = new ArrayList<>();
	
	public Room(String name) {
		this(name, true);
	}
	
	public Room(String name, Boolean light) {
		this.name = name;
		this.isLigth = light;
	}
	
 	public void lightUp() {
		this.isLigth = true;
		System.out.println("Room is now enlightened!");
	}
	
	public void addCharacter(Character character) {
		this.characters.add(character);
		character.setCurrentRoom(this);
	}
	
	public void removeCharacter(Character character) {
		this.characters.remove(character);
	}
	
	public void addEnemy(Enemy guard, Door door) {
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
			// sauf le hero (on sait deja qu'il est la)
			if(!(perso instanceof Hero)) {
				// si il est mort on affiche son cadavre
				if(!(perso.isAlive)) detail += "OH ! The dead body of ";
				
				detail += perso.toString() + " is here\n" ;
				
			}
			
		}
		
		// lister les portes
		for (Door door : doors) {
			detail  += "there's a door to "
					+ ( door.room[0] != this ? door.room[0].name : door.room[1].name  ) + "\n" ;
		}
		
		return detail;
	}
	
}
