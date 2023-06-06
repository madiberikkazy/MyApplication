package com.example.myapplication

import CreateFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myapplication.account.AccountFragment
import com.example.myapplication.created.CreatedFragment
import com.example.myapplication.lists.ListsFragment
import com.example.myapplication.messages.MessagesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav = findViewById(R.id.bottom_navigation)

        bottomNav.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.lists -> {
                    loadFragment(ListsFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.messages -> {
                    loadFragment(MessagesFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.create -> {
                    loadFragment(CreateFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.account -> {
                    loadFragment(AccountFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.created -> {
                    loadFragment(CreatedFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                // Handle additional menu items as needed
                else -> return@setOnNavigationItemSelectedListener false
            }
        }

        // Set the initial fragment
        loadFragment(ListsFragment())
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
