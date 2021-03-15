package sudoku.buildLogic;

import sudoku.computationLogic.GameLogic;
import sudoku.persistance.LocalStorageImpl;
import sudoku.problemDomain.IStorage;
import sudoku.problemDomain.SudokuGame;
import sudoku.userInterface.IUserInterfaceContract;
import sudoku.userInterface.logic.ControlLogic;

import java.io.IOException;

public class SudokuBuildLogic {
    public static void build(IUserInterfaceContract.View userInterface) throws IOException {
        SudokuGame initialState;
        IStorage storage = new LocalStorageImpl();

        try {
            initialState = storage.getGameData();
        } catch (IOException e) {
            initialState = GameLogic.getNewGame();
            storage.updateGameData(initialState);
        }

        IUserInterfaceContract.EventListener uiLogic = new ControlLogic(storage, userInterface);

        userInterface.setListener(uiLogic);
        userInterface.updateBoard(initialState);
    }
}
