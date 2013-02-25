package com.optimism.wrt.engine.components;

import com.artemis.Component;
import com.badlogic.gdx.graphics.Texture;


public class Image extends Component {
	
	public Texture texture;
	
	public Image(Texture texture) {
		this.texture = texture;
	}

}
