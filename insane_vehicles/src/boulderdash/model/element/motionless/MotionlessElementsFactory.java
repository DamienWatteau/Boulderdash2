package boulderdash.model.element.motionless;

/**
 * <h1>A factory to create MotionlessElements objects.</h1>
 *
 * @author Jade
 * @version 0.3
 */
public abstract class MotionlessElementsFactory {

	/** The Constant ditchRight. */
	private static final DitchRight ditchRight = new DitchRight();

	/** The Constant ditchLeft. */
	private static final Diamond diamond = new Diamond();

	/** The Constant ditchLeftTurnLeft. */
	private static final End end = new End();

	/** The Constant ditchLeftTurnRight. */
	private static final Rock rock = new Rock();

	/** The Constant ditchRightTurnLeft. */
	private static final DestructibleBlock destructibleBlock = new DestructibleBlock();

	/** The Constant ditchRightTurnRight. */
	private static final DitchRightTurnRight ditchRightTurnRight = new DitchRightTurnRight();

	/** The Constant TREE. */
	private static final Limit limit = new Limit();

	/** The Constant MACADAM. */
	private static final Background background = new Background();

	/** The Constant OBSTACLE. */
	private static final Monster monster = new Monster();

	/**
	 * The motionless elements is an array of all possible MotionlessElement.
	 */
	private static MotionlessElement[] motionlessElements = { ditchRight, diamond, end, rock, destructibleBlock,
			ditchRightTurnRight, background, monster, limit, };

	/**
	 * Creates a new MotionlessElements object.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createDitchRight() {
		return ditchRight;
	}

	/**
	 * Creates a new MotionlessElements object.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createDiamond() {
		return diamond;
	}

	/**
	 * Creates a new MotionlessElements object.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createEnd() {
		return end;
	}

	/**
	 * Creates a new MotionlessElements object.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createRock() {
		return rock;
	}

	/**
	 * Creates a new MotionlessElements object.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createDestructibleBlock() {
		return destructibleBlock;
	}

	/**
	 * Creates a new MotionlessElements object.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createDitchRightTurnRight() {
		return ditchRightTurnRight;
	}

	/**
	 * Creates a new macadam object.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createBackground() {
		return background;
	}

	/**
	 * Creates a new obstacle object.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createMonster() {
		return monster;
	}

	/**
	 * Creates a new MotionlessElements object.
	 *
	 * @return the motionless element
	 */
	public static MotionlessElement createLimit() {
		return limit;
	}

	/**
	 * Gets the good MotionlessElement from file symbol.
	 *
	 * @param fileSymbol
	 *            the file symbol
	 * @return the from file symbol
	 */
	public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
		for (final MotionlessElement motionlessElement : motionlessElements) {
			if (motionlessElement.getSprite().getConsoleImage() == fileSymbol) {
				return motionlessElement;
			}
		}
		return background;
	}
}
