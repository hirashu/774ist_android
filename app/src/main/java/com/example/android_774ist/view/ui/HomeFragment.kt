package com.example.android_774ist.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_774ist.R
import com.example.android_774ist.databinding.FragmentHomeBinding
import com.example.android_774ist.service.model.Schedule
import com.example.android_774ist.service.repository.ScheduleRepository
import com.example.android_774ist.view.adapter.RecyclerScheduleAdapter
import com.example.android_774ist.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        //binding.lvSchedule.adapter

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        ///
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val lvSchedule =root.findViewById<RecyclerView>(R.id.lvSchedule)
        //
        //LinearLayoutManagerオブジェクトの作成
        val layout = LinearLayoutManager(this.context)
        //RecyclerViewにレイアウトマネージャーを設定する
        lvSchedule.layoutManager=layout


        //val schedulelist = ScheduleRepository().getScheduleData()
        //todo アダプターの設定が優先
        //アダプタプジェクトの作成
        //searchVideoResult[2]= Item()
        val adapter = RecyclerScheduleAdapter(this.context,homeViewModel.scheduleListLiveData as List<Schedule>)
        //テスト
        //lvSchedule.adapter=adapter
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
        })
        
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //todo ViewModelの設定を行うまたデータ取得を行う
        val viewModel :HomeViewModel = HomeViewModel(); //todo 修正
    }

    private fun obtainViewModel() =
        ViewModelProviders.of(this).get(homeViewModel::class.java)
}