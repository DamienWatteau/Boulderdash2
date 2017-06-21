package boulderdash.model;

import java.io.IOException;

import boulderdash.model.element.mobile.IMobile;
import boulderdash.model.element.mobile.Rockford;

/**
 * <h1>The Class InsaneVehiclesModel.</h1>
 */
public class BoulderdashModel implements IBoulderdashModel {

    /** The map. */
    private IMap   map;

    /** The my vehicle. */
    private IMobile myVehicle;

    /**
     * Instantiates a new insane vehicles model.
     *
     * @param fileName
     *            the file name
     * @param myVehicleStartX
     *            the my vehicle start X
     * @param myVehicleStartY
     *            the my vehicle start Y
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public BoulderdashModel(final String fileName, final int myVehicleStartX, final int myVehicleStartY)
            throws IOException {
        this.setMap(new Map(fileName));
        this.setMyVehicle(new Rockford(myVehicleStartX, myVehicleStartY, this.getMap()));
    }

    /* (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IInsaneVehiclesModel#getMap()
     */
    @Override
    public final IMap getMap() {
        return this.map;
    }

    /**
     * Sets the map.
     *
     * @param map
     *            the map to set
     */
    private void setMap(final IMap map) {
        this.map = map;
    }

    /* (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IInsaneVehiclesModel#getMyVehicle()
     */
    @Override
    public final IMobile getMyVehicle() {
        return this.myVehicle;
    }

    /**
     * Sets the my vehicle.
     *
     * @param myVehicle
     *            the myVehicle to set
     */
    private void setMyVehicle(final IMobile myVehicle) {
        this.myVehicle = myVehicle;
    }

}
