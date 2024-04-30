package co.edu.uptc.view.dashboard;

import co.edu.uptc.pojo.CannonPojo;
import co.edu.uptc.view.ManagerView;
import org.w3c.dom.CDATASection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Dashboard extends JPanel {

    private CannonPojo cannonPojo = new CannonPojo();
    private ManagerView managerView;

    public Dashboard() {
        initComponents();
        moveCannon();
    }

    public void initPojo() {
        cannonPojo = managerView.presenter.getCannonPojo();
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
                    try {
                        Thread.sleep(80);
                        initPojo();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    repaint();
                }
            }
        });
        thread.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect(cannonPojo.getCoordinateX(), cannonPojo.getCoordinateY(), cannonPojo.getSize(), cannonPojo.getSize());
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
