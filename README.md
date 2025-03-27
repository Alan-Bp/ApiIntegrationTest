# KineduTestApp

## Overview
KineduTestApp is an Android application developed in Kotlin that demonstrates best practices in modern Android development. The project is built using Clean Architecture and the MVVM pattern, with a declarative UI powered by Jetpack Compose. It consumes data from a RESTful API using Retrofit and Gson Converter, and stores data locally using Room for persistence. Dependency injection is managed through Hilt, ensuring a modular, testable, and scalable codebase.

## Features
- **Clean Architecture & MVVM**: Clear separation of concerns for maintainability and ease of testing.
- **Jetpack Compose**: Declarative UI for modern, responsive, and concise user interfaces.
- **Retrofit & Gson**: Simplified API communication and JSON parsing.
- **Room Database**: Local data persistence to support offline capabilities.
- **Hilt Dependency Injection**: Streamlined injection of dependencies across the application.
- **Dynamic Search & Filtering**: Real-time filtering of products by title and description.
- **Seamless Navigation**: Easily navigate between the Home Screen and the Detail Screen using Navigation-Compose.

## Project Structure
├── data │ ├── local │ │ ├── dao │ │ │ └── ArticleDao.kt │ │ ├── database │ │ │ └── AppDatabase.kt │ │ └── model │ │ └── ArticleEntity.kt │ ├── remote │ │ └── ApiService.kt │ └── repository │ ├── ArticleRepository.kt │ └── DBRepository.kt ├── domain │ └── model │ ├── Article.kt │ └── ArticleData.kt ├── presentation │ ├── view │ │ ├── ui │ │ │ ├── HomeScreen.kt │ │ │ ├── DetailScreen.kt │ │ │ ├── ProductCard.kt │ │ │ └── SearchBar.kt │ │ └── navigation │ │ └── NavigationGraph.kt │ └── viewmodel │ ├── HomeViewModel.kt │ └── DetailViewModel.kt └── di └── AppModule.kt
## Technologies Used
- **Kotlin**
- **Jetpack Compose**
- **Retrofit & Gson Converter**
- **Room**
- **Hilt**

## Installation
1. **Clone the repository:**
   ```bash
   git clone https://github.com/Alan-Bp/ApiIntegrationTest
