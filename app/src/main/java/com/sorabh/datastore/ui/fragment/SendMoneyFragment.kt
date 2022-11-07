package com.sorabh.datastore.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sorabh.datastore.databinding.FragmentSendMoneyBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SendMoneyFragment : Fragment() {
    private lateinit var binding: FragmentSendMoneyBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSendMoneyBinding.inflate(inflater)

        return binding.root
    }
}