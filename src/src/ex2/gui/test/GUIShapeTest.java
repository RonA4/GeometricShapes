/**
 * Name ---> Ron amsalem
 * ID ---> 326029600
 */
package src.ex2.gui.test;
import ex2.geo.Circle_2D;
import ex2.geo.Point_2D;
import ex2.geo.Segment_2D;
import ex2.geo.Triangle_2D;
import ex2.gui.GUIShape;
import org.junit.jupiter.api.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

class GUIShapeTest {

    /**
     * It verifies that the shape returned by is equal to the segment used to create the object.
     * p1 ---> creating a  first point of segment, (1,1).
     * p2  ---> creating a second point of segment, (2,2).
     * seg ---> creating a new segment.
     */
    @Test
   public void testGetShape() {
        Point_2D p1 = new Point_2D(1,1);
        Point_2D p2 = new Point_2D(2,2);
        Segment_2D seg = new Segment_2D(p1,p2);
        GUIShape shape = new GUIShape(seg,true,Color.black,1);
        assertEquals(seg.toString(),shape.getShape().toString());
    }
    /**
     * It verifies that the shape set using method is equal to the new shape assigned.
     * p1 ---> creating a point, (1,1).
     * p2  ---> creating a  point, (2,2).
     * p3  ---> creating a  point, (3,3).
     * seg ---> creating a new segment.
     * triangle ---> creating a new triangle.
     */
    @Test
   public void testSetShape() {
        Point_2D p1 = new Point_2D(1,1);
        Point_2D p2 = new Point_2D(2,2);
        Point_2D p3 = new Point_2D(3,3);
        Segment_2D seg = new Segment_2D(p1,p2);
        Triangle_2D triangle = new Triangle_2D(p1,p2,p3);
        GUIShape shape = new GUIShape(seg,true,Color.black,1);
        shape.setShape(triangle);
        assertEquals(triangle,shape.getShape());

    }

    /**
     * It verifies that the  method returns false when the shape is not filled.
     * p1 ---> creating a  first point of segment, (1,1).
     * p2  ---> creating a second point of segment, (2,2).
     * seg ---> creating a new segment.
     */
    @Test
     public void testIsFilled() {
        Point_2D p1 = new Point_2D(1,1);
        Point_2D p2 = new Point_2D(2,2);
        Segment_2D seg = new Segment_2D(p1,p2);
        GUIShape shape = new GUIShape(seg,false,Color.black,1);
        assertFalse(shape.isFilled());
    }

/**
 * It verifies that the shape's filled status can be correctly set and retrieved.
 * p1 ---> creating a  first point of segment, (1,1).
 * p2  ---> creating a second point of segment, (2,2).
 *  seg ---> creating a new segment.
 */

    @Test
     public void testSetFilled() {
        Point_2D p1 = new Point_2D(1,1);
        Point_2D p2 = new Point_2D(2,2);
        Segment_2D seg = new Segment_2D(p1,p2);
        GUIShape shape = new GUIShape(seg,false,Color.black,1);
        shape.setFilled(true);
        assertTrue(shape.isFilled());
    }

    /**
     * It verifies that the color returned by is the same as the color specified when creating the object.
     * p1 ---> creating a  first point of segment, (1,1).
     * p2  ---> creating a second point of segment, (2,2).
     * seg ---> creating a new segment.
     */
    @Test
    public void testSetColor() {
            Point_2D p1 = new Point_2D(1,1);
            Point_2D p2 = new Point_2D(2,2);
            Segment_2D seg = new Segment_2D(p1,p2);
            GUIShape shape = new GUIShape(seg,false,Color.black,1);
            assertEquals(Color.BLACK,shape.getColor());

    }

    /**
     *It verifies that the color set using setColor() method is the same as the color retrieved by getColor().
     * p1 ---> creating a  first point of segment, (1,1).
     * p2  ---> creating a second point of segment, (2,2).
     * seg ---> creating a new segment.
     */
    @Test
   public void TestSetColor() {
        Point_2D p1 = new Point_2D(1,1);
        Point_2D p2 = new Point_2D(2,2);
        Segment_2D seg = new Segment_2D(p1,p2);
        GUIShape shape = new GUIShape(seg,false,Color.black,1);
        shape.setColor(Color.cyan);
        assertEquals(Color.cyan,shape.getColor());
    }

