package com.optimism.wrt.game.wormhole.debug;

import com.artemis.*;
import com.optimism.wrt.Debug;
import com.optimism.wrt.engine.components.*;
import com.optimism.wrt.engine.math.Vec;

public class DebugManager {

	private World world;
	private Entity fpsCount = null;
	
	public DebugManager(World world) {
		this.world = world;
		refresh();
	}
	
	public void refresh() {
		if (Debug.showFPS && fpsCount == null) {
			showCounter();
		} else if (!Debug.showFPS && fpsCount != null) {
			hideCounter();
		}
	}
	
	protected void showCounter() {
		fpsCount = world.createEntity();
		fpsCount.addComponent(new Rect(new Vec(-50,-40), Vec.zero));
		fpsCount.addComponent(new Script(new CheckFPSScript()));
		fpsCount.addToWorld();
	}
	
	protected void hideCounter() {
		this.fpsCount.deleteFromWorld();
		this.fpsCount = null;
	}
	
}
