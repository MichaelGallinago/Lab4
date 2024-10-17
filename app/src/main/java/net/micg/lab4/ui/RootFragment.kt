package net.micg.lab4.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import net.micg.lab4.R
import net.micg.lab4.databinding.FragmentRootBinding
import utils.ScheduleDataUtils.getScheduleForThisDay
import utils.ScheduleDataUtils.getScheduleForThisWeek

class RootFragment : Fragment(R.layout.fragment_root) {
    private val binding: FragmentRootBinding by viewBinding()
    private val scheduleAdapter = ScheduleAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpBottomNavigationClickListener()

        with(binding.recycler) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = scheduleAdapter
        }

        scheduleAdapter.submitValue(getScheduleForThisDay())
    }

    private fun setUpBottomNavigationClickListener() {
        binding.bottomNavView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_today -> scheduleAdapter.submitValue(getScheduleForThisDay())
                else -> scheduleAdapter.submitValue(getScheduleForThisWeek())
            }
            true
        }
    }
}
