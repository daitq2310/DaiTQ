import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Quang Đại on 1/3/2016.
 */
public class PlaneEnemy extends PlaneAbstract {
    private int count = 0, shootType, e = 0, styleMove;
    private Vector<Bullet> vecBul = new Vector<Bullet>();

    private PlaneEnemy() {

    }

    public PlaneEnemy(int positionX, int positionY, int speed, int planeType, int shootType, int styleMove) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.speed = speed;
        this.shootType = shootType;
        this.styleMove = styleMove;
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
        if (this.positionX >= 1000 - this.getSprite().getWidth()) {
            this.speed = -this.speed;
        }

        //circle ellipse example
//        this.positionX += 4*Math.sin(45);
//        this.positionY += 4*Math.cos(45);
    }

    public void moveCircleEllipse() {
        e++;
        this.positionX += 15 * Math.sin(e * 0.05);
        this.positionY += 4 * Math.cos(e * 0.05);
    }

    public void moveSineWave() {
        e++;
        this.positionY += 2 * Math.sin(e * 0.04);
        this.positionX += this.speed;
        if (this.positionX <= 0) {

            this.positionY -= 2 * Math.sin(e * 0.04);
            this.speed = -this.speed;
        }
        if (this.positionX >= 1000 - this.sprite.getWidth()) {
            this.positionY -= 2 * Math.sin(e * 0.04);
            this.speed = -this.speed;
        }
    }

    @Override
    public void update() {//60 lan 1 giay
        count++;
        if (count >= 90) {
            this.shoot();
            count = 0;
        }
        for (Bullet bul : vecBul) {
            bul.update();
        }
        if (styleMove == 1)
            this.move();
        if (styleMove == 2)
            this.moveCircleEllipse();
        if (styleMove == 3)
            this.moveSineWave();
    }

    @Override
    public void draw(Graphics g) {
        for (Bullet bul : vecBul) {
            bul.draw(g);
        }
        g.drawImage(sprite, (int) this.positionX, (int) this.positionY, null);
    }

    @Override
    public void shoot() {
        if (this.shootType == 1) {
            Bullet bullet = new Bullet((int) this.positionX + 20, (int) this.positionY + 23, -7, 1, 1);
            vecBul.add(bullet);
        } else if (this.shootType == 2) {
            Bullet bullet = new Bullet((int) this.positionX + 20, (int) this.positionY + 23, -7, 1, 1);
            Bullet bullet2 = new Bullet((int) this.positionX + 20, (int) this.positionY + 60, -7, 1, 1);
            vecBul.add(bullet);
            vecBul.add(bullet2);
        } else if (this.shootType == 3) {
            Bullet bullet = new Bullet((int) this.positionX + 20, (int) this.positionY + 23, -7, 1, 1);
            Bullet bullet2 = new Bullet((int) this.positionX + 20, (int) this.positionY + 23, 2, 1, 2);
            Bullet bullet3 = new Bullet((int) this.positionX + 20, (int) this.positionY + 23, 2, 1, 3);
            vecBul.add(bullet);
            vecBul.add(bullet2);
            vecBul.add(bullet3);
        }
    }


    public int getShootType() {
        return shootType;
    }

    public void setShootType(int shootType) {
        this.shootType = shootType;
    }
}