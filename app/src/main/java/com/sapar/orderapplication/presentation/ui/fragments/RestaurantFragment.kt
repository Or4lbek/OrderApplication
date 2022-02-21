package com.sapar.orderapplication.presentation.ui.fragments

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView


class RestaurantFragment : Fragment() {

    private lateinit var menuLayoutManager: LinearLayoutManager
    private var _binding: FragmentRestaurantDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: EstablishmentDetailViewModel
    private val parentMenuAdapter: ParentMenuAdapter = ParentMenuAdapter()
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRestaurantDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[EstablishmentDetailViewModel::class.java]
        binding.initUI()
        setObserver()
        init()
    }

    private fun init() {
        binding.burgerBtn.setOnClickListener { onClickBtnBurger() }
        binding.btnBasket.setOnClickListener { onClickBtnBasket() }
    }

    private fun setObserver() {
        viewModel.liveData.observe(viewLifecycleOwner) {
            categoryAdapter.submitList(it)
            parentMenuAdapter.submitList(it)
            scrollListener()
        }
    }

    //SOLID
    private fun FragmentRestaurantDetailsBinding.initUI() {
        categoryAdapter = CategoryAdapter()
        categoriesRv.adapter = categoryAdapter
        menuRv.adapter = parentMenuAdapter

        menuLayoutManager = LinearLayoutManager(requireContext())
        menuRv.layoutManager = menuLayoutManager
    }


    var categoryScrollingPos = 0
    var isCategoryScrolling = false
    private fun onClickCategory(pos: Int) {
        categoryScrollingPos = pos
        isCategoryScrolling = true
        binding.menuRv.smoothSnapToPosition(pos)
    }

    private fun scrollListener() {
        binding.menuRv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val posFirst =
                    menuLayoutManager.findFirstVisibleItemPosition()
                if (posFirst == categoryScrollingPos) {
                    isCategoryScrolling = false
                }
                if (!isCategoryScrolling) {
                    categoryAdapter.selectItem(posFirst)
                    binding.categoriesRv.scrollToPosition(posFirst)
                }
            }
        })
    }

    private fun RecyclerView.smoothSnapToPosition(
        position: Int,
        snapMode: Int = LinearSmoothScroller.SNAP_TO_START
    ) {
        val smoothScroller = object : LinearSmoothScroller(this.context) {
            override fun getVerticalSnapPreference(): Int = snapMode
            override fun getHorizontalSnapPreference(): Int = snapMode
            override fun calculateSpeedPerPixel(displayMetrics: DisplayMetrics?): Float {
                return 500 / this@smoothSnapToPosition.computeVerticalScrollRange().toFloat()
            }
        }
        smoothScroller.targetPosition = position
        layoutManager?.startSmoothScroll(smoothScroller)
    }

    override fun onChangeCount(meal: Meal) {
        Toast.makeText(requireContext(), "${meal.price * meal.counter}", Toast.LENGTH_SHORT).show()
        viewModel.totalPrice += meal.price * meal.counter
        binding.btnBasket.apply {
            isVisible = viewModel.totalPrice > 0
            text = viewModel.totalPrice.toString()
        }
    }

    private fun onClickBtnBasket() {
        val action =
            RestaurantFragmentDirections.goToCart()
        findNavController().navigate(action)
    }

    private fun onClickBtnBurger() {
        val bottomSheetMenuFragment = BottomSheetMenuFragment(fromCategoryToList())
        bottomSheetMenuFragment.show(parentFragmentManager, BOTTOM_SHEET_FRAGMENT)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun fromCategoryToList(): ArrayList<String> {
        val itemsMenu: ArrayList<String> = ArrayList()
        categoryAdapter.items.map { categoryMeal ->
            itemsMenu.add(categoryMeal.name)
        }
        return itemsMenu
    }
}