package advent;

import java.io.*;
import java.util.*;

public class day1 {
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

            
            int[] array1 = list1.stream().mapToInt(Integer::intValue).toArray();
            int[] array2 = list2.stream().mapToInt(Integer::intValue).toArray();
            Arrays.sort(array1);
            Arrays.sort(array2);

            
            int totalDistance = 0;
            for (int i = 0; i < array1.length; i++) {
                totalDistance += Math.abs(array1[i] - array2[i]);
            }

           
            System.out.println("Total Distance: " + totalDistance);

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing numbers: " + e.getMessage());
        }
    }
}
