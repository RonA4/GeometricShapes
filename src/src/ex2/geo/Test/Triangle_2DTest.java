/**
 * Name ---> Ron Amsalem
 * ID ---> 326029600
 */

package src.ex2.geo.Test;
import ex2.geo.Point_2D;
import ex2.geo.Triangle_2D;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class Triangle_2DTest {
   @Test
   /**
    * The test checks whether a point is inside the triangle or not.
    * a ---> First point of the triangle ,(3,1).
    * b ---> Second point of the triangle, (7,1).
    * c ---> Third point of the triangle,(5,5).
    * ot --->  Creating the point we want to test (5,3).
    */
   public void testTriangleContains() {
       Point_2D a = new Point_2D(2, 4);
       Point_2D b = new Point_2D(3, 1);
       Point_2D c = new Point_2D(1, 1);
       Point_2D ot = new Point_2D(2, 2);
       Triangle_2D triangle = new Triangle_2D(a, b, c);
       boolean isContains = triangle.contains(ot);
       Assertions.assertTrue(isContains);

   }
    /**
     * This test checks whether the area is calculated properly according to the Heron formula.
     * a ---> First point of the triangle ,(2,3).
     * b ---> Second point of the triangle, (5,1).
     * c ---> Third point of the triangle,(5,5).
     *  triangle ---> creating a triangle.
     *  area ---> Calculation of the area according to the function.
     *  areaExpected --->The calculation of the area is manual (6).
     */
    @Test
    public void testTriangleArea(){
        Point_2D a = new Point_2D(2,3);
        Point_2D b = new Point_2D(5,1);
        Point_2D c = new Point_2D(5,5);
        Triangle_2D triangle = new Triangle_2D(a,b,c);
         double area =triangle.area();
        double areaExpected= 6 ;
        Assertions.assertEquals(areaExpected,area);
    }
    /**
     * Test checks if the function to calculate the area of a triangle works correctly.
     * a ---> First point of the triangle ,(2,3).
     * b ---> Second point of the triangle, (5,1).
     * c ---> Third point of the triangle,(5,5).
     * triangle ---> creating a triangle.
     * perimeterExpected--->The perimeter the triangle should have.
     * perimeter --->The perimeter of the triangle according to the function perimeter(), (11).
     */
        @Test
        public void testTrianglePerimeter (){
            Point_2D a = new Point_2D(2,3);
            Point_2D b = new Point_2D(5,1);
            Point_2D c = new Point_2D(5,5);
            Triangle_2D triangle = new Triangle_2D(a,b,c);
            double perimeter = (int)triangle.perimeter();
            double perimeterExpected= 11;
            Assertions.assertEquals(perimeterExpected,perimeter);
    }

    /**
     * this test checking 'translate()' function
     * a ---> First point of the triangle ,(2,3).
     * b ---> Second point of the triangle, (5,1).
     * c ---> Third point of the triangle,(5,5).
     * vec ---> vector through whose values we will move the shape( 4, 7).
     * triangle ---> creating a triangle.
     * aAfter ---> The first point of the triangle, after changing according to the given vector, (6,10).
     * bAfter ---> The second point of the triangle, after changing according to the given vector, (9,8).
     * cAfter ---> The third point of the triangle, after changing according to the given vector, (9,12).
     */
    @Test
    public void testTriangleTranslate(){
        Point_2D vec = new Point_2D(4,7);
        Point_2D a = new Point_2D(2,3);
        Point_2D b = new Point_2D(5,1);
        Point_2D c = new Point_2D(5,5);
        Point_2D aAfter = new Point_2D(6,10);
        Point_2D bAfter = new Point_2D(9,8);
        Point_2D cAfter = new Point_2D(9,12);
        Triangle_2D triangle = new Triangle_2D(a,b,c);
        triangle.translate(vec);
        Assertions.assertEquals(aAfter,triangle.getAllPoints()[0]);
        Assertions.assertEquals(bAfter,triangle.getAllPoints()[1]);
        Assertions.assertEquals(cAfter,triangle.getAllPoints()[2]);


    }
    /**
     * This test checks whether the 'copy()' function works properly
     * a ---> First point of the triangle ,(2,3).
     * b ---> Second point of the triangle, (5,1).
     * c ---> Third point of the triangle,(5,5).
     * triangle ---> creating a triangle.
     * copyTriangle ---> creating a copy triangle.
     */
    @Test
    public void testTriangleCopy(){
        Point_2D a = new Point_2D(2,3);
        Point_2D b = new Point_2D(5,1);
        Point_2D c = new Point_2D(5,5);
        Triangle_2D triangle = new Triangle_2D(a,b,c);
        Triangle_2D copyTriangle = (Triangle_2D) triangle.copy();
        Assertions.assertEquals(triangle.getAllPoints()[0], copyTriangle.getAllPoints()[0]);
        Assertions.assertEquals(triangle.getAllPoints()[1], copyTriangle.getAllPoints()[1]);
        Assertions.assertEquals(triangle.getAllPoints()[2], copyTriangle.getAllPoints()[2]);
    }
    /**
     * This checks whether the Scale function works as it should.
     * I used the GPT chat here to help calculate the values that should come out.
     * a ---> First point of the triangle , (0,0).
     * b ---> Second point of the triangle, (2,0).
     * c ---> Third point of the triangle, (0,2).
     * triangle ---> creating a triangle.
     * center   ---> Creating a center point, (1,1).
     * ratio---> the ratio.
     * expectedA, expectedB ,expectedC --->The values that should come out
     * actualPoints ---> Array of points.
     */
    @Test
    public void testTriangleScale(){
        Point_2D a = new Point_2D(0, 0);
        Point_2D b = new Point_2D(2, 0);
        Point_2D c = new Point_2D(0, 2);
        Triangle_2D triangle = new Triangle_2D(a,b,c);
        double ratio = 2;
        Point_2D center = new Point_2D(1, 1);
        triangle.scale(center, ratio);
        Point_2D expectedA = new Point_2D(-1, -1);
        Point_2D expectedB = new Point_2D(3, -1);
        Point_2D expectedC = new Point_2D(-1, 3);
        Point_2D [] actualPoints = triangle.getAllPoints();

        Assertions.assertEquals(expectedA, actualPoints[0]);
        Assertions.assertEquals(expectedB, actualPoints[1]);
        Assertions.assertEquals(expectedC, actualPoints[2]);
    }
    /**
     * This test checks whether the function rotates the triangle according to the point and angle, (in my example an angle of 90 degrees).
     * a ---> First point of the triangle , (1,1).
     * b ---> Second point of the triangle, (2,3).
     * c ---> Third point of the triangle, (4,2).
     * triangle ---> creating a triangle--->,(a,b,c).
     * center   ---> Creating a center point, (2,2).
     */
    @Test
    public void testTriangleRotate(){
        Point_2D a = new Point_2D(1, 1);
        Point_2D b = new Point_2D(2, 3);
        Point_2D c = new Point_2D(4, 2);
        Triangle_2D triangle = new Triangle_2D(a,b,c);
        Point_2D center = new Point_2D(2, 2);
        triangle.rotate(center,90);
        Point_2D[] expectedPoints = {new Point_2D(3, 1), new Point_2D(1, 2), new Point_2D(2, 4)};
        Point_2D[] actualPoints = triangle.getAllPoints();
        for (int i = 0; i < expectedPoints.length; i++) {
            Assertions.assertEquals(expectedPoints[i], actualPoints[i]);
        }
    }


    /**
     * This test check if the function 'toString()' works properly.
     * p_1 ---> The first point of the triangle, (1,1) .
     * p_2 ---> The second point of triangle, (2,3).
     * p_3 ---> The third point point of triangle, (1,1).
     * point ---> array of point of the triangle.
      */
    @Test
    public void testTriangleToString(){
        Point_2D p_1 = new Point_2D(1, 1);
        Point_2D p_2= new Point_2D(2, 3);
        Point_2D p_3 = new Point_2D(1, 4);
        Point_2D [] points = {p_1,p_2,p_3};
        String ans=points[0].toString();
        for (int i = 1; i <points.length ; i++) {
            ans=ans+points[i];
        }
    }
    @Test
    /**
     * This test check if the function 'equals()' works properly.
     * p_1 ---> The first point of the first triangle, (1,1) .
     * p_2 ---> The second point of the first triangle, (2,3).
     * p_3 ---> The third point of thr first triangle, (1,4).
     * p_4 ---> The first point of the second triangle, (2,7) .
     * p_5 ---> The second point of the second triangle, (3,4).
     * p_6 ---> The third point of thr second triangle, (1,1).
     */
    public void testTriangleEquals(){
        Point_2D p_1 = new Point_2D(1, 1);
        Point_2D p_2= new Point_2D(2, 3);
        Point_2D p_3 = new Point_2D(1, 4);
        Point_2D p_4 = new Point_2D(2, 7);
        Point_2D p_5= new Point_2D(3, 5);
        Point_2D p_6 = new Point_2D(1, 1);
        Triangle_2D triangle1 = new Triangle_2D(p_1,p_2, p_3);
        Triangle_2D triangle2 = new Triangle_2D(p_4,p_5,p_6);
        boolean isEquals = triangle1.equals(triangle2);
        Assertions.assertFalse(isEquals);

    }
}

