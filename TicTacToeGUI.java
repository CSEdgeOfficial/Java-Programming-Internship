//Task-7 Medium Level
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class TicTacToeGUI extends Frame implements ActionListener {

    private Button[][] buttons;
    private int playerTurn;
    private String player1Name;
    private String player2Name;

    public TicTacToeGUI() {
        super("Tic-Tac-Toe");

        // Prompt players to enter their names
        player1Name = JOptionPane.showInputDialog(this, "Enter Player 1's Name:");
        player2Name = JOptionPane.showInputDialog(this, "Enter Player 2's Name:");

        setLayout(new GridLayout(3, 3));

        buttons = new Button[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new Button();
                buttons[i][j].addActionListener(this);
                add(buttons[i][j]);
            }
        }

        playerTurn = 1;
    }

    public void actionPerformed(ActionEvent e) {
        Button button = (Button) e.getSource();

        if (button.getLabel().equals("")) {
            if (playerTurn == 1) {
                button.setLabel("X");
            } else {
                button.setLabel("O");
            }

            playerTurn = playerTurn == 1 ? 2 : 1;

            checkWinner();
        }
    }

    private void checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getLabel().equals(buttons[i][1].getLabel()) && buttons[i][1].getLabel().equals(buttons[i][2].getLabel()) && !buttons[i][0].getLabel().equals("")) {
                declareWinner(buttons[i][0].getLabel());
                return;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (buttons[0][i].getLabel().equals(buttons[1][i].getLabel()) && buttons[1][i].getLabel().equals(buttons[2][i].getLabel()) && !buttons[0][i].getLabel().equals("")) {
                declareWinner(buttons[0][i].getLabel());
                return;
            }
        }

        if (buttons[0][0].getLabel().equals(buttons[1][1].getLabel()) && buttons[1][1].getLabel().equals(buttons[2][2].getLabel()) && !buttons[0][0].getLabel().equals("")) {
            declareWinner(buttons[0][0].getLabel());
            return;
        }

        if (buttons[0][2].getLabel().equals(buttons[1][1].getLabel()) && buttons[1][1].getLabel().equals(buttons[2][0].getLabel()) && !buttons[0][2].getLabel().equals("")) {
            declareWinner(buttons[0][2].getLabel());
            return;
        }

        if (isBoardFull()) {
            declareWinner("Tie");
        }
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getLabel().equals("")) {
                    return false;
                }
            }
        }

        return true;
    }

    private void declareWinner(String winner) {
        String winnerName;
        String loserName;

        if (winner.equals("Tie")) {
            JOptionPane.showMessageDialog(this, "It's a tie!");
            resetGame();
            return;
        } else if (winner.equals("X")) {
            winnerName = player1Name;
            loserName = player2Name;
        } else {
            winnerName = player2Name;
            loserName = player1Name;
        }

        JOptionPane.showMessageDialog(this, winnerName + " wins!\n" + loserName + " loses!");

        resetGame();
    }

    private void resetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setLabel("");
            }
        }

        playerTurn = 1;
    }

    public static void main(String[] args) {
        TicTacToeGUI game = new TicTacToeGUI();
        game.setSize(300, 300);
        game.setVisible(true);
    }
}
