package com.optimism.wrt.engine;

import com.optimism.wrt.StateManager;


public abstract class GameState {

	protected StateManager manager;
	
	public GameState(StateManager manager) {
		this.manager = manager;
	}
	
	public void run() {
		
	}
	
	public void pause() {
		
	}
	public void resume() {
		
	}
	public void dispose() {
		
	}
	
}
