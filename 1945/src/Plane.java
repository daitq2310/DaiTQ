import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Quang Đại on 28/2/2016.
 */
public class Plane {
    private int plane, positionX, positionY, damage, health, speed, direction, status;
    private BufferedImage sprite;

    private void move() {
        if (direction == 0) {
        } else if (direction == 1) {
            this.positionX -= this.speed;
        } else if (direction == 2) {
            this.positionX += this.speed;
        } else if (direction == 3) {
            this.positionY -= this.speed;
        } else if (direction == 4) {
            this.positionY += this.speed;
        }
    }

    public void draw(Graphics g) {
        g.drawImage(this.sprite, this.positionX, this.positionY, null);
    }

    public void update() {
        move();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setPlane(int plane) {
        this.plane = plane;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public int getDamage() {
        return damage;
    }

    public int getDirection() {
        return direction;
    }

    public int getHealth() {
        return health;
    }

    public int getPlane() {
        return plane;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
