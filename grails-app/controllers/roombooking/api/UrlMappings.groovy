package roombooking.api

class UrlMappings {

    static mappings = {
        group("/api/v1") {
            delete  "/$controller/$id?" (action:"delete")
            get     "/$controller?"     (action:"index")
            get     "/$controller/$id?" (action:"show")
            post    "/$controller?"     (action:"save")
            put     "/$controller/$id?" (action:"update")
            patch   "/$controller/$id?" (action:"patch")
        }

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
