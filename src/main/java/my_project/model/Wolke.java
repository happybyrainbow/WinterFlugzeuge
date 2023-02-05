package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;
import java.util.ArrayList;

public class Wolke extends InteractiveGraphicalObject {

    private double xPosC = 1050;
    private double yPosC = 10;
    private double xPosR = 10000;
    private double yPosR = 10000;

    private double timer = 4;
    private double timerR = 0;

    ArrayList<double[]> allRain = new ArrayList<>();

    public Wolke() {
        setNewImage("src/main/resources/graphic/cloud.png");
    }

    public void draw(DrawTool drawTool) {

        drawTool.drawImage(getMyImage(), xPosC, yPosC);


        for (int r = 0; r < allRain.size(); r++) {

            for (int j = 0; j < 10; j++) {

                drawTool.setCurrentColor(new Color(7, 7, 204));
                drawTool.drawFilledCircle(allRain.get(r)[0] + j * 18, allRain.get(r)[1] + 116, 3);

            }

        }
    }

    public void update(double dt) {

        timer += dt;
        timerR += dt;

        xPosC -= dt * 300;


        for (int r = 0; r < allRain.size(); r++) {
            allRain.get(r)[0] -= dt * 350;
            allRain.get(r)[1] += dt * 300;

        }


        double[] rain = new double[2];
        rain[0] = xPosR + 10;
        rain[1] = yPosR;

        for (int r = 0; r < allRain.size(); r++) {

            xPosR = xPosC;
            yPosR = yPosC;


        }

        if (timerR > 0.1) {

            allRain.add(rain);
            timerR = 0;

        }
    }

    public double getxPosC() {
        return xPosC;
    }
}
