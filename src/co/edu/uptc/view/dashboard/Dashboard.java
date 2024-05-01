package co.edu.uptc.view.dashboard;

import co.edu.uptc.pojo.BulletPojo;
import co.edu.uptc.pojo.CannonPojo;
import co.edu.uptc.util.SleepUtil;
import co.edu.uptc.view.ManagerView;
import org.w3c.dom.CDATASection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Dashboard extends JPanel {

    private CannonPojo cannonPojo = new CannonPojo();
    private BulletPojo bulletPojo = new BulletPojo();
    private ManagerView managerView;

    public Dashboard() {
        initComponents();
        moveCannon();
    }

    public void initPojo() {
        cannonPojo = managerView.presenter.getCannonPojo();
        bulletPojo = managerView.presenter.getBulletPojo();
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
                        SleepUtil.sleep(1);
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
            }}

        if (bulletPojo != null && bulletPojo.getCoordinateY() >= 0) {
            g.setColor(Color.RED);
            g.fillOval(bulletPojo.getCoordinateX(), bulletPojo.getCoordinateY(), bulletPojo.getWidth(), bulletPojo.getHeight());
        }else {
            bulletPojo = null;
        }
        g.setColor(Color.BLACK);
        g.fillRect(cannonPojo.getCoordinateX(), cannonPojo.getCoordinateY(), cannonPojo.getWidth(), cannonPojo.getHeight());


    }

    public void moveCannon() {
        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    managerView.presenter.moveCannonLeft();
                } else if (e.getKeyCode() == KeyEvent.VK_D) {
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
