package com.optimism.wrt.engine;

import java.util.Stack;



/*
 * Exactly what it sounds like: a state manager.
 * Keep a reference to it and use (push|pop)State to change between states.
 */
public class StateManager {

	public MainGame game;
	private Stack<GameState> states = new Stack<GameState>();
	
	public GameState state() {
		return states.firstElement();
	}
	
	public void initialize(MainGame game, GameState startState) {
		this.game = game;
		states.push(startState);
		startState.resume();
	}
	
	public void pushState(GameState newState) {
		state().pause();
		states.push(newState);
		state().resume();
	}
	
	public void popState() {
		state().dispose();
		states.pop();
		state().resume();
	}
	
}