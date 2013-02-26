package com.optimism.wrt.game.wormhole.scripts;

import com.artemis.*;
import com.optimism.wrt.engine.components.Velocity;
import com.optimism.wrt.engine.math.Vec;
import com.optimism.wrt.engine.scripting.ScriptAction;
import com.optimism.wrt.engine.tools.Tools;


/*
 * Initialize an entity with a random velocity direction.
 */
public class RandomDirectionScript extends ScriptAction {
	
	private double speed;
	
	public RandomDirectionScript(double speed) {
		this.speed = speed;
	}
	
	@Override
	public void initialize(World world, Entity self) {
		self.addComponent(new Velocity(new Vec(speed, 0).rotate(Tools.rangle())));
	}

}
