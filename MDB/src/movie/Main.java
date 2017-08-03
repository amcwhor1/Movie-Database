package movie;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage primaryStage;
	private AnchorPane rootLayout;
	
	
	@Override
	public void start(Stage primaryStage) throws IOException
	{
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("The Movie Database");
		
		initRootLayout();
		
		//showMovieOverview();
	}
	
	public void initRootLayout() 
	{
		try {
			
		FXMLLoader loader = new FXMLLoader();    //check file name here
		loader.setLocation(Main.class.getResource("view/firstScreen.fxml"));
		rootLayout = (AnchorPane) loader.load();
		
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
	
	public void showMovieOverview()
	{
		try {	
		FXMLLoader loader = new FXMLLoader();    //check file name here
		loader.setLocation(Main.class.getResource("view/MovieOverview.fxml"));
		AnchorPane movieOverview = (AnchorPane) loader.load();
		
		//rootLayout.setCenter(movieOverview);
		
		}catch(IOException e)
		
		{
			e.printStackTrace();
		}
	}

	public Stage getPrimaryStage() {
        return primaryStage;
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}