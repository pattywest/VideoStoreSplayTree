package edu.iastate.cs228.hw5;


import java.io.FileNotFoundException;
import java.util.Scanner; 

/**
 *  
 * @author Patrick Westerlund
 *
 */

/**
 * 
 * The Transactions class simulates video transactions at a video store. 
 *
 */
public class Transactions 
{
	
	/**
	 * The main method generates a simulation of rental and return activities.  
	 *  
	 * @param args
	 * @throws FileNotFoundException
	 * @throws AllCopiesRentedOutException 
	 * @throws FilmNotInInventoryException 
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IllegalArgumentException, FilmNotInInventoryException, AllCopiesRentedOutException
	{	
		VideoStore vs = new VideoStore("testFile");
		Scanner s = new Scanner(System.in);
		System.out.println("Transactions at a Video Store");
		System.out.println("keys: 1 (rent)     2 (bulk rent)");
		System.out.println("3 (return) 4 (bulk return) ");
		System.out.println("5 (summary) 6 (exit)");
		System.out.println("");
		while(true)
		{
			System.out.print("Transaction: ");
			int choice = s.nextInt();
			if(choice>5||choice<1)
			{
				break;
			}
			if(choice==1) 
			{
				System.out.print("Film to rent: ");
				s.nextLine();
				String line = s.nextLine();
				String film = VideoStore.parseFilmName(line);
				int copies = VideoStore.parseNumCopies(line);
				vs.videoRent(film, copies);
			}
			if(choice==2)
			{
				System.out.print("Video file (rent): ");
				s.nextLine();
				String videoFile = s.nextLine();
				vs.bulkRent(videoFile);
			}
			if(choice==3)
			{
				System.out.print("Film to return: ");
				s.nextLine();
				String line = s.nextLine();
				String film = VideoStore.parseFilmName(line);
				int copies = VideoStore.parseNumCopies(line);
				vs.videoReturn(film, copies);
			}
			if(choice==4)
			{
				System.out.print("Video file (return): ");
				s.nextLine();
				String videoFile = s.nextLine();
				vs.bulkReturn(videoFile);
			}
			if(choice==5)
			{
				System.out.println(vs.transactionsSummary());
			}
		}
		s.close();
		// 
		// 1. Construct a VideoStore object.
		// 2. Simulate transactions as in the example given in Section 4 of the 
		//    the project description. 
	}
}
