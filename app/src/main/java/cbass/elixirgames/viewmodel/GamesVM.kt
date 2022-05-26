package cbass.elixirgames.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import cbass.elixirgames.model.Games
import cbass.elixirgames.model.GamesItem

class GamesVM (application: Application):AndroidViewModel(application) {

    val games = MutableLiveData<Games>()
    val user = MutableLiveData<GamesItem>()

 /**   fun getData()
    {
        val service =
    } **/
}