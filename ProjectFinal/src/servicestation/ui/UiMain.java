package servicestation.ui;

import java.io.IOException;

import servicestation.*;

public class UiMain 
{
	public static void main(String[] args) throws ClassNotFoundException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		ServiceStation.station.loadCustDetails();
		ServiceStation.station.loadBillDetails();
		new Welcome();
	}

}
