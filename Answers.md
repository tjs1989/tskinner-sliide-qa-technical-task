# Tony Skinner Sliide Technical Test

### About Me
A little about me before we hopefully speak soon :)

I am Tony and I love all things to do with mobile testing. UI Automation wise I mostly come from an Appium Java background, and I have done a little Espresso also (about 3 months).
Your app is written in Kotlin so I have decided to run with the flow and write Kotlin for the first time. Hopefully there are not too many faults.

### Issue with your README
I am not sure if it is intentional (good idea for a test if it is) or if this is a legitimate issue. I would therefore like to point out that the username and password for the successful scenario 
which is provided in the README is incorrect. As per the example test which you have provided the credentials should be `user1/password`, as opposed to `password/password`.

### Usage
The tests are located in the classes within the `features` package, which is located at `app/src/androidTest/java/com.test.news/features`

### Framework Setup
Google recommend that you disable device animations when using Espresso. It's something which always stokes the battle between native vs Appium for UI automation.
I believe that the 2 can and in most cases should co-exist hand in hand. This is a topic of conversation which I look forward to having with you if I pass this stage :)

The recommended thing to do by Google is to manually change the relevant 3 settings on the device (see [here](https://developer.android.com/training/testing/espresso/setup#:~:text=Studio%20is%20recommended.-,Set%20up%20your%20test%20environment,Transition%20animation%20scale) for more detail)
The 2 issues with this are that any manual setup is cumbersome and prone to human error. Furthermore what do you do when you can't access the device i.e. when running in a cloud such as Browserstack or Firebase?
To that end we have a rule which disables these animations during the tests, and enables them at the end. This can be found in the `DisableAnimationsRule` class.

I am a big fan of having as many reusable methods to interact with the UI as possible, along with clear readability of the tests. To that end I have made a blend of the Page Object Model and Espresso's power
by having a `UserInterations` class in the `userInteractions` package. It handles the generic things such as entering text into a field. We then simply call this method and pass in the resource ID 
in the test. The end result means that the test looks something like this:

```kotlin   
clearAndEnterTextInField(
              R.id.editTextUserName,
              VALID_USER_NAME
          )
clearAndEnterTextInField(
              R.id.editTextPassword,
              VALID_USER_PASSWORD
          )
tapOnButton(R.id.buttonLogin)
```

I am also a fan of having util methods which help to mimic real user behaviour. For example each user will typically
have a different username and password, so entering random combinations at run time makes this a little more realistic. It's also useful for registration screens where usernames need to be unique.
This is why I have created the `Utils` class in the `utils` package.

Another challenge which Espresso faces is that of waiting for elements to render in a view/on screen. Even with animations turned off we sometimes have a loading spinner whilst waiting for an
API response for example. Espresso is loved for its speed but in this instance it's too fast to check for the element, and the test fails.

Appium and Selenium solve this issue by having driver wait mechanisms (i.e. wait for element by id, css etc until condition x is met) which times out after a specified time. There's no out of the
box solution in Espresso and idling resources are quite memory hungry. I have therefore opted for a custom View Action. It polls for the resource in question using UIAutomator with a specified timeout.
I have added this library into the Gradle build file, and created the class `ViewActions` in the `viewActions`package.

I just wanted to say that I really like the Gradle setup for adding dependencies, it is very well thought out and clean :)

Here are my answers to the tests, along with their associated scenarios.
### 1 - As a user I want to log in to the app - Automated Tests are in the `LoginTests` class

#### Scenario 1 - user opens the android app first time (when not logged in yet)
This scenario feels like an implicit check of the end to end flow of logging into the app for the first time, and seeing the news screen (Scenario 3).
To that end assertions to check that the 3 elements are displayed before actions are conducted have been added to the successful login test (`loginWithValidCredentials`).

This scenario can be covered using automated tests, and we can use a combination of virtual and real devices to assure that it works as expected.
We should understand which Operating System versions are most used by our users, along with the most used devices. This will help us to target our testing a bit more, as opposed to testing blind.
This data would help us to also understand what could be considered a best endeavours set of testing too. For example if only 1% of our users use a small screen size (One Plus 3 size or smaller for example)
then we know that this does not need to be prioritised for each test run.

#### Scenario 2 - user login failed
As Per Scenario 1, I feel that this is best served with UI automation. I couldn't quite target the OS popups with the error messages though :( , so I have left a TODO in the code.
This would be tested manually across different devices to ensure that it works. I'd also expand the scenario to successfully login after we have an initial failure, this is to make sure
that we don't have a dead journey. I have seen this issue many times in the past.

Because it goes through the UIAutomator layer, Appium has some methods out of the box for targeting OS prompts. I know that you need to do a little extra setup in Espresso, but I couldn't quite figure it out. Hopefully you'll be able to show me
when we speak :)

