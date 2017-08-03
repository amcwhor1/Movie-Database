package movie.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import movie.Main;

/** Class: 
* @author Alex McWhorter
* @version 1.0
* Completed: Summer 2017
* 
* Purpose of Class: - Contains method to go to either: add movie page, update/delete movie page
*/

public class AdminHomeControl extends AnchorPane
{
	@FXML
	private Button addMovieBT;
	@FXML
	private Button updateDeleteMovieBT;

	@FXML
    private Button backBT;
	
	@FXML
	public void loadAddMoviePage()
	{
		
		try {
		
			Stage primaryStage;
			
			primaryStage = (Stage)addMovieBT.getScene().getWindow();
			
			FXMLLoader loader = new FXMLLoader();    
			loader.setLocation(Main.class.getResource("view/AddMoviePage1.fxml"));
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
	public void loadUpdateDeleteMoviePage()
	{
		
		try {
		
			Stage primaryStage;
			
			primaryStage = (Stage)updateDeleteMovieBT.getScene().getWindow();
			
			FXMLLoader loader = new FXMLLoader();    
			loader.setLocation(Main.class.getResource("view/UpdateDeleteMoviePage2.fxml"));
			UpdateDeleteMovieControl upmc = loader.getController();
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
   	public void loadPrevPage()
   	{
   		
   		try {
   		
   			Stage primaryStage;
   			
   			primaryStage = (Stage)backBT.getScene().getWindow();
   			
   			FXMLLoader loader = new FXMLLoader();    //check file name here
   			loader.setLocation(Main.class.getResource("view/AdminLogin.fxml"));
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