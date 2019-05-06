package com.techdevcol.uhelper.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
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
    }

    public void setOnclickAsignaturaListener(MainActivity.OnclickAsignaturaListener onclickAsignaturaListener) {
        this.onclickAsignaturaListener = onclickAsignaturaListener;
    }

    @NonNull
    @Override
    public ViewHolderAsigantura onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       // View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.nota_item,
       //         viewGroup, false);
     //   return new ViewHolderAsigantura(v);

        return null;
    }

    public class ViewHolderAsigantura extends RecyclerView.ViewHolder
    {

        public ViewHolderAsigantura(@NonNull final View itemView) {
            super(itemView);
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
