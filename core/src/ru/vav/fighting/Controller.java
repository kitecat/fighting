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
            case Input.Keys.T:
                model.SendMessage(Messages.Player1, Messages.Punch);
                break;
            case Input.Keys.Y:
                model.SendMessage(Messages.Player1, Messages.Block);
                break;
            case Input.Keys.UP:
                model.SendMessage(Messages.Player2, Messages.DirUp);
                break;
            case Input.Keys.LEFT:
                model.SendMessage(Messages.Player2, Messages.DirLeft);
                break;
            case Input.Keys.DOWN:
                model.SendMessage(Messages.Player2, Messages.DirDown);
                break;
            case Input.Keys.RIGHT:
                model.SendMessage(Messages.Player2, Messages.DirRight);
                break;
            case Input.Keys.SLASH:
                model.SendMessage(Messages.Player2, Messages.Punch);
                break;
            case Input.Keys.PERIOD:
                model.SendMessage(Messages.Player2, Messages.Block);
                break;
        }
    }

    public void KeyUp(int keycode) {

        switch (keycode) {
            case Input.Keys.W:
                model.SendMessage(Messages.Player1, Messages.StopUp);
                break;
            case Input.Keys.A:
                model.SendMessage(Messages.Player1, Messages.StopLeft);
                break;
            case Input.Keys.S:
                model.SendMessage(Messages.Player1, Messages.StopDown);
                break;
            case Input.Keys.D:
                model.SendMessage(Messages.Player1, Messages.StopRight);
                break;
            case Input.Keys.UP:
                model.SendMessage(Messages.Player2, Messages.StopUp);
                break;
            case Input.Keys.LEFT:
                model.SendMessage(Messages.Player2, Messages.StopLeft);
                break;
            case Input.Keys.DOWN:
                model.SendMessage(Messages.Player2, Messages.StopDown);
                break;
            case Input.Keys.RIGHT:
                model.SendMessage(Messages.Player2, Messages.StopRight);
                break;
        }

    }
}
