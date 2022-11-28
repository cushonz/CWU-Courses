import java.io.*;
import java.util.*;
/*Zachary Cushon
9/30/2020
Advanced Data Structures
*/
public class Lab2
{
    /**
     *  Problem 1: Arrange the given array such that all even numbers are in increasing
     *  order at even indices and all odd numbers are in decreasing order at odd indices.
     */
	private static void problem1(int[] arr)
	{
		//Declaring neccesary variables
		int n = arr.length;
		//create two arrays one for even numbers and one for odd
		int[] even =new int[arr.length/2];
		int[] odd = new int[arr.length/2];
		//tracking the even and odd index
	   	int oddInd = 1; 
        int evenInd = 0; 
        //swap variable
        int temp;
        //create a stack in order to reverse the order of odd numbers easily.
        Stack<Integer> stack = new Stack<Integer>();
        
        
		while (true) 
        { 
        	//adjusting even index and checking if even
            while (evenInd < n && arr[evenInd] % 2 == 0) //O(n)
                evenInd += 2; 
            //adjusting odd index and checking if odd
            //These lines can be thought of as a pre check of how much is correct to begin with
            while (oddInd < n && arr[oddInd] % 2 == 1) //O(n)
                oddInd += 2; 
            //based on the values acquired earlier swaps will be made
            if (evenInd < n && oddInd < n) 
                { 
                    temp = arr[evenInd]; 
                    arr[evenInd] = arr[oddInd]; 
                    arr[oddInd] = temp; 
                } 
                  
            else
            	//exit loop once all values are on even/odd
                break; 
        } 
		//loop n times to populate the even and odd arrays
		for (int i = 0; i < n; i++)
		{
			//on even index add to even array
			if (i%2 == 0)
			{
				even[i/2] = arr[i];
			}
			//on odd index add to odd array
			else if (i%2 == 1)
			{
				odd[i/2] = arr[i];
			}
		}
		//sort both arrays
		Arrays.sort(even);
		Arrays.sort(odd);
		//push entire odd array onto stack for reversal
		for (int i = 0; i<n/2;i++)
			stack.push(odd[i]);
		//re construct the final array
		for (int i = 0; i<n;i++)
		{
			//if i is even reference the array(sorted)
			if (i%2 == 0)
				arr[i] = even[i/2];
			//if i is odd unload the stack into arr[i]
			else
				arr[i] = stack.pop();
				
		}
		
	}
	

    /**
     *  Problem 2: Determines for each entry its position in the sorted array.
     */
    private static int[] problem2(int[] arr)
    {
    	//create array of key value pairs
    	IntKVPair[] kvp = new IntKVPair[arr.length];
    	//create new empty array with size arr.length
    	int[] B = new int[arr.length]; 
    	for (int i = 0;i<kvp.length;i++)
    	{
    		//populate kvp array with Key-Value Pairs
    		kvp[i] = new IntKVPair(arr[i],i);
    	}
    	//sort kvp
    	Arrays.sort(kvp);
    	//assign values to empty array
    	for (int i = 0; i < arr.length; i++)
    	{
    		B[kvp[i].value] = i;
    	}
    	//return new array
    	return B;
    }

    
    
    
    // ---------------------------------------------------------------------
    // Do not change any of the code below!

    static class IntKVPair implements Comparable<IntKVPair>
    {
        public int key;
        public int value;

        public IntKVPair(int key, int value)
        {
            this.key = key;
            this.value = value;
        }

        public int compareTo(IntKVPair other)
        {
            return this.key - other.key;
        }

    }


    private static final int LabNo = 1;
    private static final String quarter = "Fall 2020";
    private static final Random rng = new Random(654321);

    private static boolean testProblem1(int[][] testCase)
    {
        int[] arr = testCase[0];

        int[] answer = arr.clone();
        problem1(answer);

        if (answer == null) return false;
        if (answer.length != arr.length) return false;

        for (int i = 2; i < answer.length; i += 2)
        {
            if (answer[i] < answer[i - 2]) return false;
        }

        for (int i = 3; i < answer.length; i += 2)
        {
            if (answer[i] > answer[i - 2]) return false;
        }

        Arrays.sort(arr);
        Arrays.sort(answer);

        for (int i = 0; i < answer.length; i++)
        {
            if (arr[i] != answer[i]) return false;
        }

        return true;
    }

    private static boolean testProblem2(int[][] testCase)
    {
        int[] arr = testCase[0];
        int[] solution = testCase[1];

        int[] result = problem2(arr);

        if (result == null || result.length != solution.length)
        {
            return false;
        }

        for (int i = 0; i < result.length; i++)
        {
            if (result[i] != solution[i]) return false;
        }

        return true;
    }

    public static void main(String args[])
    {
        System.out.println("CS 302 -- " + quarter + " -- Lab " + LabNo);

        testProblems(1);
        testProblems(2);
    }

    private static void testProblems(int prob)
    {
        int noOfLines = 10000;

        System.out.println("-- -- -- -- --");
        System.out.println(noOfLines + " test cases for problem " + prob + ".");

        boolean passedAll = true;

        for (int i = 1; i <= noOfLines; i++)
        {
            boolean passed = false;
            boolean exce = false;

            int[][] line = null;

            try
            {
                switch (prob)
                {
                    case 1:
                        line = createProblem1(i);
                        passed = testProblem1(line);
                        break;

                    case 2:
                        line = createProblem2(i);
                        passed = testProblem2(line);
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

    private static int[][] createProblem1(int lineNo)
    {
        int maxSize = Math.min(lineNo, 500);
        int size = rng.nextInt(maxSize) + 2;
        size += size % 2;

        int[] numbers = getRandomNumbers(size);

        for (int i = 0; i < size; i++)
        {
            numbers[i] = 2 * numbers[i] + (i % 2);
        }

        // Shuffle
        for (int i = 0; i < size; i++)
        {
            int rndInd = rng.nextInt(size - i) + i;

            int tmp = numbers[i];
            numbers[i] = numbers[rndInd];
            numbers[rndInd] = tmp;
        }

        return new int[][] { numbers };
    }

    private static int[][] createProblem2(int lineNo)
    {
        int maxSize = Math.min(lineNo, 500);
        int size = rng.nextInt(maxSize) + 2;

        int[] numbers = getUniqueRandomNumbers(size);
        Arrays.sort(numbers);

        int[] solution = new int[size];

        for (int i = 0; i < size; i++)
        {
            solution[i] = i;
        }

        // Shuffle
        for (int i = 0; i < size; i++)
        {
            int rndInd = rng.nextInt(size - i) + i;

            int tmp = numbers[i];
            numbers[i] = numbers[rndInd];
            numbers[rndInd] = tmp;

            tmp = solution[i];
            solution[i] = solution[rndInd];
            solution[rndInd] = tmp;
        }

        return new int[][] { numbers, solution };
    }

    private static int[] getRandomNumbers(int size)
    {
        int[] numbers = new int[size];

        int maxVal = size * 10;
        for (int i = 0; i < size; i++)
        {
            numbers[i] = rng.nextInt(maxVal);
        }

        return numbers;
    }

    private static int[] getUniqueRandomNumbers(int size)
    {
        int maxSize = size * 10;

        int[] integers = new int[maxSize];
        for (int i = 0; i < maxSize; i++)
        {
            integers[i] = i;
        }

        // Shuffle
        for (int i = 0; i < maxSize; i++)
        {
            int rndInd = rng.nextInt(maxSize - i) + i;

            int tmp = integers[i];
            integers[i] = integers[rndInd];
            integers[rndInd] = tmp;
        }

        return Arrays.copyOf(integers, size);
    }
}
