package pl.glownia.maciej.scquiz

// object is a special class that only has one instance. If you create a class with the object
// keyword instead of class, the Kotlin compiler makes the constructor private, creates a static
// reference for the object, and initializes the reference in a static block.
object Constants {

    // consts are compile time constants it means that their value has to be assigned
    // during compile time, unlike vals, where it can be done at runtime.
    // This means, that consts can never be assigned to a function or any class constructor,
    // but only to a String or primitive.

    // Location, under which are the details - can to retrieve them
    // when moving data from one activity to another.
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"
}