package roombooking.api

class Event {

    String title
    String description
    Integer roomId
    Date start
    Date end
    String contactName
    String contactNumber
    String contactEmail

    static constraints = {
        title nullable: false, blank: false
        roomId nullable: false
        start nullable: false
        end nullable: false
    }

    def beforeValidate() {
        if(!Room.exists(this.roomId)) {
            this.errors.reject(
                    'default.not.exist.message',
                    ['roomId', 'Event', roomId] as Object[],
                    'default.not.exist.message'
            )
        }
    }
}
