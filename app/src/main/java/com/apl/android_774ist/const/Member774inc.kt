package com.apl.android_774ist.const

import com.apl.android_774ist.R

enum class Member774inc(
    val group: Group774Inc,
    val castName: String,
    val chId: String,
    val imageId: Int
) {
    //774incメンバー（所属,名前,ChId,imageId）
    /** あにまーれ */
    INABA_HANERU(
        Group774Inc.ANIMARE,
        "因幡はねる",
        "UC0Owc36U9lOyi9Gx9Ic-4qg",
        R.drawable.image_inaba_naneru
    ),
    SOUYA_ICHIKA(
        Group774Inc.ANIMARE,
        "宗谷いちか",
        "UC2kyQhzGOB-JPgcQX9OMgEw",
        R.drawable.image_souya_ichika
    ),
    HINOKUMA_RAN(
        Group774Inc.ANIMARE,
        "日ノ隈らん",
        "UCRvpMpzAXBRKJQuk-8-Sdvg",
        R.drawable.image_hinokuma_ran
    ),
    KAZAMI_KUKU(
        Group774Inc.ANIMARE,
        "風見くく",
        "UCXp7sNC0F_qkjickvlYkg-Q",
        R.drawable.image_kazami_kuku
    ),
    YUNOHARA_IZUMI(
        Group774Inc.ANIMARE,
        "柚原いづみ",
        "UCW8WKciBixmaqaGqrlTITRQ",
        R.drawable.image_yunohara_izumi
    ),
    SHIROMIYA_MIMI(
        Group774Inc.ANIMARE,
        "白宮みみ",
        "UCtzCQnCT9E4o6U3mHHSHbQQ",
        R.drawable.image_shiromiya_mimi
    ),
    SESHIMA_RUI(
        Group774Inc.ANIMARE,
        "瀬島るい",
        "UC_WOBIopwUih0rytRnr_1Ag",
        R.drawable.image_seshima_rui
    ),
    HIRA_HIKARI(
        Group774Inc.ANIMARE,
        "飛良ひかり",
        "UCFsWaTQ7kT76jNNGeGIKNSA",
        R.drawable.image_hira_hikari
    ),

    /** ハニーストラップ */
    SUO_PATRA(
        Group774Inc.HONEY_STRAP,
        "周防パトラ",
        "UCeLzT-7b2PBcunJplmWtoDg",
        R.drawable.image_suou_patra
    ),
    SAIENJI_MARY(
        Group774Inc.HONEY_STRAP,
        "西園寺メアリ",
        "UCwePpiw1ocZRSNSkpKvVISw",
        R.drawable.image_saionji_mary
    ),
    SEKISHIRO_MICO(
        Group774Inc.HONEY_STRAP,
        "堰代ミコ",
        "UCDh2bWI5EDu7PavqwICkVpA",
        R.drawable.image_sekishiro_miko
    ),
    SHIMAMURA_CHARLOTTE(
        Group774Inc.HONEY_STRAP,
        "島村シャルロット",
        "UCYTz3uIgwVY3ZU-IQJS8r3A",
        R.drawable.image_shimamura_charlotte
    ),

    /** シュガーリリック */
    RYUGASAKI_RENE(
        Group774Inc.SUGAR_LYRIC,
        "龍ヶ崎リン",
        "UC2hc-00y-MSR6eYA4eQ4tjQ",
        R.drawable.image_ryugasaki_rene
    ),
    KOJO_ANNA(
        Group774Inc.SUGAR_LYRIC,
        "虎城アンナ",
        "UCvPPBoTOor5gm8zSlE2tg4w",
        R.drawable.image_kojo_anna
    ),
    SHISHIO_CHRIS(
        Group774Inc.SUGAR_LYRIC,
        "獅子王クリス",
        "UC--A2dwZW7-M2kID0N6_lfA",
        R.drawable.image_shishio_chris
    ),

    /** Vアパ */
    ANDO_YUGE(
        Group774Inc.V_APA,
        "杏戸ゆげ",
        "UC3EhsuKdEkI99TWZwZgWutg",
        R.drawable.image_and_uge
    ),
    KISAKI_ANKO(
        Group774Inc.V_APA,
        "季咲あんこ",
        "UChXm-xAYPfygrbyLo2yCASQ",
        R.drawable.image_kisaki_anko
    ),
    KANADE_KANON(
        Group774Inc.V_APA,
        "花奏かのん",
        "UCmqrvfLMws-GLGHQcB5dasg",
        R.drawable.image_kanade_kanon
    ),
    KOMORI_METO(
        Group774Inc.V_APA,
        "小森めと",
        "UCzUNASdzI4PV5SlqtYwAkKQ",
        R.drawable.image_komori_met
    ),
    FUMA_MAT(
        Group774Inc.V_APA,
        "不磨わっと",
        "UCV4EoK6BVNl7wxuxpUvvSWA",
        R.drawable.image_fuma_wat
    ),

    /** ひよクロ */
    AKANE_CANNA(
        Group774Inc.HIYOCRO,
        "茜音カンナ",
        "UCkpqb53xiOvOgNYEbNpFSyw",
        R.drawable.image_akane_canna
    ),
    SUZUMI_NEMO(
        Group774Inc.HIYOCRO,
        "涼海ネモ",
        "UCBJ6nejlzes6mm9UruaxQsA",
        R.drawable.image_suzumi_nemo
    ),
    IEIRI_POPO(
        Group774Inc.HIYOCRO,
        "家入ポポ",
        "UC_hjHmi-ODGhHlSzD16p5Pw",
        R.drawable.image_ieiri_popo
    ),
    SHISUI_KIKI(
        Group774Inc.HIYOCRO,
        "紫水キキ",
        "UC3MBUvkVTI9p-p0be7y7TQA",
        R.drawable.image_shisui_kiki
    ),
    TOURI_SEI(
        Group774Inc.HIYOCRO,
        "橙里セイ",
        "UCBxw5bdrbKO7E60E4s3KgQg",
        R.drawable.image_touri_sei
    ),
    KOHAKU_YURI(
        Group774Inc.HIYOCRO,
        "瑚白ユリ",
        "UCGyywYAJd2O5Y7yUyr7qBRQ",
        R.drawable.image_kohaku_yuri
    );

}

enum class Group774Inc(val groupId: Int) {
    ALL(0),
    ANIMARE(1),
    HONEY_STRAP(2),
    SUGAR_LYRIC(3),
    V_APA(4),
    HIYOCRO(5)
}

/**メンバーのchIDを返す*/
fun groupChannelIdList(group: Group774Inc): List<String> {
    if (group == Group774Inc.ALL) {
        return Member774inc.values().map { it.chId }
    }
    return Member774inc.values().filter { group == it.group }.map { it.chId }
}

/**ChannelIdからメンバー名を所得する*/
fun memberName(chanelId: String?): String {
    return Member774inc.values().firstOrNull { it.chId == chanelId }?.castName ?: ""
}

/**ChannelIdからグループのEnumを所得する*/
fun group774inc(chanelId: String?): Group774Inc? {
    return Member774inc.values().firstOrNull { it.chId == chanelId }?.group
}

/**ChannelIdからメンバー名を所得する*/
fun memberImageId(chanelId: String?): Int? {
    return Member774inc.values().firstOrNull { it.chId == chanelId }?.imageId
}