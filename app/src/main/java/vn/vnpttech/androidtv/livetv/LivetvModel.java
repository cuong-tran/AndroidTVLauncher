package vn.vnpttech.androidtv.livetv;

/**
 * Created by cuongtm on 26/11/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.List;

import vn.vnpttech.androidtv.R;

public class LivetvModel {
    private int id;
    private String title;
    private String content;
    private Bitmap image;
    private String videoUrl;
    private Intent intent;

    private LivetvModel(
            final int id,
            final Bitmap image,
            final String videoUrl,
            final String title,
            final String content) {

        this.title = title;
        this.content = content;
        this.image = image;
        this.videoUrl = videoUrl;
    }

    public static List<LivetvModel> getLivetvModels(Context context) {
        List<LivetvModel> livetvModels = new ArrayList<>();

//        Bitmap homeIcon = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_home);
        Bitmap userIcon = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_personal);
        Bitmap angiang = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_angiang);
        Bitmap antv = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_antv);
        Bitmap arirang = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_arirang);
        Bitmap australia = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_australia);
        Bitmap bacninhtv = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_bacninhtv);
        Bitmap bloomberg = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_bloomberg);
        Bitmap btv1 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_btv1);
        Bitmap btv2 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_btv2);
        Bitmap cantho = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_cantho);
        Bitmap channelasia = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_channelasia);
        Bitmap daklak = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_daklak);
        Bitmap dongnai1 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_dongnai1);
        Bitmap dongthap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_dongthap);
        Bitmap drt2 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_drt2);
        Bitmap dw = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_dw);
        Bitmap haiphong = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_haiphong);
        Bitmap hanam = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_hanam);
        Bitmap hanoi1 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_hanoi1);
        Bitmap hanoi2 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_hanoi2);
        Bitmap hcatv = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_hcatv);
        Bitmap hcatv2 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_hcatv2);
        Bitmap hitv = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_hitv);
        Bitmap htvfilm = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_htvphim);
        Bitmap htv1 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_htv1);
        Bitmap htv2 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_htv2);
        Bitmap htv3 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_htv3);
        Bitmap htv4 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_htv4);
        Bitmap htv7 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_htv7);
        Bitmap htv9 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_htv9);
        Bitmap htvcanhac = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_htvcanhac);
        Bitmap htvcshopping = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_htvcshopping);
        Bitmap htvcthethao = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_htvcthethao);
        Bitmap htvdulichcuocsong = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_htvdulichcuocsong);
        Bitmap htvgiadinh = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_htvgiadinh);
        Bitmap htvphim = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_htvphim);
        Bitmap htvphunu = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_htvphunu);
        Bitmap hue = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_hue);
        Bitmap itv = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_itv);
        Bitmap kg = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_kg);
        Bitmap khanhhoa = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_khanhhoa);
        Bitmap laocai = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_laocai);
        Bitmap longan = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_longan);
        Bitmap mtv = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_mtv);
        Bitmap ngheantv = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_ngheantv);
        Bitmap nhk = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_nhk);
        Bitmap o2tv = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_o2tv);
        Bitmap quangbinh = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_quangbinh);
        Bitmap quangninh1 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_quangninh1);
        Bitmap quangtri = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_quangtri);
        Bitmap quocphong = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_quocphong);
        Bitmap soctrang = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_soctrang);
        Bitmap tayninh = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_tayninh);
        Bitmap thaibinh = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_thaibinh);
        Bitmap thainguyen = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_thanhhoa);
        Bitmap thanhhoa = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_thanhhoa);
        Bitmap thuanviet = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_thuanviet);
        Bitmap tiengiang = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_tiengiang);
        Bitmap today = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_today);
        Bitmap ttxvn = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_ttxvn);
        Bitmap tv5 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_tv5);
        Bitmap vinhlong1 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_vinhlong1);
        Bitmap vinhlong2 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_vinhlong2);
        Bitmap vovtv = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_vovtv);
        Bitmap vp = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_vp);
        Bitmap vtc1 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_vtc1);
        Bitmap vtc2 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_vtc2);
        Bitmap vtc3 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_vtc3);
        //Bitmap vtc4 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_vtc4);
        //Bitmap vtc5 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_vtc5);
        Bitmap vtc6 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_vtc6);
        Bitmap vtc7 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_today);
        Bitmap vtc8 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_vtc8);
        Bitmap vtc9 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_vtc9);
        Bitmap vtc10 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_vtc10);
        Bitmap vtc11 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_vtc11);
        Bitmap vtc12 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_vtc12);
        Bitmap vtc13 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_itv);
        Bitmap vtc14 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_vtc14);
        Bitmap vtc16 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_vtc16);
        Bitmap vtv1 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_vtv1);
        Bitmap vtv1hd = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_vtv1hd);
        Bitmap vtv2 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_vtv2);
        Bitmap vtv3 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_vtv3);
        Bitmap vtv3hd = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_vtv3hd);
        Bitmap vtv4 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_vtv4);
        Bitmap vtv5 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_vtv5);
        Bitmap vtv6 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_vtv6);
        Bitmap vtv6hd = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_vtv6hd);
        Bitmap vtvdanang = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_vtvdanang);
        Bitmap vtvhue = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_vtvhue);
        Bitmap vtvphuyen = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_vtvphuyen);
        Bitmap hbo = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_hbo);
        Bitmap hbohd = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_hbohd);
        Bitmap axn = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_axn);
        Bitmap axnhd = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_axnhd);
        Bitmap mtvhd = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_mtvhd);
        Bitmap starmovies = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_starmovies);
        Bitmap starmovieshd = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_starmovieshd);
        Bitmap startworldhd = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_startworldhd);
        Bitmap starworld = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_starworld);
        Bitmap discoveryhd = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_discoveryhd);
        Bitmap disneyhd = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_disneyhd);
        Bitmap nhkhd = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_nhkhd);
        Bitmap k_1 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_k1);
        Bitmap k_1_hd = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_k1hd);
        Bitmap k_ns = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_kns);
        Bitmap k_ns_hd = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_knshd);
        Bitmap k_pm = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_kpm);
        Bitmap k_pm_hd = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_kpmhd);
        Bitmap k_pc = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_kpc);
        Bitmap k_pc_hd = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_kpchd);
        Bitmap bongdatv = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_bongdatv);
        Bitmap thethaotv = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_thethaotv);
        Bitmap bongdatvhd = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_bongdatvhd);
        Bitmap thethaotvhd = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_thethaotvhd);
        Bitmap cinemax = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_cinemax);
        Bitmap disney = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_disney);
        Bitmap cartoon = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_cartoon);
//        Bitmap vov1 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_vov1);
//        Bitmap vov2 = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_vov2);
//        Bitmap vovgthn = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_vovgthn);
        Bitmap quoc_hoi = BitmapFactory.decodeResource(context.getResources(), R.mipmap.channel_quoc_hoi);
//VTV
        livetvModels.add(new LivetvModel(0, vtv1, "rtp://232.84.1.27:8136", "VTV1", ""));
        livetvModels.add(new LivetvModel(0, vtv2, "rtp://232.84.1.39:8208", "VTV2", ""));
        livetvModels.add(new LivetvModel(0, vtv3, "rtp://232.84.1.28:8142", "VTV3", ""));
        livetvModels.add(new LivetvModel(0, vtv4, "rtp://232.84.1.40:8214", "VTV4", ""));
        livetvModels.add(new LivetvModel(0, vtv5, "rtp://232.84.1.41:8220", "VTV5", ""));
        livetvModels.add(new LivetvModel(0, vtv6, "rtp://232.84.1.42:8226", "VTV6", ""));
        livetvModels.add(new LivetvModel(0, userIcon, "rtp://232.84.1.148:8862", "VTV8", ""));
        livetvModels.add(new LivetvModel(0, vtv1hd, "rtp://232.84.1.117:10254", "VTV1 HD", ""));
        livetvModels.add(new LivetvModel(0, vtv3hd, "rtp://232.84.1.118:10260", "VTV3 HD", ""));
        livetvModels.add(new LivetvModel(0, vtv6hd, "rtp://232.84.1.119:10266", "VTV6 HD", ""));
        livetvModels.add(new LivetvModel(0, quoc_hoi, "rtp://232.84.1.234:10290", "Quoc Hoi", ""));
//HTV
        livetvModels.add(new LivetvModel(0, htvfilm, "rtp://232.84.1.105:8604", "HTV Phim", ""));
        livetvModels.add(new LivetvModel(0, htv1, "rtp://232.84.1.35:8184", "HTV1", ""));
        livetvModels.add(new LivetvModel(0, htv2, "rtp://232.84.1.36:8190", "HTV2", ""));
        livetvModels.add(new LivetvModel(0, htv7, "rtp://232.84.1.21:8100", "HTV7", ""));
        livetvModels.add(new LivetvModel(0, htv9, "rtp://232.84.1.31:8160", "HTV9", ""));
        livetvModels.add(new LivetvModel(0, htv4, "rtp://232.84.1.25:8124", "HTV4", ""));
        livetvModels.add(new LivetvModel(0, htvcthethao, "rtp://232.84.1.24:8118", "HTVC TheThao", ""));
        livetvModels.add(new LivetvModel(0, thuanviet, "rtp://232.84.1.22:8106", "HTVC ThuanViet", ""));
//VTC
        livetvModels.add(new LivetvModel(0, vtc7, "rtp://232.84.1.213:9252", "VTC7", ""));
        livetvModels.add(new LivetvModel(0, vtc10, "rtp://232.84.1.214:9258", "VTC10", ""));
        livetvModels.add(new LivetvModel(0, vtc1, "rtp://232.84.1.30:8154", "VTC1", ""));
        livetvModels.add(new LivetvModel(0, vtc2, "rtp://232.84.1.57:8322", "VTC2", ""));
        livetvModels.add(new LivetvModel(0, vtc3, "rtp://232.84.1.60:8232", "VTC3", ""));
        livetvModels.add(new LivetvModel(0, vtc6, "rtp://232.84.1.58:8328", "VTC6", ""));
        livetvModels.add(new LivetvModel(0, vtc8, "rtp://232.84.1.32:8166", "VTC8", ""));
        livetvModels.add(new LivetvModel(0, vtc9, "rtp://232.84.1.59:8334", "VTC9", ""));
        livetvModels.add(new LivetvModel(0, vtc11, "rtp://232.84.1.61:8340", "VTC11", ""));
        livetvModels.add(new LivetvModel(0, vtc13, "rtp://232.84.1.62:8346", "VTC13", ""));
        livetvModels.add(new LivetvModel(0, vtc16, "rtp://232.84.1.215:9264", "VTC16", ""));
        livetvModels.add(new LivetvModel(0, vtc14, "rtp://232.84.1.216:9270", "VTC14", ""));

//K+
        livetvModels.add(new LivetvModel(0, k_1, "rtp://232.84.1.96:8550", "K+1", ""));
        livetvModels.add(new LivetvModel(0, k_ns, "rtp://232.84.1.97:8556", "K+NS", ""));
        livetvModels.add(new LivetvModel(0, k_pm, "rtp://232.84.1.98:8562", "K+PM", ""));
        livetvModels.add(new LivetvModel(0, k_pc, "rtp://232.84.1.131:10368", "K+PC", ""));

        livetvModels.add(new LivetvModel(0, k_1_hd, "rtp://232.84.1.122:10314", "K+1 HD", ""));
        livetvModels.add(new LivetvModel(0, k_ns_hd, "rtp://232.84.1.123:10320", "K+NS HD", ""));
        livetvModels.add(new LivetvModel(0, k_pm_hd, "rtp://232.84.1.125:10326", "K+PM HD", ""));
        livetvModels.add(new LivetvModel(0, k_pc_hd, "rtp://232.84.1.176:10374", "K+PC HD", ""));
//VTV cable
        livetvModels.add(new LivetvModel(0, bongdatv, "rtp://232.84.1.138:8802", "Bong Da TV", ""));
        livetvModels.add(new LivetvModel(0, thethaotv, "rtp://232.84.1.208:9222", "The Thao TV", ""));
        livetvModels.add(new LivetvModel(0, bongdatvhd, "rtp://232.84.1.210:9234", "Bong Da TV HD", ""));
        livetvModels.add(new LivetvModel(0, thethaotvhd, "rtp://232.84.1.207:9216", "The Thao TV HD", ""));
//Others
        livetvModels.add(new LivetvModel(0, antv, "rtp://232.84.1.212:9246", "An Ninh TV", ""));
        livetvModels.add(new LivetvModel(0, hbo, "rtp://232.84.1.19:8088", "HBO", ""));
        livetvModels.add(new LivetvModel(0, cinemax, "rtp://232.84.1.20:8094", "Cinemax", ""));
        livetvModels.add(new LivetvModel(0, disney, "rtp://232.84.1.18:8082", "Disney Channel", ""));
        livetvModels.add(new LivetvModel(0, cartoon, "rtp://232.84.1.16:8070", "Cartoon Network", ""));
        livetvModels.add(new LivetvModel(0, starmovies, "rtp://232.84.1.10:8034", "Star Movies", ""));
        livetvModels.add(new LivetvModel(0, starmovieshd, "rtp://232.84.1.77:8436", "Star Movies HD", ""));
        livetvModels.add(new LivetvModel(0, itv, "rtp://232.84.1.62:8346", "iTV", ""));
        /*livetvModels.add(new LivetvModel(0, vov1,"http://IP_SRV/radio.m3u8%3Fc%3D001","VOV 1"                                , ""));
        livetvModels.add(new LivetvModel(0, vov2,"http://IP_SRV/radio.m3u8%3Fc%3D002","VOV 2"                                , ""));
        livetvModels.add(new LivetvModel(0, vovgthn,"http://IP_SRV/radio.m3u8%3Fc%3D015","VOV GT HN"                                , ""));*/
