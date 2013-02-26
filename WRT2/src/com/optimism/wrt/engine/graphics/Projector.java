package com.optimism.wrt.engine.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Matrix4;
import com.optimism.wrt.engine.Settings;

public class Projector {

	public static double gameWidth;
	public static double gameHeight;
	public static Matrix4 projection;
	
	
	public static void resize(int width, int height) {
		gameHeight = Settings.gameHeight;
		gameWidth = Gdx.graphics.getWidth() * (gameHeight / Gdx.graphics.getHeight());
		
		projection = new Matrix4().scale(2.0f/(float) gameWidth, 2.0f/(float) gameHeight, 1.0f);
	}
	
}
