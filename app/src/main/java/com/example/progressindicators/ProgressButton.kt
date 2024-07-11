package com.example.progressindicators

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.example.progressindicators.databinding.ProgressButtonBinding

class ProgressButton @JvmOverloads constructor(context : Context, attrs : AttributeSet? = null, defStyleAttr : Int = 0) : FrameLayout(context,attrs,defStyleAttr) {

    private var binding : ProgressButtonBinding = ProgressButtonBinding.inflate(LayoutInflater.from(context),this,true)

    init {
        val attibutes = context.obtainStyledAttributes(attrs,R.styleable.ProgressButton)
        binding.btnProgress.text = attibutes.getString(R.styleable.ProgressButton_android_text)
        attibutes.recycle()
    }

    fun showProgress(){
        // Butona Tıklandığında yapılacak işlemler.
        binding.btnProgress.text = ""
        binding.btnProgress.isEnabled = false
        binding.pbCircular.visibility = View.VISIBLE
    }

    fun hideProgress(buttonText : String){
        binding.btnProgress.text = buttonText
        binding.btnProgress.isEnabled = true
        binding.pbCircular.visibility = View.GONE
    }

    override fun setOnClickListener(listener: OnClickListener?) {
        super.setOnClickListener(listener)
        binding.btnProgress.setOnClickListener {
            listener?.onClick(it)
        }
    }
}