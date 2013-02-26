package com.optimism.wrt.game.wormhole.components;

import com.artemis.Component;


public class Health extends Component {
	
	public int health;
	public long score;
	
	public Health(int health, long score) {
		this.health = health;
		this.score = score;
	}
	
	public Health(int health) {
		this(health, 0);
	}
	
	public void lose(int amount) {
		this.health -= amount;
	}
	
	public boolean dead() {
		return this.health <= 0;
	}

}
