/**
 * Name ---> Ron amsalem
 * ID ---> 326029600
 */
package src.ex2.ex2.Test;
import ex2.ex2.GUI_Shape_Collection;
import ex2.ex2.ShapeCollection;
import ex2.geo.*;
import ex2.gui.GUIShape;
import ex2.gui.GUI_Shape;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import ex2.ex2.ShapeCollection;
import ex2.geo.Circle_2D;
import ex2.geo.Point_2D;
import ex2.geo.Rect_2D;
import ex2.geo.Triangle_2D;
import ex2.gui.GUIShape;
import ex2.gui.GUI_Shape;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.*;
import java.io.File;
import java.util.Comparator;


public class ShapeCollectionTest {
    //Defining information fields
    private double radius = 5;
    private Point_2D center = new Point_2D(1,1);
    private Point_2D p1 = new Point_2D(4,6);
    private Point_2D p2 = new Point_2D(2,3);


    /**
     * This test checks whether the 'toString()' function works properly .
     * We will add shapes and check if we get the information we need to get.
     * circle1 ---> create a new circle.
     * circle2 ---> create a new circle.
     * expected1 ---> The first string to get.
     *  expected2 ---> The second string to get.
     */
    @Test
    public void testToString(){
        ShapeCollection shapeCollection = new ShapeCollection();;
        Circle_2D circle1 = new Circle_2D(p1, 3);
        Circle_2D circle2 = new Circle_2D(p2, 2);
        GUIShape shape1 = new GUIShape(circle1, true, Color.black, 1);
        GUIShape shape2 = new GUIShape(circle2, false, Color.yellow, 2);
        shapeCollection.add(shape1);
        shapeCollection.add(shape2);
        String  expected1="GUIShape,0,true,1,Circle_2D,4.0,6.0, 3.0";
        String  expected2="GUIShape,16776960,false,2,Circle_2D,2.0,3.0, 2.0";
        assertEquals( expected1, shapeCollection.get(0).toString());
        assertEquals( expected2, shapeCollection.get(1).toString());

    }

    /**
     * This test checks whether the 'get()' function works properly .
     * We will add shapes and check if we get the information we need to get.
     * circle1 ---> create a new circle.
     * circle2 ---> create a new circle.
     * expected ---> The string to get.
     */
    @Test
    public void testGet(){
        ShapeCollection shapeCollection = new ShapeCollection();;
        Circle_2D circle1 = new Circle_2D(p1, 3);
        Circle_2D circle2 = new Circle_2D(p2, 2);
        GUIShape shape1 = new GUIShape(circle1, true, Color.black, 1);
        GUIShape shape2 = new GUIShape(circle2, false, Color.yellow, 2);
        shapeCollection.add(shape1);
        shapeCollection.add(shape2);
        String  expected="GUIShape,16776960,false,2,Circle_2D,2.0,3.0, 2.0";
        assertEquals( expected, shapeCollection.get(1).toString());
    }

    /**
     *This test checks if a shape located at a certain index does not remain after the operation is executed.
     * c1  ---> creating a new circle.
     * r1 ---> creating a new rect.
     * shape1 ---> creating a gui shape.
     * shape2 ---> creating a gui shape.
     */
    @Test
    public void testRemoveAllElementAt () {
        ShapeCollection shapeCollection = new ShapeCollection();
        GeoShape c1 = new Circle_2D(center,radius);
        GeoShape r1 = new Rect_2D(p1,p2);
        GUIShape shape1 = new GUIShape(c1, false, Color.BLACK, 1);
        GUIShape shape2 = new GUIShape(r1, true, Color.BLUE, 2);
        shapeCollection.add(shape1);
        shapeCollection.add(shape2);
        shapeCollection.removeElementAt(1);
        assertEquals(1, shapeCollection.size());
    }

