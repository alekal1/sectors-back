package ee.alekal.sectorsback.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

public class AppConstants {
    public static final String API_BASE_PATH = "/api";
    public static final String USER_PATH = API_BASE_PATH + "/user";
    public static final String SECTOR_PATH = API_BASE_PATH + "/sector";

    public static final String SECTOR_NOT_FOUND_EXCEPTION_MSG = "Sector with given id was not founded";
    public static final String USER_NOT_FOUND_EXCEPTION_MSG = "User with given id was not founded";

    public static final List<String> PRIMARY_SECTOR = List.of(
            "Manufacturing",
            "Other",
            "Service"
    );

    public static final Map<String, List<String>> TOP_LEVEL_SECTORS = Map.ofEntries(
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

    public static final Map<String, List<String>> MEDIUM_LEVEL_SECTORS = Map.ofEntries(
            entry("Food and Beverage", List.of(
                    "Bakery",
                    "Beverages",
                    "Fish & fish products",
                    "Meat & meat products",
                    "Milk & dairy products",
                    "Other (Food and Beverage)",
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
                    "Machinery equipment/tools",
                    "Manufacture of machinery",
                    "Maritime",
                    "Metal structures",
                    "Other (Machinery)",
                    "Repair and maintenance service"
            )),
            entry("Metalworking", List.of(
                    "Construction of metal structures",
                    "Houses and building",
                    "Metal products",
                    "Metal works",
                    "Plactic and Rubber"
            )),
            entry("Plastic and Rubber", List.of(
                    "Packaging",
                    "Plastic goods",
                    "Plastic processing technology",
                    "Plastic profiles"
            )),
            entry("Printing", List.of(
                    "Advertising",
                    "Book/Periodicals printing",
                    "Labeling and packaging printing"
            )),
            entry("Textile and Clothing", List.of(
                    "Clothing",
                    "Textile"
            )),
            entry("Wood", List.of(
                    "Other (Wood)",
                    "Wooden building material",
                    "Wooden houses"
            )),
            entry("Information Technology and Telecommunications", List.of(
                    "Data processing, Web portals, E-marketing",
                    "Programming, Consultancy",
                    "Software, Hardware"
            )),
            entry("Transport and Logistics", List.of(
                    "Air",
                    "Rail",
                    "Road",
                    "Water"
            ))
    );

    public static Map<String, List<String>> LOW_LEVEL_SECTORS = Map.ofEntries(
            entry("Maritime", List.of(
                    "Aluminium and steel workboats",
                    "Boat/Yacht building",
                    "Ship repair and conversion"
            )),
            entry("Metal works", List.of(
                    "CNC-machining",
                    "Forgings, Fasteners",
                    "Gas, Plasma, Laser cutting",
                    "MIG, TIG, Aluminium welding"
            )),
            entry("Plastic processing technology", List.of(
                    "Blowing",
                    "Moulding",
                    "Plastics welding and processing"
            ))
    );


}
