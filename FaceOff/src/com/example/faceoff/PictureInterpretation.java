package com.example.faceoff;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.TextView;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.http.*;

import org.json.*;

public class PictureInterpretation 
{
	public static ArrayList<Double> Decode(final Bitmap picture)
	{    
		class CallMashapeAsync extends AsyncTask<String, Integer, HttpResponse<JsonNode>> 
		{	
			//instance of the interface called ServerResponse
			public ServerResponse delegate = null;
			
	    	protected HttpResponse<JsonNode> doInBackground(String... msg) 
	    	{
	    		HttpResponse<JsonNode> request = null;
	    		Bitmap transfer = picture;
	    		
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
	    		ArrayList<Double> interpretedVals = new ArrayList<Double>();
	    		JSONArray Array = response.getBody().getArray();
	    		String answer = Array.toString();
	        	System.out.println(answer);
	        	System.out.println(response.getHeaders());
	        	
	        	try 
	        	{
					int length = Array.getJSONObject(0).getJSONArray("faces").getJSONObject(0).getJSONArray("landmarks").length();
					
					for(int x = 0; x < length; x++)
					{
						interpretedVals.add(Array.getJSONObject(0).getJSONArray("faces").getJSONObject(0).getJSONArray("landmarks").getJSONObject(0).getDouble("x"));
					}
					for(int x = 0; x < length; x++)
					{
						interpretedVals.add(Array.getJSONObject(0).getJSONArray("faces").getJSONObject(0).getJSONArray("landmarks").getJSONObject(0).getDouble("y"));
					}
					
					delegate.finishedProcess(interpretedVals);
	        	} 
	        	catch (JSONException e) 
	        	{
					e.printStackTrace();
				}
	    	}
		}
		ArrayList<Double> interpretedVals = new ArrayList<Double>();
		
		new CallMashapeAsync().execute();
		
		return interpretedVals;
	}
}
