package com.example.andyr.whatscore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_score.*

class ScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        submit_button.setOnClickListener { calculate() }
    }

    private fun calculate() {

        var score: Double = 0.0;

        if (min_time.text.isEmpty()) {
            Toast.makeText(this, "Please Enter Min Time", Toast.LENGTH_LONG).show()
            return
        }
        if (max_time.text.isEmpty()) {
            Toast.makeText(this, "Please Enter Max Time", Toast.LENGTH_LONG).show()
            return
        }

        val minimum : Double = min_time.text.toString().toDouble()
        val maximum : Double = max_time.text.toString().toDouble()
        val firstTime = minimum * .5
        val wonTheGame = maximum * .5
        score = (minimum + maximum) / 2

        //Min and Max time are entered
        if(check_won.isChecked && check_first.isChecked) {
            score += firstTime  //first time player
            score += wonTheGame //won the game
        } else if (check_won.isChecked) { //won the game
            score += wonTheGame
        } else if(check_first.isChecked) { //first time playing
            score += firstTime
        } else { //if neither are checked

        }

        score_number.setText(score.toString())
    }
}
