package com.example.kriz.basketballapp.Fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.kriz.basketballapp.R
import com.example.kriz.basketballapp.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentTitleBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_title,container,false)
        binding.mostrarPartidos.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_allFragment))
        binding.nuevoPartido.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_newFragment))
        return binding.root

    }
}
