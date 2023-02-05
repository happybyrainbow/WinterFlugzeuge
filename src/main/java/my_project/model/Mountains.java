package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;
import java.util.ArrayList;

public class Mountains extends GraphicalObject {

    private double timer;

    ArrayList<double[]> allMountains = new ArrayList<>();


    public Mountains(){

    }

    public void draw(DrawTool drawTool){

        for (int m = 0; m < allMountains.size(); m++) {

            drawTool.setCurrentColor(Color.white);
            drawTool.drawFilledCircle(allMountains.get(m)[0], allMountains.get(m)[1], allMountains.get(m)[2]);
            drawTool.drawFilledRectangle(0,720, 800, 100);

        }

    }

    public void update(double dt){

        timer += dt;

        for (int m = 0; m < allMountains.size(); m++) {

            allMountains.get(m)[0] -= dt*300;

            if (allMountains.get(m)[0] < -800) {
                allMountains.remove(m);
            }
        }

        double[] mountain = new double[3];
        mountain[0] = Math.random()*800 + 800;
        mountain[1] = 740;
        mountain[2] = Math.random()* 25 + 90;

        if (timer > 2){

            allMountains.add(mountain);
            timer = Math.random() * 1.5;

        }
    }
}
