package fr.exia.insanevehicles;

import java.io.IOException;

import fr.exia.insanevehicles.controller.IBoulderdashController;
import fr.exia.insanevehicles.controller.BoulderdashController;
import fr.exia.insanevehicles.model.IBoulderdashModel;
import fr.exia.insanevehicles.model.BoulderdashModel;
import fr.exia.insanevehicles.view.BoulderdashView;

/**
 * <h1>The InsaneVehicles Class.</h1>
 *
 * @author Jade
 * @version 0.2
 */
public abstract class Main {

    /** The Constant startX. */
    private static final int startX = 5;

    /** The Constant startY. */
    private static final int startY = 0;

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws InterruptedException
     *             the interrupted exception
     */
    public static void main(final String[] args) throws IOException, InterruptedException {
        final IBoulderdashModel model = new BoulderdashModel("road.txt", startX, startY);
        final BoulderdashView view = new BoulderdashView(model.getRoad(), model.getMyVehicle());
        final IBoulderdashController controller = new BoulderdashController(view, model);
        view.setOrderPerformer(controller.getOrderPeformer());

        controller.play();
        // TEST
    }
}
