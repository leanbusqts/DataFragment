package dev.bulean.datafragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : Fragment() {

    lateinit var comm: Communicator

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_main, container, false)

        // Pass data with an interface
        /*
        * To allow a Fragment to communicate up to its Activity, you can define an interface
        * in the Fragment class and implement it within the Activity.
        * */
        comm = activity as Communicator
        val buttonFirstFragment = view.findViewById<Button>(R.id.bEnterFirst)
        buttonFirstFragment.setOnClickListener {
            comm.passData(view.etInputFirst.text.toString())
        }
        // Pass data with result listener
        /*
        * In fragment B, the fragment producing the result, you must set the result on the same
        * FragmentManager, using the same requestKey.
        * You can do so by using the setFragmentResult() API
        * */
        val inputSecondFragment = view.findViewById<EditText>(R.id.etInputSecond)
        val buttonSecondFragment =  view.findViewById<Button>(R.id.bEnterSecond)
        buttonSecondFragment.setOnClickListener {
            // Data
            val data: String = inputSecondFragment.text.toString()
            // Use the Kotlin extension in the fragment-ktx artifact
            setFragmentResult("requestKey", bundleOf("bundleKey" to data))
            // Open second Fragment
            val sFragment = SecondFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, sFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        return view
    }
}