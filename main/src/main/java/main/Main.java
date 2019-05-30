/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import contract.ControllerOrder;
import controller.Controller;
import model.Model;
import view.View;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) throws SQLException, IOException, InterruptedException {
        final Model model = new Model();
        final View view = new View(model);
        final Controller controller = new Controller(view, model);


        view.setController(controller);

        int i = 1;



        controller.control();
        //controller.loop(3);


        while(i == 1){
            i = controller.autoMove();
            controller.orderPerform(ControllerOrder.NOTHING);
            if (i == 0){controller.death();}
            if (i == 2){controller.win();}
        }



    }
}
