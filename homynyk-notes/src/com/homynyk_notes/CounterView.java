package com.homynyk_notes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class CounterView extends Activity {
	Button add, delete;
	int index;
	ArrayList<Counter> saved_counters;
	Counter selected_counter;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.counter_view);
		add = (Button) findViewById(R.id.bAdd);
		delete = (Button) findViewById(R.id.bDelete);

		// Get index of selected counter
		Intent intent;
		intent = getIntent();
		index = intent.getIntExtra("index", -99);

		// Check if index is valid and display counter name and count
		if (index >= 0) {
			saved_counters = CounterListStorage
					.loadFromFile(getApplicationContext());
			selected_counter = saved_counters.get(index);
			TextView counterName = (TextView) findViewById(R.id.tvDisplay);
			counterName.setText(selected_counter.getName());
			TextView display_count = (TextView) findViewById(R.id.count);
			display_count.setText(selected_counter.getValue().toString());
		}

		// Increment and save count when add button is pushed
		add.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				selected_counter.setValue(selected_counter.getValue()+1);
				selected_counter.addDate(new Date(System.currentTimeMillis()));
				TextView display_count = (TextView) findViewById(R.id.count);
				display_count.setText(selected_counter.getValue().toString());
                saved_counters.set(index, selected_counter);
                CounterListStorage.saveInFile(getApplicationContext(), saved_counters);
			}
		});
		
		// Remove counter and return to main screen when delete button is pushed
		delete.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				saved_counters.remove(index);
				CounterListStorage.saveInFile(getApplicationContext(), saved_counters);
				finish();
			}
		});

	}
}
