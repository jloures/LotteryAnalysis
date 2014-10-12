
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * @author joaoloures
 */

public class Info extends LotteryFE{

    private int start;
    private int end;
    private int index;
    private int array_numbers[];
    private int total;
    private boolean show_combination_no;
    private int combination_number;
    private boolean print_to_file;
    private String file_name;
    private PrintWriter writer;
    private Numbers number;
    private boolean submitted;
    private Analysis analysis;

    public Analysis getAnalysis() {
        return analysis;
    }

    public void setAnalysis(Analysis analysis) {
        this.analysis = analysis;
    }

    public int[] getArray_numbers() {
        return array_numbers;
    }

    public void setArray_numbers(int[] array_numbers) {
        this.array_numbers = array_numbers;
    }
    
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }
    
    public Numbers getNumber() {
        return number;
    }

    public void setNumber(Numbers number) {
        this.number = number;
    }

    public PrintWriter getWriter() {
        return writer;
    }

    public void setWriter(PrintWriter writer) {
        this.writer = writer;
    }
    
    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setShow_combination_no(boolean show_combination_no) {
        this.show_combination_no = show_combination_no;
    }

    public void setCombination_number(int combination_number) {
        this.combination_number = combination_number;
    }

    public void setPrint_to_file(boolean print_to_file) {
        this.print_to_file = print_to_file;
    }
    
    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getTotal() {
        return total;
    }

    public boolean isShow_combination_no() {
        return show_combination_no;
    }

    public int getCombination_number() {
        return combination_number;
    }

    public boolean isPrint_to_file() {
        return false;
    }
    
    public Info(int start, int end, int total, boolean show_combination_no, int combination_number, boolean print_to_file, Numbers number) throws FileNotFoundException, UnsupportedEncodingException {
        this.start = start;
        this.end = end;
        this.total = total;
        this.show_combination_no = show_combination_no;
        this.combination_number = combination_number;
        this.print_to_file = print_to_file;
        this.number = number;
        this.analysis = new Analysis();
        this.submitted = false;
    }
}
