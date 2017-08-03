package movie.view;

import java.io.IOException;
import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import movie.Main;
import movie.model.MovieModel;

/** Class: 
* @author Alex McWhorter
* @version 1.0
* Completed: Summer 2017
* 
* Purpose of Class: - Allows user to click a genre and go to movies with that genre
*/

public class UserGenreSearchControl extends AnchorPane
{


	@FXML
	private Button backBT;
	@FXML
	private ListView<String> genreLV;

	MovieModel mm = new MovieModel();

	@FXML
	public void initialize()
	{
		ArrayList<String> genreAL = new ArrayList<String>();
		genreAL.add("adventure");
		genreAL.add("action");
		genreAL.add("comedy");
		genreAL.add("drama");
		genreAL.add("documentary");
		genreAL.add("fantasy");
		genreAL.add("horror");
		genreAL.add("musical");
		genreAL.add("romance");
		genreAL.add("scifi");
		genreAL.add("war");
		genreAL.add("western");

		genreLV.setItems(FXCollections.observableArrayList(genreAL));

		genreLV.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){

			
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){

				try {

					Stage primaryStage;

					primaryStage = (Stage)genreLV.getScene().getWindow();

					FXMLLoader loader = new FXMLLoader();    //check file name here
					loader.setLocation(Main.class.getResource("view/UserMovieList2.fxml"));
					AnchorPane rootLayout = (AnchorPane) loader.load();

					ArrayList<String> genreAL = mm.getMovieGenres(newValue);

					UserMovieListControl g = loader.getController();

					g.userSetMovies(genreAL);
					g.setAdmin(false);

					
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
	public void loadPrevPage()
	{
		
		try {

			Stage primaryStage;

			primaryStage = (Stage)backBT.getScene().getWindow();

			FXMLLoader loader = new FXMLLoader();    
			loader.setLocation(Main.class.getResource("view/UserMovieList2.fxml"));
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