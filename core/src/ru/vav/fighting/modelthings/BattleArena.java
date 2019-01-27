package ru.vav.fighting.modelthings;

import ru.vav.fighting.Model;
import ru.vav.fighting.View;
import ru.vav.fighting.ModelThing;
import ru.vav.fighting.ViewThing;

public class BattleArena implements ModelThing {

    private Integer viewThingID;
    private String postfix = "";
    private float width;
    private float height;

    private View view = View.getInst();
    private Model model = Model.getInst();

    public BattleArena() {
        viewThingID = view.addThing("Arena", new ViewThing());
    }

    public float getWidth() { return width; }
    public float getHeight() { return height; }

    @Override
    public void Update(float timeDelta) {

    }

    @Override
    public void Apply() {

    }
}