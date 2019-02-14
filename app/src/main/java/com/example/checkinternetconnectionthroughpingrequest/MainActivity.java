package com.example.checkinternetconnectionthroughpingrequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button checkInternet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkInternet =findViewById(R.id.checkInternet);
        checkInternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkInternet();
            }
        });
    }

    public boolean isConnected() throws InterruptedException, IOException {
        final String command = "ping -c 1 google.com";
        return Runtime.getRuntime().exec(command).waitFor() == 0;
    }

    private void checkInternet() {
        try {
            if(isConnected()){
                Toast.makeText(MainActivity.this, "You are connected to Internet", Toast.LENGTH_SHORT).show();
            }else{
                //disable the button when the proccess is running
                Toast.makeText(MainActivity.this, "You are not connected to Internet", Toast.LENGTH_SHORT).show();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
