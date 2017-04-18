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
        contactEmail email: true
    }

    def beforeValidate() {
        if (!Room.exists(this.roomId)) {
            this.errors.reject(
                    'default.not.exist.message',
                    ['roomId', 'Event', roomId] as Object[],
                    'default.not.exist.message'
            )
        }

        Event existingEvent = where {
            roomId == this.roomId && start < this.end && end > this.start
        }.find()

        if (existingEvent) {
            this.errors.reject(
                    'event.not.available.message',
                    [existingEvent.start, existingEvent.end] as Object[],
                    'event.not.available.message'
            )
        }
    }
}
