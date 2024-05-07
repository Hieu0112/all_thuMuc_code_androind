package com.example.session103;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MyTask extends AsyncTask<Void,Integer,Void> {
    private Activity activity;

    public MyTask(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(activity,"Bat dau tien trinh",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        for (int i = 0; i <= 100; i++) {
            SystemClock.sleep(200);
            publishProgress(i);
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... a) {
        super.onProgressUpdate(a);
        ProgressBar bar=activity.findViewById(R.id.progressBar);
        int num=a[0];
        bar.setProgress(num);
        TextView tv=activity.findViewById(R.id.tv);
        tv.setText(num+"%");
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        Toast.makeText(activity,"Tien trinh ket thuc",Toast.LENGTH_SHORT).show();
        Button bt =activity.findViewById(R.id.btStart);
        bt.setEnabled(true);
    }
}
