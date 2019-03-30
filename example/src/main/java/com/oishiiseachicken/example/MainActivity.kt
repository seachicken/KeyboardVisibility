package com.oishiiseachicken.example

import android.content.Context
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.TextInputLayout
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.oishiiseachicken.keyboardvisibility.KeyboardVisibility

class MainActivity : AppCompatActivity(), KeyboardVisibility {
    private lateinit var actionButton: FloatingActionButton
    private lateinit var textInputLayout: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actionButton = findViewById<FloatingActionButton>(R.id.actionButton).apply {
            setOnClickListener {
                configureInputMode()
            }
        }
        textInputLayout = findViewById(R.id.textInputLayout)

        setOnVisibleChangeListener(object : KeyboardVisibility.VisibleChangeListener {
            override fun onShown() {
                configureInputMode()
            }

            override fun onHidden() {
                configureUnInputMode()
            }
        })

        configureUnInputMode()
    }

    private fun configureInputMode() {
        actionButton.hide()
        textInputLayout.visibility = View.VISIBLE

        textInputLayout.editText?.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(currentFocus, 0)
    }

    private fun configureUnInputMode() {
        actionButton.show()
        textInputLayout.visibility = View.INVISIBLE

        currentFocus ?: return

        textInputLayout.editText?.clearFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromInputMethod(currentFocus.windowToken, 0)
    }
}
