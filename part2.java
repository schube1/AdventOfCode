package advent;

import java.io.*;
import java.util.*;

public class part2 {
    public static void main(String[] args) {
        
    	String filePath = "/Users/vinzentschubert/eclipse-workspace/Advent1/src/advent/input.txt"; 

        try {
            
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();

            
            String line;
            while ((line = reader.readLine()) != null) {
                
                String[] numbers = line.trim().split("\\s+");
                if (numbers.length == 2) {
                    list1.add(Integer.parseInt(numbers[0])); 
                    list2.add(Integer.parseInt(numbers[1])); 
                } else {
                    System.out.println("Error: Each line must contain exactly two numbers.");
                    reader.close();
                    return;
                }
            }
            reader.close();

        int[] array1= list1.stream().mapToInt(Integer::intValue).toArray();
        int[] array2= list2.stream().mapToInt(Integer::intValue).toArray();
        
        Map<Integer, Integer> freq = new HashMap<>();
        
        for(int num : array2) {
        	freq.put(num,freq.getOrDefault(num,0)+1);
        }
            
        int total = 0;
        
        for (int num : array1) {
        	int countInArray2 = freq.getOrDefault(num, 0);
        	total += num * countInArray2;
        }
            
        System.out.println("Similarity Score: "+ total);
            
            
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing numbers: " + e.getMessage());
        }
    }
}

