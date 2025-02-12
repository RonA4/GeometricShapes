/**
 * Name ---> Ron Amsalem
 * ID ---> 326029600
 */

package src.ex2.geo;

import java.util.Objects;

/**
 * This class represents a 2D segment on the plane, 
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */
public class Segment_2D implements GeoShape{
	private Point_2D _a;
	private Point_2D _b;

	/**
	 * Constructs a new Segment_2D object with the specified endpoints.
	 * @param a The first endpoint of the segment.
	 * @param b The second endpoint of the segment.
	 */
	public Segment_2D(Point_2D a, Point_2D b) {
		this._a = new Point_2D(a);
		this._b = new Point_2D(b);

	}
	/**
	 * Constructs a new Segment_2D object that is a copy of the specified Segment_2D.
	 * @param t1 The Segment_2D object to copy.
	 */
	public Segment_2D(Segment_2D t1) {
		_a = new Point_2D(t1.get_p1());
		_b = new Point_2D(t1.get_p2());

	}
	/**
	 * Returns a new Point_2D object representing the first endpoint of the segment.
	 * @return A new Point_2D object representing the first endpoint of the segment.
	 */
	public Point_2D get_p1() {
		return new Point_2D(_a);
	}
	/**
	 * Returns a new Point_2D object representing the second endpoint of the segment.
	 * @return A new Point_2D object representing the second endpoint of the segment.
	 */
	public Point_2D get_p2() {

		return new Point_2D(_b);
	}
	/**
	 * This function checks whether a point is on a segment.
	 * @param ot ---> A point we would like to know if it is on the segment.
	 * Calculation of the distance from point _a to ot and the distance between ot and point _b ,if it is equal to the distance between point _a and point _b, we can conclude that the point ot is on the segment.
	 * @return ---> return true if it is found and if not then return false
	 */
	@Override
	public boolean contains(Point_2D ot) {
		if (_a.distance(ot) + ot.distance(_b) == _a.distance(_b)){
			return true;
		}
			return false;
	}
	/**
	 * A function that checks the area of a segment, according to the interface (GeoShape) the area is 0.
	 * @return --> 0
	 */
	@Override
	public double area() {
		return 0;
	}
	/**
	 *A function that checks the perimeter of a Segment, according to the interface (GeoShape) the perimeter is 2 times the distance between the edges.
	 * @return --->Segment perimeter.
	 */
	@Override
	public double perimeter() {
		return 2*_a.distance(_b);
	}

	/**
	 * moves the line segment by a given vector.
	 * This method modifies the line segment by moving its endpoints according to the given vector.
	 * The line _a.move(vec) moves the first endpoint _a by the vector vec.
	 * line _b.move(vec) moves the second endpoint _b by the same vector.
	 * @param vec - a vector from the 0,0 ---> The vector by which to translate the line segment.
	 */

	@Override
	public void translate(Point_2D vec) {
		_a.move(vec);
		_b.move(vec);
	}

	/**
	 *The copy method creates a copy of the current segment.
	 * @return ---> new segment.
	 */
	@Override
	public GeoShape copy() {
		Segment_2D ans = new Segment_2D(_a,_b);
		return ans;

	}

	/**
	 * The scale method changes the line segment relative to a given center point and scale ratio.
	 * The method modifies the line segment by scaling its endpoints relative to the given center point and scale ratio.
	 * @param center - center point from which the rescaling is being done.
	 * @param ratio - the ratio of rescaling.
	 */
	@Override
	public void scale(Point_2D center, double ratio) {
		_a.scale(center,ratio);
		_b.scale(center,ratio);

	}
	/**
	 * Rotates the segment around the specified center point by the given angle in degrees.
	 * @param center - center point from which the rotation is being done.
	 * @param angleDegrees - the angle (in Degrees) the shape should be rotated by.
	 */
	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		_a.rotate(center,angleDegrees);
		_b.rotate(center,angleDegrees);
	}

	/**
	 * This method is used to determine if two objects are equal based on criteria such as the endpoints of the segment.
	 * *This method checks several things:
	 * (1) If the object being compared (`o`) is the same as the current object (`this`), then they are equal, and the method returns `true`.
	 * (2) We will check if the object that compares (`o`) is `null` or if it belongs to a different class than the current object. If either of these conditions is true, the objects are not equal, and the method returns 'false'.
	 * * @param o
	 * * @return ---> If the endpoints are equal then, the method returns `true`; Otherwise, it returns 'false'.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Segment_2D segment2D = (Segment_2D) o;
		return Objects.equals(_a, segment2D._a) && Objects.equals(_b, segment2D._b);
	}


	/**
	 * This method returns a string representing a Segment.
	 * such that this string can be used to save the shape in a text file.
	 * @return a string representing a segment.
	 */
	@Override
	public String toString() {
		return _a.toString()+","+_b.toString();

	}
}