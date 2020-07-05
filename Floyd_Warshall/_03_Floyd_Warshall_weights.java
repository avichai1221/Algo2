package Floyd_Warshall;
// Created by Or Kadrawi
//Editing and comments Avichai Israeli

public class _03_Floyd_Warshall_weights {

	static int inf = 999;

	public static void main(String[] args) {

		//Q1 basic floyd warshall to find minimum price
		//מטריצת שכנויות עם משקלים במקום T,F 
		// F עבור  inf נשים 
		int[][] mat = {{0, 4, inf, 3},
				       {4, 0, 15, inf},
			        	{inf, 15, 0, 1},
			        	{3, inf, 1, 0}};
		
		int[][] matH = {{0, 1, inf, inf,1},
			            {1, 0, 1, inf, inf},
			            {inf, 1, 0, 1, inf},
		        	    {inf, inf,1, 0, 1},
		        	    {1, inf, inf, 1, 0}};
		//Print(mat);
	//	floyd_warshall(mat);
		//Print(mat);

		//Q2 floyd warshall to find minimum price with example of path
		int[][] mat2 = {{0, 1, inf, 5},
				        {1, 0, 10, inf},
				        {inf, 10, 0, 3},
			        	{5, inf, 3, 0}};
	//	String[][] path = InitPath(mat.length, mat);
	//	PrintAllPath(path);	
	//	floyd_warshall(mat, path);
	//	FixPath(path);
	//	Print(mat);	
	//	System.out.println();
	//	PrintAllPath(path);	
		
		//Q3 floyd warshall on weights on the vertices 
		int[][] mat3 = {{0,1,inf,1},
				        {1,0,1,inf},
			         	{inf,1,0,1},
			         	{1,inf,1,0}};
		int[] arr = {4,3,2,5}; //מערך של המשקלים של הקודקודים
		int[][] H = InitH(mat3, arr);
		Print(H);
		floyd_warshall(H);
			
		fixH(H, arr);
		Print(H);	
	}

	//Q1
	// מציאת הדרך הזולה ביותר להגיע מכל קודקוד לכל קודקוד
	public static void floyd_warshall(int[][] mat) {
		int size = mat.length;
		for (int k = 0; k < size; k++) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (mat[i][k]!= inf &&  mat[k][j]!= inf)
						if (mat[i][k] + mat[k][j] < mat[i][j])
							mat[i][j] = mat[i][k] + mat[k][j];
				}
			}
		}
	}
	
	// הדפסת המטריצה
	public static void Print(int[][] mat)
	{
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.print(mat[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("-------------------------");
	}

	//Q2
	//יצירת מטריצת הסטרינגים של הנתיבים
	public static String[][] InitPath(int size, int[][] mat) {
		String[][] path = new String[size][size];
		for (int i = 0; i < path.length; i++) {
			for (int j = 0; j < path.length; j++) {
				if (mat[i][j] != inf)
					path[i][j] = (i+1) + "";
			}
		}
		return path;
	}
	//מציאת המסלול ממש
	public static void floyd_warshall(int[][] mat, String[][] path) {
		int size = mat.length;
		for (int k = 0; k < size; k++) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (mat[i][k]!= inf &&  mat[k][j]!= inf)
						if (mat[i][k] + mat[k][j] < mat[i][j])
						{
							mat[i][j] = mat[i][k] + mat[k][j];
							path[i][j] = path[i][k] + "->" + path[k][j];
						}
				}
			}
		}
	}
	// מוסיף את השרשור של קודקוד היעד
	public static void FixPath(String[][] path) {
		for (int i = 0; i < path.length; i++) {
			for (int j = 0; j < path.length; j++) {
				path[i][j] += "->"+(j+1);
			}
		}
	}
	
	// הדפסה של הנתיבים מטריצת הנתיבים
	public static void PrintAllPath(String[][] path) {
		for (int i = 0; i < path.length; i++) {
			for (int j = 0; j < path.length; j++) {
				System.out.print((i+1)+"->"+(j+1)+":\t");
				if (path[i][j] != null)
					System.out.println(path[i][j]);
				else
					System.out.println("NO..");
			}
		}
		System.out.println("-------------------------");
	}
	
	//Q3
	//המרת המטריצה ממשקלים על קודקודים למשקלים על צלעות
	public static int[][] InitH(int[][] mat, int[] arr) {
		int size = mat.length;
		int[][] H = new int[size][size];

		for (int i = 0; i < H.length; i++) {
			for (int j = 0; j < H[i].length; j++) {
				if (mat[i][j] == 1) {
					H[i][j] = arr[i] + arr[j];
				}
				else
				{
					H[i][j] = inf;
				}
			}
		}
		for (int i = 0; i < H.length; i++) { //הזנת האלכסון
			H[i][i] = arr[i];
		}
		return H;
	}
	
	//תיקון של פלויד וורשל כי הכל נספר פעמים חוץ מהקצוות
	public static void fixH(int[][] H, int[] arr) {
		for (int i = 0; i < H.length; i++) {
			for (int j = 0; j < H[i].length; j++) {
				if (i != j)
					H[i][j] = (H[i][j] + arr[i] + arr[j] ) / 2;
			}
		}
	}



	
}
