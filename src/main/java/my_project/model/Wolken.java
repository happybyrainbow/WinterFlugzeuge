package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;
import java.util.ArrayList;

public class Wolken extends GraphicalObject {

    private double timer;

    ArrayList<Wolke> allClouds = new ArrayList<>();


    public Wolken(){

    }

    public void draw(DrawTool drawTool){

        for (int c = 0; c < allClouds.size(); c++){

            allClouds.get(c).draw(drawTool);

        }

    }



    public void update(double dt){

        timer = timer + dt;

        for (int c = 0; c < allClouds.size(); c++){

            allClouds.get(c).update(dt);

            if (allClouds.get(c).getxPosC() < -210) {
                allClouds.remove(c);
            }
        }

        if (timer > 2) {

            allClouds.add(new Wolke());
            timer = Math.random() * 1;

        }
    }

    public ArrayList<Wolke> getArray(){
        return allClouds;
    }
}
