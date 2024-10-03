package com.example.recycler_view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
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

import org.json.JSONArray;
import org.json.JSONObject;

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

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        if (sharedPreferences.contains("compromissos")) {
            String json = sharedPreferences.getString("compromissos", null);
            if (json != null) {
                try {
                    JSONArray jsonArray = new JSONArray(json);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Compromisso compromisso = new Compromisso();
                        compromisso.setTitulo(jsonObject.getString("titulo"));
                        compromisso.setData(jsonObject.getString("data"));
                        compromisso.setHorario(jsonObject.getString("horario"));
                        compromisso.setLocal(jsonObject.getString("local"));
                        listaCompromissos.add(compromisso);
                    }
                    this.adapter.notifyDataSetChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void salvarCompromisso(View view) {
        String titulo = editTextTitulo.getText().toString();
        String local = editTextLocal.getText().toString();
        String data = editTextData.getText().toString();
        String horario = editTextHorario.getText().toString();

        if (titulo.matches("") || local.matches("") || data.matches("") || horario.matches("")) {
            Toast.makeText(getApplicationContext(), "Insira dados válidos", Toast.LENGTH_LONG).show();
            return;
        }

        Compromisso compromisso = new Compromisso();
        compromisso.setTitulo(titulo);
        compromisso.setLocal(local);
        compromisso.setData(data);
        compromisso.setHorario(horario);

        listaCompromissos.add(compromisso);
        this.adapter.notifyDataSetChanged();

        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String json = serializeListToJson(listaCompromissos);
        editor.putString("compromissos", json);
        editor.apply();

        editTextTitulo.setText("");
        editTextLocal.setText("");
        editTextData.setText("");
        editTextHorario.setText("");
    }

    public String serializeListToJson(List<Compromisso> lista) {
        JSONArray jsonArray = new JSONArray();
        for (Compromisso compromisso : lista) {
            try {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("titulo", compromisso.getTitulo());
                jsonObject.put("data", compromisso.getData());
                jsonObject.put("horario", compromisso.getHorario());
                jsonObject.put("local", compromisso.getLocal());
                jsonArray.put(jsonObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return jsonArray.toString();
    }
}
