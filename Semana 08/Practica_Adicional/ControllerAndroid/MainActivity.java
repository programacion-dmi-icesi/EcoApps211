package edu.co.icesi.clienteandroidtcp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button upBtn,downBtn,leftBtn,rightBtn;
    private BufferedWriter bwriter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        upBtn = findViewById(R.id.upBtn);
        downBtn = findViewById(R.id.downBtn);
        leftBtn = findViewById(R.id.leftBtn);
        rightBtn = findViewById(R.id.rightBtn);


        //Metodo de suscripcion
        upBtn.setOnClickListener(this);
        downBtn.setOnClickListener(this);
        leftBtn.setOnClickListener(this);
        rightBtn.setOnClickListener(this);


        new Thread(

                () -> {

                    try {
                        //Direccion del computador

                        //Server -> 192.168.0.12
                        //Socket socket = new Socket("192.168.0.15", 5000);
                        Socket socket = new Socket("10.0.2.2", 6000);

                        OutputStream os = socket.getOutputStream();
                        OutputStreamWriter osw = new OutputStreamWriter(os);
                        bwriter = new BufferedWriter(osw);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

        ).start();


    }

    //metodo de notificacion
    @Override
    public void onClick(View v) {
        Gson gson = new Gson();


        switch (v.getId()){
            case R.id.upBtn:
                Coordenada up = new Coordenada("UP");
                String jsonup = gson.toJson(up);
                enviar(jsonup);
                break;
            case R.id.downBtn:
                Coordenada down = new Coordenada("DOWN");
                String jsondown = gson.toJson(down);
                enviar(jsondown);
                break;
            case R.id.leftBtn:
                Coordenada left = new Coordenada("LEFT");
                String jsonleft = gson.toJson(left);
                enviar(jsonleft);
                break;
            case R.id.rightBtn:
                Coordenada right = new Coordenada("RIGHT");
                String jsonright = gson.toJson(right);
                enviar(jsonright);
                break;
        }
    }

    public void enviar(String msg){
        new Thread(() -> {
            try {
                bwriter.write(msg + "\n");
                bwriter.flush();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }).start();
    }

}