    /**
     * * It verifies that the tag returned by getTag() is the same as the tag specified when creating the GUIShape object.
     * p1 ---> creating a  first point of segment, (1,1).
     * p2  ---> creating a second point of segment, (2,2).
     * seg ---> creating a new segment.
     */
    @Test
    public void testGetTag() {
        Point_2D p1 = new Point_2D(1,1);
        Point_2D p2 = new Point_2D(2,2);
        Segment_2D seg = new Segment_2D(p1,p2);
        GUIShape shape = new GUIShape(seg,false,Color.black,1);
        assertEquals(1,shape.getTag());
    }

    /**
     * It verifies that the tag set using setTag() method is the same as the tag retrieved by getTag().
     * p1 ---> creating a  first point of segment, (1,1).
     * p2  ---> creating a second point of segment, (2,2).
     * seg ---> creating a new segment.
     */
    @Test
   public void testSetTag() {
        Point_2D p1 = new Point_2D(1,1);
        Point_2D p2 = new Point_2D(2,2);
        Segment_2D seg = new Segment_2D(p1,p2);
        GUIShape shape = new GUIShape(seg,false,Color.black,1);
        shape.setTag(4);
        assertEquals(4,shape.getTag());
    }

    /**
     * It verifies that the object returned by copy() method is not the same reference as the original object.
     * p1 ---> creating a  first point of segment, (1,1).
     * p2  ---> creating a second point of segment, (2,2).
     * seg ---> creating a new segment.
     */

    @Test
    public void testCopy() {
        Point_2D p1 = new Point_2D(1,1);
        Point_2D p2 = new Point_2D(2,2);
        Segment_2D seg = new Segment_2D(p1,p2);
        GUIShape shape = new GUIShape(seg,false,Color.black,1);
        GUIShape copyShape = (GUIShape) shape.copy();
        assertNotSame(shape,copyShape);
    }

    /**
     * It verifies that the string representation of a GUIShape object is formatted correctly.
     * p1 ---> creating a  first point of segment, (1,1).
     * p2  ---> creating a second point of segment, (2,2).
     * seg ---> creating a new segment.
     */

    @Test
    void testToString() {
        Point_2D p1 = new Point_2D(1,1);
        Point_2D p2 = new Point_2D(2,2);
        Segment_2D seg = new Segment_2D(p1,p2);
        GUIShape shape = new GUIShape(seg,false,Color.black,1);
        String expected = "GUIShape,0,false,1,Segment_2D,1.0,1.0,2.0,2.0";
        assertEquals(expected,shape.toString());
    }

    /**
     * It verifies that the selected status returned by isSelected() is true when the shape is selected.
     * p1 ---> creating a  first point of segment, (1,1).
     * p2  ---> creating a second point of segment, (2,2).
     * seg ---> creating a new segment.
     */
    @Test
    public void testIsSelected() {
        Point_2D p1 = new Point_2D(1,1);
        Point_2D p2 = new Point_2D(2,2);
        Segment_2D seg = new Segment_2D(p1,p2);
        GUIShape shape = new GUIShape(seg,false,Color.black,1);
        shape.setSelected(true);
        assertTrue(shape.isSelected());

    }

    /**
     *It verifies that the selected status set using setSelected() method is correctly reflected by isSelected().
     *p1 ---> creating a  first point of segment, (1,1).
     *p2  ---> creating a second point of segment, (2,2).
     *seg ---> creating a new segment.
     */

    @Test
      public void testSetSelected() {
        Point_2D p1 = new Point_2D(1,1);
        Point_2D p2 = new Point_2D(2,2);
        Segment_2D seg = new Segment_2D(p1,p2);
        GUIShape shape = new GUIShape(seg,false,Color.black,1);
        assertFalse(shape.isSelected());
        shape.setSelected(true);
        assertTrue(shape.isSelected());
    }

    /**
     * This test cheek if two shapes is equals by creating two circle:
      (1) circle1 --- (1,1) and radius 1.
      (2) circle2 --- (1,1) and radius 1.
     * We will compare the forms and see that the equal forms return true and if they are not equal we will get a false.
     */
    @Test
    void testEquals() {
        Point_2D p1 =new Point_2D(1,1);
        Circle_2D circle1 = new Circle_2D(p1, 1);
        Point_2D p2 = new Point_2D(2,2);
        Circle_2D circle2 = new Circle_2D(p2, 1);
        GUIShape shape1 = new GUIShape(circle1, true, Color.black, 1);
        GUIShape shape2 = new GUIShape(circle1, true, Color.black, 1);
        GUIShape shape3 = new GUIShape(circle2, true, Color.black, 1);

        assertTrue(shape1.equals(shape2));
        assertFalse(shape1.equals(shape3));


    }
}

