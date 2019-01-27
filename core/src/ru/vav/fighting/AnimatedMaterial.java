package ru.vav.fighting;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.Iterator;

public class AnimatedMaterial implements Material {

    private ArrayList<Texture> texture;
    private Timeline timeline;
    private float time;
    private Boolean repeat;

    public AnimatedMaterial(ArrayList<Texture> texture, Timeline timeline, Boolean repeat) {
        this.texture = texture;
        this.timeline = timeline;
        this.repeat = repeat;
        time = 0;
    }
    public AnimatedMaterial() {
        this(new ArrayList<Texture>() {
            {
                add(TextureManager.getInst().getTexture(0));
            }
        }, new Timeline(0, 0), false);
    }

    // From TextureManager
    public static AnimatedMaterial FromStringArray(ArrayList<String> textureNames, Timeline timeline, Boolean repeat) {
        ArrayList<Texture> texture = new ArrayList<Texture>();

        Iterator<String> iter = textureNames.iterator();
        while(iter.hasNext()){
            texture.add(TextureManager.getInst().getTexture(iter.next()));
        }

        return new AnimatedMaterial(texture, timeline, repeat);
    }
    public static AnimatedMaterial FromIDsArray(ArrayList<Integer> textureIDs, Timeline timeline, Boolean repeat) {
        ArrayList<Texture> texture = new ArrayList<Texture>();

        Iterator<Integer> iter = textureIDs.iterator();
        while(iter.hasNext()){
            texture.add(TextureManager.getInst().getTexture(iter.next()));
        }

        return new AnimatedMaterial(texture, timeline, repeat);
    }

    @Override
    public Texture GetTexture() {
        return texture.get(timeline.getFrame(time) % texture.size());
    }

    @Override
    public void Update(float deltaTime) {
        float duration = timeline.getDuration();
        if (duration <= 1E-6)
            return;
        time += deltaTime;
        if (repeat)
            time %= duration;
        else
            if (time < 0) time = 0;
            else if (time > duration) time = duration;
    }

    @Override
    public Material Copy() {
        return new AnimatedMaterial(texture, timeline, repeat);
    }
}
