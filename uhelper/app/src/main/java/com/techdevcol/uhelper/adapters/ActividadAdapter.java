package com.techdevcol.uhelper.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.techdevcol.uhelper.R;
import com.techdevcol.uhelper.model.Actividad;

import java.text.SimpleDateFormat;

public class ActividadAdapter extends FirestoreRecyclerAdapter<Actividad, ActividadAdapter.ActividadHolder>
{
    public ActividadAdapter(@NonNull FirestoreRecyclerOptions<Actividad> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ActividadHolder holder, int position, @NonNull Actividad actividad) {
        holder.txtDescripcion.setText(actividad.getDescripcion());

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String cadenaFecha = sdf.format(actividad.getFecha().toDate());
        holder.txtFecha.setText("Fecha de publicación: " + cadenaFecha);
    }

    @NonNull
    @Override
    public ActividadHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_actividad,
                viewGroup, false);
        return new ActividadHolder(v);
    }

    public class ActividadHolder extends RecyclerView.ViewHolder
    {
        private TextView txtDescripcion;
        private TextView txtFecha;
        public ActividadHolder(@NonNull final View itemView) {
            super(itemView);
            txtDescripcion = itemView.findViewById(R.id.txtDescripcion);
            txtFecha = itemView.findViewById(R.id.txtFecha);
        }

    }
}

