package com.example.meubeatsstudy.presentation.login.ui

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.URLSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.meubeatsstudy.R
import com.example.meubeatsstudy.data.login.LoginRepositoryImpl
import com.example.meubeatsstudy.databinding.FragmentLoginBinding
import com.example.meubeatsstudy.domain.login.LoginRepository
import com.example.meubeatsstudy.domain.login.LoginUseCase
import com.example.meubeatsstudy.presentation.login.viewmodel.LoginViewModel
import com.example.meubeatsstudy.presentation.util.Constants.INSCREVASE_END
import com.example.meubeatsstudy.presentation.util.Constants.INSCREVASE_START
import com.example.meubeatsstudy.util.State
import com.example.meubeatsstudy.util.State.*

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    private val loginViewModel: LoginViewModel = LoginViewModel(LoginUseCase(LoginRepositoryImpl()))

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {
        setInscravaseSpannableString()
        setListeners()
        setObservers()
    }

    private fun setObservers() {
        loginViewModel.login.observe(viewLifecycleOwner) {
            when (it) {
                is Success -> {
                    Toast.makeText(activity, it.data.toString(), Toast.LENGTH_LONG)
                    Navigation
                        .findNavController(binding.root)
                        .navigate(R.id.action_loginFragment_to_headsetListFragment)
                }
                is Error -> {
                    Toast.makeText(
                        binding.root.context,
                        "Error! Message: ${it.message}",
                        Toast.LENGTH_LONG
                    )
                }
                is Loading -> {}
            }
        }
    }

    private fun setInscravaseSpannableString() {
        binding.tvInscrever.apply {
            setText(
                SpannableString(text).apply {
                    setSpan(
                        URLSpan(""),
                        INSCREVASE_START,
                        INSCREVASE_END,
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                    setSpan(
                        ForegroundColorSpan(
                            ContextCompat.getColor(binding.root.context, R.color.teal_200)
                        ),
                        INSCREVASE_START,
                        INSCREVASE_END,
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                },
                TextView.BufferType.SPANNABLE
            )
        }
    }

    private fun setListeners() {
        binding.apply {
            btnEntrar.setOnClickListener {
                loginViewModel.doLogin(
                    tilUsuario.editText?.text.toString(),
                    tilSenha.editText?.text.toString()
                )
            }
        }
    }
}