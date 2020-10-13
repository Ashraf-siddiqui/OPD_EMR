package OPDEMR.filters;

import java.util.HashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class BuilderFilters.
 */
public class CloudOpsFilters {


	/**
	 * The Enum Country.
	 */
	public enum Country {

		/** India */
		INDIA("India"),

		/**UK*/
		UK("United Kingdom");
		/** The filter. */
		private String filter;

		/**
		 * Instantiates a new TimeZone.
		 *
		 * @param filter the filter
		 */
		Country(String filter) {
			this.filter = filter;
		}

		/*
		 * (non-Javadoc)
		 *
		 * @see java.lang.Enum#toString()
		 */
		@Override
		public String toString() {
			return filter;
		}

	}
	
	/**
	 * The Enum Region.
	 */
	public enum Regions {

		/** India */
		AsiaPacificMumbai("India"),

		/**UK*/
		UK("United Kingdom");
		/** The filter. */
		private String filter;

		/**
		 * Instantiates a new TimeZone.
		 *
		 * @param filter the filter
		 */
		Regions(String filter) {
			this.filter = filter;
		}

		/*
		 * (non-Javadoc)
		 *
		 * @see java.lang.Enum#toString()
		 */
		@Override
		public String toString() {
			return filter;
		}

	}

	/**
	 * The Enum Social Media
	 */
	public enum SocialMedia {

		/** The Facebook */
		FACEBOOK,
		
		/** The LinkedIn */
		LINKEDIN,
		
		/** The Google */
		GOOGLE,
		
		/** The Twitter */
		TWITTER;

	}
	
	public static final Map<String, String> staticMap = new HashMap<>();

	  static {
	      staticMap.put("Asia Pacific (Mumbai)", "ap-south-1");
	      staticMap.put("Asia Pacific (Seoul)", "ap-northeast-2");
	      staticMap.put("Asia Pacific (Singapore)", "ap-southeast-1");
	      staticMap.put("Asia Pacific (Sydney)", "ap-southeast-2");
	      staticMap.put("Asia Pacific (Tokyo)", "ap-northeast-1");
	      staticMap.put("EU (Ireland)", "eu-west-1");
	      staticMap.put("Global", "global");
	      staticMap.put("US East (Ohio)", "us-east-2");
	      staticMap.put("US West (Oregon)", "us-west-2");
	      
	  }
	


}
