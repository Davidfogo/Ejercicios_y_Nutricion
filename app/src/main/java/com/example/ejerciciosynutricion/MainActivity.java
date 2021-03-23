package com.example.ejerciciosynutricion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.ejerciciosynutricion.Fragments.FragmentObjetivos;
import com.example.ejerciciosynutricion.Fragments.FragmentPerfil;
import com.example.ejerciciosynutricion.Fragments.FragmentRecordatorios;
import com.example.ejerciciosynutricion.Fragments.FragmentRutina;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    FragmentRutina Rutinas = new FragmentRutina();
    FragmentRecordatorios Recordatorios = new FragmentRecordatorios();
    FragmentObjetivos Objetivos = new FragmentObjetivos();
    FragmentPerfil Perfil = new FragmentPerfil();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        
    }
    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.fragment_Rutinas:
                    loadFragment(Rutinas);
                    return true;
                    case R.id.fragment_Recordatorios:
                        loadFragment(Recordatorios);
                        return true;
                    case R.id.fragment_Objetivos:
                        loadFragment(Objetivos);
                        return true;
                    case R.id.fragment_Perfil:
                        loadFragment(Perfil);
                        return true;

            }
            return false;
        }
    };

    public void loadFragment (Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();

    }
}