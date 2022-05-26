package cbass.elixirgames.service

import cbass.elixirgames.model.Games
import retrofit2.Call
import retrofit2.http.GET

interface GamesService {

    @GET("games")
    fun getGames(): Call<Games>
}