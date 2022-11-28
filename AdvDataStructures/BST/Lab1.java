import java.io.*;
import java.util.*;

public class Lab1
{

    // ---------------------------------------------------------------------
    // Do not change any of the code below!

    private static final int LabNo = 4;
    private static final String quarter = "Fall 2020";
    private static final Random rng = new Random(190718);

    private static boolean testProblem(int[][] testCase)
    {
        int[] arr1 = testCase[0];
        int[] arr2 = testCase[1];

        // --- Build tree ---

        BST tree1 = new BST();
        BST tree2 = new BST();

        for (int i = 0; i < arr1.length; i++)
        {
            tree1.insert(arr1[i]);
            tree2.insert(arr2[i]);
        }

        int[] pre2 = tree2.getPreOrder();


        BST.problem(tree1, tree2);


        // --- Verify tree. ---

        int[] pre1 = tree1.getPreOrder();
        int[] in1 = tree1.getInOrder();

        if (in1.length != arr1.length) return false;

        for (int i = 0; i < in1.length; i++)
        {
            if (in1[i] != i) return false;
            if (pre1[i] != pre2[i]) return false;
        }

        return true;
    }

    public static void main(String args[])
    {
        System.out.println("CS 302 -- " + quarter + " -- Lab " + LabNo);
        testProblems(1);
    }

    /**
     * @param prob
     */
    private static void testProblems(int prob)
    {
        int noOfLines = 100000;

        System.out.println("-- -- -- -- --");
        System.out.println(noOfLines + " test cases for problem " + prob + ".");

        boolean passedAll = true;
long start = System.currentTimeMillis();
        for (int i = 1; i <= noOfLines; i++)
        {
            boolean passed = false;
            boolean exce = false;

            try
            {
                int[][] testCase = createProblem(i);
                passed = testProblem(testCase);
            }
            catch (Exception ex)
            {
                passed = false;
                System.out.println(ex);
                exce = true;
            }

            if (!passed)
            {
                System.out.println("Test " + i + " failed!" + (exce ? " (Exception)" : ""));
                passedAll = false;
                break;
            }
        }
System.out.println((System.currentTimeMillis() - start) + " ms");
        if (passedAll)
        {
            System.out.println("All test passed.");
        }

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

    private static int[][] createProblem(int testNo)
    {
        int size = rng.nextInt(Math.min(200, testNo)) + 1;

        int[] numbers1 = new int[size];
        int[] numbers2 = new int[size];

        for (int i = 0; i < size; i++)
        {
            numbers1[i] = i;
            numbers2[i] = i;
        }

        shuffle(numbers1);
        shuffle(numbers2);

        return new int[][] { numbers1, numbers2 };
    }
}
