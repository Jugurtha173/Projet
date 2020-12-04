package projet;

public interface Talkable {
	// Speech des personnages
	public static String speechOfLisa1 = ""
			+ "-Lisa : Hello Dad, im learning new language called : KABYLE\n"
			+ "-Homer : Oh... Good my sweety\n ";
	
	public static String speechOfLisa2 = "Wait...What, you said KABYLE ?\n"
			+ "-Lisa : Yes why ?\n"
			+ "-Homer : I have This parchment...\n "
			+ "Can you please look at it and tell if you can read it\n"
			+ "-Lisa : Oh... I see, Yes it's written in KABYLE, and i understand what it says\n "
			+ "It's the code of the locked door to go to 'Production', so it says :\n";
	public static String speechOfLisa3 = "I have to go, I'm hungry, LOVE you";

	/***************************************************************************************************/
	
	public static String speechOfBurns1 = ""
			+ "-Burns : Hm hm hm, Homer !\n"
			+ " What are you doing here ?\n"
			+ "-Homer : I came for my DONUT, give it to me !\n"
			+ "-Burns : Hmmmmm, the donut is in this safety deposit box, and I can give it to you...\n"
			+ "-Homer : Oh... Really, give me the code to unlock the door ?\n"
			+ "-Burns : OK, But before, I need an answer for the question I asked\n"
			+ "-Homer : Which question ? you didn't ask me anything\n"
			+ "-Burns : NOT YOU\n I'm talking to...\n"
			+ "------------ Samuel PELTIER ------------\n\n"
			+ "-Homer : Oh, yes I think he's in the B24"
			+ "-Burns : NON !!! this is Tahiti Bob, you mix everything, Leave us alone Homer\n\n\n\n"
			+ "-Burns : Hello Samuel, Hope your well, i know it's not easy with the lockdown\n"
			+ "Anyway, you want the code ?\n"
			+ "         you have to to give me a satisfying answer to my question\n"
			+ "         And my question is\n"
			+ "how much will you rate (on 20) the members for this project ?\n"
			+ "-Samuel : hmmmm interessant !, il me demandent carrement quelle note je vais leur donner\n"
			+ "          Bon, je vais saisir des valeurs entre 0 et 20 pour voir ce qu'ils me reserve\n";
	
	public static String speechOfBurns2 = "-Burns : Ha ha ha , EXCELLENT !\n"
			+ "          Thank you... The code of the door is\n"
			+ "          '1703'\n"
			+ "          You can go ! EXCELLENT";
	public static String speechOfBurns3 = "I have to go, I'm hungry, LOVE you";
	
	
	
	
	
	
	
	public void talkTo(Talkable t);
}
