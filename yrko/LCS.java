import java.util.Scanner;

public class LCS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String s1 = s.next();
		String s2 = s.next();
		int[][] matrix = new int[s1.length()][s2.length()];
		int max = 0;
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
//				matrix[i][j] = 
				if(s1.substring(i,i+1).equals(s2.substring(j,j+1)))
				{
					try {
						matrix[i][j] = matrix[i-1][j-1] + 1; 
						if(max < matrix[i][j])
							max = matrix[i][j];
					} catch(Exception e)
					{
						matrix[i][j]++;
						if(max < matrix[i][j])
							max = matrix[i][j];
					}
				}
				else
				{
					if(j >0 && i >0)
						matrix[i][j] = max(matrix[i][j-1],matrix[i-1][j]);
					else if(j == 0 && i ==0)
						matrix[i][j] = 0;
					else if(j == 0)
						matrix[i][j] = matrix[i-1][j];
					else
						matrix[i][j] = matrix[i][j-1];
				}
			}
			
		}
		System.out.println(max);
		
	}
	static int max(int a, int b)
	{
		if(a>b)
			return a;
		else return b;
	}

}
