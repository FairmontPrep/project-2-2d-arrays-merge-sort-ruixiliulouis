import java.util.ArrayList;
import java.util.Arrays;

public class GameBoard {
    private ArrayList<ArrayList<GamePiece>> board;

    public GameBoard() {
        board = new ArrayList<>();

        // 初始化棋盘
        board.add(new ArrayList<>(Arrays.asList( // 黑方第一排
            new GamePiece("Rook", 5), new GamePiece("Knight", 3), new GamePiece("Bishop", 3),
            new GamePiece("Queen", 9), new GamePiece("King", 10), new GamePiece("Bishop", 3),
            new GamePiece("Knight", 3), new GamePiece("Rook", 5)
        )));

        board.add(new ArrayList<>(Arrays.asList( // 黑方兵
            new GamePiece("Pawn", 1), new GamePiece("Pawn", 1), new GamePiece("Pawn", 1),
            new GamePiece("Pawn", 1), new GamePiece("Pawn", 1), new GamePiece("Pawn", 1),
            new GamePiece("Pawn", 1), new GamePiece("Pawn", 1)
        )));

        for (int i = 0; i < 4; i++) { // 4 行空白
            board.add(new ArrayList<>(Arrays.asList(
                new GamePiece("Empty", 0), new GamePiece("Empty", 0), new GamePiece("Empty", 0),
                new GamePiece("Empty", 0), new GamePiece("Empty", 0), new GamePiece("Empty", 0),
                new GamePiece("Empty", 0), new GamePiece("Empty", 0)
            )));
        }

        board.add(new ArrayList<>(Arrays.asList( // 白方兵
            new GamePiece("Pawn", 1), new GamePiece("Pawn", 1), new GamePiece("Pawn", 1),
            new GamePiece("Pawn", 1), new GamePiece("Pawn", 1), new GamePiece("Pawn", 1),
            new GamePiece("Pawn", 1), new GamePiece("Pawn", 1)
        )));

        board.add(new ArrayList<>(Arrays.asList( // 白方第一排
            new GamePiece("Rook", 5), new GamePiece("Knight", 3), new GamePiece("Bishop", 3),
            new GamePiece("Queen", 9), new GamePiece("King", 10), new GamePiece("Bishop", 3),
            new GamePiece("Knight", 3), new GamePiece("Rook", 5)
        )));
    }

    public ArrayList<ArrayList<GamePiece>> getBoard() {
        return board;
    }

    public void sortAllRows() {
        for (int i = 0; i < board.size(); i++) {
            boolean hasPiece = false;
            for (GamePiece piece : board.get(i)) {
                if (!piece.getName().equals("Empty")) { // 检查是否为非空格子
                    hasPiece = true;
                    break;
                }
            }
            if (hasPiece) {
                board.set(i, MergeSort.sort(board.get(i))); // 排序该行
            }
        }
    }
}