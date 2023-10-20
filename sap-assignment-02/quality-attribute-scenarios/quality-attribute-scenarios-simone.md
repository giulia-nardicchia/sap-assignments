# Quality Attribute Scenarios

## Basic examples of formatted QA:
**Feature**:`[name]`
- **when** `[what stimulus/event]`
- **caused by** `[what source]`
- **occur(s) in** `[what artifact]`
- **operating in** `[what situation/environment]`
- **then** `[what response]`
- **so that** `[response measure]`

# E-scooter Embedded System

##  -- Availability --

### High Availability of E-Scooter Internet Connection
**Feature**: High connection availability for an e-scooter
- **When**: Anything that requires an internet connection
- **Caused by**: E-scooter embedded system disconnection
- **Occur(s) in**: E-scooter embedded system
- **Operating in**: Any network condition within the town
- **Then**: The system quickly reconnects to the network
- **So that**: The connection availability is `greater than 95%`.

---

## -- Energy Efficiency --

### Optimal Battery Usage for E-scooters
**Feature**: Battery management for e-scooters
- **When**: An e-scooter is in use or idle
- **Caused by**: System monitoring
- **Occur(s) in**: E-scooter hardware
- **Operating in**: All weather conditions
- **Then**: The system optimizes power consumption
- **So that**: Average battery life is extended by `20%`.

---

# QA Scenarios - E-Scooter Service System

## User Side Action

## -- Availability --

### High Availability of Scooter Data
**Feature**: Searching for the nearest e-scooter available on the map
- **When**: A user searches for the nearest e-scooter
- **Caused by**: User action
- **Occur(s) in**: User mobile app
- **Operating in**: Peak usage times
- **Then**: The system provides accurate and available data
- **So that**: No more than `0.01%` of requests fail to return an available e-scooter.

---

## -- Performance --

### Response Time Of Scooter Location
**Feature**: Using an e-scooter found anywhere on the map
- **When**: A user opens the app to find an available e-scooter
- **Caused by**: User action
- **Occur(s) in**: User mobile app
- **Operating in**: Any network condition within the town
- **Then**: The system quickly locates and displays available e-scooters in real-time
- **So that**: The user sees the nearest available e-scooters within `2 seconds`.

### Speed In Tracking History
**Feature**: Tracking usage of the service (history, etc.)
- **When**: A user requests to view their ride history
- **Caused by**: User action
- **Occur(s) in**: User mobile app
- **Operating in**: Normal operating conditions
- **Then**: The system fetches and displays the user's ride history
- **So that**: The user can view their history within `2 seconds`.

---

## -- Reliability --

### Booking Reliability
**Feature**: Booking an e-scooter
- **When**: A user tries to book an e-scooter
- **Caused by**: User action
- **Occur(s) in**: User mobile app
- **Operating in**: Any network condition within the town
- **Then**: The system reserves the e-scooter and confirms the booking
- **So that**: `99.9%` of bookings are successfully confirmed within `1 second`.
-
#### Concurrent E-Scooter Booking
**Feature**: Concurrent e-scooter booking
- **When**: Multiple users try to book the same e-scooter
- **Caused by**: > 1 user
- **Occur(s) in**: Booking management system
- **Operating in**: Normal condition
- **Then**: The system only allows a single booking event to happen, rejecting the others
- **So that**: A single e-scooter is only booked by one person.

---

## -- Usability --

### Intuitive UI Design
**Feature**: User interface of the mobile app
- **When**: A user interacts with the app for the first time
- **Caused by**: User action
- **Occur(s) in**: User mobile app
- **Operating in**: Any device with supported OS
- **Then**: The system provides an intuitive UI that requires minimal learning
- **So that**: Over `95%` of users can perform basic tasks without referring to a user manual.

---

## -- Safety --

### Helmet Detection
**Feature**: Ensuring user safety
- **When**: A user starts a ride
- **Caused by**: User action
- **Occur(s) in**: E-scooter hardware and mobile app
- **Operating in**: All operational conditions
- **Then**: The system verifies helmet usage via sensors or user input
- **So that**: `95%` of rides are started with verified helmet usage.

