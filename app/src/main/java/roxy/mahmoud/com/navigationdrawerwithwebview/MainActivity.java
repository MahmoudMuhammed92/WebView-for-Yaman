package roxy.mahmoud.com.navigationdrawerwithwebview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize WebView Object
        final WebView browser = (WebView) findViewById(R.id.webview);

        // Create a client for WebView in order to open the page inside the app not from Intent
        browser.setWebViewClient(new WebViewClient());
        //Enable JavaScript this is important for your project Yaman I guess you have JavaScript.
        browser.getSettings().setJavaScriptEnabled(true);
        dl = (DrawerLayout) findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);
        dl.addDrawerListener(t);
        t.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nv = (NavigationView) findViewById(R.id.nv);


        //On navigation items clicked switch case
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.nav_menu_top:
                        //Toast.makeText(MainActivity.this, "My Account", Toast.LENGTH_SHORT).show();
                        browser.loadUrl("https://www.attrack.cf");
                        dl.closeDrawer(Gravity.START, true);
                    case R.id.nav_profile:
                        browser.loadUrl("https://www.attrack.cf/myProfile");
                        dl.closeDrawer(Gravity.START, true);
                    case R.id.nav_program:
                        browser.loadUrl("https://www.attrack.cf/course_sessions/view");
                        dl.closeDrawer(Gravity.START, true);
                    case R.id.nav_lessons:
                        browser.loadUrl("https://www.attrack.cf/lessons/view");
                        dl.closeDrawer(Gravity.START, true);
                    case R.id.drawer_view_records:
                        browser.loadUrl("https://www.attrack.cf/clever/lastAttRecords");
                        dl.closeDrawer(Gravity.START, true);
                    case R.id.drawer_search:
                        browser.loadUrl("https://www.attrack.cf/students/view");
                        dl.closeDrawer(Gravity.START, true);
                    case R.id.drawer_logout:
                        browser.loadUrl("https://www.attrack.cf/logout");
                        dl.closeDrawer(Gravity.START, true);
                    default:
                        return true;
                }


            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return t.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);

    }

}