    /**
     *This test verifies that it is indeed possible to insert a shape we want in the desired index.
     * ce1  ---> creating a new circle.
     * ce2  ---> creating a new circle.
     * shape1 ---> creating a gui shape.
     * shape2 ---> creating a gui shape.
     */
    @Test
    public void testAddAt(){
        ShapeCollection shapeCollection = new ShapeCollection();
        Circle_2D ce1 = new Circle_2D(p1,1);
        Circle_2D ce2 = new Circle_2D(p2,2);
        GUIShape shape1 = new GUIShape(ce1, false, Color.BLACK, 1);
        GUIShape shape2 = new GUIShape(ce2, true, Color.BLUE, 2);
        shapeCollection.add(shape1);
        shapeCollection.addAt(shape2, 1);
        assertEquals(shape2,shapeCollection.get(1));
    }


    @Test
    /**
     * The test checks whether the function works properly, first we will add shapes, and then we will remove shapes, and it will appear that the registration is indeed empty.
     * c1 ---> creating a new circle.
     * r1 ---> creating a new rect.
     * shape1 ---> creating a gui shape.
     *shape2 ---> creating a gui shape.
     */

    public void testRemoveAll () {
        ShapeCollection shapeCollection = new ShapeCollection();
        GeoShape c1 = new Circle_2D(center,radius);
        GeoShape r1 = new Rect_2D(p1,p2);
        GUIShape shape1 = new GUIShape(c1, false, Color.BLACK, 1);
        GUIShape shape2 = new GUIShape(r1, true, Color.BLUE, 2);
        shapeCollection.add(shape1);
        shapeCollection.add(shape2);
        shapeCollection.removeAll();
        assertEquals(0, shapeCollection.size());
    }

    @Test
    /**
     * The test here checks if the file was created successfully by checking that the file exists on the system.
     * Adding the line `file.delete()` deletes the file after the test so as not to save irrelevant files.
     * file name ---> Creating a name for the file we want to save.
     * file ---> Creating a file.
     */
    public void TestSave (){
        String fileName = "testFile.txt";
        ShapeCollection file = new ShapeCollection();
        file.save(fileName);
        File file1 = new File(fileName);
        assertTrue(file1.exists());
        file1.delete();
    }
    @Test
    /**
     * Tests the addition of GUI shapes to the shapeCollection.
     * It adds two GUI shapes to the collection and verifies that they were added successfully.
     *  p ---> creating a new point.
     *  c1 ---> creating a new circle.
     *  c2 ---> creating a new circle.
     */
    public void testAdd (){
        ShapeCollection shapeCollection = new ShapeCollection();
        Point_2D p = new Point_2D(2,4);
        GeoShape c1 = new Circle_2D(p,1);
        GeoShape c2 = new Circle_2D(p,5);
        GUIShape shape1 = new GUIShape(c2, false, Color.BLACK, 1);
        GUIShape shape2 = new GUIShape(c1, true, Color.RED, 2);
        shapeCollection.add(shape1);
        shapeCollection.add(shape2);
        assertEquals(shape1, shapeCollection.get(0));
        assertEquals(shape2, shapeCollection.get(1));
    }



    @Test
    /**
     * This test case verifies the functionality of copying shapes in a ShapeCollection
     * and ensuring that the copied shapes are independent of the original shapes.
     * p ---> creating a new point.
     * p2 ---> creating a new point.
     * c1 ---> creating a new circle.
     * c2 ---> creating a new circle.
     */
   public void testCopy() {
        ShapeCollection shapeCollection = new ShapeCollection();
        Point_2D p = new Point_2D(2,4);
        Point_2D p2 = new Point_2D(3,4);
        Circle_2D c1 = new Circle_2D(p2,2);
        Circle_2D c2 = new Circle_2D(p,5);
        GUIShape shape1 = new GUIShape(c1, false, Color.BLACK, 1);
        GUIShape shape2 = new GUIShape(c2, true, Color.RED, 2);
        shapeCollection.add(shape1.copy());
        shapeCollection.add(shape2.copy());
        assertEquals(shape1,shapeCollection.get(0));
        assertEquals(shape2,shapeCollection.get(1));
    }


