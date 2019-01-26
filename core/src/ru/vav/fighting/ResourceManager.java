package ru.vav.fighting;

import java.sql.Time;
import java.util.ArrayList;

import ru.vav.fighting.TextureManager;
import ru.vav.fighting.MaterialManager;

public class ResourceManager {
    private static ResourceManager inst = new ResourceManager();

    private ResourceManager() {
        // Animations
        ArrayList<Integer> anim = new ArrayList<Integer>();
        ArrayList<Integer> boyIdle = new ArrayList<Integer>();
        Timeline boyIdleTimeline = new Timeline();

        // Textures
        // anim
        anim.add(TextureManager.getInst().addTexture("anim1", "anim1.png"));
        anim.add(TextureManager.getInst().addTexture("anim2", "anim2.png"));
        anim.add(TextureManager.getInst().addTexture("anim3", "anim3.png"));
        // boy_idle
        Integer boyIdle0 = TextureManager.getInst().addTexture("boy_idle_0", "boy_idle_0.png");
        Integer boyIdle1 = TextureManager.getInst().addTexture("boy_idle_1", "boy_idle_1.png");
        Integer boyIdle2 = TextureManager.getInst().addTexture("boy_idle_2", "boy_idle_2.png");
        Integer boyIdle3 = TextureManager.getInst().addTexture("boy_idle_3", "boy_idle_3.png");


        // Materials
        MaterialManager.getInst().addAnimatedMaterialByIDs("anim", anim, new Timeline(3, 1));
        // boy_idle
//        boyIdle.add(boyIdle1);
//        boyIdle.add(boyIdle1);
//        boyIdle.add(boyIdle1);
//        boyIdle.add(boyIdle1);
//        boyIdle.add(boyIdle1);
//        boyIdle.add(boyIdle1);
//        boyIdle.add(boyIdle1);
//        boyIdle.add(boyIdle1);
//        boyIdle.add(boyIdle1);
//        boyIdle.add(boyIdle3);
//        boyIdle.add(boyIdle2);
//        boyIdle.add(boyIdle1);
//        boyIdle.add(boyIdle1);
//        boyIdle.add(boyIdle1);
//        boyIdle.add(boyIdle1);
//        boyIdle.add(boyIdle1);
//        boyIdle.add(boyIdle1);
//        boyIdle.add(boyIdle1);
//        boyIdle.add(boyIdle1);
//        boyIdle.add(boyIdle1);
//        boyIdle.add(boyIdle0);
//        boyIdle.add(boyIdle0);
        boyIdle.add(boyIdle0);
        boyIdle.add(boyIdle1);
        boyIdle.add(boyIdle2);
        boyIdle.add(boyIdle3);
        boyIdleTimeline.addFrame(new Timeline.KeyFrame(1, 0.6f));
        boyIdleTimeline.addFrame(new Timeline.KeyFrame(3, 0.075f));
        boyIdleTimeline.addFrame(new Timeline.KeyFrame(2, 0.075f));
        boyIdleTimeline.addFrame(new Timeline.KeyFrame(1, 0.6f));
        boyIdleTimeline.addFrame(new Timeline.KeyFrame(0, 0.15f));
        MaterialManager.getInst().addAnimatedMaterialByIDs("boy_idle", boyIdle, boyIdleTimeline);
    }

    public static ResourceManager getInst() {
        return inst;
    }
}
