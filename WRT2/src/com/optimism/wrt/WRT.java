package com.optimism.wrt;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.optimism.wrt.engine.MainGame;
import com.optimism.wrt.engine.graphics.*;
import com.optimism.wrt.game.WormholeState;


/*
 * The sort of "main class". This essentially replaces the shitty JFrame we've been using.
 */
public class WRT extends MainGame {
	
	private StateManager manager = new StateManager();
	
	@Override
	public void create() {
		// Sets the OpenGL background colour. RGBA format; values are between 0 and 1.
		Gdx.gl.glClearColor(0.5f, 0.0f, 1.0f, 1.0f);
		// Initialize the StateManager with a first state.
		manager.initialize(this, new WormholeState(manager));
		// Disables framerate limiting so that we can aim for a nice reasonable infinity frames-per-second
		Gdx.graphics.setContinuousRendering(false);
		Gdx.graphics.requestRendering();
	}

	@Override
	public void render() {
			// Clears the colour buffer (the screen) and the depth buffer (the z-sorting data)
			Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
			
			// Run the mainloop for the current state.
			manager.state().run();
			
			Gdx.graphics.requestRendering();
	}
	
	@Override
	public void dispose() {
		Resourcenator.dispose();
	}
	
	@Override
	public void resize(int width, int height) {
		Projector.resize(width, height);
	}
}
