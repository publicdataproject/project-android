package com.song2.publicdata_project

import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
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
        tl_main_menu_bar.selectedTabPosition

        val navMenuMainLayout : View = (this.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
            .inflate(R.layout.navigation_main, null, false)
        tl_main_menu_bar.getTabAt(0)!!.customView = navMenuMainLayout.findViewById(R.id.rl_nav_main_home) as RelativeLayout
        tl_main_menu_bar.getTabAt(1)!!.customView = navMenuMainLayout.findViewById(R.id.rl_nav_main_shop) as RelativeLayout
        tl_main_menu_bar.getTabAt(2)!!.customView = navMenuMainLayout.findViewById(R.id.rl_nav_main_progress) as RelativeLayout
        tl_main_menu_bar.getTabAt(3)!!.customView = navMenuMainLayout.findViewById(R.id.rl_nav_main_mypage) as RelativeLayout



        vp_main_fragment.addOnAdapterChangeListener(object : ViewPager.OnPageChangeListener,
            ViewPager.OnAdapterChangeListener {
            override fun onAdapterChanged(p0: ViewPager, p1: PagerAdapter?, p2: PagerAdapter?) {
                onPageSelected(tl_main_menu_bar.selectedTabPosition)
            }

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {

                tl_main_menu_bar.getTabAt(0)?.setIcon(R.drawable.home)
                tl_main_menu_bar.getTabAt(1)?.setIcon(R.drawable.map)
                tl_main_menu_bar.getTabAt(2)?.setIcon(R.drawable.step)
                tl_main_menu_bar.getTabAt(3)?.setIcon(R.drawable.my)

                when(position) {

                    0   ->    tl_main_menu_bar.getTabAt(0)?.setIcon(R.drawable.home_select)
                    1   ->    tl_main_menu_bar.getTabAt(1)?.setIcon(R.drawable.map_select)
                    2   ->    tl_main_menu_bar.getTabAt(2)?.setIcon(R.drawable.step_select)
                    3   ->    tl_main_menu_bar.getTabAt(3)?.setIcon(R.drawable.my_select)
                }



            }
        })


    }
}
