package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.fragment.app.Fragment
import com.example.myapplication.home.HistoryFragment
import com.example.myapplication.home.HomeFragment
import com.example.myapplication.home.PaymentFragment
import com.example.myapplication.home.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    private val homeFragment = HomeFragment()
    private val paymentFragment = PaymentFragment()
    private val historyFragment = HistoryFragment()
    private val settingFragment = SettingFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val actionBar = supportActionBar
        actionBar?.setTitle("BayarDulu")
        getSupportActionBar()?.setDisplayShowHomeEnabled(true);
        getSupportActionBar()?.setDisplayUseLogoEnabled(true);

        replaceFragment(homeFragment)
        val bottom_nav = findViewById(R.id.bottom_navigation) as BottomNavigationView

        bottom_nav.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.menu_home -> replaceFragment(homeFragment)
                R.id.menu_payment -> replaceFragment(paymentFragment)
                R.id.menu_history -> replaceFragment(historyFragment)
                R.id.menu_setting -> replaceFragment(settingFragment)
            }
            true

        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_profil,menu)
        return true
    }



    private fun replaceFragment(fragment: Fragment) {
        if (fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_container,fragment)
            transaction.commit()
        }
    }
}