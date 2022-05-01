package Application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Entity.sport;
import Dao.sportsDao;

public class Menu {
	

	private sportsDao sportsDao = new sportsDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(		
					"Display Sports",
					"Display a Sport", 
					"Create Sport", 
					"Delete Sport");
	
	
	
	public void start() {
		String selection = "";
		
		do {
			
			printMenu();
			selection = scanner.nextLine();
			
			try {
				
				if (selection.equals("1")) {
					displaySports();
				} else if (selection.equals("2")) {
					displaySport();
				} else if (selection.equals("3")) {
					createSport();
				}	else if (selection.equals("4")) {
					deleteSport();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		
			
			System.out.println("Press enter to continue...");
			scanner.nextLine();
		} while (!selection.equals("-1"));
	}
	
	private void printMenu() {
		System.out.println("Select an Option:\n----------------------------");
		for (int i= 0; i < options.size(); i++) {
			System.out.println(i + 1 + ")" + options.get(i));
		}
	}
	
	private void displaySports() throws SQLException {
		List<sport> sports = sportsDao.getSports();
		for (sport sport : sports) {
			System.out.println(sport.getSportId() + ": " + sport.getName());
		}
	}
	
	private void displaySport() throws SQLException {
		System.out.print("Enter Sport id: ");
		int id = Integer.parseInt(scanner.nextLine());
		sport sport = sportsDao.getSportById(id);
		System.out.println(sport.getSportId() + ": " + sport.getName());
	
		
	}
	
	private void createSport() throws SQLException {
		System.out.print("Enter new team name:");
		String teamname = scanner.nextLine();
		sportsDao.createNewSport(sportType);
	}
	
	private void deleteSport() throws SQLException {
		System.out.print("Enter sport id to delete:");
		int id = Integer.parseInt(scanner.nextLine());
		sportsDao.deleteSportById(id);
	}
	

}
