package com.optimism.wrt.game.wormhole.systems;

import com.artemis.systems.VoidEntitySystem;
import com.badlogic.gdx.Gdx;
import com.optimism.wrt.engine.*;
import com.optimism.wrt.game.wormhole.OrbitController;


public class OrbitControlSystem extends VoidEntitySystem {

	private OrbitController controller;
	
	public OrbitControlSystem(OrbitController controller) {
		this.controller = controller;
	}
	
	@Override
	public void processSystem() {
		double acc = 0;
		if (Gdx.input.isKeyPressed(Controls.moveLeft)) {
			acc = world.delta * Settings.direction;
		} else if (Gdx.input.isKeyPressed(Controls.moveRight)) {
			acc = -world.delta * Settings.direction;
		}
		controller.accelerate(acc);
		controller.decelerate(world.delta);
	}

}
