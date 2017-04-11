package roombooking.api.controller

import grails.plugin.json.view.mvc.JsonViewResolver
import grails.test.hibernate.HibernateSpec
import grails.test.mixin.TestFor
import grails.test.mixin.integration.Integration
import grails.transaction.Rollback
import grails.transaction.Transactional
import roombooking.api.Room
import roombooking.api.RoomController

@TestFor(RoomController)
class RoomControllerSpec extends HibernateSpec {

    static doWithSpring = {
        jsonSmartViewResolver(JsonViewResolver)
    }

    def setup() {
        Room.saveAll(
            new Room(name: "STUB-ROOM-1", capacity: 10).save(),
            new Room(name: "STUB-ROOM-2", capacity: 20).save(),
            new Room(name: "STUB-ROOM-3", capacity: 30).save()
        )
    }

    def cleanup() {
    }

    void "Test get all rooms"() {
        when: "Call api get all rooms"
            controller.index(2)

        then: "Get all rooms"
            println response.json.size()
    }
}