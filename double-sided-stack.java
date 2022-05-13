import edu.princeton.cs.algs4.StdOut;

public class DoubleStack
{
	private int[] arr;  // our int array
	private int N_l;  // current size of left
	private int N_r;  // current size of right
	
	/** Construct a DoubleStack that can store n integers. */
	public DoubleStack(int n)
	{
		arr = new int[n];
		N_l = 0;
		N_r = 0;
	}
	
	public void printArr()
	{
		System.out.print("[" + arr[0]);
		for(int i = 1; i < arr.length; i++)
		{
			 System.out.print(", " + arr[i]);
		}
		System.out.print("], N_l = " + N_l + ", N_r = " + N_r + "\n");
	}

	/** Determines if Double Stack is full. */
	public boolean isFull()
	{
		return ((N_r + N_l) == arr.length);
	}

	/** Returns the number of int values in the left stack. */
	public int sizeLeft()
	{
		return N_l;
	}

	/** Returns the number of int values in the right stack. */
	public int sizeRight()
	{
		return N_r;
	}

	/** If DoubleStack is not full, push value onto the left stack. */
	public void pushLeft(int v)
	{
		if(isFull())
		{
			throw new IllegalStateException("DoubleStack full. cannot push left.");
		}
		arr[N_l] = v;
		N_l++;
	}

	/** If DoubleStack is not full, push value onto the right stack. */
	public void pushRight(int v)
	{
		if(isFull())
		{
			throw new IllegalStateException("DoubleStack full. cannot push right.");
		}
		arr[arr.length - N_r - 1] = v;
		N_r++;
	}
	
	/**
	 * If left and right contain at least one value, exchange the top values found on both stacks.
	 * If either the left or right side is empty, throw new IllegalStateException.
	 */
	public void exchange()
	{
		if((N_r == 0) || (N_l == 0))
		{
			throw new IllegalStateException("at least one side empty. cannot exchange."); 
		}
		int temp = arr[N_l - 1];
		arr[N_l - 1] = arr[arr.length - N_r];
		arr[arr.length - N_r] = temp;
	}
	
	/** Pop and return the topmost value from left stack. */
	public int popLeft()
	{
		if(N_l == 0)
		{
			throw new IllegalStateException("left side empty. cannot pop left");
		}
		
		int R = arr[N_l - 1];
		
		arr[N_l - 1] = 0;
		N_l--;
		
		return R;
	}

	/** Pop and return the topmost value from right stack. */
	public int popRight()
	{
		if(N_r == 0)
		{
			throw new IllegalStateException("right side empty. cannot pop right");
		}
		
		int R = arr[arr.length - N_r];
		
		arr[arr.length - N_r] = 0;
		N_r--;
		
		return R;
	}
}
