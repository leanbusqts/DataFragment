package dev.bulean.datafragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction

/**
 * Fragments
 * https://developer.android.com/guide/components/fragments
 * https://developer.android.com/training/basics/fragments/creating
 * https://developer.android.com/training/basics/fragments/fragment-ui
 * https://developer.android.com/training/basics/fragments/pass-data-between
 * https://developer.android.com/training/basics/fragments/communicating
 * https://developer.android.com/training/basics/fragments/testing
 * https://developer.android.com/training/basics/fragments/animate
 * */
class MainActivity : AppCompatActivity(), Communicator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Replace Main Activity content with the OneFragment content
        /*
        * At any time while your activity is running, you can add fragments to your activity layout.
        * You simply need to specify a ViewGroup in which to place the fragment.
        * To make fragment transactions in your activity (such as add, remove, or replace a
        * fragment), you must use APIs from FragmentTransaction
        *
        * To apply the transaction to the activity, you must call commit().
        * */
        val mainFragment = MainFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, mainFragment)
            .commit()

    }

    // Use to pass data between fragments using an interface
    override fun passData(data: String) {
        val bundle = Bundle()
        bundle.putString("input_txt",data)

        val transaction = this.supportFragmentManager.beginTransaction()
        val fFragment = FirstFragment()
        fFragment.arguments = bundle

        /*
        * Use addToBackStack() to add the transaction to a back stack of fragment transactions.
        * This back stack is managed by the activity and allows the user to return to the previous
        * fragment state, by pressing the Back button.
        * */
        transaction.replace(R.id.fragment_container, fFragment)
        transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()
    }
}