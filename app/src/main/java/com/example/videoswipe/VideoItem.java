package com.example.videoswipe;

import java.util.Random;

/**
 * This is the VideoItem model class
 */
public class VideoItem {
    // Private variables for the model
    private String videoURL, videoTitle, videoDescription, videoID;

    /**
     * Getter for the VideoID variable
     * @return String of video ID
     */
    public String getVideoID() {
        return videoID;
    }

    /**
     * Setter for the VideoID
     * @param videoID this is a string of the video ID
     */
    public void setVideoID(String videoID) {
        this.videoID = videoID;
    }

    /**
     * This is the getter for the VideoURL
     * @return String of the video URL
     */
    public String getVideoURL() {
        return videoURL;
    }

    /**
     * This is the setter for the VideoURL
     * @param videoURL This is a string of the video URL
     */
    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    /**
     * This is the getter for the VideoTitle
     * @return String of the video title
     */
    public String getVideoTitle() {
        return videoTitle;
    }

    /**
     * This is the setter for the VideoTitle
     * @param videoTitle This is the string of the video title
     */
    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    /**
     * This is the getter for the VideoDescription
     * @return String of the video description
     */
    public String getVideoDescription() {
        return videoDescription;
    }

    /**
     * This is the setter for the VideoDescription
     * @param videoDescription String of the video description
     */
    public void setVideoDescription(String videoDescription) {
        this.videoDescription = videoDescription;
    }

    /**
     * This is the constructor for the Video Item class
     * @param videoURL String of the video URL
     * @param videoTitle String of the video Title
     * @param videoDescription String of the video description
     */
    public VideoItem(String videoURL, String videoTitle, String videoDescription) {
        this.videoURL = videoURL;
        this.videoTitle = videoTitle;
        this.videoDescription = videoDescription;
        Random rand = new Random();
        this.videoID = Integer.toString(rand.nextInt(99999999));
    }
}
