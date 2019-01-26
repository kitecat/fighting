package ru.vav.fighting;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

import ru.vav.fighting.Model;

public class View {

    SpriteBatch batch;
    Sprite sprite;
    Material material;

    public View() {
        ResourceManager.getInst();
        batch = new SpriteBatch();
        material = MaterialManager.getInst().getMaterial("boy_idle");
        sprite = new Sprite(material.GetTexture());
        sprite.setSize(100, 200);
        sprite.setPosition(10, 10);
    }

    public void Draw() {
        batch.begin();
        sprite.setTexture(material.GetTexture());
        sprite.draw(batch);
        batch.end();
    }


    public void Update(float deltaTime) {
        material.Update(deltaTime);
    }

}
