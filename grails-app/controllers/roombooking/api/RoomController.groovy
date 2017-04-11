package roombooking.api


import grails.rest.*
import grails.converters.*

class RoomController extends RestfulController {
    static responseFormats = ['json']
    RoomController() {
        super(Room)
    }
}
