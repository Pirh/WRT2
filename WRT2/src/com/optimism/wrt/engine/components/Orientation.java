package com.optimism.wrt.engine.components;

import com.artemis.Component;


public class Orientation extends Component {
	
	public double angle;
	public double angularVelocity;
	
	
	public Orientation(double angle, double angularVelocity) {
		this.angle = angle;
		this.angularVelocity = angularVelocity;
	}
	
	public Orientation(double angle) {
		this(angle, 0.0);
	}

}
