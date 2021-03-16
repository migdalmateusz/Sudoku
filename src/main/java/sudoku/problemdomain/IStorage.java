package sudoku.problemdomain;

public interface IStorage {
    void updateGameData(SudokuGame game);
    SudokuGame getGameData();
}
