package ru.vav.fighting;

import com.badlogic.gdx.Input;

public class Controller {

    private Model model;

    public Controller() {
        model = Model.getInst();
    }

    public void keyDown(int keycode) {

        switch (keycode) {
            case Input.Keys.W:
                model.SendMessage(Messages.Player1, Messages.DirUp);
                break;
            case Input.Keys.A:
                model.SendMessage(Messages.Player1, Messages.DirLeft);
                break;
            case Input.Keys.S:
                model.SendMessage(Messages.Player1, Messages.DirDown);
                break;
            case Input.Keys.D:
                model.SendMessage(Messages.Player1, Messages.DirRight);
                break;
        }
    }
}
