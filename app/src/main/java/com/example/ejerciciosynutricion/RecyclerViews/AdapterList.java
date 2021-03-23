package com.example.ejerciciosynutricion.RecyclerViews;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejerciciosynutricion.Fragments.FragmentEjercicios;
import com.example.ejerciciosynutricion.Modal.Exercici;
import com.example.ejerciciosynutricion.R;

import java.io.Serializable;
import java.util.List;

public class AdapterList extends RecyclerView.Adapter<AdapterList.ViewHolder>{
    private List<Exercici> mData;
    private LayoutInflater mInflater;
    private Context context;
    private boolean algo = false;
    public AdapterList(List<Exercici> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount(){return mData.size();}

    @Override
    public AdapterList.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.item_list,null);
        return new AdapterList.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterList.ViewHolder holder,final int position){
        holder.bindData(mData.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Aqui lo que hacemos es pasarle el fragmento al que queremos dirigirnos al hacer clic
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Fragment fragmentejercicios =  new FragmentEjercicios();

                //De la clase Exercici le decimos que recoja la informacion del array mData segun la posicion que a sido seleccionada
                Exercici exercici = mData.get(position);


                Bundle bundle = new Bundle();
                bundle.putSerializable("exercici", exercici);

                fragmentejercicios.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.id_rutina, fragmentejercicios).addToBackStack(null).commit();

            }
        });

    }

    public void setItems(List<Exercici> items){mData = items;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImage;
        TextView nombre,status,segundonombre;

        ViewHolder(View itemView){
            super(itemView);

            iconImage = itemView.findViewById(R.id.Icono);
            /*iconImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(algo==false){
                        iconImage.setColorFilter(Color.parseColor("#FE6262"));
                        algo =true;
                    }else if(algo==true){
                        iconImage.setColorFilter(Color.parseColor("#62BAF9"));
                       algo = false;
                    }

                }
            });*/

            nombre = itemView.findViewById(R.id.nombretextview);
            //status = itemView.findViewById(R.id.statustextview);
            segundonombre = itemView.findViewById(R.id.segundonombretextview);
        }

        void bindData(final Exercici item){

            if(item.getNombre().equals("Cardio")){
                iconImage.setImageResource(R.drawable.ic_favorite_24px);

            }else if(item.getNombre().equals("Pilates")){
                iconImage.setImageResource(R.drawable.ic_self_improvement_24px);

            }else if(item.getNombre().equals("Musculación")){
                iconImage.setImageResource(R.drawable.ic_fitness_center_24px);
            }
            iconImage.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            nombre.setText(item.getNombre());
            //status.setText((item.getStatus()));
            segundonombre.setText((item.getSegundonombre()));

            //iconImage.setImageResource(getResources().getIdentifier("ImageName","drawable",getPackageName()));


        }
    }
}