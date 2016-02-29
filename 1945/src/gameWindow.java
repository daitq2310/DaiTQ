import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Cursor;
import java.awt.event.*;
import java.awt.geom.CubicCurve2D;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Quang Đại on 28/2/2016.
 */
public class gameWindow extends Frame implements Runnable, KeyListener, MouseMotionListener {
    //smooth moving image
    //start
    Graphics seconds;
    Image image;
    //end

    BufferedImage backGround;
    Plane p1, p2;
    Bullet b1;
    ShootBullet sb1;

    public gameWindow() {
        this.setTitle("1945");
        this.setSize(400, 640);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);

        this.setResizable(false);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        p1 = new Plane();
        p2 = new Plane();
        b1 = new Bullet();
        Point pointCursor = new Point(0, 0);
        BufferedImage cursorImage = new BufferedImage(1, 1, BufferedImage.TRANSLUCENT);
        Cursor invisibleCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, pointCursor, "InvisibleCursor");
        setCursor(invisibleCursor);

        p1.setSpeed(3);
        //sb1 = new ShootBullet(this);

        try {
            backGround = ImageIO.read(new File("Resources/Background.png"));
            p1.setSprite(ImageIO.read(new File("Resources/PLANE1.png")));
            p2.setSprite(ImageIO.read(new File("Resources/PLANE2.png")));
            b1.setBulletSprite(ImageIO.read(new File("Resources/DAN.png")));
        } catch (Exception e) {

        }
        this.addKeyListener(this);
        this.addMouseMotionListener(this);
        p1.setPositionX((getWidth() - p1.getSprite().getWidth() / 2) / 2 - 100);
        p1.setPositionY((getHeight() - p1.getSprite().getHeight() / 2) / 2 + 150);
        p2.setPositionX((getWidth() - p2.getSprite().getWidth() / 2) / 2 + 100);
        p2.setPositionY((getHeight() - p2.getSprite().getHeight() / 2) / 2 + 150);

        repaint();

        b1.setBulletX(p1.getPositionX() + p1.getSprite().getWidth() / 2 - b1.getBulletSprite().getWidth() / 2);
        b1.setBulletY(p1.getPositionY() - p1.getSprite().getHeight() / 2);
    }

    @Override
    public void update(Graphics graphics) {
        if (image == null) {
            image = createImage(this.getWidth(), this.getHeight());
            seconds = image.getGraphics();
        }
        seconds.setColor(getBackground());
        seconds.fillRect(0, 0, getWidth(), getHeight());
        seconds.setColor(getForeground());
        paint(seconds);
        graphics.drawImage(image, 0, 0, null);
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawImage(backGround, 0, 0, null);
        p1.draw(graphics);
        p2.draw(graphics);
        b1.draw(graphics);
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyChar() == 'w') {
            p1.setDirection(3);
        }
        if (keyEvent.getKeyChar() == 's') {
            p1.setDirection(4);
        }
        if (keyEvent.getKeyChar() == 'a') {
            p1.setDirection(1);
        }
        if (keyEvent.getKeyChar() == 'd') {
            p1.setDirection(2);
        }
        if (keyEvent.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.println("5");

            //sb1.addBullet(p1.getSprite().getWidth(),p1.getSprite().getHeight());

        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        p1.setDirection(0);
    }

    @Override
    public void run() {
        while (true) {
            repaint();
            p1.update();

            b1.update();
            repaint();
            try {
                Thread.sleep(1000 / 6);
            } catch (InterruptedException e) {
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        p2.setPositionX(mouseEvent.getX());
        p2.setPositionY(mouseEvent.getY());
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}

