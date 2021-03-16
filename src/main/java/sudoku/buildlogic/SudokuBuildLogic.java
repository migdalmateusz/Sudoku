package sudoku.buildlogic;

import sudoku.computationlogic.GameLogic;
import sudoku.persistance.LocalStorageImpl;
import sudoku.problemdomain.IStorage;
import sudoku.problemdomain.SudokuGame;
import sudoku.userinterface.IUserInterfaceContract;
import sudoku.userinterface.logic.ControlLogic;

public class SudokuBuildLogic {

    private SudokuBuildLogic() {
    }

    public static void build(IUserInterfaceContract.View userInterface) {
        SudokuGame initialState;
        IStorage storage = new LocalStorageImpl();

        initialState = GameLogic.getNewGame();
        storage.updateGameData(initialState);

        IUserInterfaceContract.EventListener uiLogic = new ControlLogic(storage, userInterface);

        userInterface.setListener(uiLogic);
        userInterface.updateBoard(initialState);
    }
}

