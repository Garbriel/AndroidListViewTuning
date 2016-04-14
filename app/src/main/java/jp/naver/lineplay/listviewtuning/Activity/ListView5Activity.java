package jp.naver.lineplay.listviewtuning.Activity;

import android.os.Bundle;

import jp.naver.lineplay.listviewtuning.Adapter.Adapter5;
import jp.naver.lineplay.listviewtuning.R;

public class ListView5Activity extends ListViewBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Adapter5 adapter = new Adapter5(
                this, R.layout.listview_row,
                getList());
        listView.setAdapter(adapter);

    }

}
