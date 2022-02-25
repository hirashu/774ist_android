package com.apl.android_774ist.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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
        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        scheduleAdapter = RecyclerScheduleAdapter(this.context)
        binding.lvSchedule.adapter = scheduleAdapter

        binding.groupTab.apply {
            all774inc.setOnClickListener {
                scheduleAdapter.setScheduleList(homeViewModel.groupScheduleList(Group774Inc.ALL))
            }

            animare.setOnClickListener {
                scheduleAdapter.setScheduleList(homeViewModel.groupScheduleList(Group774Inc.ANIMARE))
            }

            honeyStrap.setOnClickListener {
                scheduleAdapter.setScheduleList(homeViewModel.groupScheduleList(Group774Inc.HONEY_STRAP))
            }

            sugarLyric.setOnClickListener {
                scheduleAdapter.setScheduleList(homeViewModel.groupScheduleList(Group774Inc.SUGAR_LYRIC))
            }

            vApArt.setOnClickListener {
                scheduleAdapter.setScheduleList(homeViewModel.groupScheduleList(Group774Inc.V_APA))
            }

            hiyocro.setOnClickListener {
                scheduleAdapter.setScheduleList(homeViewModel.groupScheduleList(Group774Inc.HIYOCRO))
            }
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.progressbar.visibility = View.VISIBLE
        obtainViewModel(homeViewModel)
    }

    private fun obtainViewModel(viewModel: HomeViewModel) {
        viewModel.scheduleListLiveData.observe(viewLifecycleOwner, {
            if (it == null) {
                binding.progressbar.visibility = View.GONE
                binding.loadError.visibility = View.VISIBLE
                // todo APIの情報取得失敗の表示の追加
            } else {
                binding.progressbar.visibility = View.GONE
                binding.loadError.visibility = View.GONE
                binding.lvSchedule.visibility = View.VISIBLE
                scheduleAdapter.setScheduleList(HomeViewModel.setVisibleTime(it))
            }
        })
    }
}