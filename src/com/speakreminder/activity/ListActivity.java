package com.speakreminder.activity;

import com.speakreminder.R;

import android.app.Activity;
import android.os.Bundle;

public class ListActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_reminder);
	}
}
