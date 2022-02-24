//****************************************
//Class: 	ItemsContainer
//Purpose: 	Used as a container for information
//			that is received from Steam API.
//
//****************************************

package application.model;

public class ItemsContainer {

	public CompareValue[] spItemList = new CompareValue[160];				// There are 160 total Specialized Killstreak items on the market
	public CompareValue[] profItemList = new CompareValue[160];				// There are 160 total items on the market
	public int spSpot = 0;
	public int profSpot = 0;
	public int numProfFabricators = 0;
	public int numSpFabricators = 0;
	
	ItemsContainer() {
		
	}
	
	public int getSpecializedSpot() {
		return this.spSpot;
	}
	
	public int getProfessionalSpot() {
		return this.profSpot;
	}
	
	public int getNumProfFabricators() {
		return this.numProfFabricators;
	}
	
	public CompareValue[] getSpList() {
		return this.spItemList;
	}
	
	public CompareValue[] getProfList() {
		return this.profItemList;
	}
	
	// The insertTo function will insert the value into the list of CompareValues in order.
	public int insertTo( boolean a, CompareValue b ) {						// True = sp, False = prof
		boolean hasVal = false;
		if ( a ) {
			for ( int i = 0; i < spSpot; i++ ) {
				if ( getSpList()[i].getItemName().equals(b.getItemName()) ) {
					return -1;
				}
			}
			spItemList[spSpot] = b;
			spSpot++;
			return 1;
		}
		else {
			for ( int i = 0; i < profSpot; i++ ) {
				if ( getProfList()[i].getItemName().equals(b.getItemName()) ) {
					return -1;
				}
			}
			profItemList[profSpot] = b;
			profSpot++;
			return 1;
		}
	}

	// Finds the location in either the specialized or professional lists (true = spec, false = prof) and returns its location
	public int findLocation(boolean a, String b) {				// true = spec, false = prof
		int c = -1;
		if ( a ) {
			for ( int i = 0; i < spSpot; i++ ) {
				if ( spItemList[i].getItemName().equals(b) ) {
					return i;
				}
			}
		}
		else {
			for ( int i = 0; i < profSpot; i++ ) {
				if ( getProfList()[i].getItemName().equals(b) ) {
					return i;
				}
			}
		}
		System.out.println("ERROR: Item: " + b + " not found!");
		return c;
	}
	
	// Updates the price of Fabricator section of CompareValue
	public boolean updateFabricatorPrice(boolean a, String b, double c) {
		int loc = findLocation(a,b);
		if ( loc == -1 ) {
			return false;
		}
		if ( a ) {
			if ( spItemList[loc].getPriceOfFabricator() == 0 ) {
				spItemList[loc].setPriceOfFabricator(c);
				spItemList[loc].setPriceDifference(spItemList[loc].getPriceOfKit()-c);
				this.numSpFabricators++;				// change this!!!!
			}
		}	
		else {
			if ( profItemList[loc].getPriceOfFabricator() == 0 ) {
				profItemList[loc].setPriceOfFabricator(c);
				profItemList[loc].setPriceDifference(profItemList[loc].getPriceOfKit()-c);
				this.numProfFabricators++;
			}
		}
		return true;
	}
	
}
