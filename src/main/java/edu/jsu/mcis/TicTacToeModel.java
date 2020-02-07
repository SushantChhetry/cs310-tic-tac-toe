package edu.jsu.mcis;

//import javax.lang.model.element.NestingKind;

//import com.oracle.webservices.internal.api.EnvelopeStyle;

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
        
        if (isValidSquare(row, col))
        {
            if (!isSquareMarked(row, col))
            {
                if (isXTurn())
                {
                    
                    board[row][col] = Mark.X;
                    xTurn = false;
                 
                }
                
                else 
                {
                    
                    board[row][col] = Mark.O;
                    xTurn = true;
                
                }
                
                return true;
            }

            else
                {
                
                    System.out.println("The specified square is not empty");
                    return false;
                
                }
            
        }

        else
            {
                
                System.out.println("Specifies location is out of range");
                return false;

            }
        
        
        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return TRUE if the specified location is within the bounds of the board */
        
        // INSERT YOUR CODE HERE
        boolean squareValid = false;
        if ((row>=0)&&(col>=0)&&(row<width)&&(col<width))
        {
            squareValid = true;
        }
       return squareValid;
        
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return TRUE if the square at specified location is marked */
        if (getMark(row, col) == Mark.X)
        {
            
            return true;

        }
        
        else if (getMark(row, col) == Mark.O)
        {
            
            return true;

        }
        
        else if (getMark(row, col)== Mark.EMPTY)
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
        if (isMarkWin(Mark.X)==true)
        {

            return Result.X;

        }

        else if (isMarkWin(Mark.O)==true)
        {
            
            return Result.O;

        }

        else if (isTie()==true)
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

        int secondDiagonal= 0;
        int firstDiagonal = 0;
        int acrossCount = 0;
        int downCount = 0;

        boolean winCondition = false;
        
        for(int i=0; i<width; ++i)
        {
            for ( int j =0;j<width; ++j)
            {
                if (board[i][j].equals(mark) )
                {
                    ++acrossCount;
                }
                if(board[j][i].equals(mark))
                {
                    ++downCount;
                }
                
            }
            
            if(board[i][i].equals(mark))
            {
                ++firstDiagonal;
            }
            if(board[diagonalWidth][i].equals(mark) )
            {
                ++secondDiagonal;
                --diagonalWidth;
            }
            if((acrossCount==width)||(downCount==width)||(firstDiagonal==width)||(secondDiagonal==width))
            {
                winCondition = true;
            }

            acrossCount = 0;
            downCount = 0;

            
        }
        return winCondition;
    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */
        
        boolean isTie = false;
        boolean emptySquare = false;
        
        for(int i=0;i<this.width;++i)
        {
        	
        	for(int j=0;j<this.width;++j)
        	{
        	
                if( isSquareMarked(i, j) == false )
                {
                    
                    emptySquare = true;

                    break;
                

                }
        	
        	}
        }
            if ( (emptySquare == false) &&  (isMarkWin(Mark.X) == false) && (isMarkWin(Mark.O) == false) ) 
            {

                isTie= true;

            }
            
        
        return isTie;
                
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
        
        StringBuilder output = new StringBuilder("");
        
        /* Output the board contents as a string (see examples) */
        
        for(int i = 0; i < getWidth(); ++i) {
            output.append(i);
        }
        output.append("\n\n");

        for(int i = 0; i < getWidth(); ++i)
    {
        output.append(i).append(" ");
        for(int j = 0; j < getWidth(); ++j)
        {
            Mark x = board[i][j];
            String a = x.toString();
            output.append(a);
        }
        if(i<width-1) {
            output.append("\n");
        }

    }    

    output.append("\n\n");
    
        
        return output.toString();
        
    }
    
}
