package com.ashamsi.nbateamviewer.view.allteams

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ashamsi.domain.teams.entity.TeamEntity
import com.ashamsi.nbateamviewer.databinding.LayoutTeamItemBinding
import javax.inject.Inject

class AllTeamsAdapter @Inject constructor(private val clickListener: TeamListener
) : ListAdapter<TeamEntity, AllTeamsAdapter.ViewHolder>(AllTeamsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder.from(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(clickListener, getItem(position)!!)

    /**
     * A [RecyclerView.ViewHolder] to deal with an individual team views operations and manage them.
     */
    class ViewHolder private constructor(private val binding: LayoutTeamItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(clickListener: TeamListener, item: TeamEntity) {
            binding.team = item
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = LayoutTeamItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class AllTeamsDiffCallback : DiffUtil.ItemCallback<TeamEntity>() {
    override fun areItemsTheSame(oldItem: TeamEntity, newItem: TeamEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TeamEntity, newItem: TeamEntity): Boolean {
        return oldItem == newItem
    }
}

class TeamListener(val clickListener: (teamEntity: TeamEntity) -> Unit) {
    fun onClick(team: TeamEntity) = clickListener(team)
}