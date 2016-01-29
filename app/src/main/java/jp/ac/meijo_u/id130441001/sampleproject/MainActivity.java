package jp.ac.meijo_u.id130441001.sampleproject;

        import android.support.v7.app.ActionBarActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.*;


public class MainActivity extends ActionBarActivity implements CountDownTask.CountDownTaskCallback {
    private EditText editInitialCount;
    private Button buttonStart;
    private Button buttonStop;
    private TextView textCount;
    private CountDownTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editInitialCount = (EditText)findViewById(R.id.editInitialCount);
        buttonStart = (Button)findViewById(R.id.buttonStart);
        buttonStop = (Button)findViewById(R.id.buttonStop);
        textCount = (TextView)findViewById(R.id.textCount);
    }

    public void handleButtonStart(View view) {
        int count = Integer.parseInt(editInitialCount.getText().toString());
        task = new CountDownTask(this);
        task.execute(count);

    }

    public void handleButtonStop(View view) {
        if (task != null)
            task.cancel(true);
    }

    @Override
    public void onPreExecute() {

    }

    @Override
    public void onProgressUpdate(String... values) {
        textCount.setText(values[0].toString());
    }

    @Override
    public void onPostExecute(String result) {
        textCount.setText(result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
