package com.optimism.wrt.engine.math;

/*
 * An immutable vector class. You don't need to worry about copying it now!
 */
public class Vec {
	
	public static final Vec zero = new Vec(0,0);
	
	
	public final double x;
	public final double y;
	
	public Vec(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Vec add(Vec other) {
		return new Vec(this.x + other.x, this.y + other.y);
	}
	
	public Vec sub(Vec other) {
		return new Vec(this.x - other.x, this.y - other.y);
	}
	
	public Vec mul(Vec other) {
		return new Vec(this.x * other.x, this.y * other.y);
	}
	
	public Vec mul(double scalar) {
		return new Vec(this.x * scalar, this.y * scalar);
	}
	
	public Vec neg() {
		return new Vec(-this.x, -this.y);
	}
	
	public double dot(Vec other) {
		return (this.x * other.x) + (this.y * other.y);
	}
	
	public Vec ortho() {
		return new Vec(-this.y, x);
	}
	
	public double lengthSq() {
		return this.dot(this);
	}
	
	public double length() {
		return Math.sqrt(this.lengthSq());
	}
	
	public Vec norm() {
		double len = this.length();
		return (len > 0) ? this.mul(1.0/len) : this;
	}
	
	public double angle() {
		return Math.toDegrees(Math.acos( this.x / this.length() ) * Math.signum(this.y));
	}
	
	public Vec rotate(double theta) {
		double sint = Math.sin(Math.toRadians(theta));
		double cost = Math.cos(Math.toRadians(theta));
		return new Vec(
				x * cost - y * sint,
				x * sint + y * cost);
	}
	
	public String toString() {
		return String.format("(%.3f, %.3f)", x, y);
	}

}
