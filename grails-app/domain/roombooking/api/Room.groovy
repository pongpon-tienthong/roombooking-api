package roombooking.api

class Room {

    String name
    String description
    Integer capacity
    String status = "active"
    String hexColor = "#777777"

    static constraints = {
        name blank: false, nullable: false, unique: true
        capacity nullable: false
        status inList: ["active", "inactive"]
        hexColor matches: "^#(?:[0-9a-fA-F]{3}){1,2}\$"
    }
}
