package com.ub.ml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class DataCollector
{
    static Logger logger = LoggerFactory.getLogger(DataCollector.class);
	
	public List<String> getShowNameFromS3(String bucketName, String key) throws IOException{
        AmazonS3 s3 = new AmazonS3Client().withRegion(Region.getRegion(Regions.US_EAST_1));
        logger.info("Downloading an object");
        S3Object object = s3.getObject(new GetObjectRequest(bucketName, key));
        logger.info("Content-Type: " + object.getObjectMetadata().getContentType());

        BufferedReader reader = new BufferedReader(new InputStreamReader(object.getObjectContent()));
      
      List<String> showNames = null;
      while (true) {
          String name = reader.readLine();
          if (name == null) break;
          if(showNames == null){
         	 showNames = new ArrayList<>();
          }
          showNames.add(name);
          logger.debug("    " + name);
      }
      return showNames;
      
	}
	/* main method for quick test */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
