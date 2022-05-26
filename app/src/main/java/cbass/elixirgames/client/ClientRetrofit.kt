package cbass.elixirgames.client

import cbass.elixirgames.service.GamesService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientRetrofit {

    companion object{
        val BASE_URL= "https://my-json-server.typicode.com/himuravidal/gamesDB/"
        private var client: Retrofit? = null

        fun getInstance(baseUrl:String): GamesService
        {
            if (client == null)
            {
                client = Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
            }

            return client!!.create(GamesService::class.java)

        }
    }
}