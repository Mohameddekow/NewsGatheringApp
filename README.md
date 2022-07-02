# NewsGatheringApp
Gather News all over the world

# News Gathering App is
An android app built using [Jetpack Compose](https://developer.android.com/jetpack/compose) that consumes [THE GUARDIAN API](https://open-platform.theguardian.com/documentation) to show news of the day, breaking news, news of different sections in addition you can also search for any news by just typing any keyword(s) 


---
# The Setup 
First, obtain your API key from [GUARDIANS](https://open-platform.theguardian.com/documentation) and add it in a file named `apikey.properties` within the root directory:

```bash
YOUR_API_KEY="****"
```

Then, replace it in the `build.gradle(:app)` :

```bash
...
def apikeyPropertiesFile = rootProject.file("apikey.properties")
def apikeyProperties = new Properties()
apikeyProperties.load(new FileInputStream(apikeyPropertiesFile))
 
android {

  defaultConfig {
     
    // should correspond to key/value pairs inside the file   
    buildConfigField("String", "YOUR_API_KEY", apikeyProperties['YOUR_API_KEY'])
  }
}

```

Finally, rebuild the project for changes to take effect and don't forget to update the references of this key in the `AuthInterceptor.kt` file.
and retrieve the api key like this to pass it to the header of the interceptor

```bash
...
// inside of any of your application's code
val guardiansApiKey = BuildConfig.YOUR_API_KEY,
```



---
# Tech Stack

- [Kotlin](https://kotlinlang.org/) - Kotlin is a programming language that can run on JVM.

- [Jetpack Components](https://developer.android.com/jetpack)
    - [Jetpack Compose](https://developer.android.com/jetpack/compose)- Modern toolkit for building native UI.
    - [Android KTX](https://developer.android.com/kotlin/ktx.html) - Provide concise, idiomatic Kotlin to Jetpack and Android platform APIs.
    - [AndroidX](https://developer.android.com/jetpack/androidx) - Major improvement to the original Android [Support Library](https://developer.android.com/topic/libraries/support-library/index), which is no longer maintained.
    -   [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - Perform actions in response to a change in the lifecycle status of another component, such as activities and fragments.
    - [Room](https://developer.android.com/training/data-storage/room) - Provides an abstraction layer over SQLite used for offline data caching.
    - [Preferences Datastore](https://developer.android.com/topic/libraries/architecture/datastore) - Jetpack DataStore is a data storage solution that allows you to store key-value pairs or typed objects with protocol buffers. DataStore uses Kotlin coroutines and Flow to store data asynchronously, consistently, and transactionally.
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Designed to store and manage UI-related data in a lifecycle conscious way. The ViewModel class allows data to survive configuration changes such as screen rotations.


- [MVVM Architecture](https://developer.android.com/topic/architecture) - A software architecture that removes the tight coupling between components. Most importantly, in this architecture, the children don't have the direct reference to the parent, they only have the reference by observables.
- [Hilt](https://dagger.dev/hilt/) - Hilt provides a standard way to incorporate Dagger dependency injection into an Android application.
- [Accompanist Pager Layout](https://google.github.io/accompanist/) -A library which provides paging layouts for Jetpack Compose. If you've used Android's ViewPager before, it has similar properties.
- [Accompanist HorizontalPager](https://google.github.io/accompanist/pager/) - is a layout which lays out items in a horizontal row, and allows the user to horizontally swipe between pages.
- [Accompanist - System UI Controller](https://github.com/google/accompanist/blob/main/systemuicontroller) - A library that provides easy-to-use utilities for recoloring the Android system bars from Jetpack Compose.
- [CoilImage Loader](https://coil-kt.github.io/coil/getting_started/) - Coil is a Jetpack Compose image loading library which fetches and displays network images.
- [Retrofit](https://square.github.io/retrofit/) - Type-safe http client 
and supports coroutines out of the box.
- [GSON](https://github.com/square/gson) - JSON Parser,used to parse 
requests on the data layer for Entities and understands Kotlin non-nullable 
and default parameters.
- [OkHttp Logging Interceptor](https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor/README.md) - Logs HTTP request and response data.
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Library Support for coroutines.
- [Flows](https://developer.android.com/kotlin/flow) - Flows are built on top of coroutines and can provide multiple values. A flow is conceptually a stream of data that can be computed asynchronously.
- Shimmer loading effect to display as the data is loaded from the `guardians api`

---
# Screenshots
