package com.ub.ml;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DataCollector
{

	
	public List<String> getShowNameFromS3(String bucketName, String key) throws IOException{
		
		 AmazonS3 s3 = new AmazonS3Client();
       Region usWest2 = Region.getRegion(Regions.US_WEST_2);
       s3.setRegion(usWest2);
       
		System.out.println("Downloading an object");
      S3Object object = s3.getObject(new GetObjectRequest(bucketName, key));
      System.out.println("Content-Type: "  + object.getObjectMetadata().getContentType());
      
      BufferedReader reader = new BufferedReader(new InputStreamReader(object.getObjectContent()));
      
      List<String> showNames = null;
      while (true) {
          String name = reader.readLine();
          if (name == null) break;
          if(showNames == null){
         	 showNames = new ArrayList<>();
          }
          showNames.add(name);
          System.out.println("    " + name);
      }
      return showNames;
      
	}
	/* main method for quick test */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
