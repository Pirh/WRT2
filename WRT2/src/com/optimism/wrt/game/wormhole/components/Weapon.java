package com.optimism.wrt.game.wormhole.components;

import com.artemis.Component;


public class Weapon extends Component {
	
	public double reloadTime;
	public double reloadTimeLeft = 0;
	
	
	public Weapon(double reloadTime) {
		this.reloadTime = reloadTime;
	}
	
	public void fired() {
		reloadTimeLeft = reloadTime;
	}
	
	public void reload(double delta) {
		reloadTimeLeft -= delta;
	}
	
	public boolean ready() {
		return reloadTimeLeft <= 0;
	}

}
