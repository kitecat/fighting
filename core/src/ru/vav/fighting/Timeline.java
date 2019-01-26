package ru.vav.fighting;


import java.util.ArrayList;
import java.util.Iterator;

public class Timeline {
    public static class KeyFrame {
        public int frameNum;
        public float duration;

        public KeyFrame(int frameNum, float duration) {
            this.frameNum = frameNum;
            this.duration = duration;
        }
    }
    private float duration;
    private ArrayList<KeyFrame> keyFrames;

    public float getDuration() { return duration; }

    public Timeline() {
        duration = 0;
        keyFrames = new ArrayList<KeyFrame>();
    }
    public Timeline(int frameCount, float duration) {
        this.duration = duration;
        keyFrames = new ArrayList<KeyFrame>();
        for (int i = 0; i < frameCount; i++)
            keyFrames.add(new KeyFrame(i, duration / frameCount));
    }
    public Timeline(ArrayList<KeyFrame> keyFrames) {
        this.keyFrames = keyFrames;
        duration = 0;
        for (KeyFrame keyFrame : keyFrames)
            duration += keyFrame.duration;
    }

    public void addFrame(KeyFrame keyFrame) {
        keyFrames.add(keyFrame);
        duration += keyFrame.duration;
    }
    public void addFrames(ArrayList<KeyFrame> keyFrames) {
        keyFrames.addAll(keyFrames);
        for (KeyFrame keyFrame : keyFrames)
            duration += keyFrame.duration;
    }

    public int getFrame(float time) {
        time %= duration;
        Iterator<KeyFrame> iter = keyFrames.iterator();
        int frame = 0;
        while ((time > 0) && iter.hasNext()) {
            KeyFrame keyFrame = iter.next();
            frame = keyFrame.frameNum;
            time -= keyFrame.duration;
        }
        return frame;
    }
}