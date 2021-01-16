package com.gugu.demo.kangfuzhongxin.ui.chat

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import com.gugu.demo.kangfuzhongxin.R

import com.gugu.demo.kangfuzhongxin.dummy.DummyContent.DummyItem

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(
        private val values: List<DummyItem>)
    : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    lateinit var listener: AdapterView.OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_item, parent, false)
        return ViewHolder(view)
    }

    fun setItemClickListener(listener: AdapterView.OnItemClickListener) {
        this.listener = listener
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.nameView.text = item.name
        //holder.timeView.text = item.name
        holder.contentView.text = item.content

        holder.rootView.setOnClickListener { v ->
            listener?.onItemClick(null, v, position, position.toLong())
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val rootView = view
        val iconView: ImageView = view.findViewById(R.id.item_icon)
        val nameView: TextView = view.findViewById(R.id.item_name)
        val timeView: TextView = view.findViewById(R.id.item_time)
        val contentView: TextView = view.findViewById(R.id.content)

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }


    }
}