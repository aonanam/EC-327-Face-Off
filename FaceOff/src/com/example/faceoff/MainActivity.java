package com.example.faceoff;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	ImageButton tut_button;
	Button single_phone_button;
	Button Profile_button;
	//ArrayList (like list from STL in c++) holds names of all profiles
	public static ArrayList<String> profileArray = new ArrayList<String>();
	public static ArrayList<profile> activePlayers = new ArrayList<profile>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Get the view from activity_main.xml
		setContentView(R.layout.activity_main);
	
		//Adds "Choose Profile" as first string in profileArray when app first runs
		if (profileArray.size() == 0)
		{
			profileArray.add("Choose Profile");
		}
		//Locate buttons in activity_main.xml
		tut_button = (ImageButton) findViewById(R.id.tut_button);
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