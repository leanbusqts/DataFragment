package dev.bulean.datafragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentResultListener
import androidx.fragment.app.setFragmentResultListener

class SecondFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_second, container, false)


        val tvOutput = view.findViewById<TextView>(R.id.tvOutput)
        // Use the Kotlin extension in the fragment-ktx artifact
        /*
        * To pass data back to fragment A from fragment B, first set a result listener on fragment A,
        * the fragment that receives the result.
        * Call the setFragmentResultListener() API on fragment A's FragmentManager
        * */
        setFragmentResultListener("requestKey") { _, bundle ->
            // We use a String here, but any type that can be put in a Bundle is supported
            val data = bundle.getString("bundleKey")
            tvOutput.text = data
        }

        return view
    }

}