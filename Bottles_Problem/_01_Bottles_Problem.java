package Bottles_Problem;
//Created by Or Kadrawi
//Editing and comments Avichai Israeli
public class _01_Bottles_Problem { //סיבוכיות O(M*N)^2 מילוי המטריצה

	public static void main(String[] args) {
		int m = 2; // first bottle
		int n = 1; // second bottle
		boolean[][] mat = BottlesProblem(m,n);
		Print(mat);
	}
//יצירת מטריצת השכנויות
	public static boolean[][] BottlesProblem(int m, int n) {
		int size = (m + 1) * (n + 1); //גודל המטריצה
		boolean[][] mat = new boolean[size][size];
		
		// first method
		int k;
		for (int i = 0; i < m+1; i++) {
			for (int j = 0; j < n+1; j++) {
				k = getIndex(i,j,n);
				//  T כל ששת המצבים האפשריים של הבקבוקים נסמן ב 
				mat[k][getIndex(0,j,n)] = true;	//ריקון הראשון
System.out.println(mat[k][getIndex(0,j,n)]);
				mat[k][getIndex(i,0,n)] = true;	//ריקון השני
				System.out.println(k);

				mat[k][getIndex(m,j,n)] = true;	//מילוי הראשון
				System.out.println(mat[k][getIndex(m,j,n)]);

				mat[k][getIndex(i,n,n)] = true;	//מילוי השני
				System.out.println(mat[k][getIndex(0,n,n)]);

				mat[k][getIndex(i+j-(Math.min(i+j, n)),Math.min(i+j, n),n)] = true;	//לשפוך מהראשון לשני	
				System.out.println(mat[k][getIndex(i+j-(Math.min(i+j, n)),Math.min(i+j, n),n)]);

				mat[k][getIndex(Math.min(i+j, m),i+j-Math.min(i+j, m),n)] = true; //לשפוך מהשני לראשון	
				System.out.println(mat[k][getIndex(Math.min(i+j, m),i+j-Math.min(i+j, m),n)]);

			}
		}
		
		// second method
	/*	int i,j;
		for (int k = 0; k < mat.length; k++) {
			i = getI(k,n);
			j = getJ(k,n);
			mat[k][getIndex(0,j,n)] = true;
			mat[k][getIndex(i,0,n)] = true;
			mat[k][getIndex(m,j,n)] = true;
			mat[k][getIndex(i,n,n)] = true;
			mat[k][getIndex(i+j-(Math.min(i+j, n)),Math.min(i+j, n),n)] = true;
			mat[k][getIndex(Math.min(i+j, m),i+j-Math.min(i+j, m),n)] = true;
		}*/
		return mat;
	}
	
	public static int getIndex(int i, int j, int n) // פונקציה שממירה לנו ערך של בקבוק (2 קורדינאטות) לערך יחיד
	{// מקבל את מס' העמודות ואת 2 הקורדינאטות
		return (n+1)*i + j;
	}
	
	
	
	
	 // הפעולה ההפוכה (מערך יחיד ל2 הקורדינאטות) 
	  public static int getI(int k, int n)
	{
		return k / (n+1);
	}
	
	public static int getJ(int k, int n)
	{
		return k % (n+1);
	}
	
	
	//הדפסת המטריצה שיצרנו
	public static void Print(boolean[][] mat)
	{
		int rows = mat.length;
		int cols = mat[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(mat[i][j]+"\t");
			}
			System.out.println();
		}
	}

}