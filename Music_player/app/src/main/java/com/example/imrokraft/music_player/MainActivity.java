package com.example.imrokraft.music_player;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;


public class MainActivity extends ActionBarActivity {
    Button a1,a2,a3,a4;
    static MediaPlayer mplayer;
    String url="http://www.indiamp3.com/music/index.php?action=song&id=93534";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a1=(Button)findViewById(R.id.button);
        a2=(Button)findViewById(R.id.button2);
        a3=(Button)findViewById(R.id.button3);
        a4=(Button)findViewById(R.id.button4);
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mplayer=new MediaPlayer();
                mplayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try
                {
                    mplayer.setDataSource(url);

                }catch(IllegalArgumentException e)
                {
                    Toast.makeText(getApplicationContext(),"Check url!!",Toast.LENGTH_SHORT).show();
                }
                catch(SecurityException e)
                {
                    Toast.makeText(getApplicationContext(),"Check url!!",Toast.LENGTH_SHORT).show();
                }
                catch(IllegalStateException e)
                {
                    Toast.makeText(getApplicationContext(),"Check url!!",Toast.LENGTH_SHORT).show();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                try
                {
                    mplayer.prepare();
                }catch (IllegalStateException e)
                {
                    Toast.makeText(getApplicationContext(),"Check url!!",Toast.LENGTH_SHORT).show();
                }
                catch (IOException e)
                {
                    Toast.makeText(getApplicationContext(),"Check url!!",Toast.LENGTH_SHORT).show();
                }mplayer.start();
            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mplayer!=null&&mplayer.isPlaying())
                {
                    mplayer.stop();
                }
            }
        });

    }
    protected void OnDestroy()
    {
        super.onDestroy();
        if(mplayer!=null)
        {
            mplayer.release();
            mplayer=null;
        }
    }


}
