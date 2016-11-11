/*
 *program that shows the earlier date
 */
package calendario;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Marvin
 * @date: 24/10/16
 */
public class Calendario {

    /**
     * @param args the command line arguments
     * 
     */
    public static void main(String[] args) {
        
        Anterior ayer = new Anterior();
        ayer.run();   
    }
}
