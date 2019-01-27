package ru.vav.fighting.modelthings;

import ru.vav.fighting.View;
import ru.vav.fighting.ViewThing;

public class BattleArena {

    Integer viewThingID;
    String postfix = "";

    public BattleArena() {
        viewThingID = View.getInst().addThing("Arena", new ViewThing());
    }


}
