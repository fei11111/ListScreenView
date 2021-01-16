package com.fei.listscreenview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String[] titles = new String[]{"文化", "体育", "视频", "游戏"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListScreenView listScreenView = findViewById(R.id.list_screen_view);
        listScreenView.setAdapter(new ListScreenAdapter());

    }

    public void tvClick(View view) {
        Toast.makeText(this, "点击底部", Toast.LENGTH_SHORT).show();
    }

    private class ListScreenAdapter extends BaseScreenAdapter {

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public View getTabView(int position, ViewGroup parent) {
            TextView textView = (TextView) LayoutInflater.from(MainActivity.this).inflate(R.layout.item_tab, parent, false);
            textView.setText(titles[position]);
            return textView;
        }

        @Override
        public View getMenuView(int position, ViewGroup parent) {
            TextView textView = (TextView) LayoutInflater.from(MainActivity.this).inflate(R.layout.item_tab, parent, false);
            textView.setText(titles[position]);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "吐司", Toast.LENGTH_SHORT).show();
                }
            });
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    notifyCloseMenu();
                }
            });
            return textView;
        }

        @Override
        public void openMenu(View previousTabView, View currentTabView, int currentPosition) {
            super.openMenu(previousTabView, currentTabView, currentPosition);
            if (previousTabView != null) {
                previousTabView.setSelected(false);
            }
            currentTabView.setSelected(true);
        }

        @Override
        public void closeMenu(View tabView, int currentPosition) {
            super.closeMenu(tabView, currentPosition);
            tabView.setSelected(false);
        }
    }
}