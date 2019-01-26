package ru.vav.fighting;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ViewThing {

    Sprite sprite;
    Material material;
    Boolean visible;

    public ViewThing() {
        material = MaterialManager.getInst().getMaterial("default");
        sprite = new Sprite(material.GetTexture());
        sprite.setSize(10, 10);
        sprite.setPosition(10, 10);
        visible = true;
    }

    public void setMaterial(Material mat) { material = mat.Copy(); }
    public void setSize(float width, float height) { sprite.setSize(width, height); }
    public void setPos(float x, float y) { sprite.setPosition(x, y); }

    public float getWidth() { return sprite.getWidth(); }
    public float getHeight() { return sprite.getHeight(); }
    public float getX() { return sprite.getY(); }
    public float getY() { return sprite.getX(); }

    public void Draw(SpriteBatch batch) {
        if (!visible)
            return;
        sprite.setTexture(material.GetTexture());
        sprite.draw(batch);
    }

    public void Update(float deltaTime) {
        material.Update(deltaTime);
    }
}
