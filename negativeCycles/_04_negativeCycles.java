package negativeCycles;
import Floyd_Warshall._03_Floyd_Warshall_weights;
// Created by Or Kadrawi
//Editing and comments Avichai Israeli
public class _04_negativeCycles {
	static int inf = 1000000;

	public static void main(String[] args) {
		
		
		System.out.println("    v2");
		System.out.println("    /\\");
		System.out.println("  1/  \\-5");
		System.out.println("  /    \\");
		System.out.println("v1------v3");
		System.out.println("    2");
		int[][] mat = {{0,1,inf},
						{inf,0,-5},
						{2,inf,0}};
		String[][] path = _03_Floyd_Warshall_weights.InitPath(mat.length, mat);

		_03_Floyd_Warshall_weights.floyd_warshall(mat, path);
		_03_Floyd_Warshall_weights.FixPath(path);
		_03_Floyd_Warshall_weights.Print(mat);
		int indexOfNegativeCycle=IsNegativeCycle(mat);
		if (indexOfNegativeCycle != -1) {
			System.out.println("There is negative cycle!");
			System.out.println("Example: "+path[indexOfNegativeCycle][indexOfNegativeCycle]);
		}
		else
		{
			System.out.println("There isn't negative cycle!");
		}
	}
	// בדיקה אם יש מעגל שלילי בגרף מכוון
	private static int IsNegativeCycle(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
				if (mat[i][i]<0)
					return i;
		}
		return -1; //אין מעגל שלילי
	}
	



}
