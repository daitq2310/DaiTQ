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

    private int speed, typeBullet;
    private double x, y, angel;

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

    public void moveForward() {
        x += Math.cos(this.angel) * this.speed;
        y += Math.sin(this.angel) * this.speed;
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

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {

        return x;
    }

    public double getY() {
        return y;
    }

    public double getAngel() {
        return angel;
    }

    public void setAngel(double angel) {
        this.angel = angel;
    }
}
