import student.tetris2.*;
//-------------------------------------------------------------------------
/**
 *  This is the studentBoard class
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Noah Khan(noahk)
 *  @version (2024.04.09)
 */
public class StudentBoard
    implements Board
{
    //~ Fields ................................................................
    
    private int width;
    private int height;
    private int[] columnHeights;
    private int[] blocksInAllRows;
    private boolean[][] grid;
    

    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Initializes a newly created StudentBoard object.
     * @param width is the width of studentboard
     * @param height is the height of the studentboard
     */
    public StudentBoard(int width, int height)
    {
        super();
        /*# Do any work to initialize your class here. */
        grid = new boolean[height][width];
        
        this.width = width;
        this.height = height;
        columnHeights = new int[width];
        blocksInAllRows = new int[height];
        
    }
    
    /**
     * @return the height of the gameboard
     */
    public int getHeight()
    {
        return height;
    }
    
    /**
     * @return the width of the gameboard
     */
    public int getWidth()
    {
        return width;
    }
    
    /**
     * @return an array 
     */
    public int[] getColumnHeights()
    {
        return columnHeights;
    }
    
    /**
     * returns the current status of gameboard
     * @return a 2d boolean array
     */
    public boolean[][] getGrid() 
    {
        return grid;
    }

    /**
     * clears all full rows on the gameboard
     * @return True if any rows were remove, false otherwise
     */
    public boolean clearRows()
    {
        boolean wereAnyRowsRemoved = false;
        
        for ( int i = 0; i < height; i++)
        {
            if (blocksInAllRows[i] == width)
            {
                int n = i;
            
                for ( ; n < height - 1; ++n)
                {
                    for (int a = 0; a < width; ++a)
                    {
                        grid[a][n] = grid[a][n + 1];
                        blocksInAllRows[n] = blocksInAllRows[n + 1];
                    }
                }
                
                return true;
            }

        }
        
        return false;
    }
    
    /**
     * places game piece at specified postion
     * @param piece The piece to place on gameboard
     * @param position The position at which to place game piece
     * @return Board.place if placed successfully
     */
    public int place(Piece piece, Point position)
    {
        int posX = position.getX();
        int posY = position.getY();
        
        Point[] pieceBody = piece.getBody();
        for (Point point : pieceBody)
        {
            int blockX = point.getX() + posX;
            int blockY = point.getY() + posY;
            
            if ( blockX >= width || 
                blockY >= height)
            {

                return Board.PLACE_OUT_BOUNDS;
            }
            else if (blockX < 0 || blockY < 0)
            {
                return Board.PLACE_OUT_BOUNDS; 
            }
            
            if (grid[blockY][blockX])
            {
                return Board.PLACE_BAD;
            }
            grid[blockY][blockX] = true;
            blocksInAllRows[blockY]++ ;
            
            if (blockY + 1 > columnHeights[blockX])
            {
                columnHeights[blockX] = blockY + 1;
            }

        }
        
        for (int x = 0; x < height; x++)
        {
            if (blocksInAllRows[x] == width)
            {
                return Board.PLACE_ROW_FILLED;
            }
        }
        
        return Board.PLACE_OK;
    }
    
    
    /**
     * checks if there is block at specified point on gameboard
     * @param point The point at which to check for block
     * @return True if there is a block
     */
    public boolean hasBlockAt(Point point)
    {
        int xAxis = point.getX();
        int yAxis = point.getY();
        return grid[yAxis][xAxis];
    }
    
    /**
     * @return An array where each element corresponds to the number of blocks
     */
    public int[] getBlocksInAllRows()
    {        
        return blocksInAllRows;
    }
    


    

    //~ Methods ...............................................................


}
