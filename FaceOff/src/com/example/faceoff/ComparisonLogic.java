package com.example.faceoff;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class ComparisonLogic 
{
	/*
	 * (x,y) values for the base face, for a total of 68 points
	 * As of now, we only care about 15 - 20 (left eyebrow), 21-26 (right eyebrow),
	 * 27-30 (right eye excluding pupil), 32 - 35 (left eye excluding pupil), 48 - 66 (mouth).
	 * The total number of relevant points is 34 as of now. So each point will be weighted with the 
	 * value of 1/34
	 * */
	
	public double []  VsBaseFace(profile p, double [] faceArray) //Params = profile/arrayMap of new face
	{
		double [] diffFromBase = {}; //Format will be: all x then all y
		
		//logic for extracting x y coordinates from the picture here, should probably make a function
		
		/*
		 * Comparison logic here.
		 * This function will calculate the differences between the baseface and the new face
		 * that the user just took, using the pupils and nose as a center
		 */
		
		return diffFromBase;
	}

	public double FaceVsFace(double [] picOne, double [] picTwo)
	{
		double points = 0;
		
		if(picOne.length == picTwo.length) //Checking to see if the arrays are the same size
		{
			List<Double> comparedPoints = new ArrayList<Double>();;
			
			int length = picOne.length;
			
			/*
			 * This loop adds the differences of differences for both faces and appends them to a list
			 * called comparedPoints. It takes the opposite of one of the points and adds them together.
			 * Therefore, the closer to 0 the value is, the better the faces at that point match. Need
			 * to add an algorithm to take care of only the points we need and add them to points.
			 * */
			
			for(int x = 0; x < length; x++)
			{
				{
					comparedPoints.add(picOne[x] + -1*picTwo[x]);
				}
			}
		}
		
		else
		{
			/*
			 * If the arrays are not the same size, do something here
			 * */
		}
		
		return points;
	}
}
