package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.abitur.datenstrukturen.Queue;
import my_project.model.*;
import my_project.view.InputManager;

import java.awt.event.MouseEvent;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    //Attribute


    // Referenzen
    private ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param viewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController viewController){
        this.viewController = viewController;
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen.
     * Sie erstellt die leeren Datenstrukturen, zu Beginn nur eine Queue
     */
    public void startProgram() {



       HinterGrund hinterGrund = new HinterGrund(0,0);
       viewController.draw(hinterGrund);

        End end1 = new End();
        viewController.draw(end1);

        Player1 player1 = new Player1(20, 300, end1);
        viewController.draw(player1);

        Player2 player2 = new Player2(695,400, end1);
        viewController.draw(player2);

        Snowballs snowballs1 = new Snowballs(20,0, player1, player2, end1);
        viewController.draw(snowballs1);

        Wolken wolke10 = new Wolken();
        viewController.draw(wolke10);

        Mountains mountain = new Mountains();
        viewController.draw(mountain);


        for (int i = 0; i < wolke10.getArray().size(); i++){
            viewController.draw(wolke10.getArray().get(i));
        }

    }

    /**
     * Aufruf mit jeder Frame
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt){





    }
}
