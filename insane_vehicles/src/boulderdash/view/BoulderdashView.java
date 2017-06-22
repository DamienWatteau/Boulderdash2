package boulderdash.view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import boulderdash.controller.IOrderPerformer;
import boulderdash.controller.UserOrder;
import boulderdash.model.IMap;
import boulderdash.model.element.mobile.IMobile;
import fr.exia.showboard.BoardFrame;

/**
 * <h1>The InsaneVehiclesView Class.</h1>
 *
 * @author Jade
 * @version 0.4
 */
public class BoulderdashView implements Runnable, KeyListener, IBoulderdashView {

	/** The Constant mapView. */
	private static final int mapView = 20;

	/** The Constant squareSize. */
	private static final int squareSize = 30;

	/** The Constant closeView. */
	private Rectangle closeView;

	/** The map. */
	private IMap map;

	/** My vehicle. */
	private IMobile rockford;

	/** The view. */
	private int view;

	/** The order performer. */
	private IOrderPerformer orderPerformer;

	/**
	 * Instantiates a new insane vehicles View.
	 *
	 * @param map
	 *            the map
	 * @param rockford
	 *            the my vehicle
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public BoulderdashView(final IMap Map, final IMobile rockford) throws IOException {
		this.setView(mapView);
		this.setMap(map);
		this.setRockford(rockford);
		this.getRockford().getSprite().loadImage();
		this.setCloseView(new Rectangle(0, this.getRockford().getY(), this.getMap().getWidth(), mapView));
		SwingUtilities.invokeLater(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.exia.insanevehicles.view.IInsaneVehiclesView#displayMessage(java.lang.
	 * String)
	 */
	@Override
	public final void displayMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}
/**
 * create a window of name BoulderDash
 * 	
 */
	@Override
	public final void run() {
		final BoardFrame boardFrame = new BoardFrame("BoulderDash");
		
		boardFrame.setDimension(new Dimension(this.getMap().getWidth(), this.getMap().getHeight()));
		boardFrame.setDisplayFrame(this.closeView);
		boardFrame.setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);
		boardFrame.setLocationRelativeTo(null);

		boardFrame.setBackground(null);
		boardFrame.addKeyListener(this);
		boardFrame.setFocusable(true);
		boardFrame.setFocusTraversalKeysEnabled(false);

		for (int x = 0; x < this.getMap().getWidth(); x++) {
			for (int y = 0; y < this.getMap().getHeight(); y++) {
				boardFrame.addSquare(this.map.getOnTheMapXY(x, y), x, y);
			}
		}
		boardFrame.addPawn(this.getRockford());

		this.getMap().getObservable().addObserver(boardFrame.getObserver());
		this.followRockford();

		boardFrame.setVisible(true);
		
		
	}

	/**
	 * Prints the map and the player's vehicle in the console.
	 *
	 * @param yStart
	 *            the y start
	 */
	public final void show(final int yStart) {
		int y = yStart % this.getMap().getHeight();
		for (int view = 0; view < this.getView(); view++) {
			for (int x = 0; x < this.getMap().getWidth(); x++) {
				if ((x == this.getRockford().getX()) && (y == yStart)) {
					System.out.print(this.getRockford().getSprite().getConsoleImage());
				} else {
					System.out.print(this.getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage());
				}
			}
			y = (y + 1) % this.getMap().getHeight();
			System.out.print("\n");
		}
	}

	/**
	 * Key code to user order.
	 *
	 * @param keyCode
	 *            the key code
	 * @return the user order
	 */
	private static UserOrder keyCodeToUserOrder(final int keyCode) {
		UserOrder userOrder;
		switch (keyCode) {
		case KeyEvent.VK_RIGHT:
			userOrder = UserOrder.RIGHT;
			break;
		case KeyEvent.VK_LEFT:
			userOrder = UserOrder.LEFT;
			break;
		case KeyEvent.VK_UP:
			userOrder = UserOrder.UP;
			break;
		case KeyEvent.VK_DOWN:
			userOrder = UserOrder.DOWN;
			break;
		default:
			userOrder = UserOrder.NOP;
			break;
		}
		return userOrder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(final KeyEvent keyEvent) {
		// Nop
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public final void keyPressed(final KeyEvent keyEvent) {
		try {
			this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
		} catch (final IOException exception) {
			exception.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(final KeyEvent keyEvent) {
		// Nop
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.view.IInsaneVehiclesView#followRockford()
	 */
	@Override
	public final void followRockford() {
		this.getCloseView().y = this.getRockford().getY() - 1;
	}

	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	private IMap getMap() {
		return this.map;
	}

	/**
	 * Sets the map.
	 *
	 * @param map
	 *            the new map
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void setMap(final IMap map) throws IOException {
		this.map = map;
		for (int x = 0; x < this.getMap().getWidth(); x++){
			for (int y = 0; y < this.getMap().getHeight(); y++) {
				this.getMap().getOnTheMapXY(x, y).getSprite().loadImage();
			}
		}
	}

	/**
	 * Gets my vehicle.
	 *
	 * @return my vehicle
	 */
	private IMobile getRockford() {
		return this.rockford;
	}

	/**
	 * Sets my vehicle.
	 *
	 * @param rockford
	 *            my new vehicle
	 */
	private void setRockford(final IMobile rockford) {
		this.rockford = rockford;
	}

	/**
	 * Gets the view.
	 *
	 * @return the view
	 */
	private int getView() {
		return this.view;
	}

	/**
	 * Sets the view.
	 *
	 * @param view
	 *            the new view
	 */
	private void setView(final int view) {
		this.view = view;
	}

	/**
	 * Gets the close view.
	 *
	 * @return the close view
	 */
	private Rectangle getCloseView() {
		return this.closeView;
	}

	/**
	 * Sets the close view.
	 *
	 * @param closeView
	 *            the new close view
	 */
	private void setCloseView(final Rectangle closeView) {
		this.closeView = closeView;
	}

	/**
	 * Gets the order performer.
	 *
	 * @return the order performer
	 */
	private IOrderPerformer getOrderPerformer() {
		return this.orderPerformer;
	}

	/**
	 * Sets the order performer.
	 *
	 * @param orderPerformer
	 *            the new order performer
	 */
	public final void setOrderPerformer(final IOrderPerformer orderPerformer) {
		this.orderPerformer = orderPerformer;
	}
}
