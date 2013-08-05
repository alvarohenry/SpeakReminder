package com.speakreminder.activity;

import com.speakreminder.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		// set up click listeners for all the buttons
		View newReminder = findViewById(R.id.create_new_reminder);
		newReminder.setOnClickListener(this);
		View listReminders = findViewById(R.id.list_reminders);
		listReminders.setOnClickListener(this);
		// ...
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		Intent intent;
		switch (v.getId()) {
			case R.id.create_new_reminder:
				intent = new Intent(this, InputActivity.class);
				startActivity(intent);
				break;
			case R.id.list_reminders:
				intent = new Intent(this, ListActivity.class);
				startActivity(intent);
				break;
		}
	}

}
