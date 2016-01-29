package jp.ac.meijo_u.id130441001.sampleproject;


import android.os.AsyncTask;
/**
 * Created by akapo on 2016/01/29.
 */
public class CountDownTask extends AsyncTask<Integer, String, String>{
    private CountDownTaskCallback mCallback;

    public CountDownTask(CountDownTaskCallback callback) {
        this.mCallback = callback;
    }

    @Override
    protected void onPreExecute() {
        if (mCallback != null)
            mCallback.onPreExecute();
    }

    @Override
    protected String doInBackground(Integer... params) {
        for (int i = params[0].intValue(); i >= 0; i--) {
            publishProgress(String.valueOf(i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Done!";
    }

    @Override
    protected void onProgressUpdate(String... values) {
        if (mCallback != null)
            mCallback.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        if (mCallback != null)
            mCallback.onPostExecute(result);
    }

    public interface CountDownTaskCallback {
        void onPreExecute();
        void onProgressUpdate(String... values);
        void onPostExecute(String result);
    }

}
