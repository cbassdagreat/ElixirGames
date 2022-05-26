package cbass.elixirgames.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import cbass.elixirgames.client.ClientRetrofit
import cbass.elixirgames.model.Games
import cbass.elixirgames.model.GamesItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GamesVM (application: Application):AndroidViewModel(application) {

    val games = MutableLiveData<Games>()
    val game = MutableLiveData<GamesItem>()

fun getData()
    {
        val service = ClientRetrofit.getInstance(ClientRetrofit.BASE_URL)
        service.getGames().enqueue(object :Callback<Games> {
            override fun onResponse(call: Call<Games>, response: Response<Games>) {
                response.body().let{
                    games.postValue(it)
                    Log.i("response", it.toString())
                }
            }

            override fun onFailure(call: Call<Games>, t: Throwable) {
                Log.e("CALL",t.message.toString())
            }

        })
    }

    fun updateGames(game:GamesItem)
    {
        this.game.value = game
    }
}