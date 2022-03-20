package com.apl.android_774ist.view.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.apl.android_774ist.R
import com.apl.android_774ist.databinding.MemberInfoItemBinding
import com.apl.android_774ist.service.model.GroupMemberInfo


class MemberInfoAdapter(
    private val context: Context?,
    private val memberInfoList: List<GroupMemberInfo.MemberInfo>?
) : RecyclerView.Adapter<MemberInfoAdapter.MemberInfoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberInfoViewHolder {
        val binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.member_info_item, parent, false
        ) as MemberInfoItemBinding
        return MemberInfoViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MemberInfoViewHolder, position: Int) {
        val groupMemberInfo = memberInfoList?.get(position) ?: return
        // DateBindingを行う
        holder.binding.apply {
            memberInfo = groupMemberInfo
            context?.let { context ->

                twitterImage.setOnClickListener {
                    ContextCompat.startActivity(
                        context,
                        Intent(Intent.ACTION_VIEW, Uri.parse(groupMemberInfo.twitterURL)),
                        null
                    )
                }
                youtubeImage.setOnClickListener {
                    ContextCompat.startActivity(
                        context,
                        Intent(Intent.ACTION_VIEW, Uri.parse(groupMemberInfo.channelURL)),
                        null
                    )
                }
            }
            executePendingBindings()
        }
    }

    override fun getItemCount(): Int {
        //リストデータの件数をリターン
        return memberInfoList?.size ?: 0
    }

    open class MemberInfoViewHolder(val binding: MemberInfoItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    private fun marginImage(){
       //val windowMetrics: WindowMetrics = this.getWindowManager().getCurrentWindowMetrics()
    }
}
