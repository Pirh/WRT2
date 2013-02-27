package com.optimism.wrt.engine.components;

import com.artemis.Component;
import com.badlogic.gdx.graphics.Color;


public class Text extends Component {
	
	public static float SMALL = 0.5f;
	public static float NORMAL = 0.65f;
	public static float LARGE = 1.0f;

	private String text;
	public Color colour;
	public float scale;
	
	public Text(String text, Color colour, float scale) {
		this.text = text;
		this.colour = colour;
		this.scale = scale;
	}
	
	public Text(String text) {
		this(text, Color.WHITE, NORMAL);
	}
	
	public String getText() {
		return text;
	}
	
	public void changeText(String newText) {
		this.text = newText;
	}
}
