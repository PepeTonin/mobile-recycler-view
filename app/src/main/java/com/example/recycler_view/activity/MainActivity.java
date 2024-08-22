package com.example.recycler_view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.recycler_view.R;
import com.example.recycler_view.adapter.Adapter;
import com.example.recycler_view.model.Compromisso;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Compromisso> listaCompromissos = new ArrayList<>();
    private TextInputEditText editTextTitulo;
    private TextInputEditText editTextLocal;
    private TextInputEditText editTextData;
    private TextInputEditText editTextHorario;
    private Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        editTextTitulo = findViewById(R.id.editTextTitulo);
        editTextLocal = findViewById(R.id.editTextLocal);
        editTextData = findViewById(R.id.editTextData);
        editTextHorario = findViewById(R.id.editTextHorario);

        adapter = new Adapter(listaCompromissos);

        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Compromisso compromissoItem = listaCompromissos.get(position);
                Toast.makeText(
                        getApplicationContext(),
                        "Local do compromisso: " + compromissoItem.getLocal(),
                        Toast.LENGTH_LONG
                ).show();
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }

        }));
    }

    public void salvarCompromisso(View view) {
        String titulo =  editTextTitulo.getText().toString().trim();
        String local = editTextLocal.getText().toString();
        String data = editTextData.getText().toString();
        String horario = editTextHorario.getText().toString();

        if (titulo == "" || local == "" || data == "" || horario == "") {
            Toast.makeText(
                    getApplicationContext(),
                    "Insira dados validos",
                    Toast.LENGTH_LONG
            ).show();
            return;
        }

        Compromisso compromisso = new Compromisso(titulo, local, data, horario);

        listaCompromissos.add(compromisso);
        this.adapter.notifyDataSetChanged();

        editTextTitulo.setText("");
        editTextLocal.setText("");
        editTextData.setText("");
        editTextHorario.setText("");
    }
}