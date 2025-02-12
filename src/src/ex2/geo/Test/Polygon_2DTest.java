/**
 * Name ---> Ron Amsalem
 * ID ---> 326029600
 */
package src.ex2.geo.Test;
import ex2.geo.Point_2D;
import ex2.geo.Polygon_2D;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class Polygon_2DTest {
    @Test
    /**
     * This test check if the function 'toString' works properly.
     * polygon ---> create a new polygon.
     */
    public void testPolygonToString() {
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(0, 0));
        polygon.add(new Point_2D(1, 1));
        polygon.add(new Point_2D(2, 2));

        String expected = "0.0,0.0,1.0,1.0,2.0,2.0";
        String actual = polygon.toString();

        Assertions.assertEquals(expected, actual);
    }
    /**
     * This test checks whether a point is inside or outside the polygon.
     * isContain ---> A point inside a polygon.
     * isContain2 ---> A point outSide a polygon.
     */
    @Test
    public void testPolygonContains(){
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(4, 0));
        polygon.add(new Point_2D(6, 2));
        polygon.add(new Point_2D(4, 4));
        polygon.add(new Point_2D(2, 2));
        Boolean isContain= polygon.contains(new Point_2D(4, 2));
        Boolean isContain2= polygon.contains(new Point_2D(1, 1));
        Assertions.assertTrue(isContain);
        Assertions.assertFalse(isContain2);
    }
    /**
     * This test Checks that the 'area()' function works properly.
     * polygon ---> create new polygon.
     * area ---> The area calculated by the function
     * ExpectedArea --->Calculate area manually.
     */
    @Test
    public void testPolygonArea(){
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(4, 0));
        polygon.add(new Point_2D(6, 2));
        polygon.add(new Point_2D(4, 4));
        polygon.add(new Point_2D(2, 2));
       double area=  polygon.area();
       double ExpectedArea = 8;
        Assertions.assertEquals(ExpectedArea,area);
    }
    /**
     * This test Checks that the 'perimeter()' function works properly.
     * polygon ---> create new polygon.
     * perimeter ---> The perimeter calculated by the function
     * ExpectedPerimeter --->Calculate perimeter manually.
     */
    @Test
    public  void testPolygonPerimeter(){
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(4, 0));
        polygon.add(new Point_2D(6, 2));
        polygon.add(new Point_2D(4, 4));
        polygon.add(new Point_2D(2, 2));
        double perimeter = polygon.perimeter();
        double ExpectedPerimeter=4*(Math.sqrt(8));
        Assertions.assertEquals(ExpectedPerimeter,perimeter);
    }
    /**
     * This test checking 'translate()' function.
     * vec ---> vector through whose values we will move the shape( 1, 1).
     * polygon ---> creating a triangle.
     * expectedPoints --->The values I expect to receive.
     */
    @Test
    public void testRectTranslate(){
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(4, 0));
        polygon.add(new Point_2D(6, 2));
        polygon.add(new Point_2D(4, 4));
        polygon.add(new Point_2D(2, 2));
        Point_2D vec =new Point_2D(1,1);
        polygon.translate(vec);
        Point_2D[] expectedPoints = {
                new Point_2D(5, 1),
                new Point_2D(7, 3),
                new Point_2D(5, 5),
                new Point_2D(3, 3)
        };
        Point_2D[] actualPoints = polygon.getAllPoints();
        for (int i = 0; i < expectedPoints.length; i++) {
            Assertions.assertEquals(expectedPoints[i].x(), actualPoints[i].x(), 0.0001);
            Assertions.assertEquals(expectedPoints[i].y(), actualPoints[i].y(), 0.0001);
        }
    }
    /**
     * This test checks whether the 'copy()' function works properly.
     * polygon ---> creating a polygon.
     * copyPolygon ---> creating a copy polygon.
     */
    @Test
    public  void testPolygonCopy(){
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(4, 0));
        polygon.add(new Point_2D(6, 2));
        polygon.add(new Point_2D(4, 4));
        polygon.add(new Point_2D(2, 2));
       Polygon_2D copyPolygon = (Polygon_2D) polygon.copy();
        Point_2D[] expectedPoints = {
                new Point_2D(4, 0),
                new Point_2D(6, 2),
                new Point_2D(4, 4),
                new Point_2D(2, 2)
        };
        Point_2D[] actualPoints = polygon.getAllPoints();
        for (int i = 0; i < expectedPoints.length; i++) {
            Assertions.assertEquals(expectedPoints[i].x(), actualPoints[i].x(), 0.0001);
            Assertions.assertEquals(expectedPoints[i].y(), actualPoints[i].y(), 0.0001);
        }
    }
    /**
     * The test checks if the 'scale()' function works properly.
     * polygon ---> creating a polygon.
     * center   ---> Creating a center point, (1,1).
     * ratio---> the ratio, (2).
     */
    @Test
    public void testPolygonScale(){
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(4, 0));
        polygon.add(new Point_2D(6, 2));
        polygon.add(new Point_2D(4, 4));
        polygon.add(new Point_2D(2, 2));
        Point_2D center =new Point_2D(1,1);
        double ratio = 2;
        polygon.scale(center,ratio);
        Point_2D[] expectedPoints = {
                new Point_2D(7, -1),
                new Point_2D(11, 3),
                new Point_2D(7, 7),
                new Point_2D(3, 3)
        };
        Point_2D[] actualPoints = polygon.getAllPoints();

        for (int i = 0; i < expectedPoints.length; i++) {
            Assertions.assertEquals(expectedPoints[i].x(), actualPoints[i].x(), 0.0001);
            Assertions.assertEquals(expectedPoints[i].y(), actualPoints[i].y(), 0.0001);
        }
    }
    /**
     * The test checks if the 'scale()' function works properly.
     * rect ---> creating a rect.
     * center   ---> Creating a center point, (4,0).
     */
    @Test
    public  void testPolygonRotate(){
        Polygon_2D polygon = new Polygon_2D();
        polygon.add(new Point_2D(4, 0));
        polygon.add(new Point_2D(6, 2));
        polygon.add(new Point_2D(4, 4));
        polygon.add(new Point_2D(2, 2));
        Point_2D center =new Point_2D(4,0);
        polygon.rotate(center,10);
        polygon.rotate(center,-10);
        Point_2D[] expectedPoints = {
                new Point_2D(4, 0),
                new Point_2D(6, 2),
                new Point_2D(4, 4),
                new Point_2D(2, 2)
        };
        Point_2D[] actualPoints = polygon.getAllPoints();
        for (int i = 0; i < expectedPoints.length; i++) {
            Assertions.assertEquals(expectedPoints[i].x(), actualPoints[i].x(), 0.0001);
           Assertions.assertEquals(expectedPoints[i].y(), actualPoints[i].y(), 0.0001);
        }
    }

    /**
     *  This test check if the function 'equals()' works properly.
     *  polygon1 ---> creating a new polygon.
     *  Add points to the polygon1.
     *  polygon2 ---> creating a new polygon.
     *  Add points to the polygon2.
     */
    @Test
    public void testPolygonEquals(){
        Polygon_2D polygon1 = new Polygon_2D();
        polygon1.add(new Point_2D(4, 0));
        polygon1.add(new Point_2D(6, 2));
        polygon1.add(new Point_2D(4, 4));
        polygon1.add(new Point_2D(2, 2));
        Polygon_2D polygon2 = new Polygon_2D();
        polygon2.add(new Point_2D(1, 0));
        polygon2.add(new Point_2D(2, 3));
        polygon2.add(new Point_2D(4, 4));
        polygon2.add(new Point_2D(2, 2));
        polygon1.equals(polygon2);

    }


}


