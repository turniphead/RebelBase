package com.fortythirtygames.rebelliongamehelper

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.fortythirtygames.rebelliongamehelper.model.BaseDiscoveryState
import com.fortythirtygames.rebelliongamehelper.model.GalacticSystem

class GalacticSystemAdapter(val systems: List<GalacticSystem>,
                            val onItemClick: (GalacticSystem) -> Unit) :
        RecyclerView.Adapter<GalacticSystemAdapter.ViewHolder>() {

    class ViewHolder(itemView: View, val onItemClick: (GalacticSystem) -> Unit) :
            RecyclerView.ViewHolder(itemView) {

        private val textView: TextView?

        init {
            textView = itemView.findViewById(R.id.system_name) as? TextView
        }

        fun bindGalacticSystem(system: GalacticSystem) {
            itemView.alpha = when (system.baseState) {
                BaseDiscoveryState.Unknown, BaseDiscoveryState.Discovered -> 1.0f
                BaseDiscoveryState.Probed -> 0.45f
                BaseDiscoveryState.Occupied -> 0.75f
            }

            val colorID = if (system.baseState == BaseDiscoveryState.Discovered)
                android.R.color.holo_red_light else android.R.color.white
            itemView.setBackgroundColor(itemView.context.getColor(colorID))

            textView?.text = system.name

            itemView.setOnClickListener { view -> onItemClick(system) }
        }
    }

    override fun getItemCount(): Int = systems.count()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_galactic_system, parent, false)
        return ViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindGalacticSystem(systems[position])
    }

    fun reset() {
        systems.forEach { system -> system.baseState = BaseDiscoveryState.Unknown }
        notifyDataSetChanged()
    }
}