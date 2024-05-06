package co.edu.uptc.view.dashboard;

import co.edu.uptc.pojo.AlienPojo;
import co.edu.uptc.pojo.BulletPojo;
import co.edu.uptc.pojo.CannonPojo;
import co.edu.uptc.util.SleepUtil;
import co.edu.uptc.util.ViewPropertiesUtil;
import co.edu.uptc.view.ManagerView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.CopyOnWriteArrayList;


public class DashboardView extends JPanel {

    private CannonPojo cannonPojo = new CannonPojo();
    private BulletPojo bulletPojo = new BulletPojo();
    private ManagerView managerView;
    private CopyOnWriteArrayList<AlienPojo> aliens;

    public DashboardView() {
        initComponents();
        moveCannon();
    }

    public void initPojo() {
        cannonPojo = managerView.presenter.getCannonPojo();
        bulletPojo = managerView.presenter.getBulletPojo();
        aliens = managerView.presenter.getAliens();
    }

    public void setManagerView(ManagerView managerView) {
        this.managerView = managerView;
    }

    private void initComponents() {
        this.setBackground(Color.BLACK);
    }

    public void threadPaint() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    SleepUtil.sleep(ViewPropertiesUtil.PAINT_SPEED_THREAD);
                    initPojo();
                    repaint();
                }
            }
        });
        thread.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (bulletPojo != null) {
            ImageIcon bullet = new ImageIcon("img/cannonball.png");
            bullet = new ImageIcon(bullet.getImage().getScaledInstance(bulletPojo.getWidth(), bulletPojo.getHeight(), Image.SCALE_FAST));
            g.drawImage(bullet.getImage(), bulletPojo.getCoordinateX(), bulletPojo.getCoordinateY(), null);

            if (bulletPojo.getCoordinateY() <= 0) {
                g.setColor(getBackground());
                g.fillOval(bulletPojo.getCoordinateX(), bulletPojo.getCoordinateY(), bulletPojo.getWidth(), bulletPojo.getHeight());
                bulletPojo = null;
            }
        }
        ImageIcon cannon = new ImageIcon("img/cannon.png");
        cannon = new ImageIcon(cannon.getImage().getScaledInstance(cannonPojo.getWidth(), cannonPojo.getHeight(), Image.SCALE_FAST));
        g.drawImage(cannon.getImage(), cannonPojo.getCoordinateX(), cannonPojo.getCoordinateY(), null);



        for (AlienPojo alien : aliens) {
            ImageIcon alienIcon = new ImageIcon("img/alien.png");
            alienIcon = new ImageIcon(alienIcon.getImage().getScaledInstance(alien.getWidth(), alien.getHeight(), Image.SCALE_FAST));
            g.drawImage(alienIcon.getImage(), alien.getCoordinateX(), alien.getCoordinateY(), null);

        }

    }

    public void moveCannon() {
        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    managerView.presenter.moveCannonLeft();
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    managerView.presenter.moveCannonRight();
                } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    managerView.presenter.shoot();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        this.addKeyListener(keyListener);
        this.setFocusable(true);
    }
}
