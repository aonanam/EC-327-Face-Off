package com.example.faceoff;

import java.io.File;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Player2Defense extends Activity {
	Button P2_Offense_button;
	ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player2_defense);
		
		//Displays image of previously taken picture. Need to change test.jpg to whatever we call the picture, and increase the size
		String path = MainActivity.activePlayers.get(0).path;//Environment.getExternalStorageDirectory()+ "/Pictures/FaceOff/test.jpg";
		ImageView jpgview = (ImageView)findViewById(R.id.jpgview);
		BitmapFactory.Options options = new BitmapFactory.Options();
		  options.inSampleSize = 2;
		  Bitmap bm = BitmapFactory.decodeFile(path, options);
		  jpgview.setImageBitmap(bm);
		  
		  double difference = ComparisonLogic.FaceVsFace(MainActivity.activePlayers.get(0).baseFace,MainActivity.activePlayers.get(1).baseFace);
		  
		  System.out.println(difference);
		  
		  System.out.println("Players2Defense trololol");
		  
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
