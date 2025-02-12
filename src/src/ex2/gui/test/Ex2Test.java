/**
 * Name ---> Ron amsalem
 * ID ---> 326029600
 */
package src.ex2.gui.test;
import ex2.ex2.GUI_Shape_Collection;
import ex2.ex2.ShapeCollection;
import ex2.geo.*;
import ex2.gui.Ex2;
import ex2.gui.GUIShape;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
class Ex2Test {
    /**
     * This test case verifies the functionality of initializing the Ex2 instance
     * with a ShapeCollection and ensuring that the ShapeCollection is correctly
     * initialized with the expected shapes.
     *ex ---> Get an instance of Ex2
     *shapeCollection ---> Create a new ShapeCollection and add shapes to it.
     * p1 ---> creating a new point.
     * p2 ---> creating a new point .
     * p3 ---> creating a new point .
     * circle ---> creating a new circle.
     * rect ---> crating a new rect.
     * triangle ---> creating a new triangle.
     * sizeExpected ---> We added 3 shapes so this is the expected size.
     */
    @Test
     public void testInit() {
        Ex2 ex = Ex2.getInstance();
        ShapeCollection shapeCollection = new ShapeCollection();
        Point_2D p1 = new Point_2D(2, 4);
        Point_2D p2 = new Point_2D(5, 6);
        Point_2D p3 = new Point_2D(7, 1);
        GeoShape triangle = new Triangle_2D(p1,p2,p3);
        GeoShape circle = new Circle_2D(p1, 2);
        GeoShape rect = new Rect_2D (p2, p1);
        GUIShape circleShape = new GUIShape(circle, true, Color.RED, 1);
        GUIShape triangleShape = new GUIShape(triangle,false, Color.BLACK,2);
        GUIShape rectShape = new GUIShape(rect, false, Color.BLUE, 3);
        shapeCollection.add(circleShape);
        shapeCollection.add(rectShape);
        shapeCollection.add(triangleShape);
        ex.init(shapeCollection);
        assertNotNull(shapeCollection);
        int sizeExpected = 3;
        assertEquals(sizeExpected,shapeCollection.size());
    }


    /**
     * This test case verifies the functionality of initializing the Ex2 instance
     * with a ShapeCollection, adding shapes to it, and ensuring that the ShapeCollection
     * remains unchanged after initialization.
     * ex ---> Get an instance of Ex2
     * shapeCollection ---> Create a new ShapeCollection and add shapes to it.
     * p1 ---> creating a new point.
     * p2 ---> creating a new point .
     * circle ---> creating a new circle.
     * rect ---> crating a new rect.
     */
    @Test
   public void testGetShape_Collection() {
        Ex2 ex = Ex2.getInstance();
        GUI_Shape_Collection shapeCollection = ex.getShape_Collection();
        ex.init(null);
        Point_2D p1 = new Point_2D(2, 4);
        Point_2D p2 = new Point_2D(5, 6);
        GeoShape circle = new Circle_2D(p1, 2);
        GeoShape rect = new Rect_2D (p2, p1);
        GUIShape circleShape = new GUIShape(circle, true, Color.RED, 3);
        GUIShape rectShape = new GUIShape(rect, false, Color.BLUE, 2);
        shapeCollection.add(circleShape);
        shapeCollection.add(rectShape);
        ex.init(shapeCollection);
        assertEquals(shapeCollection,ex.getShape_Collection());
    }

    /**
     * This method tests the functionality of the 'getInfo()' method in the Ex2 class.
     * It verifies that the getInfo() method correctly generates information
     * about the shapes in the ShapeCollection initialized with Ex2.
     * ex ---> Get an instance of Ex2
     * shapeCollection ---> Create a new ShapeCollection and add shapes to it.
     * p1 ---> creating a new point.
     * p2 ---> creating a new point .
     * circle ---> creating a new circle.
     * rect ---> crating a new rect.
     * expected ---> the expected string representing the information about these shapes.
     */
    @Test
    void testGetInfo() {
        Ex2 ex = Ex2.getInstance();
        ShapeCollection shapeCollection = new ShapeCollection();
        Point_2D p1 = new Point_2D(2, 4);
        Point_2D p2 = new Point_2D(5, 6);
        GeoShape circle = new Circle_2D(p1, 2);
        GeoShape rect = new Rect_2D (p2, p1);
        GUIShape circleShape = new GUIShape(circle, true, Color.RED, 3);
        GUIShape rectShape = new GUIShape(rect, false, Color.BLUE, 2);
        shapeCollection.add(circleShape);
        shapeCollection.add(rectShape);
       ex.init(shapeCollection);
     String expected ="GUIShape,16711680,true,3,Circle_2D,2.0,4.0, 2.0\n"+
             "GUIShape,255,false,2,Rect_2D,5.0,6.0,2.0,4.0,5.0,4.0,2.0,6.0\n";
       assertEquals(expected,ex.getInfo());
    }
}

