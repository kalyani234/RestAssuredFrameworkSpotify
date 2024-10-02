# RestAssured Framework for Spotify API

This repository contains a RestAssured framework built for automating API tests for the Spotify API. It demonstrates how to implement API testing using Java, TestNG, and Maven. The project includes tests for various Spotify API endpoints, such as authentication, playlists, and tracks.

## Table of Contents
- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
- [Project Structure](#project-structure)
- [Description of Each Folder](#description-of-each-folder)
- [Running Tests](#running-tests)
- [Test Cases Covered](#test-cases-covered)
- [Contributing](#contributing)
- [License](#license)

## Project Overview
The **RestAssured Framework for Spotify** is designed to:
- Automate testing of Spotify’s public API.
- Provide test coverage for user authentication, playlist management, track search, and more.
- Use RestAssured for API test implementation and TestNG for test orchestration.

This framework follows best practices for test automation and is scalable for adding new API test cases.

## Technologies Used
- **Java**: Core language for writing test scripts.
- **RestAssured**: Library for automating REST API tests.
- **TestNG**: Testing framework used for test configuration and execution.
- **Maven**: Build automation tool used to manage dependencies and run tests.
- **JSON**: Data format for API requests and responses.
  
## Setup and Installation

### Prerequisites
To run this project, you will need:
- **Java JDK 8+** installed on your machine.
- **Maven** for managing dependencies.
- **Spotify Developer Account**: You need to register on the [Spotify Developer Dashboard](https://developer.spotify.com/dashboard/applications) and get access tokens for API requests.
  
### Installation Steps
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/kalyani234/RestAssuredFrameworkSpotify.git
2. **Navigate to the Project Directory**:
    ```bash
    cd RestAssuredFrameworkSpotify
3. **Install Dependencies: Maven will automatically install all the required dependencies by running the following command**:
    ```bash
    mvn clean install
4. **Spotify API Token Setup**:
 - Generate your Spotify access token from the developer dashboard.
 - Update the token in the config.properties file located in the src/test/resources folder.

## Project Structure

The project follows a standard Maven structure:

# Project Structure

The project follows a standard Maven structure:

# Project Structure

The project follows a standard Maven structure:
```
RestAssuredFrameworkSpotify/
├── .idea                                 # IDE configuration files
├── src                                   # Source code directory
│   ├── main                              # Main application source
│   │   └── java                          # Java source files
│   │       └── org
│   │           └── example
│   │               └── Main.java         # Entry point for the application
│   ├── test                              # Test source code
│   │   └── java                          # Java test files
│   │       └── com
│   │           └── spotify
│   │               └── oauth2
│   │                   ├── api
│   │                   │   ├── applicationApi         # API related classes
│   │                   │   ├── Playlistapi.java      # Playlist API interaction
│   │                   │   ├── RestResource.java     # Base resource for API
│   │                   │   ├── Route.java            # Defines API routes
│   │                   │   ├── SpecBuilder.java      # Builds specifications for tests
│   │                   │   └── StatusCode.java       # Contains HTTP status codes
│   │                   ├── TokenManager.java          # Manages OAuth tokens
│   │                   └── pojo
│   │                       ├── Error.java              # Error response model
│   │                       ├── ExternalUrls.java       # External URL model
│   │                       ├── ExternalUrls__1.java
│   │                       ├── Followers.java          # Followers model
│   │                       ├── InnerError.java         # Inner error details
│   │                       ├── Owner.java              # Owner model
│   │                       ├── Playlist.java           # Playlist model
│   │                       └── Tracks.java             # Tracks model
│   └── tests                            # Test classes
│       ├── BaseTest.java                # Base test class for all tests
│       └── PlaylistsTests.java          # Tests for playlist functionality
│   ├── utils                             # Utility classes
│   │   ├── ConfigLoader.java             # Loads configuration settings
│   │   ├── DataLoader.java               # Loads test data
│   │   ├── FakerUtils.java               # Utility for generating fake data
│   │   └── PropertyUtils.java            # Utility for property management
│   └── resources                         # Resource files
│       ├── allure.properties             # Allure reporting configuration
│       ├── config.properties             # Application configuration
│       └── data.properties               # Test data configuration
├── .gitignore                            # Files and directories to ignore in git
├── README.md                             # Project documentation
├── RestAssuredFrameworkSpotify.iml       # IDE module configuration
└── pom.xml                               # Maven dependencies and build configuration

```
## Description of Each Folder

- **`.idea`**: Contains IDE-specific settings and configurations for the project.

- **`src`**: The primary source code directory, containing both application and test code.
  
  - **`main`**: Contains the main application source files.
  
    - **`java`**: Holds the Java source files for the application.
    
      - **`org/example/Main.java`**: The main entry point for the application, where execution begins.
  
  - **`test`**: Contains test code to validate the application's functionality.
  
    - **`java`**: Holds Java test files.
    
      - **`com/spotify/oauth2`**: Contains classes for testing the Spotify OAuth2 API.
      
        - **`api`**: Houses API-related classes for interacting with the Spotify API.
        
          - **`applicationApi`**: Contains classes that handle API requests.
          
          - **`Playlistapi.java`**: Class to interact with the Playlist API.
          
          - **`RestResource.java`**: Base class for all API interactions.
          
          - **`Route.java`**: Defines the API endpoints.
          
          - **`SpecBuilder.java`**: Builds specifications for API tests.
          
          - **`StatusCode.java`**: Defines HTTP status codes used in API responses.
        
        - **`TokenManager.java`**: Manages the OAuth tokens used for authentication.
        
        - **`pojo`**: Contains Plain Old Java Objects (POJOs) representing API responses.
        
          - **`Error.java`**: Model representing error responses from the API.
          
          - **`ExternalUrls.java`**: Represents external URLs associated with API resources.
          
          - **`ExternalUrls__1.java`**: Additional representation of external URLs.
          
          - **`Followers.java`**: Model for follower data.
          
          - **`InnerError.java`**: Represents detailed error information.
          
          - **`Owner.java`**: Model representing the owner of a resource.
          
          - **`Playlist.java`**: Represents a playlist resource.
          
          - **`Tracks.java`**: Model for track data.
  
  - **`tests`**: Contains individual test classes for various functionalities.
  
    - **`BaseTest.java`**: Base test class that provides common setup and teardown for all tests.
    
    - **`PlaylistsTests.java`**: Contains test cases specifically for validating playlist functionalities.

  - **`utils`**: Contains utility classes that aid in various functionalities.
  
    - **`ConfigLoader.java`**: Loads configuration settings from property files.
    
    - **`DataLoader.java`**: Responsible for loading test data for API tests.
    
    - **`FakerUtils.java`**: Utility for generating fake data for testing purposes.
    
    - **`PropertyUtils.java`**: Manages properties and configurations used in tests.

  - **`resources`**: Contains resource files used by the application and tests.
  
    - **`allure.properties`**: Configuration for Allure reporting.
    
    - **`config.properties`**: Application configuration settings.
    
    - **`data.properties`**: Contains test data configurations.

- **`.gitignore`**: Specifies files and directories that should be ignored by Git.

- **`README.md`**: Documentation for the project, explaining its purpose and usage.

- **`RestAssuredFrameworkSpotify.iml`**: IDE module configuration file.

- **`pom.xml`**: Maven project configuration file that defines dependencies and build settings.

## Running Tests

1. **Run All Tests**:
   To run the complete test suite, use the following command:
   ```bash
   mvn test
2. **Running Specific Test Cases**:
   You can run specific tests using the TestNG XML suite. Edit testng.xml to include the test cases you wish to run.
   ```bash
   mvn -Dtest=ClassName test
3. **Test Reports**:
   TestNG generates test reports in the target/surefire-reports directory. You can open the HTML report in any browser.

## Test Cases Covered
The framework includes automated test cases for the following Spotify API endpoints:

1. **Authentication**:
 - Generate Access Token using OAuth.
2. **User Profile**:
 - Get current user’s profile information.
3. **Playlists**:
 - Create a new playlist.
4. **Add tracks to a playlist**.
 - Get playlist details.
5. **Tracks**:
 - Search for tracks.
 - Get track details.

## Contributing
Feel free to contribute to this project by submitting a pull request. To contribute:

1. Fork this repository.
2. Create a new branch:
   ```bash
   git checkout -b feature/your-feature
3. Commit your changes:
   ```bash
   git commit -m 'Add some feature'
4. Push to the branch:
   ```bash
   git push origin feature/your-feature   
5. Open a pull request

## License
This project is licensed under the MIT License - see the LICENSE file for details.
