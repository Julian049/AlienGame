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
import java.util.ArrayList;

public class DashboardView extends JPanel {

    private CannonPojo cannonPojo = new CannonPojo();
    private BulletPojo bulletPojo = new BulletPojo();
    private ManagerView managerView;
    private ArrayList<AlienPojo> aliens;

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
            g.setColor(Color.RED);
            g.fillOval(bulletPojo.getCoordinateX(), bulletPojo.getCoordinateY(), bulletPojo.getWidth(), bulletPojo.getHeight());

            if (bulletPojo.getCoordinateY() <= 0) {
                g.setColor(getBackground());
                g.fillOval(bulletPojo.getCoordinateX(), bulletPojo.getCoordinateY(), bulletPojo.getWidth(), bulletPojo.getHeight());
                bulletPojo = null;
            }
        }
        g.setColor(Color.BLACK);
        g.fillRect(cannonPojo.getCoordinateX(), cannonPojo.getCoordinateY(), cannonPojo.getWidth(), cannonPojo.getHeight());

        for (AlienPojo alien : aliens) {
            g.setColor(Color.GREEN);
            g.fillOval(alien.getCoordinateX(), alien.getCoordinateY(), alien.getWidth(), alien.getHeight());
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
