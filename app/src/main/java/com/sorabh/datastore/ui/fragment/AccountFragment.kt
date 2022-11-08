package com.sorabh.datastore.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.sorabh.datastore.databinding.FragmentAccountBinding
import com.sorabh.datastore.ui.viewmodel.AccountViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AccountFragment : Fragment() {
    private val viewModel :AccountViewModel by viewModels()
    private lateinit var binding: FragmentAccountBinding
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initializer(inflater)
        lifecycleScope.launch {
            viewModel.getAccountDetail().collect{ account ->
                binding.txvAccountHolder.text = account.accountHolder
                binding.txvBranchName.text = account.branchName
                binding.txvAccountNo.text = account.accountNo.toString()
                binding.txvBalance.text = account.accountBalance.toString()
                binding.txvBankName.text = account.bankName
                binding.txvIfscCode.text = account.ifscCode
            }
        }
        setOnClickListener()
        return binding.root
    }

    private fun initializer(inflater: LayoutInflater) {
        binding = FragmentAccountBinding.inflate(inflater)
        navController = findNavController()
    }

    private fun setOnClickListener() {
        binding.btnAddMoney.setOnClickListener {
            navController.navigate(AccountFragmentDirections.actionAccountFragmentToAddMoneyFragment())
        }
    }

}