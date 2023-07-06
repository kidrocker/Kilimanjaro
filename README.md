# Kilimanjaro
The Kilimanjaro application contains two screens namely Home and Favorites. Each of the screens serves a distinct role in showing different coding practices and principles.

## Overview
The application follows the MVVM architecture while closely observing SOLID principles. This makes it easy to implement concerns and implement testing on the application. Below are the main principles used to achieve this:

 - Dependency injection with hilt-dagger
 - Multi-module application with separation for network, database, domain, ui, and components. This  ensures that each part of the application knows only what is necessary making it easy to replace any part of the application.
 - Kotlin Coroutines - Asynchronous movement of data between different layers of the application with null safety and 

## Third-party libraries
The application uses Android official or Kotlin-recommended libraries. However, two essential libraries were used for this application:

 - Retrofit -  The most diverse networking library used by the majority of the internet including Google. The library is in active maintenance making it secure.
 - Raamcosta/Compose Destinations - The navigation component wrapper for compose simplifies navigation for compose and fixes the shortcomings of the rather new navigation component on compose. I personally worked with the developer and used the application to simplify navigation on company-wide apps.

## Sreens
### 1. FavoritesScreen
The launch screen displays a list of locations. This screen is used to showcase the following:

 - *Navigation in compose* Include the root navigation location and also navigates to another screen.
 - *Basic compose class structure* with a variety of widgets and recomposing ui widgets.
 - *DataStore* - Storing and retrieving of data using Android Data Store that can survive restarts.

  **What could be improved**
  - Implementation of Google Maps places API for dynamic location. The timelines and lack of a native Compose solution limited the ability to implement this solution.
  - Better design. I am a sucker for design and I feel that the current design is too basic.
  - Provide navigation via the ViewModel class to eliminate unnecessary logic from the UI class.

### 2. HomeScreen
The main class displays both current weather and five-day forecast. The class is a showcase of the following:
  -  MVVM - The class showcases MVVM architecture, SOLID principles, and clean architecture.
  -  Animations - Subtle animations on the current weather value and five-day list improving user experience and fluidity on the app.
  -  Offline persistence -  Using room database to persist data locally, listening for updates, and updating the UI async.
  -  Positioning of complex compose widget on the UI using the Box widget.
  -  Kotlin Flow Combine - Using coroutine flows to fetch data async. The HomeViewModel combines two flows into the UIState.
  -  Using Retrofit versatility to embed static queries on all network calls.

 **What could improve**
 - The base URL and APPID could be stored in a local file that is excluded from version control. However, for the scope of the project, storing them in build.gradle was sufficient.
 - Error handling -  While the app fails silently on network errors, I could have done better to notify the user on various errors that might occur due network issues or parsing errors.
 - Extensive testing -  Not enough tests were written for the project.
 


## How to run the application
The application was tested on the latest version of android studio. ` Build #AI-222.4459.24.2221.10121639, built on May 12, 2023 ` Testing the application.
