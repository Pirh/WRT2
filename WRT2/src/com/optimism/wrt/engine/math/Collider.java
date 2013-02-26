package com.optimism.wrt.engine.math;

import com.optimism.wrt.game.wormhole.components.Body;


public class Collider {

	public static boolean collide(Body bodyA, Vec posA, Body bodyB, Vec posB) {
		double dispSq = posA.sub(posB).lengthSq();
		double radSq = (bodyA.circle.radius + bodyB.circle.radius) * (bodyA.circle.radius + bodyB.circle.radius);
		return (dispSq <= radSq);
	}
	
}
