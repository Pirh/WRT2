package com.optimism.wrt.engine.systems;

import com.artemis.*;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.optimism.wrt.engine.components.*;
import com.optimism.wrt.engine.math.Vec;


/*
 * In an effort to be more modular, this system no longer handles removal of offscreen entities.
 * Another system will take care of that.
 */
public class MovementSystem extends EntityProcessingSystem {
	
	@Mapper ComponentMapper<Rect> rm;
	@Mapper ComponentMapper<Velocity> vm;
	
	@SuppressWarnings("unchecked")
	public MovementSystem() {
		super(Aspect.getAspectForAll(Rect.class, Velocity.class));
	}
	
	@Override
	public void process(Entity entity) {
		Rect rect = rm.get(entity);
		Vec vel = vm.get(entity).velocity;
		rect.lowleft = rect.lowleft.add(vel.mul(world.delta));
	}

}
