package boulderdash.model;

import java.io.IOException;

import boulderdash.model.element.mobile.IMobile;
import boulderdash.model.element.mobile.Rockford;

/**
 * <h1>The Class InsaneVehiclesModel.</h1>
 */
public class BoulderdashModel implements IBoulderdashModel {

    /** The map. */
    private IMap map;

    /** The my vehicle. */
    private IMobile rockford;

    /**
     * Instantiates a new insane vehicles model.
     *
     * @param fileName
     *            the file name
     * @param rockfordStartX
     *            the my vehicle start X
     * @param rockfordStartY
     *            the my vehicle start Y
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public BoulderdashModel(final String fileName, final int rockfordStartX, final int rockfordStartY)
            throws IOException {
        this.setMap(new Map(fileName));
        this.setRockford(new Rockford(rockfordStartX, rockfordStartY, this.getMap()));
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
     * @see fr.exia.insanevehicles.model.IInsaneVehiclesModel#getrockford()
     */
    @Override
    public final IMobile getRockford() {
        return this.rockford;
    }

    /**
     * Sets the my vehicle.
     *
     * @param rockford
     *            the rockford to set
     */
    private void setRockford(final IMobile rockford) {
        this.rockford = rockford;
    }

}
