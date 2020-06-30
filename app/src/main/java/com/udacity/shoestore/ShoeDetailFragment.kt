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
    private val shoeDetail:Shoe = Shoe("",0.0,"","")
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
        binding.shoe = shoeDetail
        with(binding){
            buttonSave.setOnClickListener {
                shoeDetail?.description
                shoeDetail?.company = companyText.text.toString()
                shoeDetail?.size = sizeText.text.toString().toDouble()
                shoeDetail?.description = descriptionText.text.toString()
                shoesViewModel.addShoe(shoeDetail)
                val action = ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
                findNavController().navigate(action)
                /*if (name.isNotEmpty() && company.isNotEmpty() && size.isNotEmpty() && description.isNotEmpty()) {
                    val shoe = Shoe(name=name,company = company,size = size.toDouble(),description = description)
                    shoesViewModel.addShoe(shoe)

                }*/
            }

            buttonCancel.setOnClickListener {
                findNavController().navigateUp()
            }
        }
        return binding.root
    }


}