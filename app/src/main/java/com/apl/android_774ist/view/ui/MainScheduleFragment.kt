package com.apl.android_774ist.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MainScheduleFragment:Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        /*
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        //今日から公開分の配信情報をAPIから値を取得する
        val searchResult =ApiYTSearch().execute().get()?:return view
        val videoIdList:List<String> = searchResult.mapNotNull { it.id?.videoId }
        //todo 取得した結果をもとに動画情報を取得する。
        if(videoIdList.isEmpty()){
            return view
        }
        val searchVideoResult =ApiSearchVideoList().execute(videoIdList).get()

        //RecyclerViewの取得
        val lvSchedule =view.findViewById<RecyclerView>(R.id.lvSchedule)
        //LinearLayoutManagerオブジェクトの作成
        val layout = LinearLayoutManager(this.context)
        //RecyclerViewにレイアウトマネージャーを設定する
        lvSchedule.layoutManager=layout
        //アダプタプジェクトの作成
        val adapter =RecyclerScheduleAdapter(this.context,searchVideoResult)
        //テスト
        lvSchedule.adapter=adapter

         */
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainScheduleFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic fun newInstance(param1: String, param2: String) =
            MainScheduleFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}