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
public abstract class Bullet extends GameObject {

    protected int speed;

    private Bullet() {
        this.positionX = 0;
        this.positionY = 0;
    }

    public Bullet(int positionX, int positionY, int speed) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.speed = speed;
    }

    public void move() {
    }

    @Override
    public void update() {
    }

    @Override
    public void draw(Graphics g) {
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
