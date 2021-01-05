package com.apl.android_774ist.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.apl.android_774ist.const.Group774Inc
import com.apl.android_774ist.databinding.FragmentHomeBinding
import com.apl.android_774ist.view.adapter.RecyclerScheduleAdapter
import com.apl.android_774ist.viewmodel.HomeViewModel

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

        scheduleAdapter = RecyclerScheduleAdapter(this.context)
        binding.lvSchedule.adapter = scheduleAdapter

        binding.btAll774inc.setOnClickListener {
            scheduleAdapter.setScheduleList(homeViewModel.groupScheduleList(Group774Inc.ALL))
        }

        binding.btAniMare.setOnClickListener {
            scheduleAdapter.setScheduleList(homeViewModel.groupScheduleList(Group774Inc.ANIMARE))
        }

        binding.btHoneyStrap.setOnClickListener {
            scheduleAdapter.setScheduleList(homeViewModel.groupScheduleList(Group774Inc.HONEY_STRAP))
        }

        binding.btSugarLyric.setOnClickListener {
            scheduleAdapter.setScheduleList(homeViewModel.groupScheduleList(Group774Inc.SUGAR_LYRIC))
        }

        binding.btVApArt.setOnClickListener {
            scheduleAdapter.setScheduleList(homeViewModel.groupScheduleList(Group774Inc.V_APA))
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //todo ViewModelの設定を行うまたデータ取得を行う
        obtainViewModel(homeViewModel)
    }

    private fun obtainViewModel(viewModel: HomeViewModel) {
        viewModel.scheduleListLiveData.observe(viewLifecycleOwner, Observer { it ->
            scheduleAdapter.setScheduleList(HomeViewModel.setVisibleTime(it))
        })
    }


}