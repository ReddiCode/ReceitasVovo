package com.redditizie.receitasvovo

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.redditizie.receitasvovo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

 //   private lateinit var binding: ActivityMainBinding //  desta forma ou (primeira forma:)


  //  private val binding by lazy { desta forma (segunda forma)
  //      ActivityMainBinding.inflate(layoutInflater)
  //  }

    private lateinit var rvReceitas: RecyclerView
    private lateinit var receitasAdapter: ReceitasAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

     //
        //   binding = ActivityMainBinding.inflate(layoutInflater) primeira forma

        setContentView(R.layout.activity_main) // trocar R.layout.activity_main por binding.root dentro do setContentView

        rvReceitas = findViewById(R.id.rv_receitas)

        val lista = listOf(

            Receita("Escondidinho de carne", "25 min", R.drawable.carne1,
                listOf("1 KG de carne moida", "1 colher de manteiga", "2 dentes de alho", "1/2 cebola")
            ),
            Receita("Panqueca de carne moida", "15 min", R.drawable.carne2,
                listOf("1 KG de carne moida", "2 colheres de manteiga", "3 dentes de alho", "1 cebola", "3 ovos", "Farinha de trigo")
            ),
            Receita("Rocambole de carne moida", "30 min", R.drawable.carne3,
                listOf("1 KG de carne moida", "2 colheres de manteiga", "3 dentes de alho", "1 cebola", "1/2 quilo de queijo")
            ),
            Receita("Escondidinho de carne seca", "45 min", R.drawable.carne4,
                listOf("1 KG de carne seca",  "2 colheres de manteiga", "3 dentes de alho", "1 cebola", "3 ovos", "Farinha de trigo")
            )


        )



        //Adapter
        receitasAdapter = ReceitasAdapter{ receita ->
            val intent = Intent(this, DetalhesActivity::class.java )
            intent.putExtra("receita", receita)
            startActivity(intent)
        }
        rvReceitas.adapter = receitasAdapter
        receitasAdapter.configurarLista(lista)


        //Layout
        rvReceitas.layoutManager = LinearLayoutManager(this)

    }
}