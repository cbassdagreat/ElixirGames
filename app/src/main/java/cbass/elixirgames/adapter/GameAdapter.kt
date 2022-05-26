package cbass.elixirgames.adapter

import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import cbass.elixirgames.R
import cbass.elixirgames.databinding.ItemLayoutBinding
import cbass.elixirgames.model.Games
import cbass.elixirgames.model.GamesItem
import com.squareup.picasso.Picasso

class GameAdapter : RecyclerView.Adapter<GameAdapter.CustomViewHolder>() {
    class CustomViewHolder(itemView: View, val listener:MiListener) :RecyclerView.ViewHolder(itemView)
    {
        private val binding = ItemLayoutBinding.bind(itemView)

        fun bindData(gamesItem: GamesItem)
        {
            with(binding)
            {
                Picasso.get().load(gamesItem.backgroundImage).resize(300,300).into(ivPic)
                tvGameName.text = gamesItem.name
                tvDate.text = gamesItem.released

                itemView.setOnClickListener {
                    listener.miOnClick(gamesItem)
                }

            }
        }

    }

    var lista:List<GamesItem> = Games()
    lateinit var listener: MiListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent, false)
        return CustomViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindData(lista[position])
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun updateData(games: Games)
    {
        lista = games
        notifyDataSetChanged()
    }
}

interface MiListener {
    fun miOnClick(gamesItem: GamesItem)

}
