package com.zky.basics.common.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager

/**
 * Created by lk
 * Date 2020/2/27
 * Time 10:03
 * Detail:
 */
class TitleFragmentAdapter(
    private var mFragmentManager: FragmentManager,
    var titles: ArrayList<String>,
    var pages: List<Fragment>,
    var viewPager: ViewPager


) :
    FragmentPagerAdapter(mFragmentManager) {



    override fun getItem(position: Int): Fragment? {
        return if (pages != null) {
            pages!![position]
        } else null
    }


    override fun getCount(): Int {
        return if (pages != null) pages!!.size else 0
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles?.get(position)
    }

    override fun getItemPosition(`object`: Any): Int {
        return PagerAdapter.POSITION_NONE
    }

    fun refreshViewPager(listFragments: List<Fragment>) {
        if (pages != null && pages!!.isNotEmpty()) {
            val fragmentTransaction = mFragmentManager.beginTransaction()
            for (fragment in pages!!) {
                fragmentTransaction.remove(fragment)
            }
            fragmentTransaction.commit()
            mFragmentManager.executePendingTransactions()
        }
        pages = listFragments
        notifyDataSetChanged()

        viewPager?.currentItem = 0
    }
}
