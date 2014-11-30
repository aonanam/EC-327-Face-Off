package com.example.faceoff;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Player2 extends Activity {
	Button P2_Profile_button;
	Button start_button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player2);
		
		//Locate buttons in activity_player2.xml
		P2_Profile_button = (Button) findViewById(R.id.P2_Profile_button);
		start_button = (Button) findViewById(R.id.start_button);
		
		//Capture button clicks
		P2_Profile_button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
			
				//Start CreateProfile class
				Intent intent1 = new Intent(Player2.this, CreateProfile.class);
				startActivity(intent1);
			}
		});
		
		//Capture button clicks
		start_button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
			
				//Start StartFaceOff class
				Intent intent1 = new Intent(Player2.this, StartFaceOff.class);
				startActivity(intent1);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.player2, menu);
		return true;
	}

}
