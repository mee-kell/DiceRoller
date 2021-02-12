package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

// This activity allows the user to roll a dice and view the result/
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Roll the dice on start up.
        rollDice()

        // Roll the dice when the button is clicked.
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    // Roll the dice and update the screen with the result.
    private fun rollDice() {

        // Create two new dice with six sides and roll them.
        val dice1 = Dice(6)
        val diceRoll1 = dice1.roll()

        val dice2 = Dice(6)
        val diceRoll2 = dice2.roll()

        // Find the ImageViews in the layout
        val diceImage1: ImageView = findViewById(R.id.imageView1)
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        // Update images according to dice roll
        setDiceImageView(diceImage1, diceRoll1)
        setDiceImageView(diceImage2, diceRoll2)
    }

    // Set image view according to dice roll
    fun setDiceImageView(diceImage: ImageView, rollResult: Int) {

        // Set drawable according to dice roll
        val drawableResource = when (rollResult) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update image view properties
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = rollResult.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}