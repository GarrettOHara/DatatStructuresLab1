package cs310;
import java.util.ArrayList;
import java.util.Scanner;
public class Lab1
{
	/*
	 * The main method contains an arrayList of arrayList
	 * that has all the test arrays from the announcement
	 * that was posted
	 * 
	 * The main passes each test array through each method sequentially
	 */
	public static void main (String [] args)
	{
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(0);
		a1.add(20);
		a1.add(40);
		list.add(a1);
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(40);
		a2.add(20);
		a2.add(0);
		list.add(a2);
		ArrayList<Integer> a3 = new ArrayList<Integer>();
		a3.add(0);
		a3.add(20);
		list.add(a3);
		ArrayList<Integer> a4 = new ArrayList<Integer>();
		a4.add(1);
		a4.add(2);
		a4.add(5);
		list.add(a4);
		ArrayList<Integer> a5 = new ArrayList<Integer>();
		a5.add(0);
		a5.add(20);
		a5.add(30);
		a5.add(40);
		a5.add(50);
		a5.add(60);
		a5.add(101);
		list.add(a5);
		ArrayList<Integer> a6 = new ArrayList<Integer>();
		for (int i = 0; i < 20; i++)
		{
			a6.add(i);
		}
		a6.add(39);
		a6.add(40);
		a6.add(50);
		a6.add(59);
		list.add(a6);
		ArrayList<Integer> a7 = new ArrayList<Integer>();
		for (int i = 0; i < 20; i++)
		{
			a7.add(i);
		}
		a7.add(39);
		a7.add(40);
		a7.add(50);
		a7.add(62);
		list.add(a7);
	
		for (int i = 0; i < list.size(); i++)
		{
			problem3(list.get(i));
		}
		System.out.println();
		for (int i = 0; i < list.size(); i++)
		{
			problem4(list.get(i));
		}
		System.out.println();
		Scanner scan = new Scanner(System.in);
		int userInput = scan.nextInt();
		for (int i = 0; i < list.size(); i++)
		{
			problem5(list.get(i), userInput);
		}
		System.out.println();
		int [] overflowList = {15, 21, 2147483627, 2147483647, -2147483629};
		problem6(overflowList);
	}
	/*
	 * problem3 : finds a 111 sequence
	 * 
	 * returns index in array where the first sequence in the input is located
	 * 
	 * returns -1 if 111 is never found
	 */
	public static void problem3(ArrayList<Integer> arrayList)
	{
		int pattern = -1;
		here:
			for(int i = 0; i < arrayList.size(); i++)
			{
				boolean check1 = false;
				boolean check2 = false;
				int checkVal = arrayList.get(i);
				for (int j = i; j < arrayList.size(); j++)
				{
					int difference = 20;
					if(arrayList.get(j) - checkVal == difference)
						check1 = true;
					if(arrayList.get(j) - checkVal == 2 * difference)
						check2 = true;
					if(check1 == true && check2 == true)
					{
						pattern = i;
						break here;
					}

				}
			}
		System.out.println(pattern);
	}
	/*
	 * problem4 : finds a 110 sequence
	 * 
	 * returns -1 if 11 is found before 110
	 * returns -1 if 110 is never reached with given input
	 */
	public static void problem4(ArrayList<Integer> arrayList)
	{
		int pattern = -1;
		int val1 = 0; int val2 = 0;
		here: 
		for (int i = 0; i < arrayList.size(); i++)
		{
			for(int j = i; j < arrayList.size(); j++)
			{
				val1 = arrayList.get(i);
				val2 = arrayList.get(j);
				if (arrayList.get(j) == arrayList.get(i) + 20)
				{
					pattern = i; 
					break here;
				}
			}
		}
		if (pattern > -1)
		{
			int patternStart = pattern;
			here:
				for (int j = patternStart; j < arrayList.size(); j++)
				{
					val1 = arrayList.get(patternStart);
					val2 = arrayList.get(j);
					if (arrayList.get(j) == arrayList.get(patternStart) + 40) //checks if there is a 111
					{
						pattern = -1;
						break here;
					}
					else if (val2 - val1 > 40) //when the list goes beyond 40 units
					{
						break here;
					}
					else if (j == arrayList.size())
						pattern = -1;
				}
		}
		
		System.out.println(pattern);
	}
	/*
	 * problem5 : finds a 111 sequence where the user inputs the pattern the units should be spaced
	 * 
	 * returns index in array where the first sequence in the input is located
	 * 
	 * returns -1 if 111 is never found
	 */
	public static void problem5(ArrayList<Integer> arrayList, int userInput)
	{
		int pattern = -1;
		here:
			for(int i = 0; i < arrayList.size(); i++)
			{
				boolean check1 = false;
				boolean check2 = false;
				int checkVal = arrayList.get(i);
				for (int j = i; j < arrayList.size(); j++)
				{
					int difference = 20;
					if(arrayList.get(j) - checkVal == difference)
						check1 = true;
					if(arrayList.get(j) - checkVal == 2 * difference)
						check2 = true;
					if(check1 == true && check2 == true)
					{
						pattern = i;
						break here;
					}

				}
			}
		System.out.println(pattern);
	}
	/*
	 * problem6 : finds a 111 sequence and accounts for integer over and underflow
	 * 
	 * returns index in array where the first sequence in the input is located
	 * 
	 * returns -1 if 111 is never found
	 */
	public static void problem6(int[] overflowList)
	{
		int pattern = -1;
		boolean check1 = false;
		boolean check2 = false;
		int checkVal = 0;
		here:
			for(int i = 0; i < overflowList.length; i++)
			{
				check1 = false;
				check2 = false;
				checkVal = overflowList[i];
				for (int j = 0; j < overflowList.length; j++)
				{
					int difference = 20;
					if(Math.abs(checkVal - overflowList[j]) == difference)
						check1 = true;
					else if(Math.abs((2147483647 - overflowList[j]) + (-2147483648 - overflowList[j])) == difference)
						check1 = true;
					if(Math.abs(checkVal - overflowList[j]) == 2 * difference)
						check2 = true;
					else if(Math.abs((2147483647 - overflowList[j]) + (-2147483648 - overflowList[j])) == difference)
						check2 = true;
					if(check1 == true && check2 == true)
					{
						pattern = i;
						break here;
					}
				}
			}
		System.out.println(pattern);
	}
}