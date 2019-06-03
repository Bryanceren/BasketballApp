package com.example.kriz.basketballapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kriz.basketballapp.Fragments.AllFragmentDirections
import com.example.kriz.basketballapp.R
import com.example.kriz.basketballapp.Room.Entities.Partido

class PartidoListadapter internal constructor(
    context: Context?
) : RecyclerView.Adapter<PartidoListadapter.PartidoViewHolder>() {


    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var partidos = emptyList<Partido>()

    inner class PartidoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val matchTeamA: TextView = itemView.findViewById(R.id.item_teamA)
        val matchTeamB: TextView = itemView.findViewById(R.id.item_teamB)
        val matchScoreA: TextView = itemView.findViewById(R.id.score_itemA)
        val matchScoreB: TextView = itemView.findViewById(R.id.score_itemB)
        val wholeitem:LinearLayout=itemView.findViewById(R.id.item_portrait)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartidoViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return PartidoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PartidoViewHolder, position: Int) {
        val current = partidos[position]


            holder.matchTeamA.text = current.EquipoA
            holder.matchTeamB.text = current.EquipoB
            holder.matchScoreA.text = current.puntosA.toString()
            holder.matchScoreB.text = current.puntosB.toString()


        holder.wholeitem.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(AllFragmentDirections
                    .actionAllFragmentToDetailsFragment(current.EquipoA,current.EquipoB,current.fecha,current.puntosA,current.puntosB,current.ganador))
        }


    }

    internal fun setMatches(partidos: List<Partido>){
        this.partidos = partidos
        notifyDataSetChanged()
    }


    override fun getItemCount() = partidos.size

}