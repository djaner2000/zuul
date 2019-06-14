/**
 *  Dies ist die Hauptklasse der Anwendung "Die Welt von Zuul".
 *  "Die Welt von Zuul" ist ein sehr einfaches, textbasiertes
 *  Adventure-Game. Ein Spieler kann sich in einer Umgebung bewegen,
 *  mehr nicht. Das Spiel sollte auf jeden Fall ausgebaut werden,
 *  damit es interessanter wird!
 * 
 *  Zum Spielen muss eine Instanz dieser Klasse erzeugt werden und
 *  an ihr die Methode "spielen" aufgerufen werden.
 * 
 *  Diese Instanz erzeugt und initialisiert alle anderen Objekte
 *  der Anwendung: Sie legt alle Rï¿½ume und einen Parser an und
 *  startet das Spiel. Sie wertet auch die Befehle aus, die der
 *  Parser liefert, und sorgt fï¿½r ihre Ausfï¿½hrung.
 * 
 * @author  Michael Kï¿½lling und David J. Barnes
 * @version 2008.03.30
 */
package zuul;

import zuul.commands.*;
import java.util.HashMap;
import java.util.Scanner;

public class Spiel
{
	private Parser parser;
	private Spieler spieler;
	private HashMap<String, CommandFunction> commands;
	private boolean beendet;

	/**
	 * Erzeuge ein Spiel und initialisiere die interne Raumkarte.
	 */
	public Spiel()
	{
		this.beendet=false;
		this.spieler=new Spieler(null, null, this);
		raeumeAnlegen();
		parser = new Parser();
		this.commands=new HashMap<>();

		this.commands.put("go", new GoCommand(this.spieler));
		this.commands.put("help", new HelpCommand(this.parser));
		this.commands.put("look", new LookCommand(this.spieler));
		this.commands.put("status", new StatusCommand(this.spieler));
		this.commands.put("take", new TakeCommand(this.spieler));
		this.commands.put("drop", new DropCommand(this.spieler));
		this.commands.put("eat", new EatCommand(this.spieler));
		this.commands.put("quit", new QuitCommand(this));
		this.commands.put("sleep", new SleepCommand(this.spieler));
		this.commands.put("use", new UsePotionCommand(this.spieler));
	}

	private void raeumeAnlegen()
	{
		this.spieler.geheZu(new WorldGenerator().getStartRaum());  // das Spiel startet auf der Lichtung
	}

	public void quit() {
		this.beendet=true;
	}     
	/**
	 * Die Hauptmethode zum Spielen. LÃ¤uft bis zum Ende des Spiels
	 * in einer Schleife.
	 */
	public void spielen()
	{
		willkommenstextAusgeben();

		// Die Hauptschleife. Hier lesen wir wiederholt Befehle ein
		// und fÃ¼hren sie aus, bis das Spiel beendet wird.

		while (! beendet) {
			Befehl befehl = parser.liefereBefehl();
			verarbeiteBefehl(befehl);
		}
		System.out.println("Danke fÃ¼r dieses Spiel. Auf Wiedersehen.");
	}

	/**
	 * Einen BegrÃ¼ÃŸungstext fÃ¼r den Spieler ausgeben.
	 */
	private void willkommenstextAusgeben()
	{
		System.out.println();
		System.out.println("Willkommen zu Zuul!");
		System.out.println("Entdecke die Labyrinth von Zuul. Doch Vorsicht, Ã¼berall lauern Gefahren!");
		System.out.println("Das Ziel ist der Ausgang dieser Welt zu finden!");
		System.out.println("Tippen sie 'help', wenn Sie Hilfe brauchen.");
		System.out.println();
		raumInfoAusgeben();
	}

	private void verarbeiteBefehl(Befehl befehl)
	{
		if(befehl.istUnbekannt()) {
			System.out.println("Ich weiss nicht, was Sie meinen...");

		} else {
			String befehlswort = befehl.gibBefehlswort();
			this.commands.get(befehlswort).execute(befehl);
		}
	}

