package jp.naver.lineplay.listviewtuning.Activity;

import android.os.Bundle;

import jp.naver.lineplay.listviewtuning.Adapter.Adapter4;
import jp.naver.lineplay.listviewtuning.R;

public class ListView4Activity extends ListViewBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Adapter4 adapter = new Adapter4(
                this, R.layout.listview_row,
                getList());
        listView.setAdapter(adapter);

    }

}
