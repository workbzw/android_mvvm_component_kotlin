package com.work.app

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.alibaba.android.arouter.facade.annotation.Route
import com.work.app.databinding.ActivityMainBinding
import com.work.module_base_custom.RouterPath
import com.work.module_base_standard.base.activity.BaseActivity
import com.work.module_base_standard.util.findFragment

@Route(path = RouterPath.APP.MAIN)
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    private val fragments = arrayListOf<Fragment>(
        RouterPath.HOME.HOME.findFragment(),
        RouterPath.NOTIFICATION.HOME.findFragment(),
        RouterPath.DASHBOARD.HOME.findFragment()
    )

    override fun setLayoutId(): Int = R.layout.activity_main
    override fun init(savedInstanceState: Bundle?) {
        initViewPager(fragments)
        clickNavBottomItem()
    }

    private fun initViewPager(items: ArrayList<Fragment>) {
        binding.vpFragmentContainer.adapter =
            object : FragmentPagerAdapter(supportFragmentManager) {
                override fun getCount(): Int = items.size
                override fun getItem(position: Int): Fragment = items[position]
            }
        binding.vpFragmentContainer.offscreenPageLimit = 3
    }

    private fun clickNavBottomItem() {
        binding.navBottom.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    binding.vpFragmentContainer.setCurrentItem(0, false)
                    true
                }
                R.id.navigation_notifications -> {
                    binding.vpFragmentContainer.setCurrentItem(1, false)
                    true
                }
                R.id.navigation_dashboard -> {
                    binding.vpFragmentContainer.setCurrentItem(2, false)
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

}