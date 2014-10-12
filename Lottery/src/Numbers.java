
import java.io.BufferedReader;
import java.io.FileReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joaoloures
 */
public class Numbers extends AdditionalMethods {
    
    public static Analysis analysis;
    
    public Numbers() {
    
    }
    
    //method for identifying whether the String only contains numbers
    public boolean is_number (String s) {
        //try and catch
        try {
            Integer.parseInt(s);
        }
        catch (NumberFormatException e) {
            //not a number
            return false;
        }
        //it is a number
        return true;
    }
    
    public boolean are_valid (int start, int end, int total ) {
    
        if(end < start || (end - start + 1) < total) 
            return false;
        else if(total < 1 || end < 1 || start < 1)
            return false;
        else return true;
    }
    
    public void ReadFromFile (Info inf, String s) {
    
        try{

            //Create object of FileReader
            FileReader inputFile = new FileReader(s);

            //Instantiate the BufferedReader Class
            BufferedReader bufferReader = new BufferedReader(inputFile);

            //call function that will analyse data and check
            //if it is valid
            
            inf.getAnalysis().setSuccessful(isValidData(bufferReader,inf));
            
            if(!inf.getAnalysis().isSuccessful()) {
                ErrorMessage("Data is not valid!");
            } 
            //Close the buffer reader
            bufferReader.close();
            
        }catch(Exception e){
            inf.getNumber().ErrorMessage("Unable to read File!");
        }

    
    }

    public void generate_combinations (int index, int start, int end, int total, Info inf, javax.swing.JTextArea jTextArea1) {

    if(total == 0)
        return;
    for(int i = start; i <= end; i++) {
        inf.getArray_numbers()[index - total] = i;
        generate_combinations(index, i + 1, end, total - 1, inf, jTextArea1);
        if(total == 1) {
            for (int j = 0;j < index; j++) {
                if(inf.isPrint_to_file())
                    inf.getWriter().print(inf.getArray_numbers()[j]);
                else {
                    String temp = "" + inf.getArray_numbers()[j];
                    jTextArea1.append(temp);
                }
                if(j != (index - 1)) {
                    if(inf.isPrint_to_file())
                        inf.getWriter().print(", ");
                    else
                        jTextArea1.append(", ");
                }
            }
            inf.setCombination_number(inf.getCombination_number() + 1);
            if(inf.isShow_combination_no() == true) {
                if(inf.isPrint_to_file())
                    inf.getWriter().print(" Combination number: " + inf.getCombination_number() + "\n");
                else
                    jTextArea1.append(" Combination number: " + inf.getCombination_number() + "\n");
            }
            else 
                if(inf.isPrint_to_file())
                    inf.getWriter().print("\n");
                else
                    jTextArea1.append("\n");
        }
        
    }

   }
}
