package com.optimism.wrt;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.optimism.wrt.engine.*;
import com.optimism.wrt.engine.graphics.*;
import com.optimism.wrt.game.WormholeState;


/*
 * The sort of "main class". This essentially replaces the shitty JFrame we've been using.
 */
public class WRT extends MainGame {
	
	private StateManager manager = new StateManager();
	private FPSLogger fpsLogger = new FPSLogger();
	
	@Override
	public void create() {
		// Sets the OpenGL background colour. RGBA format; values are between 0 and 1.
		Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		// Initialize the StateManager with a first state.
		manager.initialize(this, new WormholeState(manager));
	}

	@Override
	public void render() {
		if (Debug.showFPS) {
			fpsLogger.log();
		}
		// Clears the colour buffer (the screen)
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		// Run the mainloop for the current state.
		manager.state().run();
	}
	
	@Override
	public void dispose() {
		Imager.dispose();
	}
	
	@Override
	public void resize(int width, int height) {
		Projector.resize(width, height);
	}
}
