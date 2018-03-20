package application;

import javafx.beans.property.SimpleStringProperty;

/**
 * The Class MenuTempHis.
 */
public class MenuTempHis {


	/** The f 25. */
	private SimpleStringProperty f21, f22, f23, f24, f25;
	
	/** The menu. */
	private SimpleStringProperty menu;

	/**
	 * Gets the f21.
	 *
	 * @return the f21
	 */
	public String getF21() {
		return f21.get();
	}

	/**
	 * Gets the f22.
	 *
	 * @return the f22
	 */
	public String getF22() {
		return f22.get();
	}

	/**
	 * Gets the f23.
	 *
	 * @return the f23
	 */
	public String getF23() {
		return f23.get();
	}

	/**
	 * Gets the f24.
	 *
	 * @return the f24
	 */
	public String getF24() {
		return f24.get();
	}

	/**
	 * Gets the f25.
	 *
	 * @return the f25
	 */
	public String getF25() {
		return f25.get();
	}

	/**
	 * Instantiates a new menu temp his.
	 *
	 * @param f21 the f 21
	 * @param f22 the f 22
	 * @param f23 the f 23
	 * @param f24 the f 24
	 * @param f25 the f 25
	 */
	MenuTempHis(String f21, String f22, String f23, String f24, String f25) {
		this.f21 = new SimpleStringProperty(f21);
		this.f22 = new SimpleStringProperty(f22);
		this.f23 = new SimpleStringProperty(f23);
		this.f24 = new SimpleStringProperty(f24);
		this.f25 = new SimpleStringProperty(f25);
	}
}
