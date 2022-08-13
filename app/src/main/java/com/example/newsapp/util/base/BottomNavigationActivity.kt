package com.example.newsapp.util.base

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.newsapp.R
import com.example.newsapp.util.MainHelper
import com.google.android.material.bottomnavigation.BottomNavigationView

@SuppressLint("Registered")
abstract class BottomNavigationActivity : BaseActivity(),MainHelper {
  private var doubleBackToExitPressedOnce = false
  lateinit var bottomNavigation: BottomNavigationView

  val navController by lazy {
    (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
  }

  fun setupBottomNavigation() {
    bottomNavigation = findViewById(R.id.bottom_navigation)
    bottomNavigation.menu.findItem(R.id.newsListFragment)?.isChecked = true
    NavigationUI.setupWithNavController(bottomNavigation, navController)

    navController.addOnDestinationChangedListener{_, destination, _ ->
      if (destination.id == R.id.newsListFragment || destination.id == R.id.aboutMeFragment){
        bottomNavigation.visibility = View.VISIBLE
      } else {
        bottomNavigation.visibility = View.GONE
      }
    }
  }

  fun backToHome() {
    supportFragmentManager.popBackStack("CLEAR", FragmentManager.POP_BACK_STACK_INCLUSIVE)
    bottomNavigation.visibility = View.VISIBLE
    bottomNavigation.selectedItemId = R.id.newsListFragment
    bottomNavigation.menu.findItem(R.id.newsListFragment)?.isChecked = true
  }

  override fun onBackPressed() {
    if (navController.currentDestination?.id == R.id.newsListFragment)
      exitApp()
    else
      super.onBackPressed()
  }

  private fun exitApp() {
    try {
      if (doubleBackToExitPressedOnce) {
        finish()
        return
      }
      this.doubleBackToExitPressedOnce = true
     // NotificationUtil.customMessageToast(resources.getString(R.string.clickBackAgain), R.drawable.circle_orange)
      Handler(Looper.getMainLooper()).postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    } catch (ignored: Exception) {
    }
  }

}
