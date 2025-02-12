/**
 * Name ---> Ron Amsalem
 * ID ---> 326029600
 */
package src.ex2.geo;
import java.util.ArrayList;
import java.util.Objects;

public class Polygon_2D implements GeoShape {
	private ArrayList<Point_2D> arrayListOfPoints;

	public Polygon_2D() {
		this.arrayListOfPoints = new ArrayList<Point_2D>();
	}

	public Polygon_2D(Polygon_2D po) {
		this.arrayListOfPoints=new ArrayList<>(po.arrayListOfPoints);
		}


	public Point_2D[] getAllPoints() {
		Point_2D[] p1 = new Point_2D[this.arrayListOfPoints.size()];
		p1 = this.arrayListOfPoints.toArray(p1);
		return p1;

	}

	public void add(Point_2D p) {
		if (!arrayListOfPoints.contains(p)) {
			this.arrayListOfPoints.add(p);
		}

	}

	public Polygon_2D(ArrayList<Point_2D> arr) {
		arrayListOfPoints = new ArrayList<>();
		for (int i = 0; i < arr.size(); i++) {
			this.arrayListOfPoints.add(arr.get(i));
		}

	}

	public double[] getX() {
		double[] x = new double[arrayListOfPoints.size()];
		for (int i = 0; i < arrayListOfPoints.size(); i++) {
			x[i] = arrayListOfPoints.get(i).x();
		}
		return x;
	}

	/*
	returns array of the y coordinates of the points of the polygon
	 */
	public double[] getY() {
		double[] y = new double[arrayListOfPoints.size()];
		for (int i = 0; i < arrayListOfPoints.size(); i++) {
			y[i] = arrayListOfPoints.get(i).y();
		}
		return y;
	}


	/**
	 * This method returns a string representing a polygon.
	 * such that this string can be used to save the shape in a text file.
	 * @return a string representing a polygon
	 */
	@Override
	public String toString() {
		String res = arrayListOfPoints.get(0).toString();
		for (int i =1 ; i<arrayListOfPoints.size();i++) {
			res += "," + arrayListOfPoints.get(i).toString();
		}
		return res;
	}
	/**
	 *This method is used to determine if two objects are equal based on criteria such as vertices that characterize the polygon.
	 *This method checks several things:
	 (1) If the object being compared (`o`) is the same as the current object (`this`), then they are equal, and the method returns `true`.
	 (2) We will check if the object being compared (`o`) is `null` or if it belongs to a different class than the current object. If either of these conditions is true, the objects are not equal, and the method returns 'false'.
	 * @param o
	 * @return ---> if the polygon points are equal to the comparison object the method returns `true`; Otherwise, it returns 'false'.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Polygon_2D polygon2D = (Polygon_2D) o;
		return Objects.equals(arrayListOfPoints, polygon2D.arrayListOfPoints);
	}


	/**
	 * The function checks if the point `ot` is inside the polygon defined by the points in `arrayListOfPoints`.
	 * https://en.wikipedia.org/wiki/Point_in_polygon.
	 * crossings---> A counter that counts the number of times lines have met.
	 * (1) If there is a meeting between the edges and the line, the number of cuts increases.
	 * (2) If the number of sections is odd, the point is considered inside the polygon. Otherwise, it is considered out.
	 * There are 3 conditions inside the if:
	 * (1) Checks if the y coordinate of `ot' is between the y coordinates of `vertex1' and `vertex 2'.
	 * (2) checks if the y-coordinate of `ot' is between the y-coordinates of `vertex 2' and `vertex1'.
	 * (3) This condition checks if the x-coordinate of the intersection point between the edge defined by ``vertex1'' and ``vertex2'' and the horizontal line passing through ``ot'' is to the left of the x-coordinate of 'ot' .
	 * @param ot ---> This represents the point you want to check if it is inside the polygon or not.
	 * @return ---> true if the point is inside and false if it is outside.
	 */
	@Override
	public boolean contains(Point_2D ot) {
		int crossings = 0; // Number of line segment crossings
		int n = arrayListOfPoints.size(); // Number of vertices in the polygon
		for (int i = 0; i < n; i++) {
			Point_2D vertex1 = arrayListOfPoints.get(i);
			Point_2D vertex2 = arrayListOfPoints.get((i + 1) % n);
			if (((vertex1.y() <= ot.y()) && (vertex2.y() > ot.y())) || ((vertex1.y() > ot.y()) && (vertex2.y() <= ot.y()))
					&& (ot.x() < (vertex2.x() - vertex1.x()) * (ot.y() - vertex1.y()) / (vertex2.y() - vertex1.y()) + vertex1.x())) {
				crossings++;
			}
		}
		if (crossings % 2 == 1) {
			return true;
		}
		return false;
	}

