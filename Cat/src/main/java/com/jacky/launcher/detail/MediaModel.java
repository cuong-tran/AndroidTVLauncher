package com.jacky.launcher.detail;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.jacky.launcher.R;

import java.util.ArrayList;
import java.util.List;

public class MediaModel implements Parcelable {

    public static final Creator<MediaModel> CREATOR = new Creator<MediaModel>() {
        @Override
        public MediaModel createFromParcel(Parcel in) {
            return new MediaModel(in);
        }

        @Override
        public MediaModel[] newArray(int size) {
            return new MediaModel[size];
        }
    };
    private int id;
    private String title;
    private String content;
    private String imageUrl;
    private String videoUrl;

    private MediaModel(
            final int id,
            final String title,
            final String content,
            final String imageUrl,
            final String videoUrl) {

        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.videoUrl = videoUrl;
    }

    protected MediaModel(Parcel in) {
        id = in.readInt();
        title = in.readString();
        content = in.readString();
        imageUrl = in.readString();
        videoUrl = in.readString();
    }

    public static List<MediaModel> getPhotoModels() {
        List<MediaModel> mediaModels = new ArrayList<>();

        String titles[] = {
                "Vịnh Vĩnh Hy",
                "Mũi Kê Gà",
                "Thác DRAYSAP - DRAYNUR",
                "Bình Ba - Đảo Tôm Hùm",
                "Bạc Liêu",
                "Nha Trang",
        };

        String contents[] = {
                "Những cảnh sắc đẹp đến ngỡ ngàng giữa biển trời như hòa làm một, Vĩnh Hy như một ốc đảo với những cung đường uốn lượn mềm mại như lụa bọc quanh biển xanh màu trời. Là một phần của Ninh Thuận - tỉnh thành với nhiều địa danh đẹp đến mê hồn mà vẫn giữ được nét đẹp hoang sơ của tạo hóa, vịnh Vĩnh Hy với khung cảnh đẹp như tranh và những nơi còn ít người lui tới, cảnh sắc vào từng shot hình trông hệt như cảnh “ngoài hành tinh”, mơ mơ thực thực, làm say lòng bao du khách tới vùng biển này.",
                "Mũi Kê Gà hay còn được gọi là Khe Gà thuộc huyện Hàm Thuận Nam, tỉnh Bình Thuận.\n" +
                        "Biển Kê Gà rất thu hút được hàng ngàn lượt khách du lịch mỗi năm bởi nét đẹp mơ màng trong sương sớm hay lặng lẽ trong chiều buông thả sức cho bạn có thể vùng vẫy với đại dương mênh mang.",
                "Thác Draynur và thác Draysap nằm gần thác Gia Long, cách Buôn Ma Thuột khoảng 30 km về phía Tây Nam. cả ba ngọn thác này đều nằm trên dòng sông Sêrêpôk, dòng hợp lưu của sông Krông Knô (sông Chồng) và sông Krông Ana (sông Vợ). \n" +
                        "Vì thác có độ cao lớn nên nước chảy ầm ào, mạnh mẽ tạo nên âm thanh đầy ấn tượng đối với du khách. Hơi và bụi nước tung ra, bay lên cùng với cảnh quan hoang sơ của rừng đại ngàn, tạo nên quang cảnh hùng vĩ và ngoạn mục nhưng cũng tạo ra những không gian trữ tình, thơ mộng.\n" +
                        "Thác Draynur nằm ngay cạnh Thác Draysap và chỉ cách thác Draysap một đoạn cầu treo bắt qua dòng sông Serepôk. Cả hai cùng là những thác nước đẹp và hùng vĩ, tuy nhiên bị ảnh hưởng bởi đập thủy điện gần đó nên bây giờ thác không còn nhiều nước như trước đây.",
                "Đảo Bình Ba chính là điểm đến đang cực kì hot. Người đi thì tán tụng không ngớt, còn người chưa đi thì háo hức học hỏi kinh nghiệm.\n" +
                        "Đảo Bình Ba thuộc xã Cam Bình, thành phố Cam Ranh, tỉnh Khánh Hòa. Nằm cách trung tâm thành phố Nha Trang 60km, Bình Ba còn được mệnh danh là đảo “ tôm hùm”, là địa điểm du lịch không nên bỏ lỡ trong hành trình khám phá viên ngọc Tứ Bình. Với khung cảnh hoang sơ, ánh nắng chan hòa, bãi cát trắng mịn… Nơi đây khiến bất cứ ai đặt chân đến đều có cảm giác thích thú.",
                "Bạc Liêu là một tỉnh thuộc duyên hải vùng đồng bằng sông Cửu Long, nằm trên bán đảo Cà Mau, miền đất cực Nam của Việt Nam. \n" +
                        "Bạc liêu có nhiều dân tộc khác nhau sinh sống như người Hoa, người Việt, người Khmer, người chăm... Người Bạc Liêu có phong cách phóng khoáng, đặc trưng của vùng Nam Bộ. Bạc Liêu có Công tử Bạc Liêu lừng danh một thuở giàu có và chịu chơi, ngoài ra vùng đất này còn gắn liền với tên tuổi của nhạc sĩ Cao Văn Lầu và bài Dạ cổ hoài lang đặt nền móng cho sự phát triển của nền cổ nhạc Nam Bộ.",
                "Nha Trang – hòn ngọc viễn Đông được mệnh danh là một trong những thành phố biển đẹp nhất Việt Nam quả không sai. Thành phố Nha Trang mê hoặc du khách với những bãi biển có dải cát trắng mịn trải dài, đến những hòn đảo ngoài khơi đẹp đến ngỡ ngàng như Bình Ba, Bình Hưng…\n" +
                        "Cũng như các thành phố biển khác, Nha Trang sở hữu rất nhiều bãi biển du lịch đẹp nên thơ như biển Đại Lãnh, bãi biển Sơn Đừng, bãi biển Dốc Lết, Bãi Trũ, Hòn Tằm, Bãi Dài (Vân Phong), Hòn Chồng… Bên cạnh đó, khu du lịch Vinpearl Land còn là một gợi ý khá lý tưởng dành cho các du khách yêu biển và thích các hoạt động vui chơi giải trí cảm giác mạnh.",
        };

        String urls[] = {
                "https://static.mytour.vn/upload_images/Image/Minh%20Hoang/Linh%201/18/7/vinh-vinh-hy-3.jpg",
                "http://blogdulich.com.vn/uploads/1-QUE-HUONG-VIET-NAM/mien-trung/ke-ga-phan-thiet/DSC3387-Edit.jpg",
                "http://wiki.youvivu.com/uploads/media/GZbdoYlVGztJyECfAvvUdgzU9tB9FLqo.jpg",
                "http://lendang.vn/uploads/articles/tour-tet-binh-ba-ivivu.com-2.jpg",
                "http://xomnhiepanh.com/uploads/location/2012/f6da89da899d2835994e7b0af455d504.jpg",
                "http://xomnhiepanh.com/uploads/location/2013/126400_1363581514.jpg",
        };

        for (int i = 0; i < titles.length; i++) {
            MediaModel mediaModel = new MediaModel(0, titles[i], contents[i], urls[i], "");
            mediaModels.add(mediaModel);
        }

        return mediaModels;
    }

