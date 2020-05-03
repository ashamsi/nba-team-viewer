package com.ashamsi.nbateamviewer.view.team

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ashamsi.domain.teams.entity.PlayerEntity
import com.ashamsi.domain.teams.entity.TeamEntity
import com.ashamsi.nbateamviewer.databinding.LayoutPlayerItemBinding
import com.ashamsi.nbateamviewer.databinding.LayoutTeamItemBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

private const val ITEM_VIEW_TYPE_PLAYER = 0
private const val ITEM_VIEW_TYPE_TEAM = 1

class TeamAdapter @Inject constructor() : ListAdapter<DataItem, RecyclerView.ViewHolder>(TeamDiffCallback()) {
    private val adapterScope = CoroutineScope(Dispatchers.Default)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_PLAYER -> PlayerViewHolder.from(parent)
            ITEM_VIEW_TYPE_TEAM -> TeamViewHolder.from(parent)
            else -> throw ClassCastException("Unknown view type $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PlayerViewHolder -> {
                val playerItem = getItem(position) as DataItem.PlayerItem
                holder.bind(playerItem.player)
            }

            is TeamViewHolder -> {
                val teamItem = getItem(position) as DataItem.TeamItem
                holder.bind(teamItem.team)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is DataItem.PlayerItem -> ITEM_VIEW_TYPE_PLAYER
            is DataItem.TeamItem -> ITEM_VIEW_TYPE_TEAM
        }
    }

    fun addTeamAndSubmitLIst(team: TeamEntity) {
        adapterScope.launch {
            val items = when (val list: List<PlayerEntity>? = team.players) {
                null -> listOf(DataItem.TeamItem(team))
                else -> listOf(DataItem.TeamItem(team)) + list.map { DataItem.PlayerItem(it) }
            }
            withContext(Dispatchers.Main) {
                submitList(items)
            }
        }
    }

    class PlayerViewHolder private constructor(private val binding: LayoutPlayerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PlayerEntity) {
            binding.player = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): PlayerViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = LayoutPlayerItemBinding.inflate(layoutInflater, parent, false)
                return PlayerViewHolder(binding)
            }
        }
    }

    class TeamViewHolder private constructor(private val binding: LayoutTeamItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TeamEntity) {
            binding.team = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): TeamViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = LayoutTeamItemBinding.inflate(layoutInflater, parent, false)
                return TeamViewHolder(binding)
            }
        }
    }
}

class TeamDiffCallback : DiffUtil.ItemCallback<DataItem>() {
    override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
        return oldItem == newItem
    }
}

sealed class DataItem {
    data class PlayerItem(val player: PlayerEntity) : DataItem() {
        override val id = player.id
    }

    data class TeamItem(val team: TeamEntity) : DataItem() {
        override val id = team.id
    }

    abstract val id: Int
}
