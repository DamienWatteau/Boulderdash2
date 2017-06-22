package boulderdash.model;

import boulderdash.model.element.mobile.IMobile;

/**
 * <h1>The Interface IInsaneVehiclesModel.</h1>
 *
 * @author Jade
 * @version 0.1
 */
public interface IBoulderdashModel {

    /**
     * Gets the road.
     *
     * @return the road
     */
    IMap getMap();

    /**
     * Gets the my vehicle.
     *
     * @return the Rockford
     */
    IMobile getRockford();

}
