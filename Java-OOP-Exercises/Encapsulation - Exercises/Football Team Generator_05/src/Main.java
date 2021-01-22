import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Team> teams = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split(";");
            String command = tokens[0];
            String teamName = tokens[1];
            switch (command) {
                case "Team":
                    try {
                        Team team = new Team(teamName);
                        if (teams.size() == 0) {
                            teams.add(team);
                        } else {
                            for (Team t : teams) {
                                if (!t.getName().equals(teamName)) {
                                    teams.add(team);
                                    break;
                                }
                            }
                        }
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Add":
                    String playerNameAdd = tokens[2];
                    int endurance = Integer.parseInt(tokens[3]);
                    int sprint = Integer.parseInt(tokens[4]);
                    int dribble = Integer.parseInt(tokens[5]);
                    int passing = Integer.parseInt(tokens[6]);
                    int shooting = Integer.parseInt(tokens[7]);

                    if (!isTeamExist(teamName, teams)) {
                        System.out.printf("Team %s does not exist.%n", teamName);
                    } else {
                        try {
                            Player player = new Player(playerNameAdd, endurance, sprint, dribble, passing, shooting);
                            for (Team t : teams) {
                                if (t.getName().equals(teamName)) {
                                    t.addPlayer(player);
                                    break;
                                }
                            }
                        } catch (IllegalArgumentException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }

                    break;
                case "Remove":
                    String playerName = tokens[2];
                    if (!isTeamExist(teamName, teams)) {
                        System.out.printf("Team %s does not exist.%n", teamName);
                    } else {
                        try {
                            for (Team t : teams) {
                                if (t.getName().equals(teamName)) {
                                    t.removePlayer(playerName);
                                    break;
                                }
                            }
                        } catch (IllegalArgumentException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                    break;
                case "Rating":
                    if (!isTeamExist(teamName, teams)) {
                        System.out.printf("Team %s does not exist.%n", teamName);
                    } else {
                        for (Team team : teams) {
                            if (team.getName().equals(teamName)) {
                                System.out.println(team);
                                break;
                            }
                        }
                    }
                    break;
            }

            input = scanner.nextLine();
        }
    }

    private static boolean isTeamExist(String teamName, List<Team> teams) {
        for (Team team : teams) {
            if (team.getName().equals(teamName)) {
                return true;
            }
        }
        return false;
    }
}
