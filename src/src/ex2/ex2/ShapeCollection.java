/**
 * Name ---> Ron amsalem
 * ID ---> 326029600
 */
package src.ex2.ex2;
import ex2.gui.GUIShape;
import ex2.gui.GUI_Shape;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

/**
 * This class represents a collection of GUI_Shape.
 * Ex2: you should implement this class!
 * @author I2CS
 *
 */

public class ShapeCollection implements GUI_Shape_Collection {
	private ArrayList <GUI_Shape> _shapes;
	
	public ShapeCollection() {
		_shapes = new ArrayList<GUI_Shape>();
	}
	@Override
	public GUI_Shape get(int i) {
		return _shapes.get(i);
	}

	@Override
	public int size() {
		return _shapes.size();
	}

	/**
	 *  this method provides a way to remove a `GUI_Shape` object at a specific index from the list of shapes (`_shapes`).
	 * @param i - the index of the element to be removed.
	 * @return --- > the removed element as a `GUI_Shape` object.
	 */
	@Override
	public GUI_Shape removeElementAt(int i) {
		return _shapes.remove(i);
	}

	/**
	 *  This method provides a way to add a `GUI_Shape` object at a specific index in the list of shapes (`_shapes`).
	 * @param s - the gui_shape
	 * @param i - the location (index) in which s should be added
	 */
	@Override
	public void addAt(GUI_Shape s, int i) {
		_shapes.add(i, s);
	}

	/**
	 * This `add(GUI_Shape s)` method is overridden in a class that implements the `GUI_Shape_Collection` interface. It is used to add a `GUI_Shape` object to the collection.
	 * @param s - the gui_shape
	 */
	@Override
	public void add(GUI_Shape s) {
		if(s!=null && s.getShape()!=null) {
			_shapes.add(s);
		}
	}

	/**
	 *This method creates a new instance of the `GUI_Shape_Collection` application.
	 * It then iterates over each shape in the original collection, calling the `copy()` method on each shape to get a deep copy.
	 * These copied shapes are added to the new collection. Finally, the method returns the new collection, which contains deep copies of all shapes from the original collection.
	 * Creates a deep copy of this GUI_Shape_Collection.
	 * Each shape in the collection is also copied, resulting in a new collection
	 * with identical shapes but independent of the original collection.
	 * @return a deep copy of this GUI_Shape_Collection.
	 */

	@Override
	public GUI_Shape_Collection copy() {
		GUI_Shape_Collection copy =new ShapeCollection();
		for(int i=0;i<_shapes.size();i++) {
			 copy.add(new GUIShape(_shapes.get(i).toString()));
		}
		return copy;
	}

	/**
	 * This method sorts the list of shapes (`_shapes`) based on the definition of the ArrayList by the specified comparator (`comp`).
	 * @param comp a linear order over gui_shape as defined in java.util.Comparator
	 */
	@Override
	public void sort(Comparator<GUI_Shape> comp) {
		_shapes.sort(comp);
	}

	/**
	 * This method removes all shapes from the list `_shapes`.
	 * After calling this method, the list will be empty.
	 */
	@Override
	public void removeAll() {
		_shapes.clear();
	}

	/**
	 * This method `save ()` is responsible for saving data to a file
	   That is, this method tries to create a file, write data to it if it was successfully created, and handles any `IOException' that may occur during these operations by printing an error message.
	 * For each shape, we will invoke the `toString()` method of the `GUI_Shape` object to get a string representation of the shape. This string representation typically contains all the necessary information about the shape (eg, color, dimensions) in a format suitable for storage.
	 * After writing the string representation of the shape to the file, `writer.newLine()` is called to add a new character, making sure to write each shape on a separate line in the file.
	 * writer --->is created to write data to the file specified in the `file` parameter.
	 * @param file - the file name in which this collection will be saved.
	 */
	@Override
	public void save(String file) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			for (GUI_Shape shape : _shapes) {
				writer.write(shape.toString());
				writer.newLine();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This `load(String file)` method is designed to load shape data from a text file specified by the `file` parameter.
	 * Before loading shapes from the file, the method cleans the `_shapes` collection to remove existing shapes.
	 * While the line is not empty, we will use the GUIShape(line) constructor and basically transfer the string that is in the line to the shape.
	 * @param file - the name of the text file to create a gui shape file from.
	 */
	@Override
	public void load(String file) {
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			_shapes.clear();
			String line;
			while ((line = reader.readLine()) != null) {
				_shapes.add(new GUIShape(line));
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method it is used to generate a string representation of the object.
	 * Returns a string representation of this list.
	 *  Concatenates the string representation of each element in the list
	 *  in the order they appear in the list.
	 *
	 * @return a string representation of this list.
	 *
	 */
	@Override
	public String toString() {
		String ans = "";
		for(int i=0;i<size();i=i+1) {
			ans += this.get(i);
		}
		return ans;
	}

	/**
	 * Indicates whether some other object is "equal to" this one.
	 * Two ShapeCollection objects are considered equal if they both contain
	 * the same shapes in the same order.
	 * @param o --->  the reference object with which to compare.
	 * @return ---> true if this ShapeCollection is the same as the object.
	 */

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ShapeCollection that = (ShapeCollection) o;
		return Objects.equals(_shapes, that._shapes);
	}

	}