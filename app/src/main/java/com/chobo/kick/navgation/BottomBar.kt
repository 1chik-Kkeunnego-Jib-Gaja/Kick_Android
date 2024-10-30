package com.chobo.kick.navgation

import com.chobo.kick.R

sealed class BottomBar (
    val rout: String,
    val icon: Int,
    val label: String,
){
    //위에 맞춰 값들을 구성(rout는 nav Graph에 사용됨)
    object Cook: BottomBar("cook", R.drawable.ic_cook, "요리 조합")
    object Shope: BottomBar("shope", R.drawable.ic_shop, "메뉴 찾기")
    object Home: BottomBar("home", R.drawable.ic_home, "홈")
    object Profile: BottomBar("profile", R.drawable.ic_profile, "프로필")

}