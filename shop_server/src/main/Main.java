package main;

import frameAdmin.LoginFrameAdmin;

public class Main
{
	public static void main(String arg[])
	{
		new Thread(new LoginFrameAdmin()).start();
	}
}
