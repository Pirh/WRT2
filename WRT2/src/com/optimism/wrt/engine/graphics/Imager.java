package com.optimism.wrt.engine.graphics;

import java.util.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.optimism.wrt.engine.components.Image;

public class Imager {

	private static Imager res = new Imager();
	
	private Map<String,Image> images = new HashMap<String,Image>();
	
	
	public static Image load(String filename) {
		Image img = res.images.get(filename);
		if (img == null) {
			Texture tex = new Texture(Gdx.files.internal(filename));
			img = new Image(tex);
			res.images.put(filename, img);
		}
		return img;
	}
	
	public static void dispose() {
		for (Image img: res.images.values()) {
			img.texture.dispose();
		}
		res = new Imager();
	}
	
}
