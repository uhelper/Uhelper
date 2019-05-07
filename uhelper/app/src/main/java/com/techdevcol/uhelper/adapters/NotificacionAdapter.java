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
import com.techdevcol.uhelper.activities.MainActivity;
import com.techdevcol.uhelper.model.Notificacion;

import java.text.SimpleDateFormat;

public class NotificacionAdapter extends FirestoreRecyclerAdapter<Notificacion, NotificacionAdapter.NotificacionHolder>
{
    public NotificacionAdapter(@NonNull FirestoreRecyclerOptions<Notificacion> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull NotificacionHolder holder, int position, @NonNull Notificacion notificacion) {
        holder.txtTitulo.setText(notificacion.getTitulo());
        holder.txtDescripcion.setText(notificacion.getDescripcion());

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String cadenaFecha = sdf.format(notificacion.getFecha());
        holder.txtFecha.setText("Fecha de publicación: " + cadenaFecha);
    }

    @NonNull
    @Override
    public NotificacionHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_notificacion,
                viewGroup, false);
        return new NotificacionHolder(v);
    }

    public class NotificacionHolder extends RecyclerView.ViewHolder
    {
        private TextView txtTitulo;
        private TextView txtDescripcion;
        private TextView txtFecha;
        public NotificacionHolder(@NonNull final View itemView) {
            super(itemView);
            txtTitulo = itemView.findViewById(R.id.txtTitulo);
            txtDescripcion = itemView.findViewById(R.id.txtDescripcion);
            txtFecha = itemView.findViewById(R.id.txtFecha);
        }

    }
}
