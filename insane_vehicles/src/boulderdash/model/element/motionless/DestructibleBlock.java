package boulderdash.model.element.motionless;

import boulderdash.model.element.Permeability;
import boulderdash.model.element.Sprite;

/**
 * <h1>The Class Ditch.</h1>
 *
 * @author Jade
 * @version 0.2
 */
class DestructibleBlock extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('O', "BlockDestructible.png");

    /**
     * Instantiates a new ditch.
     */
    DestructibleBlock() {
        super(SPRITE, Permeability.BLOCKING);
    }
}
