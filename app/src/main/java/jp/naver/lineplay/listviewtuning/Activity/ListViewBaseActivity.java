package jp.naver.lineplay.listviewtuning.Activity;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;

import jp.naver.lineplay.listviewtuning.Data.Data;
import jp.naver.lineplay.listviewtuning.R;

public class ListViewBaseActivity extends AppCompatActivity {
    final int testCnt = 200;
    ListView listView;
    long startTime;
    long finishTime;
    boolean lastitemVisibleFlag = false;
    boolean toastShowed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.ThreadPolicy.Builder builder = new StrictMode.ThreadPolicy.Builder();
        builder.detectNetwork();
        builder.penaltyLog();
        StrictMode.setThreadPolicy(builder.build());

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);

        setContentView(R.layout.activity_default_list_view);
        listView = (ListView) findViewById(R.id.listView);

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                int first = listView.getFirstVisiblePosition();
                int count = listView.getChildCount();

                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE && lastitemVisibleFlag && !toastShowed) {
                    lastitemVisibleFlag = false;
                    finishTime = System.currentTimeMillis();
                    StringBuilder result = new StringBuilder();
                    result.append("스크롤 시간:");
                    result.append((float) (finishTime - startTime) / 1000);
                    result.append("\n");
                    result.append("출력 개수:");
                    result.append(first + count);
                    result.append("\n");
                    result.append("초당 출력 View의 수:");
                    result.append((float) (first + count) / (float) (finishTime - startTime) * 1000);
                    Toast.makeText(getBaseContext(), result, Toast.LENGTH_SHORT).show();
                    toastShowed = true;
                }

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                lastitemVisibleFlag = (totalItemCount > 0) && (firstVisibleItem + visibleItemCount == totalItemCount);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        listView.postDelayed(new Runnable() {
            @Override
            public void run() {
                startTime = System.currentTimeMillis();
                toastShowed = false;
                listView.smoothScrollToPosition(testCnt);
            }
        }, 100);
    }

    public ArrayList<Data> getList() {

        ArrayList<Data> listData = new ArrayList<Data>();

        for (int i = 0; i < testCnt; i++) {
            Data item = new Data();
            if (i % 5 == 0) {
                item.Main_Title = "브라운";
                item.url = "http://store.linefriends.com/wp-content/uploads/2015/06/0120.jpg";
                item.Sub_Title = "010-0000-1111";
            } else if (i % 5 == 1) {
                item.Main_Title = "코니";
                item.url = "http://store.linefriends.com/wp-content/uploads/2015/06/0121.jpg";
                item.Sub_Title = "010-2222-3333";
            } else if (i % 5 == 2) {
                item.Main_Title = "셀리";
                item.url = "http://store.linefriends.com/wp-content/uploads/2015/06/0127.jpg";
                item.Sub_Title = "010-4444-5555";
            } else if (i % 5 == 3) {
                item.Main_Title = "문";
                item.url = "http://store.linefriends.com/wp-content/uploads/2015/06/0126.jpg";
                item.Sub_Title = "010-6666-7777";
            } else if (i % 5 == 4) {
                item.Main_Title = "제임스";
                item.url = "http://store.linefriends.com/wp-content/uploads/2015/06/0123.jpg";
                item.Sub_Title = "010-8888-9999";
            }
            listData.add(item);
        }
        return listData;
    }

}
