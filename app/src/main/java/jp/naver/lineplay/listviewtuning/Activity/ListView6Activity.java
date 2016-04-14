package jp.naver.lineplay.listviewtuning.Activity;

import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import jp.naver.lineplay.listviewtuning.Adapter.Adapter6;
import jp.naver.lineplay.listviewtuning.R;

public class ListView6Activity extends ListViewBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Adapter6 adapter = new Adapter6(
                this, R.layout.listview_row,
                getList());
        final ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);

        list.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

                int first = list.getFirstVisiblePosition();
                int count = list.getChildCount();

                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE && lastitemVisibleFlag && !toastShowed) {
                    adapter.mIsScrolling = false;
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
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                lastitemVisibleFlag = (totalItemCount > 0) && (firstVisibleItem + visibleItemCount == totalItemCount);
                adapter.mIsScrolling = true;
            }
        });

    }

}
