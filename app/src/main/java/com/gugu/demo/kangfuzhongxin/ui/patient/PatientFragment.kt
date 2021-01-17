package com.gugu.demo.kangfuzhongxin.ui.patient

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import com.gugu.demo.kangfuzhongxin.R
import com.gugu.demo.kangfuzhongxin.dummy.DummyContent
import com.gugu.demo.kangfuzhongxin.ui.chat.ChatActivity

/**
 * A fragment representing a list of Items.
 */
class PatientFragment : Fragment() {

    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_patient, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            var myItemRecyclerViewAdapter = PatientRecyclerViewAdapter(DummyContent.ITEMS)
            myItemRecyclerViewAdapter.setItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
                startActivity(Intent(activity, ChatActivity::class.java))
            })

            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter =
                    myItemRecyclerViewAdapter
            }
        }
        return view
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            PatientFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}