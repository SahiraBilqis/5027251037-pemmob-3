package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private TextView tvInitial;
    private TextView tvNama;
    private TextView tvNrp;
    private TextView tvDepartemen;
    private TextView tvTtl;
    private TextView tvAngkatan;
    private TextView tvEmail;

    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // XML SLIDE 2
        setContentView(R.layout.resultact);


        // ============================
        // HUBUNGKAN DENGAN XML
        // ============================

        tvInitial = findViewById(R.id.tvInitial);
        tvNama = findViewById(R.id.tvNama);
        tvNrp = findViewById(R.id.tvNrp);
        tvDepartemen = findViewById(R.id.tvDepartemen);
        tvTtl = findViewById(R.id.tvTtl);
        tvAngkatan = findViewById(R.id.tvAngkatan);
        tvEmail = findViewById(R.id.tvEmail);

        btnBack = findViewById(R.id.btnBack);


        // ============================
        // AMBIL DATA SLIDE 1
        // ============================

        String nama =
                getIntent().getStringExtra("nama");

        String nrp =
                getIntent().getStringExtra("nrp");

        String departemen =
                getIntent().getStringExtra("departemen");

        String ttl =
                getIntent().getStringExtra("ttl");

        String angkatan =
                getIntent().getStringExtra("angkatan");

        String email =
                getIntent().getStringExtra("email");


        // ============================
        // ANTISIPASI NULL
        // ============================

        if (nama == null) {
            nama = "-";
        }

        if (nrp == null) {
            nrp = "-";
        }

        if (departemen == null) {
            departemen = "-";
        }

        if (ttl == null) {
            ttl = "-";
        }

        if (angkatan == null) {
            angkatan = "-";
        }

        if (email == null) {
            email = "-";
        }


        // ============================
        // TAMPILKAN DATA
        // ============================

        tvNama.setText(nama);

        tvNrp.setText(
                "NRP  " + nrp
        );

        tvDepartemen.setText(
                departemen
        );

        tvTtl.setText(
                ttl
        );

        tvAngkatan.setText(
                "ANGKATAN  " + angkatan
        );

        tvEmail.setText(
                email
        );


        // INITIAL OTOMATIS
        tvInitial.setText(
                getInitial(nama)
        );


        // ============================
        // TOMBOL EDIT / BACK
        // ============================

        btnBack.setOnClickListener(v -> {

            // KEMBALI KE SLIDE 1
            finish();
        });
    }


    // =================================
    // MEMBUAT INITIAL
    //
    // Sahira Bilqis = SB
    // Budi Susanto = BS
    // =================================

    private String getInitial(String nama) {

        if (
                nama == null ||
                        nama.trim().isEmpty() ||
                        nama.equals("-")
        ) {

            return "ID";
        }


        String[] kata =
                nama.trim().split("\\s+");


        // SATU KATA
        if (kata.length == 1) {

            if (kata[0].length() >= 2) {

                return kata[0]
                        .substring(0, 2)
                        .toUpperCase();
            }

            return kata[0]
                    .toUpperCase();
        }


        // DUA KATA ATAU LEBIH
        return (
                kata[0].substring(0, 1) +
                        kata[1].substring(0, 1)
        ).toUpperCase();
    }
}