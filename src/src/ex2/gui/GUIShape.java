package src.ex2.gui;
/**
 * This class implements the GUI_shape.
 * Ex2: you should implement this class!
 * @author I2CS
 */
import ex2.geo.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;


public class GUIShape implements GUI_Shape{
	private GeoShape _g = null;
	private boolean _fill;
	private Color _color;
	private int _tag;
	private boolean _isSelected;
	
	public GUIShape(GeoShape g, boolean f, Color c, int t) {
		_g = null;
		if (g!=null) {_g = g.copy();}
		_fill= f;
		_color = c;
		_tag = t;
		_isSelected = false;
	}
	public GUIShape(GUIShape ot) {
		this(ot._g, ot._fill, ot._color, ot._tag);

	}

	/**
	 * A function we received from the lecturer Boaz.
	 * @param c ---> color.
	 * @return ---> number of color.
	 */
	public static int colorEncoding(Color c) {
		int r = c.getRed();
		int b = c.getBlue();
		int g = c.getGreen();
		int ce = r*256*256 + g*256 + b;
		return ce;
	}

	/**
	 * This `GUIShape` constructor is designed to parse a string `s` representing geometric shapes in a specific format and initialize a `GUIShape` object accordingly.
	 * @param s --->A string representing a shape.
	 * parts --->Creating an array of strings, so that anywhere in the array enters a data representing a feature of a shape , as is known, the given string separates the data with commas, so we will use split.
	 * The first 5 places will be the general information about the shape:
	   (1) color ---> contains the color information, which is decoded into a `Color` object using the `Color.decode()` method.
	   (2) isFill ---> represents a boolean value indicating whether the shape should be filled or not. This value is parsed into a `Boolean` object using `Boolean.parseBoolean()`.
	   (3) tag ---> represents a numerical tag associated with the shape. It's parsed into an integer using `Integer.parseInt()`.
	   (4) shape ---> represents the type of geometric shape. Depending on the type, the constructor initializes the appropriate shape object (`Circle_2D`, `Rect_2D`, `Triangle_2D`, `Segment_2D`, or `Polygon_2D`).
	 *After that we will examine what form it is and according to its data we will determine the rest of the places in the array.
	   (1) For a circle we will create a center point and a radius value and define the appropriate data.
	   (2) For a rect we will create 4 points, and enter the appropriate data.
	   (3) For a triangle we will create 3 points, and enter the appropriate data.
	   (4) For a segment we will create 2 points, and enter the appropriate data.
	   (5)For a polygon, we don't know how many points there are, so it will change according to what we draw. The strategy is to subtract 5 from the length of the dynamic array because it is the places of what I mentioned above and divide by 2 because each point has an x rate and a y rate.
	      and then initialize the data fields with the appropriate data.
	 */
	public GUIShape(String s) {
		String[] parts = s.split(",");
		Color color = Color.decode(parts[1]);
		Boolean isFill = Boolean.parseBoolean(parts[2]);
		Integer tag = Integer.parseInt(parts[3]);
		String shape = parts[4];
		if (shape.equals("Circle_2D")) {
			Double x = Double.parseDouble(parts[5]);
			Double y = Double.parseDouble(parts[6]);
			Point_2D point = new Point_2D(x, y);
			Double radius = Double.parseDouble(parts[7]);
			this._g = new Circle_2D(point, radius);
			this._color = color;
			this._fill = isFill;
			this._tag = tag;
		}
		if (shape.equals("Rect_2D")) {
			Double p1_x = Double.parseDouble(parts[5]);
			Double p1_y = Double.parseDouble(parts[6]);
			Double p2_x = Double.parseDouble(parts[7]);
			Double p2_y = Double.parseDouble(parts[8]);
			Double p3_x = Double.parseDouble(parts[9]);
			Double p3_y = Double.parseDouble(parts[10]);
			Double p4_x = Double.parseDouble(parts[11]);
			Double p4_y = Double.parseDouble(parts[12]);
			Point_2D p1 = new Point_2D(p1_x, p1_y);
			Point_2D p2 = new Point_2D(p2_x, p2_y);
			Point_2D p3 = new Point_2D(p3_x, p3_y);
			Point_2D p4 = new Point_2D(p4_x, p4_y);
			this._g = new Rect_2D(p1,p2,p3,p4);
			this._color = color;
			this._fill = isFill;
			this._tag = tag;
		}
		if (shape.equals("Triangle_2D")) {
			Double p1_x = Double.parseDouble(parts[5]);
			Double p1_y = Double.parseDouble(parts[6]);
			Double p2_x = Double.parseDouble(parts[7]);
			Double p2_y = Double.parseDouble(parts[8]);
			Double p3_x = Double.parseDouble(parts[9]);
			Double p3_y = Double.parseDouble(parts[10]);
			Point_2D p1 = new Point_2D(p1_x, p1_y);
			Point_2D p2 = new Point_2D(p2_x, p2_y);
			Point_2D p3 = new Point_2D(p3_x, p3_y);
			this._g = new Triangle_2D(p1, p2, p3);
			this._color = color;
			this._fill = isFill;
			this._tag = tag;
		}
		if (shape.equals("Segment_2D")) {
			Double p1_x = Double.parseDouble(parts[5]);
			Double p1_y = Double.parseDouble(parts[6]);
			Double p2_x = Double.parseDouble(parts[7]);
			Double p2_y = Double.parseDouble(parts[8]);
			Point_2D p1 = new Point_2D(p1_x, p1_y);
			Point_2D p2 = new Point_2D(p2_x, p2_y);
			this._g = new Segment_2D(p1, p2);
			this._color = color;
			this._fill = isFill;
			this._tag = tag;
		}
		if (shape.equals("Polygon_2D")) {
			ArrayList<Point_2D> arrayListOfPoints = new ArrayList<>();
			int n = (parts.length -5)/2;
			int j = 5;
			for (int i = 0; i <n ; i++) {
				Double x = Double.parseDouble(parts[j]);
				Double y = Double.parseDouble(parts[j+1]);
				arrayListOfPoints.add(new Point_2D(x, y));;
				j=j+2;

			}
			this._g = new Polygon_2D(arrayListOfPoints);
			this._color = color;
			this._fill = isFill;
			this._tag = tag;


		}
	}

	@Override
	public GeoShape getShape() {
		return _g;
	}

	@Override
	public void setShape(GeoShape g) {
		_g = g;
	}

	@Override
	public boolean isFilled() {
		return _fill;
	}

	@Override
	public void setFilled(boolean filled) {
		_fill = filled;
	}

	@Override
	public Color getColor() {
		return _color;
	}

	@Override
	public void setColor(Color cl) {
		_color = cl;
	}

	@Override
	public int getTag() {
		return _tag;
	}

	@Override
	public void setTag(int tag) {
		_tag = tag;
		
	}

	@Override
	public GUI_Shape copy() {
		return new GUIShape(this);
	}

	@Override
	public String toString() {
		String ans = ""+this.getClass().getSimpleName()+","+colorEncoding(_color)+","+_fill+","+_tag+","+this._g.getClass().getSimpleName()+","+_g.toString();
		return ans;
	}

	@Override
	public boolean isSelected() {
		return this._isSelected;
	}
	@Override
	public void setSelected(boolean s) {
		this._isSelected = s;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GUIShape shape = (GUIShape) o;
		return _fill == shape._fill && _tag == shape._tag && _isSelected == shape._isSelected && Objects.equals(_g, shape._g) && Objects.equals(_color, shape._color);
	}

}
