package com.example.student.myapplication;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private Button song;
    private MediaPlayer MdPl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myAdapter = new MyAdapter();
        song = (Button) findViewById(R.id.buttonSong);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(myAdapter);
        myAdapter.setData(generatedDataList());

        MdPl = MediaPlayer.create(getApplicationContext(), R.raw.song);

        song.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MdPl.isPlaying()) {
                    MdPl.pause();
                    song.setText("Play");
                } else {
                    MdPl.start();
                    song.setText("Stop");
                }

            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        MdPl.pause();
        song.setText("Play");
    }

    @Override
    protected void onDestroy() {
        MdPl.stop();
        MdPl.release();
        MdPl = null;
        super.onDestroy();
    }

    private List<String> generatedDataList() {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add(String.valueOf(i));
        }
        return data;
    }

}