package movie.view;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import movie.Main;
import movie.model.MovieModel;
import movie.model.SqliteConnection;

/** Class: 
* @author Alex McWhorter
* @version 1.0
* Completed: Summer 2017
* 
* Purpose of Class: - Contains methods necessary for the admin to add movies
*  to the sqLite database
*/

public class AddMovieControl extends AnchorPane implements Initializable 
{
	
	Connection connection;
	
	@FXML
	private TextField titleTF;
	@FXML
	private TextArea castTF;
	@FXML
	private TextField ratingTF;
	@FXML
	private TextField genreTF;
	@FXML
	private TextField runtimeTF;
	@FXML
	private TextField categoryTF;
	@FXML
	private TextField releaseDateTF;
	@FXML
	private TextArea summaryTF;
	@FXML
	private TextField testTF;
    
	@FXML
    private Button submitBT;
    @FXML
    private Button cancelBT;
  	@FXML
 	private Label isConnected;
  	
  	public MovieModel mm = new MovieModel();
 	
 	
  	public AddMovieControl()
 	{
 		connection = SqliteConnection.Connector();
		if(connection == null) System.exit(1);
 	}
 	
 	public void initialize(URL location, ResourceBundle resources)
 	{
 		if(mm.isDbConnected())
 		{
 			isConnected.setText("Connected");
 		}else
 		{
 			isConnected.setText("Not Connected");
 		}
 	}
     
     @FXML
 	public void loadSubmitMoviePage()
 	{
 		String title = titleTF.getText();
 		String cast = castTF.getText();
 		String rating = ratingTF.getText();
 		String genre = genreTF.getText();
 		String runtime = runtimeTF.getText();
 		String category = categoryTF.getText();
 		String releaseDate = releaseDateTF.getText();
 		String summary = summaryTF.getText();
 		
 		mm.addMovie(title, cast, rating, genre, runtime, category, releaseDate, summary);
	
 		try {
 	  		
  			Stage primaryStage;
  			
  			primaryStage = (Stage)cancelBT.getScene().getWindow();
  			
  			FXMLLoader loader = new FXMLLoader();    //check file name here
  			loader.setLocation(Main.class.getResource("view/UpdateDeleteMoviePage2.fxml"));
  			AnchorPane rootLayout = (AnchorPane) loader.load();
  			
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
  	public void loadCancelMoviePage()
  	{
  		
  		try {
  		
  			Stage primaryStage;
  			
  			primaryStage = (Stage)cancelBT.getScene().getWindow();
  			
  			FXMLLoader loader = new FXMLLoader();    //check file name here
  			loader.setLocation(Main.class.getResource("view/AdminHome.fxml"));
  			AnchorPane rootLayout = (AnchorPane) loader.load();
  			
  			
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
