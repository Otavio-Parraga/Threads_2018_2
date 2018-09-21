import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class WriteToFile {
	public static void LogTime(int arrSize, double total, int numThreads) {
		BufferedWriter writer = null;
	    try {
	    	File logFile = new File("log/log.txt");
	        System.out.println(logFile.getCanonicalPath());
	        String time = String.valueOf(total);
	        writer = new BufferedWriter(new FileWriter(logFile, true));
	        writer.write("NumThreads: "+numThreads + " - Array:" + arrSize + " - " + "Tempo: " + time);
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
