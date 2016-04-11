package jp.naver.lineplay.listviewtuning;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
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

public class DefaultAdapter4 extends ArrayAdapter<Data> {
    private static ArrayList<Data> items;
    private Context context;

    public DefaultAdapter4(Context context, int textViewResourceId, ArrayList<Data> items) {
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

            new DownloadImageTask(position, holder)
                    .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);

        }

        return convertView;
    }

    private static class ViewHolder {
        public int position;
        public TextView tv_Main;
        public TextView tv_Sub;
        public ImageView iv;
    }

    private static class DownloadImageTask<Bitmap> extends AsyncTask {
        private int mPosition;
        private ViewHolder mHolder;

        public DownloadImageTask(int position, ViewHolder holder) {
            mPosition = position;
            mHolder = holder;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            if (mHolder.position == mPosition)
                mHolder.iv.setImageBitmap((android.graphics.Bitmap) o);

        }

        @Override
        protected Bitmap doInBackground(Object[] params) {
            Bitmap bm = null;
            try {
                URL url = new URL(items.get(mPosition).url);
                URLConnection conn = url.openConnection();
                conn.connect();
                BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
                bm = (Bitmap) BitmapFactory.decodeStream(bis);
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bm;
        }

    }

}
