import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Quang Đại on 29/2/2016.
 */
public class Bullet extends GameObject {

    private int speed, typeBullet;

    private Bullet() {
        this.positionX = 0;
        this.positionY = 0;
    }

    public Bullet(int positionX, int positionY, int speed, int typeBullet) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.speed = speed;
        switch (typeBullet) {
            case 1:
                try {
                    this.sprite = ImageIO.read(new File("Resources/Dan1.png"));
                } catch (IOException e) {

                }
                break;
            case 2:
                try {
                    this.sprite = ImageIO.read(new File("Resources/Dan2.png"));
                } catch (IOException e) {

                }
                break;
        }
    }

    private void move() {
        this.positionY -= this.speed;
    }

    public void draw(Graphics g) {
        g.drawImage(this.sprite, this.positionX, this.positionY, null);
    }

    public void update() {
        this.move();
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setTypeBullet(int typeBullet) {
        this.typeBullet = typeBullet;
    }

    public int getTypeBullet() {

        return typeBullet;
    }

    public int getPositionY() {
        return positionY;
    }
}
