package com.example.vozz;



import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity { 

	private Button bGrabar, bDetener, bReproducir;
	
	
	private static final String LOG_TAG = "Grabadora";          
private MediaRecorder mediaRecorder;
private MediaPlayer mediaPlayer;
private static String x = Environment.                 
getExternalStorageDirectory().getAbsolutePath()+"/audio.3gp";
   
@Override public void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
 


    bGrabar = (Button) findViewById(R.id.bGrabar);
    bDetener = (Button) findViewById(R.id.bDetener);
    bReproducir = (Button) findViewById(R.id.bReproducir);
    bDetener.setEnabled(false);
    bReproducir.setEnabled(false);


}
 
 public void grabar(View view) {
    mediaRecorder = new MediaRecorder();
    mediaRecorder.setOutputFile(x);
    mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
    mediaRecorder.setOutputFormat(MediaRecorder.
                                          OutputFormat.THREE_GPP);
    mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.
                                                     AMR_NB); 
    
    
    
    bGrabar.setEnabled(false);
    bDetener.setEnabled(true);
    bReproducir.setEnabled(false);
    
    
    try {
        mediaRecorder.prepare();
    } catch (IOException e) {
        Log.e(LOG_TAG, "Fallo ");
    }
    mediaRecorder.start();
  }
 
  public void detenerGrabacion(View view) {
     mediaRecorder.stop();
     mediaRecorder.release();
  
     bGrabar.setEnabled(true);
     bDetener.setEnabled(false);
     bReproducir.setEnabled(true);
  
  
  }
 
  public void reproducir(View view) {
     mediaPlayer = new MediaPlayer();
     try {
         mediaPlayer.setDataSource(x);
         mediaPlayer.prepare();
         mediaPlayer.start();
     } catch (IOException e) {
         Log.e(LOG_TAG, "Fallo en reproducción");
     }
   }
}