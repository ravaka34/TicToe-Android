package com.example.tictoe.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.tictoe.R;
import com.example.tictoe.model.Board;
import com.example.tictoe.model.Player;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        Button[] cases = getCases();
        Player player1 = new Player("\uD83D\uDE02");
        Player player2 = new Player("\uD83D\uDE0D");
        TextView scoreView = (TextView) findViewById(R.id.scoreView);
        Board board = new Board(cases, player1, player2, scoreView);
    }

    private Button[] getCases() {
        Button[] cases = new Button[9];
        for (int i =0; i < 9; i++) {
            cases[i] = (Button) findViewById(getResources().getIdentifier("button" + i, "id",
                    this.getPackageName()));
        }
        return cases;
    }
}