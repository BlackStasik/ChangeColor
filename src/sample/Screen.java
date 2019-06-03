package sample;

import javafx.scene.paint.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import java.util.Random;

public class Screen extends JPanel{


    int[] array = new int[360];


    public Screen() {
        for (int i = 0; i < array.length; i++){
            array[i] = i;
        }
    }

    public void paint(Graphics graphics){
        Controller controller = new Controller();
        int a = 0;
        for (int i = 0; i <array.length; i++){{
            String s = controller.hsvToRgb2(array[i], 99, 99);
            graphics.setColor(Color.decode(s));
            graphics.fillRect(a, 200-200, 1, 250);
            a++;
        }}
    }

}

