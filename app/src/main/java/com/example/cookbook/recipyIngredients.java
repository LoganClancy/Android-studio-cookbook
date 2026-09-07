package com.example.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class recipyIngredients extends AppCompatActivity {
    EditText nameText;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.recipe_ingredients);


        nameText = findViewById(R.id.name);

        name = getIntent().getStringExtra("name");
        if(name != null) {nameText.setText(name);}
        Button procedure = findViewById(R.id.procedureButton);//procedure button


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void openProcedureText(View v){
        nameText = findViewById(R.id.name);//name of the recipy thats sent to the next screen need to get here so it isnt blank
        name = nameText.getText().toString();//get the string of that name


        Intent intent = new Intent(recipyIngredients.this, recipyProcedure.class);
        intent.putExtra("name", name);
        startActivity(intent);
        finish();
    }

}