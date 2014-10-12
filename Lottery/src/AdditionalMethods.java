
import java.io.BufferedReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joaoloures
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AdditionalMethods extends javax.swing.JOptionPane{
    
    public void ErrorMessage (String s) {
        JOptionPane.showMessageDialog(null, s);
    }
    
    public boolean isValidData (BufferedReader br, Info inf) throws IOException {
    
        String line = br.readLine();
        
        while (line != null) {
            String number = "";
            int i = 0;
           while (i < line.length()) {
                while(i < line.length() && line.charAt(i) <= '9' && line.charAt(i) >= '0') {
                    number += ("" + line.charAt(i));
                    i++;
                }
                while(i < line.length() && (line.charAt(i) == ',' || line.charAt(i) == ' '))
                    i++;
                if(i < line.length() && !(line.charAt(i) <= '9' && line.charAt(i) >= '0') || !ValidData(Integer.parseInt(number),inf))
                    return false;
                else {
                    int temp = Integer.parseInt(number) - 1;
                    inf.getAnalysis().getFrequency()[temp]++;
                    inf.getAnalysis().setTotal(inf.getAnalysis().getTotal() + 1);
                }
                number = "";   
            }
            line = br.readLine();
            inf.getAnalysis().setTotal(0);
        }
        
        return true;
    }
    
    public void DisplayResults (Info inf, javax.swing.JTextArea jTextArea1) {
    
        for(int i = 0; i < inf.getAnalysis().getFrequency().length; i++) {
                jTextArea1.append("Number: " + (i + 1) + ". Frequency: " + inf.getAnalysis().getFrequency()[i] + "\n");
        }
    }
    
    public boolean ValidData (int number, Info inf) {
    
        if(number < inf.getStart() || number > inf.getEnd() || (inf.getAnalysis().getTotal() + 1) > inf.getTotal())
            return false;
        else
            return true;
    }
}
