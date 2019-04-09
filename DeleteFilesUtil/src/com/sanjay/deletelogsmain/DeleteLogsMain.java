package com.sanjay.deletelogsmain;

import com.sanjay.deletelogs.DeleteLogsClass;

public class DeleteLogsMain 
{
		public static void main(String[] args) 
		{
//			java.util.logging.ConsoleHandler.level = NONE;
			// TODO Auto-generated method stub
			
			//Constants
			long TEN_DAYS = 10 * 24 * 60 * 1000;
			long ONE_MONTH = TEN_DAYS * 30;
			
			DeleteLogsClass dl = new DeleteLogsClass();
			
			String deletedFilesLog = "E:\\Cmd\\Sanjay\\Log\\DeletedFilesLog.log";
			String logsFolderPath = "E:\\aircoreProjects\\data\\aircargo\\UW\\cfd\\ssim";
			
			//To Test in Local
			/*String deletedFilesLog = "C:\\Sanjay\\Testing\\aircoreProjects\\DeletedFilesLog\\DeletedFilesLog.log";
			String logsFolderPath = "C:\\Sanjay\\Testing\\aircoreProjects\\data\\aircargo";*/
			
			dl.deleteLogs(deletedFilesLog, logsFolderPath);
			
			
		}
}
