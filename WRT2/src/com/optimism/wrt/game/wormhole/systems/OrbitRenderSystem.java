package com.optimism.wrt.game.wormhole.systems;

import com.artemis.systems.VoidEntitySystem;
import com.badlogic.gdx.graphics.glutils.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.optimism.wrt.engine.Settings;
import com.optimism.wrt.engine.graphics.Projector;


public class OrbitRenderSystem extends VoidEntitySystem {
	
	private ShapeRenderer renderer;
	
	
	public OrbitRenderSystem() {
		renderer = new ShapeRenderer();
	}
	
	@Override
	public void processSystem() {
		renderer.setProjectionMatrix(Projector.projection);
		renderer.begin(ShapeType.Circle);
		renderer.setColor(Settings.orbitColour);
		renderer.circle(0, 0, Settings.orbitRadius, Settings.orbitSharpness);
		renderer.end();
	}

}
