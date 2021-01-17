package com.gugu.demo.kangfuzhongxin.ui.chat.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.gugu.demo.kangfuzhongxin.R
import com.gugu.demo.kangfuzhongxin.ui.chat.msg.MessageFragment

private val TAB_TITLES = mapOf(
    R.string.tab_text_1 to PlaceholderFragment::class.java,
    R.string.tab_text_2 to MessageFragment::class.java
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        /*return PlaceholderFragment.newInstance(
            position + 1
        )*/
        return TAB_TITLES.values.toList()[position].newInstance()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES.keys.toList()[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 2
    }
}