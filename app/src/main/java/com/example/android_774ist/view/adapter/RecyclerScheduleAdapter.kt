package com.example.android_774ist.view.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_774ist.R
import com.example.android_774ist.const.memberName
import com.example.android_774ist.databinding.RecyclerScheduleViewBinding
import com.example.android_774ist.service.model.Schedule


class RecyclerScheduleAdapter(private val context: Context?) :
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
                    return oldList?.get(oldItemPosition)?.broadcastId == scheduleList[newItemPosition].broadcastId
                }

                override fun areContentsTheSame(
                    oldItemPosition: Int,
                    newItemPosition: Int
                ): Boolean {
                    if(newItemPosition>=scheduleList.size || oldItemPosition>=scheduleList.size){
                        return false
                    }
                    val schedule = scheduleList[newItemPosition]
                    val old = scheduleList[oldItemPosition]
                    return schedule.broadcastId == old.broadcastId
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
        if(context!=null) {
            //fixme 書き方を修正したほうがいいかもフラグメントへ移動させる。viewにコールバックを追加する
            holder.binding.ivImg.setOnClickListener {
                val uri: Uri =
                    Uri.parse("https://www.youtube.com/watch?v=" + mScheduleList?.get(position)?.broadcastId)
                // アプリが見つからなければ、ActivityNotFoundException
                ContextCompat.startActivity(context, Intent(Intent.ACTION_VIEW, uri), null)
            }
        }
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        //リストデータの件数をリターン
        return mScheduleList?.size ?: 0
    }

    open class RecyclerScheduleViewHolder(val binding: RecyclerScheduleViewBinding) :
        RecyclerView.ViewHolder(binding.root)
}
