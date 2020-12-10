package projet;

import java.util.ArrayList;
import java.util.List;


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
	
	//allume la lumiere
 	public void lightUp() {
		this.isLigth = true;
		System.out.println("Room is now enlightened!");
	}
	
 	//ajoute un personnage
	public void addCharacter(Character character) {
		this.characters.add(character);
		character.setCurrentRoom(this);
	}
	
	//supprime un personnage
	public void removeCharacter(Character character) {
		this.characters.remove(character);
	}
	
	//attribue un garde a une porte 
	public void addEnemy(Enemy guard, Door door) {
		this.addCharacter(guard);
		door.guard = guard;
	}
	
	//ajout d'une porte a la liste de portes
	public void addDoor(Door door) {
		this.doors.add(door);
	}
	
	//ajout d'un objet a la liste d'objets
	public void addObject(Object object) {
		objects.add(object);
	}
	
	//retourne le nom
	public String getName() {
		return name;
	}
	
	//retourne la liste de portes
	public List<Door> getDoors() {
		return doors;
	}
	
	//retourne la liste d'objets
	public List<Object> getObjects() {
		return this.objects;
	}
	
	//retourne la lise de personnage
	public List<Character> getCharacters(){
		return this.characters;
	}
	
	//indique dans quelle salle sommes nous
	@Override
	public String toString() {
		
		return "Your are in the " + this.name + "\n";
	}
    
	//affiche un descriptif de la salle
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
				if(!(perso.isAlive())) detail += "OH ! The dead body of ";
				
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
