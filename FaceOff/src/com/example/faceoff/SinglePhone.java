package com.example.faceoff;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SinglePhone extends Activity {
	Button P1_Profile_button;
	Button P2_button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_single_phone);
		
		//Locate buttons in activity_single_phone.xml
		P1_Profile_button = (Button) findViewById(R.id.P1_Profile_button);
		P2_button = (Button) findViewById(R.id.P2_button);
		
		//Capture button clicks
		P1_Profile_button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				
				//Start CreateProfile class
				Intent intent1 = new Intent(SinglePhone.this, CreateProfile.class);
				startActivity(intent1);
			}
		});
		
		P2_button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				
				//Start Player2 class
				Intent intent1 = new Intent(SinglePhone.this, Player2.class);
				startActivity(intent1);
			}
		});
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.single_phone, menu);
		return true;
	}

}
