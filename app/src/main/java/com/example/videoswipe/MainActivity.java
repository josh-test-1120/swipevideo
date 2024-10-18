package com.example.videoswipe;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the main activity view that drives the application layout
 */
public class MainActivity extends AppCompatActivity {
    /**
     * This is the onCreate method from the AppCompatActivity
     * @param savedInstanceState this is an instance of Bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Initialize the view Page reference
        final ViewPager2 viewPage = findViewById(R.id.videoViewPager);
        // Create the list of video items
        List<VideoItem> videoItems = new ArrayList<>();
        // Video 1
        String video1URL = "https://firebasestorage.googleapis.com/v0/b/joshtest-f2aa2.appspot.com/o/test1.mp4?alt=media&token=8d8d3476-3523-449a-bc9b-186935b0ab0d";
        String video1Title = "Video 1";
        String video1Description = "Video 1 example from phone";
        VideoItem video1 = new VideoItem(video1URL,video1Title,video1Description);
        // Video 2
        String video2URL = "https://firebasestorage.googleapis.com/v0/b/joshtest-f2aa2.appspot.com/o/test2.mp4?alt=media&token=877069d0-4a07-424a-a214-fa6335fad38e";
        String video2Title = "Video 2";
        String video2Description = "Video 2 example from phone";
        VideoItem video2 = new VideoItem(video2URL,video2Title,video2Description);
        // Video 3
        String video3URL = "https://firebasestorage.googleapis.com/v0/b/joshtest-f2aa2.appspot.com/o/test3.mp4?alt=media&token=71d2639b-fabe-46c3-8d2b-7a483752ccd9";
        String video3Title = "Video 3";
        String video3Description = "Video 3 example from phone";
        VideoItem video3 = new VideoItem(video3URL,video3Title,video3Description);
        // Add the videos to the list
        videoItems.add(video1);
        videoItems.add(video2);
        videoItems.add(video3);
        // Set the view page to leverage the adapter for recycle viewss
        viewPage.setAdapter(new VideoAdapter(videoItems));
    }
}