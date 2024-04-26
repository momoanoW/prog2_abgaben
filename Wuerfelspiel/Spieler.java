package Wuerfelspiel;

public class Spieler {
    private String objektName;
    private int punkteStand;


    //Konstruktor Spieler-Objekt
    public Spieler(String objektName) {
        this.objektName = objektName;
        this.punkteStand = 0;
    }

    // Getter, um den Namen des Spieler-Objekts zurückzugeben
    public String getObjektName() {
        return objektName;
    }

    // Getter, um den Punktestand des Spieler-Objekts zurückzugeben
    public int getPunkteStand() {
        return punkteStand;
    }

    // Print-Methode, um den Namen des Spieler-Objekts auszugeben
    public void print() {
        System.out.println("Spieler " + objektName);
    }

    //Objektmethode, um den punkteStand des Spieler-Objekts zu errechnen
    public int punkteStandAktualisieren(int punkteVersuch) {
        punkteStand = punkteStand + punkteVersuch;
        return punkteStand;
    }

}
