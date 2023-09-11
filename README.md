# lab-scheduler
A Lab Reservation Application

**Defining the Problem**

My school has 4 labs: A physics lab, a chemistry lab, a biology lab, and an IT lab. With multiple teachers using them, the labs have to be reserved by the administration on a piece of paper. This often leads to confusion and cancellation problems. Some teachers may also hoard a lab for a long period of time, making it unjust for others. Frustrated by this inefficient lab reservation system, my physics teacher approached me with a request to build an easy-to-use lab reservation app.

**Rationale for solution**

The reason for computerizing the reservation system is to eliminate the various problems associated with reserving labs. With the computerized lab reservation system, teachers will have the ability to reserve labs at their fingertips. They will also be able to cancel reservations without needing to go to the administration. While the physical reservation system requires teachers to remember exactly when they have reserved labs, the digitized version can provide a list of existing reservations and can even send reminders. Finally, the digitized version prevents the hoarding of labs since it will set a limit on the number of labs each teacher can reserve per week.

Having researched different programming languages, I decided to create my solution with Java because it has the following features: 

Java is an object-oriented programming language. This allows for Abstraction, Encapsulation, Polymorphism, and Inheritance.

Java has an abundant Application Programming Interface (API). 

Java is multithreaded. I can perform several tasks simultaneously within a program.

Java is platform-independent. This gives me the ability to run the same program on many different systems.

Java has a great collection of open-source libraries. This can help me code more easily and can save me time.

Java is free. I don’t need to pay anything to create my app.

Java is secure. I won't run into any security issues.

Lastly, Java provides an efficient memory allocation strategy.

**Success Criteria**

Having talked with my client, a successful lab reservation system would need to:

Have a functioning login system.

Give warnings to users whenever they input an incorrect form of data entry.

Make use of a graphical user interface that is easy to follow.

Communicate with an online database that stores all user information, security codes, and existing reservations.

Provide a reservation system for the 4 existing labs in the school; Physics, Chemistry, Biology, and IT lab.

Notify users of their reservations.

Allow users to view, add, delete, and print reservations.

Limit users to reserving 3 labs per week.

**Development**
List of Techniques:
Encapsulation with set and get type methods.
Use of additional libraries.
Use of additional JARs.
Inheritance of classes.
Arrays of two dimensions
Stacks (Abstract Data Types) with error checking and their appropriate methods (push, pop, isEmpty isFull, size)
Writing to a PDF file.
Trying and catching errors.
Parsing DateFormats.
Connection to PHP database from Java (Reading, Writing, Deleting, etc.)
Connection to PHP database from HTML and PHP) (Reading, Writing, Deleting, etc.)
Sending Emails from Java.

Source code can be found in the src folder.

**Evaluation:**

Although my client was satisfied with the application I created, they had a few suggestions:

Ability to view the number of reservations they can still reserve in the same week. This prevents the user from going through the trouble of filling out every reservation input and only then receiving the notification that they have exceeded the maximum amount of reservations in a week.
Link users and security code. The security code currently used to reset passwords is stored in a table in the database, but each time a new security code is generated, the old one gets deleted and the new one takes its place. This, however, isn’t preferable if there is a large number of people using the application. Many people could try to reset their passwords at the same time and won’t be able to do so, because the security code keeps on getting deleted and rewritten. Linking users and security codes would prevent this.
Being able to edit reservations. The current reservation only offers the ability to create, view, and add reservations, and although these were my client’s initial requests, he feels like the ability to edit reservations would be great.
Adding a realistic-looking calendar on the website/application where users can view existing reservations in month/week/day view. This would be complex but its totally doable.
Limit how far into the future the user can create a reservation. The app currently prevents the user from creating a reservation before the current date but anything after is acceptable. A limit of 6 months or 1 year would be preferable.

This lab reservation application turned out to be successful mainly because of the constant communication between my client and me. My client finds the application far simpler, faster, and more organized than the current system. As he says, the app not only “provides a solution to my initial problem”s, but it’s also “the next step in digitalizing our school”.


