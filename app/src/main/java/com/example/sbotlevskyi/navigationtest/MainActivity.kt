package com.example.sbotlevskyi.navigationtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.Navigation

const val TAG = "NavigationTest"

class MainActivity : AppCompatActivity(), OnFragmentInteractionListener {
    override fun onFragmentInteraction(i: Int) {
        Log.i(TAG, "onFragmentInteraction $i")
    }

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
//        navController.navigate(R.id.action_fragment1_to_fragment2)


//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                    .replace(R.id.container, BlankFragment0.newInstance())
//                    .commitNow()
//        }
    }

}
