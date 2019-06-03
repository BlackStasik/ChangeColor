package sample;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RGB implements MouseListener {

    Screen screen;
    int[] array = new int[360];

    int y = 0;
    int x = 0;

    public RGB(){;
    }


    public void showRect() throws InterruptedException {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(380,200);
        frame.setResizable(true);
        screen = new Screen();
        frame.add(screen);
        frame.setVisible(true);
        frame.addMouseListener(new MouseListener() {
            public void mousePressed(MouseEvent me) { }
            public void mouseReleased(MouseEvent me) { }
            public void mouseEntered(MouseEvent me) { }
            public void mouseExited(MouseEvent me) { }
            public void mouseClicked(MouseEvent me) {
                x = me.getX();
                y = me.getY();
            }
        });
        Thread.sleep(3000);

        frame.dispose();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        y = e.getY();
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
}
