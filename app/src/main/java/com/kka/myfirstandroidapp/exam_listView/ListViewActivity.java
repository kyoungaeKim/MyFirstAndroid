package com.kka.myfirstandroidapp.exam_listView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.kka.myfirstandroidapp.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemSelectedListener {

    private ListView mListView;
    private List<String> mdata;
    private ArrayAdapter<String> mAdapter;
    private GridView mGridView;
    private Spinner mSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        //view
        mListView = (ListView) findViewById(R.id.list);
        mGridView = (GridView) findViewById(R.id.grid);
        mSpinner = (Spinner) findViewById(R.id.spinner);
        //data

        mdata = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mdata.add("data" + i);

        }
            //Adapter
        mAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                mdata);


        mListView.setAdapter(mAdapter);
        mGridView.setAdapter(mAdapter);
        mSpinner.setAdapter(mAdapter);

        //클릭 이벤트
        mListView.setOnItemClickListener(this);

        //롱 클릭 이벤트
        mListView.setOnItemLongClickListener(this);

        mSpinner.setOnItemSelectedListener(this);

    }//어댑터뷰는 리스트 뷰다

    @Override
    public void onItemClick(AdapterView<?> parent, View view/*한칸에대한 뷰*/, int position/*누른위치*/, long id) {
        Toast.makeText(ListViewActivity.this, "position:"+position, Toast.LENGTH_SHORT).show();
    }

    @Override // 여기서 작업 하고 싶으면 true로 끝낸다.
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        mdata.remove(position);

        //화면 갱신 어댑터에게 데이터 변경을 알려준다 > 리스트에 새로운 내용 반영
        mAdapter.notifyDataSetChanged();

        Toast.makeText(ListViewActivity.this, "롱클릭", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mdata.remove(position);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
