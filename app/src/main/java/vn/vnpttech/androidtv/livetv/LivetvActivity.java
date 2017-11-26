package vn.vnpttech.androidtv.livetv;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

import vn.vnpttech.androidtv.R;

/**
 * Created by thangnn on 7/22/16.
 */
public class LivetvActivity extends Activity {
    /**
     * Tag for log
     */
    private static final String TAG = "MediaPlayerActivity";
    //private static MediaController mMediaController;
    List<LivetvModel> channel_list = new ArrayList<LivetvModel>();
    int channel_idx = 0;
    int channelList_size = 0;
    int pre_channel = 0;
    private VideoView mVideoView;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // turn off the window's title bar, must be called before setContentView
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Obsolete flag used for GB/HC to work correctly, but it's causing memory leaking in 7425B1 ICS
        //set fullscreen flag to window
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        //Avoid little bar on top of screen, visible while over-scan resize enabled.
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_SCALED,
        //WindowManager.LayoutParams.FLAG_SCALED);

        //Avoid screen locked during video playback
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_livetv);
        channel_list = LivetvModel.getLivetvModels(getApplicationContext());
        channelList_size = channel_list.size();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart...");

        Bundle extras = getIntent().getExtras();
        //String sCoverUri = extras.getString("CoverURI");
        //channel_list = (ArrayList<Item>)getIntent().getSerializableExtra("ChannelList");
        channel_idx = extras.getInt("ChannelIdx");

        if (extras != null) {
            //Log.d(TAG, "Cover's URI = "+ sCoverUri);
            Log.d(TAG, "Channel index is " + channel_idx);
        }
        String sCoverUri = channel_list.get(channel_idx).getVideoUrl();
        if (channelList_size > 0) {
            Log.d(TAG, "Size of channel list is " + channelList_size);
        }
        //Start a playback from an URI
        mVideoView = (VideoView) findViewById(R.id.VideoView);
        //mMediaController = new MediaController(this);
        //mMediaController.setAnchorView(mVideoView);
        //Change the URI here if you want to test some other format
        Uri video = Uri.parse(sCoverUri);
        //mVideoView.setMediaController(mMediaController);
        mVideoView.setVideoURI(video);
        mVideoView.requestFocus();
        // mVideoView.setLooping(true);//Set looping all the time which is convenient for demo
        mVideoView.start();
        Log.d(TAG, "Playback Start...");
        String channel_name = channel_list.get(channel_idx).getTitle();
        Toast.makeText(getApplicationContext(),
                channel_name, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause...");
        mVideoView.pause();
        mVideoView.suspend();
        // mMediaController.hide();
        finish();
        //System.exit(0);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent msg) {

//        Log.d(TAG, "KEYCODE: " + keyCode);
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            mVideoView.pause();
            mVideoView.suspend();
            // mMediaController.hide();
            // mMediaController.setEnabled(false);

            //Go back to cover flow activity
            Log.d(TAG, "KEYCODE_BACK");
            //Intent myIntent = new Intent(this, MytvActivity.class);
            //startActivity(myIntent);

            finish();
            System.exit(0);
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_CHANNEL_UP || keyCode == KeyEvent.KEYCODE_DPAD_UP) {
            if (channel_idx >= channelList_size) {
                Log.d(TAG, "Can not switch to channel UP. Upper limmited!");
            } else {
                pre_channel = channel_idx;
                channel_idx++;
                String uri = channel_list.get(channel_idx).getVideoUrl();
                Log.d(TAG, "Switch to channel " + uri + " with index up is " + channel_idx);
                Uri video = Uri.parse(uri);
                mVideoView.stopPlayback();
                mVideoView.setVideoURI(video);
                mVideoView.start();
                String channel_name = channel_list.get(channel_idx).getTitle();
                Toast.makeText(getApplicationContext(),
                        channel_name, Toast.LENGTH_LONG).show();
            }
            return true;

        } else if (keyCode == KeyEvent.KEYCODE_CHANNEL_DOWN || keyCode == KeyEvent.KEYCODE_DPAD_DOWN) {
            if (channel_idx < 1) {
                Log.d(TAG, "Can not switch to channel DOWN. Lower limmited!");
            } else {
                pre_channel = channel_idx;
                channel_idx--;
                String uri = channel_list.get(channel_idx).getVideoUrl();
                Log.d(TAG, "Switch to channel " + uri + " with index down is " + channel_idx);
                Uri video = Uri.parse(uri);
                mVideoView.stopPlayback();
                mVideoView.setVideoURI(video);
                mVideoView.start();
                String channel_name = channel_list.get(channel_idx).getTitle();
                Toast.makeText(getApplicationContext(),
                        channel_name, Toast.LENGTH_LONG).show();
            }
            return true;
        }
        if (keyCode == 67) {
            int current_ch = channel_idx;
            channel_idx = pre_channel;
            pre_channel = current_ch;
            String uri = channel_list.get(channel_idx).getVideoUrl();
            Log.d(TAG, "Switch to channel " + uri + " with index is " + channel_idx);
            Uri video = Uri.parse(uri);
            mVideoView.stopPlayback();
            mVideoView.setVideoURI(video);
            mVideoView.start();
            String channel_name = channel_list.get(channel_idx).getTitle();
            Toast.makeText(getApplicationContext(),
                    channel_name, Toast.LENGTH_LONG).show();
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_3) {
            Log.d(TAG, "Open PIP...");
            Bundle oBundle = new Bundle();
            oBundle.putString("TYPE", "OPEN");
            oBundle.putString("URL_VIDEO", "rtp://232.84.1.111:8640");
            oBundle.putInt("PosX", 640);
            oBundle.putInt("PosY", 240);
            oBundle.putInt("Width", 320);
            oBundle.putInt("Height", 240);

            Intent intent = new Intent();
            intent.setAction("com.vnpttech.smb.PIP_INTENT");
            intent.putExtras(oBundle);

            Log.d(TAG, intent.toString());
            sendBroadcast(intent);
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_4) {
            Intent intent = new Intent();
            intent.setAction("com.vnpttech.smb.PIP_INTENT");

            Bundle cBundle = new Bundle();
            cBundle.putString("TYPE", "CLOSE");
            intent.putExtras(cBundle);

            Log.d(TAG, intent.toString());
            sendBroadcast(intent);
            return true;
        } else {
            Log.d(TAG, "Hit Unhandled KeyCode --- " + keyCode);
            return false;
        }
    }

    /* Creates the menu items */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean result = super.onCreateOptionsMenu(menu);

        menu.add(0, 1, 0, "vtv1");
        menu.add(0, 2, 0, "vtv2");
        menu.add(0, 3, 0, "vtv3");
        menu.add(0, 4, 0, "vtv4");
        menu.add(0, 5, 0, "vtv5");
        menu.add(0, 6, 0, "vtv6");
        menu.add(0, 7, 0, "vtv8");
        menu.add(0, 8, 0, "vtv1 HD");
        menu.add(0, 9, 0, "vtv3 HD");
        menu.add(0, 10, 0, "vtv6 HD");
        menu.add(0, 11, 0, "Quoc Hoi");
        menu.add(0, 12, 0, "HTV Phim");
        menu.add(0, 13, 0, "HTV1");
        menu.add(0, 14, 0, "HTV2");
        menu.add(0, 15, 0, "HTV7");
        menu.add(0, 16, 0, "HTV9");
        menu.add(0, 17, 0, "HTV4");
        menu.add(0, 18, 0, "HTV The Thao");
        menu.add(0, 19, 0, "Thuan Viet");
        menu.add(0, 20, 0, "VTC7");
        menu.add(0, 21, 0, "VTC10");
        menu.add(0, 22, 0, "VTC1");
        menu.add(0, 23, 0, "VTC2");
        menu.add(0, 24, 0, "VTC3");
        menu.add(0, 25, 0, "VTC6");
        menu.add(0, 26, 0, "VTC8");
        menu.add(0, 27, 0, "VTC9");
        menu.add(0, 28, 0, "VTC11");
        menu.add(0, 29, 0, "VTC13");
        menu.add(0, 30, 0, "VTC16");
        menu.add(0, 31, 0, "VTC14");
        menu.add(0, 32, 0, "K+1");
        menu.add(0, 33, 0, "K+NS");
        menu.add(0, 34, 0, "K+PM");
        menu.add(0, 35, 0, "K+PC");
        menu.add(0, 36, 0, "K+1 HD");
        menu.add(0, 37, 0, "K+NS HD");
        menu.add(0, 38, 0, "K+PM HD");
        menu.add(0, 39, 0, "K+PC HD");
        menu.add(0, 40, 0, "Bong Da TV");
        menu.add(0, 41, 0, "The Thao TV");
        menu.add(0, 42, 0, "Bong Da TV HD");
        menu.add(0, 43, 0, "The Thao TV HD");
        menu.add(0, 44, 0, "ANTV");
        menu.add(0, 45, 0, "HBO");
        menu.add(0, 46, 0, "Cinemax");
        menu.add(0, 47, 0, "Disney Channel");
        menu.add(0, 48, 0, "Cartoon Network");
        menu.add(0, 49, 0, "Star Movies");
        menu.add(0, 50, 0, "Star Movies HD");
        menu.add(0, 51, 0, "iTV");

        return result;
    }

    /* Handles item selections */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int next_idx = item.getItemId() - 1;
        String uri = channel_list.get(next_idx).getVideoUrl();
        Log.d(TAG, "Menu: Switch to channel " + uri + " with index is " + next_idx);
        Uri video = Uri.parse(uri);
        mVideoView.stopPlayback();
        mVideoView.setVideoURI(video);
        mVideoView.start();
        String channel_name = channel_list.get(next_idx).getTitle();
        Toast.makeText(getApplicationContext(),
                channel_name, Toast.LENGTH_LONG).show();
        pre_channel = channel_idx;
        channel_idx = next_idx;
//        switch (item.getItemId()) {
//            case 1:
//                //mVideoView.setAspectRatio(0);
//                break;
//            case 2:
//                //mVideoView.setAspectRatio(1);
//                break;
//            case 3:
//                //mVideoView.setAspectRatio(2);
//                break;
//            case 4:
//                //mVideoView.setAspectRatio(3);
//                break;
//
//            default:
//                break;
//        }

        return true;

    }
}
