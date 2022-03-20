package com.apl.android_774ist.view.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.apl.android_774ist.R
import com.apl.android_774ist.databinding.GroupMemberItemBinding
import com.apl.android_774ist.service.model.GroupMemberInfo


class GroupMemberInfoAdapter(
    private val context: Context?,
    private val groupMemberInfoList: List<GroupMemberInfo>?
) : RecyclerView.Adapter<GroupMemberInfoAdapter.GroupMemberInfoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupMemberInfoViewHolder {
        val binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.group_member_item, parent, false
        ) as GroupMemberItemBinding
        return GroupMemberInfoViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: GroupMemberInfoViewHolder, position: Int) {
        val groupMemberInfo = groupMemberInfoList?.get(position) ?: return
        if (groupMemberInfo.memberInfoList.isNullOrEmpty()) {
            return
        }
        // DateBindingを行う
        holder.binding.groupMemberInfo = groupMemberInfo
        holder.binding.memberInfoItemList.adapter =
            MemberInfoAdapter(context, groupMemberInfo.memberInfoList)
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        //リストデータの件数をリターン
        return groupMemberInfoList?.size ?: 0
    }

    open class GroupMemberInfoViewHolder(val binding: GroupMemberItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}
