package com.optimism.wrt.game.wormhole.collision;

import java.util.ArrayList;

import com.artemis.Entity;


public class CollideList {

	public ArrayList<Collision> collisions = new ArrayList<Collision>();
	
	public void addCollision(Entity first, Entity second) {
		collisions.add(new Collision(first, second));
	}
	
	public void clear() {
		collisions.clear();
	}
	
}
