/**
 * Name ---> Ron Amsalem.
 * ID ---> 326029600.
 */
package src.ex2.geo.Test;
import ex2.ex2.ShapeCollection;
import ex2.geo.Circle_2D;
import ex2.geo.Point_2D;
import ex2.geo.ShapeComp;
import ex2.gui.GUIShape;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.awt.*;


public class ShapeCompTest {
    private double radius = 5;
    private Point_2D center = new Point_2D(1, 1);
    private Point_2D p1 = new Point_2D(4, 6);
    private Point_2D p2 = new Point_2D(2, 3);
    ShapeCollection shapeCollection = new ShapeCollection();

    /**
     * This test checks the sorting according to a specific type of sorting:
       -area.
       -anti area.
       -perimeter.
       -anti perimeter.
       -to string.
       -anti to string.
       -tag
       -anti tag
     */
    @Test
    public void ShapeCompTest() {
        Circle_2D circle1 = new Circle_2D(center, 1);
        Circle_2D circle2 = new Circle_2D(p1, 2);
        GUIShape shape1 = new GUIShape(circle1, true, Color.black, 1);
        GUIShape shape2 = new GUIShape(circle2, false, Color.yellow, 2);
        shapeCollection.add(shape1);
        shapeCollection.add(shape2);

        //Sort by anti area
        shapeCollection.sort(ShapeComp.CompByAntiArea);
        Assertions.assertEquals(shape2, shapeCollection.get(0));

        //Sort by area
        shapeCollection.sort(ShapeComp.CompByArea);
        Assertions.assertEquals(shape1,shapeCollection.get(0));

        //Sort by Anti Perimeter
       shapeCollection.sort(ShapeComp.CompByAntiPerimeter);
        Assertions.assertEquals(shape2, shapeCollection.get(0));

        //Sort by Perimeter
        shapeCollection.sort(ShapeComp.CompByPerimeter);
        Assertions.assertEquals(shape1,shapeCollection.get(0));

        //Sort by Anti toString
       shapeCollection.sort(ShapeComp.CompByAntiToString);
        Assertions.assertEquals(shape1, shapeCollection.get(0));

        //Sort by toString
       shapeCollection.sort(ShapeComp.CompByToString);
        Assertions.assertEquals(shape2, shapeCollection.get(0));

        //Sort  By Anti Tag
        shapeCollection.sort(ShapeComp.SortByAntiTag);
        Assertions.assertEquals(shape2, shapeCollection.get(0));

        //Sort by Tag
        shapeCollection.sort(ShapeComp.CompSortByTag);
        Assertions.assertEquals(shape1, shapeCollection.get(0));

    }
}
