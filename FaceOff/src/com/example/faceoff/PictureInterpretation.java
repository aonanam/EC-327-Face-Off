package com.example.faceoff;

import java.io.File;
import java.util.ArrayList;

import android.net.Uri;
import android.os.AsyncTask;

import com.mashape.unirest.http.*;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.*;
import com.mashape.unirest.*;

import org.json.*;

public class PictureInterpretation 
{
	public static ArrayList<Double> Decode(final Uri picture)
	{    
		class CallMashapeAsync extends AsyncTask<String, Integer, HttpResponse<JsonNode>> 
		{				
	    	protected HttpResponse<JsonNode> doInBackground(String... msg) 
	    	{
	    		HttpResponse<JsonNode> request = null;
	    		
	    		if(picture != null)
	    		{
	    			System.out.println("Picture is real! " + picture.getPath());
	    			
	    			try 
					{
						request = Unirest.post("https://apicloud-facemark.p.mashape.com/process-file.json")
								.header("X-Mashape-Key", "O5pPl3KTaVmshRGGD5FykeKF31gXp15vSBMjsnfMHFofluIQtP")
								.field("image", new File(picture.getPath()))
								.asJson();
					} 
					catch (UnirestException e) 
					{
						e.printStackTrace();
					}	
	    		}
	    		else
	    		{
	    			System.out.println("Picture is not real");
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
					
					//delegate.finishedProcess(interpretedVals);
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
