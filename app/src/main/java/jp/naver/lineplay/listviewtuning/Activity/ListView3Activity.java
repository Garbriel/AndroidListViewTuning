package jp.naver.lineplay.listviewtuning.Activity;

import android.os.Bundle;

import jp.naver.lineplay.listviewtuning.Adapter.Adapter3;
import jp.naver.lineplay.listviewtuning.R;

public class ListView3Activity extends ListViewBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Adapter3 adapter = new Adapter3(
                this, R.layout.listview_row,
                getList());
        listView.setAdapter(adapter);

    }
}
