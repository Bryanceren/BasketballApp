package com.example.kriz.basketballapp.Acttivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.kriz.basketballapp.R
import com.example.kriz.basketballapp.ScoreViewModel
import com.example.kriz.basketballapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object{
        lateinit var scoreViewModel: ScoreViewModel
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val navController = Navigation.findNavController(this,R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this,navController)
        scoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)

    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = Navigation.findNavController(this,R.id.myNavHostFragment)
        return navController.navigateUp()
    }
    fun addOneTeamA(v: View) {
        scoreViewModel.scoreA.value = scoreViewModel.scoreA.value?.plus(1)
    }

    fun addOneTeamB(v: View) {
        scoreViewModel.scoreB.value = scoreViewModel.scoreB.value?.plus(1)
    }

    fun addTwoTeamA(v: View) {
        scoreViewModel.scoreA.value = scoreViewModel.scoreA.value?.plus(2)
    }

    fun addTwoTeamB(v: View) {
        scoreViewModel.scoreB.value = scoreViewModel.scoreB.value?.plus(2)
    }

    fun addThreeTeamA(v: View) {
        scoreViewModel.scoreA.value = scoreViewModel.scoreA.value?.plus(3)
    }

    fun addThreeTeamB(v: View) {
        scoreViewModel.scoreB.value = scoreViewModel.scoreB.value?.plus(3)
    }
}
