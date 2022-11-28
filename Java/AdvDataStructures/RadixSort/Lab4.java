import java.io.*;
import java.util.*;
// Radix Sort
public class Lab4
{
    /**
     *  Problem: Sort multi-digit integers (with n total digits) in O(n) time.
     *  (Technically, it is O(n * b) time. However, since our base b = 128 is constant, it is O(n).)
     */	
    private static void problem(byte[][] arr)
    {   
    	int n = arr.length;
    	int current = 0 ;
    	int next = 0 ;
    	byte[] swap;
    	
    	
    	
    	//sort arrays by total length first
    	for (int i = 0; i < n-1;i++)
    	{
    		current = arr[i].length;
    		next = arr[i+1].length;
    		if (current > next)
    		{
    			swap = arr[i];
    			arr[i] = arr[i+1];
    			arr[i+1] = swap;
    			i = -1;
    		}
    	}
    	//end length sort
    	
    	
    	byte[][] copy;
    	int startpointer = 0;
    	int endpointer = 0;
    	int x = 0;
    		//begin radix sort
    		int column = 0;
    		for (column = 0; x < arr.length;column++)
    		{
				
			    //set end pointer----------------------------------------------------------------------
    			try {
    			while (arr[startpointer].length == arr[endpointer].length && endpointer < arr.length)
               	{
               		endpointer++;
               	}
    			}
    			catch (Exception e)
    			{
    				if (startpointer == endpointer)
    					break;
    			}     		
        		//set end pointer----------------------------------------------------------------------
        		
        		//creates copy of arrays from start point to end point-------------
        		copy = new byte[endpointer-startpointer][arr[startpointer].length];
        		for (int j = startpointer, s = 0; s < copy.length;j++, s++)
        		{
        			copy[s] = arr[j];
        		}
        		//creates copy of arrays from start point to end point-------------

        		{
        			int n1 = copy.length;
        			int max = copy[0][0];
        	    	//find maximum to save memory
        	    	for (int i = 0;i<n1;i++)
        	    	{
        	    		try {
        	    			if (copy[i][column]>max)
        	        			max = copy[i][column];
        	    		}catch(Exception e) {
        	    		}
        	    		
        	    	}
        	    	//maximum-------------------------
        	    	
        	      	byte[] countsort1 = new byte[max+1];//consider changing
        	    	byte[] countsortF = new byte[max+1];
        	    	byte[][] vertical = new byte[n1][];
        	    	Arrays.fill(countsortF, (byte)0);
        	    	//count occurences
        	    	for (int i = 0; i < copy.length;i++)
        	    	{
        	    		if (column < copy[i].length)
        	    	 countsort1[copy[i][column]]++; 
        	    		
        	    	}
        	    	//count occurences
        	    	
        	    	//add to right 
        	    	for (int i = 0; i < countsort1.length-1;i++)
        	    	{
        	    		countsort1[i+1] += countsort1[i];
        	    	}
        	    	//add to right
        	    	
        	    	//shift
        	    	for (int i = 0; i < countsort1.length-1;i++)
        	    	{
        	    		try {
        	    			countsortF[i+1] = countsort1[i];
        	    		}
        	    		catch(Exception e)
        	    		{
        	    			//caught shift exception to get rid of last digit, do nothing
        	    		}
        	    		
        	    	}
        	    	//shift
        	    	//populate new array
        	    	for (int i = 0; i < vertical.length;i++)
        	    	{
        	    		try {
        	    		vertical[countsortF[copy[i][column]]] = copy[i];
        	    		countsortF[copy[i][column]]++;
        	    		} catch (Exception e) {
        	    			
        	    		}
        	    	}
    			
    			if (vertical.length > 1)
    			{
    			//count sort looping
    			int pos = 0;
    			for (pos = startpointer; pos < vertical.length+startpointer; pos++)
    			{
    				arr[pos] = vertical[pos-startpointer];
    			}
    			
    			if (column >= arr[pos-1].length-1)
    			{
    				startpointer = endpointer;
    				column = -1;
    			}
    			}
    			else
    			{
    				startpointer = endpointer;
    				column = -1;
    			}

    		}
    		}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	/*for (int i = 0; i < arr.length-1; i++)
    	{
    		current = 0;
    		next = 0;
    		if (arr[i].length == arr[i+1].length)
    		{
    			for (int j = 0; j < arr[i].length; j++)
    			{
    			current = arr[i][j];
    			next = arr[i+1][j];
    			}
    			if (current > next)
    			{
    				swap = arr[i];
    				arr[i] = arr[i+1];
    				arr[i+1] = swap;
    				i = -1;
    			}
    		}
    	}*/
    	
    	
    }

