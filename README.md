# Run Management API Documentation

## Overview
> This first version 0.1 runs **in memory**. Next versions will use Databases

This is a Spring Boot REST API designed for managing running sessions ("runs"). It allows you to create, retrieve, update, and delete run records. Each run contains details such as its ID, title, start time, completion time, distance in miles, and location type (indoor or outdoor).

## Project Structure
- **Application.java**: Entry point for the Spring Boot application.
- **RunController.java**: REST Controller to define API endpoints for run management.
- **RunRepository.java**: Repository layer for in-memory storage and management of runs.
- **Run.java**: Record class representing the structure of a run.
- **Location.java**: Enum representing possible locations (INDOOR or OUTDOOR).

## Endpoints

### 1. Get All Runs
- **URL**: `/api/runs`
- **Method**: `GET`
- **Description**: Retrieves a list of all recorded runs.
- **Response**: `200 OK`, returns a list of all `Run` objects.

### 2. Get Run by ID
- **URL**: `/api/runs/{id}`
- **Method**: `GET`
- **Description**: Retrieves a specific run by its ID.
- **Path Parameter**:
    - `id` (Integer): Unique identifier of the run.
- **Response**:
    - `200 OK`: Returns the `Run` object.
    - `404 Not Found`: If the run with the specified ID is not found.

### 3. Create a New Run
- **URL**: `/api/runs`
- **Method**: `POST`
- **Description**: Creates a new run record.
- **Request Body**: `Run` object (in JSON format).
- **Response**: `201 Created`

### 4. Update an Existing Run
- **URL**: `/api/runs/{id}`
- **Method**: `PUT`
- **Description**: Updates an existing run with new information.
- **Path Parameter**:
    - `id` (Integer): Unique identifier of the run to update.
- **Request Body**: `Run` object (in JSON format).
- **Response**:
    - `204 No Content`: If the run is successfully updated.
    - `404 Not Found`: If the run with the specified ID is not found.

### 5. Delete a Run
- **URL**: `/api/runs/{id}`
- **Method**: `DELETE`
- **Description**: Deletes a specific run by its ID.
- **Path Parameter**:
    - `id` (Integer): Unique identifier of the run to delete.
- **Response**:
    - `204 No Content`: If the run is successfully deleted.
    - `404 Not Found`: If the run with the specified ID is not found.

## Code Explanation

### `RunController.java`
- **Purpose**: Defines the REST endpoints for managing runs.
- **Constructor**: Accepts an instance of `RunRepository` to interact with the data layer.
- **Endpoints**:
    - `getRuns()`: Retrieves all runs.
    - `findById()`: Finds a specific run by ID or throws a `ResponseStatusException` if not found.
    - `create()`: Adds a new run.
    - `update()`: Updates an existing run by ID.
    - `delete()`: Deletes a run by ID.

### `Run.java`
- **Purpose**: Represents the structure of a run as a record. Contains fields:
    - `id` (Integer): Unique identifier.
    - `title` (String): Title of the run.
    - `startedOn` (LocalDateTime): Start time of the run.
    - `completedOn` (LocalDateTime): Completion time of the run.
    - `miles` (Integer): Distance covered in miles.
    - `location` (Location): Location type (INDOOR or OUTDOOR).

### `RunRepository.java`
- **Purpose**: Acts as an in-memory data store for `Run` objects.
- **Methods**:
    - `findAll()`: Returns all stored runs.
    - `findById()`: Retrieves a run by ID, if present.
    - `create()`: Adds a new run to the list.
    - `update()`: Updates an existing run.
    - `delete()`: Removes a run by ID.
- **`@PostConstruct init()`**: Preloads the repository with sample data.

### `Application.java`
- **Purpose**: Main entry point of the application.
- **CommandLineRunner**: Logs a sample run upon startup, demonstrating run creation.

### `Location.java`
- **Enum**: Defines two possible location types:
    - `INDOOR`
    - `OUTDOOR`

## Usage Example

To create a new run, send a `POST` request to `/api/runs` with JSON body:
```json
{
  "id": 3,
  "title": "Morning Run",
  "startedOn": "2024-11-14T06:00:00",
  "completedOn": "2024-11-14T07:00:00",
  "miles": 6,
  "location": "OUTDOOR"
}