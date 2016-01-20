package org.apache.mylog;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MLog {

	public static String initPath="D:/log";
	public static String logFileName="2016-1-20.txt";
	public static String lineSeparator = System.getProperty("line.separator", "\n");
	
	
	public static void writeLog(String str)
	{
		File logDir=new File(initPath);
		if(!logDir.exists()) 
			logDir.mkdirs();
		File logFile=new File(initPath+File.separator+logFileName);
		FileWriter logWriter=null;
		if(!logFile.exists())
		{
			try {
				logFile.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		try
		{
			logWriter=new FileWriter(logFile,true);
			logWriter.write(str+lineSeparator);
			logWriter.flush();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try
			{
				logWriter.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static String getString(String...strs)
	{
		if(strs.length>0)
		{
			StringBuilder sb=new StringBuilder();
			for(String s:strs)
			{
				sb.append(s);
				sb.append(" | ");
			}
			return sb.toString();
		}
		else 
			return "";
	}

}
