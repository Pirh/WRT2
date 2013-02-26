package com.optimism.wrt.game.wormhole.systems;

import com.artemis.*;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.optimism.wrt.engine.components.Rect;
import com.optimism.wrt.game.wormhole.OrbitController;
import com.optimism.wrt.game.wormhole.components.Controllable;


public class OrbitMoveSystem extends EntityProcessingSystem {
	
	@Mapper ComponentMapper<Rect> rm;
	
	private OrbitController controller;
	
	@SuppressWarnings("unchecked")
	public OrbitMoveSystem(OrbitController controller) {
		super(Aspect.getAspectForAll(Rect.class, Controllable.class));
		this.controller = controller;
	}
	
	@Override
	public void process(Entity entity) {
		Rect rect = rm.get(entity);
		rect.setPosition(rect.position().rotate(controller.orbitVelocity));
	}

}
