/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carservise1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author permp_000
 */
public class SavePrintFile {
    
    public String saveFile(String text) throws IOException{
        FileWriter writer = new FileWriter("text.txt");
        BufferedWriter writer2 = new BufferedWriter(writer);
        String card = "*************************************** \n"
                     +"_______________________________________ \n"
              
                     + "        Автосервис ИП Самойлов О.Ф.           \n"
                + "\n"                    
                + "                        Адрес: г. Пермь             \n"
                + "                         tel 2-34-32-33             \n"
                + "                         INN 3243254325             \n"
                + "                        OGRN 3532453425            \n"
                + "\n"
                + "Работы:"
                + "\n"
                + text 
                + "\n"
                +"**************************************"
                + "\n"
                + "\n"
                + "\n"
                + "Подпись____________________               Печать \n"
                + "\n"
                + "\n"
                + "\n"
                +"**************************************";
                
                
                writer2.newLine();
        writer2.write(card);
        
        writer2.close();
        writer.close();
        
        return "OK";
    }
    
}
