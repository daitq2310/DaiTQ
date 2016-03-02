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
    Plane planeMoveByKey, planeMoveByMouse;
    Vector<PlaneEnemy> vectorPlaneEnemy = new Vector<PlaneEnemy>();

    public GameWindow() {

        this.setTitle("1945");
        this.setSize(400, 640);
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
            background = ImageIO.read(new File("Resources/Background.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        initPlane();

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getModifiers() == InputEvent.BUTTON1_MASK) {
                    planeMoveByMouse.shoot();

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
                planeMoveByMouse.move(e.getX(), e.getY());
            }
        });

        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    planeMoveByKey.setDirection(3);
                } else if (e.getKeyCode() == KeyEvent.VK_D) {
                    planeMoveByKey.setDirection(4);
                } else if (e.getKeyCode() == KeyEvent.VK_W) {
                    planeMoveByKey.setDirection(1);
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    planeMoveByKey.setDirection(2);
                } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    planeMoveByKey.shoot();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                planeMoveByKey.setDirection(0);
            }
        });
    }

    private void initPlane() {

        planeMoveByKey = new Plane(200, 200, 3, 4);
        planeMoveByMouse = new Plane(300, 300, 4, 2);
        vectorPlaneEnemy.add(new PlaneEnemy(200, 200, 1));
        vectorPlaneEnemy.add(new PlaneEnemy(150, 100, 2));
        vectorPlaneEnemy.add(new PlaneEnemy(100, 150, 3));
        vectorPlaneEnemy.add(new PlaneEnemy(250, 120, 4));
        vectorPlaneEnemy.add(new PlaneEnemy(300, 90, 5));

    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(background, 0, 0, null);
        planeMoveByKey.draw(g);
        planeMoveByMouse.draw(g);
        for (PlaneEnemy planeEnemy : vectorPlaneEnemy) {
            planeEnemy.draw(g);
        }
        repaint();
       }


    @Override
    public void run() {
        while (true) {
            planeMoveByKey.update();
            planeMoveByMouse.update();
            for (PlaneEnemy planeEnemy : vectorPlaneEnemy) {
                planeEnemy.update();
            }
            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}