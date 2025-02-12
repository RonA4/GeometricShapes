/**
 * Name ---> Ron Amsalem
 * ID ---> 326029600
 */
package src.ex2.geo;

import java.util.Objects;

/**
 * This class represents a 2D Triangle in the plane.
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */
public class Triangle_2D implements GeoShape{ //Creating properties of the triangle
	private Point_2D _a;
	private Point_2D _b;
	private Point_2D _c;
	/**
	 * A constructor that receives the points of the triangle.
	 * @param p1 ---> First point of the triangle.
	 * @param p2 ---> Second point of the triangle.
	 * @param p3 ---> Third point of the triangle.
	 */
	public Triangle_2D(Point_2D p1, Point_2D p2, Point_2D p3) {
		this._a=p1;
		this._b=p2;
		this._c=p3;
	}
	/**
	 * This method returns a string representing a Triangle.
	 * such that this string can be used to save the shape in a text file.
	 * @return a string representing a triangle.
	 */
	@Override
	public String toString() {
		return _a.toString()+","+_b.toString()+","+_c.toString();
	}
	/**
	 * Constructs a new Triangle_2D object that is a copy of the specified Triangle_2D.
	 * @param t1 ---> The triangle object to copy.
	 */
	public Triangle_2D(Triangle_2D t1) {
		this._a = t1._a;
		this._b = t1._b;
		this._c= t1._c;
	}
	/**
	 * Creates an array of objects, that is, an array of points of the triangle.
	 * @return ---> An array containing the three points of the triangle: _a, _b, and _c.
	 */
	public Point_2D[] getAllPoints() {
		Point_2D[] points = {this._a, this._b, this._c};
		return points;
	}
	/**
	 * This function checks if a point is inside a triangle.
	 * I used the principle that the sum of the areas of the three triangles obtained by dividing the triangle should be equal to the area of the original triangle.
	 * It is necessary that the sums of the areas of the small triangles created by the division are at least equal to the area of the original triangle, and if so - the point is inside the triangle.
	 * t1 ---> Creating a triangle with 2 of the sides of the original triangle.
	 * t2 ---> Creating a triangle with 2 of the sides of the original triangle.
	 * t3 ---> Creating a triangle with 2 of the sides of the original triangle.
	 * @param ot - a query 2D point.
	 * @return --->True if the given point is in a triangle else return false.
	 */
	@Override
	public boolean contains(Point_2D ot) {
		Triangle_2D t1 = new Triangle_2D(ot, _a, _c);
		Triangle_2D t2 = new Triangle_2D(_a, ot, _b);
		Triangle_2D t3 = new Triangle_2D(_c,_b, ot);
		if (t1.area() + t2.area() + t3.area() <= area()) {
			return true;
		}
		return false;
	}
	/**
	 * This function, the method of calculating the area of the triangle is according to the Heron formula.
	    https://he.wikipedia.org/wiki/%D7%A0%D7%95%D7%A1%D7%97%D7%AA_%D7%94%D7%A8%D7%95%D7%9F
	 * d1 --->The distance between _a and _b.
	 * d2 --->The distance between _b and _c.
	 * d3 --->The distance between _c and _a.
	 * @return ---> return the area of a triangle.
	 */
	@Override
	public double area() {
		double d1 = _a.distance(_b);
		double d2 = _b.distance(_c);
		double d3 = _c.distance(_a);
		double z = (d1 + d2 + d3) * (d1 + d2 - d3) * (d2 + d3 - d1) * (d3 + d1 - d2);
		double x = Math.abs(z);
		double w = Math.sqrt(x);
		double area = w / 4;
		return area;
	}
	/**
	 *This function calculates the perimeter of a triangle.
	 * d1 --->The distance between _a and _b.
	 * d2 --->The distance between _b and _c.
	 * d3 --->The distance between _c and _a.
	 * @return ---> return the perimeter of a triangle.
	 */
	@Override
	public double perimeter() {
		double d1 = _a.distance(_b);
		double d2 = _b.distance(_c);
		double d3 = _c.distance(_a);
		double perimeter = d1+d2+d3;
		return perimeter;
	}
	/**
	 *The function moves the triangle by the vector 0,0 ---> vec.
	 * @param vec - a vector from the 0,0
	 */
	@Override
	public void translate(Point_2D vec) {
		_a.move(vec);
		_b.move(vec);
		_c.move(vec);
	}
	/**
	 * This function creates a copy of an existing triangle.
	 * @return ---> A new triangle that is a copy.
	 */
	@Override
	public GeoShape copy() {
		Point_2D p1N = new Point_2D(this._a);
		Point_2D p2N = new Point_2D(this._b);
		Point_2D p3N = new Point_2D(this._c);
		Triangle_2D tri = new Triangle_2D(p1N,p2N,p3N);
		return tri;

	}
	/**
	 * Scales the triangle relative to a given center point by a specified ratio.
	 * @param center - center point from which the rescaling is being done.
	 * @param ratio - the ratio of rescaling.
	 */
	@Override
	public void scale(Point_2D center, double ratio) {
		if (!contains(center)) {
			center.scale(center, ratio);
			_a.scale(center, ratio);
			_b.scale(center, ratio);
			_c.scale(center, ratio);
		}
		else {
			_a.scale(center, ratio);
			_b.scale(center, ratio);
			_c.scale(center, ratio);

		}
	}

	/**
	 * Rotates the triangle around a given center point by a specified angle in degrees.
	 * @param center - center point from which the rotation is being done.
	 * @param angleDegrees - the angle (in Degrees) the shape should be rotated by.
	 */
	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		_a.rotate(center,angleDegrees);
		_b.rotate(center,angleDegrees);
		_c.rotate(center,angleDegrees);
	}

	/**
	 *This method is used to determine if two objects are equal based on criteria such as points characterizing a triangle.
	 *This method checks several things:
	  (1) If the object being compared (`o`) is the same as the current object (`this`), then they are equal, and the method returns `true`.
	 (2) We will check if the object being compared (`o`) is `null` or if it belongs to a different class than the current object. If either of these conditions is true, the objects are not equal, and the method returns 'false'.
	 * @param o
	 * @return ---> If the points of the triangle are equal then, the method returns `true`; Otherwise, it returns 'false'.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Triangle_2D that = (Triangle_2D) o;
		return Objects.equals(_a, that._a) && Objects.equals(_b, that._b) && Objects.equals(_c, that._c);
	}

}
