package com.apl.android_774ist.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.apl.android_774ist.const.Group774Inc
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

        binding.groupTab.apply {
            all774inc.visibility = View.GONE

            animare.setOnClickListener {
                groupPosition(Group774Inc.ANIMARE.groupId)
            }

            honeyStrap.setOnClickListener {
                groupPosition(Group774Inc.HONEY_STRAP.groupId)
            }

            sugarLyric.setOnClickListener {
                groupPosition(Group774Inc.SUGAR_LYRIC.groupId)
            }

            vApArt.setOnClickListener {
                groupPosition(Group774Inc.V_APA.groupId)
            }

            hiyocro.setOnClickListener {
                groupPosition(Group774Inc.HIYOCRO.groupId)
            }
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.progressbar.visibility = View.VISIBLE
        obtainViewModel(memberInfoViewModel)
    }

    private fun obtainViewModel(viewModel: MemberInfoViewModel) {
        viewModel.groupMemberListLiveData.observe(viewLifecycleOwner, Observer { it ->
            if (it == null) {
                binding.progressbar.visibility = View.GONE
            } else {
                binding.progressbar.visibility = View.GONE
                val adapter = GroupMemberInfoAdapter(context, it)
                binding.groupMemberInfoList.apply {
                    this.adapter = adapter
                    visibility = View.VISIBLE
                }
            }
        })
    }

    private fun groupPosition(position: Int) {
        val pos = position - 1
        if (pos < 0) {
            return
        }
        val manager: LinearLayoutManager =
            binding.groupMemberInfoList.layoutManager as LinearLayoutManager
        manager.scrollToPositionWithOffset(pos, 0)

    }
}