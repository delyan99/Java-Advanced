package barracksWars.core;

import barracksWars.core.commands.Command;
import barracksWars.data.UnitRepository;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Runnable;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

	private Repository repository;
	private UnitFactory unitFactory;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
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
				String result = interpretCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException | ExecutionControl.NotImplementedException e) {
				e.printStackTrace();
			}
		}
	}

	private String interpretCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException {
		String result = null;
		commandName = commandName.replaceFirst(String.valueOf(commandName.charAt(0)), String.valueOf(commandName.toUpperCase().charAt(0)));
		try {
			Class<?> clazz = Class.forName("barracksWars.core.commands." + commandName);
			Constructor<?> constructor = clazz.getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class);
			constructor.setAccessible(true);
			Command command = (Command)constructor.newInstance(data, this.repository, this.unitFactory);
			result = command.execute();
		} catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return result;
	}

	private String reportCommand(String[] data) {
		String output = this.repository.getStatistics();
		return output;
	}

	private String addUnitCommand(String[] data) throws ExecutionControl.NotImplementedException {
		String unitType = data[1];
		Unit unitToAdd = this.unitFactory.createUnit(unitType);
		this.repository.addUnit(unitToAdd);
		String output = unitType + " added!";
		return output;
	}
	
	private String fightCommand(String[] data) {
		return "fight";
	}
}
