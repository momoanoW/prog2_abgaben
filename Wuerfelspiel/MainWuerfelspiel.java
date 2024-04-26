package Wuerfelspiel;

public class MainWuerfelspiel {


    public static void main(String[] args) {
        Spielablauf spiel = new Spielablauf(); // Spielablauf-Objekt erstellen

        System.out.println("Spieler " + Spielablauf.names + " hat eine " + Spielablauf.wuerfeln() + " gewuerfelt." +
                "Der Punktestand verändert sich auf " + Spieler.getPunkteStand());
    }
}
}
