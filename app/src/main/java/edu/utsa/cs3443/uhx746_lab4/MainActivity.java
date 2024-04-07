package edu.utsa.cs3443.uhx746_lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    /**
     * onCreate(Bundle):
     *  - Initializes the 3 `Button` views.
     *  - Sets their corresponding onClickListeners to open `StarshipActivity`.
     *  - Passes the `registry` of the chosen `Starship` through an `Intent` to `StarshipActivity`.
     * @param savedInstanceState - IDK what this is but we need it :)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Buttons
        Button button1, button2, button3;

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        // button1 onClick()
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StarshipActivity.class);
                intent.putExtra("registry", "NCC-1701-A");
                startActivity(intent);
            }
        });

        // button2 onClick()
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StarshipActivity.class);
                intent.putExtra("registry", "NCC-1701-D");
                startActivity(intent);
            }
        });

        // button3 onClick()
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StarshipActivity.class);
                intent.putExtra("registry", "NCC-74656");
                startActivity(intent);
            }
        });
    }
}