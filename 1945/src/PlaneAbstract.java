/**
 * Created by Quang Đại on 2/3/2016.
 */
public abstract class PlaneAbstract extends GameObject {
    protected int planeModel, damage, health, speed, direction, planeType;

    public int getPlaneModel() {
        return planeModel;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setPlaneModel(int planeModel) {
        this.planeModel = planeModel;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setPlaneType(int planeType) {
        this.planeType = planeType;
    }

    public int getPlaneType() {
        return planeType;
    }
}
