package com.optimism.wrt.game.wormhole.systems;

import com.artemis.*;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.Gdx;
import com.optimism.wrt.engine.*;
import com.optimism.wrt.engine.components.*;
import com.optimism.wrt.engine.math.*;
import com.optimism.wrt.game.wormhole.components.*;
import com.optimism.wrt.game.wormhole.factory.*;


public class WeaponSystem extends EntityProcessingSystem {

	@Mapper ComponentMapper<Weapon> wm;
	@Mapper ComponentMapper<Orientation> om;
	@Mapper ComponentMapper<Controllable> cm;
	
	
	@SuppressWarnings("unchecked")
	public WeaponSystem() {
		super(Aspect.getAspectForAll(Rect.class, Orientation.class, Weapon.class));
	}
	
	@Override
	public void process(Entity entity) {
		Weapon wep = wm.get(entity);
		wep.reload(world.delta);
		if (wep.ready()) {
			if (!cm.has(entity) || Settings.autoFire || Gdx.input.isKeyPressed(Controls.fireWeapons)) {
				// If not a player, or auto-fire is on, or the fire button is pressed:
				fireWeapon(entity, wep);
			}
		}
	}
	
	protected void fireWeapon(Entity entity, Weapon wep) {
		double angle = om.get(entity).angle;
		Vec velocity = new Vec(Settings.bulletSpeed, 0).rotate(angle);
		Entity bullet = Bullets.playerBullet(world, entity, velocity);
		bullet.addToWorld();
		wep.fired();
	}
}
