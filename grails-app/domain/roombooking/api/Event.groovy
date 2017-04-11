package roombooking.api

import grails.rest.Resource

@Resource(uri='/event')
class Event {

    String title
    Integer roomId
    Date start

    static constraints = {
    }
}
