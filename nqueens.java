boolean isSafe(int board[][], int row, int col) 
	{ 
		int i, j,N=board.length; 
		for (i = 0; i < col; i++) 
			if (board[row][i] == 1) 
				return false; 
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--) 
			if (board[i][j] == '*') 
				return false; 
		for (i = row, j = col; j >= 0 && i < N; i++, j--) 
			if (board[i][j] == '*') 
				return false; 
 
		return true; 
	} 
 
	static boolean solveNQUtil(char board[][], int col) 
	{ int N=board.length;
		if (col >= N) 
			return true; 
 
		for (int i = 0; i < N; i++) { 
			if (isSafe(board, i, col)) { 
				board[i][col] = 'Q'; 
				if (solveNQUtil(board, col + 1) == true) 
					return true; 
				board[i][col] = '*';
			} 
		} 
		return false; 
	} 
 
	public static char[][] Met(char[][] board)
	{
		if (solveNQUtil(board, 0) == false) { 
			System.out.print("Solution does not exist");
		}
		return board; 
	}
