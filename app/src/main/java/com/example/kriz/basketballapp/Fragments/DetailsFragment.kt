package com.example.kriz.basketballapp.Fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kriz.basketballapp.Adapter.PartidoListadapter
import com.example.kriz.basketballapp.R
import com.example.kriz.basketballapp.databinding.FragmentAllBinding
import com.example.kriz.basketballapp.databinding.FragmentMainDetailsBinding
import com.example.room_library.Models.PartidoViewModel
import kotlinx.android.synthetic.main.content_main.view.*

class DetailsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentMainDetailsBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_main_details,container,false)
        var teamA = binding.teamADetails
        var teamB = binding.teamBDetails
        var pointsA = binding.pointsADetails
        var pointsB = binding.pointsBDetails
        var date = binding.dateDetails
        var winner = binding.winnerDetails
        val args = DetailsFragmentArgs.fromBundle(arguments!!)
        teamA.text=args.nombreA
        teamB.text=args.nombreB
        pointsA.text=args.puntosA.toString()
        pointsB.text=args.puntosB.toString()
        date.text=args.date
        winner.text=args.ganador
        return binding.root
    }


}
