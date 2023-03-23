package com.taller.juegos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TriquiActivity extends AppCompatActivity implements View.OnClickListener {
    int[] matriz=new int[9];
    ImageView img1,img2,img3,img4,img5,img6,img7,img8,img9;
    boolean winPlayerOne,WinPlayertwo,notirar=false;
    int tiradas=0,aleatorio=0;
    private String[] players;
    private static int tu=0,yo=0,empate=0;
    TextView marcador1,marcador2,marcador;
    int jugador=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triqui);
        Bundle info = getIntent().getExtras();
        players = new String[]{info.getString("Jugador 1"), info.getString("Jugador 2")};
        img1=(ImageView) findViewById(R.id.img1);
        img2=(ImageView) findViewById(R.id.img2);
        img3=(ImageView) findViewById(R.id.img3);
        img4=(ImageView) findViewById(R.id.img4);
        img5=(ImageView) findViewById(R.id.img5);
        img6=(ImageView) findViewById(R.id.img6);
        img7=(ImageView) findViewById(R.id.img7);
        img8=(ImageView) findViewById(R.id.img8);
        img9=(ImageView) findViewById(R.id.img9);
        marcador1=(TextView) findViewById(R.id.PlayerOne);
        marcador2=(TextView) findViewById(R.id.PlayerTwo);
        marcador=(TextView) findViewById(R.id.empate);

        for(int i=0;i<9;i++ ){
                matriz[i]=0;
        }
        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        img5.setOnClickListener(this);
        img6.setOnClickListener(this);
        img7.setOnClickListener(this);
        img8.setOnClickListener(this);
        img9.setOnClickListener(this);
        aleatorio=(int)(8*Math.random())+1;
        actualizarmarcador();
        borrar();

    }
