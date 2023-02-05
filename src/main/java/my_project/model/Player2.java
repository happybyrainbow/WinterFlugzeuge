package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

public class Player2 extends InteractiveGraphicalObject {

    End e1;
    public double p2X;
    public double p2Y;

    public Player2(double p2X, double p2Y, End e1){
        this.p2X = p2X;
        this.p2Y = p2Y;
        this.e1 = e1;
        setNewImage("src/main/resources/graphic/player2.png");
    }

    public void draw(DrawTool drawTool){
        drawTool.drawImage(getMyImage(), p2X, p2Y);
    }

    public void update(double dt) {
        if (e1.isEnd() == false) {
            if (ViewController.isKeyDown(38)) {
                p2Y = p2Y - dt * 200;
            }
            if (ViewController.isKeyDown(40)) {
                p2Y = p2Y + dt * 200;
            }
            if (p2Y > 880) {
                p2Y = -80;
            }
            if (p2Y < -80) {
                p2Y = 880;
            }
        }
    }
    public double getP2X(){
        return p2X;
    }

    public double getP2Y(){
        return p2Y;
    }

    public void setP2X(double p2X) {
        this.p2X = p2X;
    }

    public void setP2Y(double p2Y) {
        this.p2Y = p2Y;
    }
}


