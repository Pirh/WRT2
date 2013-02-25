package com.optimism.wrt.engine.systems;

import com.artemis.*;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.optimism.wrt.engine.components.Orientation;


public class RotationSystem extends EntityProcessingSystem {
	
	@Mapper ComponentMapper<Orientation> om;

	
	@SuppressWarnings("unchecked")
	public RotationSystem() {
		super(Aspect.getAspectForAll(Orientation.class));
	}

	@Override
	protected void process(Entity entity) {
		Orientation ori = om.get(entity);
		ori.angle += ori.angularVelocity * world.delta;
	}

}
