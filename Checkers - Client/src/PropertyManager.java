import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {

	private static PropertyManager INSTANCE = null;
	private Properties prop;
	
	private PropertyManager() throws IOException{
		prop = new Properties();
		InputStream is = getClass().getClassLoader().getResourceAsStream("config.properties");
		
		if(is != null){
			prop.load(is);
		}else{
			throw new FileNotFoundException("Property file is not found");
		}
	}
	
	public static PropertyManager getInstance() throws IOException{
		if(INSTANCE == null){
			INSTANCE = new PropertyManager();
		}
		return INSTANCE;
	}
	
	public String getAddress(){
		return prop.getProperty("server");
	}
	
	public int getPort(){
		return Integer.parseInt(prop.getProperty("port"));
	}
	
}
