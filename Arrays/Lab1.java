import java.util.*;

public class Lab1 {

	public static int problem1(int[] array,int i, int j) 
	{	
		//scope has shrunk to none
		if (i == j) 
		{
			return array[i];
		}
		//if index i is greater than j shrink the scope by decreasing j
		else if (array[i]>array[j])
		{
			return problem1(array,i,--j);//j is changed before running
		}
		//if i is less than j shrink the scope by increasing i
		else if (array[i]<array[j])
		{
			return problem1(array,++i,j);
		}else {
			return 1;
		}
	}
	//I thought it made more sense to return the entire array with the reversed portion rather than to return a single int
	private static int[] problem2(int[] array,int i, int j)
	{
		if (i>=j)
		{
			return array;
		}
		//setting a variable for swapping
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		//shrink scope
		return problem2(array,++i,--j);
	}
}
