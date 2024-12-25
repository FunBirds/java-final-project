package uz.itpu.ui;

import uz.itpu.controller.ControllerInterface;
import uz.itpu.controller.CupController;
import uz.itpu.controller.PlateController;
import uz.itpu.controller.SpoonController;
import uz.itpu.controller.user.AdminController;
import uz.itpu.controller.user.UserControllerInterface;
import uz.itpu.entity.Cup;
import uz.itpu.entity.Plate;
import uz.itpu.entity.Spoon;
import uz.itpu.entity.user.Admin;
import uz.itpu.service.user.AdminService;
import uz.itpu.service.user.UserServiceInterface;

import java.util.*;

public class UI {
    // User Controller
    UserServiceInterface<Admin> userServiceInterface = new AdminService();
    UserControllerInterface<Admin> adminController = new AdminController(userServiceInterface);

    // Tableware
    ControllerInterface<Cup> cupController = new CupController();
    ControllerInterface<Spoon> spoonController = new SpoonController();
    ControllerInterface<Plate> plateController = new PlateController();

    public static Map<String, Object> parseCommand(String command) {
        Map<String, Object> result = new HashMap<>();
        String[] parts = command.split(" ");
        result.put("command", parts[0].substring(1));

        List<Map<String, String>> params = new ArrayList<>();
        for (int i = 1; i < parts.length; i += 2) {
            if (parts[i].startsWith("-")) {
                Map<String, String> param = new HashMap<>();
                param.put(parts[i].substring(1), parts[i + 1]);
                params.add(param);
            }
        }
        result.put("params", params);
        return result;
    }

    public static String getParamValue(List<Map<String, String>> params, String key) {
        for (Map<String, String> param : params) {
            if (param.containsKey(key)) {
                return param.get(key);
            }
        }
        return null;
    }

    public static String getParam(String param, String command) {
        Map<String, Object> parsedCommand = parseCommand(command);
        List<Map<String, String>> params = (List<Map<String, String>>) parsedCommand.get("params");
        return getParamValue(params, param);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter command: ");

        while (true) {
            String command = scanner.nextLine();

            String commandScanner = parseCommand(command).get("command").toString();
            if (commandScanner.equals("exit")) {
                break;
            } else if (commandScanner.equals("login")) {
                String role = getParam("r", command);
                String email = getParam("e", command);
                String password = getParam("p", command);
                if (role == null || email == null || password == null) {
                    System.out.println("Please enter all parameters");
                } else {
                    Admin admin = new Admin()
                            .setRole(role)
                            .setEmail(email)
                            .setPassword(password);

                    adminController.login(admin);
                }
            } else if (commandScanner.equals("deluser")) {
                String id = getParam("i", command);
                if (id == null) {
                    System.out.println("Please enter all parameters");
                } else {
                    adminController.deleteUser(Long.parseLong(id));
                }
            } else if (commandScanner.equals("showalluser")) {
                String id = getParam("i", command);
                if (id == null) {
                    adminController.showAllUsers();
                } else {
                    adminController.showUserById(Long.parseLong(id));
                }
            } else if (commandScanner.equals("newadmin")) {
                String name = getParam("n", command);
                String email = getParam("e", command);
                String password = getParam("p", command);
                String role = getParam("r", command);
                if (name == null || email == null || password == null || role == null) {
                    System.out.println("Please enter all parameters");
                } else {
                    Admin admin = new Admin()
                            .setName(name)
                            .setEmail(email)
                            .setPassword(password)
                            .setRole(role);

                    adminController.newAdmin(admin);
                }
            } else if (commandScanner.equals("newtableware")) {
                String typeTableware = getParam("t", command);
                String name = getParam("n", command);
                String material = getParam("m", command);
                String price = getParam("p", command);
                String color = getParam("c", command);
                if (typeTableware == null) {
                    System.out.println("Please enter type of tableware, cup, spoon or plate");
                } else if (name == null || material == null || price == null || color == null) {
                    System.out.println("Please enter all parameters");
                } else if (typeTableware.equals("cup")) {
                    String volume = getParam("v", command);
                    String size = getParam("s", command);
                    if (volume == null || size == null) {
                        System.out.println("Please enter volume and size of cup");
                    } else {
                        Cup cup = new Cup()
                                .setName(name)
                                .setMaterial(material)
                                .setPrice(Integer.parseInt(price))
                                .setColor(color)
                                .setVolume(Integer.parseInt(volume))
                                .setSize(Integer.parseInt(size));
                        cupController.insert(cup);
                    }
                } else if (typeTableware.equals("spoon")) {
                    String length = getParam("l", command);
                    String type = getParam("t", command);
                    if (length == null || type == null) {
                        System.out.println("Please enter length and type of spoon");
                    } else {
                        Spoon spoon = new Spoon()
                                .setName(name)
                                .setMaterial(material)
                                .setPrice(Integer.parseInt(price))
                                .setColor(color)
                                .setLength(Integer.parseInt(length))
                                .setType(type);
                        spoonController.insert(spoon);
                    }

                } else if (typeTableware.equals("plate")) {
                    String diameter = getParam("d", command);
                    if (diameter == null) {
                        System.out.println("Please enter diameter of plate");
                    } else {
                        Plate plate = new Plate()
                                .setName(name)
                                .setMaterial(material)
                                .setPrice(Integer.parseInt(price))
                                .setColor(color)
                                .setDiameter(Integer.parseInt(diameter));
                        plateController.insert(plate);
                    }
                }
            } else if (commandScanner.equals("showalltableware")) {
                String id = getParam("i", command);
                String type = getParam("t", command);
                if (type == null) {
                    System.out.println("Type of Tableware can not be null");
                } else if (id == null) {
                    switch (type) {
                        case "cup" -> cupController.showAll();
                        case "spoon" -> spoonController.showAll();
                        case "plate" -> plateController.showAll();
                    }
                } else {
                    switch (type) {
                        case "cup" -> cupController.showByIndex(Long.parseLong(id));
                        case "spoon" -> spoonController.showByIndex(Long.parseLong(id));
                        case "plate" -> plateController.showByIndex(Long.parseLong(id));
                    }
                }
            } else if (commandScanner.equals("deltableware")) {
                String id = getParam("i", command);
                String type = getParam("t", command);
                if (id == null || type == null) {
                    System.out.println("Please enter all parameters, i and t");
                } else {
                    switch (type) {
                        case "cup" -> cupController.delete(Long.parseLong(id));
                        case "spoon" -> spoonController.delete(Long.parseLong(id));
                        case "plate" -> plateController.delete(Long.parseLong(id));
                        default -> System.out.println("Type of Tableware can not be found");
                    }
                }
            } else if (command.isEmpty()) {
                System.out.println("Command not found, please enter command");
            }
        }
    }
}
