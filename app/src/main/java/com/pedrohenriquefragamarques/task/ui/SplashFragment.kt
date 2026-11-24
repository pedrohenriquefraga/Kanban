package com.pedrohenriquefragamarques.task.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pedrohenriquefragamarques.task.R
import com.pedrohenriquefragamarques.task.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!
    private val handler = Handler(Looper.getMainLooper())
    private val checkAuthRunnable = Runnable { checkAuth() }

    private fun checkAuth() {
        findNavController().navigate(R.id.action_splashFragment_to_authentication)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handler.postDelayed(checkAuthRunnable, 3000)
    }

    override fun onDestroyView() {
        handler.removeCallbacks(checkAuthRunnable)
        super.onDestroyView()
        _binding = null
    }

}
