import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Quang Đại on 28/2/2016.
 */
public class Plane extends PlaneAbstract {

    private Plane() {
        this.positionX = 0;
        this.positionY = 0;
        this.speed = 0;
        try {
            this.sprite = ImageIO.read(new File("Resources/Plane1.png"));
        } catch (IOException e) {
        }
    }

    public Plane(int positionX, int positionY, int speed, int planeType) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.speed = speed;
        switch (planeType) {
            case 1:
                try {
                    this.sprite = ImageIO.read(new File("Resources/Plane1.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    this.sprite = ImageIO.read(new File("Resources/Plane2.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    this.sprite = ImageIO.read(new File("Resources/Plane3.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                try {
                    this.sprite = ImageIO.read(new File("Resources/Plane4.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 5:
                try {
                    this.sprite = ImageIO.read(new File("Resources/PlaneEnemy1.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 6:
                try {
                    this.sprite = ImageIO.read(new File("Resources/PlaneEnemy2.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public void shoot() {
        Bullet b = new Bullet(this.positionX + 25, this.getPositionY(), 10, 2);
        vecBul.add(b);
    }

    private Vector<Bullet> vecBul = new Vector<Bullet>();

    public void move(int x, int y) {
        this.positionX = x;
        this.positionY = y;
    }

    private void move() {
        switch (direction) {
            case 0:

                break;
            case 1:
                this.positionY -= this.speed;
                break;
            case 2:
                this.positionY += this.speed;
                break;
            case 3:
                this.positionX -= this.speed;
                break;
            case 4:
                this.positionX += this.speed;
                break;
        }
    }

    public void draw(Graphics g) {
        g.drawImage(sprite, positionX, positionY, null);
        for (Bullet bul : vecBul) {
            bul.draw(g);
        }
    }

    public void update() {
        this.move();
        for (Bullet bul : vecBul) {
            bul.update();
        }
    }
}
