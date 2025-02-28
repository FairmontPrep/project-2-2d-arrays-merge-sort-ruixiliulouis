import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChessBoardGUI extends JFrame {
    private GameBoard gameBoard;
    private JPanel boardPanel;

    public ChessBoardGUI(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        setTitle("Chess Board");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        boardPanel = new JPanel();
        updateBoard();
        add(boardPanel, BorderLayout.CENTER);

        JButton sortButton = new JButton("Sort All Rows");
        sortButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            gameBoard.sortAllRows(); // 排序所有行
            updateBoard(); // 更新 GUI
        }
        });
        add(sortButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void updateBoard() {
        boardPanel.removeAll();
        boardPanel.setLayout(new GridLayout(8, 8));

        for (ArrayList<GamePiece> row : gameBoard.getBoard()) {
            for (GamePiece piece : row) {
                JButton button = new JButton(piece.toString());
                boardPanel.add(button);
            }
        }

        boardPanel.revalidate();
        boardPanel.repaint();
    }
}