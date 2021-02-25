package com.example.ejerciciosynutricion.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.example.ejerciciosynutricion.Modal.Perfil;
import com.example.ejerciciosynutricion.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FragmentPerfil extends Fragment {

    public FragmentPerfil() {
        // Required empty public constructor
    }

    EditText txtPasos;
    EditText txtPeso;
    EditText txtAltura;
    Boolean editar = false;
    EditText txtNombre;
    DatabaseReference db;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fperfil = inflater.inflate(R.layout.fragment_perfil, container, false);

        txtPasos = fperfil.findViewById(R.id.txtPasos);
        txtPeso = fperfil.findViewById(R.id.txtPeso);
        txtAltura = fperfil.findViewById(R.id.txtAltura);
        txtNombre = fperfil.findViewById(R.id.txtNombre);

        db = FirebaseDatabase.getInstance().getReference().child("perfil");


        Switch switch_edit = fperfil.findViewById(R.id.switch_editar);
        switch_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editar == false){
                    txtPasos.setEnabled(true);
                    txtPeso.setEnabled(true);
                    txtAltura.setEnabled(true);
                    txtNombre.setEnabled(true);
                    editar = true;
                }else{
                    txtPasos.setEnabled(false);
                    txtPeso.setEnabled(false);
                    txtAltura.setEnabled(false);
                    txtNombre.setEnabled(false);
                    editar = false;
                }
            }
        });
        Button btnEditar = fperfil.findViewById(R.id.btnEditar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    // GUARDAR
                    String key = db.push().getKey();
                    Perfil perfil = new Perfil(txtNombre.getText().toString(), Integer.parseInt(txtPasos.getText().toString()),Integer.parseInt(txtPeso.getText().toString()),Integer.parseInt(txtAltura.getText().toString()));
                    db.child(key).setValue(perfil);


            }
        });


        return fperfil;
    }
}