    @Test
    /**
     * A test that checks the sorting of objects.
     * p ---> creating a new point.
     * p2 ---> creating a new point.
     * c1 ---> creating a new circle.
     * c2 ---> creating a new circle.
     * c3 ---> creating a new circle.
     *
     */
    void testSort() {
        ShapeCollection shapeCollection = new ShapeCollection();
        Point_2D p = new Point_2D(2,4);
        Point_2D p2 = new Point_2D(3,4);
        GeoShape c1 = new Circle_2D(p2,2);
        GeoShape c2 = new Circle_2D(p,5);
        GeoShape c3 = new Circle_2D(p,7);
        GUIShape shape1 = new GUIShape(c3, false, Color.BLACK, 2);
        GUIShape shape2 = new GUIShape(c1, true, Color.RED, 3);
        GUIShape shape3 = new GUIShape(c2, true, Color.BLUE, 1);
        shapeCollection.add(shape1);
        shapeCollection.add(shape2);
        shapeCollection.add(shape3);
        Comparator<GUI_Shape> comparator = Comparator.comparingInt(GUI_Shape::getTag);
        shapeCollection.sort(comparator);
       assertEquals(shape3, shapeCollection.get(0));
       assertEquals(shape1, shapeCollection.get(1));
       assertEquals(shape2, shapeCollection.get(2));
    }

    /**
     * This test case verifies the functionality of loading a ShapeCollection from a file,
     * ensuring that the loaded collection matches the original collection.
     * p ---> creating a new point .
     * p2 ---> creating a new point.
     * c1 ---> creating a first circle.
     * c2 ---> creating a second circle.
     */
    @Test
    public void testLoad() {
        ShapeCollection shapeCollection = new ShapeCollection();
        Point_2D p = new Point_2D(2, 4);
        Point_2D p2 = new Point_2D(3, 4);
        GeoShape c1 = new Circle_2D(p2, 2);
        GeoShape c2 = new Circle_2D(p, 5);
        GUIShape shape1 = new GUIShape(c1, false, Color.BLACK, 1);
        GUIShape shape2 = new GUIShape(c2, true, Color.RED, 2);
        shapeCollection.add(shape1);
        shapeCollection.add(shape2);

        String filePath = "shapes.txt";
        shapeCollection.save(filePath);
        ShapeCollection loadedCollection = new ShapeCollection();
        loadedCollection.load(filePath);

        assertEquals(shapeCollection.size(), loadedCollection.size());
        assertEquals(shapeCollection.get(0).toString(), loadedCollection.get(0).toString());
        assertEquals(shapeCollection.get(1).toString(), loadedCollection.get(1).toString());
    }

    /**
     * This test checks whether two instances of `ShapeCollection` are considered equal when they contain the same shapes added in the same order.
     * It creates two `ShapeCollection` instances (`shapeCollection1` and `shapeCollection2`) and adds the same shapes (`shape1` and `shape2`) to both collections in the same order.
     * Then, it asserts that `shapeCollection1` equals `shapeCollection2`, expecting the `equals` method to return `true`.
     * circle1 ---> create a new circle.
     * circle2 ---> create a new circle.
     */
    @Test
    public void testEquals() {
        ShapeCollection shapeCollection1 = new ShapeCollection();
        ShapeCollection shapeCollection2 = new ShapeCollection();
        Circle_2D circle1 = new Circle_2D(p1, 3);
        Circle_2D circle2 = new Circle_2D(p2, 2);
        GUIShape shape1 = new GUIShape(circle1, true, Color.black, 1);
        GUIShape shape2 = new GUIShape(circle2, false, Color.yellow, 2);
        shapeCollection1.add(shape1);
        shapeCollection1.add(shape2);
        shapeCollection2.add(shape1);
        shapeCollection2.add(shape2);
        assertTrue(shapeCollection1.equals(shapeCollection2));
    }
}
