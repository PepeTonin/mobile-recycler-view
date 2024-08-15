package com.example.recycler_view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recycler_view.R;
import com.example.recycler_view.adapter.Adapter;
import com.example.recycler_view.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> listaFilmes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        this.criarFilmes();

        Adapter adapter = new Adapter(listaFilmes);

        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    public void criarFilmes() {
        Filme filme1 = new Filme("A Lista de Schindler", "Drama", "1993");
        this.listaFilmes.add(filme1);

        Filme filme2 = new Filme("O Senhor dos Anéis: A Sociedade do Anel", "Aventura", "2001");
        this.listaFilmes.add(filme2);

        Filme filme3 = new Filme("Pulp Fiction", "Crime", "1994");
        this.listaFilmes.add(filme3);

        Filme filme4 = new Filme("A Origem", "Ficção Científica", "2010");
        this.listaFilmes.add(filme4);

        Filme filme5 = new Filme("O Poderoso Chefão", "Drama", "1972");
        this.listaFilmes.add(filme5);

        Filme filme6 = new Filme("Avatar", "Aventura", "2009");
        this.listaFilmes.add(filme6);

        Filme filme7 = new Filme("Titanic", "Romance", "1997");
        this.listaFilmes.add(filme7);

        Filme filme8 = new Filme("O Exorcista", "Terror", "1973");
        this.listaFilmes.add(filme8);

        Filme filme9 = new Filme("Star Wars: Episódio IV - Uma Nova Esperança", "Ficção Científica", "1977");
        this.listaFilmes.add(filme9);

        Filme filme10 = new Filme("O Clube da Luta", "Drama", "1999");
        this.listaFilmes.add(filme10);

        Filme filme11 = new Filme("Os Incríveis", "Animação", "2004");
        this.listaFilmes.add(filme11);

        Filme filme12 = new Filme("Cães de Aluguel", "Crime", "1992");
        this.listaFilmes.add(filme12);

        Filme filme13 = new Filme("O Silêncio dos Inocentes", "Thriller", "1991");
        this.listaFilmes.add(filme13);

        Filme filme14 = new Filme("Forrest Gump", "Drama", "1994");
        this.listaFilmes.add(filme14);

        Filme filme15 = new Filme("Jurassic Park", "Aventura", "1993");
        this.listaFilmes.add(filme15);

        Filme filme16 = new Filme("A Bela e a Fera", "Animação", "1991");
        this.listaFilmes.add(filme16);

        Filme filme17 = new Filme("O Grande Lebowski", "Comédia", "1998");
        this.listaFilmes.add(filme17);

        Filme filme18 = new Filme("Mad Max: Estrada da Fúria", "Ação", "2015");
        this.listaFilmes.add(filme18);

        Filme filme19 = new Filme("O Labirinto do Fauno", "Fantasia", "2006");
        this.listaFilmes.add(filme19);

        Filme filme20 = new Filme("Memento", "Mistério", "2000");
        this.listaFilmes.add(filme20);

    }
}