package roombooking.api

class Room {

    String name
    String description
    Integer capacity
    String status = 'active'
    String btnColor = 'bg-light-blue'

    static constraints = {
        name blank: false, nullable: false, unique: true
        capacity nullable: false
        status inList: ['active', 'inactive']
        btnColor blank: false, nullable: false
    }
}
