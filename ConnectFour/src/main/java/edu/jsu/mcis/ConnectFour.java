package edu.jsu.mcis;

public class ConnectFour {
    public enum Token { RED, BLACK, EMPTY }
    public enum Result { NONE, RED_WIN, BLACK_WIN, TIE }
    public static final int COLUMNS = 7;
    private final int ROWS = 6;
    private Token[][] board;
    private boolean redTurn;
    
    public ConnectFour() {
        board = new Token[ROWS][COLUMNS];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = Token.EMPTY;
            }
        }
        redTurn = true;
    }
    
    public Token getTopOfColumn(int col) {
		if(getHeightOfColumn(col) == 0) {
			return board[0][col];
		}
		else{
			return board[ROWS - getHeightOfColumn(col)][col];
		}
    }
    
    public int getHeightOfColumn(int col) {
		int height = 0;
        for(int i = 5; i >= 0; i--) {
			if(board[i][col] != Token.EMPTY) {
				height = height + 1;
			}
		}	
		return height;
    }
    
    public boolean dropTokenInColumn(int col) {
		boolean ableToDrop = false;
		if(board[5][col] == Token.EMPTY) {
			board[5][col] = (redTurn)? Token.RED : Token.BLACK;
			redTurn = !redTurn;
			ableToDrop = true;
		}
		else if(board[4][col] == Token.EMPTY) {
			board[4][col] = (redTurn)? Token.RED : Token.BLACK;
			redTurn = !redTurn;
			ableToDrop = true;
		}
		else if(board[3][col] == Token.EMPTY) {
			board[3][col] = (redTurn)? Token.RED : Token.BLACK;
			redTurn = !redTurn;
			ableToDrop = true;
		}
		else if(board[2][col] == Token.EMPTY) {
			board[2][col] = (redTurn)? Token.RED : Token.BLACK;
			redTurn = !redTurn;
			ableToDrop = true;
		}
		else if(board[1][col] == Token.EMPTY) {
			board[1][col] = (redTurn)? Token.RED : Token.BLACK;
			redTurn = !redTurn;
			ableToDrop = true;
		}
		else if(board[0][col] == Token.EMPTY) {
			board[0][col] = (redTurn)? Token.RED : Token.BLACK;
			redTurn = !redTurn;
			ableToDrop = true;
		}
		else {
			ableToDrop = false;
		}
		
		getResult();
		//System.out.println("|" + makeStringFromColumn(col) + "|");
		return ableToDrop;
    }

    public Result getResult() {
		for(int i = 0; i < COLUMNS; i++) {
			if(doesRedWinVerticallyInColumn(i)) {
				return Result.RED_WIN;
			}
		}
		for(int j = 0; j < ROWS; j++) {
			if(doesBlackWinHorizontallyInRow(j)) {
				return Result.BLACK_WIN;
			}
		}
		return Result.TIE;
    }
    
    
    // Here are a couple of private methods to give you
    // an idea of a more clever way to determine winners.
    private boolean doesRedWinVerticallyInColumn(int col) {
        String columnString = makeStringFromColumn(col);
        return (columnString.indexOf("RRRR") >= 0);
    }

	private boolean doesBlackWinHorizontallyInRow(int row) {
	    String columnString = makeStringFromRow(row);
	    return (columnString.indexOf("BBBB") >= 0);
	}
    
    private String makeStringFromColumn(int col) {
        String s = "";
        for(int row = 0; row < ROWS; row++) {
            if(board[row][col] == Token.RED) s += "R";
            else if(board[row][col] == Token.BLACK) s += "B";
            else s += " "; 
        }
        return s;
    }

	private String makeStringFromRow(int row) {
		String s = "";
	    for(int col = 0; col < COLUMNS; col++) {
	    	if(board[row][col] == Token.RED) s += "R";
	        else if(board[row][col] == Token.BLACK) s += "B";
	        else s += " "; 
	    }
	    return s;
	}
}












