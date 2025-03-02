package org.openjfx.tictactoe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    private InfoCenter infoCenter;
    private TileBoard tileBoard;

    @Override
    public void start(Stage stage) {
        try{
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root,UIConstants.APP_WIDTH, UIConstants.APP_HEIGHT);
            initLayout(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initLayout(BorderPane root) {
        initInfoCenter(root);
        initTileBoard(root);
    }

    private void initTileBoard(BorderPane root) {
        tileBoard = new TileBoard(infoCenter);
        root.getChildren().add(tileBoard.getStackPane());

    }

    private void initInfoCenter(BorderPane root) {
        infoCenter = new InfoCenter();
        infoCenter.setStartButtonOnAction(startNewGame());
        root.getChildren().add(infoCenter.getStackPane());

    }

    private EventHandler<ActionEvent> startNewGame(){
        return _ -> {
            infoCenter.hideStartButton();
            infoCenter.updateMessage("Player X's Turn");
            tileBoard.startNewGame();
        };
    }

    public static void main(String[] args) {
        launch(args);
    }
}