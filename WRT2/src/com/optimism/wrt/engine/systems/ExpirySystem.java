package com.optimism.wrt.engine.systems;

import com.artemis.*;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.optimism.wrt.engine.components.Lifespan;


public class ExpirySystem extends EntityProcessingSystem {
	
	@Mapper ComponentMapper<Lifespan> lm;
	
	
	@SuppressWarnings("unchecked")
	public ExpirySystem() {
		super(Aspect.getAspectForAll(Lifespan.class));
	}

	@Override
	protected void process(Entity entity) {
		Lifespan span = lm.get(entity);
		span.time -= world.delta;
		if (span.time <= 0) {
			entity.deleteFromWorld();
		}
	}

}
