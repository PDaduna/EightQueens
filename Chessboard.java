public class Chessboard {

	int[] x;
	int counter = 0;

	public Chessboard(int N) {
		x = new int[N];
	}

	public boolean canPlaceQueen(int row, int col) { 
		for (int i = 0; i < row; i++) {
			if (x[i] == col || (i - row) == (x[i] - col) || (i - row) == (col - x[i])) {
				return false;
			}
		}
		return true;
	}

	public void placeTheQueens(int row, int n) {
		
		for (int col = 0; col < n; col++) {
			if (canPlaceQueen(row, col)) {
				x[row] = col;
				if (row == n - 1) {
					counter++;
					printQueens(x);
					
				} else {
					placeTheQueens(row + 1, n);
				}
			}
		}
	}

	public void callPlaceTheQueens() {
		placeTheQueens(0, x.length);
	}
	
	public void printQueens(int[] x) {
		int N = x.length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (x[i] == j) {
					System.out.print("Q ");
				} else {
					System.out.print("* ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String args[]) {
		Chessboard Q = new Chessboard(8);
		Q.callPlaceTheQueens();
		System.out.println(Q.counter);
	}
}