### Maximum Speed Detection
**Feature**: Ensuring user safety
- **When**: A user rides an e-scooter
- **Caused by**: User action
- **Occur(s) in**: Some designated areas inside town
- **Operating in**: All operational conditions
- **Then**: The e-scooter regulates its maximum speed
- **So that**: It is impossible to go over `5 km/h` in certain zones.

---

## -- Security --

### Payment Authentication
**Feature**: Payment security
- **When**: A user makes a payment
- **Caused by**: User action
- **Occur(s) in**: User mobile app
- **Operating in**: Any network conditions
- **Then**: The system requires payment authentication
- **So that**: Unauthorized payments are reduced by `99,9%`

### Two-factor Authentication
**Feature**: Account security
- **When**: A user logs in
- **Caused by**: User action
- **Occur(s) in**: User mobile app
- **Operating in**: Any network conditions
- **Then**: The system requires two-factor authentication
- **So that**: Unauthorized access is reduced by `99%`.

#### Basic Fraud Security
**Feature**: Basic fraud security
- **When**: A scooter is left parked for 5 minutes
- **Caused by**: The user not terminating the ride
- **Occur(s) in**: Booking management system
- **Operating in**: Normal condition
- **Then**: The ride should be automatically terminated
- **So that**: It is more difficult to steal an e-scooter.

---

## QA Scenarios - E-Scooter Company Side

### Automated User Management
**Feature**: Automating management of the users and rides
- **When**: New user data is added or existing data is updated
- **Caused by**: User action or system event
- **Occur(s) in**: Backend Database
- **Operating in**: Normal operating conditions
- **Then**: The system updates the user and ride information
- **So that**: **99.9%** of updates are processed within 100 milliseconds.

---

### Maintenance Automation Reliability
**Feature**: Automating maintenance of the e-scooters
- **When**: An e-scooter's battery level goes below a threshold
- **Caused by**: System monitoring
- **Occur(s) in**: Backend monitoring system
- **Operating in**: Normal to high e-scooter usage
- **Then**: The system triggers a maintenance task
- **So that**: 99% of maintenance tasks are initiated within 5 minutes of the condition being met.


### Speed Tracking Ride
**Feature**: Tracking usage of the users ride
- **When**: A company employee requests to view the current ride of the users
- **Caused by**: Company employee action
- **Occur(s) in**: Company dashboard
- **Operating in**: Normal operating conditions
- **Then**: The system fetches and displays the user's ride history
- **So that**: The employee can view the requested data within **1 seconds**.

---

## -- Deployability --

### Seamless Updates
**Feature**: System updates
- **When**: New features or patches are rolled out
- **Caused by**: System administrators
- **Occur(s) in**: Backend infrastructure
- **Operating in**: Across all deployment environments
- **Then**: The system can be updated without downtime
- **So that**: `99.9%` of users experience no service interruptions during updates.

---

## -- Testability --

### Modular System Design
**Feature**: Overall system architecture
- **When**: New features or patches are in the development phase
- **Caused by**: Development team
- **Occur(s) in**: Source code
- **Operating in**: Development environment
- **Then**: The system allows for isolated testing of components
- **So that**: `95%` of bugs are discovered and fixed before production.

---

## QA scenarios - shared among ( user side / company side )

## -- Reliability --

### Backup and Recovery
**Feature**: Data protection and recovery
- **When**: A system failure occurs
- **Caused by**: Unplanned incidents or hardware failure
- **Occur(s) in**: Backend database
- **Operating in**: All operational situations
- **Then**: The system automatically switches/restores to a backup on a different server
- **So that**: Recovery On Failure (RoF) is less than `5 minutes`.

---

## -- Integrability --

### API Responsiveness
**Feature**: Third-party services accessing scooter data via API
- **When**: A third-party service fetches scooter location data
- **Caused by**: API request
- **Occur(s) in**: Backend API
- **Operating in**: Normal to high usage
- **Then**: The system returns the requested data
- **So that**: `99%` of API requests are processed within `200 milliseconds`.

---

