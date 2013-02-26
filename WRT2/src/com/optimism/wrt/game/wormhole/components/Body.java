package com.optimism.wrt.game.wormhole.components;

import com.artemis.Component;
import com.optimism.wrt.engine.math.Circle;


public class Body extends Component {
	
	public Circle circle;
	
	
	public Body(Circle circle) {
		this.circle = circle;
	}
	
}
