package com.example.tictoe.model;

import android.widget.Button;

public class Player {
    private String emoji;
    private int score = 0;


    public Player(String emoji) {
        this.emoji = emoji;
    }

    /**
     * Draw the emoji on the button and make it unclickable
     * @param button
     */
    public void play(Button button){
       //TODO implement play
        button.setText(emoji);
//        button.setEnabled(false);

    }

    /**
     * Check if the current player wins the game
     * @param buttons
     * @return
     */
    public boolean isWinner(Button[] buttons){
        //check rows
        for(int row = 0; row < 3; row++){
            int beginRow = row * 3;
            if(buttons[beginRow].getText().equals(emoji) &&
                    buttons[beginRow+1].getText().equals(emoji) && buttons[beginRow+2].getText().equals(emoji)){
                return true;
            }
        }

        //check cols
        for(int col = 0; col < 3; col++){
            if(buttons[col].getText().equals(emoji) &&
                    buttons[col+3].getText().equals(emoji) && buttons[col+6].getText().equals(emoji)){
                return true;
            }
        }

        //check the diagonals
        if (buttons[0].getText().equals(emoji) && buttons[4].getText().equals(emoji) && buttons[8].getText().equals(emoji)) {
            return true;
        }

        if (buttons[2].getText().equals(emoji) && buttons[4].getText().equals(emoji) && buttons[6].getText().equals(emoji)) {
            return true;
        }
        return false;
    }

    /**
     * Increment the score of the player
     */
    public void incrementScore(){
        score ++;
    }

    public int getScore() {
        return score;
    }
}
