package cbass.elixirgames.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import cbass.elixirgames.R
import cbass.elixirgames.adapter.GameAdapter
import cbass.elixirgames.databinding.FragmentListaJuegosBinding
import cbass.elixirgames.model.GamesItem
import cbass.elixirgames.viewmodel.GamesVM

class ListaJuegos : Fragment() {

    lateinit var binding: FragmentListaJuegosBinding
    private val viewModel by activityViewModels<GamesVM>()
    private val adapter = GameAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListaJuegosBinding.inflate(layoutInflater)

        val layoutManager = LinearLayoutManager(requireContext())

        with(binding)
        {
            rvList.adapter = adapter
            rvList.layoutManager = layoutManager
        }

        adapter.setMilistener(object : GameAdapter.MiListener{
            override fun miOnClick(gamesItem: GamesItem){
                viewModel.updateGames(gamesItem)
                Navigation.findNavController(requireView()).navigate(R.id.action_listaJuegos_to_detalleJuegos)
            }
        })

        viewModel.games.observe(viewLifecycleOwner, Observer{
            adapter.updateData(it)
        })

        return binding.root
    }


}