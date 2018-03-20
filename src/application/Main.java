
package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.sun.glass.ui.Window.Level;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Restaurant Management System The program includes features: -implemented as a
 * JavaFX GUI application using buttons, tables, listeners, etc. -restaurant
 * employee login to the restaurant management system using a username/password
 * pair. -The system display a graphical representation of the tables with their
 * numeric labels and approximate position within the restaurant. -Register a
 * new order with minimal information such as table number, time of order, list
 * of ordered items, total amount of order, special requests, comments, etc, by
 * first clicking on the graphical representation of a table. -Clicking on the
 * graphical representation of a table again allows editing its current order
 * (add, modify, delete, etc). -Delete an exiting order, asking for confirmation
 * before deleting an order. -Search the list of orders based on any of the
 * stored fields, i.e., table number, dates and times intervals, ordered food,
 * etc. and produce a list of corresponding orders. -The restaurant manager has
 * a special account that allows him/her manage employees accounts (add, delete
 * accounts) and display their activities log. Edit menus, etc. -The restaurant
 * manager can export a list of selected orders as a comma separated file or any
 * other format. -The restaurant manager can import a comma separated file (or
 * the format used for export) containing orders into the system. The new orders
 * data will be appended to the existing ones already stored in the restaurant
 * management system.
 *
 *
 * @author Titaporn Janjumratsang
 * @version 2.0
 * @since 2016-12-12
 */

public class Main extends Application {

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(Main.class.getName());

	/** The stage 9. */
	Stage stage1, stage2, stage3, stage4, stage5, stage6, stage7, stage8, stage9;

	/** The scene 9. */
	Scene scene1, scene2, scene3, scene4, scene5, scene6, scene7, scene8, scene9;

	/** The total price button 5. */
	Button totalPriceButton5;

	/** The tablestage 3. */
	private final TableView<Account> tablestage3 = new TableView<>();

	/** The datastage 3. */
	private final ObservableList<Account> datastage3 = FXCollections.observableArrayList();

	/** The tablestage 6. */
	final TableView<MenuList> tablestage6 = new TableView<>();

	/** The datastage 6. */
	final ObservableList<MenuList> datastage6 = FXCollections.observableArrayList();

	/** The tablestage 5. */
	private final TableView<MenuTempHis> tablestage5 = new TableView<>();

	/** The datastage 5. */
	private final ObservableList<MenuTempHis> datastage5 = FXCollections.observableArrayList();

	/** The tablestage 7. */
	private final TableView<HistoryMain> tablestage7 = new TableView<>();

	/** The datastage 7. */
	private final ObservableList<HistoryMain> datastage7 = FXCollections.observableArrayList();

	/** The total show 5 in stage 5 to show total cost of a table. */
	Text totalShow5;

	/** The file name. */
	String fileName;

	/** The text area 9. */
	TextArea textArea9;

	/** The pw box. */
	PasswordField pwBox;

	/**
	 * Strings to be passed in the method to check username and password in the
	 * order to login.
	 */
	String checkUser, checkPw;

	/** The pane. */
	Pane pane = new Pane();

	/**  The actiontarget, stage1 shows if the user login is correct or not. */
	final Text actiontarget = new Text();

	/** The user account. */
	final Text userAccount = new Text();

	/** The exit button 9. */
	Button exportButton7, importButton7, exitButton9;

	/** The file name 7. */
	String fileName7;

	/** The txt field 7. */
	TextField TextField, userTextField, txtField7;

	/** The Table 1. */
	Button table1 = new Button("table 1");

	/** The Table 2. */
	Button table2 = new Button("table 2");

	/** The Table 3. */
	Button table3 = new Button("table 3");

	/** The Table 4. */
	Button table4 = new Button("table 4");

	/** The Table 5. */
	Button table5 = new Button("table 5");

	/** The Table 6. */
	Button table6 = new Button("table 6");

	/** The Table 7. */
	Button table7 = new Button("table 7");

	/** The Table 8. */
	Button table8 = new Button("table 8");

	/** The Table 9. */
	Button table9 = new Button("table 9");

	/** The manage history button. */
	Button manageHistoryButton = new Button("history");

	/** The manage menu button. */
	Button manageMenuButton = new Button("manage menu");

	/** The manage account button. */
	Button manageAccountButton = new Button("manage accounts");

	/** The log access button. */
	Button logAccessButton = new Button("employees log");

	/** The logout button. */
	Button logoutButton = new Button("logout");

	/** The grid 7. */
	GridPane grid7;

	/** The user. */
	String user;

	/** The tablestage 4. */
	private final TableView<Menu> tablestage4 = new TableView<>();

