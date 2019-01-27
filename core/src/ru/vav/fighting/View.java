package ru.vav.fighting;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ru.vav.fighting.Model;

public class View {

    // Things
    private ArrayList<ViewThing> things = new ArrayList<ViewThing>();
    private Map<String, Integer> keys = new HashMap<String, Integer>();
    private class ThingLink implements Comparable<ThingLink> {
        public int thingID;
        public ThingLink(int thingID) {
            this.thingID = thingID;
        }
        @Override
        public int compareTo(ThingLink right) {
            return getThing(thingID).compareTo(getThing(right.thingID));
        }
    }
    private ArrayList<ThingLink> links = new ArrayList<ThingLink>();

    public Integer addThing(String thingName, ViewThing thing) {
        if (keys.containsKey(thingName))
            return 0;
        else {
            int index = things.size();
            keys.put(thingName, index);
            things.add(thing);
            links.add(new ThingLink(index));
            return index;
        }
    }
    public ViewThing getThing(Integer ID) {
        if ((ID >= things.size()) || (ID < 0))
            return new ViewThing();
        return things.get(ID);
    }
    public ViewThing getThing(String name) {
        return getThing(getID(name));
    }
    public Integer getID(String name) {
        if (keys.containsKey(name))
            return keys.get(name);
        else
            return 0;
    }


    // Singleton
    private static View inst = new View();
    public static View getInst() { return inst; }


    SpriteBatch batch;
    Sprite sprite;
    Material material;

    MaterialManager matMgr = MaterialManager.getInst();

    public View() {
        ResourceManager.getInst();
        batch = new SpriteBatch();
        //material = MaterialManager.getInst().getMaterial("girl_punch");
        //sprite = new Sprite(material.GetTexture());
        //sprite.setSize(100, 180);
        //sprite.setPosition(10, 10);
    }

    public void Draw() {
        batch.begin();
        //sprite.setTexture(material.GetTexture());
        //sprite.draw(batch);
        Collections.sort(links);
        for (ThingLink link : links)
            if (getThing(link.thingID)!= null)
                getThing(link.thingID).Draw(batch);
        batch.end();
    }



    public void Update(float deltaTime) {
        //material.Update(deltaTime);
        for (ViewThing thing : things)
            if (thing != null)
                thing.Update(deltaTime);
    }

}
