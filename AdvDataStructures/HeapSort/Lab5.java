import java.io.*;
import java.util.*;

public class Lab5
{

    /**
     *  Problem 1: Find the smallest integer that appears at least k times.
     */
    private static int problem1(int[] arr, int k)
    {
     	
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); //create hash map
        for (int i = 0; i < arr.length; i++)
        	if (map.containsKey(arr[i]))
        	{
        		//populate hashmap
        		map.put(arr[i],map.get(arr[i])+1);
        	}
        	else 
        	{
        		//fill key with array value and value with 1
        		map.put(arr[i],1);
        	}
        	//making sure that result is larger than any value
        	int result = Integer.MAX_VALUE;
        	//create a set
        	Set<Integer> set = map.keySet();
        	//loop through set and compare
        	for (int i : set)
        		if (map.get(i) >= k)
        			result = Math.min(i, result);
        
        return result; 
    }

    /**
     *  Problem 2: Find two distinct indices i and j such that A[i] = A[j] and |i - j| <= k.
     */
    private static int[] problem2(int[] arr, int k)
    {
        int i = 0;
        //create return array
        int ret[] = new int[2];
        //create hash map
        HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
        
        for (i = 0; i < arr.length; i++)
        {
        	//populate hash map with key value pairs
        	if(hm.containsKey(arr[i])) {
        		//Check for duplicates
        		if (i - (hm.get(arr[i])) <= k)
        		{
        			//populate answer array
        			ret[0] = i;
        			ret[1] = hm.get(arr[i]);
        			return ret;
        		}
        		else
        		{
        			//shift to latest duplicate if the gap is too big
        			hm.put(arr[i], i);
        		}
        	}else {
        		//populate array with unique values
        		hm.put(arr[i], i);
        	} 
        }
        return null;
    }

    // ---------------------------------------------------------------------
    // Do not change any of the code below!

    private static final int LabNo = 5;
    private static final String quarter = "Fall 2020";
    private static final Random rng = new Random(16);

    private static boolean testProblem1(int[][] testCase)
    {
        int[] arr = testCase[0];
        int k = testCase[1][0];

        int answer = problem1(arr.clone(), k);

        Arrays.sort(arr);
        for (int i = 0, j = 0; i < arr.length; i = j)
        {
            for (; j < arr.length && arr[i] == arr[j]; j++) { }

            if (j - i >= k)
            {
                return answer == arr[i];
            }
        }

        return false; // Will never happen.
    }

    private static boolean testProblem2(int[][] testCase)
    {
        int[] arr = testCase[0];
        int k = testCase[1][0];
        int[] answer = problem2(arr.clone(), k);

        if (answer == null || answer.length != 2)
        {
            return false;
        }

        Arrays.sort(answer);

        // Check answer
        int i = answer[0];
        int j = answer[1];
        return i != j
            && j - i <= k
            && i >= 0
            && j < arr.length
            && arr[i] == arr[j];
    }

    public static void main(String args[])
    {
        System.out.println("CS 302 -- " + quarter + " -- Lab " + LabNo);
        testProblems(1);
        testProblems(2);
    }

    private static void testProblems(int prob)
    {
        int noOfLines = prob == 1 ? 100000 : 500000;

        System.out.println("-- -- -- -- --");
        System.out.println(noOfLines + " test cases for problem " + prob + ".");

        boolean passedAll = true;

        for (int i = 1; i <= noOfLines; i++)
        {

            int[][] testCase = null;

            boolean passed = false;
            boolean exce = false;

            try
            {
                switch (prob)
                {
                    case 1:
                        testCase = createProblem1(i);
                        passed = testProblem1(testCase);
                        break;

                    case 2:
                        testCase = createProblem2(i);
                        passed = testProblem2(testCase);
                        break;
                }
            }
            catch (Exception ex)
            {
                passed = false;
                exce = true;
            }

            if (!passed)
            {
                System.out.println("Test " + i + " failed!" + (exce ? " (Exception)" : ""));
                passedAll = false;
                break;
            }
        }

        if (passedAll)
        {
            System.out.println("All test passed.");
        }

    }

    private static int[][] createProblem1(int testNo)
    {
        int size = rng.nextInt(Math.min(1000, testNo)) + 5;

        int[] numbers = getRandomNumbers(size, size);
        Arrays.sort(numbers);

        int maxK = 0;

        for (int i = 0, j = 0; i < size; i = j)
        {
            for (; j < size && numbers[i] == numbers[j]; j++) { }
            maxK = Math.max(maxK, j - i);
        }

        int k = rng.nextInt(maxK) + 1;

        shuffle(numbers);

        return new int[][] { numbers, new int[] { k } };
    }

    private static int[][] createProblem2(int testNo)
    {
        int size = rng.nextInt(Math.min(1000, testNo)) + 5;

        int[] numbers = getRandomNumbers(size, size);

        int i = rng.nextInt(size);
        int j = rng.nextInt(size - 1);
        if (i <= j) j++;

        numbers[i] = numbers[j];

        return new int[][] { numbers, new int[] { Math.abs(i - j) } };
    }

    private static void shuffle(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
            int rndInd = rng.nextInt(arr.length - i) + i;
            int tmp = arr[i];
            arr[i] = arr[rndInd];
            arr[rndInd] = tmp;
        }
    }

    private static int[] getRandomNumbers(int range, int size)
    {
        int numbers[] = new int[size];

        for (int i = 0; i < size; i++)
        {
            numbers[i] = rng.nextInt(2 * range) - range;
        }

        return numbers;
    }
}
