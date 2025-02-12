/**
 * Name:Ron amsalem
 * ID:326029600
 */
package src.ex2.geo.Test;
import ex2.geo.Circle_2D;
import ex2.geo.Point_2D;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class Circle_2DTest {
    /**
     * This test check if the function 'toString' works properly.
     * circle ---> create a new circle.
     * radius ---> The radius of the circle, (5).
     * center ---> create a center point , (1,1).
     * expected ---> The string I want to get.
     * actual --->The string I need to get.
     */
    @Test
    public void testCircleToString() {
        Point_2D center = new Point_2D(1, 1);
        double radius = 5;
        Circle_2D circle = new Circle_2D(center, radius);
        String expected = center.x() + "," + center.y() + "," + " " + radius;
        String actual = circle.toString();
        Assertions.assertEquals(expected, actual);
    }
    /**
     * This test tests the 'equals' method.
     * c_1 ---> the center point of first circle.
     * r_1 ---> the radius of second circle.
     * c_2 ---> the center point of second circle.
     * r_2 ---> the radius of second circle.
     */
    @Test
    public void testCircleEquals(){
        Point_2D c_1 = new Point_2D(1, 1);
        double r_1 = 5;
        Circle_2D circle_1 = new Circle_2D(c_1, r_1);
        Point_2D c_2= new Point_2D(2, 3);
        double r_2 = 5;
        Circle_2D circle_2 = new Circle_2D(c_2, r_2);
        boolean isEquals= circle_1.equals(circle_2);
        Assertions.assertFalse(isEquals);
    }
    /**
     * The test is based on the equation of the circle (x-a)^2+(y-b)^2=r^2.
     * So (x,y) is a point we want to check if it is in the circle and (a,b) is the center point of the circle.
     * The circuit equation in the test is ---> (x+5)^2+(y-3)^2=40.
     * radius ---> radius of the circle ---> root 40.
     * x ---> The xCen rate of the center point and y ---> The yCen rate of the center point (-5,3) --->pointCenter ---> Creating the center point.
     * xOt ---> The x rate of the point we want to check if it is in a circle or not.
     * yOt ---> The y rate of the point we want to check if it is in a circle or not.
     * ot ---> Creating the point we want to test.
     * circle --->creating a circle.
     * This test uses the distance test and checks whether the distance is small equal to the radius, if so then the point is inside.
     */
    @Test
    public void testCircleContains() {
        double xCen = -5;
        double yCen = 3;
        double xOt = 1;
        double yOt = 2;
        double radius = Math.sqrt(40);
        Point_2D pointCenter = new Point_2D(xCen, yCen);
        Point_2D ot = new Point_2D(xOt, yOt);
        Circle_2D circle = new Circle_2D(pointCenter, radius);
        boolean isContains = circle.contains(ot);
        if (ot.distance(pointCenter) <= radius) {
            isContains = true;
        }
        Assertions.assertTrue(isContains);
    }
    /**
     * The purpose of the test is to test the function that calculates the area of a circle.
     * radius ---> radius of the circle.
     * x ---> The x rate of the center point.
     * y ---> The y rate of the center point.
     * pointCenter ---> Creating the center point.
     * circle --->creating a circle.
     * The test basically checks whether the area that the function calculates is equal to the area that should be output.
     */
    @Test
    public void testCircleArea() {
        double radius = 7;
        double x = 3;
        double y = 4;
        Point_2D pointCenter = new Point_2D(x, y);
        Circle_2D circle = new Circle_2D(pointCenter, radius);
        double expectedArea = Math.PI * Math.pow(radius, 2);
        double actualArea = circle.area();
        Assertions.assertEquals(expectedArea, actualArea);
    }
    /**
     * The purpose of the test is to test the function that calculates the perimeter of a circle.
     * radius ---> radius of the circle.
     * x ---> The x rate of the center point.
     * y ---> The y rate of the center point.
     * pointCenter ---> Creating the center point.
     * circle --->creating a circle.
     * The test basically checks whether the perimeter that the function calculates is equal to the perimeter that should be output.
     */
    @Test
    public void testCirclePerimeter() {
        double radius = 7;
        double x = 3;
        double y = 4;
        Point_2D pointCenter = new Point_2D(x, y);
        Circle_2D circle = new Circle_2D(pointCenter, radius);
        double expectedArea = 2 * radius * Math.PI;
        double actualArea = circle.perimeter();
        Assertions.assertEquals(expectedArea, actualArea);
    }
    /**
     * This test isChecking whether the center of the circle changes as it should.
     * centerPoint ---> Creating a center point
     * radius ---> radius of the circle.
     * circle --->creating a circle.
     * vec --->A vector through whose values we will move the shape.
     */
    @Test
    public void testCircleTranslate() {
        Point_2D centerPoint = new Point_2D(3, 4);
        double radius = 5;
        Circle_2D circle = new Circle_2D(centerPoint, radius);
        Point_2D vec = new Point_2D(2, 3);
        circle.translate(vec);
        Assertions.assertEquals(5.0, circle.getCenter().x()); // expected center after translation: (3 + 2, 4 + 3) = (5, 7)
        Assertions.assertEquals(7.0, circle.getCenter().y());
    }
    /**
     *This test checks whether the values of the circle I created are equal to the values of the copied circle.
     * centerPoint ---> Creating a center point
     * radius ---> radius of the circle.
     * circle --->creating a circle.
     * copyCircle --->creating copy circle.
     */
    @Test
    public void testCircleCopy() {
        Point_2D centerPoint = new Point_2D(3, 4);
        double radius = 5;
        Circle_2D circle = new Circle_2D(centerPoint, radius);
        Circle_2D copyCircle = (Circle_2D) circle.copy();
        //checking if the rates of the center point are the same
        Assertions.assertEquals(circle.getCenter().x(), copyCircle.getCenter().x());
        Assertions.assertEquals(circle.getCenter().y(), copyCircle.getCenter().y());
        //check if the radius is the same
        Assertions.assertEquals(circle.getRadius(), copyCircle.getRadius());

    }
    /**
     * This test checks 2 things:
     (1) it checks if the radius is updated properly after calling the function.
     (2) it checks if the center point is updated properly after calling the function.
     * center ---> Creating a center point.
     * ratio ---> the ratio.
     * radius ---> radius of the circle.
     * circle ---> creating a circle.
     * newCenter ---> creating a new circle.
     * actualRadius ---> The radius that came out after running the function scale().
     * expectedRadius --->Calculation of the radius according to the ratio.
     */
    @Test
    public void testCircleScale() {
        Point_2D center = new Point_2D(3, 4);
        double radius = 5;
        double ratio = 2;
        Circle_2D circle = new Circle_2D(center, radius);
        circle.scale(center, ratio);
        Assertions.assertEquals(10, circle.getRadius());
        Assertions.assertEquals(center, circle.getCenter());

    }
    /**
     **The rotate() test checks that the radius of the circle remains the same after the 360 degree ,rotation.
     * center --->  create a new center point (4,3) .
     * circle ---> creating a circle.
     */
    @Test
    public  void testCircleRotate(){
        Point_2D center = new Point_2D(4, 3);
        Circle_2D circle = new Circle_2D(center, 5);
        circle.rotate(center, 360);
        Assertions.assertEquals(4.0,circle.getCenter().x(), 0.001);
        Assertions.assertEquals(3.0, circle.getCenter().y(), 0.001);
       Assertions.assertEquals(5.0, circle.getRadius(), 0.001);
    }


}





