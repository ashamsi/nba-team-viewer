package com.ashamsi.nbateamviewer.view.team

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.ashamsi.nbateamviewer.R
import com.ashamsi.nbateamviewer.databinding.FragmentTeamBinding
import com.ashamsi.nbateamviewer.di.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class TeamFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: TeamFragmentViewModel by viewModels { viewModelFactory }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentTeamBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_team, container, false)

        binding.setLifecycleOwner(this)

        binding.viewModel = viewModel

        val adapter = TeamAdapter()
        binding.playersList.adapter = adapter

        viewModel.team.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.addTeamAndSubmitLIst(it)
            }
        })

        return binding.root
    }
}