/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joaoloures
 */
public class Analysis {

    private int frequency[];
    private int hot_and_cold[][];
    private int combinations[][];
    private int total;
    private boolean successful;

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }
    
    Analysis() {
       this.successful = false; 
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    public int[] getFrequency() {
        return frequency;
    }

    public void setFrequency(int[] frequency) {
        this.frequency = frequency;
    }

    public int[][] getHot_and_cold() {
        return hot_and_cold;
    }

    public void setHot_and_cold(int[][] hot_and_cold) {
        this.hot_and_cold = hot_and_cold;
    }

    public int[][] getCombinations() {
        return combinations;
    }

    public void setCombinations(int[][] combinations) {
        this.combinations = combinations;
    }

    public Analysis(int[] frequency) {
        this.frequency = frequency;
        this.total = 0;
    }
    
}
