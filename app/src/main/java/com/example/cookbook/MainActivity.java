package com.example.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {//main activity first screen of the app

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button addButton = findViewById(R.id.addButton);//button to press to add a new recipe to your book



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void open2ndActivity(View v){//method thats ran when the button is pressed
        startRecipeIngredients();//starts the recipy ingrededients activity not passing any variables
    }



    public void startRecipeIngredients(){
        Intent intent = new Intent(MainActivity.this, recipyIngredients.class);
        startActivity(intent);
        finish();
    }

}

