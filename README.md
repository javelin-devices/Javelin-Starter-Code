# Javelin-Starter-Code-Android
Boiler plate code to get your app up and running with Javelin. This code will take care of connecting to the device and receiving data, so you can dive right into creating a cool application.

## Renaming Your Project and Package 

1. To rename the Starter-Code, make sure your project is not open in Android Studio. Find the project in the file explorer window and right click on it and choose rename. 
2. To rename your package, open your renamed project in Android Studio and go to the project pane on the left-hand side. 
3. There is a dropdown menu next to the project pane selection button that allows you to select the folder structure you would like to view your project in. Choose the Android option. 
4. Right click on the com.javelindevices.javelinstartercode located under app->java and click refractor and then rename. 
5. Select Rename Package, enter the new name and click refractor. If a warning pops up, select rename all. 
6. Open the build.grade (Module: app) under Gradle Scripts and rename the applicationId to your new package name and sync Gradle. 
Note: You can rename the title bar by going to strings under res->values and changing the app_name. 
