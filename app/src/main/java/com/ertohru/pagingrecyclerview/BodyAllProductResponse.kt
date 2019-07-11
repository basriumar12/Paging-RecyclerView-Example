package id.bukku.bukkuapps.model.product.all_product

data class BodyAllProductResponse(
    val searchBy: String? = null,
    val category: String? = null,
    val bookCategory: String? = null,
    val startPrice: Int? = null,
    val endPrice: Int? = null,
    val sortBy: Int? = null,
    val page: Int? = null,
    val pageSize: Int? = null,
    val publisherCode: String? = null
)