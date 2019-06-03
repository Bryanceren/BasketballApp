package com.example.kriz.basketballapp.Fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.example.kriz.basketballapp.Acttivities.MainActivity
import com.example.kriz.basketballapp.ScoreViewModel
import com.example.kriz.basketballapp.R
import com.example.kriz.basketballapp.Room.Entities.Partido
import com.example.kriz.basketballapp.databinding.FragmentGameBinding
import com.example.room_library.Models.PartidoViewModel

class GameFragment : Fragment() {
    private lateinit var partidoViewModel: PartidoViewModel
    private lateinit var scoreViewModel: ScoreViewModel
    private lateinit var date: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentGameBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_game,container,false)

        val args = GameFragmentArgs.fromBundle(arguments!!)
        val partido=Partido(args.nombreA,args.nombreB,0,0,args.date,"")

        scoreViewModel=MainActivity.scoreViewModel
        partidoViewModel = ViewModelProviders.of(this).get(PartidoViewModel::class.java)
        partidoViewModel.insertMarches(partido)
        date=args.date
        binding.teamA.text = args.nombreA
        binding.teamB.text = args.nombreB
        binding.tvScoreTeamA.text=scoreViewModel.scoreA.value.toString()
        binding.tvScoreTeamB.text=scoreViewModel.scoreB.value.toString()
        binding.btDone.setOnClickListener{
            notifyChange()
            if(scoreViewModel.scoreA.value!! > scoreViewModel.scoreB.value!!){
                partidoViewModel.setWinner(date,args.nombreA)
            }else{
                partidoViewModel.setWinner(date,args.nombreB)
            }
            scoreViewModel.scoreA.value=0
            scoreViewModel.scoreB.value=0
            Navigation.findNavController(it).navigate(R.id.action_gameFragment_to_allFragment)
        }
        binding.lifecycleOwner = this
        binding.score=scoreViewModel
        return binding.root

    }
    fun notifyChange(){
        partidoViewModel.setPointsA(date,scoreViewModel.scoreA.value!!)
        partidoViewModel.setPointsB(date,scoreViewModel.scoreB.value!!)
    }

}
