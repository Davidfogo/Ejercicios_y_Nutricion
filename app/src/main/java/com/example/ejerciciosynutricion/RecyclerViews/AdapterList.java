package com.example.ejerciciosynutricion.RecyclerViews;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ejerciciosynutricion.Modal.Exercici;
import com.example.ejerciciosynutricion.R;

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

            iconImage.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            nombre.setText(item.getNom());
            //status.setText((item.getStatus()));
            segundonombre.setText((item.getSegundonombre()));

            //iconImage.setImageResource(getResources().getIdentifier("ImageName","drawable",getPackageName()));


        }
    }
}