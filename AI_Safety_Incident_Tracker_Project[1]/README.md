AI Safety Incident Tracker
Overview
This is an Android application developed as a take-home assignment for the Frontend Intern position at HumanChain. The "AI Safety Incident Tracker" allows users to view a list of AI safety incidents, filter them by severity, view detailed information about each incident, and report new incidents. The app is built using Kotlin and leverages Android Jetpack components (Navigation, View Binding, RecyclerView) and Material Design components for a modern, user-friendly interface.
Features

Incident List: Displays a scrollable list of incidents in a RecyclerView with CardView, showing each incident’s Title, Severity, and Reported Date.
Severity Filtering: Uses a ChipGroup to filter incidents by severity ("All", "Low", "Medium", "High"), with "All" as the default selection.
Incident Details: Tapping an incident navigates to a detail screen displaying the incident’s Title, Severity, Reported Date, and Description.
Report New Incident: A Floating Action Button (FAB) opens a form to report new incidents, with fields for Title, Description, and Severity (via a Spinner). The form includes automatic date setting and validation to ensure non-empty Title and Description fields.
Navigation: Utilizes the Android Navigation Component with Safe Args for seamless and type-safe transitions between screens.
Responsive UI: Implements Material Design components (CardView, FAB, TextInputLayout) for a clean, consistent, and responsive user interface across different screen sizes.

Mock Data
The app includes three predefined incidents stored in-memory:

Incident 1: "Biased Recommendation Algorithm" (Severity: Medium, Date: 2025-03-15T10:00:00Z)
Description: "Algorithm consistently favored certain demographics..."


Incident 2: "LLM Hallucination in Critical Info" (Severity: High, Date: 2025-04-01T14:30:00Z)
Description: "LLM provided incorrect safety procedure information..."


Incident 3: "Minor Data Leak via Chatbot" (Severity: Low, Date: 2025-03-20T09:15:00Z)
Description: "Chatbot inadvertently exposed non-sensitive user metadata..."



Tech Stack

Language: Kotlin
UI Components: View Binding, RecyclerView, CardView, Material Components (ChipGroup, FAB, TextInputLayout, Spinner)
Navigation: Android Navigation Component with Safe Args
Data Storage: In-memory MutableList (no backend or persistent database)
Build System: Gradle 8.1
Minimum SDK: API 24 (Android 7.0 Nougat)
Target SDK: API 34 (Android 14)
Dependencies:
androidx.core:core-ktx:1.12.0
androidx.appcompat:appcompat:1.7.0
com.google.android.material:material:1.12.0
androidx.constraintlayout:constraintlayout:2.1.4
androidx.navigation:navigation-fragment-ktx:2.7.7
androidx.navigation:navigation-ui-ktx:2.7.7
androidx.cardview:cardview:1.0.0
androidx.recyclerview:recyclerview:1.3.2



Setup Instructions
Follow these steps to open and run the project in Android Studio:
Prerequisites

Android Studio: Latest stable version (e.g., Koala or later) installed from developer.android.com/studio.
JDK: Version 8 or higher (Android Studio includes an embedded JDK).
Android SDK: API 24 (Android 7.0 Nougat) and API 34 (Android 14) installed via File > Settings > Appearance & Behavior > System Settings > Android SDK.
A physical Android device (API 24 or higher) or an emulator for testing.

Steps

Unzip the Project:

Extract AISafetyIncidentTracker.zip to a directory (e.g., C:\Projects\AISafetyIncidentTracker on Windows or ~/Projects/AISafetyIncidentTracker on macOS/Linux).


Update local.properties:

Open AISafetyIncidentTracker/local.properties.
Set the sdk.dir to your Android SDK path:sdk.dir=/path/to/your/android-sdk


Example for macOS: sdk.dir=/Users/yourusername/Library/Android/sdk
Example for Windows: sdk.dir=C:\\Users\\yourusername\\AppData\\Local\\Android\\Sdk


Save the file.


Open in Android Studio:

Launch Android Studio and select Open an existing project.
Navigate to the extracted AISafetyIncidentTracker folder and select it.
Android Studio will load the project and recognize the Gradle configuration.


Sync Gradle:

Click Sync Project with Gradle Files (elephant icon or File > Sync Project with Gradle Files).
Android Studio will download dependencies and the Gradle wrapper (gradle-wrapper.jar, gradlew, gradlew.bat) if missing.
If sync fails, ensure you’re online and verify the Android SDK path in local.properties.


Configure a Device or Emulator:

Physical Device:
Connect an Android device (API 24 or higher) via USB.
Enable Developer Options and USB Debugging:
Go to Settings > About Phone > Build Number and tap 7 times.
Go to Settings > Developer Options > USB Debugging and enable it.


