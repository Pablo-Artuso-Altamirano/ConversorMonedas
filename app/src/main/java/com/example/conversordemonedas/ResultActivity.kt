package com.example.conversordemonedas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.conversordemonedas.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater) // inicio el binding
        setContentView(binding.root)

        // Traigo el resultado del MainActivity
        val resultado = intent.getStringExtra("resultado") ?: "0.0"

        // Muestro el resultado
        binding.tvResult.text = "Su monto convertido es: $resultado"
    }
}
