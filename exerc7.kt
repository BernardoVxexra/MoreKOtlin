fun main() {
    val event1 = Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, duration = 0)
    val event2 = Event(title = "Eat breakfast", daypart = Daypart.MORNING, duration = 15)
    val event3 = Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, duration = 30)
    val event4 = Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, duration = 60)
    val event5 = Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, duration = 10)
    val event6 = Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, duration = 45)

    val events = mutableListOf<Event>(event1, event2, event3, event4, event5, event6)
    println(events.toString())

    val shortEvents = events.filter { it.duration < 60 }
    println("Short Events: ${shortEvents.size}.")

    val groupedEvents = events.groupBy { it.daypart }
    groupedEvents.forEach { (daypart, events) ->
    println("$daypart: ${events.size} events")

    println("Last event of the day: ${events.last().title}")
    }

    val durationOfEvent = if (events[0].duration < 60) {
        "short"
    } else {
        "long"
    }
    println("Duration of first event of the day: $durationOfEvent")
}

data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val duration: Int,
)

enum class Daypart {
    MORNING, AFTERNOON, EVENING,
}

/* 

Resultado:
[Event(title=Wake up, description=Time to get up, daypart=MORNING, duration=0), Event(title=Eat breakfast, description=null, daypart=MORNING, duration=15), Event(title=Learn about Kotlin, description=null, daypart=AFTERNOON, duration=30), Event(title=Practice Compose, description=null, daypart=AFTERNOON, duration=60), Event(title=Watch latest DevBytes video, description=null, daypart=AFTERNOON, duration=10), Event(title=Check out latest Android Jetpack library, description=null, daypart=EVENING, duration=45)]
Short Events: 5.
MORNING: 2 events
Last event of the day: Eat breakfast
AFTERNOON: 3 events
Last event of the day: Watch latest DevBytes video
EVENING: 1 events
Last event of the day: Check out latest Android Jetpack library
Duration of first event of the day: short

*/