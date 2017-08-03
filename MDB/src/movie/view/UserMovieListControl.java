package movie.view;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
* Purpose of Class: - allows users to search throw movie list or click on genre page
*/

public class UserMovieListControl extends AnchorPane
{

	Connection connection;
	
	@FXML
 	private Label isConnected;
	@FXML
	private Button backBT;
	@FXML
	private Button genrePageBT;
	@FXML
	private Button userHomeBT;
	@FXML
	private ListView<String> moviesLV;
	
	private boolean isAdmin;
	
	public void setAdmin(boolean isAdmin)
	{
		this.isAdmin = isAdmin;
	}
	
  	public MovieModel mm = new MovieModel();
  	
  	
  	public void setLabel(String label)
  	{
  		isConnected.setText(label);
  	}
  	

  	@FXML
  	public void initialize()
  	{
  		connection = SqliteConnection.Connector();
  		showMovies();
  	}
 	
 	public void userSetMovies(ArrayList<String> userAL)
 	{
 		moviesLV.setItems(FXCollections.observableArrayList(userAL));
 	}
 	
 	
 	public void showMovies()
 	{
 		ArrayList<String> movies = mm.getMovies();
 		ObservableList<String> m = FXCollections.observableArrayList(movies);

		moviesLV.setItems(m);
		moviesLV.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
			
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
				//System.out.println(newValue);
				try {
		 	  		
		  			Stage primaryStage;
		  			
		  			primaryStage = (Stage)moviesLV.getScene().getWindow();
		  			
		  			FXMLLoader loader = new FXMLLoader();    //check file name here
		  			loader.setLocation(Main.class.getResource("view/UserGenericMoviePage.fxml"));
		  			AnchorPane rootLayout = (AnchorPane) loader.load();
		  			
		  			UserGenericMovieControl g = loader.getController();
		  			g.setMovie(newValue);
		  			//g.setAdmin(isAdmin);
		  			
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
		});
 	}
 	@FXML
   	public void loadGenrePage()
   	{
   		try {
   		
   			Stage primaryStage;
   			
   			primaryStage = (Stage)genrePageBT.getScene().getWindow();
   			
   			FXMLLoader loader = new FXMLLoader();    //check file name here
   			loader.setLocation(Main.class.getResource("view/UserGenreSearchView.fxml"));
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
   	public void loadUserHomePage()
   	{
   		try {
   		
   			Stage primaryStage;
   			
   			primaryStage = (Stage)genrePageBT.getScene().getWindow();
   			
   			FXMLLoader loader = new FXMLLoader();    //check file name here
   			loader.setLocation(Main.class.getResource("view/UserMovieList2.fxml"));
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