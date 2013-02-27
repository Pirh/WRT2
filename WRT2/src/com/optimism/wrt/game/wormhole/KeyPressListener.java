package com.optimism.wrt.game.wormhole;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.*;
import com.optimism.wrt.Debug;
import com.optimism.wrt.engine.Settings;
import com.optimism.wrt.game.wormhole.debug.DebugManager;


public class KeyPressListener implements InputProcessor {

	private DebugManager debugMan;

	public KeyPressListener(DebugManager debugMan) {
		this.debugMan = debugMan;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
		case Keys.F1: Debug.showFPS = !Debug.showFPS; debugMan.refresh(); break;
		case Keys.F2: Debug.renderBodies = !Debug.renderBodies; break;
		case Keys.P: Settings.paused = !Settings.paused; break;
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

}
