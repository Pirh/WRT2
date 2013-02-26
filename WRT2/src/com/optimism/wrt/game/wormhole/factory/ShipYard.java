package com.optimism.wrt.game.wormhole.factory;

import com.artemis.*;
import com.optimism.wrt.engine.Settings;
import com.optimism.wrt.engine.components.*;
import com.optimism.wrt.engine.math.*;
import com.optimism.wrt.game.wormhole.components.*;

public class ShipYard {
	
	public static Entity playerShip(World world, Vec position) {
		return createShip(world, position, new Vec(10,10), "ship-player.png", 3.0, Team.TEAM1, 1, 0, 0);
	}
	
	
	public static Entity createShip(World world, Vec position, Vec size, String image, double radius, Team team,
			int health, int damage, long score) {
		Entity ship = Factory.createThing(world, position, size, image);
		ship.addComponent(new Velocity(Vec.zero));
		ship.addComponent(new Orientation(0));
		ship.addComponent(Team.TEAM1);
		ship.addComponent(new Body(new Circle(radius)));
		ship.addComponent(new Health(health, score));
		if (damage >= 0) {
			ship.addComponent(new Damage(damage));
		}
		return ship;
	}
	
	public static Entity[] createPlayerShips(World world, int numShips, Entity wormhole) {
		Entity[] ships = new Entity[numShips];
		double angle = 360.0 / numShips;
		Vec stretch = new Vec(0, Settings.orbitRadius);
		for (int i=0; i<numShips; i++) {
			Entity ship = playerShip(world, stretch.rotate(i*angle));
			ship.addComponent(new LookAt(wormhole));
			ship.addComponent(new Weapon(Settings.firingRate));
			ship.addComponent(Controllable.FLAG);
			ship.addToWorld();
		}
		return ships;
	}

}