    // ---------------------------------------------------------------------
    // Do not change any of the code below!

    private static final int LabNo = 4;
    private static final String quarter = "Fall 2020";
    private static final Random rng = new Random(654321);

    private static boolean testProblem(byte[][] testCase)
    {
        byte[][] numbersCopy = new byte[testCase.length][];

        // Create copy.
        for (int i = 0; i < testCase.length; i++)
        {
            numbersCopy[i] = testCase[i].clone();
        }

        // Sort
        
        problem(testCase);
        Arrays.sort(numbersCopy, new numberComparator());

        // Compare if both equal
        if (testCase.length != numbersCopy.length)
        {
            return false;
        }

        for (int i = 0; i < testCase.length; i++)
        {
            if (testCase[i].length != numbersCopy[i].length)
            {
                return false;
            }

            for (int j = 0; j < testCase[i].length; j++)
            {
                if (testCase[i][j] != numbersCopy[i][j])
                {
                    return false;
                }
            }
        }

        return true;
    }

    // Very bad way of sorting.
    private static class numberComparator implements Comparator<byte[]>
    {
        @Override
        public int compare(byte[] n1, byte[] n2)
        {
            // Ensure equal length
            if (n1.length < n2.length)
            {
                byte[] tmp = new byte[n2.length];
                for (int i = 0; i < n1.length; i++)
                {
                    tmp[i] = n1[i];
                }
                n1 = tmp;
            }

            if (n1.length > n2.length)
            {
                byte[] tmp = new byte[n1.length];
                for (int i = 0; i < n2.length; i++)
                {
                    tmp[i] = n2[i];
                }
                n2 = tmp;
            }

            // Compare digit by digit.
            for (int i = n1.length - 1; i >=0; i--)
            {
                if (n1[i] < n2[i]) return -1;
                if (n1[i] > n2[i]) return 1;
            }

            return 0;
        }
    }

    public static void main(String args[])
    {
        System.out.println("CS 302 -- " + quarter + " -- Lab " + LabNo);
        testProblems();
    }

    private static void testProblems()
    {
        int noOfLines = 10000;

        System.out.println("-- -- -- -- --");
        System.out.println(noOfLines + " test cases.");

        boolean passedAll = true;

        for (int i = 1; i <= noOfLines; i++)
        {
            byte[][] testCase =  createTestCase(i);

            boolean passed = false;
            boolean exce = false;

           // try
            //{
                passed = testProblem(testCase);
           // }
           // catch (Exception ex)
           /* {
            	System.out.println(ex);
                passed = false;
                exce = true;
            }*/

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

    private static byte[][] createTestCase(int testNo)
    {
        int maxSize = Math.min(100, testNo) + 5;
        int size = rng.nextInt(maxSize) + 5;

        byte[][] numbers = new byte[size][];

        for (int i = 0; i < size; i++)
        {
            int digits = rng.nextInt(maxSize) + 1;
            numbers[i] = new byte[digits];

            for (int j = 0; j < digits - 1; j++)
            {
                numbers[i][j] = (byte)rng.nextInt(128);
            }

            // Ensures that the most significant digit is not 0.
            numbers[i][digits - 1] = (byte)(rng.nextInt(127) + 1);
        }

        return numbers;
    }

}
