package com.optimism.wrt.game.wormhole;

import com.artemis.*;
import com.badlogic.gdx.Gdx;
import com.optimism.wrt.game.wormhole.factory.*;

public class WormholeScene {
	
	public Entity[] players = new Entity[] {};
	public Entity wormhole;
	
	
	public WormholeScene(World world) {
		wormhole = Factory.wormhole(world);
		replacePlayers(world, 2);
	}
	
	public void replacePlayers(World world, int numShips) {
		for (Entity e: players) {
			Gdx.app.log("Deleted","Player - "+e);
			e.deleteFromWorld();
		}
		players = ShipYard.createPlayerShips(world, numShips, wormhole);
	}
	
}
