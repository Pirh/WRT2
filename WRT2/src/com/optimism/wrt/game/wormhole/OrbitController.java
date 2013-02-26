package com.optimism.wrt.game.wormhole;

import com.optimism.wrt.engine.Settings;

/*
 * Handles control information for the wormhole state.
 */
public class OrbitController {
	
	public double orbitVelocity = 0.0;
	
	public void accelerate(double amount) {
		orbitVelocity += amount * Settings.orbitAcceleration;
		double absVelocity = Math.abs(orbitVelocity);
		if (absVelocity > Settings.orbitMaxSpeed) {
			orbitVelocity *= (Settings.orbitMaxSpeed / absVelocity);
		}
	}
	
	public void decelerate(double amount) {
		double speedSign = Math.signum(orbitVelocity);
		orbitVelocity = Math.max(
				Math.abs(orbitVelocity) - (amount * Settings.orbitDeceleration), 0) * speedSign;
	}

}
