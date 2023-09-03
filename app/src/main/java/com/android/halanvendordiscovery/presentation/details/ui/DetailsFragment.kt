package com.android.halanvendordiscovery.presentation.details.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.DividerItemDecoration
import com.android.halanvendordiscovery.R
import com.android.halanvendordiscovery.databinding.FragmentDetailsBinding
import com.android.halanvendordiscovery.presentation.details.adapter.MerchantsAdapter
import com.android.halanvendordiscovery.presentation.details.viewmodel.DetailsStates
import com.android.halanvendordiscovery.presentation.details.viewmodel.DetailsViewModel
import com.android.halanvendordiscovery.utils.isShowProgressBar
import com.android.halanvendordiscovery.utils.showSnackBar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DetailsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDetailsBinding.inflate(inflater)
        viewModel.getMerchants("63d3dc61aa41feb6018b6770")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getMerchantsResponse()
    }

    private fun getMerchantsResponse() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getMerchantsResponse.collectLatest {
                    when (it) {
                        is DetailsStates.Loading -> {
                            binding.progressBar.progressBar.isShowProgressBar(it.isLoading)
                        }

                        is DetailsStates.Success -> {
                            binding.tvVendorName.text = it.value[0].vendorArabicName
                            binding.rvMerchants.adapter = MerchantsAdapter(
                                it.value,
                                object : MerchantsAdapter.OnItemClickListener {
                                    override fun onLocationClick(
                                        latitude: Double,
                                        longitude: Double
                                    ) {
                                        val uri =
                                            "geo:${latitude}, ${longitude}?q=${latitude},${longitude}"
                                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
                                        startActivity(intent)
                                    }

                                    override fun onPhoneClick(phone: String) {
                                        val uri = "tel:${phone}"
                                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
                                        startActivity(intent)
                                    }
                                })
                            setDividerItemDecoration()
                        }

                        is DetailsStates.Failure -> {
                            it.throwable.message?.let { it1 ->
                                showSnackBar(
                                    it1,
                                    requireActivity()
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    private fun setDividerItemDecoration() {
        val divider = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        AppCompatResources.getDrawable(requireContext(), R.drawable.separator)?.let {
            divider.setDrawable(it)
        }
        binding.rvMerchants.addItemDecoration(divider)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}