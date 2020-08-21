package com.example.englishquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.Navigator
import com.example.englishquiz.databinding.FragmentQuizWinBinding

class QuizWinFragment : Fragment() {
    lateinit var binding: FragmentQuizWinBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuizWinBinding.inflate(layoutInflater)
        binding.repeatButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(QuizWinFragmentDirections.actionQuizWinFragmentToQuiz())
        )
        return binding.root
    }
}