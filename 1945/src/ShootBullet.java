
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

/**
 * Created by Quang Đại on 29/2/2016.
 */
public class ShootBullet {
    private LinkedList<Bullet> listBullet = new LinkedList<>();
    Bullet bullet;
    gameWindow game;

    private void move() {
        for (int i = 0; i < listBullet.size(); i++) {
            bullet = listBullet.get(i);
            if (bullet.getBulletY() < 0) {
                deleBullet(bullet);
            }
            bullet.update();
        }
    }

    public ShootBullet(gameWindow game, Bullet bullet) {
        this.game = game;
        this.bullet=bullet;
    }

    public void draw(Graphics g) {
        for (int i = 0; i < listBullet.size(); i++) {
            bullet = listBullet.get(i);
            bullet.draw(g);
        }
    }

    public void update() {
        move();
    }

    public void addBullet(Bullet newBullet) {
        listBullet.add(newBullet);
    }

    public void deleBullet(Bullet oldBullet) {
        listBullet.remove(oldBullet);
    }
}
