package zuul.commands;

import zuul.Befehl;
import zuul.Spieler;

public class UsePotionCommand implements CommandFunction {

	private Spieler spieler;

	public UsePotionCommand(Spieler spieler) {
		this.spieler = spieler;
	}

	@Override
	public void execute(Befehl befehl) {
		this.spieler.essen(befehl.gibZweitesWort());
	}
}
