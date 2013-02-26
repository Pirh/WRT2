package com.optimism.wrt.engine.tools;

import java.util.Random;

import com.optimism.wrt.engine.math.Vec;


public class Tools {
	
	public static Random random = new Random();
	
	public static double clamp(double min, double value, double max) {
		return Math.max(min, Math.min(value, max));
	}
	
	public static double rangle() {
		return random.nextFloat()*360;
	}
	
	public static Vec randomVec(double maxSize) {
		return new Vec(random.nextFloat()*maxSize,0).rotate(Tools.rangle());
	}

}
