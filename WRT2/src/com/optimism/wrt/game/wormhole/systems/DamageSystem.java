package com.optimism.wrt.game.wormhole.systems;

import com.artemis.*;
import com.artemis.annotations.Mapper;
import com.artemis.systems.VoidEntitySystem;
import com.optimism.wrt.game.wormhole.LevelData;
import com.optimism.wrt.game.wormhole.collision.*;
import com.optimism.wrt.game.wormhole.components.*;


public class DamageSystem extends VoidEntitySystem {

	@Mapper ComponentMapper<Health> hm;
	@Mapper ComponentMapper<Damage> dm;
	@Mapper ComponentMapper<Team> tm;
	
	private CollideList collideList;
	private LevelData levelData;
	
	
	public DamageSystem(CollideList collideList, LevelData levelData) {
		this.collideList = collideList;
		this.levelData = levelData;
	}
	
	@Override
	protected void processSystem() {
		for (Collision coll: collideList.collisions) {
			collide(coll.first, coll.second, true);
		}
	}
	
	protected void collide(Entity first, Entity second, boolean recurse) {
		
		Health health = hm.getSafe(first);
		Damage damage = dm.getSafe(second);
		
		if (health != null && damage != null) {
			health.lose(damage.damage);
			if (health.dead()) {
				// Give the player score if the damager was them:
				Team team = tm.getSafe(second);
				if (team == Team.TEAM1) {
					levelData.gainScore(health.score);
				}
				first.deleteFromWorld();
			}
			// Delete the attacker if appropriate
			if (damage.onceOnly) {
				second.deleteFromWorld();
			}
			
			// Return instead of testing the same collision the other way
			return;
		}
		
		if (recurse) {
			collide(second, first, false);
		}
	}

}
