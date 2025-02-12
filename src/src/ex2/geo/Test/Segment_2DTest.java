/**
 * Name ---> Ron Amsalem
 * ID ---> 326029600
 */
package src.ex2.geo.Test;
import ex2.ex2.Ex2_Const;
import ex2.geo.Circle_2D;
import ex2.geo.Point_2D;
import ex2.geo.Segment_2D;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class Segment_2DTest {

    /**
     * This test checks whether a point is on a segment.
     * ot --->The point we would like to check (xOt,yOt).
     * a --->First endpoint of the segment (x,y).
     * b --->Second endpoint of the segment (w,z).
     * segment --->Segment creation.
     */
    @Test
    public void testSegmentContains () {
        double xOt = 6;
        double yOt = 4;
        double x = 5;
        double y =3;
        double w = 7;
        double z =5;
        Point_2D ot = new Point_2D(xOt,yOt);
        Point_2D a = new Point_2D(x,y);
        Point_2D b = new Point_2D(w,z);
        Segment_2D segment = new Segment_2D(a,b);
        boolean isContains = segment.contains(ot);
        if (a.distance(ot)+ ot.distance(b)==a.distance(b)){
            isContains=true;
        }
        Assertions.assertTrue(isContains);
    }

    /**
     * This test checks whether the 'area ()' is calculated correctly.
     * p1 --->First endpoint of the segment (2,4).
     * p2 --->Second endpoint of the segment (5,4).
     * segment --->Segment creation.
     * area ---> the current area.
     */
    @Test
    public void testSegmentArea(){
        Point_2D p1 = new Point_2D(2,4);
        Point_2D p2 = new Point_2D(5,4);
        Segment_2D segment = new Segment_2D(p1,p2);
       double area =  segment.area();
        Assertions.assertEquals(0,area);
    }
    /**
     * This test checks whether the perimeter is calculated correctly.
     * ot --->The point we would like to check (xOt,yOt).
     * a --->First endpoint of the segment (x,y).
     * b --->Second endpoint of the segment (w,z).
     * segment --->Segment creation.
     * expectedPerimeter --->perimeter that needs to be exited.
     * perimeter ---> the current perimeter.
     */
    @Test
    public void testSegmentPerimeter(){
        double x = 5;
        double y =3;
        double w = 7;
        double z =5;
        Point_2D a = new Point_2D(x,y);
        Point_2D b = new Point_2D(w,z);
        double expectedPerimeter=2*a.distance(b);
        Segment_2D segment = new Segment_2D(a,b);
        double perimeter = segment.perimeter();
        Assertions.assertEquals(expectedPerimeter,perimeter);


    }
    /**
     * This test checks if the translate function works properly.
     *  vec ---> A vector through whose values we will move the shape (2,3).
     * a --->First endpoint of the segment (5,9).
     * b --->Second endpoint of the segment (3,4).
     * segment --->Segment creation.
     * expectedPerimeter --->perimeter that needs to be exited.
     * perimeter ---> the current perimeter.
     */
    @Test
    public void testSegmentTranslate(){
        Point_2D vec = new Point_2D(2, 3);
        Point_2D a =new Point_2D(5, 9);
        Point_2D b =new Point_2D(3, 4);
        Segment_2D segment = new Segment_2D(a,b);
        segment.translate(vec);

        Assertions.assertEquals(7.0,segment.get_p1().x());
        Assertions.assertEquals(12.0,segment.get_p1().y());
        Assertions.assertEquals(5.0,segment.get_p2().x());
        Assertions.assertEquals(7.0,segment.get_p2().y());
    }

    /**
     *This test checks whether the 'copy()' function works properly.
     * a --->First endpoint of the segment (5,9).
     * b --->Second endpoint of the segment (3,4).
     * segment --->Segment creation.
     * copySegment ---> copy segment creation
     */
    @Test
    public void testSegmentCopy (){
        Point_2D a =new Point_2D(5, 9);
        Point_2D b =new Point_2D(3, 4);
        Segment_2D segment = new Segment_2D(a,b);
        Segment_2D copySegment = (Segment_2D) segment.copy();
        Assertions.assertEquals(5.0,copySegment.get_p1().x());
        Assertions.assertEquals(9.0,copySegment.get_p1().y());
        Assertions.assertEquals(3.0,copySegment.get_p2().x());
        Assertions.assertEquals(4.0,copySegment.get_p2().y());

    }

    /**
     * This test checks whether the 'scale()' function works properly.
     * a --->First endpoint of the segment (4,0).
     * b --->Second endpoint of the segment (6,2).
     * center   ---> Creating a center point, (1,1).
     * ratio---> the ratio, (2).
     *
     */
    @Test
    public void testSegmentScale (){
        Point_2D a =new Point_2D(4, 0);
        Point_2D b =new Point_2D(6, 2);
        Point_2D center =new Point_2D(1, 1);
        Segment_2D segment = new Segment_2D(a,b);
        segment.scale(center,2);
        Assertions.assertEquals(7,segment.get_p1().x());
        Assertions.assertEquals(-1,segment.get_p1().y());
        Assertions.assertEquals(11,segment.get_p2().x());
        Assertions.assertEquals(3,segment.get_p2().y());

    }
    /**
     *Test rotating a segment.
     *It creates a segment with two points (p1 and p2) and rotates it around another point (5,5) by an angle of 0 degrees.
     *Then it compares the perimeters of the original segment and the rotated segment, and asserts that they are equal.
     * Additionally, it checks if the x-coordinate of the first point of the rotated segment equals to the x-coordinate of the first point of the original segment.
     * Finally, it rotates the segment by an angle of 90 degrees and again compares their perimeters.
     */
    @Test
    public void testSegmentRotate (){
        Point_2D p1 = new Point_2D (0,0);
        Point_2D p2 = new Point_2D (2,6);
        Segment_2D seg = new Segment_2D(p1, p2);
        Segment_2D seg2 = new Segment_2D(p1, p2);
        seg2.rotate(new Point_2D(5,5),0);
        //perimeter should be equals
        Assertions.assertEquals(seg.perimeter(),seg2.perimeter(), Ex2_Const.EPS);
        Assertions.assertEquals(seg2.get_p1().x(),seg.get_p1().x(),Ex2_Const.EPS);
        seg2.rotate(new Point_2D(5,5),90);
        Assertions.assertEquals(seg.perimeter(),seg2.perimeter(),Ex2_Const.EPS);
    }
    /**
     * This test check if the function 'toString()' works properly.
     * s1 ---> create a new segment.
     */
    @Test
    public void testSegmentToString (){
        Point_2D p1 = new Point_2D (3,6);
        Point_2D p2 = new Point_2D (2,6);
        Segment_2D s1= new Segment_2D(p1,p2);
        String expected = "3.0,6.0,2.0,6.0";
        String actual = s1.toString();

        Assertions.assertEquals(expected, actual);
    }
    /**
     * This test tests the 'equals' method.
     * p_1 ---> The first point of the first segment, (1,1) .
     * p_2 ---> The second point of the first segment, (2,3).
     * p_3 ---> The first point of the second segment, (1,1).
     * p_4 ---> The second point of the second segment, (5,6).
     * segment1 ---> creating a new segment whit p_1 and p_2 .
     * segment2 ---> creating a new segment whit p_3 and p_4 .
     */
    @Test
    public void testSegmentEquals(){
        Point_2D p_1 = new Point_2D(1, 1);
        Point_2D p_2= new Point_2D(2, 3);
        Point_2D p_3 = new Point_2D(1, 1);
        Point_2D p_4= new Point_2D(5, 6);
        Segment_2D segment1 = new Segment_2D(p_1,p_2);
        Segment_2D segment2 = new Segment_2D(p_3,p_4);
       boolean isEquals = segment1.equals(segment2);
        Assertions.assertFalse(isEquals);

    }

}

