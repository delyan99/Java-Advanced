package barracksWars.core;

import barracksWars.interfaces.Runnable;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine implements Runnable {

	CommandInterpreterImp commandInterpreterImp;

	public Engine(CommandInterpreterImp commandInterpreterImp) {
		this.commandInterpreterImp = commandInterpreterImp;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = commandInterpreterImp.interpretCommand(data, commandName).execute();
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
