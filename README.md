Demo Recording : https://drive.google.com/file/d/1S5OgEjh6_dnJQA7sNK3nE4lV46UalNxy/view?usp=sharing

# YouTube Automation Project

This project automates the YouTube website using Selenium WebDriver to perform various tasks on different tabs (Films, Music, and News) and validate information. The test cases include navigation, assertions, and interactions with elements, including searching for videos and verifying specific attributes.

## Tools Used
- **Java** (Programming language)
- **Selenium WebDriver** (For automating web interactions)
- **TestNG** (For running tests and generating reports)
- **Gradle** (For managing dependencies and building the project)
- **DataProvider** (For parameterized tests and data-driven testing)

## Setup

1. Clone the repository: git clone <repository-url>
2. Navigate to the project directory: cd <project-directory>
3. Install dependencies using Gradle: gradle build
4. Ensure that the necessary WebDriver version is compatible with your browser. Update WebDriverManager if needed.

## Test Cases

### testCase01: Navigate to YouTube and verify the URL
1. Go to YouTube.com.

2. Assert that the URL is correct.

3. Click on the "About" link at the bottom of the sidebar.

4. Print the message from the "About" section.

------------------------------------------------------------------------------------------------------------

### testCase02: Check Films or Movies tab for "Top Selling" section
1. Go to the "Films" or "Movies" tab.

2. Scroll to the extreme right in the “Top Selling” section.

3. Apply a Soft Assert to check if the movie is marked “A” for Mature.
   
4. Apply a Soft Assert to check if the movie category (e.g., "Comedy", "Animation", "Drama") exists.

------------------------------------------------------------------------------------------------------------

### testCase03: Check Music tab and verify playlist details
1. Go to the "Music" tab.

2. Scroll to the extreme right in the first section.

3. Print the name of the playlist.

4. Apply a Soft Assert to check if the number of tracks is less than or equal to 50.

------------------------------------------------------------------------------------------------------------

### testCase04: Check News tab for Latest News Posts
1. Go to the "News" tab.

2. Print the title and body of the first 3 “Latest News Posts”.

3. Calculate and print the sum of the number of likes for the 3 posts (if no likes are given, consider 0).

------------------------------------------------------------------------------------------------------------

### testCase05: Search items from a dataset and scroll until video views reach 10 Crore
1. Retrieve search items from the src/test/resources/data.xlsx file.

2. For each item, search on YouTube.

3. Scroll through the results until the sum of views for all matching videos reaches 10 Crore.

------------------------------------------------------------------------------------------------------------


### Execution
To run the tests, use the following Gradle command: gradle test 

------------------------------------------------------------------------------------------------------------
