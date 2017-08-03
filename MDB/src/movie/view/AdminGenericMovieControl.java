package movie.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
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
* Purpose of Class: - Contains the methods to update or delete the movie
*/

public class AdminGenericMovieControl extends AnchorPane 
{

	@FXML
	private Text titleTX;
	@FXML
	private TextArea castTA;
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
	private TextArea summaryTA;
	
	@FXML
	private Button backBT;
	@FXML
	private Button updateBT;
	@FXML
	private Button deleteBT;
	
	
	
  	public MovieModel mm = new MovieModel();

	
	@FXML
	public void updateDB()
	{
		String title = titleTX.getText();
		String cast = castTA.getText();
 		String rating = ratingTF.getText();
 		String genre = genreTF.getText();
 		String runtime = runtimeTF.getText();
 		String category = categoryTF.getText();
 		String releaseDate = releaseDateTF.getText();
 		String summary = summaryTA.getText();
 		
 		mm.updateMovie (title, cast, rating, genre, runtime, category, releaseDate, summary);
 		loadPrevPage("Movie Updated");
	}
	
	@FXML
	public void deleteFromDB()
	{
		mm.deleteMovie(titleTX.getText());
		
		loadPrevPage("Movie Deleted");
	}
	
	@FXML
	public void loadPreviousTest()
	{
		loadPrevPage("");
	}
	
	
   	public void loadPrevPage(String label)
   	{
   		
   		try {
   		
   			Stage primaryStage;
   			
   			primaryStage = (Stage)backBT.getScene().getWindow();
   			
   			FXMLLoader loader = new FXMLLoader();    
   			loader.setLocation(Main.class.getResource("view/UpdateDeleteMoviePage2.fxml"));
   			AnchorPane rootLayout = (AnchorPane) loader.load();
   			
   			UpdateDeleteMovieControl obj = loader.getController();
   			obj.setLabel(label);
   			
   			 	
   			Scene scene = new Scene(rootLayout);
   			primaryStage.setScene(scene);
   			primaryStage.show();
   			} 
   			catch(IOException e)
   			{
   				e.printStackTrace();
   			}
   	}

	/**
	 * @param newValue
	 */
	public void setMovie(String newValue)
	{

		Object[] movieInfo = mm.getMovie(newValue);
		titleTX.setText(newValue);
		castTA.setText((String) movieInfo[0]);
		ratingTF.setText(movieInfo[1].toString());
		genreTF.setText((String) movieInfo[2]);
		runtimeTF.setText((String) movieInfo[3]);
		categoryTF.setText((String) movieInfo[4]);
		releaseDateTF.setText((movieInfo[5].toString()));
		summaryTA.setText((String) movieInfo[6]);

		
	}


	
}
