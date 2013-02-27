package com.optimism.wrt.game;

import com.artemis.*;
import com.badlogic.gdx.Gdx;
import com.optimism.wrt.engine.*;
import com.optimism.wrt.engine.graphics.*;
import com.optimism.wrt.engine.systems.*;
import com.optimism.wrt.game.wormhole.*;
import com.optimism.wrt.game.wormhole.collision.*;
import com.optimism.wrt.game.wormhole.debug.*;
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
	private WormholeScene scene;
	private HUD hud;
	
	
	public WormholeState(StateManager manager) {
		super(manager);

		world = new World();
		controller = new OrbitController();
		collideList = new CollideList();
		scene = new WormholeScene(world);
		levelData = new LevelData();
		hud = new HUD(world, levelData);
		
		Gdx.input.setInputProcessor(new KeyPressListener(new DebugManager(world)));
		
		initialize();
	}
	
	public void initialize() {
		
		/* TODO
		 * - Failure state
		 */
		
		world.setSystem(new OrbitControlSystem(controller));
		world.setSystem(new OrbitMoveSystem(controller));
		world.setSystem(new ScriptSystem());
		
		world.setSystem(new MovementSystem());
		world.setSystem(new RotationSystem());
		world.setSystem(new LookAtSystem());
		
		world.setSystem(new WeaponSystem());
		world.setSystem(new CollisionSystem(collideList));
		
		world.setSystem(new DamageSystem(collideList, levelData, hud));
		world.setSystem(new PlanetDamageSystem(levelData, hud));
		
		world.setSystem(new UpgradeSystem(levelData, scene));
		world.setSystem(new EnemySpawnSystem(levelData));
		
		world.setSystem(new DecaySystem());		// When things go offscreen
		world.setSystem(new ExpirySystem());	// When things expire after a certain amount of time
		
		// Systems for rendering entities.
		// The 'true' in setSystem means it is passive: it won't be called by world.process()
		renderSystems = new EntitySystem[] {
				world.setSystem(new OrbitRenderSystem(levelData), true),
				world.setSystem(new SpriteRenderSystem(), true),
				world.setSystem(new TextRenderSystem(), true),
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
			
			if (levelData.lives <= 0)
				Gdx.app.exit();
			}
		// Process all graphics related systems; we do this even when its paused.
		for (EntitySystem renderSys: renderSystems) {
			renderSys.process();
		}
	}
	
}
