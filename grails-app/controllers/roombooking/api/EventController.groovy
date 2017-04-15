package roombooking.api


import grails.rest.*
import grails.converters.*

class EventController extends RestfulController {
	static responseFormats = ['json', 'xml']

    EventController() {
        super(Event)
    }
}
