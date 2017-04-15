package roombooking.api


import grails.rest.*
import grails.converters.*

class EventController extends RestfulController {
	static responseFormats = ['json']

    EventController() {
        super(Event)
    }
}
