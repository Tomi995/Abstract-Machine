/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.tuke.emulatoras.instrukcia;

import emulatoras.Instrukcia;
import emulatoras.MyParserException;
import emulatoras.Parser;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Tomi
 */
public class Loop extends Instrukcia {

    @Override
    public void vykonaj(String instrukcia) throws MyParserException {
        System.out.println(instrukcia);
        Parser parser = new Parser();

        String prvyPrikaz;
        String druhyPrikaz;

        instrukcia = instrukcia.replaceAll("\\s", "");                          //odstranenie bielych znakov
        instrukcia = instrukcia.toUpperCase();                                  //zmena na velke pismena

        Pattern pattern = Pattern.compile(regexp());                            //pattern pre regularny vyraz
        Matcher match = pattern.matcher(instrukcia);

        if (match.find()) {
            prvyPrikaz = match.group(1);                                            //priradenie prvej casti
            druhyPrikaz = match.group(2);                                           //priradenie druhej casti
            System.out.println(prvyPrikaz + ":COND(" + druhyPrikaz + ":" + instrukcia + ",EMPTYOP)");
            parser.parse(prvyPrikaz + ":COND(" + druhyPrikaz + ":" + instrukcia + ",EMPTYOP)");     //upravenie kodu ktory sa zacne znovu parsovat
        }
    }

    @Override
    public String regexp() {
        return "^LOOP[(](.*),(.*)[)]$";
    }

    @Override
    public String platnost() {
        return "^LOOP[(](.*),(.*)[)]$";
    }
}
