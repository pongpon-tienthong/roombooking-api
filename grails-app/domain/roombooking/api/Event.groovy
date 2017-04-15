package roombooking.api

import grails.databinding.BindUsing

class Event {

    String title
    String description

    @BindUsing({ obj, source ->
        [room: [id: source['roomId']]]
    })
    Room room
    Date start
    Date end
    String contactName
    String contactNumber
    String contactEmail


    static constraints = {
    }
}
