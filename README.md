# Java Journal
Sometimes life gets hectic and we find ourselves with too much to keep track of. 
With the Java Journal, never let yours slip away from you!

Enjoy all of the following features for free:

![Screenshot 2023-06-21 233436](https://github.com/CS-3500-OOD/pa05-teamteam/assets/107224274/1de3dfc6-445d-4ee4-8b8a-e771d750d7c5)

Add tasks and events to your week journal, an easy to read, stylish horizontal week view with a customizable theme.

Place limits on the maximum number of events or tasks that you would like per day, and get warned when this limit is exceeded.

![Screenshot 2023-06-21 233548](https://github.com/CS-3500-OOD/pa05-teamteam/assets/107224274/63e88e95-cb22-4846-9c2f-e395ff333a0e)

View all interaction options in an organized, accessible menu bar with keyboard commands built in as shortcuts.

Add quotes or notes to a designated area of your journal for general viewing.

Click on tasks or events to view them in a mini viewer with options for deleting and editing the entry at hand.

![Screenshot 2023-06-21 233615](https://github.com/CS-3500-OOD/pa05-teamteam/assets/107224274/aab6d017-db3d-4f98-9f69-bd81fd06529f)

Create clickable links simply by pasting your http addresses into the description box of your entry.

Deploy your application with the click of a jar file.

Save all of your preferences and events with a few clicks.

Place password locks on your files to ensure that no one but you accesses your private information.

![Screenshot 2023-06-21 233707](https://github.com/CS-3500-OOD/pa05-teamteam/assets/107224274/0f5a8c68-1823-436d-bacd-8e0ffea74aed)

Get a fresh start on a new week by using our weekly starters feature to pass over preferences without the old information.


# SOLID Principles
## Single Responsibility
Our program follows the Single Responsibiliy Principle to the fullest extent. Every single module of the program
is responsible for one task only. The view class is responsible only for interacting with the FX elements and calling dialogue
elements - which themselves are individual, distinct classes each responsible for their respective unique dialogue element - the controller class,
responsible only for monitoring user input and passing the information to the model, the updates of which being reflected in the view,
and even the InputValidator class which is solely responsible for validating whether user input is valid or not. As such,
it is clear that every single module has one and only one reason to change, or performing its own unique assigned task differently.

## Open-Closed Principle
The modules of our program are entirely open for extension but closed for modification. Well defined, intentional methods and constructors
are present for all classes of our program that allow them to be extended in a stable manner without requiring any modification to base code.
Due to this, any sort of coupling that may occur will not be disturbed by extension to the program, which both allowed our program to be stable while
we were extending it to add new features and will allow it to continue to be stable in the future.

## Liskov Substitution
All subclasses within our program are substitutable within eachothers use cases. The only superclass subclass relationship within our program
involving more than one child is between the interface DialogCreator and its children. with each child, it returns a specific optional datatype.
Although the data received will either be lacking or extraneous, substitution does not break the program, and substituting subclasses with eachother
returning the same data type will work properly. Thus, our program is able to use derived classes in place of base casses without modification, 
and thus abides by the Liskov Substitution Principle.

## Interface Segregation Principle
The Interface Segregation Principle states that no client should be forced to use an interface that isn't relevalt to it. Nowhere in our program
is this principle violated. All interfaces are uniquely designed and segregated such that they only contain what is absolutely necessary for program
function. Because of this, no interface method is forced upon a client.

## Dependency Inversion
Our program is heavily built upon the Dependency Inversion Principle. High level classes and low level classes interact via interfaces and intermediary
datatypes such as TaskData, and Week, thus reducing coupling and allowing modifications to be made on both ends without issue. Another
such instance is with our use of the Optional datatype abstracting multiple types of data, allowing class modification to be made without issue.
Because of this, the Dependency Inversion Principle is properly achieved in our program.


# Program Extension
An additional non-implemented feature from above is the Vertical Layout feature. This would be very straightforward to implement. First, a new FXML 
scene would be constructed by quite simply moving the elements of our current horizontal layout via HBoxes within a VBox just like how our current
layout implements VBoxes within an HBox into a vertical fashion though rotating 90 degrees clockwise with respect to the top left corner. Then,
put this file into the resources folder of our program, and then assign some action to an element on the scene, for instance a new menu item. When this menu
item is called, call the scene to load the newly created horizontal scene file and apply the stage to the new scene. Then, set the root of the newly applied 
scene to the external form of the original file through .setRoot(). Then, resetting the week view and then applying all former data to the new view through 
the Week datatype will ensure that the new vertical format is as before in terms of the stored data.

# Attributions
- PNG graphics were generated using the MidJourney generative model. All themes were created by hand.
