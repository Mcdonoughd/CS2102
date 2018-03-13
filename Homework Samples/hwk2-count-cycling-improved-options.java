// Different approaches to the countCyclingImproved method from CS2102 hwk2
// Prepared by Kartik Thooppal Vasu

class Competition {
	LinkedList<Athlete> athletes;
	
	Competition(LinkedList<Athlete> athletes) {
		this.athletes = athletes;
	}
	
	//returns the number of athletes who have improved in the "other" competition from "this" competition
	int countCyclingImproved(Competition other) {
		int runningImproved = 0;
		//iterate over the list of competition of the "this" competition
		for(Athlete a : this.athletes) {
			 // For every athlete in the "this" competition, 
			 // compare it to every athlete in the "other" competition
			 // until you find the same athlete.
			for(Athlete b : other.athletes) {				
				if(a.name.equals(b.name)) {					
					if(a.cyclingResult.getCyclingScore() < b.cyclingResult.getCyclingScore())
						runningImproved = runningImproved + 1;
				}
			}
		}
		return runningImproved;
	}
	
	int countCyclingImproved2(Competition other) {
		int runningImproved = 0;
		for(Athlete a : this.athletes) {
			//here we are "sending" the inner for loop 
			//that we have in countCyclingImproved to findAthlete to 
			//do the work for us.
			Athlete b = other.findAthlete(a.name);
			if(a.cyclingResult.getCyclingScore() < b.cyclingResult.getCyclingScore())
				runningImproved = runningImproved + 1;
		}		
		return runningImproved;
	}
	
	//returns the athlete in the competition with the given name
	Athlete findAthlete(String name) {
		for(Athlete a : athletes) {
			if(a.name.equals(name)) {
				return a;
			}
		}
		//when you can't find the athlete in the competition
		return null;
	}
	
	int countCyclingImproved3(Competition other) {
		int runningImproved = 0;
		for(Athlete a : this.athletes) {
			if(a.cyclingResult.getCyclingScore() < other.findAthleteCyclingScore(a.name)) {
				runningImproved = runningImproved + 1;
			}
		}
		return runningImproved;
	}
	
	// this function is responsible for both
	// finding the athlete with the given name and
	// getting to its cycling score to find something
	// to return.
	double findAthleteCyclingScore(String name) {
		for(Athlete a : athletes) {
			if(a.name.equals(name)) {
				return a.cyclingResult.getCyclingScore();
			}
		}
		//didn't find that Athlete!!
		return -1;
	}		
}
