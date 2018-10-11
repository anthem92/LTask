package com.example.akira08.linovess

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ExpandableListView
import android.widget.Toast
import com.example.akira08.linovess.`object`.MenuObject
import com.example.akira08.linovess.adapter.ExpandableListAdapter
import com.example.akira08.linovess.fragment.home.homepage
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.nav_header.view.*

class MainActivity : AppCompatActivity(){

    private lateinit var mDrawerLayout: DrawerLayout
    val header : MutableList<String> = ArrayList()
    val body : MutableList<MutableList<String>> = ArrayList()
    var menuObject = MenuObject()
    var firstFragment = homepage()
    lateinit var currentFragment:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val actionbar: ActionBar? = supportActionBar
        actionbar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu)
        }

        mDrawerLayout = findViewById(R.id.drawer_layout)
        mDrawerLayout.addDrawerListener(
                object : DrawerLayout.DrawerListener {
                    override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                        // Respond when the drawer's position changes
                    }

                    override fun onDrawerOpened(drawerView: View) {
                        // Respond when the drawer is opened
                    }

                    override fun onDrawerClosed(drawerView: View) {
                        // Respond when the drawer is closed
                    }

                    override fun onDrawerStateChanged(newState: Int) {
                        // Respond when the drawer motion state changes
                    }
                }
        )

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // set item as selected to persist highlight
            menuItem.isChecked = true
            // close drawer when item is tapped
            mDrawerLayout.closeDrawers()

            // Add code here to update the UI based on the item selected
            // For example, swap UI fragments here

            true
        }

        var headerNavigationView = navigationView.getHeaderView(0)
        headerNavigationView.usernameText.setText("Jhon Rhoe")

        setMenuNavigation()

        if (findViewById<View>(R.id.fragment_container) != null) {

            if (savedInstanceState != null) {
                return
            }

            firstFragment.setArguments(intent.extras)

            supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, firstFragment, "default").commit()
        }


    }

    fun setMenuNavigation(){
        expandableListView.setAdapter(ExpandableListAdapter(this,expandableListView, menuObject.menu))
        expandableListView.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->

            var same:Boolean = false
            val newFragment = menuObject.menu.get(groupPosition).bodyText.get(childPosition).get(1)
            var newCurrentFragment = menuObject.menu.get(groupPosition).bodyText.get(childPosition).get(0).toString()

            val count = supportFragmentManager.backStackEntryCount
            if(count == 1){
                Log.i("Compare", currentFragment+" "+newCurrentFragment)
                if(currentFragment.equals(newCurrentFragment)){
                    same = true
                }
                else{
                    supportFragmentManager.popBackStack()
                }
            }

            if(!same){
                currentFragment = menuObject.menu.get(groupPosition).bodyText.get(childPosition).get(0).toString()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fragment_container, newFragment as Fragment)
                transaction.addToBackStack(null)
                transaction.commit()
            }

            mDrawerLayout.closeDrawers()
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                mDrawerLayout.openDrawer(GravityCompat.START)
                true
            }
            R.id.action_fullscreen-> {
                Log.i("Fullscreen", "Ya")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_right, menu)
        return true
    }

}
