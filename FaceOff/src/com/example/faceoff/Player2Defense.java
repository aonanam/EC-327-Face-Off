package com.example.faceoff;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Player2Defense extends Activity {
	Button P2_Offense_button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player2_defense);
		
		//Locate buttons in activity_player2_defense.xml
		P2_Offense_button = (Button) findViewById(R.id.P2_Offense_button);
						
		//Capture button clicks
		P2_Offense_button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				//Start Player2Offense class
				Intent intent1 = new Intent(Player2Defense.this, Player2Offense.class);
				startActivity(intent1);
			}
		});				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.player2_defense, menu);
		return true;
	}

}
