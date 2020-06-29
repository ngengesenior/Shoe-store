package com.udacity.shoestore

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.FrameLayout
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.core.view.setPadding
import androidx.core.widget.TextViewCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.viewmodels.ShoesViewModel
import kotlin.system.exitProcess

/**
 * A simple [Fragment] subclass.
 */
class ShoeListFragment : Fragment() {

    private val shoesViewModel:ShoesViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        // Prevent navigation to onboarding screens
        val onBackPressedCallback =  object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {

                val alertDialogBuilder = AlertDialog.Builder(context)
                alertDialogBuilder.setMessage(getString(R.string.exit_note))
                    .setPositiveButton(getString(R.string.yes)
                    ) { dialog, which ->

//                        this@HomeFragment.activity?.finish()
//                        moveTaskToBack(true);
                        exitProcess(-1)
                    }
                    .setNegativeButton(getString(R.string.no),null)
                    .show()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(this, onBackPressedCallback )
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding:FragmentShoeListBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_list,container,false)
        binding.lifecycleOwner = this
        binding.vModel = shoesViewModel
        shoesViewModel.shoes.observe(viewLifecycleOwner, Observer {shoesList ->
            shoesList.forEachIndexed { index, shoe ->
                val textView = TextView(requireContext())
                textView.id = index
                val text = "Name:${shoe.name}\nSize:${shoe.size}\nCompany:${shoe.company}"
                textView.text = text
                textView.layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.WRAP_CONTENT)
                textView.setPadding(12)
                binding.shoeListLayout.addView(textView)
            }

        })

        binding.buttonAdd.setOnClickListener {
            val action = ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
            findNavController().navigate(action)
        }
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.list_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.actionLogout) {
            findNavController().navigate(R.id.loginFragment)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}
