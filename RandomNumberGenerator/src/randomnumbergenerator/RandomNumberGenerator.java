/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomnumbergenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author joaoloures
 */
public class RandomNumberGenerator {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int start = 1, array_numbers[] = new int[7], end = 49, how_many = 10000, total = end - start + 1, random_number, frequency[] = new int[total];
        PrintWriter writer;
        File file;
        for (int i = 0; i < array_numbers.length; i++) {
            array_numbers[i] = 0;
        }

        try {

            writer = new PrintWriter("Default.txt");
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 7; j++) {
                    int temp;
                    do {
                        temp = (((int) (Math.random() * 1000000000)) % (end - start + 1) + start);
                    }while(!isUnique(array_numbers, temp));
                    String temp2 = temp + "";
                    if (j < 6) {
                        temp2 += ", ";
                    } else {
                        temp2 += "\n";
                    }
                    writer.print(temp2);
                }
            }
        } catch (FileNotFoundException e) {

            return;

        }
    }

    public static boolean isUnique(int array_numbers[], int number) {

        for (int i = 0; array_numbers[i] != 0; i++) {
            if (number == array_numbers[i]) {
                return false;
            }
        }

        return true;

    }
}
