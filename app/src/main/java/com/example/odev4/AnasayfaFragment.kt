package com.example.odev4

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.odev4.databinding.FragmentAnasayfaBinding

class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)
        binding.buttonA.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.ayaGecis)
        }
        binding.buttonX.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.byeGecis)
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("yaşam düngüsü","onCreate")
    }

    override fun onResume() {
        super.onResume()
        Log.e("yaşam döngüsü","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("yaşam döngüsü","onPause")
    }

}