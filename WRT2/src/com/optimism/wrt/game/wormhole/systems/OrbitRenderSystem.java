package com.optimism.wrt.game.wormhole.systems;

import com.artemis.systems.VoidEntitySystem;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.optimism.wrt.engine.Settings;
import com.optimism.wrt.engine.graphics.Projector;
import com.optimism.wrt.game.wormhole.LevelData;


public class OrbitRenderSystem extends VoidEntitySystem {
	
	private ShapeRenderer renderer;
	private LevelData levelData;
	
	
	public OrbitRenderSystem(LevelData levelData) {
		renderer = new ShapeRenderer();
		this.levelData = levelData;
	}
	
	@Override
	public void processSystem() {
		renderer.setProjectionMatrix(Projector.projection);
		renderer.begin(ShapeType.Circle);
		Color col = Settings.orbitColour;
		double hurt = levelData.hurtTime;
		if (hurt > 0) {
			float decolour = 1 - (float) (hurt/Settings.orbitFlashTime);
			col = new Color(1.0f, decolour, decolour, 1.0f);
			levelData.hurtTime -= world.delta;
		}
		renderer.setColor(col);
		renderer.circle(0, 0, Settings.orbitRadius, Settings.orbitSharpness);
		renderer.end();
	}

}
