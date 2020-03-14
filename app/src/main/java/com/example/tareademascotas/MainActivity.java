package com.example.tareademascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
   private ListView lvItems;
   private Adaptador adaptador;
    public ArrayList<Entidad2> lista;
   public ArrayList<Entidad> listItems;
   String c0,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10="0";
   int cont0,cont1,cont2,cont3,cont4,cont5,cont6,cont7,cont8,cont9,cont10=0;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Mis mascotas");


        lvItems = (ListView) findViewById(R.id.lvItems);
        adaptador = new Adaptador(this, GetArrayItems());
        lvItems.setAdapter(adaptador);

        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int numero;
                numero= Integer.parseInt(listItems.get(position).getRating());
                numero++;

                listItems.get(position).setRating(Integer.toString(numero));
              //  Collections.sort(listItems,Collections.reverseOrder());
                Collections.sort(listItems);

                lvItems = (ListView) findViewById(R.id.lvItems);
                lvItems.setAdapter(adaptador);

                //adaptador = new Adaptador(this, GetArrayItems());


            }
        });

    }


    private ArrayList<Entidad> GetArrayItems(){


        c1=Integer.toString(cont1);
        listItems = new ArrayList<Entidad>();

        listItems.add(new Entidad(R.drawable.aventurero1, "Aventurero","0"));
        listItems.add(new Entidad(R.drawable.bigotes1,"Bigotes","0"));
        listItems.add(new Entidad(R.drawable.cocinero1,"Cocinero","0"));
        listItems.add(new Entidad(R.drawable.cool1,"Cool","0"));
        listItems.add(new Entidad(R.drawable.dormilon1,"Dormilón","0"));
        listItems.add(new Entidad(R.drawable.intelectual1,"Intelectual","0"));
        listItems.add(new Entidad(R.drawable.ojitos1,"Ojitos","0"));
        listItems.add(new Entidad(R.drawable.peinado1,"Peinado","0"));
        listItems.add(new Entidad(R.drawable.robusto1,"Robusto","0"));
        listItems.add(new Entidad(R.drawable.triste1,"Triste","0"));
        listItems.add(new Entidad(R.drawable.viajero1,"Viajero","0"));

        return listItems;
    }



    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);

        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        lista = new ArrayList<Entidad2>();
        int foto1 = 100;
        String nombre1;
        String rating1;
        int id = item.getItemId();
        if (id == R.id.rating5) {
            for (int i=0;i<=4;i++) {

                foto1 = listItems.get(i).getImgFoto();
                nombre1 = listItems.get(i).getNombre();
                rating1 = listItems.get(i).getRating();
                if(foto1!=100){
                lista.add(new Entidad2(foto1, nombre1, rating1));}
            }

               // lista.add(new Entidad2(listItems.get(i).getImgFoto(),listItems.get(i).getNombre(),listItems.get(i).getRating()));
            Intent intent = new Intent(MainActivity.this, RecyclerRating.class);
             //lista.get(i).setNombre(listItems.get(i).getNombre());
             //lista.get(i).setRating(listItems.get(i).getRating());
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("ListaObjetos",lista);
            intent.putExtras(bundle);
            startActivity(intent);
          //}
            //intent.putExtra("lista", listItems);

            //startActivity(intent);

        }
        return true;
    }

    protected void onSaveInstanceDtate(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putSerializable("listado",listItems);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);


    }


}
