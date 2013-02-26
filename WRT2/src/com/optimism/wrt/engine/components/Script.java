package com.optimism.wrt.engine.components;

import com.artemis.Component;
import com.optimism.wrt.engine.scripting.ScriptAction;


public class Script extends Component {
	
	public ScriptAction script;
	public boolean initialized = false;
	
	public Script(ScriptAction script) {
		this.script = script;
	}

}
