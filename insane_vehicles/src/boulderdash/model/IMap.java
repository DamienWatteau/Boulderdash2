package boulderdash.model;

import java.util.Observable;

import boulderdash.model.element.IElement;

/**
 * <h1>The Interface Imap.</h1>
 *
 * @author Jade
 * @version 0.1
 */
public interface IMap {

	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	int getWidth();

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	int getHeight();

	/**
	 * Gets the on the map XY.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @return the on the map XY
	 */
	IElement getOnTheMapXY(int x, int y);

	/**
	 * Sets the mobile has changed.
	 */
	void setMobileHasChanged();

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
}
