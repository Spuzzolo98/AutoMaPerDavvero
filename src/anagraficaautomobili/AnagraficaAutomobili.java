//nel main troviamo il menu, l'inserimento di un nuovo oggetto automobile e la gestione della logica
package anagraficaautomobili;

import classi.Automobile;
import java.util.ArrayList;
import java.util.Scanner;
import logica.GestioneAutomobili;

public class AnagraficaAutomobili {

    public static Automobile Inserimento() throws Exception { //se l'opzione 1 viene scelta allora si ha un inserimento di un oggetto automobile
        Scanner s = new Scanner(System.in);
        String marca = "", modello = "";
        int anno = 0, costo = 0;
        System.out.println("inserisci modello ");
        modello = s.nextLine();
        System.out.println("inserisci marca ");
        marca = s.nextLine();
        System.out.println("inserisci anno di presentazione ");
        anno = s.nextInt();
        System.out.println("inserisci costo");
        costo = s.nextInt();
        Automobile auto = new Automobile(marca, modello, costo, anno);
        return auto;
    }

    public static void ScritturaFile() {
        Automobile auto = new Automobile();
        try {
            auto = Inserimento();
        } catch (Exception ex) {
            System.out.println("Errore inserimento!");
            auto = new Automobile("errore", "errore", 344043, 344043);
        }//una variabile di tipo automobile è creata e inizializza con la funzione Inserimento
        String sep = ","; //si presuppone che nel file i vari dati dell'auto siano separati da una virgola
        GestioneAutomobili.Scritturafile(auto, sep); //vedi logica

    }

    public static ArrayList<Automobile> LetturaFile() {//questa funzione restituisce una lista di automobili a partire dal file .txt scelto
        String sep = ",";
        ArrayList<Automobile> Automobili = GestioneAutomobili.Letturafile(sep);
        return Automobili;
    }

    public static void menu() {//questa funzione esiste solo per non ripetere il menu nel main
        System.out.println("Scegli opzione:\n" + "1. Inserisci automobile\n" + "2. Leggi marche\n" + "U. Uscita");
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        menu();
        String risp = s.nextLine();
        while (!risp.equalsIgnoreCase("u")) {
            switch (risp) {
                case "1":
                    ScritturaFile();
                    break;
                case "2":
                    ArrayList<Automobile> Automobilii = LetturaFile();
                    for (int i = 0; i < Automobilii.size(); i++) {
                        System.out.println(Automobilii.get(i).getMarca());
                    }
                    break;
                default:
                    System.out.println("Opzione non valida!");
                    break;
            }
            menu();
            risp = s.nextLine();
        }
    }
}
