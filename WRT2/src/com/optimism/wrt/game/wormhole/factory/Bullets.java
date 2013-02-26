package com.optimism.wrt.game.wormhole.factory;

import com.artemis.*;
import com.optimism.wrt.engine.components.Rect;
import com.optimism.wrt.engine.math.*;
import com.optimism.wrt.game.wormhole.components.*;


public class Bullets {
	
	public static Entity playerBullet(World world, Entity firer, Vec velocity) {
		return createBullet(world, firer, new Vec(2.5,2.5), "bullet-player.png", 1.25, velocity, 1);
	}
	
	public static Entity createBullet(World world, Entity firer, Vec size, String image, double radius,
			Vec velocity, int damage) {
		Vec position = firer.getComponent(Rect.class).position();
		Entity bullet = Factory.createMovingThing(world, position, size, image, velocity);
		bullet.addComponent(new Body(new Circle(radius)));
		bullet.addComponent(new Damage(damage));
		Team team = firer.getComponent(Team.class);
		if (team != null) {
			bullet.addComponent(team);
		}
		return bullet;
	}

}
