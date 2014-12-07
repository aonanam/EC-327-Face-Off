package com.example.faceoff;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Player1Defense extends Activity {
	Button Next_Round_button;
	Button Quit_button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player1_defense);
		
		String path = MainActivity.activePlayers.get(1).path;//Environment.getExternalStorageDirectory()+ "/Pictures/FaceOff/test.jpg";
		ImageView jpgview = (ImageView)findViewById(R.id.jpgview);
		BitmapFactory.Options options = new BitmapFactory.Options();
		  options.inSampleSize = 2;
		  Bitmap bm = BitmapFactory.decodeFile(path, options);
		  jpgview.setImageBitmap(bm);
		
		//Locate buttons in activity_player1_defense.xml
		Next_Round_button = (Button) findViewById(R.id.Next_Round_button);
		Quit_button = (Button) findViewById(R.id.Quit_button);
						
		//Capture button clicks
		Next_Round_button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				//Start Player1Offense class
				Intent intent1 = new Intent(Player1Defense.this, Player1Offense.class);
				startActivity(intent1);
			}
		});
		Quit_button.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				//Start MainActivity class
				Intent intent2 = new Intent(Player1Defense.this, MainActivity.class);
				startActivity(intent2);
			}
		});				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.player1_defense, menu);
		return true;
	}

}
