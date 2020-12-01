package logica;

import classi.Automobile;
import java.util.ArrayList;
import java.util.Collections;

public class GestioneAutomobili {

    static String nomeFile = "penis.txt";

    public static void Scritturafile(Automobile auto, String sep) {
        String riga = ""; //creazione di una stringa vuota d'apppoggio
        riga = auto.getMarca() + sep + auto.getModello() + sep + auto.getAnno_presentazione() + sep + auto.getCosto(); //conversione oggetto automobile importato da ScritturaFile a stringa

        try {
            gestionefile.Scrittura.Scrivi(riga, nomeFile, true); //si scrive sul file la stringa ottenuta dalla conversione ("riga")
        } catch (Exception ex) {
            System.out.println("ERRORESCRITTURA");
        }

    }

    public static ArrayList<Automobile> Letturafile(String sep) {//questo codice ha fatto bestemmiare 3 ore due studenti, restituisce una lista di Automobili a partire da un file .txt contenente su ogni riga un'automobile in formato prestabilito
        ArrayList<Automobile> Automobili = new ArrayList<Automobile>();//creazione di una lista vuota d'appoggio di tipo Automobili

        try {
            ArrayList<String> Stringhe = (ArrayList<String>) gestionefile.Lettura.Letturalista(nomeFile).clone();
            for (int i = 0; i < Stringhe.size(); i++) { //conversione delle stringhe in oggetti Automobili
                String[] vet_stringa = Stringhe.get(i).split(sep);
                Automobile auto = new Automobile(vet_stringa[0], vet_stringa[1], Integer.parseInt(vet_stringa[2]), Integer.parseInt(vet_stringa[3]));
                Automobili.add(auto);
            }
            return Automobili;
        } catch (Exception ex) {
            System.out.println("ERRORELETTURAFILE");
        }
        return Automobili;
    }
}
