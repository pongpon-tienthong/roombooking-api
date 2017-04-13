package roombooking.api

import grails.rest.Resource

@Resource(uri='/event')
class Event {

    String title
    String description
    Room room
    Date start
    Date end
    String contactName
    String contactNumber
    String contactEmail


    static constraints = {
    }
}
