package ee.itcollege.tetris;

import ee.itcollege.tetris.lib.FigureGenerator;
import ee.itcollege.tetris.parts.Block;
import ee.itcollege.tetris.parts.Figure;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TetrisGame extends Application {

	public static final int FIELD_HEIGHT = 30;
	public static final int FIELD_WIDHT = 15;

	public static void main(String[] args) {
		TetrisGame.launch(args);
	}

	FigureGenerator figureGenerator = new FigureGenerator();

	@Override
	public void start(Stage window) throws Exception {
		Figure figure = figureGenerator.createFigure();
		Pane layout = new Pane();
		layout.getChildren().addAll(figure);
		Scene scene = new Scene(layout,
				Block.SIZE * FIELD_WIDHT,
				Block.SIZE * FIELD_HEIGHT);

		scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
			System.out.println(event.getCode());
		});

		window.setOnCloseRequest(e -> System.exit(0));
		window.setScene(scene);
		window.show();
	}

}
