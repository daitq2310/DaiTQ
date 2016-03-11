import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Quang Đại on 28/2/2016.
 */
public class Plane extends PlaneAbstract implements Subject {
    private Vector<Observer> observerVector = new Vector<>();

    private Plane() {
        this.positionX = 0;
        this.positionY = 0;
        this.speed = 0;
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
                }
                break;
            case 2:
                try {
                    this.sprite = ImageIO.read(new File("Resources/Plane2.png"));
                } catch (IOException e) {
                }
                break;
            case 3:
                try {
                    this.sprite = ImageIO.read(new File("Resources/Plane3.png"));
                } catch (IOException e) {
                }
                break;
            case 4:
                try {
                    this.sprite = ImageIO.read(new File("Resources/Plane4.png"));
                } catch (IOException e) {
                }
                break;
            case 5:
                try {
                    this.sprite = ImageIO.read(new File("Resources/PlaneEnemy1.png"));
                } catch (IOException e) {
                }
                break;
            case 6:
                try {
                    this.sprite = ImageIO.read(new File("Resources/PlaneEnemy2.png"));
                } catch (IOException e) {
                }
                break;
        }
    }

    @Override
    public void shoot() {
        BulletPlayer b = new BulletPlayer((int) this.positionX + 25, (int) this.getPositionY(), 10);
        vecBul.add(b);
    }

    private Vector<BulletPlayer> vecBul = new Vector<>();

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

    @Override
    public void draw(Graphics g) {
        g.drawImage(sprite, (int) positionX, (int) positionY, null);
        for (BulletPlayer bul : vecBul) {
            bul.draw(g);
        }
    }

    @Override
    public void update() {
        this.move();
        for (BulletPlayer bul : vecBul) {
            bul.update();
        }
    }

    public int getWidth() {
        return sprite.getWidth();
    }

    public int getHeight() {
        return sprite.getHeight();
    }

    @Override
    public void addObserver(Observer ob) {
        observerVector.add(ob);
    }

    @Override
    public void removeObserver(Observer ob) {
        observerVector.remove(ob);
    }

    @Override
    public void notifiObserver() {
        if (true) {
            for (Observer ob : observerVector) {
                ob.update("Bo Vua An Duoc Qua");
            }
        }
    }
}
