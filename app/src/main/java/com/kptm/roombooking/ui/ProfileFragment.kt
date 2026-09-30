package com.kptm.roombooking.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.kptm.roombooking.R

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameInput = view.findViewById<EditText>(R.id.profile_name)
        val semesterInput = view.findViewById<EditText>(R.id.profile_semester)
        val profileInput = view.findViewById<EditText>(R.id.profile_type)
        val idInput = view.findViewById<EditText>(R.id.profile_id)
        val icInput = view.findViewById<EditText>(R.id.profile_ic)
        val classInput = view.findViewById<EditText>(R.id.profile_class)
        val themeSwitch = view.findViewById<Switch>(R.id.theme_switch)
        val saveBtn = view.findViewById<Button>(R.id.save_profile_btn)

        nameInput.setText("Muhammad Qis")
        semesterInput.setText("Semester 4")
        profileInput.setText("Student")
        idInput.setText("TSE2483")
        icInput.setText("123456-12-3456")
        classInput.setText("DA241A")

        val prefs = requireContext().getSharedPreferences("settings", 0)
        val isDark = prefs.getBoolean("dark_mode", false)
        themeSwitch.isChecked = isDark

        themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            prefs.edit().putBoolean("dark_mode", isChecked).apply()
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        saveBtn.setOnClickListener {
            val name = nameInput.text.toString()
            val semester = semesterInput.text.toString()
            val type = profileInput.text.toString()
            val id = idInput.text.toString()
            val ic = icInput.text.toString()
            val cls = classInput.text.toString()

            prefs.edit()
                .putString("name", name)
                .putString("semester", semester)
                .putString("profile", type)
                .putString("id", id)
                .putString("ic", ic)
                .putString("class", cls)
                .apply()
        }
    }
}
