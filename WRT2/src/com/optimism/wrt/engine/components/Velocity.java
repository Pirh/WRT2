package com.optimism.wrt.engine.components;

import com.artemis.Component;
import com.optimism.wrt.engine.math.Vec;


public class Velocity extends Component {
	
	public Vec velocity;
	
	public Velocity(Vec velocity) {
		this.velocity = velocity;
	}

}
