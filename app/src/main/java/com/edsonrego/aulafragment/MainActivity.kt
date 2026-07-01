package com.edsonrego.aulafragment

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.edsonrego.aulafragment.fragments.ChamadasFragment
import com.edsonrego.aulafragment.fragments.ConversasFragment

class MainActivity : AppCompatActivity() {

    private lateinit var btnConversas: Button
    private lateinit var btnChamadas: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /* val fragmentManager = supportFragmentManager.beginTransaction()

        fragmentManager.add(R.id.fragment_conteudo, ConversasFragment())

        fragmentManager.commit()*/

        Log.i("ciclo_vida", "Activity onCreate")

        btnConversas = findViewById(R.id.btn_conversas)
        btnChamadas = findViewById(R.id.btn_chamadas)

        btnConversas.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_conteudo, ConversasFragment() )
                .commit()
        }

        btnChamadas.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_conteudo, ChamadasFragment())
                .commit()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("ciclo_vida", "Activity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("ciclo_vida", "Activity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("ciclo_vida", "Activity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("ciclo_vida", "Activity onStop")
    }

    override fun onDestroy() {
        Log.i("ciclo_vida", "Activity onDestroy")
        super.onDestroy()
    }
}