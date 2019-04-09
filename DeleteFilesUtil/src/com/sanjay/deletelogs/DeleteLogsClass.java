package com.sanjay.deletelogs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class DeleteLogsClass 
{
	
	public void deleteLogs(String deletedFilesLog, String logsFolderPath)
	{

		Logger log = Logger.getLogger("log");
		log.setUseParentHandlers(false);
		FileHandler fh;
		//long noOfDays = 0;
		//long duration = 0;
		try
		{
			fh = new FileHandler(deletedFilesLog, true);
			log.addHandler(fh);
			SimpleFormatter sf = new SimpleFormatter();
			fh.setFormatter(sf);
			log.info("This is a log of deleted files\n");
		}
		catch(Exception e)
		{
			System.out.println();
		}
		int count = 0;
		try 
		{			
			
			Files.walk(Paths.get(logsFolderPath))
			.filter(Files::isRegularFile)
			.forEach((f)->
			{
				//System.out.println(f);
			    String file = f.toString();
			    System.out.println(file);
			    if( file.endsWith("dat") && file.contains("UW\\cfd\\ssim"))
			    {
			        //System.out.println(file + " found!");  
			    	
					long duration = 0;
			        File f1 = new File(file);
			        //System.out.println(f1);
			        	
			        duration = new Date().getTime() - f1.lastModified();
			        
			        //long TENDAYS = 10 * 24 * 60 * 1000;
			        
			        
					if (duration > (7 * 24 * 60 * 60 * 1000)) 
					//if (duration > (7 * 24 * 60 * 60 * 1000) && f1.delete()) 
						//if (duration > (7 * 24 * 60 * 60 * 1000) && f1.delete()) 
			        //if( duration > TENDAYS)
					//if(f1.delete())
					{
//						count++;
						//System.out.println( "File "+ file.getAbsolutePath()+" is deleted");
						log.info("File "+ f1.getAbsolutePath()+" is deleted");
					}		
			        //count++;
					//System.out.println(count +" log files are deleted. Please check logfile for details >> DeletedFilesLog.log.");
			    }
			});
			System.out.println("Log files are deleted. Please check the log for details >> DeletedFilesLog.log.");
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
