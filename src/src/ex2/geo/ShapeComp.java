/**
 * Name :Ron Amsalem
 * ID : 326029600
 */


/**
 * ln this class there is the sorting of shapes by area, anti-area, perimeter, anti-perimeter,string, anti string.
 */

package src.ex2.geo;

import java.util.Comparator;

import ex2.ex2.Ex2_Const;
import ex2.gui.GUI_Shape;

/**
 * This class represents a Comparator over GUI_Shapes - 
 * as a linear order over GUI_Shapes.
 * Ex2: you should implement this class!
 * @author I2CS

 */

/**
 * This class is used to sort shapes by area, perimeter, string and tag.
 */
public class ShapeComp implements Comparator<GUI_Shape>{

	public static final ShapeComp CompByArea = new ShapeComp(Ex2_Const.Sort_By_Area);
	public static final ShapeComp CompByAntiArea = new ShapeComp(Ex2_Const.Sort_By_Anti_Area);
	public static final ShapeComp CompByAntiToString = new ShapeComp(Ex2_Const.Sort_By_toString);
	public static final ShapeComp CompByToString = new ShapeComp(Ex2_Const.Sort_By_Anti_toString);
	public static final ShapeComp CompByPerimeter = new ShapeComp(Ex2_Const.Sort_By_Perimeter);
	public static final ShapeComp CompByAntiPerimeter = new ShapeComp(Ex2_Const.Sort_By_Anti_Perimeter);
	public static final ShapeComp CompSortByTag = new ShapeComp(Ex2_Const.Sort_By_Tag);
	public static final ShapeComp SortByAntiTag = new ShapeComp(Ex2_Const.Sort_By_Anti_Tag);

	private int _flag;
	public ShapeComp(int flag) {
		_flag = flag;
	}

	/**
	 * Make sure you implement the basic code below
	 * @param o1 the first object to be compared.
	 * @param o2 the second object to be compared.
	 * @return 1 iff o1 is grater than o1, -1 iff o1 is smaller than o2,
	 * and 0 iff o1 and o2 are equals.
	 */

	@Override
	public int compare(GUI_Shape o1, GUI_Shape o2) {
		double a1=-1, a2 = -1;
		GeoShape s1 = o1.getShape(), s2 = o2.getShape();
		int ans =0;

		/*
		sort by area --->  the sorting based on area prioritizes objects based on their area values. Objects with larger area values appear earlier in the sorted array.
		 */
		if(_flag == Ex2_Const.Sort_By_Area) {
			a1 = s1.area();
			a2 = s2.area();
			if(a1>a2) {ans=1;}
			if(a1<a2) {ans=-1;}
		}
		/*
		sort by anti area --->  the sorting based on anti-area prioritizes objects based on their area values in reverse order. Objects with larger area values appear earlier in the sorted array.
		 */
		if(_flag == Ex2_Const.Sort_By_Anti_Area) {
			double areaO1=o1.getShape().area();
			double areaO2=o2.getShape().area();
			if(areaO1<areaO2)
				ans=1;
			if(areaO2<areaO1)
				ans=-1;
		}

		/*
		sort by  to string ---> the sorting based on string representation orders the objects based on their string representations in lexicographical order.
		 */
		if(_flag == Ex2_Const.Sort_By_toString) {
			ans = o1.toString().compareTo(o2.toString());
		}
		/*
	   	sort by anti to string --->the sorting based on anti-string representation reverses the order of the comparison of string representations, ensuring objects with "greater" string representations appear earlier in the sorted array.
		 */
		if(_flag == Ex2_Const.Sort_By_Anti_toString) {
			ans = -(o1.toString().compareTo(o2.toString()));
		}
		/*
		 * sort by perimeter--->the sorting based on perimeter prioritizes objects with smaller perimeters, ensuring they appear earlier in the sorted array.
		 */
		if(_flag == Ex2_Const.Sort_By_Perimeter) {
			double perO1=o1.getShape().perimeter();
			double perO2=o2.getShape().perimeter();
			if(perO1<perO2)
				ans=-1;
			if(perO2<perO1)
				ans=1;
		}
		/*
		 * sort by anti perimeter --->the extent-based sort gives priority to objects with larger extents, ensuring that they appear earlier in the sorted array.
		 */
		if(_flag == Ex2_Const.Sort_By_Anti_Perimeter) {
			double perO1=o1.getShape().perimeter();
			double perO2=o2.getShape().perimeter();
			if(perO1<perO2)
				ans=1;
			if(perO2<perO1)
				ans=-1;
		}
		/*
		sort by tag ---> the sorting based on tag prioritizes objects based on their tag values. Objects with lower tag values appear earlier in the sorted array.
		 */
		if(_flag == Ex2_Const.Sort_By_Tag) {
			if(o1.getTag()<o2.getTag())
				ans=-1;
			else
				ans=1;
		}
		/*
		sort by anti tag ---> the sorting based on anti-tag prioritizes objects based on their tag values in reverse order. Objects with higher tag values appear earlier in the sorted array.
		 */
		if(_flag == Ex2_Const.Sort_By_Anti_Tag) {
			if(o1.getTag()<o2.getTag())
				ans=1;
			else
				ans=-1;
		}

		return ans;
	}
}
