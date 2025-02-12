/**
 * Name ---> Ron Amsalem
 * ID ---> 326029600
 */
package src.ex2.geo.Test;
import ex2.ex2.Ex2_Const;
import ex2.geo.Point_2D;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class Point_2DTest {
    /*
    Defining points in order to have a more understandable and readable code
     */
    private Point_2D P1_2 = new Point_2D(1,2);
    private Point_2D P4_6 = new Point_2D(4,6);

    @Test
    /**
     * This test checks whether the distance between two points is calculated correctly.
     * point ---> the new point ---> (5,7).
     * point1 ---> the new point ---> (3,7).
     *currentDistance ---> The distance that came out after using the distance function.
     */
    public void testPointDistance(){
        double x = 5;
        double y = 7;
        double w=3;
        double z =7;
        Point_2D point =new Point_2D(x,y);
        Point_2D point1 =new Point_2D(w,z);
       double currentDistance =point.distance(point1);
        Assertions.assertEquals(2,currentDistance);
    }

    /**
     * This test checks whether the distance between two points is calculated correctly.
     */
    @Test
    public void testPointDistance1(){
        double d = P1_2.distance(P4_6);
        Assertions.assertEquals(d,5, Ex2_Const.EPS);
    }
    /**
     * Test scaling a point by a factor of 0.5.
     *It scales a point (P1_2) by a factor of 0.5 with respect to the origin (0,0) and checks if the result point equals to (0.5,1).
     */
    @Test
    public void testPointScale(){
        Point_2D p = new Point_2D(P1_2);
        p.scale(Point_2D.ORIGIN,0.5);
        Point_2D t = new Point_2D(0.5,1);
        Assertions.assertEquals(p,t);
    }
    /**
     * Test scaling a point by a factor of 2.
     * It scales a point (P1_2) by a factor of 2 with respect to the origin (0,0) and checks if the result point equals to (2,4).
     */
    @Test
    public void testPointScale1(){
        Point_2D p = new Point_2D(P1_2);
        p.scale(Point_2D.ORIGIN,2);
        Point_2D t = new Point_2D(2,4);
        Assertions.assertEquals(p,t);
    }
    /**
     * Test the addition of two points.
     * It adds two points (P1_2 and P4_6) and checks if the result point's distance from (5,8) is less than a defined EPSILON
     * and if the result point equals to (5,8).
     */
    @Test
    public void testPointAdd(){
        Point_2D p = P1_2.add(P4_6);
        Point_2D pp = new Point_2D(5,8);
        double d = p.distance(pp);
        Assertions.assertTrue(d< Ex2_Const.EPS);
        Assertions.assertEquals(p,pp);
    }
    /**
     * This test checks whether the function rotates the point according to the point and angle
     */
    @Test
    public void testPointRotate() {
        Point_2D p = new Point_2D(P1_2);
        double d1 = p.distance();
        p.rotate(Point_2D.ORIGIN, 10);
        double d2 = p.distance();
        Assertions.assertEquals(d1, d2, Ex2_Const.EPS);
        Assertions.assertNotEquals(P1_2, p);
    }
    /**
     * This test check if the function 'toString' works properly.
     * point ---> create a new point.
     */
    @Test
    public void testPointToString(){
        Point_2D point = new Point_2D(3,4);
        String expected = point.x()+","+ point.y();
        String actual = point.toString();
        Assertions.assertEquals(expected, actual);
    }

    /**
     * This test checks whether the move() function works properly.
     * vec--->In relation to this point, the starting point changes, (2,2).
     * point ---> create a new point, (3,4);
     */
    @Test
    public void testPointMove (){
        Point_2D point = new Point_2D(3,4);
        Point_2D vec = new Point_2D(2,2);
        point.move(vec);
        Assertions.assertEquals(5,point.x());
        Assertions.assertEquals(6,point.y());
    }

    /**
     * This test tests the 'equals' method.
     * p_1 ---> the center point of first point.
     * p_2 ---> the radius of second point.
     */
    @Test
    public void testCircleEquals(){
        Point_2D p_1 = new Point_2D(1, 1);
        Point_2D p_2 = new Point_2D(1, 1);
        boolean isEquals= p_1.equals(p_2);
        Assertions.assertFalse(isEquals);
    }
}