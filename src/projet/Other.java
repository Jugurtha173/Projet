package projet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Other extends Character implements Talkable{

	public final List<String> speechs = new ArrayList<>();
	private String condition = "yes";
	Scanner interact = new Scanner(System.in);
	
	public Other(String name, String condition) {
		super(name);
		this.condition = condition;
		
	}
	
	public Other(String name) {
		super(name);
		
	}
	
	public void addSpeechs(String speech1, String speech2, String speech3) {
		this.speechs.add(speech1);
		this.speechs.add(speech2);
		this.speechs.add(speech3);
	}


	@Override
	public void talkTo(Talkable t) {
		NuclearCentral.print(this.speechs.get(0));
		if (this.getName().equalsIgnoreCase("Lisa")) 
			this.talkToLisa(t);
		else
		if(this.getName().equalsIgnoreCase("Mr Burns"))
			this.talkToBurns(t);
		
		else {
			if (condition.equalsIgnoreCase(interact.nextLine().split(" ")[0])) {
				NuclearCentral.print(this.speechs.get(1));
				this.dropAllInventory();
			} else {
				NuclearCentral.print(this.speechs.get(2));
			}
		}		
	}
	
	public void talkToLisa(Talkable t) {
		List<Object> inv = ((Character)t).inventory;
		for(Object obj : inv) {
			if(obj instanceof Parchment) {
				((Parchment)obj).decrypt();
				NuclearCentral.print(this.speechs.get(1));
				NuclearCentral.print(obj.descriptif());	
				return;
			}
		}
		NuclearCentral.print(this.speechs.get(2));

	}
	
	public void talkToBurns(Talkable t) {
		int note = this.interact.nextInt();
		if(note < 7) {
			System.out.println("-Burns : REALLY ? (-_-)\n"
					+ "-Samuel : OK OK je rigole je comptais pas leur mettre une salle note de toutes facons\n"
					+ "        : je vais revoir ma note a la hausse, aller\n");
			talkToBurns(t);
		} else {
			if(note >= 7 && note < 15) {
				System.out.println("-Burns : OHHHHH honestly, don't they deserve more ?\n"
								 + "        I will give you only one digit : '1***'\n"
								 + "-Samuel : Mmmmmmm, c'est vrai qu'ils meritent plus...\n");
				talkToBurns(t);
			} else {
				if(note >= 15 && note < 18) {
					System.out.println("-Burns : frankly, it touches me thank you\n"
									 + "+ \"        I will give you three digit : '170*'\n"
									 + "-Samuel : Okayyy, ils abusent un peu je trouve\n"
									 + "        Mais c'est vrai que c'est bien foutu, aller je leurs met un 20/20\n");
					talkToBurns(t);
				} else {
					System.out.println("-Burns : WAAAAAW, you're the best Samuel ;) \n"
							 		 + "        Take the code : '1703'\n"
							 		 + "-Samuel : Tres bien, finissons-en (c'etait cool GG)\n");
				}
			}
		}
	}
    
}
