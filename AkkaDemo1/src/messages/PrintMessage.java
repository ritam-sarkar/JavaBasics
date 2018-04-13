/**
 * 
 */
package messages;

import java.util.List;

/**
 * @author ritsarka
 *
 */
public class PrintMessage {
	
	private List<String> fileNames;
	private String threadName;
	public PrintMessage(List<String> fileNames, String threadName) {
		super();
		this.fileNames = fileNames;
		this.threadName = threadName;
	}
	public List<String> getFileNames() {
		return fileNames;
	}
	public void setFileNames(List<String> fileNames) {
		this.fileNames = fileNames;
	}
	public String getThreadName() {
		return threadName;
	}
	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}
	

}
