package com.optimism.wrt.engine.systems;

import com.artemis.*;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.optimism.wrt.engine.components.*;
import com.optimism.wrt.engine.math.Vec;


public class LookAtSystem extends EntityProcessingSystem {
	
	@Mapper ComponentMapper<Rect> rm;
	@Mapper ComponentMapper<Orientation> om;
	@Mapper ComponentMapper<LookAt> lm;
	
	
	@SuppressWarnings("unchecked")
	public LookAtSystem() {
		super(Aspect.getAspectForAll(Rect.class, Orientation.class, LookAt.class));
	}
	
	@Override
	public void process(Entity entity) {
		LookAt lookat = lm.get(entity);
		if (lookat.target != null) {
			Rect target = rm.getSafe(lookat.target);
			if (target != null) {
				Rect rect = rm.get(entity);
				Vec eyeLine = target.position().sub(rect.position());
				om.get(entity).angle = eyeLine.angle();
			}
		}
	}
	
}
