package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodels.ShoesViewModel


class ShoeDetailFragment : Fragment() {
    private val shoesViewModel:ShoesViewModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_detail,container,false)
        binding.lifecycleOwner = this
        binding.vModel = shoesViewModel
        with(binding){
            buttonSave.setOnClickListener {
                val name = nameText.text.toString()
                val company = companyText.text.toString()
                val size = sizeText.text.toString()
                val description = descriptionText.text.toString()
                if (name.isNotEmpty() && company.isNotEmpty() && size.isNotEmpty() && description.isNotEmpty()) {
                    val shoe = Shoe(name=name,company = company,size = size.toDouble(),description = description)
                    shoesViewModel.addShoe(shoe)
                    val action = ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
                    findNavController().navigate(action)
                }
            }

            buttonCancel.setOnClickListener {
                findNavController().navigateUp()
            }
        }
        return binding.root
    }


}