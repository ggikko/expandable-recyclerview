package ggikko.me.expandablerecyclerviewexample.apapter;

/**
 * Created by admin on 16. 4. 12..
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import ggikko.me.expandablerecyclerviewexample.R;

/**
 * 원하는 지하철 역을 설정하고 이에 관련 데이터를 받는 화면
 */
public class SubwayActivty extends AppCompatActivity {

    private RecyclerView recyclerView;
    private String subway;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subway_actiity);

        Intent intent = getIntent();
        subway = intent.getStringExtra("subway");

        /** 기본 툴바 설정 및 Actionbar 셋팅 */
        Toolbar toolbar = (Toolbar) findViewById(R.id.subway_toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setHomeButtonEnabled(true);
        ab.setDisplayHomeAsUpEnabled(true);

        /** recyclerView 설정 */
        recyclerView = (RecyclerView) findViewById(R.id.subway_recyclerview);
        RecyclerviewAdapter adapter = new RecyclerviewAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    /**
     * 옵션 메뉴 아이템이 선택되었을 때 설정할 수 있는 함수이다.
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                backToActivity();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void backToActivity() {
        Intent intent = new Intent();
        intent.putExtra("subway", subway);
        setResult(0 , intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        backToActivity();
    }
}