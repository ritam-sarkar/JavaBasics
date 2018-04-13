/**
 * 
 */
package messages;

import actors.FileListenerActor;
import akka.actor.ActorRef;

/**
 * @author ritsarka
 *
 */
public class SearchMessage {
	private String filePath;
	private int level;

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public SearchMessage(String filePath,int level) {
		super();
		this.filePath = filePath;
		this.setLevel(level);
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

		

}
