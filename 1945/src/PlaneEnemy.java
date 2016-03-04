import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Quang Đại on 1/3/2016.
 */
public class PlaneEnemy extends PlaneAbstract {
    private int count = 0;
    private Vector<Bullet> vecBul = new Vector<Bullet>();

    private PlaneEnemy() {

    }

    public void shoot() {
        Bullet bullet1 = new Bullet(positionX + 30 + 10, positionY + 59, -5, 1);
        Bullet bullet2 = new Bullet(positionX + 30 - 10, positionY + 59, -5, 1);
        vecBul.add(bullet1);
        vecBul.add(bullet2);
    }

    public PlaneEnemy(int positionX, int positionY, int speed, int planeType) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.speed = speed;
        switch (planeType) {
            case 1:
                try {
                    this.sprite = ImageIO.read(new File("Resources/PlaneEnemy1.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    this.sprite = ImageIO.read(new File("Resources/PlaneEnemy2.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public void move() {
        this.positionX += this.speed;
        if (this.positionX <= 0) {
            this.speed = -this.speed;
        }
        if (this.positionX >= 400-this.getSprite().getWidth()) {
            this.speed = -this.speed;
        }

        //circle ellipse example
//        this.positionX += 4*Math.sin(45);
//        this.positionY += 4*Math.cos(45);
    }

    public void update() {//60 lan 1 giay
        count++;
        if (count >= 90) {
            this.shoot();
            count = 0;
        }
        for (Bullet bul : vecBul) {
            bul.update();
        }
        move();
    }

    public void draw(Graphics g) {
        for (Bullet bul : vecBul) {
            bul.draw(g);
        }
        g.drawImage(sprite, positionX, positionY, null);
    }
}