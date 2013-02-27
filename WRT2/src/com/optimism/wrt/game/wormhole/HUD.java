package com.optimism.wrt.game.wormhole;

import com.artemis.*;
import com.badlogic.gdx.graphics.Color;
import com.optimism.wrt.engine.components.*;
import com.optimism.wrt.engine.math.Vec;

public class HUD {

	public Entity scoreMeter;
	public Entity lifeMeter;
	
	public HUD(World world, LevelData levelData) {
		scoreMeter = newMeter(world, "Score: "+levelData.score, Color.YELLOW, new Vec(-50,45));
		lifeMeter = newMeter(world, "Lives: "+levelData.lives, Color.GREEN, new Vec(-50,42));
	}
	
	private Entity newMeter(World world, String label, Color color, Vec position) {
		Entity meter = world.createEntity();
		meter.addComponent(new Rect(position, Vec.zero));
		meter.addComponent(new Text(label, color, Text.NORMAL));
		meter.addToWorld();
		return meter;
	}
	
	public void refresh(LevelData levelData) {
		scoreMeter.getComponent(Text.class).changeText("Score: "+levelData.score);
		lifeMeter.getComponent(Text.class).changeText("Lives: "+levelData.lives);
	}
	
}
