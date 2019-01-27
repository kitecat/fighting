package ru.vav.fighting.modelthings;

import ru.vav.fighting.View;
import ru.vav.fighting.ViewThing;

public class Character {

    String charName;
    String postfix = "";
    Integer viewThingID;
    float x;
    float y; // This will used when jump
    float z;

    public Character(String charName) {
        this.charName = charName;
        Integer index = 0;
        while ((viewThingID = View.getInst().addThing("char_" + charName + postfix, new ViewThing())) == 0 ) {
            postfix = "_" + index++;
        }
    }

}
