package ru.vav.fighting.modelthings;

import ru.vav.fighting.MaterialManager;
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

    protected View view = View.getInst();
    protected Model model = Model.getInst();
    private Integer IdleMaterialID;
    private Integer WalkMaterialID;
    private Integer PunchMaterialID;
    private Integer BlockMaterialID;

    private int currentAnim;

    public Character(String charName) {
        this.charName = charName;
        Integer index = 0;
        while ((viewThingID = view.addThing("char_" + charName + postfix, new ViewThing())) == 0 ) {
            postfix = "_" + index++;
        }
        ViewThing player = view.getThing(viewThingID);
        IdleMaterialID = MaterialManager.getInst().getID(charName + "_idle");
        WalkMaterialID = MaterialManager.getInst().getID(charName + "_walk");
        PunchMaterialID = MaterialManager.getInst().getID(charName + "_punch");
        BlockMaterialID = MaterialManager.getInst().getID(charName + "_block");
        currentAnim = IdleMaterialID;
        player.setMaterial(MaterialManager.getInst().getMaterial(currentAnim));
        player.setSize(100, 200);
        arenaID = View.getInst().getID("Arena");
        x = 0;
        y = 0;
        z = 0;
    }

    protected void Move(float x, float z) {
        ModelThing arena = Model.getInst().getThing(arenaID);
        if (arena instanceof BattleArena) {
            this.x += x;
            this.z += z;
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
        Move(velX * deltaTime * 10, velZ * deltaTime * 10);
    }

    @Override
    public void Apply() {
        ModelThing arena = Model.getInst().getThing(arenaID);
        if (arena instanceof BattleArena) {
            ViewThing characterView = View.getInst().getThing(viewThingID);
            if (velX != 0)
                characterView.setFlip(velX < 0);
            characterView.setPos(x, z + y);
            characterView.setZOrder(z);
            if ((velX != 0) || (velZ != 0))
                SetMaterial(WalkMaterialID);
            else
                SetMaterial(IdleMaterialID);
        }
    }
    private void SetMaterial(int ID) {
        if (ID != currentAnim) {
            View.getInst().getThing(viewThingID).setMaterial(MaterialManager.getInst().getMaterial(ID));
            currentAnim = ID;
        }
    }
}