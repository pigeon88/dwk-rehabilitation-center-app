package com.gugu.demo.kangfuzhongxin.ui.chat.msg

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gugu.demo.kangfuzhongxin.R
import com.gugu.demo.kangfuzhongxin.dummy.DummyContent.DummyItem
import kotlin.random.Random

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MessageRecyclerViewAdapter(
    private val values: List<DummyItem>
) : RecyclerView.Adapter<MessageRecyclerViewAdapter.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return (values.size * Random.nextInt()) % 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View
        var from = LayoutInflater.from(parent.context)
        view = when (viewType) {
            1 -> {
                from.inflate(R.layout.fragment_chat_msg_item_recv, parent, false)
            }
            else -> {
                from.inflate(R.layout.fragment_chat_msg_item_send, parent, false)
            }
        }
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        //holder.nameView.text = item.name
        //holder.timeView.text = item.name
        //holder.contentView.text = item.content
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val rootView = view
        val iconView: ImageView = view.findViewById(R.id.item_icon)

        //val nameView: TextView = view.findViewById(R.id.item_name)
        //val timeView: TextView = view.findViewById(R.id.item_time)
        val contentView: TextView = view.findViewById(R.id.item_content)

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }


    }
}