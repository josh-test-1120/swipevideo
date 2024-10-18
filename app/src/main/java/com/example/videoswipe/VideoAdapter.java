package com.example.videoswipe;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * This is the Video Adapter that extends the RecycleView.Adapter
 * and uses the VideoViewHolder class we defined as the instance type
 */
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    // Variables for the Adapter
    private List<VideoItem> videoItems;

    /**
     * This is the constructor
     * @param videoItems this is a list of VideoItem instances
     */
    public VideoAdapter(List<VideoItem> videoItems) {
        this.videoItems = videoItems;
    }

    /**
     * This is the onCreateViewHolder that is part of the parent class RecycleView.Adapter
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return an instance of VideoViewHolder
     */
    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.video_container,parent,false)
        );
    }

    /**
     * This is the onBindViewHolder that is part of the parent class RecycleView.Adapter
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.setVideoData(videoItems.get(position));
    }

    /**
     * This will get the count of items in the list
     * @return an integer that represents the number of the video items
     */
    @Override
    public int getItemCount() {
        return videoItems.size();
    }

    /**
     * This is the static Video View Holder class that extends the
     * RecyclerView.ViewHolder class
     */
    static class VideoViewHolder extends RecyclerView.ViewHolder {
        // These are the variables we will use in the View
        TextView videoTitle, videoDescription, videoID;
        VideoView videoView;
        ProgressBar progressBar;

        /**
         * This is instance call for the VideoViewHolder
         * @param itemView This is an instance of a View to be used
         */
        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.videoView);
            videoTitle = itemView.findViewById(R.id.videoTitle);
            videoDescription = itemView.findViewById(R.id.videoDescription);
            videoID = itemView.findViewById(R.id.videoID);
            progressBar = itemView.findViewById(R.id.videoProgressBar);
        }

        /**
         * This will setup the Video data for the view
         * @param videoItem This is an instance of a View to be used
         */
        void setVideoData(VideoItem videoItem) {
            videoTitle.setText(videoItem.getVideoTitle());
            videoID.setText(videoItem.getVideoID());
            videoDescription.setText(videoItem.getVideoDescription());
            videoView.setVideoPath(videoItem.getVideoURL());
            /**
             * This is the setOnPreparedListener that is part of the parent class VideoView
             */
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    // Ensure the progress bar is not visible
                    progressBar.setVisibility(View.GONE);
                    // Start the media player
                    mediaPlayer.start();
                    // Determine the scaling factors
                    float videoRatio = mediaPlayer.getVideoWidth() / (float) mediaPlayer.getVideoHeight();
                    float screenRatio = videoView.getWidth() / (float) videoView.getHeight();
                    // Calculate the scale
                    float scale = videoRatio / screenRatio;
                    // Set the scale for the VideoView
                    if (scale > 1f) {
                        videoView.setScaleX(scale);
                    }
                    else {
                        videoView.setScaleY(1f / scale);
                    }
                }
            });
            /**
             * This is the setOnCompletionListener that is part of the parent class VideoView
             */
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });
        }
    }
}
