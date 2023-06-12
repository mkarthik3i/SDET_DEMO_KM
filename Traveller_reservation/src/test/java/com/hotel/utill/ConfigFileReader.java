package com.hotel.utill;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
		
		private Properties properties;
		private final String propertyFilePath= "configs//Configuration.properties";

		
		public ConfigFileReader(){
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(propertyFilePath));
				properties = new Properties();
				try {
					properties.load(reader);
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
			}		
		}
		
		public String getDriverPath(){
			String driverPath = properties.getProperty("driverPath");
			if(driverPath!= null) return driverPath;
			else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");		
		}
		
		public long getImplicitlyWait() {		
			String implicitlyWait = properties.getProperty("implicitlyWait");
			if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
			else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
		}
		
		public String getApplicationUrl() {
			String url = properties.getProperty("appURL");
			if(url != null) return url;
			else throw new RuntimeException("URL is not specified in the Configuration.properties file.");
		}
		
		public String getBrowserName() {
			String url = properties.getProperty("browser");
			if(url != null) return url;
			else throw new RuntimeException("Browser is not specified in the Configuration.properties file.");
		}
		
		public String getCountry() {
			String url = properties.getProperty("country");
			if(url != null) return url;
			else throw new RuntimeException("Country is not specified in the Configuration.properties file.");
		}
		
		public String get_no_of_adult() {
			String url = properties.getProperty("no_of_adult");
			if(url != null) return url;
			else throw new RuntimeException("No of Adult not specified in the Configuration.properties file.");
		}
		
		public String get_no_of_rooms() {
			String url = properties.getProperty("no_of_rooms");
			if(url != null) return url;
			else throw new RuntimeException("No of rooms not specified in the Configuration.properties file.");
		}
		
		public String get_title() {
			String url = properties.getProperty("title");
			if(url != null) return url;
			else throw new RuntimeException("Title has not specified in the Configuration.properties file.");
		}
		
		public String get_firstname1() {
			String url = properties.getProperty("first_name1");
			if(url != null) return url;
			else throw new RuntimeException("First Name-1 is not specified in the Configuration.properties file.");
		}
		
		public String get_firstname2() {
			String url = properties.getProperty("first_name2");
			if(url != null) return url;
			else throw new RuntimeException("First Name-1 is not specified in the Configuration.properties file.");
		}
		
		public String get_lastname1() {
			String url = properties.getProperty("last_name1");
			if(url != null) return url;
			else throw new RuntimeException("Last Name-1 is not specified in the Configuration.properties file.");
		}
		
		public String get_lastname2() {
			String url = properties.getProperty("last_name2");
			if(url != null) return url;
			else throw new RuntimeException("Last Name-2 is not specified in the Configuration.properties file.");
		}
		
		public String get_pax1_date() {
			String url = properties.getProperty("pax1_date");
			if(url != null) return url;
			else throw new RuntimeException("First Passenger date is not specified in the Configuration.properties file.");
		}
		
		public String get_pax2_date() {
			String url = properties.getProperty("pax2_date");
			if(url != null) return url;
			else throw new RuntimeException("Second Passenger date is not specified in the Configuration.properties file.");
		}
		
		public String get_pax1_month() {
			String url = properties.getProperty("pax1_month");
			if(url != null) return url;
			else throw new RuntimeException("First Passenger month is not specified in the Configuration.properties file.");
		}
		
		public String get_pax2_month() {
			String url = properties.getProperty("pax2_month");
			if(url != null) return url;
			else throw new RuntimeException("Second Passenger month is not specified in the Configuration.properties file.");
		}
		
		public String get_pax1_year() {
			String url = properties.getProperty("pax1_year");
			if(url != null) return url;
			else throw new RuntimeException("First Passenger Year is not specified in the Configuration.properties file.");
		}
		
		public String get_pax2_year() {
			String url = properties.getProperty("pax2_year");
			if(url != null) return url;
			else throw new RuntimeException("Second Passenger Year is not specified in the Configuration.properties file.");
		}
		
		public String getMobileNumber() {
			String url = properties.getProperty("mobile_number");
			if(url != null) return url;
			else throw new RuntimeException("mobile_numberis not specified in the Configuration.properties file.");
		}
		
		public String getEmail() {
			String url = properties.getProperty("email");
			if(url != null) return url;
			else throw new RuntimeException("Email Id is not specified in the Configuration.properties file.");
		}

		public String getCity() {
			String url = properties.getProperty("city");
			if(url != null) return url;
			else throw new RuntimeException("City is not specified in the Configuration.properties file.");
		}
		
		public String getPincode() {
			String url = properties.getProperty("postcode");
			if(url != null) return url;
			else throw new RuntimeException("Pin code is not specified in the Configuration.properties file.");
		}
		
		
		public String getAddress1() {
			String url = properties.getProperty("address1");
			if(url != null) return url;
			else throw new RuntimeException("Address-1 is not specified in the Configuration.properties file.");
		}
		
		public String getAddress2() {
			String url = properties.getProperty("address2");
			if(url != null) return url;
			else throw new RuntimeException("Address-1 is not specified in the Configuration.properties file.");
		}
		
		
		public String gethearabout() {
			String url = properties.getProperty("hearabout");
			if(url != null) return url;
			else throw new RuntimeException("Hearabout is not specified in the Configuration.properties file.");
		}
		
		public String getPrice() {
			String url = properties.getProperty("one_adult_passenger_cost");
			if(url != null) return url;
			else throw new RuntimeException("one_adult_passenger_cost is not specified in the Configuration.properties file.");
		}
		
		public String getDeparture_airport() {
			String url = properties.getProperty("departure_airport");
			if(url != null) return url;
			else throw new RuntimeException("departure_airport is not specified in the Configuration.properties file.");
		}
		
	}