	/**
	 * Calculating the area of a polygon using the Shoelace formula.
	 * I use ---> https://he.wikipedia.org/wiki/%D7%A0%D7%95%D7%A1%D7%97%D7%AA_%D7%94%D7%A9%D7%A8%D7%95%D7%9A
	 * @return ---> Area of a polygon.
	 */
	@Override
	public double area() {
		double ans = 0;
		for (int i = 0; i < arrayListOfPoints.size(); i++) {
			Point_2D p1 = arrayListOfPoints.get(i);
			Point_2D p2 = arrayListOfPoints.get((i + 1) % arrayListOfPoints.size());
			ans += (p1.x() * p2.y()) - (p1.y() * p2.x());
		}
		ans = Math.abs(ans / 2);
		return ans;
	}
	/**
	 * This `perimeter()` function calculates the perimeter of the polygon defined by the points in the `arrayListOfPoints`.
	 * It iterates over all the points in the list and calculates the distance between them.
	 * In each iteration of the loop, the perimeter of the polygon is incremented by the distance between the points `p1` and `p2`. This is done by calling the `distance()` function, which calculates the distance between two points in the plane.
	 * @return --->Perimeter of a polygon.
	 */
	@Override
	public double perimeter() {
		double ans = 0;
		for (int i = 0; i < arrayListOfPoints.size(); i++) {
			Point_2D p1 = arrayListOfPoints.get(i);
			Point_2D p2 = arrayListOfPoints.get((i + 1) % arrayListOfPoints.size());
			ans += p1.distance(p2);
		}
		return ans;
	}
	/**
	 *The function moves the polygon by the vector 0,0 ---> vec.
	 * @param vec - a vector from the 0,0.
	 */
	@Override
	public void translate(Point_2D vec) {
		for (Point_2D point : arrayListOfPoints) {
			point.move(vec);
		}
	}
	/**
	 * This function creates a copy of an existing polygon.
	 * @return ---> A new polygon that is a copy.
	 */
	@Override
	public GeoShape copy() {
		ArrayList<Point_2D> polyPointsC=new ArrayList<Point_2D>();
		for(int i=0;i<arrayListOfPoints.size();i++) {
			Point_2D deepCP=new Point_2D(this.arrayListOfPoints.get(i));
			polyPointsC.add(deepCP);
		}
		Polygon_2D copyPoly = new Polygon_2D(polyPointsC);
		return copyPoly;
	}


	/**
	 * Scales the polygon relative to a given center point by a specified ratio.
	 * @param center - center point from which the rescaling is being done.
	 * @param ratio - the ratio of rescaling.
	 */
	@Override
	public void scale(Point_2D center, double ratio) {
		int n = arrayListOfPoints.size();
		if (n > 2) {
			for (int i = 0; i < n; i++) {
				Point_2D current = arrayListOfPoints.get(i);
				current.scale(center, ratio);
			}
		}
	}

	/**
	 * * Rotates the polygon around a given center point by a specified angle in degrees.
	 * @param center - center point from which the rotation is being done.
	 * @param angleDegrees - the angle (in Degrees) the shape should be rotated by.
	 */

	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		int n = arrayListOfPoints.size();
		if (n > 2) {
			for (int i = 0; i < n; i++) {
				Point_2D current = arrayListOfPoints.get(i);
				current.rotate(center, angleDegrees);
			}
		}
	}
}

