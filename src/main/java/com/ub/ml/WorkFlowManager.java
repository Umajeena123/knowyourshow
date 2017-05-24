package com.ub.ml;

import java.io.IOException;
import java.util.List;

public class WorkFlowManager
{
	public static void main(String[] args){
	//Read list of TV Shows from S3 store
	DataCollector dataCollector = new DataCollector();
	try
	{
		List<String> showNameList = dataCollector.getShowNameFromS3("aws-project-ml", "tv_show_names.txt");
		System.out.println(showNameList);
	}
	catch (IOException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
