package com.android.consumerfinancehalan.presentation.details

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import com.android.consumerfinancehalan.R
import com.android.consumerfinancehalan.databinding.FragmentDetailsBinding
import com.android.consumerfinancehalan.utils.ApiResponse
import com.android.consumerfinancehalan.utils.hideProgressBar
import com.android.consumerfinancehalan.utils.showProgressBar
import com.android.consumerfinancehalan.utils.showSnackBar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private val viewModel: DetailsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater)
        viewModel.getMerchants("63d3dc61aa41feb6018b6770")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getMerchantsResponse()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun getMerchantsResponse() {
        lifecycleScope.launch {
            viewModel.getMerchantsResponse.flowWithLifecycle(
                lifecycle,
                Lifecycle.State.STARTED
            )
                .collectLatest {
                    when (it) {
                        is ApiResponse.Loading -> {
                            if(it.isLoading)
                                binding.progressBar.progressBar.showProgressBar()
                            else
                                binding.progressBar.progressBar.hideProgressBar()
                        }
                        is ApiResponse.Success -> {
                            binding.tvVendorName.text = it.value?.data?.get(0)?.vendorArabicName
                            binding.rvMerchants.adapter= it.value?.data?.let { it1 ->
                               MerchantsAdapter(
                                   it1
                               )
                           }
                            binding.rvMerchants.addItemDecoration(getDividerItemDecoration())
                        }
                        is ApiResponse.Failure -> {
                            it.throwable.message?.let { it1 -> showSnackBar(it1, requireActivity()) }
                        }
                    }
                }
        }
    }

    private fun getDividerItemDecoration():DividerItemDecoration{
        val divider=DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL)
        ResourcesCompat.getDrawable(resources,R.drawable.separator, null)
            ?.let { it1 -> divider.setDrawable(it1) }
        return divider
    }

}