package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Class<RichSoilLand> richSoilLandClass = RichSoilLand.class;
		Field[] declaredFields = richSoilLandClass.getDeclaredFields();
		Map<String, List<String>> allModifiers = new LinkedHashMap<>();
		Map<String, List<String>> privateModifiers = new LinkedHashMap<>();
		Map<String, List<String>> protectedModifiers = new LinkedHashMap<>();
		Map<String, List<String>> publicModifiers = new LinkedHashMap<>();
		StringBuilder sb;

		for (Field field : declaredFields) {
			sb = new StringBuilder();
			sb.append(Modifier.toString(field.getModifiers())).append(" ").append(field.getType().getSimpleName()).append(" ").append(field.getName());
			allModifiers.putIfAbsent("all", new LinkedList<>());
			allModifiers.get("all").add(sb.toString());
			if(Modifier.isPrivate(field.getModifiers())) {
				privateModifiers.putIfAbsent("private", new LinkedList<>());
				privateModifiers.get("private").add(sb.toString());
			}else if(Modifier.isProtected(field.getModifiers())) {
				protectedModifiers.putIfAbsent("protected", new LinkedList<>());
				protectedModifiers.get("protected").add(sb.toString());
			} else if(Modifier.isPublic(field.getModifiers())) {
				publicModifiers.putIfAbsent("public", new LinkedList<>());
				publicModifiers.get("public").add(sb.toString());
			}
		}

		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		while (!input.equals("HARVEST")){
			switch (input){
				case "private":
					privateModifiers.get("private").forEach(System.out::println);
					break;
				case "protected":
					protectedModifiers.get("protected").forEach(System.out::println);
					break;
				case "public":
					publicModifiers.get("public").forEach(System.out::println);
					break;
				case "all":
					allModifiers.get("all").forEach(System.out::println);
					break;
			}

			input = scanner.nextLine();
		}

	}
}
