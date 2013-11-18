package com.flyingh.textswitcher;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity {
	private TextSwitcher textSwitcher;
	private String[] strs = { "a", "b", "c", "d", "e" };
	private int current;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textSwitcher = (TextSwitcher) findViewById(R.id.text_switcher);
		textSwitcher.setFactory(new ViewFactory() {

			@Override
			public View makeView() {
				TextView textView = new TextView(MainActivity.this);
				textView.setTextSize(80);
				textView.setTextColor(Color.BLUE);
				return textView;
			}
		});
	}

	public void next(View view) {
		textSwitcher.setText(strs[current++ % strs.length]);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
