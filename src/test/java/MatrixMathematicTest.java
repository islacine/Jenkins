


import model.Matrix;
import service.MatrixMathematics;
import exception.NoSquareException;

import org.junit.Test;
import static org.junit.Assert.*;



public class MatrixMathematicTest {

    @Test
    public void determinantTest() throws NoSquareException{
        double [][] data = {{6,4,0},{4,6,1},{0,1,6}};
        Matrix m1 = new Matrix(data);
        double det = 114;
        assertEquals(MatrixMathematics.determinant(m1),det,0);
    }


    @Test
    public void cofactorTest () throws NoSquareException{
        double [][] mat = {{6,4,0},{4,6,1},{0,1,6}};
        double [][] matCof = {{35,-24,4},{-24,36,-6},{4,-6,20}};
        Matrix matt = new Matrix(mat);
        assertArrayEquals(MatrixMathematics.cofactor(matt).getValues(),matCof);

    }

    /*********** rendre le couvrage egale a 100% *******************/


    @Test (expected = NoSquareException.class )
    public void determinantThrowTest() throws NoSquareException{
        double [][] data = {{6,4,0},{4,6,1}};
        Matrix m1 = new Matrix(data);
        MatrixMathematics.determinant(m1);
    }

    @Test (expected = NoSquareException.class )
    public void cofactorThrowTest () throws NoSquareException{
        double [][] mat = {{6,4,0},{4,6,1}};
        Matrix matt = new Matrix(mat);
        MatrixMathematics.cofactor(matt);

    }


}
