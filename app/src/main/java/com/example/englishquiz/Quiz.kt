package com.example.englishquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.englishquiz.databinding.FragmentQuizBinding
import kotlinx.android.synthetic.main.fragment_quiz.view.*


class Quiz : Fragment() {

    data class Question(
        val text: String,
        val answers: MutableList<String>
    )

    private val questions: MutableList<Question> =
        mutableListOf(
            Question(
                text = "Как переводится выражение They have a mind of their own?",
                answers = mutableListOf(
                    "think independently, don´t necessarily do what people expect",
                    "you keep thinking about it, worried about it",
                    "consider/think about it",
                    "stop you thinking about it",
                    "you keep hearing a pop song inside your head"
                )
            ),

            Question(
                text = "Как переводится выражение Something is on your mind?",
                answers = mutableListOf(
                    "you keep thinking about it, worried about it",
                    "think independently, don´t necessarily do what people expect",
                    "consider/think about it",
                    "stop you thinking about it",
                    "you keep hearing a pop song inside your head"
                )
            ),

            Question(
                text = "Как переводится выражение Keep/bear it in mind?",
                answers = mutableListOf(
                    "consider/think about it",
                    "you keep thinking about it, worried about it",
                    "think independently, don´t necessarily do what people expect",
                    "stop you thinking about it",
                    "you keep hearing a pop song inside your head"
                )
            ),

            Question(
                text = "Как переводится выражение Take your mind off the problem?",
                answers = mutableListOf(
                    "stop you thinking about it",
                    "you keep thinking about it, worried about it",
                    "think independently, don´t necessarily do what people expect",
                    "consider/think about it",
                    "you keep hearing a pop song inside your head"
                )
            ),

            Question(
                text = "Как переводится выражение You can´t get it out of your head?",
                answers = mutableListOf(
                    "you keep hearing a pop song inside your head",
                    "you keep thinking about it, worried about it",
                    "think independently, don´t necessarily do what people expect",
                    "consider/think about it",
                    "stop you thinking about it"
                )
            )
        )


    lateinit var binding: FragmentQuizBinding
    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private var numQuestions = questions.size

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuizBinding.inflate(layoutInflater)
        randomizeQuestions()
        binding.game = this // Bind this fragment class to the layout, or the screen will be empty, without question and answers

        binding.submitButton.setOnClickListener { view: View ->
            val checkedId = binding.radioGroup.checkedRadioButtonId
            if (-1 != checkedId) {
                var answerIndex = 0
                when (checkedId) {
                    R.id.choice2 -> answerIndex = 1
                    R.id.choice3 -> answerIndex = 2
                    R.id.choice4 -> answerIndex = 3
                    R.id.choice5 -> answerIndex = 4
                }
                if (answers[answerIndex] == currentQuestion.answers[0]){
                    questionIndex++
                    if (questionIndex < numQuestions){
                        setQuestion()
                        binding.invalidateAll()
                    } else {
                        view.findNavController().navigate(QuizDirections.actionQuizToQuizWinFragment())
                    }
                } else {
                    view.findNavController().navigate(QuizDirections.actionQuizToQuizLoseFragment())
                }
            }
        }
        return binding.root
    }

    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    private fun setQuestion() {
        binding.radioGroup.clearCheck()
        currentQuestion = questions[questionIndex]
        answers = currentQuestion.answers.toMutableList()
        answers.shuffle()
        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.questionNum, questionIndex + 1, numQuestions)
    }
}