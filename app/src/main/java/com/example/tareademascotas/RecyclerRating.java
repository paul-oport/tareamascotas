package com.example.tareademascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.LauncherActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_LONG;

public class RecyclerRating extends AppCompatActivity {
    private List<Entidad> items = new ArrayList<>();
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lmanager;
    private String nombre;
    private int foto;
    private String rating;
    private ListView lvItems;
    private Adaptador adaptador;
    public ArrayList<Entidad2> lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_rating);

        Toolbar toolbar1 = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar1);

        Bundle bundle = getIntent().getExtras();
        lista = bundle.getParcelableArrayList("ListaObjetos");

        recycler=(RecyclerView)findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        lmanager=new LinearLayoutManager(this);
        recycler.setLayoutManager(lmanager);

        adapter = new RatingAdaptador(lista);
        recycler.setAdapter(adapter);
    }
}
