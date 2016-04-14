package jp.naver.lineplay.listviewtuning.Activity;

import android.os.Bundle;

import jp.naver.lineplay.listviewtuning.Adapter.Adapter2;
import jp.naver.lineplay.listviewtuning.R;

public class ListView2Activity extends ListViewBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Adapter2 adapter = new Adapter2(
                this, R.layout.listview_row,
                getList());
        listView.setAdapter(adapter);

    }
}
