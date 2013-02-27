package com.optimism.wrt;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "W.R.T";
		cfg.useGL20 = false;
		cfg.width = 1024;
		cfg.height = 576;
		cfg.useCPUSynch = false;
		cfg.vSyncEnabled = false;
		
		new LwjglApplication(new WRT(), cfg);
	}
}