    public static List<MediaModel> getVideoModels(Context context) {
        List<MediaModel> mediaModels = new ArrayList<>();

        String titles[] = {
                "Red Bull Art of Motion 2012 Santorini Parkour",
                "Sintel",
                "Big Buck Bunny",
        };

        String contents[] = {
                context.getString(R.string.video_parkour_content),
                context.getString(R.string.video_sintel_content),
                context.getString(R.string.video_content_bigbuckbunny),
        };

        String urls[] = {
                "http://i.ytimg.com/vi/BPd-qy7-0RM/maxresdefault.jpg",
                "http://i.ytimg.com/vi/unb-gGE_dhg/maxresdefault.jpg",
                "http://i.ytimg.com/vi/mtx-cLnu2VM/maxresdefault.jpg",
        };

        String videoUrls[] = {
                "http://bitdash-a.akamaihd.net/content/MI201109210084_1/m3u8s/f08e80da-bf1d-4e3d-8899-f0f6155f6efa.m3u8",
                "http://bitdash-a.akamaihd.net/content/sintel/hls/playlist.m3u8",
                "http://184.72.239.149/vod/smil:BigBuckBunny.smil/playlist.m3u8",
        };

        for (int i = 0; i < titles.length; i++) {
            MediaModel mediaModel = new MediaModel(
                    0, titles[i], contents[i], urls[i], videoUrls[i]);
            mediaModels.add(mediaModel);
        }

        return mediaModels;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(content);
        dest.writeString(imageUrl);
        dest.writeString(videoUrl);
    }
}
