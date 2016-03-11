import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Quang Đại on 1/3/2016.
 */
public class PlaneEnemy extends PlaneAbstract implements Observer {
    private int count = 0, shootType, e = 0, styleMove;
    private Vector<BulletEnemy> vecBul = new Vector<>();

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
                }
                break;
            case 2:
                try {
                    this.sprite = ImageIO.read(new File("Resources/PlaneEnemy2.png"));
                } catch (IOException e) {
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
        for (BulletEnemy bul : vecBul) {
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
        for (BulletEnemy bul : vecBul) {
            bul.draw(g);
        }
        g.drawImage(sprite, (int) this.positionX, (int) this.positionY, null);
    }

    @Override
    public void shoot() {
        if (this.shootType == 1) {
            BulletEnemy bullet = new BulletEnemy((int) this.positionX + 20, (int) this.positionY + 23, -7, 1);
            vecBul.add(bullet);
        } else if (this.shootType == 2) {
            BulletEnemy bullet = new BulletEnemy((int) this.positionX + 20, (int) this.positionY + 23, -7, 1);
            BulletEnemy bullet2 = new BulletEnemy((int) this.positionX + 20, (int) this.positionY + 60, -7, 1);
            vecBul.add(bullet);
            vecBul.add(bullet2);
        } else if (this.shootType == 3) {
            BulletEnemy bullet = new BulletEnemy((int) this.positionX + 20, (int) this.positionY + 23, -7, 1);
            BulletEnemy bullet2 = new BulletEnemy((int) this.positionX + 20, (int) this.positionY + 23, 2, 2);
            BulletEnemy bullet3 = new BulletEnemy((int) this.positionX + 20, (int) this.positionY + 23, 2, 3);
            vecBul.add(bullet);
            vecBul.add(bullet2);
            vecBul.add(bullet3);
        }
    }

    @Override
    public void update(String msg) {
        if (msg.equalsIgnoreCase("Bo Vua An Duoc Qua")) {
            System.out.println("Thang Player Vua An Duoc Qua Roi");
        }
    }

    public int getWidth() {
        return this.sprite.getWidth();
    }

    public int getHeight() {
        return this.sprite.getHeight();
    }
}