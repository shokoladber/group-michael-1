plugins {
	java
	id("org.springframework.boot") version "3.2.2"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "org.launchcode"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = '17'
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'mysql:mysql-connector-java:8.0.32')

}

tasks.withType<Test> {
	useJUnitPlatform()
}

//Unit 2, Class 12 abt 17:00 dependency import tip