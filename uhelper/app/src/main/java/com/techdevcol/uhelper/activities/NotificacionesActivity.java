package com.techdevcol.uhelper.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.techdevcol.uhelper.R;
import com.techdevcol.uhelper.adapters.AsignaturasAdapter;
import com.techdevcol.uhelper.adapters.NotificacionAdapter;
import com.techdevcol.uhelper.model.Curso;
import com.techdevcol.uhelper.model.Notificacion;

public class NotificacionesActivity extends AppCompatActivity {

    private RecyclerView rvNotificaciones;
    private NotificacionAdapter notificacionAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_keyboard_backspace_black_24dp);
        getSupportActionBar().setTitle(getString(R.string.txt_notificaciones));
        rvNotificaciones= findViewById(R.id.rvNotificaciones);
        String idUsuarioActual= FirebaseAuth.getInstance().getCurrentUser().getUid();
        Query query = FirebaseFirestore.getInstance().collection(Notificacion.NAME_COLLECTION)
                .whereArrayContains("estudiantes",idUsuarioActual);
        FirestoreRecyclerOptions<Notificacion> options= new FirestoreRecyclerOptions.Builder<Notificacion>()
                .setQuery(query, Notificacion.class)
                .build();
        notificacionAdapter=new NotificacionAdapter(options);
        rvNotificaciones.setLayoutManager(new LinearLayoutManager(this));
        rvNotificaciones.setAdapter(notificacionAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        notificacionAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        notificacionAdapter.stopListening();
    }
}
