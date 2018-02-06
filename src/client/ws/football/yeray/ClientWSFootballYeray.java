/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.ws.football.yeray;

import eu.dataaccess.footballpool.ArrayOfString;
import eu.dataaccess.footballpool.ArrayOftCountryInfo;
import java.util.ArrayList;

/**
 *
 * @author entrar
 */
public class ClientWSFootballYeray {
//A1-Client-Football
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      System.out.println(yellowCardsTotal());
      
      ArrayOfString nuevo = allDefenders("Spain");
      
      ArrayOftCountryInfo paises = countryNames(true);
      
     
      for(int i=0; i< paises.getTCountryInfo().size();i++ ){
          System.out.println(paises.getTCountryInfo().get(i).getSName());
          nuevo = allDefenders(paises.getTCountryInfo().get(i).getSName());
          System.out.println(nuevo.getString());
      }
    }

    private static int yellowCardsTotal() {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap();
        return port.yellowCardsTotal();
    }

    private static ArrayOfString allDefenders(java.lang.String sCountryName) {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap();
        return port.allDefenders(sCountryName);
    }

    private static ArrayOftCountryInfo countryNames(boolean bWithCompetitors) {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap();
        return port.countryNames(bWithCompetitors);
    }
    
}
