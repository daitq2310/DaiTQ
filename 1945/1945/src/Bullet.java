import javafx.scene.transform.Rotate;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

/**
 * Created by Quang Đại on 29/2/2016.
 */
public class Bullet extends GameObject {

    private int speed, typeBullet, typeMove;

    private Bullet() {
        this.positionX = 0;
        this.positionY = 0;
    }

    public Bullet(int positionX, int positionY, int speed, int typeBullet, int typeMove) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.speed = speed;
        this.typeMove = typeMove;
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

    public void move() {
        if (this.typeMove == 1) {
            this.positionY -= this.speed;
        } else if (this.typeMove == 2) {
            this.positionX -= 4;
            this.positionY += 4;
        } else if (this.typeMove == 3) {
            this.positionX += 4;
            this.positionY += 4;
        }
    }

    @Override
    public void update() {
        this.move();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(getSprite(), (int) this.positionX, (int) this.positionY, null);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getTypeBullet() {
        return typeBullet;
    }

    public void setTypeBullet(int typeBullet) {
        this.typeBullet = typeBullet;
    }

    public int getTypeMove() {
        return typeMove;
    }

    public void setTypeMove(int typeMove) {
        this.typeMove = typeMove;
    }
}
