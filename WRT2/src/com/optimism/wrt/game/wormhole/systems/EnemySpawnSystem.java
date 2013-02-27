package com.optimism.wrt.game.wormhole.systems;

import com.artemis.*;
import com.artemis.systems.IntervalEntitySystem;
import com.artemis.utils.ImmutableBag;
import com.optimism.wrt.engine.Settings;
import com.optimism.wrt.engine.math.Vec;
import com.optimism.wrt.engine.tools.Tools;
import com.optimism.wrt.game.wormhole.LevelData;
import com.optimism.wrt.game.wormhole.components.Health;
import com.optimism.wrt.game.wormhole.factory.ShipYard;


public class EnemySpawnSystem extends IntervalEntitySystem {

	private LevelData levelData;
	private double timeSinceSpawn = 0;

	
	@SuppressWarnings("unchecked")
	public EnemySpawnSystem(LevelData levelData) {
		super(Aspect.getAspectForAll(Health.class), Settings.spawnFrequency);
		this.levelData = levelData;
	}
	
	@Override
	protected void processEntities(ImmutableBag<Entity> entities) {
		double chance = spawnChance(entities.size());
		if (Tools.random.nextFloat() < chance || timeSinceSpawn > 2.5) {
			randomEnemy().addToWorld();
			timeSinceSpawn = 0;
		} else {
			timeSinceSpawn += 0.2;
		}
	}
	
	protected double spawnChance(int numberOfShips) {
		double baseChance = 0.5;
		double levelChance = (levelData.level+1 / 6.0) * 0.8;
		double densityChance = Tools.clamp(0.01, (20-numberOfShips)/20.0, 1.0);
		return (baseChance * levelChance * densityChance);
	}
	
	protected Entity randomEnemy() {
		Vec position = Tools.randomVec(15.0);
		Entity ship;
		switch (Tools.random.nextInt(2)) {
		case 1: ship = ShipYard.redShip(world, position); break;
		default: ship = ShipYard.blueShip(world, position); break;
		}
		return ship;
	}
	
}
