package com.example.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class recipyProcedure extends AppCompatActivity {
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recipy_procedure);

        name = getIntent().getStringExtra("name");

        TextView procedureName = findViewById(R.id.procedureName);
        procedureName.setText(name);




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }



    public void openIngredients(View v){//goes back to the ingredient recipe activity
        Intent intent = new Intent(recipyProcedure.this, recipyIngredients.class);
        intent.putExtra("name", name);
        startActivity(intent);
        finish();


    }



}