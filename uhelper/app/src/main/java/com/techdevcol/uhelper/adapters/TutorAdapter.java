package com.techdevcol.uhelper.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.techdevcol.uhelper.R;
import com.techdevcol.uhelper.model.Tutor;


public class TutorAdapter extends FirestoreRecyclerAdapter<Tutor ,TutorAdapter.TutorHolder>
{
    public TutorAdapter(@NonNull FirestoreRecyclerOptions<Tutor> options) {
        super(options);
    }

    @NonNull
    @Override
    public TutorHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tutor_disponible,
                viewGroup, false);
        return new TutorHolder(v);
    }

    @Override
    protected void onBindViewHolder(@NonNull TutorHolder holder, int position, @NonNull Tutor model) {
        holder.nombrePersonal.setText(model.getEstudiante().getNombres().trim()+ " " + model.getEstudiante().getApellidos().trim());
        holder.tutor=model;
    }

    //Esta clase representa cada elemento de la coleccion del RecyclerView, item
    class TutorHolder extends RecyclerView.ViewHolder
    {
        public final static String API_WHATSAPP = "https://api.whatsapp.com/send?phone=";
        public final static String MENSAJE_TEXTO = "&text=Hola,%20¿Qué%20tal?%20estuve%20viendo%20MoviApp%20y%20me%20gustaría%20solicitar%20la%20siguiente%20monitoria:%20";

        Context context;
        private TextView nombrePersonal;
        private Button btnSolicitar;
        private Tutor tutor;
        public TutorHolder(@NonNull View itemView)
        {
            super(itemView);
            context = itemView.getContext();
            nombrePersonal = itemView.findViewById(R.id.txtNombreTutor);
            btnSolicitar = itemView.findViewById(R.id.btnSolicitarMonitoria);
            btnSolicitar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String mensajeMoviApp = tutor.getAsignatura().getNombre() ;
                    String url = API_WHATSAPP + tutor.getEstudiante().getCelular() + MENSAJE_TEXTO + mensajeMoviApp + "%20";;
                    Uri uriUrl = Uri.parse(url);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl);
                    context.startActivity(intent);
                }
            });
        }
    }
}
