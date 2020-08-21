package com.example.englishquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.englishquiz.databinding.FragmentQuizStartBinding

class QuizStart : Fragment() {
    lateinit var binding: FragmentQuizStartBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuizStartBinding.inflate(layoutInflater)
        binding.startButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(QuizStartDirections.actionQuizStartToQuiz())
        )
        return binding.root
    }
}