package jp.naver.lineplay.listviewtuning;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class DefaultAdapter1 extends ArrayAdapter<Data> {
    private ArrayList<Data> items;
    private Context context;

    public DefaultAdapter1(Context context, int textViewResourceId, ArrayList<Data> items) {
        super(context, textViewResourceId, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = vi.inflate(R.layout.listview_row, null);

        final Data custom_list_data = items.get(position);

        if (custom_list_data != null) {

            TextView tv_Main = (TextView) v.findViewById(R.id.custom_list_title_main);
            TextView tv_Sub = (TextView) v.findViewById(R.id.custom_list_title_sub);
            final ImageView iv = (ImageView) v.findViewById(R.id.custom_list_image);

            tv_Main.setText(custom_list_data.Main_Title);
            tv_Sub.setText(custom_list_data.Sub_Title);
//            iv.setImageResource(custom_list_data.Image_ID);

            try {
                URL url = new URL(custom_list_data.url);
                URLConnection conn = url.openConnection();
                conn.connect();
                BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
                Bitmap bm = BitmapFactory.decodeStream(bis);
                bis.close();
                iv.setImageBitmap(bm);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return v;
    }
}
