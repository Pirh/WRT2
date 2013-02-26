package com.optimism.wrt.game.wormhole;

import com.optimism.wrt.engine.Settings;



public class LevelData {
	
	public long score = 0;
	public int lives = 10;
	public int level = 0;
	
	public double hurtTime = 0.0;
	
	
	public void gainScore(long amount) {
		score += amount;
	}
	
	public void levelUp() {
		level += 1;
		lives = 10;
	}
	
	public void damagePlanet() {
		lives -= 1;
		hurtTime = Settings.orbitFlashTime;
	}
}
