package com.example.ejerciciosynutricion.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ejerciciosynutricion.R;

public class FragmentRegistroEjercicios extends Fragment {

    public FragmentRegistroEjercicios() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registro_ejercicios, container, false);
    }
}