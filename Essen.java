package zuul;

public class Essen extends Gegenstand{

    private int bonus;
    private int hungerPunkte;

    public Essen(String name, String beschreibung, int gewicht, int hungerPunkte, int bonus) {

        super(name, beschreibung, gewicht, hungerPunkte);
        this.bonus=bonus;
        this.hungerPunkte=hungerPunkte;
    }

    public int getBonus() {
        return this.bonus;
    }

	public int getHp() {
		return this.hungerPunkte;
	}
}
