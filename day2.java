package advent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class day2 {
	public static void main(String[] args) {
	
	String filePath = "/Users/vinzentschubert/eclipse-workspace/Advent1/src/advent/reports.txt";

    try {
        
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
    
        int totalSafe =0;
        
        String line;
        while((line = reader.readLine()) != null) {
        	
        	String[] numbers = line.trim().split("\\s+");
        	if (numbers.length > 1) {
        		int [] levels = new int[numbers.length];
        		for (int i = 0; i< numbers.length; i++) {
        			levels[i] = Integer.parseInt(numbers[i]);
        		}
        		
        		if (isSafe(levels)) {
        			totalSafe++;
        			
        		}else {
        			System.out.println("Error: Each report must contain exactly 5 levels.");
        		}
        	}
        }
        reader.close();
        
        
        System.out.println("Number of safe reports: "+ totalSafe);

        
        
  		} catch (IOException e) {
		    System.out.println("Error reading the file: " + e.getMessage());
		} catch (NumberFormatException e) {
		    System.out.println("Error parsing numbers: " + e.getMessage());
		}
    
	}
		
    	private static boolean isSafe(int[] levels) {
    		boolean inc = true;
    		boolean dec = true;
    		
    		for(int i =1; i < levels.length; i++) {
    			int diff = levels[i] -levels[i-1];
    			
    		
    		
    		if(diff < -3 || diff == 0 || diff > 3) {
    			return false; 		
    		}    		
    		if(diff > 0) {
    			dec = false;	
    		}else if(diff <0) {
    			inc = false;
    		}
    		}
    		return inc || dec;
    	}
    	
			
}
