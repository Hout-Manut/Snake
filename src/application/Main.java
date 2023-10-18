package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	public int width = 1280;
	public int height = 720; 
	
	private Menu menu;
	private Game game;
	
	private static String bgColor = "#eaeaea";
	
	@Override
	public void start(Stage primaryStage) {
		try {
			StackPane root = new StackPane();
			Scene scene = new Scene(root, width, height, Color.web(bgColor));
			
			menu = new Menu(this);
			game = new Game(this);
			
			root.getChildren().addAll(game, menu);
			
			game.toFront();
			
			game.setVisible(false);
			menu.setVisible(true);
			primaryStage.setScene(scene);
			primaryStage.show();
			
	        scene.widthProperty().addListener((obs, oldWidth, newWidth) -> {
	            width = newWidth.intValue();
	        });

	        scene.heightProperty().addListener((obs, oldHeight, newHeight) -> {
	            height = newHeight.intValue();
	        });
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void switchToGame() {
		menu.setVisible(false);
		game.setVisible(true);
	}
	
	public void switchToMenu() {
		game.setVisible(false);
		menu.setVisible(true);
	}
}
