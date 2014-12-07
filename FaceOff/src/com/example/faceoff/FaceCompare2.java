package com.example.faceoff;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class FaceCompare2 extends Activity {

	Button Quit_button;
	Button Next_Round_button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_face_compare2);
		
		//Displays the two pictures taken on offense vs defense side by side
		
				//Displays image taken by player 1 on offense
				String path1 = Environment.getExternalStorageDirectory()+ "/Pictures/FaceOff/Player2Offense.jpg";
				ImageView jpgview1 = (ImageView)findViewById(R.id.imageView1);
				BitmapFactory.Options options1 = new BitmapFactory.Options();
				options1.inSampleSize = 2;
				Bitmap bm1 = BitmapFactory.decodeFile(path1, options1);
				jpgview1.setImageBitmap(bm1);
				
				//Displays image taken by player 2 on defense
				String path2 = Environment.getExternalStorageDirectory()+ "/Pictures/FaceOff/Player1Defense.jpg";
				ImageView jpgview2 = (ImageView)findViewById(R.id.imageView2);
				BitmapFactory.Options options2 = new BitmapFactory.Options();
				options2.inSampleSize = 2;
				Bitmap bm2 = BitmapFactory.decodeFile(path2, options2);
				jpgview2.setImageBitmap(bm2);
				
				
				//Locate buttons in activity_face_compare.xml
				Quit_button = (Button) findViewById(R.id.Quit_button);
				Next_Round_button = (Button) findViewById(R.id.Next_Round_button);
										
				//Capture button clicks
				Quit_button.setOnClickListener(new OnClickListener() {
					public void onClick(View arg0) {
						//Start MainActivity class
						Intent intent1 = new Intent(FaceCompare2.this, MainActivity.class);
						startActivity(intent1);
					}
				});		
				Next_Round_button.setOnClickListener(new OnClickListener() {
					public void onClick(View arg0) {
						//Start Player1Offense class
						Intent intent1 = new Intent(FaceCompare2.this, Player1Offense.class);
						startActivity(intent1);
					}
				});		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.face_compare2, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}