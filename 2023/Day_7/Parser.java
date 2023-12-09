import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {
	
    private String[] args;
    private ArrayList<String> lines;
     
    
    public Parser(String[] args) throws IOException {
    	this.args = args;
    	this.lines = new ArrayList<String>();
    	parseInputFile(args);
    }
    
    private void usage() {
        System.err.println("usage: java Driver input.txt");
        System.exit(1);
    }

    private void parseInputFile(String[] args) throws IOException{
        if (args.length == 0) {
            usage();
        }
        try {
			BufferedReader bf = new BufferedReader(new FileReader(args[0]));
			String line = bf.readLine();
			
			// checking for end of file
	        while (line != null) {
	        	lines.add(line);
	            line = bf.readLine();
	        }
	       
	        bf.close();
	       
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
    
    public ArrayList<String> getInput(){
    	return lines;
    }

}