public void onClick(View v){
        boolean tiro=false;
        switch (v.getId()){
            case    R.id.img1:
                if(matriz[0]==0&&jugador==1){
                    img1.setImageResource(R.drawable.equis);
                    matriz[0]=1;
                    tiro=true;
                }
                if(matriz[0]==0&&jugador==2){
                    img1.setImageResource(R.drawable.circulo);
                    matriz[0]=2;
                    tiro=true;
                }
                break;
            case    R.id.img2:
                if(matriz[1]==0&&jugador==1){
                    img2.setImageResource(R.drawable.equis);
                    matriz[1]=1;
                    tiro=true;
                }
                if(matriz[1]==0&&jugador==2){
                    img2.setImageResource(R.drawable.circulo);
                    matriz[1]=2;
                    tiro=true;
                }
                break;
            case    R.id.img3:
                if(matriz[2]==0&&jugador==1){
                    img3.setImageResource(R.drawable.equis);
                    matriz[2]=1;
                    tiro=true;
                }
                if(matriz[2]==0&&jugador==2){
                    img3.setImageResource(R.drawable.circulo);
                    matriz[2]=2;
                    tiro=true;
                }
                break;
            case    R.id.img4:
                if(matriz[3]==0&&jugador==1){
                    img4.setImageResource(R.drawable.equis);
                    matriz[3]=1;
                    tiro=true;
                }
                if(matriz[3]==0&&jugador==2){
                    img4.setImageResource(R.drawable.circulo);
                    matriz[3]=2;
                    tiro=true;
                }
                break;
            case    R.id.img5:
                if(matriz[4]==0&&jugador==1){
                    img5.setImageResource(R.drawable.equis);
                    matriz[4]=1;
                    tiro=true;
                }
                if(matriz[4]==0&&jugador==2){
                    img5.setImageResource(R.drawable.circulo);
                    matriz[4]=2;
                    tiro=true;
                }
                break;
            case    R.id.img6:
                if(matriz[5]==0&&jugador==1){
                    img6.setImageResource(R.drawable.equis);
                    matriz[5]=1;
                    tiro=true;
                }
                if(matriz[5]==0&&jugador==2){
                    img6.setImageResource(R.drawable.circulo);
                    matriz[5]=2;
                    tiro=true;
                }
                break;
            case    R.id.img7:
                if(matriz[6]==0&&jugador==1){
                    img7.setImageResource(R.drawable.equis);
                    matriz[6]=1;
                    tiro=true;
                }
                if(matriz[6]==0&&jugador==2){
                    img7.setImageResource(R.drawable.circulo);
                    matriz[6]=2;
                    tiro=true;
                }
                break;
            case    R.id.img8:
                if(matriz[7]==0&&jugador==1){
                    img8.setImageResource(R.drawable.equis);
                    matriz[7]=1;
                    tiro=true;
                }
                if(matriz[7]==0&&jugador==2){
                    img8.setImageResource(R.drawable.circulo);
                    matriz[7]=2;
                    tiro=true;
                }
                break;
            case    R.id.img9:
                if(matriz[8]==0&&jugador==1){
                    img9.setImageResource(R.drawable.equis);
                    matriz[8]=1;
                    tiro=true;
                }
                if(matriz[8]==0&&jugador==2){
                    img9.setImageResource(R.drawable.circulo);
                    matriz[8]=2;
                    tiro=true;
                }
                break;
        }
        if(tiro==true){
            if(jugador==1){
                jugador=2;
            }else {jugador=1;}
            tiradas++;
            quiengana();
            checa();
        }
}
public void borrar(){
        img1.setImageResource(R.drawable.casilla);
    img2.setImageResource(R.drawable.casilla);
    img3.setImageResource(R.drawable.casilla);
    img4.setImageResource(R.drawable.casilla);
    img5.setImageResource(R.drawable.casilla);
    img6.setImageResource(R.drawable.casilla);
    img7.setImageResource(R.drawable.casilla);
    img8.setImageResource(R.drawable.casilla);
    img9.setImageResource(R.drawable.casilla);
    for(int i=0;i<9;i++){
        matriz[i]=0;
    }
    winPlayerOne=false;
    WinPlayertwo=false;
    tiradas=0;
    aleatorio=(int)(8*Math.random())+1;
}
    public void actualizarmarcador(){
        marcador.setText("");
        marcador1.setText("");
        marcador2.setText("");
        String text1 = String.valueOf(tu);
        String text2 = String.valueOf(yo);
        String text3 = String.valueOf(empate);
        marcador.setText("empate: "+text3);
        marcador1.setText(players[0]+": "+text1);
        marcador2.setText(players[1]+": "+text2);
    }
    public void checa(){
        if(winPlayerOne==true) {
            Toast toast = Toast.makeText(this, "Ha ganado "+players[0], Toast.LENGTH_LONG);
            toast.show();
            tu++;
            reiniciaActivity(this);
        }
        if(WinPlayertwo==true) {
            Toast toast = Toast.makeText(this, "Ha ganado "+players[1], Toast.LENGTH_LONG);
            toast.show();
            yo++;
            reiniciaActivity(this);
        }
        if(tiradas==9 && winPlayerOne==false && WinPlayertwo==false){
            Toast toast = Toast.makeText(this,"Empate",Toast.LENGTH_LONG);
            toast.show();
            empate++;
        }
    }
    public static void reiniciaActivity(Activity actividad){
        Intent intent= new Intent();
        intent.setClass(actividad,actividad.getClass());
        actividad.startActivity(intent);
        actividad.finish();
    }
    public void quiengana(){
        if(matriz[0]==1 && matriz[1]==1 && matriz[2]==1){
            winPlayerOne=true;
        }
        if(matriz[3]==1 && matriz[4]==1 && matriz[5]==1){
            winPlayerOne=true;
        }
        if(matriz[6]==1 && matriz[7]==1 && matriz[8]==1){
            winPlayerOne=true;
        }
        if(matriz[0]==1 && matriz[3]==1 && matriz[6]==1){
            winPlayerOne=true;
        }
        if(matriz[1]==1 && matriz[4]==1 && matriz[7]==1){
            winPlayerOne=true;
        }
        if(matriz[2]==1 && matriz[5]==1 && matriz[8]==1){
            winPlayerOne=true;
        }
        if(matriz[0]==1 && matriz[4]==1 && matriz[8]==1){
            winPlayerOne=true;
        }
        if(matriz[2]==1 && matriz[4]==1 && matriz[6]==1){
            winPlayerOne=true;
        }
        if(matriz[0]==2 && matriz[1]==2 && matriz[2]==2){
            WinPlayertwo=true;
        }
        if(matriz[3]==2 && matriz[4]==2 && matriz[5]==2){
            WinPlayertwo=true;
        }
        if(matriz[6]==2 && matriz[7]==2 && matriz[8]==2){
            WinPlayertwo=true;
        }
        if(matriz[0]==2 && matriz[3]==2 && matriz[6]==2){
            WinPlayertwo=true;
        }
        if(matriz[1]==2 && matriz[4]==2 && matriz[7]==2){
            WinPlayertwo=true;
        }
        if(matriz[2]==2 && matriz[5]==2 && matriz[8]==2){
            WinPlayertwo=true;
        }
        if(matriz[0]==2 && matriz[4]==2 && matriz[8]==2){
            WinPlayertwo=true;
        }
        if(matriz[2]==2 && matriz[4]==2 && matriz[6]==2){
            WinPlayertwo=true;
        }
    }
}