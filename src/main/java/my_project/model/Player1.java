package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

public class Player1 extends InteractiveGraphicalObject {

    private double p1X;
    private double p1Y;
    End e1;

    public Player1(double p1X, double p1Y, End e1){
        this.p1X = p1X;
        this.p1Y = p1Y;
        this.e1 = e1;
        setNewImage("src/main/resources/graphic/player1.png");
    }

    public void draw(DrawTool drawTool){
        drawTool.drawImage(getMyImage(), p1X, p1Y);
    }

    public double getP1X(){
        return p1X;
    }

    public double getP1Y(){
        return p1Y;
    }

    public void setP1X(double p1X) {
        this.p1X = p1X;
    }

    public void setP1Y(double p1Y) {
        this.p1Y = p1Y;
    }

    public void update(double dt) {
        if (e1.isEnd() == false) {
            if (ViewController.isKeyDown(87)) {
                p1Y = p1Y - dt * 200;
            }
            if (ViewController.isKeyDown(83)) {
                p1Y = p1Y + dt * 200;
            }
            if (p1Y > 880) {
                p1Y = -80;
            }
            if (p1Y < -80) {
                p1Y = 880;
            }
        }
    }
}


