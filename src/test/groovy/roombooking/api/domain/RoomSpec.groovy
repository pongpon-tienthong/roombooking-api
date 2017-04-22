package roombooking.api.domain

import grails.test.hibernate.HibernateSpec
import grails.test.mixin.TestFor
import roombooking.api.Room

@TestFor(Room)
class RoomSpec extends HibernateSpec {

    void "Test save a room with blank name"() {
        when: "A room is save with a blank name"
            Room room = new Room(name: "")
            room.save()

        then: "There is an error and the data is not saved"
            room.hasErrors()
            room.count() == 0
    }

    void "Test save a room without name"() {
        when: "A room is save without name"
            Room room = new Room()
            room.save()

        then: "There is an error and the data is not saved"
            room.hasErrors()
            room.errors.getFieldError("name")
            room.count() == 0
    }

    void "Test save a room with duplicated name"() {
        when: "A room is save with a duplicated name"
            new Room(name: "SAVED-ROOM", capacity: 10).save()
            Room room = new Room(name: "SAVED-ROOM", capacity: 10)
            room.save()

        then: "There is an error and the data is not saved"
            room.hasErrors()
            room.errors.getFieldError("name")
            room.count() == 1
    }

    void "Test save a room with blank capacity"() {
        when: "A room is save without capacity"
            Room room = new Room(name: "STUB-NAME")
            room.save()

        then: "There is an error and the data is not saved"
            room.hasErrors()
            room.errors.getFieldError('capacity')
            room.count() == 0
    }

    void "Test save a room with a wrong status"() {
        when: "A room is save without capacity"
            Room room = new Room(
                    name: "STUB-NAME",
                    capacity: 10,
                    status: "RANDOM-STATUS"
            )
            room.save()

        then: "There is an error and the data is not saved"
            room.hasErrors()
            room.errors.getFieldError('status')
            room.count() == 0
    }

    void "Test save a room with a wrong color format"() {
        when: "A room is save with a wrong color format"
            Room room = new Room(
                    name: "STUB-NAME",
                    capacity: 10,
                    status: "RANDOM-STATUS",
                    btnColor: "AAAAAA"
            )
            room.save()

        then: "There is an error and the data is not saved"
            room.hasErrors()
            room.errors.getFieldError('btnColor')
            room.count() == 0
    }

    void "Test save a room successfully"() {
        when: "A valid name is saved"
            Room room = new Room(
                    name: "STUB-NAME",
                    description: "STUB-DESC",
                    capacity: 10,
                    btnColor: "#FFFFFF"
            )
            room.save()

        then: "The room is saved successfully"
            Room.count() == 1
            Room savedRoom = Room.first()
            savedRoom.name == "STUB-NAME"
            savedRoom.description == "STUB-DESC"
            savedRoom.capacity == 10
            savedRoom.status == "active"
            savedRoom.btnColor == "#FFFFFF"
    }
}
