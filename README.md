# LeftOverChef
## Overview
LeftOverChef is an innovative mobile application designed to combat food waste by helping users, particularly beginner cooks, utilize their leftover ingredients efficiently. By offering personalized recipe suggestions based on the ingredients users have on hand, the app not only promotes sustainable cooking practices but also enhances culinary creativity.

## Features
1. Smart Ingredient Recognition: Users can take photos of their leftover ingredients, and the app uses YOLOv5 machine learning model to recognize and identify these ingredients.
2. Dynamic Recipe Generation: Once ingredients are identified, users receive personalized recipe suggestions that consider their culinary preferences, dietary restrictions, and desired meal complexity.
3. Pantry Management: Allows users to record and track their current stock of ingredients, aiding in planning future grocery purchases and preventing excess buying.
4. Recipe Tracking and Management: Includes Featured, Favorites, and History pages for easy tracking and management of recipes.
5. Dietary Settings: Enables users to customize their dietary preferences and restrictions, including gluten-free, vegan, vegetarian, keto, and low-FODMAP diets.

## Main UI Elements
### Home Page
Acts as the app's central navigation hub, offering a straightforward layout with quick access to main features. 

![image](https://github.com/JithinBathula/LeftOverChef/assets/90094241/e6680f8a-2334-4851-a6bf-dcac31c23f96)
### Ingredient Recognition Page
Allows users to capture or upload photos of ingredients for identification. 

![image](https://github.com/JithinBathula/LeftOverChef/assets/90094241/e451e549-7519-4044-b0c4-5b695c133f22)

### Pantry Page
Enables users to manage their virtual pantry, tracking available ingredients. 

![image](https://github.com/JithinBathula/LeftOverChef/assets/90094241/de5173d7-87ef-4179-8257-1a089611f7f5)

### Preferences Page
Refines recipe suggestions based on additional criteria like cuisine or prep time. 

![image](https://github.com/JithinBathula/LeftOverChef/assets/90094241/4b7fedc8-17c7-492d-b667-52f445dd3600)
### Recipe List Page
Displays suggested recipes based on identified ingredients, with filtering options.

![image](https://github.com/JithinBathula/LeftOverChef/assets/90094241/cbce7afc-473f-4f17-8336-475af4d59bfb)

## Technical Resources
 - OpenAI API: For generating recipe suggestions.
 - YOLOv5: For smart ingredient recognition.
 - Firebase: For backend database management.
 - Google Custom Search API: For fetching related recipe images.

## How to Use LeftOverChef App
### Prerequisites
1. Ensure you have Android Studio installed.
2.  Have a device or emulator running Android 5.0 (Lollipop) or higher.
### Clone the Repository
1.  Open a terminal and run:
`git clone https://github.com/XavierTann/LeftOverChef.git`
2.  Navigate to the project directory:
`cd LeftOverChef`
### Set Up Firebase
1. Firebase Project:

   - Create a Firebase project at Firebase Console.
   - Register your app with the Firebase project.
   - Download the google-services.json file and place it in the app/ directory.
2. Enable Firebase Services:
   - Enable Firestore Database and Authentication in the Firebase console.

### Configure API Keys
1. OpenAI API Key:
   - Obtain an API key from OpenAI.
   - Add the key to your project's environment variables or directly in the code as needed.
2. Google Custom Search API Key:
   - Obtain an API key from Google Developers Console.
   - Add the key to your project's environment variables or directly in the code as needed.

### Build and Run the App
1. Open Project in Android Studio:
   - Launch Android Studio.
   - Open the cloned LeftOverChef project.
2. Sync Gradle:
   - Sync the Gradle files to download all dependencies.
3. Run the App:
   - Connect your Android device or start an emulator.
   - Click on the 'Run' button in Android Studio.
   
## Team Contributions
 - Database and UI: Yu Hueng, Priyanshi Saraogi, Elan
 - Recipe Generation: Xavier Tan Zen
 - Object Detection: Jithin Bathula, Augustine

## Contact
For any inquiries or further information, please feel free to reach out:
  - Project Maintainer: Parth - @JithinBathula

## Citations
 - YouTube Video for ML Model Integration: [Deploy YOLO model in Android](https://www.youtube.com/watch?v=aLgF--7aNNc&t=671s)
 - Roboflow Dataset for Ingredients: [Cairo University](https://universe.roboflow.com/cairo-university-evqqa/food-azc1s)
 - YOLOv5 Google Colab Notebook: [Google Colab](https://colab.research.google.com/drive/1gDZ2xcTOgR39tGGs-EZ6i3RTs16wmzZQ)
 - GitHub Repository for TensorFlow Lite Model Inference: [yyccR/yolov5-tflite-android](https://github.com/yyccR/yolov5-tflite-android/tree/master)
 - AI Debugging: [ChatGPT](https://chatgpt.com/?oai-dm=1)
