import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Quang Đại on 1/3/2016.
 */
public abstract class GameObject {
    protected double positionX, positionY;
    public BufferedImage sprite;

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public abstract void update();

    public abstract void draw(Graphics g);
}
