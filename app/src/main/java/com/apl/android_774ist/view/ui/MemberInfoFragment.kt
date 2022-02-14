package com.apl.android_774ist.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.apl.android_774ist.R
import com.apl.android_774ist.databinding.FragmentHomeBinding
import com.apl.android_774ist.databinding.GroupMemberItemBinding
import com.apl.android_774ist.viewmodel.HomeViewModel
import com.apl.android_774ist.viewmodel.MemberInfoViewModel

class MemberInfoFragment : Fragment() {

    private lateinit var binding: GroupMemberItemBinding
    private lateinit var memberInfoViewModel: MemberInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = GroupMemberItemBinding.inflate(inflater, container, false)
        memberInfoViewModel = ViewModelProvider(this)[MemberInfoViewModel::class.java]

        // todo 描画設定。アダプターにいろいろと設定する
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        obtainViewModel(memberInfoViewModel)
    }

    private fun obtainViewModel(viewModel: MemberInfoViewModel) {
        //viewModel.scheduleListLiveData.observe(viewLifecycleOwner, Observer { it ->
        //    scheduleAdapter.setScheduleList(HomeViewModel.setVisibleTime(it))
        //})
    }
}