Select the device in Android Studio’s Device Manager dropdown.


Emulator:
Open Device Manager (View > Tool Windows > Device Manager).
Click Create Virtual Device, choose a device (e.g., Pixel 6), select a system image for API 24 or higher, and click Finish.
Start the emulator and select it in the Device Manager dropdown.




Build the Project:

Go to Build > Make Project (or press Ctrl+F9 on Windows/Linux, Cmd+F9 on macOS).
Android Studio will compile the Kotlin code and resources.
If build errors occur, check the Build output and ensure all files are present.


Run the App:

Select your device or emulator in the Device Manager dropdown.
Click Run > Run 'app' (or Shift+F10 on Windows/Linux, Ctrl+R on macOS).
The app will install and launch, displaying the incident list screen.


Verify Functionality:

Incident List: Confirm the three mock incidents are displayed.
Filtering: Use the ChipGroup to filter incidents by severity.
Details: Tap an incident to view its details.
Reporting: Click the FAB to report a new incident, ensuring validation works (empty fields trigger a “Please fill all fields” toast).
Check Logcat for any runtime errors.



Design Decisions

Navigation Component with Safe Args: Used for robust navigation and type-safe argument passing, ensuring reliable transitions between fragments (e.g., passing Incident objects to IncidentDetailFragment).
View Binding: Adopted over findViewById for type-safe, null-safe view access, improving code maintainability and reducing runtime errors.
RecyclerView with DiffUtil: Implements efficient list updates with smooth animations when filtering or adding incidents, enhancing performance.
ChipGroup for Filtering: Provides an intuitive, Material Design-compliant way to filter incidents by severity, with “All” as the default for accessibility.
In-Memory Data: Uses a MutableList for simplicity, as no backend or persistent storage was required, with mock data matching the assignment specifications.
Random ID Generation: New incidents receive random IDs (1–10,000) since no backend ensures uniqueness, sufficient for a demo app.
Material Design Components: Leverages CardView, FAB, TextInputLayout, and Spinner for a modern, consistent UI that adapts to various screen sizes.
Input Validation: Ensures non-empty Title and Description fields in the report form, displaying a toast for user feedback.

Challenges

Fragment Communication: Adding new incidents from ReportIncidentFragment to IncidentListFragment required accessing the list fragment. This was solved by finding the IncidentListFragment instance in the fragment manager and calling its addIncident method.
Safe Args Integration: Ensuring IncidentDetailFragmentArgs was generated correctly required applying the androidx.navigation.safeargs.kotlin plugin and defining the incident argument in nav_graph.xml.
Responsive Layout: Used ConstraintLayout and ScrollView to ensure the UI adapts to different screen sizes, particularly for the detail and report screens.
Date Formatting: Implemented SimpleDateFormat to generate ISO 8601 timestamps (e.g., 2025-03-15T10:00:00Z) for new incidents, matching the mock data format.
Gradle Deprecations: Addressed deprecated Gradle features by modernizing plugin management and dependency declarations, ensuring compatibility with Gradle 8.1.

Notes

Data Persistence: The app uses in-memory storage, so new incidents are lost when the app is closed, as per the assignment’s scope.
Project Structure: Organized with separate model and ui packages for clarity and maintainability.
UI Simplicity: The interface prioritizes functionality and usability, adhering to Material Design guidelines while keeping development focused on the assignment requirements.
Gradle Configuration: Updated to avoid deprecated APIs, with dependencies at the latest stable versions as of April 2025 to minimize build issues.

Troubleshooting

Gradle Sync Fails:
Ensure internet connectivity for dependency downloads.
Verify sdk.dir in local.properties points to your Android SDK.
Run ./gradlew build --warning-mode all to diagnose deprecation warnings and share output for further assistance.


Build Errors:
Confirm all files (e.g., nav_graph.xml, fragment_incident_detail.xml) are in the correct paths.
Ensure launcher icons (ic_launcher.png, ic_launcher_round.png) exist in app/src/main/res/mipmap/. Generate them via New > Image Asset if missing.
Check for syntax errors in Kotlin or XML files.


App Crashes:
Use Logcat to identify errors (e.g., NullPointerException, ResourceNotFoundException).
Verify nav_graph.xml defines correct fragment IDs and arguments.
Ensure the Incident class and mock data in IncidentListFragment.kt are unchanged.


Emulator Issues:
Ensure sufficient system resources (RAM, CPU) for the emulator.
Try a different device profile or use a physical device if the emulator is slow.



For persistent issues, consult the Gradle documentation at https://docs.gradle.org/8.1/userguide/command_line_interface.html#sec:command_line_warnings or contact the assignment provider with specific error details.
Thank you for reviewing my submission!
