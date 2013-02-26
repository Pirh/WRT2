package com.optimism.wrt.game.wormhole.debug;

import com.artemis.*;
import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.optimism.wrt.Debug;
import com.optimism.wrt.engine.components.Rect;
import com.optimism.wrt.engine.graphics.Projector;
import com.optimism.wrt.engine.math.Vec;
import com.optimism.wrt.game.wormhole.collision.*;
import com.optimism.wrt.game.wormhole.components.*;


public class DebugBodiesSystem extends EntityProcessingSystem {
	
	private static final Color Team0Col = new Color(1.0f, 0.6f, 0.3f, 1.0f);
	private static final Color Team1Col = new Color(0.6f, 1.0f, 0.7f, 1.0f);
	private static final Color Team2Col = new Color(1.0f, 1.0f, 0.4f, 1.0f);
	
	@Mapper ComponentMapper<Rect> rm;
	@Mapper ComponentMapper<Body> bm;
	@Mapper ComponentMapper<Team> tm;
	
	private ShapeRenderer renderer;
	private CollideList collideList;
	
	@SuppressWarnings("unchecked")
	public DebugBodiesSystem(CollideList collideList) {
		super(Aspect.getAspectForAll(Rect.class, Body.class));
		renderer = new ShapeRenderer();
		this.collideList = collideList;
	}
	
	@Override
	public void begin() {
		renderer.setProjectionMatrix(Projector.projection);
		renderer.begin(ShapeType.Circle);
	}
	
	@Override
	public void process(Entity entity) {
		Color col = Color.GRAY;
		Team team = tm.get(entity);
		
		// If it has a team, give it its team's colour
		if (team != null) {
			switch (team.teamNumber) {
				case 0: col = Team0Col; break;
				case 1: col = Team1Col; break;
				case 2: col = Team2Col; break;
			}
		}
		
		// If it's colliding with something, make it red
		for (Collision coll: collideList.collisions) {
			if (entity == coll.first || entity == coll.second) {
				col = Color.RED;
				break;
			}
		}
		
		Vec pos = rm.get(entity).position();
		float radius = (float) bm.get(entity).circle.radius;
		
		renderer.setColor(col);
		renderer.circle((float) pos.x, (float) pos.y, radius, 16);
	}
	
	@Override
	public void end() {
		renderer.end();
	}
	
	@Override
	public boolean checkProcessing() {
		return Debug.renderBodies;
	}

}
