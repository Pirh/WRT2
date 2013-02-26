package com.optimism.wrt.game;

import com.artemis.*;
import com.badlogic.gdx.Gdx;
import com.optimism.wrt.engine.*;
import com.optimism.wrt.engine.graphics.SpriteRenderSystem;
import com.optimism.wrt.engine.systems.*;
import com.optimism.wrt.game.wormhole.*;
import com.optimism.wrt.game.wormhole.collision.*;
import com.optimism.wrt.game.wormhole.debug.DebugBodiesSystem;
import com.optimism.wrt.game.wormhole.factory.*;
import com.optimism.wrt.game.wormhole.systems.*;


/*
 * The state for the main gameplay.
 */
public class WormholeState extends GameState {

	private World world;
	private EntitySystem[] renderSystems;
	
	private LevelData levelData;
	private OrbitController controller;
	private CollideList collideList;
	
	
	public WormholeState(StateManager manager) {
		super(manager);

		world = new World();
		controller = new OrbitController();
		collideList = new CollideList();
		
		Gdx.input.setInputProcessor(new KeyPressListener());
		
		initialize();
	}
	
	public void initialize() {
		Entity wormhole = Factory.wormhole(world);
		wormhole.addToWorld();
		Entity[] players = ShipYard.createPlayerShips(world, 2, wormhole);
		
		levelData = new LevelData(players);
		
		world.setSystem(new OrbitControlSystem(controller));
		world.setSystem(new OrbitMoveSystem(controller));
		
		world.setSystem(new MovementSystem());
		world.setSystem(new RotationSystem());
		world.setSystem(new LookAtSystem());
		
		world.setSystem(new WeaponSystem());
		world.setSystem(new CollisionSystem(collideList));
		world.setSystem(new DamageSystem(collideList, levelData));
		
		// Systems for rendering entities.
		// The 'true' in setSystem means it is passive: it won't be called by world.process()
		renderSystems = new EntitySystem[] {
				world.setSystem(new OrbitRenderSystem(), true),
				world.setSystem(new SpriteRenderSystem(), true),
				world.setSystem(new DebugBodiesSystem(collideList), true)
		};
		
		world.initialize();
	}
	
	@Override
	public void run() {
		// Set the delta
		world.setDelta(Gdx.graphics.getDeltaTime());
		// Only process if the game isn't paused.
		if (!Settings.paused) {
			collideList.clear();
			world.process();
		}
		// Process all graphics related systems; we do this even when its paused.
		for (EntitySystem renderSys: renderSystems) {
			renderSys.process();
		}
	}
	
}
