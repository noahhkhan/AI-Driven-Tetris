import student.micro.*;
import static org.assertj.core.api.Assertions.*;
import student.tetris2.*;


// -------------------------------------------------------------------------
/**
 *  This is the test class for student board
 *  Summarize what your test objectives are.
 *
 *  @author Noah Khan(noahk)
 *  @version (2024.04.09)
 */
public class StudentBoardTest
    extends TestCase
{
    //~ Fields ................................................................
    
    private StudentBoard studentBoard;
    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new StudentBoardTest test object.
     */
    public StudentBoardTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        /*# Insert your own setup code here */
        studentBoard = new StudentBoard(10, 24);
    }

    /**
     * this test method getsHeight()
     */
    public void testGetHeight()
    {
        assertEquals(24, studentBoard.getHeight());
    }
    
    /**
     * this test method tests getWidth()
     */
    public void testGetWidth()
    {
        assertEquals(10, studentBoard.getWidth());
    }
    
    /**
     * this method tests clearRows()
     */
    public void testClearRows()
    {
        StudentBoard start = BoardUtilities.newBoard(StudentBoard.class,
            10, 4,
            "          ",
            "          ",
            "          ",
            "#### #####"
            );
        
        assertFalse(start.clearRows());
    
    }
    
         
    /**
     * this method tests existingdata on clearRows()
     */
    public void testClearRowsExistingData() 
    {
        
        StudentBoard board = BoardUtilities.newBoard(
            StudentBoard.class,
            10, 3,
            "##########",
            "   #   #",
            "   #   #"
        );

        
        boolean rowsCleared = board.clearRows();
        
        
        assertThat(rowsCleared).isTrue();
        
        
        StudentBoard expected = BoardUtilities.newBoard(
            StudentBoard.class,
            10, 3,
            "        ",
            "   #   #",
            "   #   #"
        );

         
        assertThat(BoardUtilities.equals(board, expected)).isFalse();  
    }

    
    /**
     * this tests HasBlockAt() method
     */
    public void testHasBlockAt0()
    {
        StudentBoard jonah = BoardUtilities.newBoard(StudentBoard.class,
            10, 24,
            "#### #####",
            "          "
        ); 
        
        Point noah = new Point(5, 0);
        assertThat(jonah.hasBlockAt(noah)).isFalse();
    }
    
    /**
     * test method for hasblockat 1
     */
    public void testHasBlockAt1()
    {
        StudentBoard jonah = BoardUtilities.newBoard(StudentBoard.class,
            10, 24,
            "#### #####",
            "          "
        );
        
        Point noah = new Point(1, 1);
        assertThat(jonah.hasBlockAt(noah)).isTrue();
    }
    
    /**
     * test method for hasblockat 2
     */
    public void testHasBlockAt2()
    {
        StudentBoard jonah = BoardUtilities.newBoard(StudentBoard.class,
            24, 10,
            "#### #####",
            "          "
        );
        
        Point noah = new Point(10, 1);
        assertThat(jonah.hasBlockAt(noah)).isFalse();
    }
    
    /**
     * test method for hasblock3
     */
    public void testHasBlockAt3()
    {
        StudentBoard jonah = BoardUtilities.newBoard(StudentBoard.class,
            10, 24,
            "#### #####",
            "          "
        );
        
        Point noah = new Point(0, 0);
        assertThat(jonah.hasBlockAt(noah)).isFalse();
    }
    
    /**
     * test method for hasblock4
     */
    public void testHasBlockAt4()
    {
        StudentBoard jonah = BoardUtilities.newBoard(StudentBoard.class,
            10, 24,
            "#### #####",
            "          "
        );
        
        Point noah = new Point(4, 3);
        assertThat(jonah.hasBlockAt(noah)).isFalse();
    }
    
    /**
     * is test method for place
     */
    public void testLonRow0()
    {
        StudentBoard jonah = BoardUtilities.newBoard(StudentBoard.class,
            10, 24,
            "          ",
            "          "
        );
        
        Piece newPiece = Piece.getPiece(Piece.SQUARE, 0);
        Point noah = new Point(1, 1);
        
        int result = jonah.place(newPiece, noah);
        assertThat(result).isEqualTo(Board.PLACE_OK);
    }
    
    /**
     * this test method tests place()
     */
    public void testPlace()
    {
        StudentBoard board = BoardUtilities.newBoard(StudentBoard.class,
            10, 24,
            "#### #####"
            );
    
        Piece newPiece = Piece.getPiece(Piece.SQUARE, 0);
        Point noah = new Point(1, 1);
        
        int result = board.place(newPiece, noah);
        boolean isTrue = board.clearRows();
        assertThat(result).isEqualTo(Board.PLACE_ROW_FILLED);
        assertThat(isTrue).isEqualTo(true);
            
    }    

    // ----------------------------------------------------------
    /*# Insert your own test methods here */

}
