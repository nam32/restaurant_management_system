package application;

import javafx.beans.property.SimpleStringProperty;

/**
 * The Class Account used in stage 7, login(stage 1) and also in management of
 * accounts (stage 3).
 */
public class Account {

	/** The f 02. */
	private SimpleStringProperty f01, f02;

	/**
	 * Gets the f01.
	 *
	 * @return the f01
	 */
	public String getF01() {
		return f01.get();
	}

	/**
	 * Gets the f02.
	 *
	 * @return the f02
	 */
	public String getF02() {
		return f02.get();
	}

	/**
	 * Instantiates a new account.
	 *
	 * @param f01
	 *            the f 01
	 * @param f02
	 *            the f 02
	 */
	Account(String f01, String f02) {
		this.f01 = new SimpleStringProperty(f01);
		this.f02 = new SimpleStringProperty(f02);
	}
}
