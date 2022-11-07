package com.sorabh.datastore.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.sorabh.datastore.R
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

        binding.btnSendMoney.setOnClickListener {

        }
        return binding.root
    }

    private fun showDialog(receiverName:String){
        val dialog = MaterialAlertDialogBuilder(requireContext())
            .setIcon(R.drawable.ic_logo)
            .setTitle(getString(R.string.send_money_to,receiverName))
            .setMessage(getString(R.string.payment_successfully_completed_to,receiverName))
            .setPositiveButton(getString(R.string.ok)){ dialog, _ ->
                dialog.dismiss()

            }.create()
        dialog.show()
    }
}