package roombooking.api

class BootStrap {

    def init = { servletContext ->
        new Room(
                name: 'Sanctaury Room',
                description: 'The main worship hall',
                capacity: 10,
                status: 'active',
                hexColor: '#444444'
        ).save()
    }
    def destroy = {
    }
}