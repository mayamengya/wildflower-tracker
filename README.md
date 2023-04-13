# Wildflower Tracker

## Track nature's blooms with ease 

**What will the application do?**
- This application will allow users to track the wildflowers 
they spot outdoors by entering the type of wildflower that
was spotted, location and the month it was seen. 
Possible features include the ability to view through the total
different types of wildflowers seen so far, statistics about 
which locations specific types of wildflowers grow at, and when is the best month of 
the year to see certain types of wildflowers.

**Who will use it?**
- This application can be used by a variety of demographics and ages, from 
children tracking wildflowers in local parks, to back country hikers wanting to know
when is the best time to spot alpine flowers in the mountains. Primarily, it will target users
who have an interest in the outdoors and nature. 

**Why is this project of interest to you?** 
- Wildflowers are beautiful to see - but many species (especially in alpine conditions)
only bloom for a short time during the year. With so many beautiful hikes around
BC, I hope that this application can help other wildflower-enthusiasts
better understand the blooming cycles around them, and act as a diary of 
their outdoor adventures! Finally, due to the ramifications of climate change, these blooming 
cycles have been directly impacted over the past few years, with many species 
blooming earlier due to warmer conditions. I hope that this application can also provide 
valuable data on how environments around us is changing.

## User Stories 
- As a user, I want to be able to add and remove a wildflower to my tracking list.
- As a user, I want to be able to check if I have seen a type of wildflower before. 
- As a user, I want to be able to view a list of the different types of wildflowers seen so far.
- As a user, I want to be able to view a list of all the locations a specific wildflower grows.
- As a user, I want to be able to save my wildflower list to file (if I so choose).
- As a user, I want to be able to load my wildflower list to file (if I so choose).

# Instructions for Grader
- You can generate the first required action related to adding Xs to a Y by clicking the button
  labelled "Add".
- You can generate the second required action related to adding Xs to a Y by clicking the button
  labelled "Types".
- You can locate my visual component by looking at the background image, as well as each of the images
  added to the buttons specified in the previous points.
- You can save the state of my application by clicking the button labelled "Save".
- You can reload the state of my application by clicking the button labelled "Load".

# Phase 4: Task 2
A representative sample of the events that occur when this program runs:

Wed Apr 12 22:10:29 PDT 2023
Event log cleared.

Wed Apr 12 22:10:32 PDT 2023
Added wildflower to: My Wildflower List

Wed Apr 12 22:10:34 PDT 2023
Checked all wildflower types seen so far in: My Wildflower List

Wed Apr 12 22:10:37 PDT 2023
Checked all locations of a specific wildflower in: My Wildflower List

Wed Apr 12 22:10:40 PDT 2023
Removed wildflower from: My Wildflower List

# Phase 4: Task 3
Proposed refactoring: 

1. **Refactor for greater cohesion in GUI:**
The current implementation of GUI violates the Single Responsibility Principle, as it is responsible for managing 
the wishlist data, displaying the GUI and handling user input. The GUI class should primarily be responsible for 
presenting information and receiving input from the user. To improve the cohesion of the class, I would create two new 
classes. One would be responsible for managing the persistence of the wishlist data, using the existing JsonReader and 
JsonWriter fields extracted from GUI. The other would be responsible for handling user input and button presses, using 
the various methods that currently exist in GUI. By extracting these responsibilities into separate classes, you can 
improve the cohesion of each class and reduce code duplication, making the code easier to maintain, test and modify 
in the future. Additionally, by separating the concerns of these classes, I can make my code more modular. 
2. **Reducing coupling between GUI and WildflowerList:** Currently, there exists high coupling between the WildflowerList 
class in the model package and the GUI class in the ui package. This can make the code harder to maintain and update. 
If any changes are made to the WildflowerList class, it could potentially break the GUI class and vice versa, which 
can make it challenging to modify or maintain the codebase over time. To address this, I might implement an Observer 
pattern to reduce coupling. In this approach, I would create an interface called "WildflowerListObserver" in the ui 
package, which the GUI class would implement. The WildflowerList class would then include a list of 
WildflowerListObserver objects, which it would notify whenever there is a change in the data. This way, the GUI 
class can register itself as an observer to the WildflowerList class and be notified of changes in the data, without
having to directly access or modify the Wildflower class itself. This can help reduce coupling between the two classes
and make the codebase more modular and maintainable.




