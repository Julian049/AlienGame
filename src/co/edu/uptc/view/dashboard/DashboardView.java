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
    private ManagerView managerView;
    private CopyOnWriteArrayList<AlienPojo> aliens;
    private CopyOnWriteArrayList<BulletPojo> bullets;

    public DashboardView() {
        initComponents();
        moveCannon();
    }

    public void initPojo() {
        cannonPojo = managerView.presenter.getCannonPojo();
        bullets = managerView.presenter.getBullets();
        aliens = managerView.presenter.getAliens();
    }

    public void setManagerView(ManagerView managerView) {
        this.managerView = managerView;
    }

    private void initComponents() {
        this.setBackground(Color.BLACK);
    }

    public void threadPaint() {
        Thread thread = new Thread(() -> {
            while (true) {
                SleepUtil.sleep(ViewPropertiesUtil.PAINT_SPEED_THREAD);
                initPojo();
                repaint();
            }
        });
        thread.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        ImageIcon background = new ImageIcon(ViewPropertiesUtil.BACKGROUND_IMAGE);
        background = new ImageIcon(background.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_FAST));
        g.drawImage(background.getImage(), 0, 0, null);
        paintBullets(g);
        paintCannon(g);
        paintAliens(g);
    }

    private void paintBullets(Graphics g) {
        for (BulletPojo bulletPojo : bullets) {
            if (bulletPojo != null) {
                ImageIcon bullet = new ImageIcon(ViewPropertiesUtil.BULLET_IMAGE);
                bullet = new ImageIcon(bullet.getImage().getScaledInstance(bulletPojo.getWidth(), bulletPojo.getHeight(), Image.SCALE_FAST));

                if (cannonPojo.getCoordinateY() > bulletPojo.getCoordinateY()) {
                    g.drawImage(bullet.getImage(), bulletPojo.getCoordinateX(), bulletPojo.getCoordinateY(), null);
                }
            }
        }
    }

    private void paintCannon(Graphics g) {
        ImageIcon cannon = new ImageIcon(ViewPropertiesUtil.CANNON_IMAGE);
        cannon = new ImageIcon(cannon.getImage().getScaledInstance(cannonPojo.getWidth(), cannonPojo.getHeight(), Image.SCALE_FAST));
        managerView.presenter.updateCannonYCoordinate();
        g.drawImage(cannon.getImage(), cannonPojo.getCoordinateX(), cannonPojo.getCoordinateY(), null);

    }

    private void paintAliens(Graphics g) {
        for (AlienPojo alien : aliens) {
            ImageIcon alienIcon = new ImageIcon(ViewPropertiesUtil.ALIEN_IMAGE);
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
                } else if (e.getKeyChar() == managerView.getKeyToShoot()) {
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
