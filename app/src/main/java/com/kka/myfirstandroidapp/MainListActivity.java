package com.kka.myfirstandroidapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.kka.myfirstandroidapp.baseAdapter_prac.BaseAdapter_pracActivity;
import com.kka.myfirstandroidapp.exam.Main2Activity;
import com.kka.myfirstandroidapp.exam_fab_dialog.FabAndDialogActivity;
import com.kka.myfirstandroidapp.exam_fragment.FragmentExamActivity;
import com.kka.myfirstandroidapp.exam_lifeCycle.LifeCycleActivity;
import com.kka.myfirstandroidapp.exam_listView.ListViewActivity;
import com.kka.myfirstandroidapp.exam_webView.WebViewActivity;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 예제의 첫 화면
 */
public class MainListActivity extends ListActivity {

    private final static Comparator<Map<String, Object>> sDisplayNameComparator =
            new Comparator<Map<String, Object>>() {
                private final Collator collator = Collator.getInstance();

                public int compare(Map<String, Object> map1, Map<String, Object> map2) {
                    return collator.compare(map1.get("title"), map2.get("title"));
                }
            };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new SimpleAdapter(this, getData(),
                android.R.layout.simple_list_item_1, new String[] {
                "title"
        },
                new int[] {
                        android.R.id.text1
                }));
        getListView().setTextFilterEnabled(true);
    }

    protected List<Map<String, Object>> getData() {
        List<Map<String, Object>> myData = new ArrayList<>();

        // 메뉴 추가 부분
        addItem(myData, "버튼 이벤트", MainActivity.class);
        addItem(myData, "ScrollView", ScrollActivity.class);
        addItem(myData, "암시적 인텐트", IntentActivity.class);
        addItem(myData, "커피주문", Main2Activity.class);
        addItem(myData, "webView 예제", WebViewActivity.class);
        addItem(myData, "listView 예제", ListViewActivity.class);
        addItem(myData, "생명주기 연습", LifeCycleActivity.class);
        addItem(myData, "플로팅 다이얼로그 연습", FabAndDialogActivity.class);
        addItem(myData, "베이스어댑터 연습", BaseAdapter_pracActivity.class);
        addItem(myData, "fragment", FragmentExamActivity.class);


        // ----- 메뉴 추가 여기까지

        // 이름 순 정렬
        // Collections.sort(myData, sDisplayNameComparator);

        return myData;
    }

    protected void addItem(List<Map<String, Object>> data, String name, Intent intent) {
        Map<String, Object> temp = new HashMap<>();
        temp.put("title", name);
        temp.put("intent", intent);
        data.add(temp);
    }

    protected void addItem(List<Map<String, Object>> data, String name, Class cls) {
        this.addItem(data, name, new Intent(this, cls));
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Map<String, Object> map = (Map<String, Object>) l.getItemAtPosition(position);

        Intent intent = (Intent) map.get("intent");
        startActivity(intent);
    }
}
