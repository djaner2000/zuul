package zuul;

public class Gegenstand {

    private String name;
    private String beschreibung;
    private int gewicht;
    private boolean essbar;
    private int hungerPunkte;


    public Gegenstand(String name, String beschreibung, int gewicht, int hungerPunkte) {
        this.beschreibung=beschreibung;
        this.name=name;
        this.gewicht=gewicht;
        this.hungerPunkte= hungerPunkte;
    }

    @Override
    public String toString() {
        return name + ", " + this.beschreibung +", " + this.gewicht+"kg" +", "+ this.hungerPunkte +" Hunger Punkte";
    }

    public int getGewicht() {
        return this.gewicht;
    }

    public String getName() {
        return this.name;
    }

}
