package com.example.faceoff;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class profile {

		String profileName;
		int points;
		
		/*
		 * (x,y) values for the base face, for a total of 68 points
		 * As of now, we only care about 15 - 20 (left eyebrow), 21-26 (right eyebrow),
		 * 27-30 (right eye excluding pupil), 32 - 35 (left eye excluding pupil), 48 - 66 (mouth).
		 * */
		
		int [] x ; //x values of the baseface (should be 68 in size)
		int [] y ; //y values of the baseface (should be 68 in size)
		
		int profileNum; //The element of the current profile. assuming many will be stored
		
		public profile(String name, double [] arrayMap, int index)
		{
			profileName = name;
			points = 0;
			profileNum = index;
		}
		
		public int getPoints()
		{
			return this.points;
		}
		
		public String getProfileName()
		{
			return this.profileName;
		}
		
		public int getIndex()
		{
			return this.profileNum;
		}
		
		public void setProfileName(String newName)
		{
			this.profileName = newName;
		}
}
