package com.hussein.shopapp.model


data class ProductX(
    val brand: String,
    val category: String,
    val description: String,
    val discountPercentage: Double,
    val id: Int,
    val images: List<String>,
    val price: Int,
    val rating: Double,
    val stock: Int,
    val thumbnail: String,
    val title: String
)

/*
class ProductX {
    var brand: String=""
        get() = field
        set(value) { field = value }

    var category: String=""
        get() = field
        set(value) { field = value }

    var description: String=""
        get() = field
        set(value) { field = value }

    var discountPercentage: Double=0.0
        get() = field
        set(value) { field = value }

    var id: Int=0
        get() = field
        set(value) { field = value }

    var images: List<String> = ArrayList()
        get() = field
        set(value) { field = value }

    var price: Int=0
        get() = field
        set(value) { field = value }

    var rating: Double=0.0
        get() = field
        set(value) { field = value }

    var stock: Int=0
        get() = field
        set(value) { field = value }

    var thumbnail: String=""
        get() = field
        set(value) { field = value }

    var title: String = ""
        get() = field
        set(value) { field = value }


    @BindingAdapter("imageUrl")
    fun loadImage(view: ImageView, imageUrl: String?) {
        Picasso.get()
            .load(imageUrl)
            .into(view)
    }
}*/
