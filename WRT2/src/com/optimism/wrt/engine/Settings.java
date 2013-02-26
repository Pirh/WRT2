package com.optimism.wrt.engine;

import com.badlogic.gdx.graphics.Color;


public class Settings {

	// Game settings
	public static boolean paused = false;
	
	// Graphics settings
	public static double gameHeight = 100.0;
	
	// Orbit settings
	public static float orbitRadius = 45.0f;
	public static int orbitSharpness = 56;
	public static Color orbitColour = Color.WHITE;
	
	public static double orbitAcceleration = 15.0;
	public static double orbitDeceleration = 5.0;
	public static double orbitMaxSpeed = 3.0;
	
	// Player settings
	public static double direction = 1.0;	// Set to -1.0 if you're weird. AKA Ryan and Scott.
	public static boolean autoFire = false;	// Set to false if you're weird. AKA James.
	public static double firingRate = 0.3;	// Set to 0.03 if you're dumb. AKA ***Deadname***.
	public static double bulletSpeed = 100;
	
}
