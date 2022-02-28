package gameProj;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Report {
	private final int COL_WIDTH = 15;
	private final String[] COLS = {"Vehicle", "Passenger", "From", "To"};
	private final String fileName = "src/gameProj/report.txt";
	
	public void init() {
		BufferedWriter out = null;
		try {
		    FileWriter fstream = new FileWriter(this.fileName);
		    out = new BufferedWriter(fstream);
		    for (int i = 0; i < COLS.length; i++ ) {
		    	for (int c = 0; c < (COL_WIDTH - COLS[i].length())/2; c++ ) out.write(" ");
		    	out.write(COLS[i]);
		    	for (int c = 0; c < (COL_WIDTH - COLS[i].length())/2; c++ ) out.write(" ");
		    	if (i != COLS.length -1) out.write("|");
		    }
		    out.write("\n");
		    for (int i = 0; i < COLS.length; i++ ) {
		    	for (int c = 0; c < ((COL_WIDTH - COLS[i].length())/2)*2 + COLS[i].length(); c++ ) out.write("-");
		    	if (i != COLS.length -1) out.write("|");
		    }
		    out.write("\n");
		    out.close();
		}

		catch (IOException e) {
		    System.err.println("Error: " + e.getMessage());
		}
	}
	
	public void addVehicleFinish(Vehicle v) {
		BufferedWriter out = null;
		try {
		    FileWriter fstream = new FileWriter(this.fileName, true);
		    out = new BufferedWriter(fstream);
		    for (int i = 0; i < COLS.length; i++ ) {
		    	switch (COLS[i]) {
			    	case "Vehicle": 
			    		out.write(v.toString());
			    		for (int c = 0; c < COL_WIDTH - v.toString().length(); c++ ) out.write(" ");
			    		break;
			    	case "Passenger":
			    		if (v.getPassenger() != null) {
			    			out.write(v.getPassenger().toString());
			    			for (int c = 0; c < COL_WIDTH - v.getPassenger().toString().length(); c++ ) out.write(" ");
			    		} else for (int c = 0; c < COL_WIDTH; c++ ) out.write(" ");
			    		break;
			    	case "From":
			    		out.write(v.getPath().get(0).getEntryJunction().toString());
			    		for (int c = 0; c < COL_WIDTH - v.getPath().get(0).getEntryJunction().toString().length()-1; c++ ) out.write(" ");
			    		break;
			    	case "To":
			    		out.write(v.getPath().get(v.getPath().size()-1).getExitJunction().toString());
			    		for (int c = 0; c < COL_WIDTH - v.getPath().get(v.getPath().size()-1).getExitJunction().toString().length(); c++ ) out.write(" ");
			    		break;
		    	}
		    	if (i != COLS.length -1) out.write("|");
		    }
		    out.write("\n");
		    out.close();
		}

		catch (IOException e) {
		    System.err.println("Error: " + e.getMessage());
		}
	}
}
