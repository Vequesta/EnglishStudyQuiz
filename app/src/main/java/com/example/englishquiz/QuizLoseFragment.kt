package com.example.englishquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.englishquiz.databinding.FragmentQuizLoseBinding

class QuizLoseFragment : Fragment() {
    lateinit var binding: FragmentQuizLoseBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuizLoseBinding.inflate(layoutInflater)
        binding.tryAgainButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(QuizLoseFragmentDirections.actionQuizLoseFragmentToQuiz())
        )
        return binding.root
    }
}