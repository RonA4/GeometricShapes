/**
 * Name:Ron amsalem
 * ID:326029600
 */

package src.ex2.geo;

import java.util.Objects;

/**
 * This class represents a 2D circle in the plane.
 * Please make sure you update it according to the GeoShape interface.
 * Ex2: you should update this class!
 * @author boaz.benmoshe
 */


public class Circle_2D implements GeoShape {
    private Point_2D _center;
    private double _radius;

    public Circle_2D(Point_2D cen, double rad) {
        this._center = new Point_2D(cen);
        this._radius = rad;
    }

    public Circle_2D(Circle_2D c) {
        this(c.getCenter(), c.getRadius());
    }

    public double getRadius() {
        return this._radius;
    }

    public Point_2D getCenter() {
        return _center;
    }

    /**
     * This method returns a string representing a circle by radius and center point.
     * @return ---> to string that present the geo shape from type circle to string .
     */
    @Override
    public String toString() {
        return _center.toString() + ", " + _radius;
    }

    /**
     *This method is used to determine if two objects are equal based on criteria such as center point and radius.
     *This method checks several things:
      (1) If the object being compared (`o`) is the same as the current object (`this`), then they are equal, and the method returns `true`.
      (2) We will check if the object that compares (`o`) is `null` or if it belongs to a different class than the current object. If either of these conditions is true, the objects are not equal, and the method returns 'false'.
     * @param o
     * @return ---> If both the radius and the center are equal, the method returns `true`; Otherwise, it returns 'false'.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Circle_2D circle2D = (Circle_2D) o;
        return Double.compare(circle2D._radius, _radius) == 0 && Objects.equals(_center, circle2D._center);
    }

    /**
     * The function checks whether a certain point is inside the circle or not (you can take into account that if the point is on the circle it is still inside the circle).
     * The function checks it like this :
     * (1) If the distance of the point from the center of the circle is equal to the radius of the circle.
     * (2) If it is smaller than the radius it is inside the circle.
     * (3) If it is greater than the radius, it is outside the circle.
     * @param ot ---> a query 2D point.
     * @return ---> true if the point falls with in circle.
     */
    @Override
    public boolean contains(Point_2D ot) {
        if (this._radius >= ot.distance(this._center)) {
            return true;
        }
        else {
            return false;
        }
    }
    /**
     * area () uses the Math class in order to have the ability to calculate the area of the circle (radius^2*PI).
     * @return --->Return the calculated area.
     */
    @Override
    public double area() {
        double area = Math.PI * Math.pow(_radius, 2);
        return area;
    }
    /**
     * perimeter () uses the Math class in order to have the ability to calculate the perimeter of the circle (2*radius*PI).
     * @return --->Return the calculated perimeter.
     */
    @Override
    public double perimeter() {
        double perimeter = 2 * _radius * Math.PI;
        return perimeter;
    }
    /**
     * This method changes the center of the circle according to vec.
     * @param vec - a vector from the 0,0.
     */
    @Override
    public void translate(Point_2D vec) {
        _center = new Point_2D(_center.x() + vec.x(), _center.y() + vec.y());
    }
    /**
     *  A method called copy returns a copy of a circle.
     * @return --->A new circle that is a copy.
     */
    @Override
    public GeoShape copy() {
        return new Circle_2D(_center, _radius);
    }
    /**
     * This method rescales a circle relative to the given center point.
     * The function checks if the center point `center` is not included within the circle using the `()contains` condition. If the center point is not contained within the circle
      (1) It changes the center point `_center` according to the activation of the `scale` function.
      (2) It updates the radius of the circle, because it is calculated from the center (`_radius = _radius * ratio`).
     *If the center point 'center' is already contained within the circle, the function updates the radius of the circle based on the scale ratio
     * @param center ---> center point from which the rescaling is being done.
     * @param ratio  ---> the ratio of rescaling.
     */
    @Override
    public void scale(Point_2D center, double ratio) {
        if (!contains(center)) {
            _center.scale(center, ratio);
            _radius = _radius * ratio;
        }
        else{
            _radius = _radius * ratio;
        }
    }
    /**
     * Rotate this triangle with respect to the given center point by an angle.
     * @param center - center point from which the rotation is being done.
     * @param angleDegrees - the angle (in Degrees) the shape should be rotated by.
     */
    @Override
    public void rotate(Point_2D center, double angleDegrees) {
        _center.scale(center, angleDegrees);
    }
}
