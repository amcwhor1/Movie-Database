package movie.model;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/** Class: 
	* @author Alex McWhorter
	* @version 1.0
	* Completed: Summer 2017
	* 
	* Purpose of Class: - Overrides the initialize method
*/

public class MovieControl implements Initializable
{
	public MovieModel movieModel = new MovieModel();
	
	
	
	@FXML
	private Label isConnected;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		if(movieModel.isDbConnected())
		{
			isConnected.setText("Connected");
		}else
		{
			isConnected.setText("Not Connected");
		}
		
	}

}
