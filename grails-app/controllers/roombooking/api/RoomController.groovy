package roombooking.api


import grails.rest.*
import grails.converters.*

class RoomController extends RestfulController {
    static responseFormats = ['json']
    RoomController() {
        super(Room)
    }

    @Override
    protected List<Room> listAllResources(Map params) {
        Room.where{
            if (params.status) {
                status == params.status
            }
        }.list(params)
    }
}
