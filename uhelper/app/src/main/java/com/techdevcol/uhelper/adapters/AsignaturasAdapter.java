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
import com.techdevcol.uhelper.model.Curso;

public class AsignaturasAdapter extends FirestoreRecyclerAdapter<Curso, AsignaturasAdapter.ViewHolderAsigantura>
{
    private MainActivity.OnclickAsignaturaListener onclickAsignaturaListener;
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public AsignaturasAdapter(@NonNull FirestoreRecyclerOptions<Curso> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolderAsigantura holder, int position, @NonNull Curso model) {
        //cargar los datos
        //se le pide al curso la asignatura
        holder.notaAsign.setText(String.valueOf(model.getAsignatura().getCreditos()));
        holder.nombreDocente.setText(model.getDocente().getNombres() + " " +model.getDocente().getApellidos());
        holder.nombreAsigna.setText(model.getAsignatura().getNombre());
    }

    public void setOnclickAsignaturaListener(MainActivity.OnclickAsignaturaListener onclickAsignaturaListener) {
        this.onclickAsignaturaListener = onclickAsignaturaListener;
    }

    @NonNull
    @Override
    public ViewHolderAsigantura onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.asignatura_item,
               viewGroup, false);
        return new ViewHolderAsigantura(v);
    }

    public class ViewHolderAsigantura extends RecyclerView.ViewHolder
    {
        private TextView nombreAsigna;
        private TextView notaAsign;
        private TextView nombreDocente;
        public ViewHolderAsigantura(@NonNull final View itemView) {
            super(itemView);
            nombreAsigna=itemView.findViewById(R.id.txtNombreAsignatura);
            notaAsign=itemView.findViewById(R.id.txtNotaAsignatura);
            nombreDocente=itemView.findViewById(R.id.txtNombreDocente);
            //cargar segun el item de la asignatura
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos=getAdapterPosition();
                    if(onclickAsignaturaListener!=null && pos!=RecyclerView.NO_POSITION)
                    {
                        onclickAsignaturaListener.onClickCursoItem(pos);
                    }
                }
            });
        }

    }
}