//        livetvModels.add(new LivetvModel(0, userIcon,"rtp://232.84.1.242:9426","Mosaic 1"                                , ""));
//        livetvModels.add(new LivetvModel(0, userIcon,"http://techslides.com/demos/sample-videos/small.webm","Webm"                                , ""));
////        livetvModels.add(new LivetvModel(0, userIcon,"http://172.16.3.254/drmv.m3u8?file=/video/test/drm2-diepvan2-movies-mytv.mp4&q=480&deviceType=&userId=&deviceId=&type=&zn=flx&rkey=UlRCgm1eaKIyclEp&grantor=1&start=0&token=&location=&rp=172.16.3.250,172.16.3.254", "DRM VOD", ""));
////        livetvModels.add(new LivetvModel(0, userIcon,"http://172.16.29.135/v4movie.m3u8?file=/video//c8/86/60/06/65/55/c8606-rungchuyen-movies-mytv.mp4&q=720&deviceType=9&userId=25477&deviceId=&zn=flx&rkey=D7IlO8xWN4Lg45z8&grantor=1&start=0&token=&location=HNI&rp=172.16.29.81,172.16.10.43,172.16.10.42,172.16.10.41,172.16.3.250,172.16.3.254","HTTP", ""));
//        livetvModels.add(new LivetvModel(0, userIcon,"http://cmghlslive-i.akamaihd.net:80/hls/live/224709/KOKI/master.m3u8", "Fox23 News", ""));
//        livetvModels.add(new LivetvModel(0, userIcon,"http://mediauseast.akamaized.net/us/us3_live.m3u8", "Bloomberg US HD ", ""));
//        livetvModels.add(new LivetvModel(0, userIcon, "http://123.29.70.3/test-qpvn.m3u8?q=high", "HLS High", ""));
//        livetvModels.add(new LivetvModel(0, userIcon, "http://123.29.70.3/test-qpvn.m3u8?q=auto", "HLS Auto", ""));
//        livetvModels.add(new LivetvModel(0, userIcon, "http://10.2.14.126/mytvnet/video_oom/test-qpvn.m3u8", "QPVN Drive", ""));

        return livetvModels;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Intent getIntent() {
        return intent;
    }

    /*
    private String dataDir;
    private Drawable icon;
    private String id;
    private String name;
    private String launcherName;
    private String packageName;
    private int pageIndex;
    private int position;
    private boolean sysApp;

    public String getDataDir() {
        return this.dataDir;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    public int getPosition() {
        return this.position;
    }

    public void setDataDir(String paramString) {
        this.dataDir = paramString;
    }

    public void setIcon(Drawable paramDrawable) {
        this.icon = paramDrawable;
    }

    public void setId(String paramString) {
        this.id = paramString;
    }

    public void setName(String paramString) {
        this.name = paramString;
    }

    public void setPackageName(String paramString) {
        this.packageName = paramString;
    }

    public void setPageIndex(int paramInt) {
        this.pageIndex = paramInt;
    }

    public void setPosition(int paramInt) {
        this.position = paramInt;
    }

    public String toString() {
        return "AppBean [packageName=" + this.packageName + ", name=" + this.name + ", dataDir=" + this.dataDir + "]";
    }

    public boolean isSysApp() {
        return sysApp;
    }

    public void setSysApp(boolean sysApp) {
        this.sysApp = sysApp;
    }

    public String getLauncherName() {
        return launcherName;
    }

    public void setLauncherName(String launcherName) {
        this.launcherName = launcherName;
    }
*/
}
