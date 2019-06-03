package com.example.kriz.basketballapp.Fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kriz.basketballapp.Adapter.PartidoListadapter
import com.example.kriz.basketballapp.R
import com.example.kriz.basketballapp.databinding.FragmentAllBinding
import com.example.kriz.basketballapp.databinding.FragmentTitleBinding
import com.example.room_library.Models.PartidoViewModel
import kotlinx.android.synthetic.main.content_main.view.*

class AllFragment : Fragment() {
    lateinit var partidoViewModel: PartidoViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentAllBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_all,container,false)
        var adapter=PartidoListadapter(this.context)
        val recyclerView = binding.include.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        partidoViewModel = ViewModelProviders.of(this).get(PartidoViewModel::class.java)
        partidoViewModel.allMatches.observe(this, Observer { matches ->
            matches?.let { adapter.setMatches(it) }
        })

        return binding.root
    }




}
