package com.example.ejerciciosynutricion.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;

import com.example.ejerciciosynutricion.Modal.Exercici;
import com.example.ejerciciosynutricion.R;
import com.example.ejerciciosynutricion.RecyclerViews.AdapterList;

import java.util.ArrayList;
import java.util.List;


public class FragmentRutina extends Fragment {
    List<Exercici> elements;
    View frutina;

    public FragmentRutina() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        frutina =  inflater.inflate(R.layout.fragment_rutina, container, false);

        elements = new ArrayList<>();
        elements.add(new Exercici("#62BAF9","Cardio","Frecuencias cardíacas"));
        elements.add(new Exercici("#62BAF9","Pilates","Estiramientos, yoga, Flexibilidad..."));
        elements.add(new Exercici("#62BAF9","Musculación","Fuerza, resistencia..."));

        AdapterList AdapterList = new AdapterList(elements, getActivity());
        RecyclerView recyclerView = frutina.findViewById(R.id.lista_recyclerview);

        //recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(AdapterList);
        return frutina;

    }

    public void init(){

    }
}