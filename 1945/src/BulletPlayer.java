import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Quang Đại on 10/3/2016.
 */
public class BulletPlayer extends Bullet {
    private Vector<PlaneEnemy> planeEnemyVector = PlaneEnemyManager.getInstance().getPlaneEnemyVector();
    private Vector<RandomBird> randomBirdVector = RandomBirdManager.getInstance().getRandomBirdVector();

    public BulletPlayer(int positionX, int positionY, int speed) {
        super(positionX, positionY, speed);
        try {
            this.sprite = ImageIO.read(new File("Resources/Dan2.png"));
        } catch (IOException e) {
        }
    }

    public void checkCollision() {
        Rectangle rectBullet = new Rectangle((int) positionX, (int) positionY, sprite.getWidth(), sprite.getHeight());
        for (int i = 0; i < planeEnemyVector.size() ; i++) {
            Rectangle rectPlaneEnemy = new Rectangle((int) planeEnemyVector.get(i).getPositionX()
                    , (int) planeEnemyVector.get(i).getPositionY()
                    , planeEnemyVector.get(i).getSprite().getWidth()
                    , planeEnemyVector.get(i).getSprite().getHeight());

            if (rectBullet.intersects(rectPlaneEnemy)) {
                planeEnemyVector.remove(i);
            }
        }
        for (int i = 0; i < randomBirdVector.size() ; i++){
            Rectangle rectRandomBird = new Rectangle((int) randomBirdVector.get(i).getPositionX()
                    , (int) randomBirdVector.get(i).getPositionY()
                    , randomBirdVector.get(i).getSprite().getWidth()
                    , randomBirdVector.get(i).getSprite().getHeight());
            if(rectBullet.intersects(rectRandomBird)){
                randomBirdVector.remove(i);
            }
        }
    }


    @Override
    public void move() {
        this.positionY -= this.speed;
    }

    @Override
    public void update() {
        this.move();
        checkCollision();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(sprite, (int) this.positionX, (int) this.positionY, null);
    }
}
