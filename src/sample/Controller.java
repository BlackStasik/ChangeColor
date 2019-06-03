package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.awt.*;

public class Controller {

    @FXML
    Button button;
    @FXML
    Button hsv;

    Color color;
    float n = 0;

    float red = 0;
    float green = 99;
    float blue = 99;
    String col = "-fx-background-color: ";

    int counter = 0;

    public void setHsv(ActionEvent actionEvent) throws InterruptedException {
        hsv.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                RGB rgb = new RGB();
                n = 0;
                try {
                    rgb.showRect();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                n = rgb.x;
                col += hsvToRgb2(n,green,blue) + ";";
                Main.root.setStyle(col);
                col = "-fx-background-color: ";

            }
        });
    }

    public String hsvToRgb2(float H, float S, float V) {

        float R, G, B;

        H /= 360f;
        S /= 100f;
        V /= 100f;

        if (S == 0)
        {
            R = V * 255;
            G = V * 255;
            B = V * 255;
        } else {
            float var_h = H * 6;
            if (var_h == 6)
                var_h = 0; // H must be < 1
            int var_i = (int) Math.floor((double) var_h); // Or ... var_i =
            // floor( var_h )
            float var_1 = V * (1 - S);
            float var_2 = V * (1 - S * (var_h - var_i));
            float var_3 = V * (1 - S * (1 - (var_h - var_i)));

            float var_r;
            float var_g;
            float var_b;
            if (var_i == 0) {
                var_r = V;
                var_g = var_3;
                var_b = var_1;
            } else if (var_i == 1) {
                var_r = var_2;
                var_g = V;
                var_b = var_1;
            } else if (var_i == 2) {
                var_r = var_1;
                var_g = V;
                var_b = var_3;
            } else if (var_i == 3) {
                var_r = var_1;
                var_g = var_2;
                var_b = V;
            } else if (var_i == 4) {
                var_r = var_3;
                var_g = var_1;
                var_b = V;
            } else {
                var_r = V;
                var_g = var_1;
                var_b = var_2;
            }

            R = var_r * 255; // RGB results from 0 to 255
            G = var_g * 255;
            B = var_b * 255;
        }

        String rs = Integer.toHexString((int) (R));
        String gs = Integer.toHexString((int) (G));
        String bs = Integer.toHexString((int) (B));

        if (rs.length() == 1)
            rs = "0" + rs;
        if (gs.length() == 1)
            gs = "0" + gs;
        if (bs.length() == 1)
            bs = "0" + bs;
        return "#" + rs + gs + bs;
    }



    public void onClick(ActionEvent actionEvent) {
        if(red > 360){
            red = 0;
        }
        else {
            red += 2;
        }
        col += hsvToRgb2(red,green,blue) + ";";
        System.out.println(col);
        Main.root.setStyle(col);
        col = "-fx-background-color: ";
        if (counter == 0 ) {
            button.setText("Дуже добре");
        }
        else {
            if (counter == 1 ) {
                button.setText("Кнопку натиснули " + counter + " раз");
            }
            else {
                if (counter > 1 && counter < 5) {
                    button.setText("Кнопку натиснули " + counter + " рази");
                }
                else {
                    if(counter % 10 == 0 ){
                        button.setText("Кнопку натиснули " + counter + " разів");
                    }
                    else {
                        if(counter % 10 == 1 ){
                            button.setText("Кнопку натиснули " + counter + " раз");
                        }
                        else {
                            if(counter % 10 > 0 && counter % 10 < 5 && counter > 20){
                                button.setText("Кнопку натиснули " + counter + " рази");
                            }
                            else {
                                button.setText("Кнопку натиснули " + counter + " разів");
                            }
                        }
                    }
                }
            }
        }
        counter++;
    }
}
