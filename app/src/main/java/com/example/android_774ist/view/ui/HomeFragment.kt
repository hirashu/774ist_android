package com.example.android_774ist.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import com.example.android_774ist.databinding.FragmentHomeBinding
import com.example.android_774ist.service.model.Schedule
import com.example.android_774ist.view.adapter.RecyclerScheduleAdapter
import com.example.android_774ist.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel

    private lateinit var scheduleAdapter: RecyclerScheduleAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        homeViewModel =
            ViewModelProviders.of(this)[HomeViewModel::class.java]

        scheduleAdapter = RecyclerScheduleAdapter()
        binding.lvSchedule.adapter = scheduleAdapter

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //todo ViewModelの設定を行うまたデータ取得を行う
        val viewModel: HomeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        obtainViewModel(viewModel)
    }

    private fun obtainViewModel(viewModel: HomeViewModel) {
        /*viewModel.scheduleListLiveData.observe(viewLifecycleOwner, Observer {it->
            scheduleAdapter.setScheduleList(it)
        })*/
    }
}