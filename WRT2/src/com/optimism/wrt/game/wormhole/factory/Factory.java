package com.optimism.wrt.game.wormhole.factory;

import com.artemis.*;
import com.optimism.wrt.engine.components.*;
import com.optimism.wrt.engine.graphics.Imager;
import com.optimism.wrt.engine.math.*;
import com.optimism.wrt.game.wormhole.components.*;

public class Factory {

	
	public static Entity createThing(World world, Vec position, Vec size, String image) {
		Entity thing = world.createEntity();
		thing.addComponent(new Rect(position, size, Anchor.CENTRE));
		thing.addComponent(Imager.load("images/"+image));
		return thing;
	}
	
	public static Entity createMovingThing(World world, Vec position, Vec size, String image, Vec velocity) {
		Entity thing = createThing(world,position,size,image);
		thing.addComponent(new Velocity(velocity));
		thing.addComponent(new Orientation(velocity.angle()));
		return thing;
	}
	
	public static Entity wormhole(World world) {
		Entity wormhole = createThing(world, Vec.zero, new Vec(35,35), "wormhole.png");
		wormhole.addComponent(new Orientation(0,-8));
		wormhole.addComponent(new Body(new Circle(2)));
		wormhole.addComponent(Team.TEAM0);
		wormhole.addComponent(new Health(1<<30, 1L<<62));
		wormhole.addToWorld();
		return wormhole;
	}
	
}
