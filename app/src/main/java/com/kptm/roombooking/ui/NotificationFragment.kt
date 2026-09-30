package com.kptm.roombooking.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.kptm.roombooking.R

class NotificationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val notifList = view.findViewById<ListView>(R.id.notif_list)

        val notifications = listOf(
            "✓ Lab 5 - Oct 15, 2:00 PM - APPROVED",
            "✓ Lecture Room 3 - Oct 16 - APPROVED",
            "✗ Seminar Room 1 - Oct 17 - REJECTED",
            "⏳ Lab 10 - Oct 18 - PENDING",
            "✓ Lab 2 - Oct 19, 10:00 AM - APPROVED"
        )

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, notifications)
        notifList.adapter = adapter
    }
}
