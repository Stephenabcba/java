package com.stephenlee.abstractart;

import java.util.ArrayList;
import java.util.Random;

public class Museum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Painting p1 = new Painting("Starry Night");
		Painting p2 = new Painting("Mona Lisa");
		Painting p3 = new Painting("Stickman");
		
		Sculpture s1 = new Sculpture("David");
		Sculpture s2 = new Sculpture("Cupid");
		
		ArrayList<Art> museum = new ArrayList<Art>();
		museum.add(p1);
		museum.add(p2);
		museum.add(p3);
		museum.add(s1);
		museum.add(s2);
		
		Random r = new Random();
		ArrayList<Art> museumCopy = new ArrayList<Art>(museum);
		while (museumCopy.size() > 0) {
			int randIndex = r.nextInt(museumCopy.size());
			Art curPiece = museumCopy.get(randIndex);
			curPiece.viewArt();
			museumCopy.remove(randIndex);
		}
		
		
	}

}
