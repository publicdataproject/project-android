package com.song2.publicdata_project

import android.graphics.PorterDuff
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.content.ContextCompat
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatDrawableManager
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import android.widget.TableLayout
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


        tl_main_menu_bar.getTabAt(0)?.setIcon(R.drawable.home_select)
        tl_main_menu_bar.getTabAt(1)?.setIcon(R.drawable.map)
        tl_main_menu_bar.getTabAt(2)?.setIcon(R.drawable.step)
        tl_main_menu_bar.getTabAt(3)?.setIcon(R.drawable.my)


        tl_main_menu_bar.addOnTabSelectedListener(object :  TabLayout.OnTabSelectedListener {
            val selectColor = ContextCompat.getColor(applicationContext,R.color.colorLogo)
            val unselectColor = ContextCompat.getColor(applicationContext,R.color.unselect)
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.icon?.setColorFilter(unselectColor, PorterDuff.Mode.SRC_IN)
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.icon?.setColorFilter(selectColor, PorterDuff.Mode.SRC_IN)
            }

        })

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

            }
        })


    }
}
