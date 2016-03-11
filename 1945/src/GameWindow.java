import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Quang Đại on 28/2/2016.
 */
public class GameWindow extends Frame implements Runnable {
    //smooth moving image
    //start
    Graphics seconds;
    Image image;

    @Override
    public void update(Graphics g) {
        if (image == null) {
            image = createImage(this.getWidth(), this.getHeight());
            seconds = image.getGraphics();
        }
        seconds.setColor(getBackground());
        seconds.fillRect(0, 0, getWidth(), getHeight());
        seconds.setColor(getForeground());
        paint(seconds);
        g.drawImage(image, 0, 0, null);
    }
    //end

    BufferedImage background;
    Vector<PlaneEnemy> vectorPlaneEnemy;
    Vector<OtherObject> vectorObject = new Vector<>();
    Vector<RandomBird> vectorBird = new Vector<>();
    BulletEnemy b;
    Vector<GiftBox> giftBoxVector = new Vector<>();
    GiftBox giftBox;

    public GameWindow() {

        this.setTitle("1945");
        this.setSize(1000, 700);
        //-------------------------------------------------------
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);
        //-------------------------------------------------------
        this.setResizable(false);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        //-------------------------------------------------------
        Point pointCursor = new Point(0, 0);
        BufferedImage cursorImage = new BufferedImage(1, 1, BufferedImage.TRANSLUCENT);
        Cursor invisibleCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, pointCursor, "InvisibleCursor");
        setCursor(invisibleCursor);
        //-------------------------------------------------------
        try {
            background = ImageIO.read(new File("Resources/Background1.jpg"));
        } catch (IOException e) {
        }
        vectorPlaneEnemy = PlaneEnemyManager.getInstance().getPlaneEnemyVector();
        initPlane();
        PlaneManager.getInstance().getPlaneMoveByKey().setHealth(200);
        PlaneManager.getInstance().getPlaneMoveByMouse().setHealth(200);

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getModifiers() == InputEvent.BUTTON1_MASK) {
                    PlaneManager.getInstance().getPlaneMoveByMouse().shoot();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                PlaneManager.getInstance().getPlaneMoveByMouse().move(e.getX(), e.getY());
            }
        });

        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    PlaneManager.getInstance().getPlaneMoveByKey().setDirection(3);
                } else if (e.getKeyCode() == KeyEvent.VK_D) {
                    PlaneManager.getInstance().getPlaneMoveByKey().setDirection(4);
                } else if (e.getKeyCode() == KeyEvent.VK_W) {
                    PlaneManager.getInstance().getPlaneMoveByKey().setDirection(1);
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    PlaneManager.getInstance().getPlaneMoveByKey().setDirection(2);
                } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    PlaneManager.getInstance().getPlaneMoveByKey().shoot();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                PlaneManager.getInstance().getPlaneMoveByKey().setDirection(0);
            }
        });
    }

    private void initPlane() {
        vectorPlaneEnemy.add(new PlaneEnemy(200, 200, 1, 1, 1, 1));
        vectorPlaneEnemy.add(new PlaneEnemy(150, 100, 2, 1, 2, 1));
        vectorPlaneEnemy.add(new PlaneEnemy(100, 150, 3, 2, 1, 2));
        vectorPlaneEnemy.add(new PlaneEnemy(250, 120, 4, 2, 3, 2));
        vectorPlaneEnemy.add(new PlaneEnemy(300, 90, 5, 2, 3, 1));
        vectorPlaneEnemy.add(new PlaneEnemy(200, 90, 5, 2, 1, 3));
        vectorPlaneEnemy.add(new PlaneEnemy(150, 90, 5, 1, 2, 3));
        vectorPlaneEnemy.add(new PlaneEnemy(100, 90, 5, 2, 3, 3));
        vectorPlaneEnemy.add(new PlaneEnemy(50, 90, 5, 1, 2, 3));
        vectorObject.add(new OtherObject(100, 550, 1));
        vectorObject.add(new OtherObject(800, 500, 2));
        vectorObject.add(new OtherObject(700, 450, 3));
        vectorObject.add(new OtherObject(100, 200, 3));
        vectorObject.add(new OtherObject(500, 10, 3));
        vectorBird.add(new RandomBird(20, 200));
        vectorBird.add(new RandomBird(100, 150));
        giftBoxVector.add(new GiftBox(100, 0, 3));
        giftBoxVector.add(new GiftBox(800, 0, 2));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(background, 0, 0, null);
        //--------------------------------------------
        g.setColor(Color.GRAY);
        g.fillRect(20, 40, 200, 30);
        g.setColor(Color.GREEN);
        g.fillRect(20, 40, PlaneManager.getInstance().getPlaneMoveByKey().getHealth(), 30);
        g.setColor(Color.WHITE);
        g.drawRect(20, 40, 200, 30);
        //--------------------------------------------
        g.setColor(Color.GRAY);
        g.fillRect(780, 40, 200, 30);
        g.setColor(Color.GREEN);
        g.fillRect(780, 40, PlaneManager.getInstance().getPlaneMoveByMouse().getHealth(), 30);
        g.setColor(Color.WHITE);
        g.drawRect(780, 40, 200, 30);
//        //--------------------------------------------
        for (OtherObject otherObject : vectorObject) {
            otherObject.draw(g);
        }

        for (RandomBird randomBird : vectorBird) {
            randomBird.draw(g);
        }

        for (GiftBox giftBox : giftBoxVector) {
            giftBox.draw(g);
        }

        PlaneManager.getInstance().getPlaneMoveByKey().draw(g);
        PlaneManager.getInstance().getPlaneMoveByMouse().draw(g);

        for (PlaneEnemy planeEnemy : vectorPlaneEnemy) {
            planeEnemy.draw(g);
        }
    }

    @Override
    public void run() {
        while (true) {
            for (OtherObject otherObject : vectorObject) {
                otherObject.update();
            }

            for (RandomBird randomBird : vectorBird) {
                randomBird.update();
            }

            for (PlaneEnemy planeEnemy : vectorPlaneEnemy) {
                planeEnemy.update();
            }

            for (GiftBox giftBox : giftBoxVector) {
                giftBox.update();
            }

            if(GiftBox.destroyAll){
                vectorPlaneEnemy.clear();
            }

            PlaneManager.getInstance().getPlaneMoveByKey().update();
            PlaneManager.getInstance().getPlaneMoveByMouse().update();
            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
            }
        }
    }
}