package com.example.rhythmgame2024

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class GameAdapter(var gameList: List<Features>) :
    RecyclerView.Adapter<GameAdapter.ViewHolder>(){
    companion object{
        val TAG = "GameAdapter"
    }
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
            val textViewSongName: TextView
            val textViewAuthorName: TextView
            val textViewHighScore: TextView
            val textViewCombo: TextView
            val imageViewPlay: ImageView
            val layout: ConstraintLayout

            init{
                textViewSongName = view.findViewById(R.id.textView_songItem_songName)
                textViewAuthorName = view.findViewById(R.id.textView_songItem_authorName)
                textViewHighScore = view.findViewById(R.id.textView_songItem_highScore)
                textViewCombo = view.findViewById(R.id.textView_songItem_combo)
                layout = view.findViewById(R.id.layout_songItem)
                imageViewPlay = view.findViewById(R.id.imageView_songItem_play)

            }
        }
        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder{
            val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_song, viewGroup, false)
            return ViewHolder(view)
        }
        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int){
            val features = gameList[position]
            val context = viewHolder.layout.context
            viewHolder.textViewSongName.text = gameList[position].name
            viewHolder.textViewAuthorName.text = gameList[position].author
            Log.d(TAG, "onBindViewHolder: name =" + viewHolder.textViewSongName.text + " author = " + viewHolder.textViewAuthorName.text)
            viewHolder.textViewCombo.text = "Combo: " + gameList[position].combo.toString()
            viewHolder.textViewHighScore.text = "High Score: " + gameList[position].score.toString()

            // play button
            viewHolder.imageViewPlay.setOnClickListener{
                val detailIntent = Intent(context, GameScreen::class.java)
                detailIntent.putExtra(GameScreen.EXTRA_GAME, features)
                context.startActivity(detailIntent)
            }
        }

    override fun getItemCount() = gameList.size
    }