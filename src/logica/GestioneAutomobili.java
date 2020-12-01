
package logica;

import classi.Automobile;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import gestionefile.Lettura;    
import java.util.Collections;

public class GestioneAutomobili {
    static String nomeFile = "penis.txt";
    public static void Scritturafile ( Automobile auto, String sep){
        String riga = "";
        riga= auto.getMarca()+sep+auto.getModello()+sep+auto.getAnno_presentazione()+sep+auto.getCosto();
        
        try{
           gestionefile.Scrittura.Scrivi(riga ,nomeFile, true); 
        }
       catch (Exception ex){
           System.out.println("ERRORESCRITTURA");
       }
        
    }
    public static ArrayList<Automobile> Letturafile( String sep){
        ArrayList<Automobile> Automobili= new ArrayList<Automobile>();
       
        try{
          ArrayList<String> Stringhe = new ArrayList<String>();
          for(int i=0; i<gestionefile.Lettura.Letturalista(nomeFile).size(); i++){
          Stringhe.add(gestionefile.Lettura.Letturalista(nomeFile).get(i));
          }
          /*Collections.copy(Stringhe,gestionefile.Lettura.Letturalista());*/
          for(int i=0; i<Stringhe.size(); i++){
              String[] vet_stringa = Stringhe.get(i).split(sep);
               Automobile auto= new Automobile(vet_stringa[0],vet_stringa[1],Integer.parseInt(vet_stringa[2]),Integer.parseInt(vet_stringa[3]));
               Automobili.add(auto);
          }
          return Automobili;
        }
        catch (Exception ex){
           System.out.println("ERRORELETTURAFILE"); 
          
        }
        
        return Automobili;
    }
}