	private void raumInfoAusgeben() {
		System.out.println(this.spieler.getAktuellerRaum().getLangeBeschreibung());
	}
	}
	
	
	
	
	
	/**
	public void run()
    {
        Scanner readName = new Scanner(System.in);
        System.out.print("Ihre Name lautet: ");
        String userName = readName.nextLine();

        Scanner readRolle = new Scanner(System.in);
        System.out.print("Wählen Sie ihre Rolle (Fighter, Ranger, Arcanist): ");
        String userRole = readRolle.nextLine();
        while(true){
            if(userRole.equalsIgnoreCase("Fighter") || userRole.equalsIgnoreCase("Ranger") || userRole.equalsIgnoreCase("Arcanist")){
                break;
            }else{
                System.out.println("Wählen Sie ihre Rolle...");
                readRolle = new Scanner(System.in);
                System.out.print("Wählen Sie ihre Rolle (Fighter, Ranger, Arcanist): ");
                userRole = readRolle.nextLine();
            }
        }
        System.out.println("");
        Spieler spieler = new Spieler(userName, userRole, null);

    }
    public String attack(Monster one, Monster two){
        int a = one.attack(two);
        return one.getName() + " greift " + two.getName()+ " an für " + a + " dmg.";
    }

    public void battle(Spieler one, Monster two){
        System.out.println(one);
        System.out.println(two);

        while(true){
            Scanner readChoice = new Scanner(System.in);
            System.out.print("\nWas wollen Sie tun (Attack, Run, Status, Use Potion): ");
            String userChoice = readChoice.nextLine();
            while(true){
                if(!userChoice.equalsIgnoreCase("Status") && !userChoice.equalsIgnoreCase("Run") && !userChoice.equalsIgnoreCase("Attack") && !userChoice.equalsIgnoreCase("Use Potion")){
                    System.out.println("Choose a valid choice");
                    readChoice = new Scanner(System.in);
                    System.out.print("\nWas wollen Sie tun (Attack, Run, Status, Use Potion): ");
                    userChoice = readChoice.nextLine();
                }else{
                    break;
                }
            }

            if(userChoice.equalsIgnoreCase("Use Potion")){
                System.out.println(one.useHealthPotion());
                System.out.println(one.status());

                continue;
            }

            if(userChoice.equalsIgnoreCase("Run")){
                int run = (int)(Math.random() * 100 + 1);
                if(run >= 50){
                    System.out.println("Sie laufen.");
                    break;
                }else{
                    System.out.println("Sie können nicht laufen.");

                }

            }else if(userChoice.equalsIgnoreCase("Attack")){
                System.out.println(attack(one, two));
                System.out.println(two.status());

            }
            if(!two.isDead()){
                System.out.println(attack(two, one));
                System.out.println(one.status());

                if(one.isDead()){
                    System.out.println("Sie sind tot!");
                    break;
                }
            }else{
                System.out.println("Sie haben " + two.getName() + "getötet \n");
                System.out.println("Sie haben " + one.gainXp(two) + " exp gewonnen");
                if(one.checkXp()){
                    System.out.println("LEVEL UP! Ihre HP wird restoriert!");
                    System.out.println("Sie haben " + one.getXp() + " exp");
                }else{
                    System.out.println("Sie haben " + one.getXp() + " exp");
                }
                System.out.println(one + "\n");
                break;
            }
        }
    }
                public void scene(Spieler one, String description){
                    System.out.println(one.getName() + " arrives at " + description);

                    int x = (int)(Math.random() * 3 + 1);

                    for(int i = 0; i < x; i++){
                        if(one.isDead()){
                            break;
                        }
                        Enemy randEnemy = new Enemy(one.getLevel());
                        System.out.println("\nYou encounter " + randEnemy.getName() + " the " + randEnemy.getRole());
                        battle(one, randEnemy);
                    }

                }
            }
        
    */
   