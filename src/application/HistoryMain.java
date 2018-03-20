/**
 * This file contains the class HistoryMain used in stage 7.
 */
package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javafx.beans.property.SimpleStringProperty;

/**
 * The Class HistoryMain.
 */
public class HistoryMain {
	
	/** The f 37. */
	public SimpleStringProperty f31, f32, f33, f34, f35, f36, f37;
	
	/** The History main. */
	public SimpleStringProperty HistoryMain;

	/**
	 * Gets the f31.
	 *
	 * @return the f31
	 */
	public String getF31() {
		return f31.get();
	}

	/**
	 * Gets the f32.
	 *
	 * @return the f32
	 */
	public String getF32() {
		return f32.get();
	}

	/**
	 * Gets the f33.
	 *
	 * @return the f33
	 */
	public String getF33() {
		return f33.get();
	}

	/**
	 * Gets the f34.
	 *
	 * @return the f34
	 */
	public String getF34() {
		return f34.get();
	}

	/**
	 * Gets the f35.
	 *
	 * @return the f35
	 */
	public String getF35() {
		return f35.get();
	}
	
	/**
	 * Gets the f36.
	 *
	 * @return the f36
	 */
	public String getF36() {
		return f36.get();
	}

	/**
	 * Gets the f37.
	 *
	 * @return the f37
	 */
	public String getF37() {
		return f37.get();
	}

	/**
	 * Instantiates a new history main.
	 *
	 * @param f31 the f 31
	 * @param f32 the f 32
	 * @param f33 the f 33
	 * @param f34 the f 34
	 * @param f35 the f 35
	 * @param f36 the f 36
	 * @param f37 the f 37
	 */
	HistoryMain(String f31, String f32, String f33, String f34, String f35, String f36, String f37) {
		this.f31 = new SimpleStringProperty(f31);
		this.f32 = new SimpleStringProperty(f32);
		this.f33 = new SimpleStringProperty(f33);
		this.f34 = new SimpleStringProperty(f34);
		this.f35 = new SimpleStringProperty(f35);
		this.f36 = new SimpleStringProperty(f36);
		this.f37 = new SimpleStringProperty(f37);
	}


}