package ru.vav.fighting.modelthings;

import ru.vav.fighting.Model;
import ru.vav.fighting.ModelThing;
import ru.vav.fighting.View;
import ru.vav.fighting.ViewThing;

public class Character implements ModelThing {

    protected String charName;
    protected String postfix = "";
    protected Integer viewThingID;
    protected Integer arenaID;
    protected float x;
    protected float y; // This will used when jump
    protected float z;
    protected float velX;
    protected float velZ;

    public Character(String charName) {
        this.charName = charName;
        Integer index = 0;
        while ((viewThingID = View.getInst().addThing("char_" + charName + postfix, new ViewThing())) == 0 ) {
            postfix = "_" + index++;
        }
        arenaID = View.getInst().getID("Arena");
        x = 0;
        y = 0;
        z = 0;
    }

    protected void Move(float x, float z) {
        ModelThing arena = Model.getInst().getThing(arenaID);
        if (arena instanceof BattleArena) {
            this.x += x;
            float sizeW = ((BattleArena)arena).getWidth();
            float sizeH = ((BattleArena)arena).getHeight();
            if (this.x < 0)
                this.x = 0;
            if (this.z < 0)
                this.z = 0;
            if (this.x > sizeW)
                this.x = sizeW;
            if (this.z > sizeH)
                this.z = sizeH;
        }
    }

    @Override
    public void Update(float deltaTime) {
        Move(velX * deltaTime, velZ * deltaTime);
    }

    @Override
    public void Apply() {
        ModelThing arena = Model.getInst().getThing(arenaID);
        if (arena instanceof BattleArena) {
            ViewThing characterView = View.getInst().getThing(viewThingID);
            if (velX != 0)
                characterView.setFlip(velX < 0);
            characterView.setPos(x, z * 0.3f + y);
        }
    }
}