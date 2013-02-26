package com.optimism.wrt.game.wormhole;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.*;
import com.optimism.wrt.Debug;
import com.optimism.wrt.engine.Settings;


public class KeyPressListener implements InputProcessor {

	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
		case Keys.B: Debug.renderBodies = !Debug.renderBodies; break;
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
