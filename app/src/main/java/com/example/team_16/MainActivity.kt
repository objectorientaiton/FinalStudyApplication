package com.example.team_16

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.team_16.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val navController = binding.frgNav.getFragment<NavHostFragment>().navController

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.todoFragment,
                R.id.stopwatchFragment,
                //R.id.entryFragment,
                R.id.mypageAndLogoutFragmentFrag,
                R.id.statisticFragment
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.bottomNav.setupWithNavController(navController)
        setContentView(binding.root)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            // 바텀 네비게이션이 표시되는 Fragment
            if (destination.id == R.id.todoFragment || destination.id == R.id.mypageAndLogoutFragmentFrag
                || destination.id == R.id.stopwatchFragment || destination.id == R.id.statisticFragment
            ) {
                binding.bottomNav.visibility = View.VISIBLE
            }
            // 바텀 네비게이션이 표시되지 않는 Fragment
            else {
                binding.bottomNav.visibility = View.GONE
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = binding.frgNav.getFragment<NavHostFragment>().navController
        return navController.navigateUp() || super.onSupportNavigateUp()

    }
}