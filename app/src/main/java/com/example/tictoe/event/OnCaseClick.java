package com.example.tictoe.event;

import android.view.View;
import android.widget.Button;

import com.example.tictoe.model.Board;
import com.example.tictoe.model.Player;

public class OnCaseClick implements View.OnClickListener{
    private Board board;

    public OnCaseClick(Board board) {
        this.board = board;
    }

    /**
     * The player plays on the case clicked
     * then we check if it wins the game
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        Player currentPlayer = board.getCurrentPlayer();
        currentPlayer.play((Button) v);
        board.decrementClickablButtonLeft();
        board.switchPlayer();
        if(currentPlayer.isWinner(board.getCases())){
            //if it wins we increment the score
            currentPlayer.incrementScore();
            //update the view score
            board.updateScore();
            //replay the game
            board.replay();
        } else if(board.isBoardFull()) {
            board.replay();
        }
    }
}
