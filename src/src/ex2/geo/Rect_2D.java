/**
 * Name ---> Ron Amsalem
 * ID ---> 326029600
 */

package src.ex2.geo;

import java.util.Objects;

/**
 * This class represents a 2D axis parallel rectangle.
 * Ex4: you should implement this class!
 *
 * @author I2CS
 */
public class Rect_2D implements GeoShape {
    private Point_2D _a;
    private Point_2D _b;
    private Point_2D _c;
    private Point_2D _d;

    /**
     * This constructor is used to create a rectangle based on two given points, p1 and p2. These points define the diagonal of the rectangle.
     * The constructor takes two points, p1 and p2, as parameters. These points determine the diagonal of the rectangle.
     * @param p1 ---> Point p1 is copied to point a. This ensures that point a of the rectangle is located in the same position as point p1.
                        Point p1 is copied again to point b, but with the y-coordinate of p1 and the x-coordinate of p2. This ensures that point b is the same height as a but the same width as p2.
     * @param p2 ---> Point p2 is copied to point c. This ensures that point c is located at the same position as point p2.
     *            Point p2 is copied again to point d, but with the y-coordinate of p1 and the x-coordinate of p2. This ensures that point d is at the same height as c but at the same width as p1.
     */
    public Rect_2D(Point_2D p1, Point_2D p2) {
        _a = new Point_2D(p1);
        _b = new Point_2D(p1.x(), p2.y());
        _c = new Point_2D(p2);
        _d = new Point_2D(p2.x(), p1.y());

    }
    public Rect_2D(Point_2D p1, Point_2D p2,Point_2D p3, Point_2D p4) {
        _a = new Point_2D(p1);
        _b = new Point_2D(p2);
        _c = new Point_2D(p3);
        _d = new Point_2D(p4);

    }

    /**
     * constructor by given rectangle
     *
     * @param t1
     */
    public Rect_2D(Rect_2D t1) {
        _a = new Point_2D(t1._a);
        _b = new Point_2D(t1._b);
        _c = new Point_2D(t1._c);
        _d = new Point_2D(t1._d);
    }

    //get for point number 1
    public Point_2D getA() {
        return new Point_2D(this._a);
    }

    //get for point number 2
    public Point_2D getB() {
        return new Point_2D(this._b);
    }

    //get for point number 3
    public Point_2D getC() {
        return new Point_2D(this._c);
    }

    //get for point number 4
    public Point_2D getD() {
        return new Point_2D(this._d);
    }

    //get the Width of the rectangle
    public double getHeight() {
        return this._a.distance(_b);
    }

    //get the Width of the rectangle
    public double getWidth() {
        return this._a.distance(_d);
    }

    /**
     * Returns the midpoint of the rectangle
     *
     * @return
     */
    public Point_2D getCenPoint() {
        double minX = Math.min(Math.min(_a.x(), _b.x()), Math.min(_c.x(), _d.x()));
        double MaxX = Math.max(Math.max(_a.x(), _b.x()), Math.max(_c.x(), _d.x()));
        double MaxY = Math.max(Math.max(_a.y(), _b.y()), Math.max(_c.y(), _d.y()));
        double MinY = Math.min(Math.min(_a.y(), _b.y()), Math.min(_c.y(), _d.y()));

        double x = (MaxX + minX) / 2, y = (MaxY + MinY) / 2;
        Point_2D ans = new Point_2D(x, y);
        return ans;
    }

    /**
     * This method returns a string representing a rect.
     * such that this string can be used to save the shape in a text file.
     * @return a string representing a rect.
     * */
    @Override
    public String toString() {
        return _a.toString()+","+_c.toString()+","+_b.toString()+","+_d.toString();
    }

    /**
     * *This method is used to determine if two objects are equal based on criteria such as vertices that characterize the rect.
     * *This method checks several things:
     * (1) If the object being compared (`o`) is the same as the current object (`this`), then they are equal, and the method returns `true`.
     * (2) We will check if the object being compared (`o`) is `null` or if it belongs to a different class than the current object. If either of these conditions is true, the objects are not equal, and the method returns 'false'.
     * * @param o
     * * @return ---> if the points of the rect are equal to the comparing object the method returns `true`; Otherwise, it returns 'false'.
      */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rect_2D rect2D = (Rect_2D) o;
        return Objects.equals(_a, rect2D._a) && Objects.equals(_b, rect2D._b) && Objects.equals(_c, rect2D._c) && Objects.equals(_d, rect2D._d);
    }



    /**
     * This function Checks whether a point is in a rect or not.
     * It divides the rectangle into 4 triangles using the point 'ot' we want to check.
     * If the area of all small triangles is equal to or less than the area of the rectangle then the point is in the rect.
     *
     * @param ot - a query 2D point
     * @return ---> True if the point is inside and false if the point is outside.
     */
    @Override
    public boolean contains(Point_2D ot) {
        Triangle_2D a = new Triangle_2D(ot, _b, _c);
        Triangle_2D b = new Triangle_2D(_b, ot, _a);
        Triangle_2D c = new Triangle_2D(_a, _d, ot);
        Triangle_2D d = new Triangle_2D(_d, ot, _c);
        Rect_2D rect = new Rect_2D(_a, _c);
        double rectArea = rect.area();
        if (a.area() + b.area() + c.area() + d.area() <= rectArea) {
            return true;
        }
        return false;
    }

    /**
     * This function calculates the area of a rectangle (width * length).
     *
     * @return ---> area of the rect.
     */

    @Override
    public double area() {
        double result = _a.distance(_b) * _b.distance(_c);
        return result;
    }

    /**
     * The function calculates the perimeter of the rect by using it in a 'distance()' function.
     *
     * @return ---> perimeter of rect.
     */
    @Override
    public double perimeter() {
        double perimeter = (_a.distance(_b) + _b.distance(_c)) * 2;

        return perimeter;
    }

    @Override
/**
 *  *The function moves the rect by the vector 0,0 ---> vec.
 * 	 * @param vec - a vector from the 0,0.
 */
    public void translate(Point_2D vec) {
        this._a.move(vec);
        this._b.move(vec);
        this._c.move(vec);
        this._d.move(vec);
    }

    /**
     * A method called copy returns a copy of a rect.
     *
     * @return --->A new rect that is a copy.
     */
    @Override
    public GeoShape copy() {
        return new Rect_2D(_a, _c);
    }

    /**
     * Scales the rect relative to a given center point by a specified ratio.
     *
     * @param center - center point from which the rescaling is being done.
     * @param ratio  - the ratio of rescaling.
     */
    @Override
    public void scale(Point_2D center, double ratio) {
        this._a.scale(center, ratio);
        this._b.scale(center, ratio);
        this._c.scale(center, ratio);
        this._d.scale(center, ratio);
    }

    /**
     * Rotates the rect around a given center point by a specified angle in degrees.
     *
     * @param center       - center point from which the rotation is being done.
     * @param angleDegrees - the angle (in Degrees) the shape should be rotated by.
     */

    @Override
    public void rotate(Point_2D center, double angleDegrees) {
        this._a.rotate(center, angleDegrees);
        this._b.rotate(center, angleDegrees);
        this._c.rotate(center, angleDegrees);
        this._d.rotate(center, angleDegrees);
    }


}
