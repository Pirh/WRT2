package com.optimism.wrt.game.wormhole.debug;

import com.artemis.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.optimism.wrt.engine.components.Text;
import com.optimism.wrt.engine.scripting.ScriptAction;


public class CheckFPSScript extends ScriptAction {

	private double waitTime = 1;
	private double waitTimeLeft = waitTime;
	
	@Override
	public void initialize(World world, Entity self) {
		self.addComponent(new Text("FPS: 0", Color.GREEN, Text.SMALL));
		self.changedInWorld();
	}
	
	@Override
	public void run(World world, Entity self) {
		if (waitTimeLeft <= 0) {
			waitTimeLeft = waitTime;
			self.getComponent(Text.class).changeText("FPS: "+Gdx.graphics.getFramesPerSecond());
		}
		waitTimeLeft -= world.delta;
	}
	
}
