package com.example.kriz.basketballapp.Fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.kriz.basketballapp.R
import com.example.kriz.basketballapp.databinding.FragmentNewBinding
import com.example.kriz.basketballapp.databinding.FragmentTitleBinding
import kotlinx.android.synthetic.main.fragment_new.view.*
import java.text.SimpleDateFormat
import java.util.*


class NewFragment : Fragment() {
    private lateinit var editA: EditText
    private lateinit var editB: EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentNewBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_new,container,false)
        val c = Calendar.getInstance().getTime()
        println("Current time => $c")

        editA=binding.editTeamA
        editB=binding.editTeamB

        binding.buttonSave.setOnClickListener{view:View->
            Navigation.findNavController(view).navigate(NewFragmentDirections.actionNewFragmentToGameFragment(editA.text.toString(),editB.text.toString(),c.toString()))
        }
        return binding.root

    }

}
