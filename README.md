# RestAssured Framework for Spotify API

This repository contains a RestAssured framework built for automating API tests for the Spotify API. It demonstrates how to implement API testing using Java, TestNG, and Maven. The project includes tests for various Spotify API endpoints, such as authentication, playlists, and tracks.

## Table of Contents
- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
- [Project Structure](#project-structure)
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
    ├── src/
    │   ├── main/
    │   │   └── java/
    │   │       └── base/                # Base classes for API requests
    │   └── test/
    │       ├── java/
    │       │   ├── tests/               # Test classes
    │       │   └── utils/               # Utility functions for test data and config management
    │       └── resources/               # Properties and configuration files
    ├── pom.xml                          # Maven dependencies and build configuration
    ├── testng.xml                       # TestNG suite configuration
    └── README.md                        # Project documentation
```
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
