package edu.jsu.mcis;

import com.oracle.webservices.internal.api.EnvelopeStyle;

public class TicTacToeModel {
    
    private Mark[][] board; /* Game board */
    private boolean xTurn;  /* True if X is current player */
    private int width;      /* Size of game board */
    
    /* ENUM TYPE DEFINITIONS */
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a TIE,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("TIE"), 
        NONE("NONE");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        this(TicTacToe.DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create board (width x width) as a 2D Mark array */
        
        board = new Mark[width][width];
         

        /* Initialize board by filling every square with empty marks */
        
        // INSERT YOUR CODE HERE
        for(int i=0;i<this.width;i++)
        {
        	
        	for(int j=0;j<this.width;j++)
        	{
        	
        		board[i][j]= Mark.EMPTY;
        	
        	}
        }
        
    }
	
    public boolean makeMark(int row, int col) {
        
        if (isValidSquare(row, col)== true)
        {
            if (isSquareMarked(row, col)!=true)
            {
                if (isXTurn())
                {
                    
                    board[row][col] = Mark.X;
                    xTurn = false;
                 
                }
                
                else if (!isXTurn())
                {
                    
                    board[row][col] = Mark.O;
                    xTurn = true;
                
                }
                
                return true;
            }

            else
                {
                
                    system.out.println("The specified square is not empty");
                    return false;
                
                }
            
        }

        else
            {
                
                system.out.println("Specifies location is out of range");
                return false;

            }
        
        
        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return TRUE if the specified location is within the bounds of the board */
        
        // INSERT YOUR CODE HERE
        if ((row<width)&&(col<width))
        {
            return true;
        }
       
        else
        {
            return false;
        }
        
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return TRUE if the square at specified location is marked */
        if (board[row][col].Mark = Mark.X)
        {
            
            return true;

        }
        
        else if (board[row][col].Mark = Mark.O)
        {
            
            return true;

        }
        
        else if (board[row][col].Mark = Mark.EMPTY)
        {
            
            return false;

        }
        
        else
        {
            
            System.out.println("Error: Can't Check if square is marked");
            return false;

        }
            
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return the mark from the square at the specified location */
        
       
        return board[row][col];

        
            
    }
	
    public Result getResult() {
        
        /* Call "isMarkWin()" to see if X or O is the winner, if the game is a
           TIE, or if the game is not over.  Return the corresponding Result
           value */
        
        // INSERT YOUR CODE HERE
        if (isMarkWin(Mark.X))
        {

            return Result.X;

        }

        else if (isMarkWin(Mark.O))
        {
            
            return Result.O;

        }

        else if (isTie())
        {
           
            return Result.TIE;

        }

        else 
        {
            
            return Result.NONE;

        }
  
        
    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        int diagonalWidth = width -1 ;

        int secondtDiagonal= 0;
        int firstDiagonal = 0;
        // INSERT YOUR CODE HERE

        for(int i=0;i<width;i++)
        {
        	if((board[i][i]==mark))
                {
                    
                    firstDiagonal++;

                }
                  	
        }
        if(firstDiagonal==width)
        {
            return true;

        }

        
        for(int i=0;i<width;i++)
        {
        	
        	
                if((board[i][diagonalWidth]==mark))
                {
                    
                    secondDigonal++;
                    diagonalWidth--;

                }
        	     	
        }
        if(secondtDiagonal== width)
        {
            return true;

        }
        

        for(int i=0;i<width;i++)
        {
        	
        	for(int j=0;j<width;j++)
        	{
        	
                if((board[i][j]==mark))
                {
                    firstDiagonal++;
                }
        	
            }
            if(firstDiagonal == width)
            {
                return true;
            }
        }

        for(int i=0;i<width;i++)
        {
        	
        	for(int j=0;j<width;j++)
        	{
        	
                if((board[j][i]==mark))
                {
                    firstDiagonal++;
                }
                
                if(firstDiagonal == width)
                {
                    return true;
                }    
        	
            }
           
        }
        

        return false; // remove this line later!

    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */
        
        // INSERT YOUR CODE HERE
        for(int i=0;i<this.size;i++)
        {
        	
        	for(int j=0;j<this.size;j++)
        	{
        	
                if(board[i][j]= Mark.EMPTY)
                {
                    
                    return false;

                }
        	
        	}
        }
            if ((!isMarkWin(Mark.X)) || (!isMarkWin(Mark.O)))
            {

                return false;

            }
            
            else
            {
               
                return true;
                
            }
                
    }

    public boolean isGameover() {
        
        /* Return TRUE if the game is over */
        
        return (Result.NONE != getResult());
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
    @Override
    public String toString() {
        
        StringBuilder output = new StringBuilder("  ");
        
        /* Output the board contents as a string (see examples) */
        
        // INSERT YOUR CODE HERE
        
        return output.toString();
        
    }
    
}
