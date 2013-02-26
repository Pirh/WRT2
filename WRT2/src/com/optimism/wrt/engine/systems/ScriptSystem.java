package com.optimism.wrt.engine.systems;

import com.artemis.*;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.optimism.wrt.engine.components.Script;


public class ScriptSystem extends EntityProcessingSystem {

	@Mapper ComponentMapper<Script> sm;
	
	
	@SuppressWarnings("unchecked")
	public ScriptSystem() {
		super(Aspect.getAspectForOne(Script.class));
	}
	
	@Override
	public void process(Entity entity) {
		Script script = sm.get(entity);
		if (!script.initialized) {
			script.script.initialize(world, entity);
			script.initialized = true;
		}
		script.script.run(world, entity);
	}
	
}
