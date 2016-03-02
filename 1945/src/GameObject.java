import java.awt.image.BufferedImage;

/**
 * Created by Quang Đại on 1/3/2016.
 */
public abstract class GameObject {
    protected int positionX, positionY;
    public BufferedImage sprite;

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }
}
