package com.example.rhythmgame2024

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rhythmgame2024.databinding.ActivityEndScreenBinding

class EndScreen : AppCompatActivity() {
    private lateinit var binding: ActivityEndScreenBinding
    companion object{
        val EXTRA_END = "end"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEndScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val features = intent.getParcelableExtra<Features>(GameScreen.EXTRA_GAME)
        val context = this
        //high score
        binding.textViewEndScreenScore.text = features?.score.toString()
        binding.textViewEndScreenName.text = features?.name
        //max combo
        binding.textViewEndScreenMaxCombo.text = "Max Combo: " + features?.combo.toString()
        //rating, if score is higher than some number and combo is greater than some number, idk about numbers yet so not done
        if(features?.score!! > 10000 && features?.combo!! > 100){
            binding.textViewEndScreenRating.text = "SS"
        }
        else if(features?.score!! > 100000 && features?.combo!! > 50){
            binding.textViewEndScreenRating.text = "S"
        }
        else if(features?.score!! > 10000 && features?.combo!! > 25){
            binding.textViewEndScreenRating.text = "A"
        }
        else if(features?.score!! > 1000 && features?.combo!! > 12){
            binding.textViewEndScreenRating.text = "B"
        }
        else if(features?.score!! > 100 && features?.combo!! > 6){
            binding.textViewEndScreenRating.text = "C"
        }
        else if(features?.score!! > 100 && features?.combo!! > 3){
            binding.textViewEndScreenRating.text = "D"
        }
        else if(features?.score!! > 10 && features?.combo!! > 1){
            binding.textViewEndScreenRating.text = "E"
        }
        else{
            binding.textViewEndScreenRating.text = "F"
        }
        //back button (to main screen)
        binding.buttonEndScreenBack.setOnClickListener{
            val detailIntent = Intent(context, MainActivity::class.java)
            detailIntent.putExtra(MainActivity.EXTRA_MAIN, features)
            context.startActivity(detailIntent)
        }
        //retry button (to game screen)
        binding.buttonEndScreenRetry.setOnClickListener{
            val detailIntent = Intent(context, GameScreen::class.java)
            detailIntent.putExtra(GameScreen.EXTRA_GAME, features)
            context.startActivity(detailIntent)
        }
    }
}