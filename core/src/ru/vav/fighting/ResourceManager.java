package ru.vav.fighting;

import java.util.ArrayList;

public class ResourceManager {
    private static ResourceManager inst = new ResourceManager();

    private ResourceManager() {
        // Animations
        ArrayList<Integer> anim = new ArrayList<Integer>();
        // boy_idle
        ArrayList<Integer> boyIdle = new ArrayList<Integer>();
        Timeline boyIdleTimeline = new Timeline();
        // boy_walk
        ArrayList<Integer> boyWalk = new ArrayList<Integer>();
        Timeline boyWalkTimeline = new Timeline();
        // boy_block_walk
        ArrayList<Integer> boyBlockWalk = new ArrayList<Integer>();
        Timeline boyBlockWalkTimeline = new Timeline();
        // boy_punch
        ArrayList<Integer> boyPunch = new ArrayList<Integer>();
        Timeline boyPunchTimeline = new Timeline();

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
        // boy_walk
        Integer boyWalk0 = TextureManager.getInst().addTexture("boy_walk_0", "boy_walk_0.png");
        Integer boyWalk1 = TextureManager.getInst().addTexture("boy_walk_1", "boy_walk_1.png");
        Integer boyWalk2 = TextureManager.getInst().addTexture("boy_walk_2", "boy_walk_2.png");
        Integer boyWalk3 = TextureManager.getInst().addTexture("boy_walk_3", "boy_walk_3.png");
        // boy_block_walk
        Integer boyBlockWalk0 = TextureManager.getInst().addTexture("boy_block_walk_0", "boy_block_walk_0.png");
        Integer boyBlockWalk1 = TextureManager.getInst().addTexture("boy_block_walk_1", "boy_block_walk_1.png");
        Integer boyBlockWalk2 = TextureManager.getInst().addTexture("boy_block_walk_2", "boy_block_walk_2.png");
        Integer boyBlockWalk3 = TextureManager.getInst().addTexture("boy_block_walk_3", "boy_block_walk_3.png");
        Integer boyBlockWalk4 = TextureManager.getInst().addTexture("boy_block_walk_4", "boy_block_walk_4.png");
        // boy_punch
        Integer boyPunch0 = TextureManager.getInst().addTexture("boy_punch_0", "boy_punch_0.png");
        Integer boyPunch1 = TextureManager.getInst().addTexture("boy_punch_1", "boy_punch_1.png");
        Integer boyPunch2 = TextureManager.getInst().addTexture("boy_punch_2", "boy_punch_2.png");
        Integer boyPunch3 = TextureManager.getInst().addTexture("boy_punch_3", "boy_punch_3.png");

        // Materials
        MaterialManager.getInst().addAnimatedMaterialByIDs("anim", anim, new Timeline(3, 1));
        // boy_idle
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
//         boy_walk
        boyWalk.add(boyWalk0);
        boyWalk.add(boyWalk1);
        boyWalk.add(boyWalk2);
        boyWalk.add(boyWalk3);
        boyWalkTimeline.addFrame(new Timeline.KeyFrame(0, 0.2f));
        boyWalkTimeline.addFrame(new Timeline.KeyFrame(1, 0.2f));
        boyWalkTimeline.addFrame(new Timeline.KeyFrame(2, 0.2f));
        boyWalkTimeline.addFrame(new Timeline.KeyFrame(3, 0.2f));
        MaterialManager.getInst().addAnimatedMaterialByIDs("boy_walk", boyWalk, boyWalkTimeline);
//         boy_walk
        boyBlockWalk.add(boyBlockWalk0);
        boyBlockWalk.add(boyBlockWalk1);
        boyBlockWalk.add(boyBlockWalk2);
        boyBlockWalk.add(boyBlockWalk3);
        boyBlockWalk.add(boyBlockWalk4);
        boyBlockWalkTimeline.addFrame(new Timeline.KeyFrame(0, 0.2f));
        boyBlockWalkTimeline.addFrame(new Timeline.KeyFrame(1, 0.2f));
        boyBlockWalkTimeline.addFrame(new Timeline.KeyFrame(2, 0.2f));
        boyBlockWalkTimeline.addFrame(new Timeline.KeyFrame(3, 0.2f));
        boyBlockWalkTimeline.addFrame(new Timeline.KeyFrame(4, 0.2f));
        MaterialManager.getInst().addAnimatedMaterialByIDs("boy_block_walk", boyBlockWalk, boyBlockWalkTimeline);
//         boy_punch
        boyPunch.add(boyPunch0);
        boyPunch.add(boyPunch1);
        boyPunch.add(boyPunch2);
        boyPunch.add(boyPunch3);
        boyPunchTimeline.addFrame(new Timeline.KeyFrame(0, 0.2f));
        boyPunchTimeline.addFrame(new Timeline.KeyFrame(1, 0.2f));
        boyPunchTimeline.addFrame(new Timeline.KeyFrame(2, 0.2f));
        boyPunchTimeline.addFrame(new Timeline.KeyFrame(3, 0.2f));
        MaterialManager.getInst().addAnimatedMaterialByIDs("boy_punch", boyPunch, boyPunchTimeline);
    }

    public static ResourceManager getInst() {
        return inst;
    }
}
