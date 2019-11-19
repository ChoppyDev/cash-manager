package cash_manager.epitech.cashmanager.model

data class Article(
	val id: Int,
    val title : String = "Default title",
    val photo: String,
    val price: Float = 0.00f,
	val quantity: Int

)