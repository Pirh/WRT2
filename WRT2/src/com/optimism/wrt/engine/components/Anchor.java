package com.optimism.wrt.engine.components;

import com.optimism.wrt.engine.math.Vec;


/*
 * Defines an anchor point for a Rect.
 */
public class Anchor {
	
	public static final Anchor TOPLEFT = new Anchor(new Vec(0.0, 1.0));
	public static final Anchor TOP = new Anchor(new Vec(0.5, 1.0));
	public static final Anchor TOPRIGHT = new Anchor(new Vec(1.0, 1.0));
	public static final Anchor LEFT = new Anchor(new Vec(0.0, 0.5));
	public static final Anchor CENTRE = new Anchor(new Vec(0.5, 0.5));
	public static final Anchor RIGHT = new Anchor(new Vec(1.0, 0.5));
	public static final Anchor LOWLEFT = new Anchor(Vec.zero);
	public static final Anchor LOW = new Anchor(new Vec(0.5, 0.0));
	public static final Anchor LOWRIGHT = new Anchor(new Vec(1.0, 0.0));
	
	
	public Vec point;
	
	public Anchor(Vec point) {
		this.point = point;
	}

}
