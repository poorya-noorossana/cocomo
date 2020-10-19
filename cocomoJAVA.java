import java.lang.Math;

// implements the COCMO model
public class cocomo {
	// init the program and variables
	public static void main(String[] args) 
	{
		double[][] table = { {2.4, 1.05, 2.5, 0.38}, {3.0, 1.12, 2.5, 0.35}, {3.6, 1.20, 2.5, 0.32} };
		
		String mode[] = {"Organic","Semi-Detached","Embedded"};
		
		int size = 4;
		
		calculate(table, 3, mode, size);
	}
	
	// Function to calculate parameters of Basic COCOMO
	private static void calculate(double[][] table, int n, String[] mode, int size) 
	{
		double effort, time, staff;
		
		int model = 0;
		
		// Check the mode according to size 
	    if(size >= 2 && size <= 50)
	    {
	        model = 0;        //organic 
	    }
	    else if(size > 50 && size <= 300) 
	    {
	        model = 1;        //semi-detached 
	    }  
	    else if(size > 300)
	    {
	        model = 2;        //embedded 
	    }
	    
	    System.out.printf("The mode is %s", mode[model]);
	    
	    // Calculate Effort 
	    effort = table[model][0]*Math.pow(size,table[model][1]);
	    
	    // Calculate Time 
	    time = table[model][2]*Math.pow(effort,table[model][3]);
	    
	    //Calculate Persons Required 
	    staff = effort/time;
	    
	    // Output the values calculated
	    System.out.printf("\nEffort = %.3f Person-Month", effort);
	    
	    System.out.printf("\nDevelopment Time = %.5f Months", time);
	    
	    System.out.printf("\nAverage Staff Required = %d Persons", fround(staff));
	}
	
	// Function for rounding off double to int 
	private static int fround(double x) 
	{
		int a = 0;
		x = x + 0.5;
		a = (int)x;
		return a;
	}
}
