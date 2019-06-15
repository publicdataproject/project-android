package com.song2.publicdata_project

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import com.song2.publicdata_project.adapter.MainPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureMainTab()
    }

    private fun configureMainTab(){
        vp_main_fragment.adapter = MainPagerAdapter(supportFragmentManager, 4)
        vp_main_fragment.offscreenPageLimit = 3

        tl_main_menu_bar.setupWithViewPager(vp_main_fragment)

        val navMenuMainLayout : View = (this.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
            .inflate(R.layout.navigation_main, null, false)
        tl_main_menu_bar.getTabAt(0)!!.customView = navMenuMainLayout.findViewById(R.id.rl_nav_main_home) as RelativeLayout
        tl_main_menu_bar.getTabAt(1)!!.customView = navMenuMainLayout.findViewById(R.id.rl_nav_main_shop) as RelativeLayout
        tl_main_menu_bar.getTabAt(2)!!.customView = navMenuMainLayout.findViewById(R.id.rl_nav_main_progress) as RelativeLayout
        tl_main_menu_bar.getTabAt(3)!!.customView = navMenuMainLayout.findViewById(R.id.rl_nav_main_mypage) as RelativeLayout

    }
}
