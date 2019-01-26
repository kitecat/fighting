package ru.vav.fighting;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TextureManager {

    private static TextureManager inst = new TextureManager();

    private ArrayList<Texture> textures = new ArrayList<Texture>() {
        {
            add(new Texture("default.png"));
        }
    };
    private Map<String, Integer> keys = new HashMap<String, Integer>() {
        {
            put("default", 0);
        }
    };

    private TextureManager() {

    }

    public Texture getTexture(Integer id) {
        if (id >= textures.size())
            return textures.get(0);
        return textures.get(id);
    }
    public Texture getTexture(String name) {
        return getTexture(getID(name));
    }
    public Integer getID(String name) {
        if (keys.containsKey(name))
            return keys.get(name);
        else
            return 0;
    }

    public Integer addTexture(String name, Texture texture) {
        if (keys.containsKey(name))
            return 0;
        else {
            int index = textures.size();
            keys.put(name, index);
            textures.add(texture);
            return index;
        }
    }
    public Integer addTexture(String name, String path) {
        try {
            return addTexture(name, new Texture(path));
        }
        catch (GdxRuntimeException e) {
            return 0;
        }
    }

    public static TextureManager getInst() {
        return inst;
    }
}
