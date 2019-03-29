import java.util.Scanner;

public class Meats {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		int h = s.nextInt();
		int w = s.nextInt();
		
		String [][] matrix = new String[h][w];
		for(int k = 0; k<t; k++) {
		for (int i = 0; i < h; i++) {
			String a = s.next();
			for (int j = 0; j < w; j++) {
				matrix[i][j] = a.substring(j,j+1);				
			}
		}
		
		for (int i = 0; i < h; i++) {
			for (int j = w-1; j >= 0; j--) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		}
	}
}
