/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendario;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Marvin
 */
public class Anterior {
    void run(){
    
    Calendar c = Calendar.getInstance();
    c.add(Calendar.DATE, -1);
    Date date = c.getTime();
    System.out.println("Yesterday: " + date);
    
    }
        
}
