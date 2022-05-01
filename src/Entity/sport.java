package Entity;

public class sport {
	
	private int sportId;
	private String sportType;
	
	
	


	public void Sport(int sportId, String sportType) {
		this.setSportId(sportId);
		this.setSportType(sportType);
		
		
	}

	public int getSportId() {
		return sportId;
	}

	public void setSportId(int sportId) {
		this.sportId = sportId;
	} 

	public String getSportType() {
		return sportType;
	}

	public void setSportType(String sportType) {
		this.sportType = sportType;
	}


}