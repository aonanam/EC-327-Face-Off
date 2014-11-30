package com.example.faceoff;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	Button tut_button;
	Button single_phone_button;
	Button Profile_button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Get the view from activity_main.xml
		setContentView(R.layout.activity_main);
	
		//Locate buttons in activity_main.xml
		tut_button = (Button) findViewById(R.id.tut_button);
		single_phone_button = (Button) findViewById(R.id.single_phone_button);
		Profile_button = (Button) findViewById(R.id.Profile_button);
	
		//Capture button clicks
		tut_button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
			
				//Start Tutorial class
				Intent intent1 = new Intent(MainActivity.this, Tutorial.class);
				startActivity(intent1);
			}
		});
	
		single_phone_button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
			
				//Start SinglePhone class
				Intent intent2 = new Intent(MainActivity.this, SinglePhone.class);
				startActivity(intent2);
			}
		});
	
		Profile_button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
			
				//Start CreateProfile class
				Intent intent3 = new Intent(MainActivity.this, CreateProfile.class);
				startActivity(intent3);
			}
		});
	
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}