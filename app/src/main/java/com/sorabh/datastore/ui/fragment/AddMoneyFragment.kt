package com.sorabh.datastore.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sorabh.datastore.databinding.FragmentAddMoneyBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddMoneyFragment: Fragment() {
private lateinit var binding:FragmentAddMoneyBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddMoneyBinding.inflate(inflater)


        return binding.root
    }
}