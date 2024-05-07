package com.example.rhythmgame2024

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class GameAdapter(var gameList: List<Features>) :
    RecyclerView.Adapter<GameAdapter.ViewHolder>(){
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
            val textViewSongName: TextView
            val textViewAuthorName: TextView
            val textViewHighScore: TextView
            val textViewCombo: TextView
            val layout: ConstraintLayout

            init{
                textViewSongName = view.findViewById(R.id.textView_songItem_songName)
                textViewAuthorName = view.findViewById(R.id.textView_songItem_authorName)
                textViewHighScore = view.findViewById(R.id.textView_songItem_highScore)
                textViewCombo = view.findViewById(R.id.textView_songItem_combo)
                layout = view.findViewById(R.id.layout_songItem)
            }
        }
        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder{
            val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_song, viewGroup, false)
            return ViewHolder(view)
        }
        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int){
            val features = gameList[position]
            val context = viewHolder.layout.context
            viewHolder.textViewSongName.text = gameList[position].song.name
            viewHolder.textViewAuthorName.text = gameList[position].song.author
            viewHolder.textViewCombo.text = gameList[position].combo
            viewHolder.textViewHighScore.text = gameList[position].highScore

            viewHolder.layout.setOnClickListener{
                val detailIntent = Intent(context, GameScreen::class.java)
                detailIntent.putExtra(GameScreen.EXTRA_GAME, features)
                context.startActivity(detailIntent)
            }
        }

    override fun getItemCount() = gameList.size
    }