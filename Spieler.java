package zuul;

import java.util.ArrayList;
import java.util.Scanner;

public class Spieler extends Monster {

    private Raum aktuellerRaum;
    private int tragkraft;
    private ArrayList<Gegenstand> gegenstaende;
    private int hp;
    private Spiel spiel;
    public int xp;
    private int hpPotion = 3;

    public Spieler(String name, String rolle, Spiel spiel) {
    	super(name, rolle);
        this.gegenstaende=new ArrayList<>();
        this.tragkraft = 30;
        this.spiel= spiel;
        this.level = 1;
        this.curHp = 11;
    }    
    


	public int ermittleGewicht() {
        int gesamtgewicht=0;

        // this.gegenstaende wird durchlaufen
        // Jeder Gegenstand in der Liste wird einmal
        // in der Variablen g abgespeichert
        for(Gegenstand g: this.gegenstaende) {
            // a = a + b oder a+=b
            gesamtgewicht += g.getGewicht();
        }
        return gesamtgewicht;
    }

    /**

     *
     * Dieser Gegenstand sollte dann im aktuellen Raum
     * gesucht werden (Methode dafür erstellen!).
     * Sofern dieser Gegenstand mit diesem Namen
     * existiert und sofern die Tragkraft es zulässt,
     * wird dieser Gegenstand aufgenommen.
     *
     * Das bedeutet natürlich, dass der Raum diesen
     * Gegenstand dann nicht mehr haben kann
     * (Methode dafür erstellen!).
     *
     * Die Methode gegenstandAufnehmen() liefert dann
     * true oder false zurück, je nachdem ob es
     * geklappt hat oder nicht.
     */
    public boolean gegenstandAufnehmen(String name) {
        Gegenstand gesucht=this.aktuellerRaum.sucheGegenstand(name);
        if(gesucht==null) {
            return false;
        } else {
            if(ermittleGewicht()+gesucht.getGewicht()<=this.tragkraft) {
                this.gegenstaende.add(gesucht);
                this.aktuellerRaum.entferneGegenstand(gesucht);
                this.hp--;
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean gegenstandAblegen(String name) {
        for(Gegenstand g: this.gegenstaende) {
            if(g.getName().equalsIgnoreCase(name)) {
                this.gegenstaende.remove(g);
                this.aktuellerRaum.gegenstandAblegen(g);
                return true;
                // Methode wird abgebrochen (damit auch die Schleife)
            }
        }
        // Falls das hier erreicht wird, wurde der Gegenstand
        // nicht gefunden
        return false;
    }

    public String zeigeStatus() {
    	System.out.println("Ich habe " + this.curHp + " Health");
    	String erg="Ich kann insgesamt ";
        erg+=this.tragkraft + "kg tragen\n";
        for(Gegenstand g: this.gegenstaende) {
            erg+=" - " + g.getName() + " " + g.getGewicht()+"kg\n";
        }
        erg+=this.tragkraft-ermittleGewicht() + "kg kann ich noch tragen!";
        return erg;
    }

    public void geheZu(Raum raum) {
        this.aktuellerRaum=raum;
        this.curHp--;
    }

    public Raum getAktuellerRaum() {
        return aktuellerRaum;
    }

    public void essen(String name) {
        for(Gegenstand g: this.gegenstaende) {
            if(g.getName().equalsIgnoreCase(name)) {
                // Ist g ein Objekt vom Typ Essen
                if(g instanceof Essen) {
                    Essen e=(Essen)g;
                    this.tragkraft+=e.getBonus();
                    this.gegenstaende.remove(g);
                    this.curHp+=e.getHp();
                    return;
                }
            }
        }
    }
    
    public void hunger() {
    	if (curHp<=0) {
    		System.out.println("Sie sind tot, Game Over!");
    		 this.spiel.quit();
    	}
    }
    
    public void sleep() {
        System.out.println("Ich schlaf dann mal");
        curHp++;

    }
    
    
    
    
    /*
public String useHealthPotion(){
    if(hpPotion >= 1 ){
        this.setCurHp(this.getCurHp() + 25);
        hpPotion--;
        return hpPotion + " potions.";
    }else{
        return "Keine Potions mehr.";
    }
}

public int gainXp(Monster other){
    int x = other.getLevel();
    int gainedXp = x * (int)(Math.random() * (60 - 21) + 20);
    xp += gainedXp;
    return gainedXp;
}

public boolean checkXp(){
    if(xp >= level * 40){
        xp = xp - (level  * 40);
        levelUp();

        return true;
    }else{
        return false;
    }
}
public String status(){
    return name + " hat " + curHp + "/" + maxHp + " HP.";
}
public String getXp(){
    return xp + "/" + (level * 40);
}

//Stats
public void rollStats(){
    int hp = 0;
    int att = 0;
    switch(rolleToNumber()){
        case 1: hp = 16; att = 10; break;
        case 2: hp = 13; att = 13; break;
        case 3: hp = 12; att = 14; break;
    }
    maxHp = (roll(6) + hp);
    maxAtt = (roll(6) + att); 
    minAtt = (maxAtt - 3); 

}

private int roll(int sides){
    int aRoll = (int)(Math.random() * sides + 1);
    return aRoll;
}
//Waechelt die Rolle zu einer Zahl

private int rolleToNumber(){
    if(rolle.equalsIgnoreCase("Fighter")){
        return 1;
    }else if(rolle.equalsIgnoreCase("Ranger")){
        return 2;
    }else if(rolle.equalsIgnoreCase("Arcanist")){
        return 3;
    }else{
        return 0;
    }
}
//coding des LevelUp mit modifiers aufs Rolle basiert
public void levelUp(){
    level++;
    int hp = 0;
    int att = 0;
    switch(rolleToNumber()){
        case 1: hp = 24; att = 14; break;
        case 2: hp = 19; att = 19; break;
        case 3: hp = 16; att = 22; break;

    }
    maxHp += (hp * Math.random()/2 + .7);
    maxAtt += (att * Math.random()/2 + .7);
    minAtt = maxAtt - 3;
    this.curHp = maxHp;

}
*/
}  