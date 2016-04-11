package jp.naver.lineplay.listviewtuning;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

public class DefaultAdapter5 extends ArrayAdapter<Data> {
    private static ArrayList<Data> items;
    private Context context;

    public DefaultAdapter5(Context context, int textViewResourceId, ArrayList<Data> items) {
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

        holder.position = position;

        final Data custom_list_data = items.get(position);

        if (custom_list_data != null) {

            holder.tv_Main.setText(custom_list_data.Main_Title);
            holder.tv_Sub.setText(custom_list_data.Sub_Title);

            ImageLoader.getInstance().displayImage(custom_list_data.url, holder.iv);

        }

        return convertView;
    }

    private static class ViewHolder {
        public int position;
        public TextView tv_Main;
        public TextView tv_Sub;
        public ImageView iv;
    }

}
