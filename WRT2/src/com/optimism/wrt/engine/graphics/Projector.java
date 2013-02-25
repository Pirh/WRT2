package com.optimism.wrt.engine.graphics;

import com.badlogic.gdx.Gdx;
import com.optimism.wrt.engine.Settings;

public class Projector {

	public static double gameWidth;
	public static double gameHeight;
	
	
	public static void resize(int width, int height) {
		gameHeight = Settings.gameHeight;
		gameWidth = Gdx.graphics.getWidth() * (gameHeight / Gdx.graphics.getHeight());
	}
	
}
