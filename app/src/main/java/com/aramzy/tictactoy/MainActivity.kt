package com.aramzy.tictactoy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var btn1: Button;
    lateinit var btn2: Button;
    lateinit var btn3: Button;
    lateinit var btn4: Button;
    lateinit var btn5: Button;
    lateinit var btn6: Button;
    lateinit var btn7: Button;
    lateinit var btn8: Button;
    lateinit var btn9: Button;
    var player1: ArrayList<Int> = ArrayList<Int>();
    var player2: ArrayList<Int> = ArrayList<Int>();
    var activePlayer: Int = 1;
    var winner = -1;

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        // Code here

    }

    fun btnSelect(view: View) {

        val btn: Button = view as Button;
        var cellID: Int = 0;

        when(btn.id) {

            R.id.btn1 -> cellID = 1;
            R.id.btn2 -> cellID = 2;
            R.id.btn3 -> cellID = 3;
            R.id.btn4 -> cellID = 4;
            R.id.btn5 -> cellID = 5;
            R.id.btn6 -> cellID = 6;
            R.id.btn7 -> cellID = 7;
            R.id.btn8 -> cellID = 8;
            R.id.btn9 -> cellID = 9;

        }

        playGame(cellID, btn);
        checkWinner();

    }

    fun playGame(cellID: Int, btn: Button) {

        if(activePlayer == 1) {

            btn.text = "x";
            btn.setBackgroundResource(R.color.blue);
            player1.add(cellID);
            activePlayer = 2;
            autoPlay();

        } else if(activePlayer == 2) {

            btn.text = "o";
            btn.setBackgroundResource(R.color.dark_green);
            player2.add(cellID);
            activePlayer = 1;

        }

        btn.isEnabled = false;

    }

    fun checkWinner() {

        // row1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)) {

            winner = 1;

        } else if(player2.contains(1) && player2.contains(2) && player2.contains(3)) {

            winner = 2;

        }

        // row2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)) {

            winner = 1;

        } else if(player2.contains(4) && player2.contains(5) && player2.contains(6)) {

            winner = 2;

        }

        // row3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)) {

            winner = 1;

        } else if(player2.contains(7) && player2.contains(8) && player2.contains(9)) {

            winner = 2;

        }

        // col1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)) {

            winner = 1;

        } else if(player2.contains(1) && player2.contains(4) && player2.contains(7)) {

            winner = 2;

        }

        // col2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)) {

            winner = 1;

        } else if(player2.contains(2) && player2.contains(5) && player2.contains(8)) {

            winner = 2;

        }

        // col3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)) {

            winner = 1;

        } else if(player2.contains(3) && player2.contains(6) && player2.contains(9)) {

            winner = 2;

        }

        if(winner != -1) {

            if(winner == 1) {

                Toast.makeText(this, "Player 1 win the game", Toast.LENGTH_SHORT).show();

            } else if(winner == 2) {

                Toast.makeText(this, "Player 2 win the game", Toast.LENGTH_SHORT).show();

            }

        }

    }

    fun autoPlay() {

        val emptyCells: ArrayList<Int> = ArrayList<Int>();
        for(cellID in 1..9) {

            if (!(player1.contains(cellID) || player2.contains(cellID))) {

                emptyCells.add(cellID);

            }
        }

        val r: Random = Random();
        val randomIndex: Int = r.nextInt(emptyCells.size - 0) + 0;
        val cellId: Int = emptyCells[randomIndex];
        val btn: Button?;

        when(cellId) {

            1 -> btn = btn1;
            2 -> btn = btn2;
            3 -> btn = btn3;
            4 -> btn = btn4;
            5 -> btn = btn5;
            6 -> btn = btn6;
            7 -> btn = btn7;
            8 -> btn = btn8;
            9 -> btn = btn9;

            else -> {

                btn = btn1;

            }

        }

        playGame(cellId, btn);

    }

}
