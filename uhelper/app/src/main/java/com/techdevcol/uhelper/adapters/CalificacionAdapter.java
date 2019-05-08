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
import com.techdevcol.uhelper.model.Calificacion;

import java.util.ArrayList;

public class CalificacionAdapter extends FirestoreRecyclerAdapter<Calificacion, CalificacionAdapter.CalificacionHolder>
{
    private double definitiva;

    public CalificacionAdapter(@NonNull FirestoreRecyclerOptions<Calificacion> options) {
        super(options);
        definitiva = 0.0;
    }

    @Override
    protected void onBindViewHolder(@NonNull CalificacionHolder holder, int position, @NonNull Calificacion calificacion) {
        holder.txtPorcentaje.setText("Porcentaje: (" + (int) calificacion.getPorcentaje() + "%)");
        holder.txtNota.setText("Nota: " + calificacion.getNota());

        definitiva += (calificacion.getNota() * (calificacion.getPorcentaje() / 100));
    }

    public double getDefinitiva()
    {
        return definitiva;
    }

    @NonNull
    @Override
    public CalificacionHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_calificacion,
                viewGroup, false);
        return new CalificacionHolder(v);
    }

    public class CalificacionHolder extends RecyclerView.ViewHolder
    {
        private TextView txtPorcentaje;
        private TextView txtNota;
        public CalificacionHolder(@NonNull final View itemView) {
            super(itemView);
            txtPorcentaje = itemView.findViewById(R.id.txtPorcentaje);
            txtNota = itemView.findViewById(R.id.txtNota);
        }

    }
}