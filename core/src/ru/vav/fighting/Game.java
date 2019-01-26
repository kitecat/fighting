package ru.vav.fighting;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.vav.fighting.TextureManager;

public class Game extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch;
	Texture img, character1;
	Controller controller;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
        TextureManager.getInst().addTexture("bg1", "bg1.png");
		img = TextureManager.getInst().getTexture("bg1");
		character1 = TextureManager.getInst().getTexture(0);
		controller = new Controller();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.draw(character1, 0, 0);
		batch.end();
	}

    @Override
    public boolean keyDown(int keycode) {
        controller.keyDown(keycode);
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

    @Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		character1.dispose();
	}
}
