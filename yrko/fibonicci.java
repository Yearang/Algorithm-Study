import java.util.Scanner;

public class fibonicci {
	static int a=0, b=0, fibz[], fibo[];
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		int [] n = new int[t];
		for (int i = 0; i < t; i++) 
		{
			fibz = new int[10000];
			fibo = new int[10000];
			fibz[0] = 1;
			fibo[1] = 1;
			n[i] = s.nextInt();
			fibonacci(n[i]);
			
			System.out.println(fibz[n[i]] + " " + fibo[n[i]]);

		}	
		s.close();
	}

	static void fibonacci(int n) {

		int k = 1;
	    if (n == 0) {
	        return;
	    } else if (n == 1) {
	        return;
	    } else {
	    	while(k!=n)
	    	{
	    		k++;
	    		fibz[k] = fibz[k-1] + fibz[k-2];
	    		fibo[k] = fibo[k-1] + fibo[k-2];
	    		
	    	}
	    }
	}
}
