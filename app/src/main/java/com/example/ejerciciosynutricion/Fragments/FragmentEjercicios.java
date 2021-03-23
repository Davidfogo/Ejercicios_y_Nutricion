package com.example.ejerciciosynutricion.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.textclassifier.TextClassification;
import android.widget.Button;
import android.widget.TextView;

import com.example.ejerciciosynutricion.Modal.Exercici;
import com.example.ejerciciosynutricion.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;


public class FragmentEjercicios extends Fragment {
     TextView txt_tipo;


    public FragmentEjercicios() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fejercicios =  inflater.inflate(R.layout.fragment_ejercicios, container, false);

        //Inicializamos los elementos de la pantalla
        TextView titol = fejercicios.findViewById(R.id.txt_titulo);


        //pasamos los datos de donde hemos dado clic a esta pantalla
        Exercici exercici = (Exercici) this.getArguments().getSerializable("exercici");
        Log.i("exercici", exercici.getNombre());


        titol.setText(exercici.getNombre());
        txt_tipo = fejercicios.findViewById(R.id.txt_tipo);
        Button btn_prueba = fejercicios.findViewById(R.id.btn_prueba);

        ObtenerDatos(txt_tipo);




        return fejercicios;



    }

    public void ObtenerDatos(TextView textview){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference db;

        db = database.getReference().child("Ejercicio").child(textview.getText().toString());
        ArrayList<Exercici> arrayExercicis = new ArrayList<Exercici>();

        // Read from the database
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("logTest " ,""+dataSnapshot.getChildrenCount());

                arrayExercicis.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Exercici exercici = postSnapshot.getValue(Exercici.class);
                    arrayExercicis.add(exercici);

                    Log.i("logTest","Nombre = " + exercici.getNombre());


                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.i("logTest", "Failed to read value.", error.toException());
            }
        });




    }

}