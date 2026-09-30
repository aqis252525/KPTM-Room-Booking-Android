package com.kptm.roombooking.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.kptm.roombooking.R
import java.text.SimpleDateFormat
import java.util.Calendar

class BookingFragment : Fragment() {

    private lateinit var calendarView: CalendarView
    private lateinit var roomSpinner: Spinner
    private lateinit var startTimeInput: EditText
    private lateinit var endTimeInput: EditText
    private lateinit var bookButton: Button
    private lateinit var statusText: TextView
    private var selectedDate: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_booking, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        calendarView = view.findViewById(R.id.calendar)
        roomSpinner = view.findViewById(R.id.room_spinner)
        startTimeInput = view.findViewById(R.id.start_time)
        endTimeInput = view.findViewById(R.id.end_time)
        bookButton = view.findViewById(R.id.book_btn)
        statusText = view.findViewById(R.id.status)

        setupRooms()
        setupCalendar()
        setupBookButton()
    }

    private fun setupRooms() {
        val labs = (1..17).map { "Lab $it" }
        val lectures = (1..13).map { "Lecture Room $it" }
        val seminars = (1..3).map { "Seminar Room $it" }
        val allRooms = labs + lectures + seminars

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, allRooms)
        roomSpinner.adapter = adapter
    }

    private fun setupCalendar() {
        val cal = Calendar.getInstance()
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        selectedDate = sdf.format(cal.time)

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val selected = Calendar.getInstance()
            selected.set(year, month, dayOfMonth)
            selectedDate = sdf.format(selected.time)
        }
    }

    private fun setupBookButton() {
        bookButton.setOnClickListener {
            val room = roomSpinner.selectedItem.toString()
            val startTime = startTimeInput.text.toString()
            val endTime = endTimeInput.text.toString()

            if (startTime.isNotEmpty() && endTime.isNotEmpty()) {
                statusText.text = "Booked: $room on $selectedDate\nTime: $startTime - $endTime"
                startTimeInput.text.clear()
                endTimeInput.text.clear()
            } else {
                statusText.text = "Please enter time"
            }
        }
    }
}
