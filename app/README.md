# Stoik Cytat Quiz #
---
### Goal ### 
Create an app which let user test their knowledge about popular thoughts of stoics.
Application is in polish language.
This app contains thoughts of 4 stoics:

#####Overview:#####
1. First activity is to welcome user, 
2. Second activity is to let user choose if they want to draw 1, 10 or 40 quotes,
3. Then in next activity user can find question/s based on thoughts and four possible answer 
   to check. Good and bad answer is highlight in different color. If user chosen wrong answer 
   there also good answer will be displayed,
4. This layout also contain progress bar to show user which question actually is 
   and how many is in total,
5. Application requires to check one of answer to go to the next question.
6. At the end there is result activity were trophy is waiting for user. Also there is result 
   of they answers (counted) related to total number of questions.
7. Last option for user is to finish quiz.
8. Quotes I keep in HashMap.

Of course there is space to develop this app for different features.

### To start this app ###
1. Clone this project,
2. Open Android Studio,
3. Select File -> Open... -> choose this project from path where you cloned it,
4. Set Gradle: File -> Settings -> Build, Execution, Deployment -> Gradle
   -> Gradle JDK: set up for 1.8 (if it is necessary),
5. Run the application.

### Requirements: ###
1. Android Studio ArcticFox (2020.3.1) Stable,
2. Minimal Sdk: 21 Recommended: 32.

### What I have learned during this project? ###
1. I should write README.md up to date -> now it is difficult to put everything in nice order
   with more details and also with thoughts which I had in various points during develop this app,
2. How to set up:
   - program buttons to work in different goal,- layouts,
3. How to add:
   - different functionality as drawable, buttons, textViews etc.
4. Important elements and functions, as:
   - make working all buttons and text view,
   - cardView,
   - data class,
   - constants,
   - progress bar,
   - object - special class,
   - setOnClickListener()
   - intent and passing data to next activity,
   - passing and retrieving data via intent  
   - part of collections,
   - null safety,
   
### Summary ###
There are many concepts, more of them I saw first time. They need to repeat to understand it better, 
but I used many lines of comments to write down explanation and to understand, as good as possible, 
what happen in this code, which functions are responsible for, and also why some concepts I should 
use in that case.