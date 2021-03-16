package sudoku.persistance;

import sudoku.problemdomain.IStorage;
import sudoku.problemdomain.SudokuGame;

import java.io.*;

public class LocalStorageImpl implements IStorage {
    private static final File gameData = new File(
            System.getProperty("user.home"),
            "gamedata.txt"
    );

    @Override
    public void updateGameData(SudokuGame game) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(gameData);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(game);
            objectOutputStream.close();
        } catch (IOException e) {
            throw new IllegalStateException("Unable to access Game Data", e);
        }

    }

    @Override
    public SudokuGame getGameData()  {
        try {
            FileInputStream fileInputStream = new FileInputStream(gameData);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            SudokuGame gameState = (SudokuGame) objectInputStream.readObject();
            objectInputStream.close();
            return gameState;
        } catch (IOException | ClassNotFoundException e ) {
            throw new IllegalStateException ("File Not Found", e);
        }
    }
}