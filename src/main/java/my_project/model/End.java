package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class End extends GraphicalObject {

    private boolean end = false;
    private double timerEnd;

    private BufferedImage b1;
    private BufferedImage b2;

    private double timerPlayer;


    public End(){

    }

    public void draw(DrawTool drawTool){

       if(end == true){

           setNewImage("src/main/resources/graphic/Krone.png");

           drawTool.drawImage(getMyImage(),  363.5, 338.5);

           setNewImage("src/main/resources/graphic/Winner.png");

           drawTool.drawImage(getMyImage(),  300.5, 400.5);

       }

    }

    public void update(double dt){

        timerEnd += dt;
        timerPlayer += dt;


        if (timerEnd > 30){
            end = true;
        }

        if (timerEnd > 35){
            timerEnd = 0;
            end = false;
        }
    }



    public boolean isEnd() {
        return end;
    }

    public double getTimerEnd() {
        return timerEnd;
    }

    public double getTimerPlayer() {
        return timerPlayer;
    }

    public void setTimerPlayer(double timerPlayer) {
        this.timerPlayer = timerPlayer;
    }
}
