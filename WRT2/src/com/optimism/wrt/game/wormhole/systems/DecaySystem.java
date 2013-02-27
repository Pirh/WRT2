package com.optimism.wrt.game.wormhole.systems;

import com.artemis.*;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.optimism.wrt.engine.components.*;
import com.optimism.wrt.engine.graphics.Projector;


public class DecaySystem extends EntityProcessingSystem {
	
	@Mapper ComponentMapper<Rect> rm;
	
	
	@SuppressWarnings("unchecked")
	public DecaySystem() {
		super(Aspect.getAspectForAll(Rect.class, Velocity.class));
	}
	
	@Override
	public void process(Entity entity) {
		Rect rect = rm.get(entity);
		double halfWidth = Projector.gameWidth/2;
		double halfHeight = Projector.gameHeight/2;
		if (
				rect.lowleft.x > halfWidth ||
				rect.lowleft.x + rect.size.x < -Projector.gameWidth/2 ||
				rect.lowleft.y > halfHeight ||
				rect.lowleft.y + rect.size.y < -Projector.gameHeight/2) {
			
			entity.deleteFromWorld();
		}
	}

}
