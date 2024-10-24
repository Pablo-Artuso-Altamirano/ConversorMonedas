package com.example.conversordemonedas

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.conversordemonedas.databinding.ActivityMainBinding
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding  // declaramos el binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)  // inicio el binding
        setContentView(binding.root)


        binding.btnConvertir.setOnClickListener {

            val valorArsTexto = binding.valorArs.text.toString()

            if (valorArsTexto.isEmpty()) {
                binding.txvMensaje.text = "Por favor, ingrese su Monto"
                return@setOnClickListener  // Salgo del listener si no hay valor
            }

            val valorArs = valorArsTexto.toBigDecimal()
            val monedaSeleccionada = binding.spinnerMonedas.selectedItem.toString()

            convertirMoneda(valorArs, monedaSeleccionada)
        }

    }

    private fun convertirMoneda(ars: BigDecimal, moneda: String) {
        val tasaArsUsd = BigDecimal("0.0010")  // tasa ARS a USD
        val tasaArsEur = BigDecimal("0.00094")  // tasa ARS a EUR
        var resultado = BigDecimal.ZERO

        when (moneda) {
            "USD" -> resultado = ars * tasaArsUsd
            "EUR" -> resultado = ars * tasaArsEur
        }

        // Aca formateo el resultado a 2 decimales
        val resultadoFormateado = resultado.setScale(2, BigDecimal.ROUND_HALF_UP).toString()

        // Navegar a la nueva actividad con el resultado
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("resultado", resultadoFormateado)
        startActivity(intent)
    }

}
