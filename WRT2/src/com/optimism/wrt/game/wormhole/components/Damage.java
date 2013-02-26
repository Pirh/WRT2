package com.optimism.wrt.game.wormhole.components;

import com.artemis.Component;


public class Damage extends Component {

	public int damage;
	public boolean onceOnly = true;	// May change this later.
	
	public Damage(int damage) {
		this.damage = damage;
	}
	
}
