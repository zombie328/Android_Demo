package com.example.mypainter

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val drawingView = findViewById<com.example.mypainter.DrawingView>(R.id.DrawingView)

        val btnBlack: Button = findViewById(R.id.btn_black)
        val btnRed: Button = findViewById(R.id.btn_red)
        val btnGreen: Button = findViewById(R.id.btn_green)
        val btnBlue: Button = findViewById(R.id.btn_blue)
        val btnErase: Button = findViewById(R.id.btn_erase)
        val btnClear: Button = findViewById(R.id.btn_clear)

        btnBlack.setOnClickListener {
            drawingView.setStrokeWidth(10.0F)
            drawingView.setColor(Color.BLACK)
        }

        btnRed.setOnClickListener {
            drawingView.setStrokeWidth(10.0F)
            drawingView.setColor(Color.RED)
        }

        btnGreen.setOnClickListener {
            drawingView.setStrokeWidth(10.0F)
            drawingView.setColor(Color.GREEN)
        }

        btnBlue.setOnClickListener {
            drawingView.setStrokeWidth(10.0F)
            drawingView.setColor(Color.BLUE)
        }

        btnErase.setOnClickListener {
            drawingView.setStrokeWidth(100.0F)
            drawingView.setEraser()
        }

        btnClear.setOnClickListener {
            drawingView.clearCanvas()
        }
    }
}