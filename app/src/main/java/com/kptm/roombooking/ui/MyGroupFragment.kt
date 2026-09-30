package com.kptm.roombooking.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.kptm.roombooking.R

class MyGroupFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_group, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val groupList = view.findViewById<ListView>(R.id.group_list)

        val members = listOf(
            "Muhammad Qis - TSE2483",
            "Ali Hassan - TSE2484",
            "Sarah Lim - TSE2485",
            "Zainab Ahmad - TSE2486",
            "Ravi Kumar - TSE2487"
        )

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, members)
        groupList.adapter = adapter
    }
}
