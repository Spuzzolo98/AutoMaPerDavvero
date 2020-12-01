/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anagraficaautomobili;

import classi.Automobile;
import java.util.ArrayList;
import java.util.Scanner;
import logica.GestioneAutomobili;

public class AnagraficaAutomobili {

   public static Automobile  Inserimento(){
       Scanner s =new Scanner (System.in);
       String marca="", modello="";
        int anno=0, costo=0;
        System.out.println("inserisci modello ");
        modello=s.nextLine();
        System.out.println("inserisci marca ");
        marca=s.nextLine();
        System.out.println("inserisci anno di presentazione ");
        anno=s.nextInt();
        System.out.println("inserisci costo");
        costo=s.nextInt();
        Automobile auto= new Automobile(marca,modello,costo,anno);
        return auto;
   }
   public static void  ScritturaFile (){
       Automobile auto= Inserimento();
       String sep= ",";
       GestioneAutomobili.Scritturafile(auto, sep);
       
   }
   public static ArrayList<Automobile> LetturaFile(){
       String sep= ",";
        ArrayList<Automobile> Automobili=GestioneAutomobili.Letturafile(sep);
        return Automobili;
   }
   public static void menu(){
       System.out.println("Scegli opzione:\n"+ "1. Inserisci automobile\n"+ "2. Leggi marche\n"+ "U. Uscita");
   }
  
    public static void main(String[] args) {
        Scanner s = new Scanner (System.in);
        
        menu();
         String risp = s.nextLine();
        while (!risp.equalsIgnoreCase("u"))
        {
            switch (risp)
            {
                case "1":
                    ScritturaFile();
                    break;
                case "2":
                    ArrayList<Automobile> Automobilii = LetturaFile();
                    for(int i=0; i<Automobilii.size(); i++)
                    System.out.println(Automobilii.get(i).getMarca());
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
