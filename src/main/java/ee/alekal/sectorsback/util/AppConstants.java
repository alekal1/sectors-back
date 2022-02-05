package ee.alekal.sectorsback.util;

import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class AppConstants {
    public static final String API_BASE_PATH = "/api";
    public static final String USER_PATH = API_BASE_PATH + "/user";
    public static final String SECTOR_PATH = API_BASE_PATH + "/sector";

    public static final String SECTOR_NOT_FOUND_EXCEPTION_MSG = "Sector with given id was not founded";
    public static final String USER_NOT_FOUND_EXCEPTION_MSG = "User with given id was not founded";

    public static final List<String> TOP_LEVEL_SECTORS = List.of(
            "Manufacturing",
            "Other",
            "Service"
    );

    public static final Map<String, List<String>> MEDIUM_LEVEL_SECTORS = Map.ofEntries(
            entry("Manufacturing", List.of(
                    "Construction material",
                    "Electronics and Optics",
                    "Food and Beverage",
                    "Furniture",
                    "Machinery",
                    "Metalworking",
                    "Plastic and Rubber",
                    "Printing",
                    "Textile and Clothing",
                    "Wood"
            )),
            entry("Other", List.of(
                    "Creative industries",
                    "Energy technologies",
                    "Environment"
            )),
            entry("Service", List.of(
                    "Business services",
                    "Engineering",
                    "Information Technology and Telecommunications",
                    "Tourism",
                    "Translation services",
                    "Transport and Logistics"
            ))
    );

    public static final Map<String, List<String>> LOW_LEVEL_SECTORS = Map.ofEntries(
            entry("Food and Beverage", List.of(
                    "Bakery",
                    "Beverages",
                    "Fish & fish products",
                    "Meat & meat products",
                    "Milk & dairy products",
                    "Other",
                    "Sweets & snack food"
            )),
            entry("Furniture", List.of(
                    "Bathroom/sauna",
                    "Bedroom",
                    "Childrenâ€™s room",
                    "Kitchen",
                    "Living room",
                    "Office",
                    "Other (Furniture)",
                    "OutDoor",
                    "Project furniture"
            )),
            entry("Machinery", List.of(
                    "Machinery components",
                    "Maritime"
            ))
    );


}
