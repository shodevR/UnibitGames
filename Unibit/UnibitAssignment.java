

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;


public class Main {
    

	 public static List<int[]> findPairs(int[] array, int t) {
	        List<int[]> pairs = new ArrayList<>();

	        Arrays.sort(array); // Sort the array in ascending order

	        int left = 0;
	        int right = array.length - 1;

	        while (left < right) {
	            int sum = array[left] + array[right];

	            if (sum == t) {
	                pairs.add(new int[]{array[left], array[right]});
	                left++;
	                right--;
	            } else if (sum < t) {
	                left++;
	            } else {
	                right--;
	            }
	        }

	        return pairs;
	 }
	 
	 public static int[] mergePairs(List<int[]> pairs) {
	        int totalPairs = pairs.size();
	        int[] mergedArray = new int[totalPairs * 2];

	        int index = 0;
	        for (int[] pair : pairs) {
	            mergedArray[index++] = pair[0];
	            mergedArray[index++] = pair[1];
	        }

	        Arrays.sort(mergedArray);

	        return mergedArray;
	    }
	 
	 public static List<int[]> findQuartets(int[] array, int t) {
	        List<int[]> quartets = new ArrayList<>();
	        Arrays.sort(array); 

	        int n = array.length;

	        for (int i = 0; i < n - 3; i++) {
	            for (int j = i + 1; j < n - 2; j++) {
	                int left = j + 1;
	                int right = n - 1;

	                while (left < right) {
	                    int sum = array[i] + array[j] + array[left] + array[right];

	                    if (sum == t) {
	                        quartets.add(new int[]{array[i], array[j], array[left], array[right]});
	                        left++;
	                        right--;
	                    } else if (sum < t) {
	                        left++;
	                    } else {
	                        right--;
	                    }
	                }
	            }
	        }

	        return quartets;
	    }

	public static void main(String[] args) throws IOException {
   	 
    	BufferedReader bf = new BufferedReader(new   InputStreamReader(System.in));
   	 
   
     
     
         
         int[] array = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
         int t = Integer.parseInt(bf.readLine());
         
         
         List<int[]> pairs = findPairs(array, t);
         System.out.println("First Combination For "+t);
         for (int[] pair : pairs) {
             System.out.println(Arrays.toString(pair));
         }
         int[] mergedArray = mergePairs(pairs);
         

         System.out.println("Merged Array for pairs in ascending order: ");
         System.out.println(Arrays.toString(mergedArray));
         
         List<int[]> quartets = findQuartets(mergedArray, t*2);

         System.out.println("Second Combination For "+" "+t*2);
         for (int[] quartet : quartets) {
             System.out.println(Arrays.toString(quartet));
         }
     
   	    	bf.close();
        	}
   	 
    
	}

