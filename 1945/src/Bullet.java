import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Quang Đại on 29/2/2016.
 */
public class Bullet {
    private int bullet, bulletX, bulletY;
    private BufferedImage bulletSprite;

//    public Bullet(int bulletX, int bulletY) {
//        this.bulletX = bulletX;
//        this.bulletY = bulletY;
//    }

    private void move() {
        this.bulletY -= 10;
    }

    public void draw(Graphics g) {
        g.drawImage(this.bulletSprite, this.bulletX, this.bulletY, null);
    }

    public void update() {
        move();
    }

    public void setBullet(int bullet) {
        this.bullet = bullet;
    }

    public void setBulletSprite(BufferedImage bulletSprite) {
        this.bulletSprite = bulletSprite;
    }

    public void setBulletX(int bulletX) {
        this.bulletX = bulletX;
    }

    public void setBulletY(int bulletY) {
        this.bulletY = bulletY;
    }

    public BufferedImage getBulletSprite() {
        return bulletSprite;
    }

    public int getBullet() {
        return bullet;
    }


    public int getBulletX() {
        return bulletX;
    }

    public int getBulletY() {
        return bulletY;
    }
}
