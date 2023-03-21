import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class game extends JFrame implements ActionListener {

    private JButton rockButton, paperButton, scissorsButton;
    private JTextField textField, textField2;

    public static void main(String[] args) {
        game paper = new game();
//        paper.setExtendedState(JFrame.MAXIMIZED_BOTH);
        paper.setSize(350,150); // Setting up the pane
        paper.createGUI();
        paper.show();
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        textField = new JTextField(15); // Setting up the buttons/fields
        window.add(textField);

        textField2 = new JTextField(15);
        window.add(textField2);

        rockButton = new JButton("Rock");
        window.add(rockButton);
        rockButton.addActionListener(this);

        paperButton = new JButton("Paper");
        window.add(paperButton);
        paperButton.addActionListener(this);

        scissorsButton = new JButton("Scissors");
        window.add(scissorsButton);
        scissorsButton.addActionListener(this);

    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        int playerChoice;
        int compChoice;
        String winner;
        Random randomSeed = new Random();
        if (source == rockButton) {
            playerChoice = 0;
        }
        else if (source == paperButton){
            playerChoice = 1;
        } else {
            playerChoice = 2;
        }
        compChoice = randomSeed.nextInt(3);
        winner = findWinner(playerChoice, compChoice);
        textField.setText("Winner is " + winner + "!");

        if (compChoice == 0) {
            textField2.setText("Computer chose rock");
        } else if (compChoice == 1) {
            textField2.setText("Computer chose paper");
        } else {
            textField2.setText("Computer chose scissors");
        }

    }
    private String findWinner(int playerChoice, int compChoice) {
        String winner;
        if (playerChoice == compChoice) {
            winner = "IT'S A TIE";
        } else if (playerChoice == 0 && compChoice == 1) {
            winner = "COMPUTER";
        } else if (playerChoice == 1 && compChoice == 2) {
            winner = "COMPUTER";
        } else if (playerChoice == 2 && compChoice == 0) {
            winner = "COMPUTER";
        } else {
            winner = "PLAYER";
        } return winner;
    }
}