package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesViewModel : ViewModel() {
    private val _shoes: MutableLiveData<MutableList<Shoe>> = MutableLiveData()
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes

    init {
        _shoes.value = mutableListOf(
            /*Shoe(
                name = "Nike Blazer",
                size = 12.5,
                company = "Nike",
                description = "A great footwear to be used during all seasons for sports",
                images = listOf("https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,b_rgb:f5f5f5/u9ky0ah8uucbw4ctjubm/blazer-mid-77-vintage-shoe-CBDjT0.jpg")
            ),
            Shoe(
                name = "Nike Air Zoom",
                size = 12.5,
                company = "Nike",
                description = "A great footwear to be used during all seasons for sports",
                images = listOf("https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,b_rgb:f5f5f5/0f04659f-3014-4867-a110-f17c94e4671e/air-zoom-pegasus-37-running-shoe-qVSCSr.jpg")
            ),
            Shoe(
                name = "Adidas Primeknit",
                size = 12.5,
                company = "Adidas",
                description = "A new day. A new run. Make it your best. These high-performance shoes feature a foot-hugging knit upper. Stitched-in reinforcement is precisely placed to give you support in the places you need it most. The soft elastane heel delivers a more comfortable fit. Responsive cushioning returns energy to your stride with every footstrike for that I-could-run-forever feeling.",
                images = listOf("https://assets.adidas.com/images/h_840,f_auto,q_auto:sensitive,fl_lossy/e3a7db18925d4728809baafc0106b761_9366/Ultraboost_20_Shoes_Black_EF1043_01_standard.jpg")
            ),
            Shoe(
                name = "New Balance",
                size = 12.5,
                company = "New balance",
                description = "A great footwear to be used during all seasons for sports",
                images = listOf("https://www.abc-mart.com.tw/upload/sync/shoes/new%20balance/MTCRGLW2-1.jpg")
            )*/
        )
    }

    fun setShoes(shoes:MutableList<Shoe>){
        _shoes.value = shoes
    }

    fun clearShoes(){
        _shoes.value = mutableListOf()
    }

    fun addShoe(shoe: Shoe) {
        _shoes.value?.add(shoe)
    }
}