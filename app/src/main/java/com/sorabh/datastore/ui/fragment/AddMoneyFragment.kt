package com.sorabh.datastore.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.sorabh.datastore.R
import com.sorabh.datastore.databinding.FragmentAddMoneyBinding
import com.sorabh.datastore.ui.viewmodel.AddMoneyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AddMoneyFragment : Fragment() {
    private val viewModel: AddMoneyViewModel by viewModels()
    private lateinit var binding: FragmentAddMoneyBinding
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddMoneyBinding.inflate(inflater)
        navController = findNavController()
        binding.btnAddMoney.setOnClickListener {
            saveAccountData()
        }

        return binding.root
    }

    private fun saveAccountData() {
        val bankName = binding.edtBankName.text.toString()
        val accountHolder = binding.edtAccountHolder.text.toString()
        val branchName = binding.edtBankName.text.toString()
        val accountNo = binding.edtAccountNo.text.toString()
        val ifscCode = binding.edtIfscCode.text.toString()
        val phoneNo = binding.edtPhone.text.toString()
        val emailId = binding.edtEmail.text.toString()
        val accountBalance = binding.edtBalance.text.toString()
        if (bankName.isNotEmpty() && accountHolder.isNotEmpty() && branchName.isNotEmpty() && accountNo.isNotEmpty() && ifscCode.isNotEmpty() && phoneNo.isNotEmpty() && emailId.isNotEmpty() && accountBalance.isNotEmpty()) {
            lifecycleScope.launch {
                viewModel.updateAccountData(
                    bankName,
                    accountHolder,
                    accountNo.toLong(),
                    phoneNo.toLong(),
                    emailId,
                    ifscCode,
                    branchName,
                    accountBalance.toLong()
                )
                navController.popBackStack()
            }
        }else
            Toast.makeText(context,getString(R.string.please_fill_all_the_fields),Toast.LENGTH_SHORT).show()
    }
}