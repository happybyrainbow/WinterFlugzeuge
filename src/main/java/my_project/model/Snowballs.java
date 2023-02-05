package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.Collision;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Snowballs extends InteractiveGraphicalObject {

    private boolean schneeBall = false;

    End e1;
    Player1 p1;
    Player2 p2;
    private int punkteR;
    private int punkteB;
    double timerP1 = 0;
    double timerP2 = 0;
    double yPosP1;
    double xPosP1;
    double yPosP2;
    double xPosP2;
    //int j = 1;

    ArrayList<double[]> allBulletsP1 = new ArrayList<>();
    ArrayList<double[]> allBulletsP2 = new ArrayList<>();

    public Snowballs(double x, double y, Player1 p1, Player2 p2, End e1) {
        this.x = x;
        this.y = y;
        this.p1 = p1;
        this.p2 = p2;
        this.e1 = e1;
    }

    public void draw(DrawTool drawTool) {
        for (int i = 0; i < allBulletsP1.size(); i++) {
            drawTool.setCurrentColor(new Color(255, 255, 255));
            drawTool.drawFilledCircle(allBulletsP1.get(i)[1] + 80, allBulletsP1.get(i)[0] + 20.5, 3);
            drawTool.setCurrentColor(new Color(1, 1, 1));
            drawTool.drawCircle(allBulletsP1.get(i)[1] + 80, allBulletsP1.get(i)[0] + 20.5, 3);
        }
        for (int l = 0; l < allBulletsP2.size(); l++) {
            drawTool.setCurrentColor(new Color(255, 255, 255));
            drawTool.drawFilledCircle(allBulletsP2.get(l)[1], allBulletsP2.get(l)[0] + 20.5, 3);
            drawTool.setCurrentColor(new Color(1, 1, 1));
            drawTool.drawCircle(allBulletsP2.get(l)[1], allBulletsP2.get(l)[0] + 20.5, 3);
        }
        drawTool.drawText(10,30,"Punkte: " + punkteR);
        drawTool.drawText(725,30,"Punkte: " + punkteB);
    }


    public int getPunkteR() {
        return punkteR;
    }

    public int getPunkteB() {
        return punkteB;
    }

    public void update(double dt) {
        //Bewegung der Bullets
        for (int j = 0; j < allBulletsP1.size(); j++) {
            allBulletsP1.get(j)[1] += 200 * dt;
        }
        for (int k = 0; k < allBulletsP2.size(); k++) {
            allBulletsP2.get(k)[1] -= 200 * dt;
        }
        //timer
        timerP1 = timerP1 + dt;
        timerP2 = timerP2 + dt;
        //Schießen Player 1
        if (timerP1 > 0.3) {
            if (ViewController.isKeyDown(69)) {
                yPosP1 = p1.getP1Y();
                xPosP1 = p1.getP1X();
                timerP1 = 0;
                double[] bulletP1 = new double[2];
                bulletP1[0] = yPosP1;
                bulletP1[1] = xPosP1;
                allBulletsP1.add(bulletP1);
            }
        }
        //Schießen Player 2
        if (timerP2 > 0.3) {
            if (ViewController.isKeyDown(37)) {
                timerP2 = 0;
                yPosP2 = p2.getP2Y();
                xPosP2 = p2.getP2X();
                double[] bulletP2 = new double[2];
                bulletP2[0] = yPosP2;
                bulletP2[1] = xPosP2;
                allBulletsP2.add(bulletP2);
            }
        }
        //punktInRechteck
        for (int p = 0; p < allBulletsP1.size(); p++) {
            if (Collision.circleToRect((float) allBulletsP1.get(p)[1], (float) allBulletsP1.get(p)[0], 3, (float) p2.getP2X() - 73, (float) p2.getP2Y() - 20, 73, 41)) {

                allBulletsP1.remove(p);
                punkteR += 1;

            }
        }
        for (int g = 0; g < allBulletsP2.size(); g++) {

            if (Collision.circleToRect((float) allBulletsP2.get(g)[1], (float) allBulletsP2.get(g)[0], 3, (float) p1.getP1X(), (float) p1.getP1Y() - 20, 73, 41)) {

                allBulletsP2.remove(g);
                punkteB += 1;

            }
        }

        if (e1.getTimerEnd() > 30 && punkteR > punkteB && e1.isEnd() == true){

            p1.setP1X(363.5);
            p1.setP1Y(379.5);
            p2.setP2Y(37900000.50000);

        }

        if (e1.getTimerEnd() > 30 && punkteB > punkteR && e1.isEnd() == true){

            p2.setP2X(363.5);
            p2.setP2Y(379.5);
            p1.setP1Y(379000.5);

        }

        if (e1.getTimerEnd() > 30 && punkteB == punkteR && e1.isEnd() == true){

            p2.setP2X(400);
            p2.setP2Y(379.5);
            p1.setP1X(327);
            p1.setP1Y(379.5);

        }

        if(e1.getTimerEnd() > 35){
            punkteB = 0;
            punkteR = 0;
        }

        if (e1.getTimerPlayer() > 35.000000000000000000000000001){

                p1.setP1X(20);
                p1.setP1Y(300);
                p2.setP2X(695);
                p2.setP2Y(400);
                e1.setTimerPlayer(0);
                punkteB = 0;
                punkteR = 0;

        }

    }

    public void setPunkteR(int punkteR) {
        this.punkteR = punkteR;
    }

    public void setPunkteB(int punkteB) {
        this.punkteB = punkteB;
    }
}





