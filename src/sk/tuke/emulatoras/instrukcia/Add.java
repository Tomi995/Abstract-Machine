/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.emulatoras.instrukcia;

import emulatoras.Instrukcia;
import emulatoras.MyParserException;
import emulatoras.Zasobnik;
import emulatoras.ZasobnikException;

/**
 *
 * @author Tomi
 */
public class Add extends Instrukcia {

    /**
     * Vykonanie add funkcie
     *
     * @author Tomi
     */
    @Override
    public void vykonaj(String instrukcia) throws MyParserException {

        int prveCislo = 0;          //premenna pre prve cislo zo zasobnika
        int druheCislo = 0;            //premenna pre druhe cislo zo zasobnika
        int vysledok;                   // vysledok

        if (Zasobnik.getZasobnik().jeCislo()) {                             //overenie ci je v zasobniku cislo
            prveCislo = Integer.parseInt(Zasobnik.getZasobnik().vyber());   //ak je tak ho priradi do premennej a vyhodi zo zasobnika
        } else {
            throw new ZasobnikException("Zla hodnota v zasobniku");         //ak nie exception
        }
        if (Zasobnik.getZasobnik().jeCislo()) {                             //overenie ci je druhe cislo v zasobniku cislo 
            druheCislo = Integer.parseInt(Zasobnik.getZasobnik().vyber());  //ak ano priradi sa do premennej a vyhodi zo zasobnika
        } else {
            throw new ZasobnikException("Zla hodnota v zasobniku");         //ak nie exception
        }
        vysledok = prveCislo + druheCislo;                                  //vyhodnotenie
        Zasobnik.getZasobnik().vloz(vysledok);                              //vlozenie vysledku do zasobnika
    }

    /**
     * regularny vyraz pre add funkciu
     *
     * @author Tomi
     */
    @Override
    public String regexp() {
        return "^ADD$";
    }

    @Override
    public String platnost() {
        return "^ADD$";
    }
}