#### Scenario 3 - user login succeed (credentials provided below)
As mentioned in Scenario 1, these 2 have been coupled together. Please therefore refer to the notes in Scenario 1 for the implementation details.

#### Scenario 4 - user opens app next time (when previously logged in)
The app appears to have 2 different behaviours depending on the type of close and open operation. If we soft close and open the app then the state doesn't change. The user is still on the news
screen. If the user hard closes and opens the app then they are logged out.

I was not able to stop and restart the Login activity successfully so I would have to manually test both scenarios in this scenario for now. Appium handles this with out of the box configurations
which allow you to close and reopen the app in a soft or hard manner. I am convinced that this can be automated in Espresso too, but it needs some more tweaking and understanding of the Activity Test Rule.
The Activity Test Rule class is soon to be deprecated by Google as per the Espresso docs, and implementing the Activity Scenario Rule may help solve this challenge. I say this because it appears to have more 
granular control for stopping and starting activities. 


##

### 2 - As a user I want to see my news

#### Scenario 1 - news images are loaded
In a similar ilk to the first test, I feel that scenarios 1 and 3 are an end to end flow. I would therefore test them in the same way under one test, and this can be found in
the `NewsTests` class within the `imagesAreDisplayed` method.

Out of the box Appium has solutions to determine if you have switched out to Chrome after a tap event. I couldn't find such a thing in Espresso and got quite lost when trying to
build a ground up solution. I have therefore left this as a TODO in the code.

Given that the scenario mentioned that multiple images may appear in the same row (they don't in the sample app), and the images are also quite large in size. I would recommend implementing
a scrolling mechanism too. We could generate a random position to scroll down or up to and check that the images work/display as expected. I have been caught out by different screen sizes
many times with similar features so I would recommend a fair bit of manual exploratory testing on this area too. The automation serves as more of an initial sanity check for these types of features.

#### Scenario 2 - failed to load images
This has been a fun one. I say that because Appium also has out of the box features for enabling and disabling Wi-Fi, Mobile Data and Airplane mode.
With Espresso there's a lot of ways which you can do it but given that I had already implemented a rule for device animation disabling, I decided to expand the logic of how this was created.

I moved the UI automator interaction into a separate rule class called `NetworkConnectivityRules`, and from here I then created generic commands to dictate device behaviour.
The tests then call a generic method which invokes the relevant actions i.e. enable and re-enable Wi-Fi and Data.
Kotlin has issues with Before and After class JUnit annotations. From what I could deduce in my search those issues are resolved in JUnit5. This project uses JUnit 4 currently and through fear
of breaking the unit tests, I opted to write this test in Java. Because we are altering the device state we need to have a before and after mechanism to ensure that our tests are clean, and do not
cause any detrimental issues to other tests which may run before or after it.

The scenario mentions that a retry button should be present but I could not find one on the screen or in the code. If it did exist then I would have check that it displays and could be clicked also.
From a manual perspective I'd be testing this scenario on smaller devices to check for word wrapping issues. This is also a common gotcha when translating apps into other languages.

#### Scenario 3 - news image is clicked
This has been covered by what was mentioned in scenario 1.

Please do not hesitate to get in touch if you have any further questions.

I look forward to hearing your reply
Kind Regards
Tony
