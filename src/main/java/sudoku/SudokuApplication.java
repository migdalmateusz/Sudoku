package sudoku;

import javafx.application.Application;
import javafx.stage.Stage;
import sudoku.buildlogic.SudokuBuildLogic;
import sudoku.userinterface.UserInterfaceImpl;

public class SudokuApplication extends Application {

    @Override
    public void start(Stage primaryStage) {

        UserInterfaceImpl uiImpl = new UserInterfaceImpl(primaryStage);

        SudokuBuildLogic.build(uiImpl);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
