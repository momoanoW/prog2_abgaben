package Wuerfelspiel;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Spielablauf {
    private static int numberOfPlayers; // global, damit ich sie in verschiedenen Methoden benutzen kann
    public static String[] names;
    public static int wuerfelZahl;
    public static int punkteVersuch;

    public static int getPunkteVersuch() {
        return punkteVersuch;
    }

    //1. Objektmethode: findet Spieleranzahl heraus
    public int spielerAnzahlEingabe() {
        Scanner sc = new Scanner(System.in); // Scanner-Objekt zum Einlesen von der Konsole erstellen
        numberOfPlayers = 0; // Variable zur Speicherung der eingelesenen Zahl
        boolean inputOk = false; // Variable zur Überprüfung der korrekten Eingabe

        // Wiederhole, bis eine korrekte Eingabe erfolgt ist
        do {
            System.out.print("Gib die Anzahl der Spieler ein: "); // Eingabeaufforderung
            try {
                numberOfPlayers = sc.nextInt(); // Versuche, eine ganze Zahl einzulesen
                inputOk = true; // Setze inputOk auf true, wenn die Eingabe erfolgreich war
            } catch (InputMismatchException e) {
                // Wenn eine Eingabeaufforderung nicht erfolgreich war, setze die Fehlermeldung und ignoriere die falsche Eingabe
                System.out.print("Bitte gib eine Zahl ein!");
                sc.next(); // Überspringe die fehlerhafte Eingabe
            }
        } while (!inputOk); // Wiederhole, solange die Eingabe nicht korrekt ist
        return numberOfPlayers; // Gib die eingelesene Zahl zurück
    }

    //2. Objektmethode: findet Namen heraus
    public String[] spielerNameEingabe(int numberOfPlayers) {
        Scanner sc = new Scanner(System.in);
        names = new String[numberOfPlayers];
        boolean inputOk = false; // Variable zur Überprüfung der korrekten Eingabe

        for (int i = 0; i < numberOfPlayers; i++) {
            do {
                System.out.print("Gib den Namen für Spieler " + (i + 1) + " ein: "); // Eingabeaufforderung
                try {
                    names[i] = sc.nextLine(); // Versuche, Strings einzulesen
                    inputOk = true; // Setze inputOk auf true, wenn die Eingabe erfolgreich war
                } catch (InputMismatchException e) {
                    // Wenn eine Eingabeaufforderung nicht erfolgreich war, setze die Fehlermeldung und ignoriere die falsche Eingabe
                    System.out.print("Bitte gib einen Namen, bestehend aus Klein- und Grossbuchstaben, ein!");
                    sc.next(); // Überspringe die fehlerhafte Eingabe
                }
            } while (!inputOk); // Wiederhole, solange die Eingabe nicht korrekt ist
        }
        return names;
    }

    //3. Objektmethode: erstellt Spieler-Objekte anhand der Eingabewerte
    public void spielerErstellen(int numberOfPlayers, String[] names) {
        Spieler[] spielerListe = new Spieler[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            spielerListe[i] = new Spieler(names[i]);
        }
    }

    //4. Objektmethode: erwürfelt zufälligen Wert im bound-Bereich 1-6
    public static int wuerfeln() {
        Random r = new Random();
        wuerfelZahl = r.nextInt(6) + 1;
        return wuerfelZahl;
    }

    //5. Objektmethode: regelt Ablauf eines Versuchs
    public int versuch(int wuerfelZahl) {
        punkteVersuch = 0;
        Spieler[] spielerListe = new Spieler[numberOfPlayers];
        for (int i = 0; i < this.spielerListe.length; i++) {
            while (spielerListe[i].getPunkteStand() <= 20 && wuerfelZahl > 0) { //solange Punktestand unter 20 und Spieler nicht abbricht
                if (wuerfelZahl == 6) {
                    punkteVersuch = 0;
                }
                if (wuerfelZahl <= 6) {
                    punkteVersuch = wuerfelZahl;
                }
            }
        }
        return punkteVersuch;
    }
}



