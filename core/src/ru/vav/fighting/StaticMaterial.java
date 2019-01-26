package ru.vav.fighting;

import com.badlogic.gdx.graphics.Texture;

import ru.vav.fighting.Material;
import ru.vav.fighting.TextureManager;

public class StaticMaterial implements Material {

    private Texture texture;

    public StaticMaterial(Texture texture) {
        this.texture = texture;
    }
    public StaticMaterial() {
        this(TextureManager.getInst().getTexture(0));
    }


    public StaticMaterial(String textureName) {
        this(TextureManager.getInst().getTexture(textureName));
    }
    public static StaticMaterial FromString(String textureName) {
        return new StaticMaterial(textureName);
    }
    public StaticMaterial(int textureID) {
        this(TextureManager.getInst().getTexture(textureID));
    }
    public  static StaticMaterial FromIDs(int textureID) {
        return new StaticMaterial(textureID);
    }

    @Override
    public Texture GetTexture() {
        return texture;
    }

    // Does nothing 'cause this material is static
    @Override
    public void Update(float deltaTime) {}

}
