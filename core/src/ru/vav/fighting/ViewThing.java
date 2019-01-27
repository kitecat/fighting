package ru.vav.fighting;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ViewThing implements Comparable<ViewThing> {

    Sprite sprite;
    Material material;
    Boolean visible;
    Boolean playing;
    Boolean mirror;
    float zorder = 0;

    public ViewThing() {
        material = MaterialManager.getInst().getMaterial("default");
        sprite = new Sprite(material.GetTexture());
        sprite.setSize(10, 10);
        sprite.setPosition(10, 10);
        visible = true;
        playing = true;
        mirror = false;
    }

    public void setMaterial(Material mat) { material = mat.Copy(); }
    public void setSize(float width, float height) { sprite.setSize(width, height); }
    public void setPos(float x, float y) { sprite.setPosition(x, y); }
    public void setVisible(Boolean visible) { this.visible = visible; }
    public void setPlaying(Boolean playing) { this.playing = playing; }
    public void setZOrder(float z) { zorder = z; }

    public void flip() { mirror = !mirror; }
    public void setFlip(Boolean left) { mirror = left; }

    public float getWidth() { return sprite.getWidth(); }
    public float getHeight() { return sprite.getHeight(); }
    public float getX() { return sprite.getX(); }
    public float getY() { return sprite.getY(); }
    public float getZOrder(float z) { return zorder; }
    public Boolean getVisible() { return visible; }
    public Boolean getPlaying() { return playing; }

    public void Draw(SpriteBatch batch) {
        if (!visible)
            return;
        sprite.setTexture(material.GetTexture());
        float x = getX();
        float y = getY();
        float width = getWidth();
        float height = getHeight();
        if (mirror)
        {
            setSize(-width, height);
            setPos(x + width, y);
            sprite.draw(batch);
            setSize(width, height);
            setPos(x, y);
        }
        else
            sprite.draw(batch);
    }

    public void Update(float deltaTime) {
        if (playing)
            material.Update(deltaTime);
    }
    public int compareTo(ViewThing person) {
        return this.zorder > person.zorder ? -1 : this.zorder < person.zorder ? 1 : 0;
    }
}
