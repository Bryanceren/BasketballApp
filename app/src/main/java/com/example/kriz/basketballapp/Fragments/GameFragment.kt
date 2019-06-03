package com.example.kriz.basketballapp.Fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
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

        /*val df = SimpleDateFormat("dd-MMM-yyyy")
        val formattedDate = df.format(args.date)
        */
        scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)
        partidoViewModel = ViewModelProviders.of(this).get(PartidoViewModel::class.java)
        partidoViewModel.insertMarches(partido)
        date=args.date
        binding.teamA.text = args.nombreA
        binding.teamB.text = args.nombreB
        binding.tvScoreTeamA.text=scoreViewModel.scoreA.value.toString()
        binding.tvScoreTeamB.text=scoreViewModel.scoreB.value.toString()
        binding.btDone.setOnClickListener{
            notifyChange()
            Navigation.findNavController(it).navigate(R.id.action_gameFragment_to_allFragment)
        }
        binding.lifecycleOwner = this
        binding.score=scoreViewModel
        return binding.root

    }
    fun addOneTeamA(v:View) {
        scoreViewModel.scoreA.value = scoreViewModel.scoreA.value?.plus(1)
    }

    fun addOneTeamB(v:View) {
        scoreViewModel.scoreB.value = scoreViewModel.scoreB.value?.plus(1)
    }

    fun addTwoTeamA(v:View) {
        scoreViewModel.scoreA.value = scoreViewModel.scoreA.value?.plus(2)
    }

    fun addTwoTeamB(v:View) {
        scoreViewModel.scoreB.value = scoreViewModel.scoreB.value?.plus(2)
    }

    fun addThreeTeamA(v:View) {
        scoreViewModel.scoreA.value = scoreViewModel.scoreA.value?.plus(3)
    }

    fun addThreeTeamB(v: View) {
        scoreViewModel.scoreB.value = scoreViewModel.scoreB.value?.plus(3)
    }
    fun notifyChange(){
        partidoViewModel.setPointsA(date,scoreViewModel.scoreA.value!!)
        partidoViewModel.setPointsB(date,scoreViewModel.scoreB.value!!)
    }
}
