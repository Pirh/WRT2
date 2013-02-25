package com.optimism.wrt.game;

import com.artemis.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.optimism.wrt.StateManager;
import com.optimism.wrt.engine.GameState;
import com.optimism.wrt.engine.components.*;
import com.optimism.wrt.engine.graphics.*;
import com.optimism.wrt.engine.systems.*;
import com.optimism.wrt.engine.vectors.Vec;


/*
 * The state for the main gameplay.
 */
public class WormholeState extends GameState {

	private World world;
	private EntitySystem[] renderSystems;
	private boolean paused = false;
	
	
	public WormholeState(StateManager manager) {
		super(manager);

		world = new World();
		
		initialize();
	}
	
	public void initialize() {
		Entity test = world.createEntity();
		test.addComponent(new Rect(new Vec(0,0), new Vec(64,64), Anchor.CENTRE));
		test.addComponent(Resourcenator.texture("images/ship-player.png"));
		test.addToWorld();
		
		world.setSystem(new MovementSystem());
		world.setSystem(new RotationSystem());
		
		// Systems for rendering entities.
		// The 'true' in setSystem means it is passive: it won't be called by world.process()
		renderSystems = new EntitySystem[] {
				world.setSystem(new RenderSystem(), true)
		};
		
		world.initialize();
	}
	
	@Override
	public void run() {
		// Only process if the game isn't paused.
		if (!paused) {
			world.process();
		}
		// Process all graphics related systems; we do this even when its paused.
		for (EntitySystem renderSys: renderSystems) {
			renderSys.process();
		}
	}
	
}
