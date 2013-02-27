package com.optimism.wrt.game.wormhole.systems;

import com.artemis.*;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.optimism.wrt.engine.Settings;
import com.optimism.wrt.engine.components.Rect;
import com.optimism.wrt.game.wormhole.*;
import com.optimism.wrt.game.wormhole.components.Team;


public class PlanetDamageSystem extends EntityProcessingSystem {
	
	@Mapper ComponentMapper<Team> tm;
	@Mapper ComponentMapper<Rect> rm;
	
	private LevelData levelData;
	private HUD hud;
	
	@SuppressWarnings("unchecked")
	public PlanetDamageSystem(LevelData levelData, HUD hud) {
		super(Aspect.getAspectForAll(Team.class, Rect.class));
		this.levelData = levelData;
		this.hud = hud;
	}
	
	@Override
	public void process(Entity entity) {
		Team team = tm.get(entity);
		if (team.teamNumber == 0) {
			// e.g. it's the enemy team
			Rect rect = rm.get(entity);
			if (rect.position().lengthSq() > Settings.orbitRadius*Settings.orbitRadius) {
				// e.g. it's outside the orbit
				levelData.damagePlanet();
				hud.refresh(levelData);
				entity.removeComponent(Team.class);
				entity.changedInWorld();
			}
		}
	}

}
