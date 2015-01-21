
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

import java.io.IOException;
import java.util.Vector;
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
    
    public boolean isValidData2 (String str, Info inf){
    
        String line = str;
        String number = "";
        Vector<String> list = new Vector<String>();
        int i = 0, j = 0;
        while (i < line.length()) {
             while(i < line.length() && line.charAt(i) <= '9' && line.charAt(i) >= '0') {
                 number += ("" + line.charAt(i));
                 i++;
             }
             while(i < line.length() && (line.charAt(i) == ',' || line.charAt(i) == ' '))
                 i++;
             if(i < line.length() && !(line.charAt(i) <= '9' && line.charAt(i) >= '0'))
                 return false;
             else {
                 list.add(number);
             }
             number = "";   
        }
        
        int nums = 0;
        for(String tmp_str: list)
            nums++;
        inf.setSequence(new int[nums]);
        int index = 0;
        for(String tmp_str:list)
        {
            inf.getSequence()[index] = Integer.parseInt(tmp_str);
            index++;
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
