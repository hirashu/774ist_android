package com.apl.android_774ist.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.apl.android_774ist.databinding.FragmentGroupMemberInfoBinding
import com.apl.android_774ist.view.adapter.GroupMemberInfoAdapter
import com.apl.android_774ist.viewmodel.MemberInfoViewModel

class MemberInfoFragment : Fragment() {

    private lateinit var binding: FragmentGroupMemberInfoBinding
    private lateinit var memberInfoViewModel: MemberInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGroupMemberInfoBinding.inflate(inflater, container, false)
        memberInfoViewModel = ViewModelProvider(this)[MemberInfoViewModel::class.java]

        binding.groupTab.all774inc.visibility = View.GONE

        // todo 描画設定。アダプターにいろいろと設定する
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        obtainViewModel(memberInfoViewModel)
    }

    private fun obtainViewModel(viewModel: MemberInfoViewModel) {
        viewModel.groupMemberListLiveData.observe(viewLifecycleOwner, Observer { it ->
            val adapter = GroupMemberInfoAdapter(context, it)
            binding.groupMemberInfoList.apply {
                this.adapter = adapter
                visibility = View.VISIBLE
            }
        })
    }
}