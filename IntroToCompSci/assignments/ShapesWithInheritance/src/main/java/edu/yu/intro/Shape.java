package edu.yu.intro;

/** " Shapes With Inheritance " Assignment #11
*
* @author Tom Bohbot
*/

public abstract class Shape {
	
	public abstract double area (); {
	}

	public abstract double perimeter (); {
	}
}

class Circle extends Shape {
	private double radius;
	private double pi = 3.14;

	public Circle (double radius) {
		this.radius = radius;
	}
	@Override
	public double area () {
		double area = pi * radius * radius;
		return area;
	}
	@Override
	public double perimeter () {
		double perimeter = 2 * pi * radius;
		return perimeter;
	}

}

class Rectangle extends Shape {
	private double width;
	private double height;

	public Rectangle (double width , double height) {
		this.width = width;
		this.height = height;
	}
	@Override
	public double area () {
		double area = width * height;
		return area;
	}
	@Override
	public double perimeter () {
		double perimeter = (width * 2) + (height * 2);
		return perimeter;
	}
}

class Triangle extends Shape {
	private double s1;
	private double s2;
	private double s3;
	private double perimeter;

	public Triangle (double s1, double s2, double s3) {
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
	}
	@Override
	public double perimeter () {
		double perimeter = (s1 + s2 + s3)/2;
		return perimeter;
	}
	@Override
	public double area () {
		double p = perimeter();
		// double p = perimeter;
		double area = Math.sqrt(p*(p-s1)*(p-s2)*(p-s3) );
		return area;
	}
}