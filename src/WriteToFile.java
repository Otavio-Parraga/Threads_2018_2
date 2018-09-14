import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class WriteToFile {
	public static void LogTime(int arrSize, double total) {
		BufferedWriter writer = null;
	    try {
	    	File logFile = new File("log/log.txt");
	        System.out.println(logFile.getCanonicalPath());
	        String time = String.valueOf(total);
	        writer = new BufferedWriter(new FileWriter(logFile, true));
	        writer.write(arrSize + " - " + time);
	        writer.newLine();
	    } 
	    catch (Exception e) {
	        e.printStackTrace();
	    } 
	    finally {
	        try {
	            writer.close();
	        } 
	        catch (Exception e) {
	        
	        }
	    }
	}
}
