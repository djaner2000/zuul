package zuul;

public class WorldGenerator {
    private Raum lichtung, waldstueck, taverne, hexenhaus, dorfplatz, kellerDerTaverne, geheimgang, taverneErsterStock, piratenHoehle, 
    cafeteria, schloss, thronsaal, kueche, turm, verlies, grab;

    public WorldGenerator() {
        this.raeumeAnlegen();
        this.setzeAusgaenge();
        this.addGegenstaende();
    }

    private void raeumeAnlegen() {
        lichtung = new Raum("auf einer Lichtung, umgeben von dunklen Tannen");
        waldstueck = new Raum("im dunklen Wald");
        taverne = new Raum("in der Taverne, mit zwielichten Gestalten an der Theke");
        hexenhaus = new Raum("im Hexenhaus");
        dorfplatz = new Raum("auf dem Dorfplatz");
        piratenHoehle = new Raum("in einer alten Piratenhï¿½hle");
        kellerDerTaverne = new Raum("im Keller der Taverne");
        geheimgang = new Raum("in einem schmalen modrigen Geheimgang");
        taverneErsterStock=new Raum("bei den den Gï¿½stezimmern im ersten Stock der Taverne");
        cafeteria=new Raum("in der Cafeteria, ein großes Menü wartet auf sie");
        schloss=new Raum("im besessen Schloss von Ainz Ooal Gown...Sie nähern sich dem Ende");
        thronsaal=new Raum("in einem Thronsaal, der Eisenthron steht vor ihr");
        kueche=new Raum("in die königliche Küche");
        turm=new Raum("in einem verlassener Turm");
        verlies=new Raum("im gruseliger Kerker");
        grab=new Raum("im der Grab von der berüchtigter Zull...sie haben den Ende entdeckt");
        
        
    }

    private void setzeAusgaenge() {

        // die Ausgï¿½nge initialisieren
        lichtung.setAusgang("down", piratenHoehle);
        lichtung.setAusgang("east", waldstueck);
        waldstueck.setAusgang("west", lichtung);
        waldstueck.setAusgang("south", dorfplatz);
        waldstueck.setAusgang("north", schloss);
        dorfplatz.setAusgang("west", hexenhaus);
        dorfplatz.setAusgang("north", waldstueck);
        dorfplatz.setAusgang("south", taverne);
        dorfplatz.setAusgang("tunnel", kueche);
        hexenhaus.setAusgang("east", dorfplatz);
        hexenhaus.setAusgang("portal", lichtung);
        hexenhaus.setAusgang("tunnel", kellerDerTaverne);
        taverne.setAusgang("north", dorfplatz);
        taverne.setAusgang("up", taverneErsterStock);
        taverne.setAusgang("down", kellerDerTaverne);
        taverne.setAusgang("west", cafeteria);
        taverneErsterStock.setAusgang("down", taverne);
        taverneErsterStock.setAusgang("window", dorfplatz);
        kellerDerTaverne.setAusgang("up", taverne);
        kellerDerTaverne.setAusgang("tunnel", hexenhaus);
        kellerDerTaverne.setAusgang("north", geheimgang);
        geheimgang.setAusgang("south", kellerDerTaverne);
        geheimgang.setAusgang("east", piratenHoehle);
        piratenHoehle.setAusgang("west", geheimgang);
        piratenHoehle.setAusgang("up", lichtung);
        cafeteria.setAusgang("east", taverne);
        schloss.setAusgang("south", waldstueck);
        schloss.setAusgang("west", thronsaal);
        schloss.setAusgang("east", kueche);
        schloss.setAusgang("up", turm);
        schloss.setAusgang("down", verlies);
        thronsaal.setAusgang("east", schloss);
        kueche.setAusgang("west", schloss);
        kueche.setAusgang("tunnel", dorfplatz);
        turm.setAusgang("down", schloss);
        verlies.setAusgang("up", schloss);
        verlies.setAusgang("down", grab);
        
    }


    private void addGegenstaende() {
        lichtung.gegenstandAblegen(new Gegenstand("Korb", "ein Weidenkorb gefÃ¼llt mit Brot", 4, 0));
        lichtung.gegenstandAblegen(new Essen("Muffin", "lecker lecker", 1, 5, 5));
        waldstueck.gegenstandAblegen(new Essen("Pilz", "ein seltsam aussehender Pilz", 1, 20, 1));
        waldstueck.gegenstandAblegen(new Essen("Beeren", "wilde Beeren", 1, 3, 3));
        taverne.gegenstandAblegen(new Gegenstand("Bierkrug", "ein leckeres dunkles Pils in einem edlen Krug", 2, 2));
        taverne.gegenstandAblegen(new Gegenstand("Teller", "ein Teller mit deftigem Wildschweinfleisch mit SoÃŸe", 5, 5));
        hexenhaus.gegenstandAblegen(new Gegenstand("Zauberstab", "ein magisches Zauberstab von magisches Holz", 2, 0));
        hexenhaus.gegenstandAblegen(new Essen("Trank", "ein geheimvolles Hexentrank", 1, -10, 0));
        dorfplatz.gegenstandAblegen(new Essen("Suppe", "eine Warme Dörfersuppe", 2, 6, 5));
        dorfplatz.gegenstandAblegen(new Essen("Tomaten", "frische Tomaten", 2, 4, 2));
        piratenHoehle.gegenstandAblegen(new Gegenstand("Schatztruhe", "eine mit Golf gefÃ¼llte Holzkiste", 40, 0));
        piratenHoehle.gegenstandAblegen(new Gegenstand("Schwert", "das Schwert des alten PiratenkapitÃ¤ns", 10, 0));
        kellerDerTaverne.gegenstandAblegen(new Essen("Wein", "altes, rotes Wein" , 3 , 3, 0));
        kellerDerTaverne.gegenstandAblegen(new Gegenstand("Morellomonicon", "ein altes Buch voll mit Geheimnisse...", 8, 0)); 
        taverneErsterStock.gegenstandAblegen(new Gegenstand("Karte", "eine karte für die Welt von Zull", 1, 0));
        taverneErsterStock.gegenstandAblegen(new Gegenstand("Beutel", "eine Lederbeutel mit Goldmünzen", 4, 0));
        cafeteria.gegenstandAblegen(new Essen("Menü", "ein 3 Gänge Menü", 3, 100, 100));
        thronsaal.gegenstandAblegen(new Gegenstand("Krone", "die silberne Krone von Cersei Lannister", 2, 0));
        thronsaal.gegenstandAblegen(new Gegenstand("Schwert", "das lange vergessene Schwert Widow's Bane von Könnig Joffrey Baratheon", 7, 0));
        kueche.gegenstandAblegen(new Essen("Gebäck", "gebackene Heidelbeertörtchen", 2, 6, 6));
        kueche.gegenstandAblegen(new Essen("Fruchte", "alte Fruchte", 2, -5, -5));
        turm.gegenstandAblegen(new Gegenstand("Spiegel", "verzauberter Spiegel", 100, 100));
        turm.gegenstandAblegen(new Essen("Apfel", "eine rote Apfel", 1, -100, 0));
        verlies.gegenstandAblegen(new Gegenstand("Gift", "kleine Phiole voll mit Wolfsbane", 1, -100));
        verlies.gegenstandAblegen(new Gegenstand("Beutel", "eine Lederbeutel mit Edelsteine", 4, 0));
    }

    public Raum getStartRaum() {
        return this.lichtung;
    }


}
