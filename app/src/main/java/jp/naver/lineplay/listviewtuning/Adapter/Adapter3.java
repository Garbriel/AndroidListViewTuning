package jp.naver.lineplay.listviewtuning.Adapter;

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

import jp.naver.lineplay.listviewtuning.Data.Data;
import jp.naver.lineplay.listviewtuning.R;

public class Adapter3 extends ArrayAdapter<Data> {
    private ArrayList<Data> items;
    private Context context;

    public Adapter3(Context context, int textViewResourceId, ArrayList<Data> items) {
        super(context, textViewResourceId, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.listview_row, null);

            holder = new ViewHolder();
            holder.tv_Main = (TextView) convertView.findViewById(R.id.custom_list_title_main);
            holder.tv_Sub = (TextView) convertView.findViewById(R.id.custom_list_title_sub);
            holder.iv = (ImageView) convertView.findViewById(R.id.custom_list_image);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final Data custom_list_data = items.get(position);

        if (custom_list_data != null) {

            holder.tv_Main.setText(custom_list_data.Main_Title);
            holder.tv_Sub.setText(custom_list_data.Sub_Title);

            try {
                URL url = new URL(custom_list_data.url);
                URLConnection conn = url.openConnection();
                conn.connect();
                BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
                Bitmap bm = BitmapFactory.decodeStream(bis);
                bis.close();
                holder.iv.setImageBitmap(bm);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return convertView;
    }

    private static class ViewHolder {
        public TextView tv_Main;
        public TextView tv_Sub;
        public ImageView iv;
    }

}
