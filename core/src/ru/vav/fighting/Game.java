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
	View view;
	Model model;
	float currentTime;
	float lastTime;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
        TextureManager.getInst().addTexture("bg1", "room.png");
		img = TextureManager.getInst().getTexture("bg1");
		character1 = TextureManager.getInst().getTexture(0);
		controller = new Controller();
        view = View.getInst();
        model = Model.getInst();
        currentTime = lastTime = System.nanoTime() * 1E-9f;

        Gdx.input.setInputProcessor(this);
	}

	@Override
	public void render () {
	    // Time
        currentTime = System.nanoTime() * 1E-9f;
        float deltaTime = (lastTime == 0) ? 0 : (currentTime - lastTime);
        lastTime = currentTime;

        // Draw
        Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0, 1280, 720);
		//batch.draw(character1, 0, 0);
		batch.end();
        model.Update(deltaTime);
        model.Apply();
        view.Update(deltaTime);
        view.Draw();
	}

    @Override
    public boolean keyDown(int keycode) {
        controller.keyDown(keycode);
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        controller.KeyUp(keycode);
        return true;
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
