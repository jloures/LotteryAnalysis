
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.util.Vector;

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
    
    int relative_freq(Frequency tmp[], int start, int end) {
        
        int total = 0;
        for(int i = start; start <= end; start++)
            total += tmp[i].getFrequency();
        return total;
    }
    
    public void generate_combinations_based_on_data(Info inf, javax.swing.JTextArea jTextArea1) {
    
        Random rand = new Random(); 
        int div = (int)(Math.sqrt(inf.getEnd() - inf.getStart() + 1));
        int sequence[] = new int[inf.getTotal()], index = 0;
        for(int z = 0; z < sequence.length; z++)
            sequence[z] = 0;
        Frequency frq[];
        int num_of_comb = inf.getNum_of_combinations();
        int num_to_select = inf.getTotal();
        int num = inf.getTotal();
        int total = inf.getEnd() - inf.getStart() + 1;
        while(num_of_comb != 0)
        {
            int end = 0;
            for(int i =0; i < div; i++)
            {
                if(i*div + div > total)
                end = total - 1;
                else end = i*div + div - 1;
                sequence[i] = rand.nextInt(end - i*div) + i*div + 1;   
            }
            
            for (int j = 0;j < num_to_select; j++) {
                String temp = "" + sequence[j];
                jTextArea1.append(temp);
                if(j != (num_to_select - 1)) {
                    jTextArea1.append(", ");
                }
            }
            inf.setCombination_number(inf.getCombination_number() + 1);
            if(inf.isShow_combination_no() == true) {
                    jTextArea1.append(" Combination number: " + inf.getCombination_number() + "\n");
            }
            else 
                jTextArea1.append("\n");
            num_of_comb--;
        }
    
    }
    
    public void Organize (int numbers[], Info inf) {
        int total = inf.getEnd() - inf.getStart() + 1;
        int tmp_frq[] = new int[total];
        int index = 0, highest = -1,number = -1;
        while(total != 0)
        {
            int k = 0;
            for(int tmp: tmp_frq)
            {
                if(tmp > highest)
                {   
                    highest = tmp;
                    number =  k + 1;   
                } 
                k++;
            }
            inf.getFrq()[index] = new Frequency(number,highest);
            tmp_frq[highest] = -2;
            index++;
            highest = -1;
            number = -1;
            total--;
        }
        inf.getAnalysis().setFrequency(tmp_frq);
    }
    public void generate_combinations_from_sequence (int index, int start, int end, int total, Info inf, javax.swing.JTextArea jTextArea1) {

    if(total == 0)
        return;
    for(int i = start; i <= end; i++) {
        inf.getArray_numbers()[index - total] = inf.getSequence()[i];
        generate_combinations_from_sequence(index, i + 1, end, total - 1, inf, jTextArea1);
        if(total == 1) {
            for (int j = 0;j < index; j++) {
                String temp = "" + inf.getArray_numbers()[j];
                jTextArea1.append(temp);
                if(j != (index - 1)) {
                    jTextArea1.append(", ");
                }
            }
            inf.setCombination_number(inf.getCombination_number() + 1);
            if(inf.isShow_combination_no() == true) {
                    jTextArea1.append(" Combination number: " + inf.getCombination_number() + "\n");
            }
            else 
                jTextArea1.append("\n");
        }
        
    }
    
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
        generate_combinations(index, i + 1,end, total - 1, inf, jTextArea1);
        if(total == 1) {
            for (int j = 0;j < index; j++) {
                    String temp = "" + inf.getArray_numbers()[j];
                    jTextArea1.append(temp);
                if(j != (index - 1)) {
                    jTextArea1.append(", ");
                }
            }
            inf.setCombination_number(inf.getCombination_number() + 1);
            if(inf.isShow_combination_no() == true) {
                jTextArea1.append(" Combination number: " + inf.getCombination_number() + "\n");
            }
            else 
                jTextArea1.append("\n");
        }
        
    }
  
    
    }
    
    
}
