package com.optimism.wrt.game.wormhole.systems;

import com.artemis.systems.VoidEntitySystem;
import com.optimism.wrt.game.wormhole.*;


public class UpgradeSystem extends VoidEntitySystem {

	private static final long[] levelMilestones = new long[] {
		150,
		750,
		2000,
		5000,
		10000,
		1L<<62
		};
	
	private LevelData levelData;
	private WormholeScene scene;
	
	
	public UpgradeSystem(LevelData levelData, WormholeScene scene) {
		this.levelData = levelData;
		this.scene = scene;
	}
	
	@Override
	protected void processSystem() {
		long nextLevel = levelMilestones[levelData.level];
		if (levelData.score >= nextLevel) {
			levelData.levelUp();
			scene.replacePlayers(world, levelData.level+2);
		}
	}

}
