package com.chobo.kick.navgation

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomBarScreen(
    navController: NavHostController,
) {
    // 네비게이션 바에 표시될 항목들을 리스트로 정의
    val items = listOf(
        BottomBar.Cook,
        BottomBar.Shope,
        BottomBar.Home,
        BottomBar.Profile
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // BottomNavigation을 생성
    BottomNavigation {
        items.forEach { item ->
            BottomNavigationItem(
                //안에 있을 요소들
                icon = {
                    val iconColor =
                        if (currentRoute == item.rout) Color(0xffFF462D) else Color(0xffBCBCBC)
                    Icon(
                        ImageVector.vectorResource(id = item.icon),
                        contentDescription = item.label,
                        tint = iconColor,
                        modifier = Modifier
                            .width(26.dp)
                            .height(26.dp)
                    )
                },
                selected = currentRoute == item.rout,
                alwaysShowLabel = false,
                onClick = {
                    navController.navigate(item.rout) {

                        // 주어진 항목의 경로로 네비게이션
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }

                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}