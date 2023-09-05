package com.android.halanvendordiscovery.presentation.vendor.ui


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.consumerfinancehalan.presentation.model.CategoriesUiState
import com.android.consumerfinancehalan.presentation.model.CategoryUiModel
import com.android.consumerfinancehalan.presentation.model.VendorUiModel
import com.android.consumerfinancehalan.presentation.model.VendorsUiState
import com.android.consumerfinancehalan.ui.adapter.CategoryClickListener
import com.android.consumerfinancehalan.ui.adapter.CategoryRecyclerAdapter
import com.android.consumerfinancehalan.ui.adapter.VendorClickListener
import com.android.consumerfinancehalan.ui.adapter.VendorsRecyclerAdapter
import com.android.halanvendordiscovery.R
import com.android.halanvendordiscovery.databinding.FragmentVendorsBinding
import com.android.halanvendordiscovery.presentation.vendor.viewmodel.VendorsViewModel
import com.android.halanvendordiscovery.utils.hideProgressBar
import com.android.halanvendordiscovery.utils.showProgressBar
import com.android.halanvendordiscovery.utils.showSnackBar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class VendorsFragment : Fragment(), CategoryClickListener, VendorClickListener {

    private val viewModel: VendorsViewModel by viewModels()
    private val categoriesAdapter: CategoryRecyclerAdapter by lazy {
        CategoryRecyclerAdapter(
            emptyList(),
            this,
        )
    }
    private val vendorsAdapter by lazy { VendorsRecyclerAdapter(this) }
    private var _binding: FragmentVendorsBinding? = null
    private val binding get() = _binding!!
    private var categoryId: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVendorsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.vendorSearchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.searchVendors(categoryId, query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.searchVendors(categoryId, newText)
                return true
            }
        })
        binding.vendorsRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

                val isAtBottom = (visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                if (isAtBottom) {
                    viewModel.fetchVendors(categoryId,binding.vendorSearchBar.query.toString())
                }
            }
        })

        setupVendorsRecyclerView()
        setupCategoriesRecyclerView()
        observeVendorsUiState()
        observeCategoriesUiState()
        viewModel.fetchVendors(null, null)
        viewModel.fetchCategories()
    }

    private fun observeCategoriesUiState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.categoriesUiState.collectLatest {
                when (it) {
                    is CategoriesUiState.Initial -> {
                    }

                    is CategoriesUiState.Loading -> {
                        binding.progressBar.progressBar.showProgressBar()
                    }

                    is CategoriesUiState.Success -> {
                        binding.progressBar.progressBar.hideProgressBar()
                        categoriesAdapter.updateList(it.categories)
                    }

                    is CategoriesUiState.Error -> {
                        binding.progressBar.progressBar.hideProgressBar()
                        showSnackBar(it.throwable.message.toString(), requireActivity())
                    }
                }
            }
        }
    }

    private fun setupVendorsRecyclerView() {
        binding.apply {
            vendorsRecyclerView.setHasFixedSize(true)
            vendorsRecyclerView.adapter = vendorsAdapter
            vendorsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            setDividerItemDecoration()
        }
    }

    private fun setupCategoriesRecyclerView() {
        binding.apply {
            categoriesRecyclerView.setHasFixedSize(true)
            categoriesRecyclerView.adapter = categoriesAdapter
            categoriesRecyclerView.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        }
    }

    private fun observeVendorsUiState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.vendorsUiState.collectLatest {
                when (it) {
                    is VendorsUiState.Initial -> {
                    }

                    is VendorsUiState.Loading -> {
                        binding.progressBar.progressBar.showProgressBar()
                    }

                    is VendorsUiState.Success -> {
                        binding.progressBar.progressBar.hideProgressBar()
                        vendorsAdapter.submitList(it.vendors)
                    }

                    is VendorsUiState.Error -> {
                        binding.progressBar.progressBar.hideProgressBar()
                        showSnackBar(it.throwable.message.toString(), requireActivity())
                    }
                }
            }
        }
    }

    override fun onCategoryClick(category: CategoryUiModel) {
        this.categoryId = category.id
        viewModel.selectCategory(category, binding.vendorSearchBar.query.toString())
    }

    override fun onVendorClick(vendor: VendorUiModel) {
        val action = VendorsFragmentDirections.actionVendorsFragmentToDetailsFragment(vendor.id)
        findNavController().navigate(action)
    }

    private fun setDividerItemDecoration() {
        val divider = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        AppCompatResources.getDrawable(requireContext(), R.drawable.separator)?.let {
            divider.setDrawable(it)
        }
        binding.vendorsRecyclerView.addItemDecoration(divider)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}