# YetAnotherSnackbar
[![API](https://img.shields.io/badge/API-14%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=14)

Yet Another Snackbar for Kotlin Android Development
This Modules is minimum classes to Snackbar that make writing snackbar easily and more beautiful.

## Screenshots

## Downloads

### Gradle

Add the code below to your **root** `build.gradle` file (`NOT` your module `build.gradle` file, check [here](./build.gradle) for an example).

```groovy
allprojects {
    repositories {
        jcenter()
    }
}
```

Add the code below to your **module**'s `build.gradle` file:

```groovy
dependencies {
	// Other dependencies here.
	implemention 'io.github.amalhanaja:yas:1.0.1'
}
```

### Maven

```xml
<dependency>
  <groupId>io.github.amalhanaja</groupId>
  <artifactId>yas</artifactId>
  <version>1.0.1</version>
  <type>pom</type>
</dependency>
```

## Usage

Each method always returns a `Snackbar` object, so you can customize the Snackbar much more. **DON'T FORGET THE `show()` METHOD!**
To display an error Snackbar:

``` kotlin
YAS.error(yourView, "Error Message").show()
```
To display a success Snackbar:

``` kotlin
YAS.success(yourView, "Error Message").show()
```
To display an info Snackbar:

``` kotlin
YAS.info(yourView, "Error Message").show()
```
To display a warning Snackbar:

``` kotlin
YAS.warning(yourView, "Error Message").show()
```
To display the usual Snackbar:

``` kotlin
YAS.normal(yourView, "Error Message").show()
```

You can also create your custom Snackbars with the `make()` method:
``` kotlin
YAS.make(view, {
            text = "yourMessage"
            color = yourColor
            backgroundColor = Color.rgb(254, 196, 23)
            duration = Snackbar.LENGTH_SHORT
            icon = R.drawable.ic_warning
        }, 
        { 
          text = "ACTION_TEXT"
          color = ACTION_COLOR
          onClick {
            // On Action Clicked
          }
        })
        .show()
```

## LICENSE

    Copyright 2017 The YetAnotherSnackbar authors

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
