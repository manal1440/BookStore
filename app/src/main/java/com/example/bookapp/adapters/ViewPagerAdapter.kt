package com.example.bookapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import java.util.ArrayList

class ViewPagerAdapter(supportFragmentManger:FragmentManager):FragmentPagerAdapter(supportFragmentManger,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
      constructor(supportFragmentManger: FragmentManager, lifecycle: Lifecycle) : this(supportFragmentManger)

    private val mFragmentList= ArrayList<Fragment>()
    private val mFragmentTitleList = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
       return mFragmentList[position]
    }
    override fun getCount(): Int {
      return mFragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList[position]
    }
    fun addFragment(fragment:Fragment,title:String){
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }



}