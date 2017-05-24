package com.ub.ml;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorkFlowManager
{
	static Logger logger = LoggerFactory.getLogger(WorkFlowManager.class);
	public static void main(String[] args){

	//Read list of TV Shows from S3 store
	DataCollector dataCollector = new DataCollector();
	try
	{
		List<String> showNameList = dataCollector.getShowNameFromS3("aws-project-ml", "tv_show_names.txt");
		logger.info(showNameList.toString());
	}
	catch (IOException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
