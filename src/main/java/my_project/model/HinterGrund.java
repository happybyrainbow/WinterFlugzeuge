package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;

public class HinterGrund extends GraphicalObject {

    public HinterGrund(double x, double y){
        this.x = x;
        this.y = y;
        setNewImage("src/main/resources/graphic/hinterGrund.png");
    }

    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(new Color(40, 116, 178));
        drawTool.drawFilledRectangle(x,y, 800, 720);
    }
}
