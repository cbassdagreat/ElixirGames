package cbass.elixirgames.model


import com.google.gson.annotations.SerializedName

data class GamesItem(
    @SerializedName("background_image")
    val backgroundImage: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("metacritic")
    val metacritic: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("rating_top")
    val ratingTop: Int,
    @SerializedName("released")
    val released: String
)