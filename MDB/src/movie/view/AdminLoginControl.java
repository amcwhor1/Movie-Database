package movie.view;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import movie.Main;
import movie.model.MovieModel;

/** Class: 
* @author Alex McWhorter
* @version 1.0
* Completed: Summer 2017
* 
* Purpose of Class: - Admin must login with correct credentials that are
* placed in sqLite db
*/

public class AdminLoginControl extends AnchorPane
{
	@FXML
	private Label isConnected;
	
	
	@FXML
	private Text unpw;
	@FXML
	private Button loginBT;
	@FXML
	private Button backBT;
	@FXML
	private TextField unTF;
	@FXML
	private TextField pwPF;

	public MovieModel mm = new MovieModel();

	@FXML
	public void Login() throws IOException
	{
		try
		{
			if(mm.isLogin(unTF.getText(), pwPF.getText()))
			{
				Stage primaryStage;

				primaryStage = (Stage)loginBT.getScene().getWindow();

				FXMLLoader loader = new FXMLLoader();    //check file name here
				loader.setLocation(Main.class.getResource("view/AdminHome.fxml"));
				AnchorPane rootLayout = (AnchorPane) loader.load();

				// Show the scene containing the root layout.	
				Scene scene = new Scene(rootLayout);
				primaryStage.setScene(scene);
				primaryStage.show();
			}else
			{
				unpw.setText("username and password is incorrect");
			}

		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@FXML
	public void loadAdminHomePage()
	{
		//System.out.println("Button clicked");
		try {

			Stage primaryStage;

			primaryStage = (Stage)loginBT.getScene().getWindow();

			FXMLLoader loader = new FXMLLoader();    //check file name here
			loader.setLocation(Main.class.getResource("view/AdminHome.fxml"));
			AnchorPane rootLayout = (AnchorPane) loader.load();

			// Show the scene containing the root layout.	
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	@FXML
	public void loadPrevPage()
	{
		//System.out.println("Button clicked");
		try {

			Stage primaryStage;

			primaryStage = (Stage)backBT.getScene().getWindow();

			FXMLLoader loader = new FXMLLoader();    //check file name here
			loader.setLocation(Main.class.getResource("view/FirstScreen.fxml"));
			AnchorPane rootLayout = (AnchorPane) loader.load();

			// Show the scene containing the root layout.	
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}




}