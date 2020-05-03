package com.ashamsi.nbateamviewer.view.allteams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.ashamsi.domain.LogUtils
import com.ashamsi.nbateamviewer.R
import com.ashamsi.nbateamviewer.databinding.FragmentAllteamsBinding
import com.ashamsi.nbateamviewer.di.viewmodel.ViewModelFactory
import com.ashamsi.nbateamviewer.view.team.TeamFragmentViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

private const val TAG = "AllTeamsFragment"

class AllTeamsFragment : DaggerFragment() {
    @Inject
    lateinit var log: LogUtils

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val allTeamsViewModel: AllTeamsFragmentViewModel by viewModels { viewModelFactory }

    private val teamViewModel: TeamFragmentViewModel by viewModels { viewModelFactory }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentAllteamsBinding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_allteams, container, false)

        binding.lifecycleOwner = this

        binding.allTeamsViewModel = allTeamsViewModel

        val adapter = AllTeamsAdapter(TeamListener { teamEntity ->
            teamViewModel.setTeam(teamEntity)
            allTeamsViewModel.onNavigateClicked()
        })
        binding.teamsList.adapter = adapter

        allTeamsViewModel.teams().observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        binding.teamsSort.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            private var selectCount = 0

            override fun onNothingSelected(parent: AdapterView<*>?) {
                log.d(TAG, "No item selected in spinner")
                // No-op
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (selectCount++ > 1) {
                    allTeamsViewModel.sort(position)
                }
            }
        }

        allTeamsViewModel.navigateToTeamFragment.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigate(AllTeamsFragmentDirections.actionFragmentOneToFragmentTwo())
                allTeamsViewModel.onNavigateComplete()
            }
        })

        allTeamsViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.error.visibility = View.GONE
                binding.progress.visibility = if (it) View.VISIBLE else View.GONE
            }
        })

        allTeamsViewModel.error.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.progress.visibility = View.GONE
                binding.error.setMessage(it)
                binding.error.visibility = View.VISIBLE
            }
        })

        return binding.root
    }
}