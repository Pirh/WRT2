package com.optimism.wrt.engine.components;

import com.artemis.*;


public class LookAt extends Component {

	public Entity target;
	
	public LookAt(Entity target) {
		this.target = target;
	}
	
}
