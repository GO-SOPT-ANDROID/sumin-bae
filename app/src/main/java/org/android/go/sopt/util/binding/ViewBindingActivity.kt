package org.android.go.sopt.util.binding

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class ViewBindingActivity<B: ViewBinding>(
    private val inflate: (LayoutInflater) -> B
) : AppCompatActivity() {
    lateinit var binding : B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        setContentView(binding.root)

        constructLayout()
        addListeners()
    }

    open fun constructLayout() {}
    open fun addListeners() {}
}