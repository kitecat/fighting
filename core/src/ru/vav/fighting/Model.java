package ru.vav.fighting;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ru.vav.fighting.modelthings.BattleArena;
import ru.vav.fighting.modelthings.Character;
import ru.vav.fighting.modelthings.Player;

public class Model {

    // Things
    private ArrayList<ModelThing> things = new ArrayList<ModelThing>();
    private Map<String, Integer> keys = new HashMap<String, Integer>();

    public Integer addThing(String thingName, ModelThing thing) {
        if (keys.containsKey(thingName))
            return 0;
        else {
            int index = things.size();
            keys.put(thingName, index);
            things.add(thing);
            return index;
        }
    }
    public ModelThing getThing(Integer ID) {
        if ((ID >= things.size()) || (ID < 0))
            return null;
        return things.get(ID);
    }
    public ModelThing getThing(String name) {
        return getThing(getID(name));
    }
    public Integer getID(String name) {
        if (keys.containsKey(name))
            return keys.get(name);
        else
            return 0;
    }



    Integer player1ID;
    Integer player2ID;



    public Model() {
        addThing("Arena", new BattleArena());
        player1ID = addThing("Player1", new Player("boy"));
        player2ID = addThing("Player2", new Player("girl"));
    }

    public void Update(float deltaTime) {
        for (ModelThing thing : things)
            thing.Update(deltaTime);
    }
    public void Apply() {
        for (ModelThing thing : things)
            thing.Apply();
    }

    // Singleton
    private static Model inst = new Model();
    public static Model getInst() {
        return inst;
    }


    private class PlayerKeys {
        int left = 0;
        int up = 0;
        int right = 0;
        int down = 0;
    }

    PlayerKeys player1Keys = new PlayerKeys();
    PlayerKeys player2Keys = new PlayerKeys();

    public void SendMessage(int msgID, int Message) {
        if ((msgID == Messages.Player1) || (msgID == Messages.Player2)) {
            PlayerKeys playerKeys = (msgID == Messages.Player1) ? player1Keys : player2Keys;
            Player player = (Player)getThing((msgID == Messages.Player1) ? player1ID : player2ID);
            switch (Message) {
                case Messages.DirLeft:
                    playerKeys.left = 1;
                    break;
                case Messages.DirUp:
                    playerKeys.up = 1;
                    break;
                case Messages.DirRight:
                    playerKeys.right = 1;
                    break;
                case Messages.DirDown:
                    playerKeys.down = 1;
                    break;
                case Messages.StopLeft:
                    playerKeys.left = 0;
                    break;
                case Messages.StopUp:
                    playerKeys.up = 0;
                    break;
                case Messages.StopRight:
                    playerKeys.right = 0;
                    break;
                case Messages.StopDown:
                    playerKeys.down = 0;
                    break;
            }
            player.setVelosity(playerKeys.right - playerKeys.left, playerKeys.up - playerKeys.down);
        }
    }

}
