
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PropertyFileReader prop = new PropertyFileReader("C:/Users/IBM_ADMIN/Desktop/job.properties");
		System.out.println("read by reader "+prop.read("job.shc.cron.enable"));
		boolean enable = Boolean.parseBoolean(prop.read("job.shc.cron.enable"));
        if(enable){
        	System.out.println("enable true");
        }
	}

}
