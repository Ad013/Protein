import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
 
/**
* Read contents of a File line by line using BufferedReader

*/
public class ReadLinesInFile {
    int c=0;
    //This function Prints the data file
    public void print(String[][] myArray)
    {
      System.out.println(Arrays.deepToString(myArray));
    }
    //This Function Counts the no of lines or rows
    public int count(String data)
    {
         try {
            BufferedReader br = null; 
            String line = "";
            br = new BufferedReader(new FileReader(data));
            while( (line = br.readLine()) != null){
                c++;
            }
         }
         catch (IOException e) {
            System.err.println("Oops! Unable to read the file.");
            e.printStackTrace();
        }
         return c;
    }
	//This function read the file and store the data in a array
    
        public String[][] read(String data)
    {
        count(data);
        String [][] my = new String[c][2];
        BufferedReader br = null;        
        String line = "";
        int i=0;
        try {
            br = new BufferedReader(new FileReader(data));                       
            while( (line = br.readLine()) != null){
                String[] splitInput = line.split("\\s+");
  		if (splitInput.length != 2) {
                    System.out.println("Invalid data entry read: " + line);
    		continue;
  		}
        	my[i][0] = splitInput[0];    
                my[i][1] = splitInput[1];  
                i++;
            }
            
        } catch (FileNotFoundException e) {
            System.err.println("Oops! Please check for the presence of file in the path specified.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Oops! Unable to read the file.");
            e.printStackTrace();
        }
       return my;
    }
}
