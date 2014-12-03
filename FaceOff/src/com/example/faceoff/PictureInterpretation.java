package com.example.faceoff;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.TextView;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.http.*;

import org.json.*;

public class PictureInterpretation {

	public static ArrayList<Double> Decode(Bitmap picture)
	{    
		HttpResponse<JsonNode> response = null;
		
		class CallMashapeAsync extends AsyncTask<String, Integer, HttpResponse<JsonNode>> 
		{	
	    	protected HttpResponse<JsonNode> doInBackground(String... msg) 
	    	{
	    		HttpResponse<JsonNode> request = null;
	    		
				try 
				{
					request = Unirest.post("https://apicloud-facemark.p.mashape.com/process-file.json")
							.header("X-Mashape-Key", "O5pPl3KTaVmshRGGD5FykeKF31gXp15vSBMjsnfMHFofluIQtP")
							.field("image", new File("/storage/sdcard0/DCIM/Camera/20141202_212057.jpg"))
							.asJson();
				} 
				catch (UnirestException e) 
				{
					e.printStackTrace();
				}	
	    		return request;
	    	}
	    	protected void onPostExecute(HttpResponse<JsonNode> response) 
	    	{
	    		JSONArray Array = response.getBody().getArray();
	    		String answer = Array.toString();
	        	System.out.println(answer);
	        	System.out.println(response.getHeaders());
	    	}
		}
		
		new CallMashapeAsync().execute();
		
		ArrayList<Double> interpretedVals = new ArrayList<Double>();
		
		return interpretedVals;
	}

}
