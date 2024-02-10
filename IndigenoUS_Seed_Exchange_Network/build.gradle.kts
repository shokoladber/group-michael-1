plugins {
	java
	id("org.springframework.boot") version "3.2.2"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "org.launchcode"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	implementation ("jakarta.persistence:jakarta.persistence-api:3.1.0")
	implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation ("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation ("org.springframework.boot:spring-boot-starter-validation")
	implementation ("org.springframework.boot:spring-boot-starter-web")

	implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation ("mysql:mysql-connector-java")

	developmentOnly ("org.springframework.boot:spring-boot-devtools")
	implementation ("mysql:mysql-connector-java:8.0.28")
	testImplementation ("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jmockit:jmockit:1.49")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
