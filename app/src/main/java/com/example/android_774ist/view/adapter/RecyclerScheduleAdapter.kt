package com.example.android_774ist.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_774ist.R
import com.example.android_774ist.const.memberName
import com.example.android_774ist.databinding.RecyclerScheduleViewBinding
import com.example.android_774ist.service.model.Schedule


class RecyclerScheduleAdapter :
    RecyclerView.Adapter<RecyclerScheduleAdapter.RecyclerScheduleViewHolder>() {

    private var mScheduleList: List<Schedule>? = null

    fun setScheduleList(scheduleList: List<Schedule>?) {
        if (scheduleList == null) {
            return
        }
        if (mScheduleList == null) {
            mScheduleList = scheduleList
            notifyItemRangeInserted(0, scheduleList.size)
        } else {
            val result = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
                override fun getOldListSize(): Int {
                    return requireNotNull(this@RecyclerScheduleAdapter.mScheduleList).size
                }

                override fun getNewListSize(): Int {
                    return scheduleList.size
                }

                override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                    val oldList = this@RecyclerScheduleAdapter.mScheduleList
                    return oldList?.get(oldItemPosition)?.id == scheduleList[newItemPosition].id
                }

                override fun areContentsTheSame(
                    oldItemPosition: Int,
                    newItemPosition: Int
                ): Boolean {
                    val schedule = scheduleList[newItemPosition]
                    val old = scheduleList[oldItemPosition]
                    return schedule.id == old.id
                }
            })
            mScheduleList = scheduleList
            result.dispatchUpdatesTo(this)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerScheduleViewHolder {
        val binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recycler_schedule_view, parent, false
        ) as RecyclerScheduleViewBinding
        return RecyclerScheduleViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerScheduleViewHolder, position: Int) {
        holder.binding.scheduleInfo = mScheduleList?.get(position)
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        //リストデータの件数をリターン
        return mScheduleList?.size ?: 0
    }

    open class RecyclerScheduleViewHolder(val binding: RecyclerScheduleViewBinding) :
        RecyclerView.ViewHolder(binding.root)
}
