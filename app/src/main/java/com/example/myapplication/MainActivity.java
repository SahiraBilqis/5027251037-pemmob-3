package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNama;
    private EditText etNrp;
    private EditText etDepartemen;
    private EditText etTtl;
    private EditText etAngkatan;
    private EditText etEmail;

    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // HUBUNGKAN JAVA DENGAN XML
        etNama = findViewById(R.id.etNama);
        etNrp = findViewById(R.id.etNrp);
        etDepartemen = findViewById(R.id.etDepartemen);
        etTtl = findViewById(R.id.etTtl);
        etAngkatan = findViewById(R.id.etAngkatan);
        etEmail = findViewById(R.id.etEmail);

        btnNext = findViewById(R.id.btnNext);


        // TOMBOL NEXT
        btnNext.setOnClickListener(v -> {

            String nama = etNama.getText().toString().trim();
            String nrp = etNrp.getText().toString().trim();
            String departemen = etDepartemen.getText().toString().trim();
            String ttl = etTtl.getText().toString().trim();
            String angkatan = etAngkatan.getText().toString().trim();
            String email = etEmail.getText().toString().trim();


            // ============================
            // VALIDASI
            // ============================

            if (nama.isEmpty()) {
                etNama.setError("Nama wajib diisi");
                etNama.requestFocus();
                return;
            }

            if (nrp.isEmpty()) {
                etNrp.setError("NRP wajib diisi");
                etNrp.requestFocus();
                return;
            }

            if (departemen.isEmpty()) {
                etDepartemen.setError("Departemen wajib diisi");
                etDepartemen.requestFocus();
                return;
            }

            if (ttl.isEmpty()) {
                etTtl.setError("TTL wajib diisi");
                etTtl.requestFocus();
                return;
            }

            if (angkatan.isEmpty()) {
                etAngkatan.setError("Angkatan wajib diisi");
                etAngkatan.requestFocus();
                return;
            }

            if (email.isEmpty()) {
                etEmail.setError("Email wajib diisi");
                etEmail.requestFocus();
                return;
            }


            // ============================
            // PINDAH KE SLIDE 2
            // ============================

            Intent intent =
                    new Intent(MainActivity.this, ResultActivity.class);


            // KIRIM DATA
            intent.putExtra("nama", nama);
            intent.putExtra("nrp", nrp);
            intent.putExtra("departemen", departemen);
            intent.putExtra("ttl", ttl);
            intent.putExtra("angkatan", angkatan);
            intent.putExtra("email", email);


            // BUKA SLIDE 2
            startActivity(intent);
        });
    }
}