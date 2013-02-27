package com.optimism.wrt.engine.graphics;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.optimism.wrt.engine.Settings;
import com.optimism.wrt.engine.math.Vec;


public class Projector {

	public static double gameWidth;
	public static double gameHeight;
	
	public static int deviceWidth;
	public static int deviceHeight;
	
	public static double widthRatio;
	public static double heightRatio;
	
	public static Matrix4 projection;
	public static Matrix4 textProjection;
	
	
	public static void resize(int width, int height) {
		deviceWidth = width;
		deviceHeight = height;
		
		gameHeight = Settings.gameHeight;
		gameWidth = width * (gameHeight / height);
		
		widthRatio = (double) deviceWidth / gameWidth;
		heightRatio = (double) deviceHeight / gameHeight;
		
		projection = new Matrix4().scale(2.0f/(float) gameWidth, 2.0f/(float) gameHeight, 1.0f);
		
		SpriteBatch batch = new SpriteBatch();
		textProjection = batch.getProjectionMatrix();
		batch.dispose();
	}
	
	/**
	 * Gets the screen position of a vector. This gets around the scaling bug in the Bitmap Font.
	 */
	public static Vec textPositionHack(Vec pos) {
		Vec half = new Vec(deviceWidth/2, deviceHeight/2);
		return pos.mul(new Vec(widthRatio, heightRatio)).add(half);
	}
	
}
