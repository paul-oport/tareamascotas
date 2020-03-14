package com.example.tareademascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu1,menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        lista = new ArrayList<Entidad2>();
        int foto1 = 100;
        String nombre1;
        String rating1;
        int id = item.getItemId();
        if (id == R.id.atras) {


           Intent intent = new Intent(RecyclerRating.this, MainActivity.class);


            startActivity(intent);
            //}
            //intent.putExtra("lista", listItems);

            //startActivity(intent);

        }
        return true;
    }
    private ArrayList<Entidad2> GetArrayItems(){


        lista.add(new Entidad2(R.drawable.aventurero1, "Aventurero", "0"));

        lista.add(new Entidad2(R.drawable.intelectual1,"Intelectual","0"));


       return lista;
    }
}
