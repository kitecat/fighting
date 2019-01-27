package ru.vav.fighting.modelthings;

public class Player extends Character {

    public Player(String charName) {
        super(charName);
    }

    public void setVelosity(float x, float z) {
        velX = x;
        velZ = z;
    }

    @Override
    public void Update(float deltaTime) {
        Move(velX * deltaTime * 200, velZ * deltaTime * 200);
    }
}
