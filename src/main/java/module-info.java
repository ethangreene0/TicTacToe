module org.openjfx.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.openjfx.tictactoe to javafx.fxml;
    exports org.openjfx.tictactoe;
}