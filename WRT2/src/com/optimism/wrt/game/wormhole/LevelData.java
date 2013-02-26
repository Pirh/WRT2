package com.optimism.wrt.game.wormhole;

import com.artemis.Entity;


public class LevelData {

	public long score = 0;
	public int lives = 10;
	
	public Entity[] players;
	
	public double hurtTime = 0.0;
	
	
	public LevelData(Entity[] players) {
		this.players = players;
	}
	
	public void gainScore(long amount) {
		score += amount;
	}
	
}
