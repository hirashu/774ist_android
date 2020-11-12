package com.example.android_774ist.view.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_774ist.R
import com.example.android_774ist.const.memberName
import com.example.android_774ist.service.model.Schedule
import com.example.android_774ist.service.model.ScheduleResult
import com.example.android_774ist.util.DateUnit


class RecyclerScheduleAdapter(
    private val context: Context?,
    private val items: List<ScheduleResult.Item>
) : RecyclerView.Adapter<RecyclerScheduleAdapter.RecyclerScheduleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerScheduleViewHolder {
        //インフレータを設定
        val inflater = LayoutInflater.from(context)
        //1行分の画像部品として設定する
        val view = inflater.inflate(R.layout.recycler_schedule_view, parent, false)
        //ビューホルダオブジェクトを作成する
        return RecyclerScheduleViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerScheduleViewHolder, position: Int) {
        // TODO 値を格納する
        val item = items[position]

        val videoId = item.id
        val pos=holder.adapterPosition
        //TODO前の項目と同じ時間なら
        if (position != 0) {
            if (item.liveStreamingDetails?.scheduledStartTime == items[position - 1].liveStreamingDetails?.scheduledStartTime) {
                holder.tvScheduleTime.visibility = View.GONE
            } else {
                holder.tvScheduleTime.visibility = View.VISIBLE
                holder.tvScheduleTime.text =
                    DateUnit().formHmmDate(item.liveStreamingDetails?.scheduledStartTime) + " ~"
            }
        } else {
            holder.tvScheduleTime.visibility = View.VISIBLE
            holder.tvScheduleTime.text =
                DateUnit().formHmmDate(item.liveStreamingDetails?.scheduledStartTime) + " ~"
        }

        item.snippet?.let {
            val distributor = memberName(it.channelId)
            val imgStr = it.thumbnails?.medium?.url
            val broadcastStatus = "配信中（非表示）$videoId"
            val broadcastTitle = it.title

            // TODO Viewholderに値を設定する
            holder.tvDistributor.text = distributor
            holder.tvBroadcastStatus.text = broadcastStatus
            holder.tvBroadcastTitle.text = broadcastTitle
            //画像を設定
            if (context != null) {
                Glide.with(context).load(imgStr).into(holder.ivImg)

                holder.ivImg.setOnClickListener {
                    val uri: Uri = Uri.parse("https://www.youtube.com/watch?v="+item.id)
                    val i = Intent(Intent.ACTION_VIEW, uri)
                    // アプリが見つからなければ、ActivityNotFoundException
                    startActivity(context,i,null)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        //リストデータの件数をリターン
        return items.size
    }

    class RecyclerScheduleViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        //画面部品の定義
        var tvScheduleTime: TextView = itemView.findViewById(R.id.tvScheduleTime)
        var tvDistributor: TextView = itemView.findViewById(R.id.tvDistributor)
        var ivImg: ImageView = itemView.findViewById(R.id.ivImg)
        var tvBroadcastStatus: TextView = itemView.findViewById(R.id.tvBroadcastStatus)
        var tvBroadcastTitle: TextView = itemView.findViewById(R.id.tvBroadcastTitle)
    }
}
