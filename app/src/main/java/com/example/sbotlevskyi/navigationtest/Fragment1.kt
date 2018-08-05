package com.example.sbotlevskyi.navigationtest


import android.content.Context
import android.os.Bundle
import android.provider.SyncStateContract
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation


class Fragment1 : Fragment(){

    private lateinit var navController: NavController
    private lateinit var message: TextView
    private lateinit var message2: TextView
    private var listener: OnFragmentInteractionListener? = null

    companion object {
        @JvmStatic
        fun newInstance() = Fragment1()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        message = view.findViewById(R.id.message)
        message.setOnClickListener {
            navController.navigate(R.id.action_fragment1_to_fragment2)
            listener?.onFragmentInteraction(1)
        }
        message2 = view.findViewById(R.id.message2)
        message2.setOnClickListener {
            navController.navigate(R.id.action_fragment1_to_fragment3)
            listener?.onFragmentInteraction(12)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onDetach() {
        super.onDetach()
        Log.i(TAG, "onDetach 1")
        listener = null
    }

}