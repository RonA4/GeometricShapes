/**
 * Name ---> Ron Amsalem
 * ID ---> 326029600
 */

package src.ex2.geo.Test;
import ex2.geo.Point_2D;
import ex2.geo.Rect_2D;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class Rect_2DTest {
    @Test
    /**
     *
     * a ---> the first point that makes up the diagonal of the rect , (2,2).
     * b ---> the first point that makes up the diagonal of the rect , (6,5).
     * ot --->  Creating the point we want to test (4,3).
     */
    public void testRectContain() {
        Point_2D a = new Point_2D(2, 2);
        Point_2D c = new Point_2D(6, 5);
        Point_2D ot = new Point_2D(4, 3);
        Rect_2D rect = new Rect_2D(a, c);
        boolean isContain = rect.contains(ot);
        Assertions.assertTrue(isContain);

    }

    /**
     * The test checks whether the 'area()' function calculates an area correctly.
     * a ---> The first point that makes up the diagonal of the rect,(2,2).
     * b ---> The second point that makes up the diagonal of the rect, (6,5).
     * rect ---> creating a rect.
     * ExpectedArea ---> Expected area (manually calculated).
     * area ---> area calculated by the function
     */
    @Test
    public void testRectArea() {
        Point_2D a = new Point_2D(2, 2);
        Point_2D c = new Point_2D(6, 5);
        Rect_2D rect = new Rect_2D(a, c);
        double area = rect.area();
        double ExpectedArea = 12;
        Assertions.assertEquals(ExpectedArea, area);

    }

    @Test
    /**
     * The test checks whether the 'perimeter()' function calculates a perimeter correctly.
     * a ---> The first point that makes up the diagonal of the rect,(2,2).
     * b ---> The second point that makes up the diagonal of the rect, (6,5).
     * rect ---> creating a rect.
     * expectedPerimeter ---> Expected perimeter (manually calculated).
     * perimeter ---> Perimeter calculated by the function.
     */
    public void testRectPerimeter() {
        Point_2D a = new Point_2D(2, 2);
        Point_2D c = new Point_2D(6, 5);
        Rect_2D rect = new Rect_2D(a, c);
        double perimeter = rect.perimeter();
        double expectedPerimeter = 14.0;
        Assertions.assertEquals(expectedPerimeter, perimeter);
    }

    /**
     * this test checking 'translate()' function
     * vec ---> vector through whose values we will move the shape( 2, 2).
     * a --->  The first point that makes up the diagonal of the rect,(2,2).
     * b ---> The second point that makes up the diagonal of the rect, (6,5).
     * rect ---> creating a rect.
     */
    @Test
    public void testRectTranslate() {
        Point_2D vec = new Point_2D(2, 2);
        Point_2D a = new Point_2D(2, 2);
        Point_2D c = new Point_2D(6, 5);
        Rect_2D rect = new Rect_2D(a, c);
        rect.translate(vec);
        Assertions.assertEquals(4, rect.getA().x());
        Assertions.assertEquals(4, rect.getA().y());
        Assertions.assertEquals(8, rect.getC().x());
        Assertions.assertEquals(7, rect.getC().y());
    }

    /**
     * a --->  The first point that makes up the diagonal of the rect,(2,2).
     * b ---> The second point that makes up the diagonal of the rect, (6,5).
     * rect ---> creating a rect.
     * copyRect ---> creating a copy rect.
     */
    @Test
    public void testRectCopy() {
        Point_2D a = new Point_2D(2, 2);
        Point_2D c = new Point_2D(6, 5);
        Rect_2D rect = new Rect_2D(a, c);
        Rect_2D copyRect = (Rect_2D) rect.copy();
        Assertions.assertEquals(2, copyRect.getA().x());
        Assertions.assertEquals(2, copyRect.getA().y());
        Assertions.assertEquals(6, copyRect.getC().x());
        Assertions.assertEquals(5, copyRect.getC().y());
    }

    /**
     * The test checks if the 'scale()' function works properly.
     * a --->  The first point that makes up the diagonal of the rect,(2,2).
     * b ---> The second point that makes up the diagonal of the rect, (6,5).
     * rect ---> creating a rect.
     * center   ---> Creating a center point, (1,1).
     * ratio---> the ratio.
     */
    @Test
    public void testRectScale() {
        Point_2D a = new Point_2D(2, 2);
        Point_2D c = new Point_2D(6, 5);
        Rect_2D rect = new Rect_2D(a, c);
        double ratio = 2;
        Point_2D center = new Point_2D(1, 1);
        rect.scale(center, ratio);
        Assertions.assertEquals(3, rect.getA().x());
        Assertions.assertEquals(3, rect.getA().y());
        Assertions.assertEquals(11, rect.getC().x());
        Assertions.assertEquals(9, rect.getC().y());
    }

    /**
     * The test checks whether the 'rotate()' function works properly.
     * a --->  The first point that makes up the diagonal of the rect,(2,2).
     * b ---> The second point that makes up the diagonal of the rect, (6,5).
     * rect ---> creating a rect.
     */
    @Test
    public void testRectRotate() {
        Point_2D a = new Point_2D(2, 2);
        Point_2D c = new Point_2D(6, 5);
        Rect_2D rect = new Rect_2D(a, c);
        rect.rotate(a, 90);
        Assertions.assertEquals(2, rect.getA().x());
        Assertions.assertEquals(2, rect.getA().y());
        Assertions.assertEquals(-1, rect.getB().x());
        Assertions.assertEquals(2, (int) rect.getB().y());
        Assertions.assertEquals(-1, rect.getC().x(), 0001);
        Assertions.assertEquals(6, rect.getC().y(), 0001);
        Assertions.assertEquals(2, (int) rect.getD().x());
        Assertions.assertEquals(6, rect.getD().y());

    }

    /**
     * This test check if the function 'toString' works properly.
     * a ---> the point of a rect, (3,4).
     * b ---> the point of a rect, (6,8).
     * c ---> the point of a rect, (6,4).
     * d ---> the point of a rect, (5,8).
     * rect --- > creating a new rect.
     */
    @Test
    public void testRectToString(){
        Point_2D a = new Point_2D(3, 4);
        Point_2D b = new Point_2D(6,8);
        Point_2D c = new Point_2D(6, 4);
        Point_2D d = new Point_2D(5,8);
        Rect_2D rect = new Rect_2D(a,b,c,d);
        String expected = "3.0,4.0,6.0,4.0,6.0,8.0,5.0,8.0";
        String  actual = rect.toString();
        Assertions.assertEquals(expected, actual);

    }
    /**
    *  This test check if the function 'equals()' works properly.
     * rect1 ---> creating a new rect with the points : (3, 4),(6,8),(6, 4),(5,8) .
     * rect2--->  creating a new rect with the points : (2, 2),(6,5),(6, 2),(2,5) .
     */
    @Test
    public void testRectEquals(){
        Point_2D a_1 = new Point_2D(3, 4);
        Point_2D b_1 = new Point_2D(6,8);
        Point_2D c_1 = new Point_2D(6, 4);
        Point_2D d_1 = new Point_2D(5,8);
        Rect_2D rect1 = new Rect_2D(a_1,b_1,c_1,d_1);
        Point_2D a_2 = new Point_2D(2, 2);
        Point_2D b_2 = new Point_2D(6,5);
        Point_2D c_2 = new Point_2D(6, 2);
        Point_2D d_2 = new Point_2D(2,5);
        Rect_2D rect2 = new Rect_2D(a_2,b_2,c_2,d_2);
        boolean isEquals = rect1.equals(rect2);
        Assertions.assertFalse(isEquals);

    }


}
