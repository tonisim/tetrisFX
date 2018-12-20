package ee.itcollege.tetris;

import ee.itcollege.tetris.lib.FigureGenerator;
import ee.itcollege.tetris.parts.Block;
import ee.itcollege.tetris.parts.Figure;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TetrisGame extends Application {

    public static final int FIELD_HEIGHT = 30;
    public static final int FIELD_WIDTH = 15;

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
                Block.SIZE * FIELD_WIDTH,
                Block.SIZE * FIELD_HEIGHT);

        scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.RIGHT) {
                figure.move(1, 0);
            } else if (event.getCode() == KeyCode.LEFT) {
                figure.move(-1, 0);
            } else if (event.getCode() == KeyCode.UP) {
                figure.rotate();
            } else if (event.getCode() == KeyCode.DOWN) {
                figure.move(0, 1);
            } else {
                figure.move(0, 0);
            }
            System.out.println(event.getCode());
        });

        window.setOnCloseRequest(e -> System.exit(0));
        window.setScene(scene);
        window.show();
    }

}
