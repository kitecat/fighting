package ru.vav.fighting;

public class Model {

    private static Model inst = new Model();

    public void SendMessage(int msgID, int Message) {

    }

    public static Model getInst() {
        return inst;
    }
}