	/** The datastage 4. */
	private final ObservableList<Menu> datastage4 = FXCollections.observableArrayList();
	public void start(Stage primaryStage) throws Exception {

		/**
		 * This part of the code set up all of stage 1 scene 1 The login to the
		 * restaurant system.
		 */
		stage1 = primaryStage;
		stage1.setTitle("restaurant system login");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text scenetitle = new Text("restaurant system login");
		scenetitle.setId("system-login");
		grid.add(scenetitle, 0, 0, 2, 1);

		Label userName = new Label("User Name:");
		grid.add(userName, 0, 1);
		userTextField = new TextField();
		grid.add(userTextField, 1, 1);

		Label pw = new Label("Password:");
		grid.add(pw, 0, 2);

		pwBox = new PasswordField();
		grid.add(pwBox, 1, 2);

		Button signinButton = new Button("Sign in");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(signinButton);
		grid.add(hbBtn, 1, 4);

		grid.add(actiontarget, 1, 6);
		scene1 = new Scene(grid, 500, 375);
		stage1.setScene(scene1);
		scene1.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
		stage1.show();

		/**
		 * This part of the code set up log system to log activities of the
		 * employees to "mylog.txt" file and to make a new file if such file
		 * does not exists.
		 */
		Logger logger = Logger.getLogger("MyLog");
		FileHandler fh;

		try {

			File f = new File("mylog.txt");
			if (f.exists() == false) {
				f.createNewFile();
			}
			fh = new FileHandler("mylog.txt", true);
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		/**
		 * This part of the code set up all of stage 2 scene 2 which is a
		 * graphical representation of the tables with their numeric labels once
		 * you successful login. The manager will have the ability to manage
		 * employees accounts (add, delete accounts), see history of employee
		 * log and export files and edit menus. Waiters can have any usernames
		 * and can only add, edit or delete orders.
		 */
		draggable(table1);
		draggable(table2);
		draggable(table3);
		draggable(table4);
		draggable(table5);
		draggable(table6);
		draggable(table7);
		draggable(table8);
		draggable(table9);

		table1.setOnAction(e -> {

			String UserAccountLabel = userAccount.getText();
			UserAccountLabel = UserAccountLabel.replaceAll("Welcome back you are currently logged in as: ", "");

			fileName = UserAccountLabel + "_" + "table1.csv";
			stage5.show();
			datastage5.clear();
			readCSVTempHis(fileName);
			logger.info(UserAccountLabel + ": start serving table1.csv.");

		});

		table2.setOnAction(e -> {
			String UserAccountLabel = userAccount.getText();
			UserAccountLabel = UserAccountLabel.replaceAll("Welcome back you are currently logged in as: ", "");

			fileName = UserAccountLabel + "_" + "table2.csv";
			stage5.show();
			datastage5.clear();
			readCSVTempHis(fileName);

			logger.info(UserAccountLabel + ": start serving table2.");
		});

		table3.setOnAction(e -> {
			String UserAccountLabel = userAccount.getText();
			UserAccountLabel = UserAccountLabel.replaceAll("Welcome back you are currently logged in as: ", "");

			fileName = UserAccountLabel + "_" + "table3.csv";
			stage5.show();
			datastage5.clear();
			readCSVTempHis(fileName);
			logger.info(UserAccountLabel + ": start serving table3.");
		});

		table4.setOnAction(e -> {
			String UserAccountLabel = userAccount.getText();
			UserAccountLabel = UserAccountLabel.replaceAll("Welcome back you are currently logged in as: ", "");

			fileName = UserAccountLabel + "_" + "table4.csv";
			stage5.show();
			datastage5.clear();
			readCSVTempHis(fileName);
			logger.info(UserAccountLabel + ": start serving table4.");
		});

		table5.setOnAction(e -> {
			String UserAccountLabel = userAccount.getText();
			UserAccountLabel = UserAccountLabel.replaceAll("Welcome back you are currently logged in as: ", "");

			fileName = UserAccountLabel + "_" + "table5.csv";
			stage5.show();
			datastage5.clear();
			readCSVTempHis(fileName);
			logger.info(UserAccountLabel + ": start serving table5.");
		});

		table6.setOnAction(e -> {
			String UserAccountLabel = userAccount.getText();
			UserAccountLabel = UserAccountLabel.replaceAll("Welcome back you are currently logged in as: ", "");

			fileName = UserAccountLabel + "_" + "table6.csv";
			stage5.show();
			datastage5.clear();
			readCSVTempHis(fileName);
			logger.info(UserAccountLabel + ": start serving table6.");

		});

		table7.setOnAction(e -> {
			String UserAccountLabel = userAccount.getText();
			UserAccountLabel = UserAccountLabel.replaceAll("Welcome back you are currently logged in as: ", "");

			fileName = UserAccountLabel + "_" + "table7.csv";
			stage5.show();
			datastage5.clear();
			readCSVTempHis(fileName);
			logger.info(UserAccountLabel + ": start serving table7.");

		});

		table8.setOnAction(e -> {
			String UserAccountLabel = userAccount.getText();
			UserAccountLabel = UserAccountLabel.replaceAll("Welcome back you are currently logged in as: ", "");

			fileName = UserAccountLabel + "_" + "table8.csv";
			stage5.show();
			datastage5.clear();
			readCSVTempHis(fileName);
			logger.info(UserAccountLabel + ": start serving table8.");

		});

		table9.setOnAction(e -> {
			String UserAccountLabel = userAccount.getText();
			UserAccountLabel = UserAccountLabel.replaceAll("Welcome back you are currently logged in as: ", "");

			fileName = UserAccountLabel + "_" + "table9.csv";
			stage5.show();
			datastage5.clear();
			readCSVTempHis(fileName);
			logger.info(UserAccountLabel + ": start serving table9.");

		});

		pane.getChildren().add(table1);
		table1.setLayoutX(100);
		table1.setLayoutY(50);
		pane.getChildren().add(table2);
		table2.setLayoutX(100);
		table2.setLayoutY(200);
		pane.getChildren().add(table3);
		table3.setLayoutX(100);
		table3.setLayoutY(350);
		pane.getChildren().add(table4);
		table4.setLayoutX(350);
		table4.setLayoutY(50);
		pane.getChildren().add(table5);
		table5.setLayoutX(350);
		table5.setLayoutY(200);
		pane.getChildren().add(table6);
		table6.setLayoutX(350);
		table6.setLayoutY(350);
		pane.getChildren().add(table7);
		table7.setLayoutX(600);
		table7.setLayoutY(50);
		pane.getChildren().add(table8);
		table8.setLayoutX(600);
		table8.setLayoutY(200);
		pane.getChildren().add(table9);
		table9.setLayoutX(600);
		table9.setLayoutY(350);

		pane.getChildren().add(userAccount);
		userAccount.setLayoutX(5);
		userAccount.setLayoutY(490);

		manageAccountButton.setLayoutX(127);
		manageAccountButton.setLayoutY(0);
		manageAccountButton.setOnAction(e -> {
			stage3.show();
			datastage3.removeAll(datastage3);
			readCSVStage3("login_profiles.csv");
		});

		manageMenuButton.setLayoutX(255);
		manageMenuButton.setLayoutY(0);
		manageMenuButton.setOnAction(e -> {
			stage4.show();
			readCSVForMenu("menu.csv");
		});

		logAccessButton.setLayoutX(363);
		logAccessButton.setLayoutY(0);
		logAccessButton.setOnAction(e -> {
			fillTextarea();
			stage9.show();
		});
		manageHistoryButton.setLayoutX(65);
		manageHistoryButton.setLayoutY(0);
		pane.getChildren().add(manageHistoryButton);
		manageHistoryButton.setOnAction(e -> {
			stage7.show();
			readCSVHistory("mainHistory.csv");
			initFilterHistory();
			String UserAccountLabel = userAccount.getText();
			UserAccountLabel = UserAccountLabel.replaceAll("Welcome back you are currently logged in as: ", "");
			String str2 = "manager";
			if (UserAccountLabel.toLowerCase().contains(str2.toLowerCase())) {
				grid7.getChildren().add(importButton7);
				grid7.getChildren().add(exportButton7);
			}
		});

		/**
		 * For any orders to be submitted into the mainHistory.csv file, must
		 * logout of the system, or else the system will assume that the user is
		 * still logged in and will not write to the log file.
		 */

		pane.getChildren().add(logoutButton);
		logoutButton.setLayoutX(0);
		logoutButton.setLayoutY(0);
		logoutButton.setId("logoutButton");
		logoutButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String UserAccountLabel = userAccount.getText();
				UserAccountLabel = UserAccountLabel.replaceAll("Welcome back you are currently logged in as: ", "");
				logger.info(UserAccountLabel + " logged out.");

				deleteFileContentLogoff(UserAccountLabel + "_table1.csv");
				deleteFileContentLogoff(UserAccountLabel + "_table2.csv");
				deleteFileContentLogoff(UserAccountLabel + "_table3.csv");
				deleteFileContentLogoff(UserAccountLabel + "_table4.csv");
				deleteFileContentLogoff(UserAccountLabel + "_table5.csv");
				deleteFileContentLogoff(UserAccountLabel + "_table6.csv");
				deleteFileContentLogoff(UserAccountLabel + "_table7.csv");
				deleteFileContentLogoff(UserAccountLabel + "_table8.csv");
				deleteFileContentLogoff(UserAccountLabel + "_table9.csv");

				/**
				 * This part of the code set up allows the users to escape
				 * program gracefully.
				 */
				stage2.close();
				actiontarget.setText("");
				userTextField.setText("");
				pwBox.setText("");
				System.exit(0);
			}
		});

		stage2 = new Stage();
		scene2 = new Scene(pane, 900, 500);
		stage2.setScene(scene2);

		/**
		 * This part of the code set up all of stage 3 scene 3 which is the
		 * scene for account management only available to managers. Allowing the
		 * manager to make new accounts and delete old accounts.
		 */

		stage3 = new Stage();
		Group root3 = new Group();
		Scene scene3 = new Scene(root3, 420, 500);
		stage3.setScene(scene3);
		stage3.setTitle("manage Accounts");

		GridPane grid3 = new GridPane();
		grid3.setPadding(new Insets(10, 10, 10, 10));
		grid3.setVgap(5);
		grid3.setHgap(5);

		scene3.setRoot(grid3);

		/**
		 * This part of the code set up layout of scene3 stage3 including all
		 * its buttons and textfields.
		 */

		final TextField UserName3 = new TextField();
		UserName3.setPromptText("create new user");
		UserName3.setPrefColumnCount(10);
		UserName3.getText();
		grid3.setConstraints(UserName3, 0, 1);
		grid3.getChildren().add(UserName3);

		final TextField password3 = new TextField();
		password3.setPromptText("create new password");
		grid3.setConstraints(password3, 0, 2);
		grid3.getChildren().add(password3);

		Button newAccountAddButton3 = new Button("add new account");
		grid3.setConstraints(newAccountAddButton3, 1, 1);
		grid3.getChildren().add(newAccountAddButton3);

		Button deleteAccounts3 = new Button("delete account");
		grid3.setConstraints(deleteAccounts3, 1, 2);
		grid3.getChildren().add(deleteAccounts3);

		Button closeButton3 = new Button("exit");
		grid3.setConstraints(closeButton3, 0, 4);
		grid3.getChildren().add(closeButton3);
		closeButton3.setOnAction(e -> stage3.close());

		/**
		 * This part of the code set up table layout of tableview. pairing
		 * account and its password.
		 */
		TableColumn columnF01 = new TableColumn("Account");
		columnF01.setMinWidth(150);
		columnF01.setCellValueFactory(new PropertyValueFactory<>("f01"));

		TableColumn columnF02 = new TableColumn("Password");
		columnF02.setMinWidth(100);
		columnF02.setCellValueFactory(new PropertyValueFactory<>("f02"));

		tablestage3.setItems(datastage3);
		tablestage3.getColumns().addAll(columnF01, columnF02);

		grid3.setConstraints(tablestage3, 0, 3);
		grid3.getChildren().add(tablestage3);

		/**
		 * Getting the row that was clicked on and if delete button is pushed,
		 * that username will be deleted.
		 */
		tablestage3.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue == null) {
				return;
			}
			String ItemName = newValue.getF01();
			String price = newValue.getF02();

			deleteAccounts3.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					String account = ItemName + "," + price;
					user = userAccount.getText();
					user = user.replaceAll("Welcome back you are currently logged in as: ", "");
					logger.info(user + ": " + account + " deleted.");
					deleteItemInFile(account, "login_profiles.csv");
					UserName3.setText("");
					password3.setText("");
					datastage3.removeAll(datastage3);
					readCSVStage3("login_profiles.csv");

				}
			});

		});

		/**
		 * This part of the code set up all of stage 4 scene 4 which is the
		 * scene for menu management only available to managers. This allows you
		 * to import csv files using fileChooser, add new items by filling both
		 * the name and the price of the food and also deleting items by
		 * clicking the item you want to delete and clicking the delete button.
		 */
		stage4 = new Stage();
		Group root4 = new Group();
		Scene scene4 = new Scene(root4, 390, 500);
		stage4.setScene(scene4);
		stage4.setTitle("manage menu");

		GridPane grid4 = new GridPane();
		grid4.setPadding(new Insets(10, 10, 10, 10));
		grid4.setVgap(5);
		grid4.setHgap(5);

		scene4.setRoot(grid4);

		final TextField itemName4 = new TextField();
		itemName4.setPromptText("Enter new Item");
		itemName4.setPrefColumnCount(10);
		itemName4.getText();
		grid4.setConstraints(itemName4, 0, 2);
		grid4.getChildren().add(itemName4);

		final TextField itemPrice4 = new TextField();
		itemPrice4.setPromptText("Enter Item price");
		grid4.setConstraints(itemPrice4, 0, 3);
		grid4.getChildren().add(itemPrice4);

		Button newItemInMenuAddButton4 = new Button("add new item");
		grid4.setConstraints(newItemInMenuAddButton4, 1, 2);
		grid4.getChildren().add(newItemInMenuAddButton4);

		Button deletemenuAndPrices4 = new Button("delete items");
		grid4.setConstraints(deletemenuAndPrices4, 1, 3);
		grid4.getChildren().add(deletemenuAndPrices4);

		Button importFiles4 = new Button("import files");
		grid4.setConstraints(importFiles4, 0, 4);
		grid4.getChildren().add(importFiles4);

		Button closeButton4 = new Button("exit");
		grid4.setConstraints(closeButton4, 0, 6);
		grid4.getChildren().add(closeButton4);
		closeButton4.setOnAction(e -> {
			datastage4.clear();
			stage4.close();
		});

		/**
		 * This part of the code set up tableview of scene4 which contains menu
		 * and prices for menu management.
		 */

		TableColumn columnF1 = new TableColumn("item name");
		columnF1.setMinWidth(150);
		columnF1.setCellValueFactory(new PropertyValueFactory<>("f1"));

		TableColumn columnF2 = new TableColumn("prices");
		columnF2.setMinWidth(100);
		columnF2.setCellValueFactory(new PropertyValueFactory<>("f2"));

		tablestage4.setItems(datastage4);
		tablestage4.getColumns().addAll(columnF1, columnF2);

		grid4.setConstraints(tablestage4, 0, 5);
		grid4.getChildren().add(tablestage4);

		/**
		 * This part of the code allows new menu to be typed and added to the
		 * menulist file.
		 */
		newItemInMenuAddButton4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String menuAndPrices = itemName4.getText() + "," + itemPrice4.getText();
				if (menuAndPrices.equals(",")) {
				} else {
					csvFileWriterForMenu(menuAndPrices);
					user = userAccount.getText();
					user = user.replaceAll("Welcome back you are currently logged in as: ", "");
					logger.info(user + ": " + menuAndPrices + " added to menu.");
					itemName4.setText("");
					itemPrice4.setText("");
					datastage4.removeAll(datastage4);
					readCSVForMenu("menu.csv");
				}
			}
		});

		/**
		 * This part of the code allows the selected row data to be retrived and
		 * deleted if the delete button is pressed.
		 */
		tablestage4.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue == null) {
				return;
			}
			String itemNameString = newValue.getF1();
			String priceString = newValue.getF2();
			deletemenuAndPrices4.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					String menuAndPrices = itemNameString + "," + priceString;
					deletemenuAndPrices(menuAndPrices);
					user = userAccount.getText();
					user = user.replaceAll("Welcome back you are currently logged in as: ", "");
					logger.info(user + ": " + menuAndPrices + " deleted from menu.");
					itemName4.setText("");
					itemPrice4.setText("");
					datastage4.removeAll(datastage4);
					readCSVForMenu("menu.csv");
				}
			});
		});

		/**
		 * This part of the code links importFiles4 button to a filechooser,
		 * allows the files to be selected and imported into menu .csv file. The
		 * format must be correct or this will cause index error in code.
		 */
		importFiles4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				FileChooser fileChooser = new FileChooser();

				FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text Files", "*.csv");
				fileChooser.getExtensionFilters().add(extFilter);
				File file = fileChooser.showOpenDialog(stage4);
				if (file != null) {
					csvFileWriterForMenu(readFile(file));
					user = userAccount.getText();
					user = user.replaceAll("Welcome back you are currently logged in as: ", "");
					logger.info(user + ": " + readFile(file) + " file imported for menu.");
					trim("menu.csv");
					datastage4.clear();
					readCSVForMenu("menu.csv");
				}
			}
		});

		/**
		 * This part of the code set up all of stage 5 scene 5 which is the
		 * scene which pops up once the user clicks on the graphical
		 * presentation of a table. This allows all people to add orders, edit
		 * orders and delete orders for each table. The delete button will bring
		 * you to an user interface (stage 8) which will asks for verification
		 * that you indeed want to delete the order.
		 */
		stage5 = new Stage();
		Group root5 = new Group();
		Scene scene5 = new Scene(root5, 900, 600);
		stage5.setScene(scene5);
		stage5.setTitle("Orders");

		GridPane grid5 = new GridPane();
		grid5.setPadding(new Insets(10, 10, 10, 10));
		grid5.setVgap(5);
		grid5.setHgap(5);

		scene5.setRoot(grid5);

		final Text ItemNameShow = new Text();
		grid5.setConstraints(ItemNameShow, 0, 1);
		grid5.getChildren().add(ItemNameShow);

		Button menuList = new Button("menu list");
		grid5.setConstraints(menuList, 1, 1);
		grid5.getChildren().add(menuList);

		final Text ItemPriceShow = new Text();
		grid5.setConstraints(ItemPriceShow, 0, 2);
		grid5.getChildren().add(ItemPriceShow);

		ObservableList<String> quantity5 = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8",
				"9", "10");
		final ComboBox quantitiesCombo5 = new ComboBox(quantity5);

		grid5.setConstraints(quantitiesCombo5, 0, 3);
		quantitiesCombo5.getSelectionModel().selectFirst();
		quantitiesCombo5.setVisibleRowCount(5);
		grid5.getChildren().add(quantitiesCombo5);

		final TextField itemNameTextField5 = new TextField();
		itemNameTextField5.setPromptText("enter comment");
		grid5.setConstraints(itemNameTextField5, 0, 4);
		grid5.getChildren().add(itemNameTextField5);

		Button newItemInMenuAddButton5 = new Button("add new item");
		grid5.setConstraints(newItemInMenuAddButton5, 1, 2);
		grid5.getChildren().add(newItemInMenuAddButton5);

		Button deleteOrders5 = new Button("delete items");
		grid5.setConstraints(deleteOrders5, 1, 3);
		grid5.getChildren().add(deleteOrders5);

		Button editOrders5 = new Button("edit items");
		grid5.setConstraints(editOrders5, 1, 4);
		grid5.getChildren().add(editOrders5);

		totalPriceButton5 = new Button("total price");
		grid5.setConstraints(totalPriceButton5, 1, 7);
		grid5.getChildren().add(totalPriceButton5);

		totalShow5 = new Text();
		grid5.setConstraints(totalShow5, 0, 7);
		grid5.getChildren().add(totalShow5);

		Button closeButton5 = new Button("exit");
		grid5.setConstraints(closeButton5, 0, 8);
		grid5.getChildren().add(closeButton5);
		closeButton5.setOnAction(e -> {
			totalShow5.setText("");
			stage5.close();
		});

		/**
		 * The finishedSession5 button allows the table data to be wiped and new
		 * customer orders to be taken without older orders still existing. The
		 * previous orders have been recorded into the main history file.
		 */
		Button finishSession5 = new Button("finished serving table");
		grid5.setConstraints(finishSession5, 0, 9);
		grid5.getChildren().add(finishSession5);
		finishSession5.setOnAction(e -> {
			user = userAccount.getText();
			user = user.replaceAll("Welcome back you are currently logged in as: ", "");
			String tableNumber1 = fileName.replace((user + "_"), "");
			String tableNumber = tableNumber1.replace(".csv", "");
			deleteFileContentLogoff(user + "_" + tableNumber + ".csv");
			datastage5.removeAll(datastage5);
			readCSVTempHis(fileName);
			logger.info(user + ": finished serving " + tableNumber + ".");
		});

		TableColumn columnF21 = new TableColumn("item name");
		columnF21.setMinWidth(130);
		columnF21.setCellValueFactory(new PropertyValueFactory<>("f21"));

		TableColumn columnF22 = new TableColumn("prices");
		columnF22.setMinWidth(55);
		columnF22.setCellValueFactory(new PropertyValueFactory<>("f22"));

		TableColumn columnF23 = new TableColumn("Quantity");
		columnF23.setMinWidth(55);
		columnF23.setCellValueFactory(new PropertyValueFactory<>("f23"));

		TableColumn columnF24 = new TableColumn("Time Ordered");
		columnF24.setMinWidth(160);
		columnF24.setCellValueFactory(new PropertyValueFactory<>("f24"));

		TableColumn columnF25 = new TableColumn("Comment");
		columnF25.setMinWidth(300);
		columnF25.setCellValueFactory(new PropertyValueFactory<>("f25"));

		tablestage5.setItems(datastage5);
		tablestage5.getColumns().addAll(columnF21, columnF22, columnF23, columnF24, columnF25);

		grid5.setConstraints(tablestage5, 0, 6);
		grid5.getChildren().add(tablestage5);

		totalPriceButton5.setOnAction(e -> {
			total(fileName);
		});

		deleteOrders5.setOnAction(e -> {
			stage8.show();
		});

		tablestage5.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue == null) {
				return;
			}
			String itemNameString = newValue.getF21();
			String priceString = newValue.getF22();
			String QuantityString = newValue.getF23();
			String dateString = newValue.getF24();
			String commentString = newValue.getF25();

			/**
			 * after clicking the row to edit, you must press the edit button.
			 * This will fill up the text boxes and comment box with the detail
			 * of the order. The comboBox will be set back to quantity 1. Any
			 * amendments can be made and will be re-submitted into the order
			 * table when add button is pressed. The time of the order will
			 * remain the time the order was first placed. If the add button is
			 * not pressed, the item will be deleted.
			 */

			editOrders5.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					ItemNameShow.setText(itemNameString);
					ItemPriceShow.setText(priceString);
					itemNameTextField5.setText(commentString);
					String deleteString = itemNameString + "," + priceString + "," + QuantityString + "," + dateString
							+ "," + commentString;
					user = userAccount.getText();
					user = user.replaceAll("Welcome back you are currently logged in as: ", "");

					String tableNumber1 = fileName.replace((user + "_"), "");
					String tableNumber = tableNumber1.replace(".csv", "");
					String mainHistoryString = deleteString + "," + tableNumber + "," + user;
					deleteItemInFile(mainHistoryString, "mainHistory.csv");
					logger.info(user + ": " + deleteString + " edited in order in table " + tableNumber + ".");

					///
					deleteItemInFile(deleteString, fileName);
					newItemInMenuAddButton5.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent e) {

							String quantitySelectedString = (String) quantitiesCombo5.getValue();
							String commentString = itemNameTextField5.getText();
							if (commentString.equals("")) {
								commentString = "-";
							}

							DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
							String date = df.format(Calendar.getInstance().getTime());

							if (ItemNameShow.getText().equals("")) {
								ItemNameShow.setText("item not selected");
							}
							if (ItemNameShow.getText().equals("item not selected")) {
							} else {
								String account = ItemNameShow.getText() + "," + ItemPriceShow.getText() + ","
										+ quantitySelectedString + "," + date + "," + commentString;
								csvFileWriterToFile(account, fileName);
								///
								logger.info(
										user + ": " + " edited to " + account + " table number " + tableNumber + ".");
								String tableNumber1 = fileName.replace((user + "_"), "");
								String tableNumber = tableNumber1.replace(".csv", "");
								String mainHistoryString2 = account + "," + tableNumber + "," + user;
								csvFileWriterToFile(mainHistoryString2, "mainHistory.csv");

								datastage5.removeAll(datastage5);
								ItemNameShow.setText("");
								ItemPriceShow.setText("");
								itemNameTextField5.setText("");
								readCSVTempHis(fileName);
								quantitiesCombo5.getSelectionModel().selectFirst();
							}
						}

					});

					datastage5.clear();
					readCSVTempHis(fileName);

				}
			});
		});

		/**
		 * Stage6 is called by stage5 button to show a menu. It then allows the
		 * row selected to be added into orders taken.
		 */
		Stage stage6 = new Stage();

		Group root6 = new Group();
		Scene scene6 = new Scene(root6, 270, 400);
		stage6.setScene(scene6);

		GridPane grid6 = new GridPane();
		grid6.setPadding(new Insets(10, 10, 10, 10));
		grid6.setVgap(5);
		grid6.setHgap(5);
		scene6.setRoot(grid6);

		TableColumn columnF11 = new TableColumn("item name");
		columnF11.setMinWidth(150);
		columnF11.setCellValueFactory(new PropertyValueFactory<>("f1"));

		TableColumn columnF12 = new TableColumn("prices");
		columnF12.setMinWidth(100);
		columnF12.setCellValueFactory(new PropertyValueFactory<>("f2"));

		tablestage6.setItems(datastage6);
		tablestage6.getColumns().addAll(columnF11, columnF12);

		grid6.setConstraints(tablestage6, 0, 2);
		grid6.getChildren().add(tablestage6);

		tablestage6.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue == null) {
				return;
			}
			String ItemName = newValue.getF1();
			ItemNameShow.setText(ItemName);
			String price = newValue.getF2();
			ItemPriceShow.setText(price);
			stage6.close();
		});

		/**
		 * This part of the code set up all of stage 7 scene 7 which is the
		 * history table. There is also a search function to search different
		 * fields and import and export files option. The exported file will
		 * have csv format and will be called "the search input" + ".csv".
		 */
		stage7 = new Stage();
		Group root7 = new Group();
		Scene scene7 = new Scene(root7, 900, 500);
		stage7.setScene(scene7);
		stage7.setTitle("");

		grid7 = new GridPane();
		grid7.setPadding(new Insets(10, 10, 10, 10));
		grid7.setVgap(5);
		grid7.setHgap(5);
		scene7.setRoot(grid7);

		txtField7 = new TextField();
		txtField7.setPromptText("enter comment");
		grid7.setConstraints(txtField7, 0, 1);
		grid7.getChildren().add(txtField7);

		exportButton7 = new Button("export file");
		grid7.setConstraints(exportButton7, 0, 2);

		importButton7 = new Button("Import file");
		grid7.setConstraints(importButton7, 0, 3);

		Button exitButton7 = new Button("exit");
		grid7.setConstraints(exitButton7, 0, 4);
		grid7.getChildren().add(exitButton7);
		exitButton7.setOnAction(e -> {
			txtField7.setText("");
			datastage7.clear();
			stage7.close();
		});

		scene7.setRoot(grid7);
		exportButton7.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String textSearched = txtField7.getText();
				String fileName7 = textSearched + ".csv";
				try {
					writeExcel(textSearched, fileName7);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		importButton7.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				FileChooser fileChooser = new FileChooser();

				FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text Files", "*.csv");
				fileChooser.getExtensionFilters().add(extFilter);

				File file = fileChooser.showOpenDialog(stage7);
				if (file != null) {
					csvFileWriterHistory(readFile(file));
					user = userAccount.getText();
					user = user.replaceAll("Welcome back you are currently logged in as: ", "");
					logger.info(user + ": " + readFile(file) + " file imported into mainHistory.");
					trim("mainHistory.csv");
					datastage7.clear();
					readCSVHistory("mainHistory.csv");

				}
			}
		});

		TableColumn columnF31 = new TableColumn("item name");
		columnF31.setMinWidth(150);
		columnF31.setCellValueFactory(new PropertyValueFactory<>("f31"));

		TableColumn columnF32 = new TableColumn("prices");
		columnF32.setMinWidth(100);
		columnF32.setCellValueFactory(new PropertyValueFactory<>("f32"));

		TableColumn columnF33 = new TableColumn("Quantity");
		columnF33.setMinWidth(75);
		columnF33.setCellValueFactory(new PropertyValueFactory<>("f33"));

		TableColumn columnF34 = new TableColumn("Time Ordered");
		columnF34.setMinWidth(150);
		columnF34.setCellValueFactory(new PropertyValueFactory<>("f34"));

		TableColumn columnF35 = new TableColumn("Comment");
		columnF35.setMinWidth(200);
		columnF35.setCellValueFactory(new PropertyValueFactory<>("f35"));

		TableColumn columnF36 = new TableColumn("table number");
		columnF36.setMinWidth(100);
		columnF36.setCellValueFactory(new PropertyValueFactory<>("f36"));

		TableColumn columnF37 = new TableColumn("user");
		columnF37.setMinWidth(100);
		columnF37.setCellValueFactory(new PropertyValueFactory<>("f37"));

		tablestage7.setItems(datastage7);
		tablestage7.getColumns().addAll(columnF31, columnF32, columnF33, columnF34, columnF35, columnF36, columnF37);

		grid7.setConstraints(tablestage7, 0, 5);
		grid7.getChildren().add(tablestage7);

		/**
		 * This part of the code set up all of stage 8 scene 8 which is used to
		 * verify if the user wants to delete the orders in scene 5 or not.
		 */
		stage8 = new Stage();
		GridPane grid8 = new GridPane();
		grid8.setAlignment(Pos.CENTER);
		grid8.setHgap(10);
		grid8.setVgap(10);
		grid8.setPadding(new Insets(25, 25, 25, 25));

		Text scenetitle8 = new Text("Do you want to delete your order?");
		grid8.add(scenetitle8, 0, 0, 2, 1);

		Button yesButton8 = new Button("Yes");
		grid8.add(yesButton8, 0, 1);
		tablestage5.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue == null) {
				return;
			}
			String itemNameString = newValue.getF21();
			String priceString = newValue.getF22();
			String QuantityString = newValue.getF23();
			String dateString = newValue.getF24();
			String commentString = newValue.getF25();

			yesButton8.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					String deleteString = itemNameString + "," + priceString + "," + QuantityString + "," + dateString
							+ "," + commentString;
					user = userAccount.getText();
					user = user.replaceAll("Welcome back you are currently logged in as: ", "");
					deleteItemInFile(deleteString, fileName);

					String tableNumber1 = fileName.replace((user + "_"), "");
					String tableNumber = tableNumber1.replace(".csv", "");
					String mainHistoryString = deleteString + "," + tableNumber + "," + user;
					deleteItemInFile(mainHistoryString, "mainHistory.csv");
					logger.info(user + ": " + deleteString + " deleted from " + tableNumber);

					datastage5.clear();
					readCSVTempHis(fileName);

					ItemNameShow.setText("");
					ItemPriceShow.setText("");
					itemNameTextField5.setText("");
					quantitiesCombo5.getSelectionModel().selectFirst();
					stage8.close();

				}
			});

		});

		Button NoButton8 = new Button("No");
		grid8.add(NoButton8, 0, 2);
		Scene scene8 = new Scene(grid8, 300, 245);
		stage8.setScene(scene8);

		NoButton8.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				stage8.close();
				ItemNameShow.setText("");
				ItemPriceShow.setText("");
				itemNameTextField5.setText("");
				quantitiesCombo5.getSelectionModel().selectFirst();
			}
		});

		/**
		 * Setup for stage 8 scene 8 which show the log activities of all user.
		 * This is only available to the manager as well.
		 */
		stage9 = new Stage();
		stage9.setTitle("logger");

		textArea9 = new TextArea();

		textArea9.setEditable(false);

		GridPane grid9 = new GridPane();
		grid9.setAlignment(Pos.CENTER);
		grid9.setHgap(10);
		grid9.setVgap(10);
		grid9.setPadding(new Insets(25, 25, 25, 25));
		textArea9.setPrefWidth(800);
		textArea9.setPrefHeight(500);

		grid9.add(textArea9, 0, 1);

		exitButton9 = new Button("exit");
		exitButton9.setOnAction(e -> {
			stage9.close();
			textArea9.setText("");
		});
		grid9.add(exitButton9, 0, 2);
		scene9 = new Scene(grid9, 800, 500);
		stage9.setScene(scene9);

		signinButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				checkUser = userTextField.getText().toString();
				checkPw = pwBox.getText().toString();
				String userInput = checkUser + "," + checkPw;
				csvFileReader(userInput);
				String LoginStatus = actiontarget.getText();
				logger.info(checkUser + " logged in.");
				if (LoginStatus.equals("login successful")) {
					stage1.close();
					if (checkUser.equals("manager")) {
						pane.getChildren().add(manageAccountButton);
						pane.getChildren().add(manageMenuButton);
						pane.getChildren().add(logAccessButton);
						scene2.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
						stage2.show();
					} else {
						scene2.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());
						stage2.show();
					}

				}
			}
		});

		newAccountAddButton3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String account = UserName3.getText() + "," + password3.getText();
				user = userAccount.getText();
				user = user.replaceAll("Welcome back you are currently logged in as: ", "");
				logger.info(user + ": " + account + " created.");
				if (account.equals(",")) {
				} else {
					csvFileWriter(account, "login_profiles.csv");
					UserName3.setText("");
					password3.setText("");
					datastage3.removeAll(datastage3);
					readCSVStage3("login_profiles.csv");
				}
			}

		});

		menuList.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				datastage6.clear();
				stage6.show();
				readCSVstage6();
			}

		});

		newItemInMenuAddButton5.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {

				String quantitySelectedString = (String) quantitiesCombo5.getValue();
				String commentString = itemNameTextField5.getText();
				if (commentString.equals("")) {
					commentString = "-";
				}

				DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
				String date = df.format(Calendar.getInstance().getTime());

				if (ItemNameShow.getText().equals("")) {
					ItemNameShow.setText("item not selected");
				} if (ItemNameShow.getText().equals("item not selected")) {
				} else {
					String account = ItemNameShow.getText() + "," + ItemPriceShow.getText() + ","
							+ quantitySelectedString + "," + date + "," + commentString;
					user = userAccount.getText();
					user = user.replaceAll("Welcome back you are currently logged in as: ", "");
					csvFileWriterToFile(account, fileName);
					String tableNumber1 = fileName.replace((user + "_"), "");
					String tableNumber = tableNumber1.replace(".csv", "");
					String mainHistoryString = account + "," + tableNumber + "," + user;
					csvFileWriterToFile(mainHistoryString, "mainHistory.csv");
					logger.info(user + ": " + account + " added order to " + tableNumber + ".");

					datastage5.removeAll(datastage5);
					readCSVTempHis(fileName);
					quantitiesCombo5.getSelectionModel().selectFirst();
					itemNameTextField5.setText("");
					ItemPriceShow.setText("");
					ItemNameShow.setText("");
				}
			}

		});
	}

	/**
	 * Csv file writer to file specified in the parameter.
	 *
	 * @param string
	 *            specify the string to write to file.
	 * @param File
	 *            specify which file to write to.
	 */
	private void csvFileWriterToFile(String string, String File) {

		final String COMMA_DELIMITER = ",";
		final String NEW_LINE_SEPARATOR = "\n";

		File inFile = new File(File);
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			if (inFile.exists() == false) {
				inFile.createNewFile();
				fw = new FileWriter(inFile, true);
				bw = new BufferedWriter(fw);
				bw.write(string + NEW_LINE_SEPARATOR);
			} else {
				fw = new FileWriter(inFile, true);
				bw = new BufferedWriter(fw);
				bw.write(string + NEW_LINE_SEPARATOR);
			}
		} catch (Exception e) {
			logger.info("Exception in CsvFileWriterForHistory method");
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * Draggable are applied to all tables 1 to 9.
	 *
	 * @param button
	 *            are table 1-9.
	 * 
	 */
	private void draggable(Button button) {
		button.setPrefSize(200, 100);
		button.setOnMouseDragged(e -> {
			button.setLayoutX(e.getSceneX());
			button.setLayoutY(e.getSceneY());
		});
	}

	/**
	 * csv file reader used to read login_profiles.csv and check if the user
	 * input matches with the username and password stored in .csv file or not.
	 * If not, will display "Incorrect username or password" and if it is
	 * correct, will display "login successful" message.
	 *
	 * @param userInput
	 *            the user input
	 */
	private void csvFileReader(String userInput) {

		String csvFile = "login_profiles.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				String UserString = line;
				if (UserString.equals(userInput)) {
					actiontarget.setFill(Color.GREENYELLOW);
					actiontarget.setText("login successful");
					String userName = userInput.split(",")[0];
					userAccount.setText("Welcome back you are currently logged in as: " + userName);
					logger.info("logged in as " + userName);

					break;

				} else {
					actiontarget.setFill(Color.CRIMSON);
					userTextField.setText("");
					pwBox.setText("");
					actiontarget.setText("Incorrect username or password");
					logger.info("wrong password");
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.info("FileNotFoundException CsvFileReader method.");
		} catch (IOException e) {
			e.printStackTrace();
			logger.info("IOException CsvFileReader method.");
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					logger.info("IOException CsvFileReader method.");
					// e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Read the tables .csv files.
	 *
	 * @param File
	 *            the file
	 */
	private void readCSVTempHis(String File) {
		String FieldDelimiter = ",";
		BufferedReader br;

		try {
			br = new BufferedReader(new FileReader(File));
			String line;
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(FieldDelimiter, -1);

				MenuTempHis MenuTempHis = new MenuTempHis(fields[0], fields[1], fields[2], fields[3], fields[4]);
				datastage5.add(MenuTempHis);

			}

		} catch (FileNotFoundException e) {
			logger.info("FileNotFoundException readCSVTempHis method.");
		} catch (IOException e) {
			logger.info("IOException readCSVTempHis method.");
		}

	}

	/**
	 * Delete string line in specified file name.
	 *
	 * @param string
	 *            the string
	 * @param File
	 *            file name
	 */
	private void deleteItemInFile(String string, String File) {
		try {
			File inFile = new File(File);
			if (!inFile.isFile()) {
				logger.info("file do not exist, new file " + File + "is generated by DeleteAccount method.");
				return;
			}
			File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
			BufferedReader br = new BufferedReader(new FileReader(inFile));
			PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
			String line = null;
			while ((line = br.readLine()) != null) {

				if (!line.trim().contains(string)) {

					pw.println(line);
					pw.flush();
				}
			}
			pw.close();
			br.close();

			if (!inFile.delete()) {
				logger.info("problems with trying to delete the original file in DeleteAccount method");
				return;
			}
			if (!tempFile.renameTo(inFile)) {
				logger.info("temporary file cannot be renamed");
			}
		} catch (FileNotFoundException ex) {
			logger.info("file not found although supposedly created at the beginning of the DeleteAccount method");
			ex.printStackTrace();
		} catch (IOException ex) {
			logger.info("IOException in DeleteAccount method.");
			ex.printStackTrace();
		}

	}

	/**
	 * .csv file writer writes account and password to login_profiles.csv file.
	 *
	 * @param account
	 *            the account
	 * @param File
	 *            file name
	 */
	private void csvFileWriter(String account, String File) {

		final String COMMA_DELIMITER = ",";
		final String NEW_LINE_SEPARATOR = "\n";

		File login_profiles = new File(File);
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			if (login_profiles.exists() == false) {
				login_profiles.createNewFile();
				logger.info(".csv file for employees does not exist, " + File + "created");
				fw = new FileWriter(login_profiles, true);
				bw = new BufferedWriter(fw);
				bw.write("manager,managerpassword" + NEW_LINE_SEPARATOR + account + NEW_LINE_SEPARATOR);
			} else {
				fw = new FileWriter(login_profiles, true);
				bw = new BufferedWriter(fw);
				bw.write(account + NEW_LINE_SEPARATOR);
			}
		} catch (Exception e) {
			logger.info("exception in CsvFileWriter method.");
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				logger.info("error in closing FileWriter or BufferedWriter in CsvFileWriter method.");
			}
		}
	}

	/**
	 * csv. file writer for menu when new menu items are added to menu.csv file.
	 *
	 * @param menuAndPrices
	 *            the menu and prices
	 */
	private void csvFileWriterForMenu(String menuAndPrices) {

		final String COMMA_DELIMITER = ",";
		final String NEW_LINE_SEPARATOR = "\n";

		File file = new File("menu.csv");
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			if (file.exists() == false) {
				file.createNewFile();
				fw = new FileWriter(file, true);
				bw = new BufferedWriter(fw);
			} else {
				fw = new FileWriter(file, true);
				bw = new BufferedWriter(fw);
				bw.write(menuAndPrices + NEW_LINE_SEPARATOR);
				logger.info("new menu file created by CsvFileWriterForMenu method.");
			}
		} catch (Exception e) {
			logger.info("error in CsvFileWriterForMenu method.");
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				logger.info("error in closing BufferedReader or FileWriter in CsvFileWriterForMenu method.");
				ex.printStackTrace();
			}
		}
	}

	/**
	 * Delete menu and prices from the menu .csv file.
	 *
	 * @param menuAndPrices
	 *            the menu and prices
	 */
	private void deletemenuAndPrices(String menuAndPrices) {
		try {
			File inFile = new File("menu.csv");
			if (!inFile.isFile()) {
				logger.info("menu.csv does not exists (DeletemenuAndPrices method).");
				return;
			}
			File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
			BufferedReader br = new BufferedReader(new FileReader("menu.csv"));
			PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
			String line = null;
			while ((line = br.readLine()) != null) {
				if (!line.trim().contains(menuAndPrices)) {
					pw.println(line);
					pw.flush();
				}
			}
			pw.close();
			br.close();
			if (!inFile.delete()) {
				logger.info("DeletemenuAndPrices cannot delete the original file.");
				return;
			}
			if (!tempFile.renameTo(inFile)) {
				logger.info("DeletemenuAndPrices cannot rename temporary file");
			}
		} catch (FileNotFoundException ex) {
			logger.info("FileNotFoundException in DeletemenuAndPrices method");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
			logger.info("IOException in DeletemenuAndPrices method");

		}
	}

	/**
	 * Read .csv file for menu to table view.
	 *
	 * @param File
	 *            the file
	 */
	private void readCSVForMenu(String File) {
		String FieldDelimiter = ",";

		BufferedReader br;

		try {
			br = new BufferedReader(new FileReader(File));
			String line;
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(FieldDelimiter, -1);

				Menu Menu = new Menu(fields[0], fields[1]);
				datastage4.add(Menu);

			}

		} catch (FileNotFoundException e) {
			logger.info("FileNotFoundException in readCSVForMenu method");
		} catch (IOException e) {
			logger.info("IOException in readCSVForMenu method");
		}
	}

	/**
	 * Read file used with fileChooser.
	 *
	 * @param file
	 *            the file
	 * @return the string
	 */
	private String readFile(File file) {
		StringBuilder stringBuffer = new StringBuilder();
		BufferedReader bufferedReader = null;

		try {
			bufferedReader = new BufferedReader(new FileReader(file));

			String text;
			while ((text = bufferedReader.readLine()) != null) {
				stringBuffer.append(text + "\n");
			}

		} catch (FileNotFoundException ex) {
			logger.info("FileNotFoundException in readFile method");
		} catch (IOException ex) {
			logger.info("IOException in readFile method");
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException ex) {
				logger.info("error in closing bufferedReader in readFile method");
			}
		}

		return stringBuffer.toString();
	}

	/**
	 * Read .csv file to table view in stage 3.
	 *
	 * @param File
	 *            file name
	 */
	private void readCSVStage3(String File) {
		String FieldDelimiter = ",";

		BufferedReader br;

		try {
			br = new BufferedReader(new FileReader(File));

			String line;
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(FieldDelimiter, -1);

				Account Account = new Account(fields[0], fields[1]);
				datastage3.add(Account);

			}

		} catch (FileNotFoundException e) {
			logger.info("FileNotFoundException in readCSVStage3 method");
		} catch (IOException e) {
			logger.info("IOException in readCSVStage3 method");
		}

	}

	/**
	 * Read menu file to table view in stage 6.
	 */
	private void readCSVstage6() {

		String File = "menu.csv";
		String FieldDelimiter = ",";

		BufferedReader br;

		try {
			br = new BufferedReader(new FileReader(File));

			String line;
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(FieldDelimiter, -1);

				MenuList MenuList = new MenuList(fields[0], fields[1]);
				datastage6.add(MenuList);

			}

		} catch (FileNotFoundException e) {
			logger.info("FileNotFoundException in readCSVstage6 method");
		} catch (IOException e) {
			logger.info("IOException in readCSVstage6 method");
		}

	}

	/**
	 * Delete table .csv file contents of table 1 to table 9 when logoff button
	 * is pressed to set up empty orders for each table when the user log in
	 * again.
	 *
	 * @param File
	 *            file name
	 */
	private void deleteFileContentLogoff(String File) {
		try {
			File inPutFile = new File(File);
			if (inPutFile.exists() == false) {
				inPutFile.createNewFile();
				logger.info(File + " not exist, new file is created by deleteFileContentLogoff method.");
			}
			PrintWriter writer = new PrintWriter(File);
			writer.print("");
			writer.close();
		} catch (IOException e) {
			logger.info("IOException by deleteFileContentLogoff method.");
			e.printStackTrace();
		}
	}

	/**
	 * Write excel .csv file out for export history option.
	 *
	 * @param textSearched
	 *            the text searched
	 * @param fileName7
	 *            the file name 7
	 * @throws Exception
	 *             the exception
	 */
	private void writeExcel(String textSearched, String fileName7) throws Exception {
		BufferedWriter writer = null;
		File file = new File("mainHistory.csv");
		Scanner in = null;
		try {
			if (file.exists() == false) {
				file.createNewFile();
				logger.info("mainHistory.csv does not exist, new file is created writeExcel by writeExcel method.");
			}
			File logFile = new File(fileName7);
			if (logFile.exists() == false) {
				file.createNewFile();
				logFile.createNewFile();
				logger.info(fileName7 + " does not exist, new file is created writeExcel by writeExcel method.");
			}
			writer = new BufferedWriter(new FileWriter(logFile));
			in = new Scanner(file);
			while (in.hasNext()) {
				String line = in.nextLine();
				if (line.contains(textSearched)) {
					writer.write(line + "\n");
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.info("FileNotFoundException in writeExcel method.");
		} finally {
			writer.close();
		}
	}

	/**
	 * This method writes input string to the history .csv file which can be
	 * viewed by all users.
	 *
	 * @param string
	 *            the string
	 */
	private void csvFileWriterHistory(String string) {

		final String COMMA_DELIMITER = ",";
		final String NEW_LINE_SEPARATOR = "\n";

		File file = new File("mainHistory.csv");
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			if (file.exists() == false) {
				file.createNewFile();
				fw = new FileWriter(file, true);
				bw = new BufferedWriter(fw);
			} else {
				fw = new FileWriter(file, true);
				bw = new BufferedWriter(fw);
				bw.write(string + NEW_LINE_SEPARATOR);
				logger.info("new menu file created by CsvFileWriterForMenu method.");
			}
		} catch (Exception e) {
			logger.info("error in CsvFileWriterForMenu method.");
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				logger.info("error in closing BufferedReader or FileWriter in CsvFileWriterForMenu method.");
				ex.printStackTrace();
			}
		}
	}

	/**
	 * Modified utility class that filters the table view and updates the table
	 * with search from text area from stackoverflow discussion board. Original
	 * Author: Zaid Sultan. Forum here:
	 * http://stackoverflow.com/questions/17017364/fast-filtering-in-javafx-tableview
	 */
	private void initFilterHistory() {
		txtField7.setPromptText("Filter");
		txtField7.textProperty().addListener(new InvalidationListener() {

			@Override
			public void invalidated(Observable o) {
				if (txtField7.textProperty().get().isEmpty()) {
					tablestage7.setItems(datastage7);
					return;
				}
				ObservableList<HistoryMain> tableItems = FXCollections.observableArrayList();
				ObservableList<TableColumn<HistoryMain, ?>> cols = tablestage7.getColumns();
				for (int i = 0; i < datastage7.size(); i++) {

					for (int j = 0; j < cols.size(); j++) {
						TableColumn col = cols.get(j);
						String cellValue = col.getCellData(datastage7.get(i)).toString();
						cellValue = cellValue.toLowerCase();
						if (cellValue.contains(txtField7.textProperty().get().toLowerCase())) {
							tableItems.add(datastage7.get(i));
							break;
						}
					}
				}
				tablestage7.setItems(tableItems);
			}
		});
	}

	/**
	 * reads order .csv file and times each item price by quantity before adding
	 * the sum all together to get the total cost for the current selected
	 * table.
	 *
	 * @param File
	 *            file name
	 */
	private void total(String File) {
		File file = new File(File);
		ArrayList<Double> result = new ArrayList<Double>();
		ArrayList<Double> quantity = new ArrayList<Double>();
		List<Double> vectorProd = new ArrayList<Double>();
		List<String> totalPriceString = new ArrayList<String>();
		List<String> totalQuantityString = new ArrayList<String>();
		if (file.exists()) {

			try (BufferedReader br = new BufferedReader(new FileReader(File))) {
				String line;

				while ((line = br.readLine()) != null) {
					String line_remove_1 = line.replaceAll("£", "");
					String line_remove = line_remove_1.replaceAll(" £", "");
					String[] split_line = line_remove.split(",");
					totalPriceString.add(split_line[1]);
					totalQuantityString.add(split_line[2]);
				}
				for (String stringValue : totalPriceString) {
					try {
						if (stringValue.contains(".")) {
							NumberFormat format = NumberFormat.getInstance(Locale.US);
							Number number = format.parse(stringValue);
							double d = number.doubleValue();
							result.add(d);
						} else {
							result.add(Double.parseDouble(stringValue));
						}
					} catch (NumberFormatException nfe) {
						logger.info("NumberFormatException in total method.");
					} catch (ParseException e) {
						logger.info(
								"ParseException in total method , cannot parse prices as a double. Wrong currency used.");
						e.printStackTrace();
					}
				}
				for (String stringValue2 : totalQuantityString) {
					try {

						quantity.add(Double.parseDouble(stringValue2));

					} catch (NumberFormatException nfe) {
						logger.info(
								"NumberFormatException in total method , cannot parse prices as a double. Wrong currency used.");
					}
				}

				if (result.size() != quantity.size()) {
					logger.info("array size for quantity and prices are different.");
				}
				for (int i = 0; i < totalQuantityString.size(); ++i) {
					vectorProd.add(result.get(i) * quantity.get(i));
				}
			} catch (FileNotFoundException e1) {
				logger.info("FileNotFoundException in total method.");
				e1.printStackTrace();
			} catch (IOException e1) {
				logger.info("IOException in total method.");
				e1.printStackTrace();
			}

			int i;
			double totalCost = 0.00;
			if (vectorProd.isEmpty()) {
				totalCost = 0;
			} else {
				for (i = 0; i < vectorProd.size(); i++) {
					totalCost += vectorProd.get(i);
				}
			}

			totalShow5.setText(String.valueOf(totalCost + "£"));

		}

	}

	/**
	 * trims the end of appended files (history and menu) when imported files
	 * are appended to them, producing 2 newlines at the end of file which cause
	 * problems.
	 *
	 * @param File
	 *            file name
	 */
	private void trim(String File) {

		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(File));
		} catch (FileNotFoundException e) {
			logger.info("FileNotFoundException in trim method.");
			e.printStackTrace();
		}
		PrintStream out = null;
		try {
			out = new PrintStream(new File(File + "temp.csv"));
		} catch (FileNotFoundException e) {
			logger.info("FileNotFoundException in trim method.");
			e.printStackTrace();
		}
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			line = line.trim();
			if (line.length() > 0)
				out.println(line);
		}

		File inFile = new File(File);
		if (!inFile.delete()) {
			return;
		}
		File tempFile = new File(File + "temp.csv");

		if (!tempFile.renameTo(inFile)) {
		}
	}

	/**
	 * readCSVHistory reads history to the tableview.
	 *
	 * @param File
	 *            file name
	 */
	private void readCSVHistory(String File) {
		String FieldDelimiter = ",";
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(File));

			String line;
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(FieldDelimiter, -1);

				HistoryMain HistoryMain = new HistoryMain(fields[0], fields[1], fields[2], fields[3], fields[4],
						fields[5], fields[6]);
				datastage7.add(HistoryMain);
			}
		} catch (FileNotFoundException e) {
			logger.info("FileNotFoundException in readCSVHistory method.");

		} catch (IOException e) {
			logger.info("IOException in readCSVHistory method.");
		}
	}

	/**
	 * read the log file to textarea in stage 9.
	 */
	private void fillTextarea() {
		try {

			Scanner s = new Scanner(new File("mylog.txt"));
			while (s.hasNext()) {
				if (s.hasNextInt()) {
					textArea9.appendText(s.nextInt() + "\n");

				} else {
					textArea9.appendText(s.next() + " ");
				}
			}

		} catch (FileNotFoundException ex) {
			logger.info("FileNotFoundException in fillTextarea method.");
		}

	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
}