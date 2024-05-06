package com.example.tictoe.model;

import android.widget.Button;
import android.widget.TextView;

import com.example.tictoe.event.OnCaseClick;

public class Board {
    private Button[] cases = new Button[9];
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private int clickableButtonLeft = 0;
    private TextView scoreView;

    public Board(Button[] cases, Player player1, Player player2, TextView scoreView) {
        this.cases = cases;
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        clickableButtonLeft = cases.length;
        this.scoreView = scoreView;
        setButtonsClickable();
    }

    /**
     * Make the button clickable with OnCaseClick
     */
    private void setButtonsClickable() {
        OnCaseClick onCaseClick = new OnCaseClick(this);
        for (Button btn : cases
             ) {
            btn.setOnClickListener(onCaseClick);
        }
    }

    /**
     * Check if the board is full
     * @return
     */
    public boolean isBoardFull() {
        return clickableButtonLeft == 0;
    }

    /**
     * decrement the clickable button lef
     */
    public void decrementClickablButtonLeft(){
        clickableButtonLeft --;
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    /**
     * Switch the current player to the next player
     */
    public void switchPlayer(){
        if(currentPlayer == player1){
            currentPlayer = player2;
        }else{
            currentPlayer = player1;
        }
    }

    public Button[] getCases() {
        return cases;
    }

    /**
     * Update the view score
     */
    public void updateScore() {
        String score = player1.getScore() + " : "+ player2.getScore();
        scoreView.setText(score);
    }

    /**
     * make all the button clickable and remove all emojis on it
     */
    public void replay() {
        for (Button btn : cases
             ) {
            btn.setText("");
            btn.setEnabled(true);
        }
    }
}
