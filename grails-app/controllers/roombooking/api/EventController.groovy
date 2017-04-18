package roombooking.api


import grails.rest.*

class EventController extends RestfulController {
	static responseFormats = ['json']

    EventController() {
        super(Event)
    }
}
