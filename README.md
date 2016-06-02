# What is in the repositories

dist : containing the lastest SDK

example : containing an example app integrating the Triber SDK

# How to install

Put triber-sdk-release.aar into app/libs directory (create it if necessary)

Add library dependencies to build.gradle:

```groovy
repositories {
  flatDir {
    dirs 'libs'
  }
}

dependencies {
  compile(name:'triber-sdk-release', ext:'aar')
  compile 'com.android.support:support-v4:23.4.0'
  compile 'com.android.support:appcompat-v7:23.4.0'
  compile 'com.android.support:percent:23.4.0'
  compile 'com.google.android.gms:play-services-maps:8.4.0'
  compile 'com.google.android.gms:play-services-location:8.4.0'
  compile 'com.squareup.picasso:picasso:2.5.2'
  compile 'com.squareup.retrofit2:retrofit:2.0.2'
  compile 'com.squareup.retrofit2:converter-gson:2.0.0'
  compile 'com.sothree.slidinguppanel:library:3.3.0'
}
```

Add keys to your manifest, inside the <application> element

```xml
<meta-data
  android:name="com.google.android.geo.API_KEY"
  android:value="YOUR_API_KEY" />
```

Add a FrameLayout in one of your activities layout, that will contain TriberSdk views:
```xml
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
  android:id="@+id/my_fragment_container"
  android:layout_width="match_parent"
  android:layout_height="match_parent" />
```

Configure the appearance of the SDK views

```java
TriberSdkConfig config = new TriberSdkConfig();
config.themeCompassArrowColor = Color.YELLOW;
// More configuration
```

Initialize the Triber SDK, in your Application using : 

```java
sdk.init(context, apiKey, config);
```

with : 
- context : The application context
- apiKey : The TriberSDK API key
- config : An TriberSdkConfig object, containing the SDK configuration


```java
TriberSdk sdk = TriberSdk.getInstance();
sdk.init(context, "YOUR_API_KEY", config);
```

- Launch SDK when you need to - it will display on the specified layout
```java
sdk.launch(fragmentManager, fragmentContainerId)
```

with :
- fragmentManager : The containing activity/fragment fragment manager 
- fragmentContainerId : The Id of the layout that will contain the Triber fragment (android:id) 

```java
TriberSdk sdk = TriberSdk.getInstance();
sdk.launch(fragmentManager, R.id.my_fragment_container);
```

Done !

# Options
Use these options in the TriberSdkConfig class to personalise the Triber integration in your app

### Welcome Screen
- themeWelcomeScreenLogo : Your logo
- themeWelcomeScreenTriberLogoColor : Welcome screen Tribe logo color (LogoColor.WHITE or LogoColor.BLACK)

### Font color and typeface
- themeTitleTypeface : Titles and item titles font
- themeTitleColor : Titles and item titles color
- themeTextTypeface : Text block font
- themeTextColor : Text block color
- buttonTypeface : Button text font
- themeBackgroundImage : Background image

### Compass
- themeCompassArrowColor : Color of the arrow
- themeDistanceTextColor : Distance to point text color
- themeMeetingPointCompassIcon : Icone on the left of the meetings points list

### Powered by Triber
- themePoweredByTriberTextColor : "Powered bo Triber" text color
- themePoweredByTriberBackgroundColor : "Powered by Triber" background color
- themePoweredByTriberLogoColor : "Powered by Triber" Logo color (LogoColor.WHITE or LogoColor.BLACK)

# Happy Tribin' ! :)