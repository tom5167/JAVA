package PatientCareUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {
	
	public String getCurrentDateTime() {
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
	    return formatter.format(date).toString();
	}

	public void setUserId(String userId) {
		System.setProperty("user.id",userId);
	}
	
	public void setUserId(int userId) {
		System.setProperty("user.id",userId+"");
	}
	
	public String getUserId() {
		return System.getProperty("user.id");
	}

}
