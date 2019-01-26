package ru.vav.fighting;

import com.badlogic.gdx.graphics.Texture;

public interface Material {

    void Update(float deltaTime);

    Texture GetTexture();

    Material Copy();

}
