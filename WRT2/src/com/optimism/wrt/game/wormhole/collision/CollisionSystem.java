package com.optimism.wrt.game.wormhole.collision;

import com.artemis.*;
import com.artemis.annotations.Mapper;
import com.artemis.utils.ImmutableBag;
import com.optimism.wrt.engine.components.Rect;
import com.optimism.wrt.engine.math.*;
import com.optimism.wrt.game.wormhole.components.*;


public class CollisionSystem extends EntitySystem {

	@Mapper ComponentMapper<Rect> rm;
	@Mapper ComponentMapper<Body> bm;
	@Mapper ComponentMapper<Team> tm;
	
	private CollideList collideList;
	
	@SuppressWarnings("unchecked")
	public CollisionSystem(CollideList collideList) {
		super(Aspect.getAspectForAll(Rect.class, Body.class, Team.class));
		this.collideList = collideList;
	}
	
	@Override
	public void processEntities(ImmutableBag<Entity> entities) {
		int size = entities.size();
		if (size < 2) {
			return;
		}
		for (int i=0; i < size; i++) {
			Entity entityA = entities.get(i);
			Vec posA = rm.get(entityA).position();
			Body bodyA = bm.get(entityA);
			Team teamA = tm.get(entityA);
			
			for (int j=i+1; j < size; j++) {
				Entity entityB = entities.get(j);
				Team teamB = tm.get(entityB);
				
				if (teamA.teamNumber == teamB.teamNumber) {
					continue;
				}
				
				Vec posB = rm.get(entityB).position();
				Body bodyB = bm.get(entityB);
				if (Collider.collide(bodyA, posA, bodyB, posB)) {
					collideList.addCollision(entityA, entityB);
				}
			}
		}
	}
	
	@Override
	public boolean checkProcessing() { return true; }
}
