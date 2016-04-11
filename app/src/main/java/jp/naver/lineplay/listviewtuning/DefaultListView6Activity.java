package jp.naver.lineplay.listviewtuning;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.AbsListView;
import android.widget.ListView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;

public class DefaultListView6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.ThreadPolicy.Builder builder = new StrictMode.ThreadPolicy.Builder();
        builder.detectNetwork();
        builder.penaltyLog();
        StrictMode.setThreadPolicy(builder.build());

        setContentView(R.layout.activity_default_list_view);

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);

        final DefaultAdapter6 adapter = new DefaultAdapter6(
                this, R.layout.listview_row,
                getList());
        final ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);

        list.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                adapter.mIsScrolling = (scrollState != SCROLL_STATE_IDLE);

                int first = list.getFirstVisiblePosition();
                int count = list.getChildCount();

                if (scrollState == SCROLL_STATE_IDLE
                        || (first + count > adapter.getCount())) {
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

        list.smoothScrollToPosition(adapter.getCount());
    }


    public ArrayList<Data> getList() {

        ArrayList<Data> list = new ArrayList<Data>();

        for (int i = 0; i < 100; i++) {
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
            list.add(item);
        }
        return list;
    }

}
