package ru.vav.fighting;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ViewThing {

    Sprite sprite;
    Material material;
    Boolean visible;
    Boolean playing;

    public ViewThing() {
        material = MaterialManager.getInst().getMaterial("default");
        sprite = new Sprite(material.GetTexture());
        sprite.setSize(10, 10);
        sprite.setPosition(10, 10);
        visible = true;
        playing = true;
    }

    public void setMaterial(Material mat) { material = mat.Copy(); }
    public void setSize(float width, float height) { sprite.setSize(width, height); }
    public void setPos(float x, float y) { sprite.setPosition(x, y); }
    public void setVisible(Boolean visible) { this.visible = visible; }
    public void setPlaying(Boolean playing) { this.playing = playing; }

    public float getWidth() { return sprite.getWidth(); }
    public float getHeight() { return sprite.getHeight(); }
    public float getX() { return sprite.getY(); }
    public float getY() { return sprite.getX(); }
    public Boolean getVisible() { return visible; }
    public Boolean getPlaying() { return playing; }

    public void Draw(SpriteBatch batch) {
        if (!visible)
            return;
        sprite.setTexture(material.GetTexture());
        sprite.draw(batch);
    }

    public void Update(float deltaTime) {
        if (playing)
            material.Update(deltaTime);
    }
}
