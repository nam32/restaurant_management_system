package application;

import javafx.beans.property.SimpleStringProperty;

/**
 * The Class Menu used in stage 4.
 */
public class Menu {

	
	/** The f 2. */
	private SimpleStringProperty f1, f2;
	
	/**
	 * Gets the f1.
	 *
	 * @return the f1
	 */
	public String getF1() {
		return f1.get();
	}

	/**
	 * Gets the f2.
	 *
	 * @return the f2
	 */
	public String getF2() {
		return f2.get();
	}

	/**
	 * Instantiates a new menu.
	 *
	 * @param f1 the f 1
	 * @param f2 the f 2
	 */
	Menu(String f1, String f2) {
		this.f1 = new SimpleStringProperty(f1);
		this.f2 = new SimpleStringProperty(f2);
	}
}
