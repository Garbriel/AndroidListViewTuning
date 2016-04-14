package jp.naver.lineplay.listviewtuning.Activity;

import android.os.Bundle;

import jp.naver.lineplay.listviewtuning.Adapter.Adapter1;
import jp.naver.lineplay.listviewtuning.R;

public class ListView1Activity extends ListViewBaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Adapter1 adapter = new Adapter1(
                this, R.layout.listview_row,
                getList());
        listView.setAdapter(adapter);

    }

}
