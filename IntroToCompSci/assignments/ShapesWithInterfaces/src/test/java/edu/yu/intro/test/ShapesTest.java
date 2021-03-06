package edu.yu.intro.test;

/** " Shapes Test " Assignment #12
*
* @author Tom Bohbot
*/

import edu.yu.intro.Shapes;
import edu.yu.intro.Shape;
import edu.yu.intro.Polygon;
import edu.yu.intro.Circle;
import edu.yu.intro.Rectangle;
import edu.yu.intro.Triangle;
import org.junit.*;
import static org.junit.Assert.*;

public class ShapesTest {

	Shapes shapesInstance = new Shapes();

	@Test
	public void CheckCircleMethod () {
		Shape circle = shapesInstance.newCircle(5);
		assertEquals ("testing area of circle." , 78.5 , circle.area() , 0.1 );
		assertEquals ("testing perimeter of circle." , 31.4 , circle.perimeter() , 0.1 );
	}
	@Test (expected = IllegalArgumentException.class)
	public void negativeInputCircle () {
		Shape circle = shapesInstance.newCircle(-5);
	}
	@Test (expected = IllegalArgumentException.class)
	public void nonPositiveInputCircle () {
		Shape circle = shapesInstance.newCircle(0);
	}

	@Test
	public void CheckRectangleMethod () {
		Shape rectangle = shapesInstance.newRectangle(2 , 2);
		Rectangle rectangleNSides = (Rectangle) rectangle;
		assertEquals ("testing area of rectangle." , 4.0 , rectangle.area() , 0 );
		assertEquals ("testing perimeter of rectangle." , 8.0 , rectangle.perimeter() , 0 );
		assertEquals ("testing n of sides of rectangle." , 4 , rectangleNSides.nSides() );
	}
	@Test (expected = IllegalArgumentException.class)
	public void negativeInputRectangle () {
		Shape rectangle = shapesInstance.newRectangle(2 , -2);
	}
	@Test (expected = IllegalArgumentException.class)
	public void nonPositiveInputRectangle () {
		Shape rectangle = shapesInstance.newRectangle(0 , 2);
	}

	@Test
	public void CheckTriangleMethod () {
		Shape triangle = shapesInstance.newTriangle(18 , 30 , 24);
		Triangle triangleNSides = (Triangle) triangle;
		assertEquals ("testing area of triangle." , 216.0 , triangle.area() , 0 );
		assertEquals ("testing perimeter of triangle." , 72.0 , triangle.perimeter() , 0 );
		assertEquals ("testing n of sides of triangle." , 3 , triangleNSides.nSides() );
	}
	@Test (expected = IllegalArgumentException.class)
	public void negativeInputTriangle () {
		Shape triangle = shapesInstance.newTriangle(18 , -30 , 24);
	}
	@Test (expected = IllegalArgumentException.class)
	public void nonPositiveInputTriangle () {
		Shape triangle = shapesInstance.newTriangle(18 , 30 , 0);
	}
}